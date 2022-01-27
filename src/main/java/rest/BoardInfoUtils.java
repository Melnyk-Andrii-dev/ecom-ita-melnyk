package rest;

import rest.dto.CreatedListDto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardInfoUtils {

    static void deleteBoardInfoFromFile(BoardInfo boardInfo) {
        List<BoardInfo> list = new ArrayList<>();
        BoardInfo boardInfoTemp;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/BoardInfo15.dat"))) {
            while ((boardInfoTemp = (BoardInfo) ois.readObject()) != null) {
                list.add(boardInfoTemp);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean wasLast = false;
        if (list.size() == 1) wasLast = true;
        if (list.remove(boardInfo)) {
            File file = new File("data/BoardInfo15.dat");
            if (wasLast) {
                file.delete();
                return;
            }
            if (file.length() != 0) {
                int i = 0;
                for (BoardInfo obj : list) {
                    if (i == 0) {
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/BoardInfo15.dat", false))) {
                            oos.writeObject(obj);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try (MyOutputStream mos = new MyOutputStream(new FileOutputStream("data/BoardInfo15.dat", true))) {
                            mos.writeObject(obj);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    i++;
                }
            }
        }
    }
    static String getIdByNameFromFile(String name){
        Map<String, BoardInfo> boardInfoMap = new HashMap<>();

        BoardInfo boardInfo;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/BoardInfo18-12v2.dat"))) {

            while ((boardInfo = (BoardInfo) ois.readObject()) != null) {
                boardInfoMap.put(boardInfo.getName(), boardInfo);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(boardInfoMap.get(name).getId()!=null){
            BoardInfoUtils.deleteBoardInfoFromFile(boardInfoMap.get(name));
            return boardInfoMap.get(name).getId();
        }
        return null;
    }

    static void wtiteListToFile(CreatedListDto createdListDto, File file){
        if (file.length() == 0) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/BoardInfo18-12v2.dat", true))) {
                oos.writeObject(createdListDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (MyOutputStream mos = new MyOutputStream(new FileOutputStream("data/BoardInfo18-12v2.dat", true))) {
                mos.writeObject(createdListDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package rest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BoardInfoUtils {
    static void deleteBoardInfo(BoardInfo boardInfo) {
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
            if(wasLast) {
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





//                try (MyOutputStream mos = new MyOutputStream(new FileOutputStream("data/BoardInfo12.dat"))) {
//                    for (BoardInfo obj : list) {
//                        mos.writeObject(obj);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}

package rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
public class BoardInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardInfo boardInfo = (BoardInfo) o;
        return id.equals(boardInfo.id) && name.equals(boardInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

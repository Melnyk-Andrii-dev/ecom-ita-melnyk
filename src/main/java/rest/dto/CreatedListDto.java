package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatedListDto {

    private String id;
    private String name;
    private boolean closed;
    private int pos;
    private String softLimit;
    private String idBoard;
    private boolean subscribed;
    private Limits limits;

    @Data
    @AllArgsConstructor
    private class PerBoard{
        private String status;
        private int disableAt;
        private int warnAt;
    }

    @Data
    @AllArgsConstructor
    public class Attachments{
        private PerBoard perBoard;
    }

    @Data
    @AllArgsConstructor
    public class Limits{
        private Attachments attachments;
    }

}

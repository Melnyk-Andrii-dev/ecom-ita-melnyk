package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class CreatedCardDto {

    private String id;
    private String address;
    private Badges badges;
    private List<String> checkItemStates;
    private boolean closed;
    private String coordinates;
    private String creationMethod;
    private Date dateLastActivity;
    private String desc;
    private DescData descData;
    private String due;
    private String dueReminder;
    private String email;
    private String idBoard;
    private List<IdChecklist> idChecklists;
    private List<IdLabel> idLabels;
    private String idList;
    private List<String> idMembers;
    private List<String> idMembersVoted;
    private int idShort;
    private List<String> labels;
    private Limits limits;
    private String locationName;
    private boolean manualCoverAttachment;
    private String name;
    private int pos;
    private String shortLink;
    private String shortUrl;
    private boolean subscribed;
    private String url;
    private Cover cover;

    @Data
    @AllArgsConstructor
    public class Trello{
        private int board;
        private int card;
    }

    @Data
    @AllArgsConstructor
    public class AttachmentsByType{
        private Trello trello;
    }

    @Data
    @AllArgsConstructor
    public class Badges{
        private AttachmentsByType attachmentsByType;
        private boolean location;
        private int votes;
        private boolean viewingMemberVoted;
        private boolean subscribed;
        private String fogbugz;
        private int checkItems;
        private int checkItemsChecked;
        private int comments;
        private int attachments;
        private boolean description;
        private String due;
        private boolean dueComplete;
    }

    @Data
    @AllArgsConstructor
    public class Emoji{
    }

    @Data
    @AllArgsConstructor
    public class DescData{
        private Emoji emoji;
    }

    @Data
    @AllArgsConstructor
    public class IdChecklist{
        private String id;
    }

    @Data
    @AllArgsConstructor
    public class IdLabel{
        private String id;
        private String idBoard;
        private String name;
        private String color;
    }

    @Data
    @AllArgsConstructor
    public class PerBoard{
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

    @Data
    @AllArgsConstructor
    public static class Cover{
        private String color;
        private boolean idUploadedBackground;
        private String size;
        private String brightness;
        private boolean isTemplate;
    }




}

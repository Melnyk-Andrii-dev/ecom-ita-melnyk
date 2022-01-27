package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CardInfoDto {

    private String id;
    private List<Object> checkItemStates;
    private boolean closed;
    private Date dateLastActivity;
    private String desc;
    private DescData descData;
    private Object dueReminder;
    private String idBoard;
    private String idList;
    private List<Object> idMembersVoted;
    private int idShort;
    private Object idAttachmentCover;
    private List<Object> idLabels;
    private boolean manualCoverAttachment;
    private String name;
    private int pos;
    private String shortLink;
    private boolean isTemplate;
    private Object cardRole;
    private boolean dueComplete;
    private Object due;
    private Object email;
    private List<Object> labels;
    private String shortUrl;
    private Object start;
    private String url;
    private Cover cover;
    private List<Object> idMembers;
    private Badges badges;
    private boolean subscribed;
    private List<Object> idChecklists;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Emoji{
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class DescData{
        private Emoji emoji;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Cover{
        private Object idAttachment;
        private String color;
        private Object idUploadedBackground;
        private String size;
        private String brightness;
        private Object idPlugin;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Trello{
        private int board;
        private int card;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static  class AttachmentsByType{
        private Trello trello;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static  class Badges{
        private AttachmentsByType attachmentsByType;
        private boolean location;
        private int votes;
        private boolean viewingMemberVoted;
        private boolean subscribed;
        private String fogbugz;
        private int checkItems;
        private int checkItemsChecked;
        private Object checkItemsEarliestDue;
        private int comments;
        private int attachments;
        private boolean description;
        private Object due;
        private boolean dueComplete;
        private Object start;
    }
    
}

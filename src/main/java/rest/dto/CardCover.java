package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardCover {
    private Cover cover;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Cover {
        private String idAttachment;
        private String color;
        private boolean idUploadedBackground;
        private String size;
        private String brightness;
        private boolean isTemplate;
    }
}

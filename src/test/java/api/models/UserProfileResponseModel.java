package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileResponseModel {

    private Detail resume;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail {
        private String about;
        private EnglishDetails en;

        @Data
        public static class EnglishDetails {
            private String about;
        }
    }
}

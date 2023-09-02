package api_tests.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileBodyModel {
    private Detail resume;

    @Data
    @AllArgsConstructor
    public static class Detail {
        private String about;
        private EnglishDetails en;

        @Data
        @AllArgsConstructor
        public static class EnglishDetails {
            private String about;
        }
    }
}

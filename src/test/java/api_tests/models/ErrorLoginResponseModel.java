package api_tests.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorLoginResponseModel {
    private List<Detail> details;

    @Data
    public static class Detail {
        private String type;
        private String text;
    }
}

package api_tests.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBlogListInFavoriteResponseModel {
    private Integer id;
}
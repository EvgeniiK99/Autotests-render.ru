package api_tests.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeleteBlogFromFavoriteResponseModel {
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("post_id")
    int postId;
    boolean favorite;
}

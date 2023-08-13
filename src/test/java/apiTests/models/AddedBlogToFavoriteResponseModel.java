package apiTests.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddedBlogToFavoriteResponseModel {
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("post_id")
    int postId;
    boolean favorite;
}

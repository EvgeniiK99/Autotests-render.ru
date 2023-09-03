package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlogsResponseModel {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
    private boolean favorite;
}
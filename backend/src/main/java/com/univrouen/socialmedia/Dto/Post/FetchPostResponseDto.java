package com.univrouen.socialmedia.Dto.Post;

import com.univrouen.socialmedia.Dto.AlertAndInfoDto;
import com.univrouen.socialmedia.Entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class FetchPostResponseDto extends AlertAndInfoDto {
    private List<Post> posts;
}

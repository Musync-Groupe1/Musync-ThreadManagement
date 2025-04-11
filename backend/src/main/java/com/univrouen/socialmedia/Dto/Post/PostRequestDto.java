package com.univrouen.socialmedia.Dto.Post;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostRequestDto {
    private String content;
    private Integer userId;
}

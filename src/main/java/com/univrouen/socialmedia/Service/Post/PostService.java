package com.univrouen.socialmedia.Service.Post;

import com.univrouen.socialmedia.Dto.Post.CreatePostRequestDto;
import com.univrouen.socialmedia.Dto.Post.CreatePostResponseDto;

public interface PostService {
    public CreatePostResponseDto createPost(CreatePostRequestDto requestDto);
}

package com.univrouen.socialmedia.Dto.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentPostRequestDto {
    @NotNull
    private Integer post_id;
    @NotBlank
    private String content;
}

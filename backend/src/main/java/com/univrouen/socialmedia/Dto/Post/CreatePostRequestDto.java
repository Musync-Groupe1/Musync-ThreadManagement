package com.univrouen.socialmedia.Dto.Post;

import com.univrouen.socialmedia.Dto.Poll.PollDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequestDto {
    @NotEmpty
    @Size(max = 512)
    private String content;

    private PollDto poll;

}

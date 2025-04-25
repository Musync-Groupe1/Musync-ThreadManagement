package com.univrouen.socialmedia.Dto.Post;

import com.univrouen.socialmedia.Dto.Post.Poll.PollDto;
import com.univrouen.socialmedia.Dto.Post.Quiz.QuizQuestionDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequestDto {
    @NotEmpty
    @Size(max = 512)
    private String content;

    private PollDto poll;

    private List<QuizQuestionDto> quiz;

}

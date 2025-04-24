package com.univrouen.socialmedia.Dto.Post.Quiz;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionDto {
    @NotEmpty
    @Size(max = 50)
    private String question;

    @NotEmpty
    @Size(max = 4)
    List<QuizOptionDto> quiz_options;

}

package com.univrouen.socialmedia.Dto.Post.Quiz;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizOptionDto {
    @NotEmpty
    @Size(max = 50)
    private String option;

    @NotNull
    private Boolean is_correct;

}

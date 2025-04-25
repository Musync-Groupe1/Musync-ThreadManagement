package com.univrouen.socialmedia.Dto.Post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteQuizRequestDto {
    @NotNull
    private Integer post_id;

    @NotNull
    private Integer question_id;

    @NotNull
    private Integer option_id;
}

package com.univrouen.socialmedia.Dto.Post.Poll;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollDto {
    @NotEmpty
    @Size(max = 50)
    private String question;

    @NotEmpty
    private List<PollOptionDto> poll_options;

}

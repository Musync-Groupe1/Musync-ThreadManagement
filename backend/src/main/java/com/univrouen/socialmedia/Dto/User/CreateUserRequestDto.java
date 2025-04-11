package com.univrouen.socialmedia.Dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CreateUserRequestDto {
    private String firstname;
    private String lastname;
    private String email;
}

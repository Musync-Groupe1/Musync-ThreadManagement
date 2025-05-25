package com.univrouen.socialmedia.Dto.Post;

import com.univrouen.socialmedia.Dto.AlertAndInfoDto;
import com.univrouen.socialmedia.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchUsersResponseDto extends AlertAndInfoDto {
    private List<User> users;
}
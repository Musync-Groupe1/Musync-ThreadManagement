package com.univrouen.socialmedia.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertAndInfoDto {
    private String alert;
    private String info;
}

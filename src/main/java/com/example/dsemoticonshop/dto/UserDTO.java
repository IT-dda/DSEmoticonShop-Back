package com.example.dsemoticonshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int user_id;

    private String user_name;

    private String email;

    private boolean hasProfile;
}

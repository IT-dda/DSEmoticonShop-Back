package com.example.dsemoticonshop.dto;

import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {

    private int like_id;

    private User user_id;

    private Emoticon emoticon_id;
}

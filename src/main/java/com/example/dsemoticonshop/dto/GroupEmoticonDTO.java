package com.example.dsemoticonshop.dto;

import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupEmoticonDTO {

    private int id;

    private List<Group> group_id;

    private List<Emoticon> emoticon_id;
}

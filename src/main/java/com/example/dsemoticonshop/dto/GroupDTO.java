package com.example.dsemoticonshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

    private int group_id;

    private String group_name;

    private CategoryDTO category_id;

    private List<GroupEmoticonDTO> group_emoticon;
}

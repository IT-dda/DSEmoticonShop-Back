package com.example.dsemoticonshop.dto;

import com.example.dsemoticonshop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

    private int group_id;

    private String group_name;

    private Category category_id;

}

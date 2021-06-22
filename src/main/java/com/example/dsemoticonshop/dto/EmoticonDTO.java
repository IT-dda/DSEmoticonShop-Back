package com.example.dsemoticonshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmoticonDTO {

    private int emoticon_id;

    private String emoticon_name;

    private int emoticon_price;

    private int sale_price;

    private int quantity;

    private List<Integer> group_id;

    private int creator;

    private LocalDateTime register_date;
}

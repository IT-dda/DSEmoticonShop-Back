package com.example.dsemoticonshop.dto;

import com.example.dsemoticonshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    private User creator;

    private LocalDateTime register_date;
}

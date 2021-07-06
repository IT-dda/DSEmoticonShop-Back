package com.example.dsemoticonshop.dto;

import com.example.dsemoticonshop.entity.Emoticon;
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
public class OrderDTO {

    private int order_id;

    private LocalDateTime order_date;

    private String method;

    private int order_price;

    private Emoticon emoticon_id;

    private User purchaser;

}

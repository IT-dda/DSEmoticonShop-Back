package com.example.dsemoticonshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiftDTO {

    private int gift_id;

    private LocalDateTime order_date;

    private String method;

    private int order_price;

    private int from_id;

    private int to_id;

}

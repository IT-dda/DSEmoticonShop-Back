package com.example.dsemoticonshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private int order_id;

    private Date order_date;

    private String method;

    private int order_price;

    private UserDTO purchaser;

    private boolean isGift;
}

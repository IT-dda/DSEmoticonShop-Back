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
public class CouponDTO {

    private int coupon_id;

    private String coupon_name;

    private Date expired_date;

    private Date used_date;

    private boolean isUsed;

    private int percentage;

    private UserDTO user_id;
}

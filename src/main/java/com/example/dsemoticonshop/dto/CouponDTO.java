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
public class CouponDTO {

    private int coupon_id;

    private String coupon_name;

    private LocalDateTime expired_date;

    private LocalDateTime used_date;

    private boolean isUsed;

    private int percentage;

    private int user_id;
}

package com.example.dsemoticonshop.service.interfaces;

import com.example.dsemoticonshop.dto.CouponDTO;
import com.example.dsemoticonshop.entity.Coupon;

import java.util.List;

public interface CouponService {

    List<CouponDTO> getAllWithId (int id, boolean isUsed);

    default Coupon dtoToEntity(CouponDTO couponDTO) {
        Coupon coupon = Coupon.builder()
                .coupon_id(couponDTO.getCoupon_id())
                .coupon_name(couponDTO.getCoupon_name())
                .expired_date(couponDTO.getExpired_date())
                .used_date(couponDTO.getUsed_date())
                .isUsed(couponDTO.isUsed())
                .percentage(couponDTO.getPercentage())
                .user_id(couponDTO.getUser_id())
                .build();
        return coupon;
    }

    default CouponDTO entityToDTO(Coupon coupon) {
        CouponDTO couponDTO = CouponDTO.builder()
                .coupon_id(coupon.getCoupon_id())
                .coupon_name(coupon.getCoupon_name())
                .expired_date(coupon.getExpired_date())
                .used_date(coupon.getUsed_date())
                .isUsed(coupon.isUsed())
                .percentage(coupon.getPercentage())
                .user_id(coupon.getUser_id())
                .build();
        return couponDTO;
    }
}

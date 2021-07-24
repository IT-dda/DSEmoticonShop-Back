package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.CouponDTO;
import com.example.dsemoticonshop.entity.Coupon;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.CouponRepository;
import com.example.dsemoticonshop.service.interfaces.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public List<CouponDTO> getAllWithId(User user, boolean isUsed) {
        List<Coupon> couponList = couponRepository.getList(user, isUsed);
        return couponList.stream().map(coupon -> entityToDTO(coupon)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void changeStatus(int coupon_id) {
        try {
            Coupon coupon = couponRepository.getById(coupon_id);
            if (coupon.isUsed()) {
                log.info("coupon is already used");
            } else {
                couponRepository.changeStatus(coupon_id);
                log.info("changing coupon status success");
            }
        } catch (EntityNotFoundException e) {
            log.info("wrong coupon number");
        }
    }

}

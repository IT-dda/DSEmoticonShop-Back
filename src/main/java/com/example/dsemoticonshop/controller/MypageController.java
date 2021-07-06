package com.example.dsemoticonshop.controller;


import com.example.dsemoticonshop.dto.*;
import com.example.dsemoticonshop.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/mypage/")
@RequiredArgsConstructor
public class MypageController {

    private final CouponService couponService;
    private final GiftService giftService;
    private final LikeService likeService;
    private final OrderService orderService;

    @GetMapping("/purchase")
    public ResponseEntity<List<OrderDTO>> purchase(int id) {
        log.info("purchase=============================");
        return new ResponseEntity<>(orderService.getAllWithId(id), HttpStatus.OK);
    }

    @GetMapping("/presents/received")
    public ResponseEntity<List<GiftDTO>> presents_received(int id) {
        log.info("presents=============================");
        return new ResponseEntity<>(giftService.getAllWithId(id, true), HttpStatus.OK);
    }

    @GetMapping("/presents/sent")
    public ResponseEntity<List<GiftDTO>> presents_sent(int id) {
        log.info("presents=============================");
        return new ResponseEntity<>(giftService.getAllWithId(id, false), HttpStatus.OK);
    }

    @GetMapping("/coupons")
    public ResponseEntity<List<CouponDTO>> coupons(int id) {
        log.info("coupons=============================");
        return new ResponseEntity<>(couponService.getAllWithId(id, false), HttpStatus.OK);
    }

    @GetMapping("/coupons/used")
    public ResponseEntity<List<CouponDTO>> coupons_used(int id) {
        log.info("coupons=============================");
        return new ResponseEntity<>(couponService.getAllWithId(id, true), HttpStatus.OK);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<LikeDTO>> likes(int id) {
        log.info("likes=============================");
        return new ResponseEntity<>(likeService.getAllWithId(id), HttpStatus.OK);
    }

}

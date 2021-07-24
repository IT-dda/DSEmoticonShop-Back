package com.example.dsemoticonshop.controller;


import com.example.dsemoticonshop.dto.*;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.UserRepository;
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
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final CouponService couponService;
    private final GiftService giftService;
    private final LikeService likeService;
    private final OrderService orderService;

    private final UserRepository userRepository;

    public User getUser(int user_id) {
        return userRepository.getById(user_id);
    }

    @GetMapping("/purchase")
    public ResponseEntity<List<OrderDTO>> purchase(int user_id) {
        return new ResponseEntity<>(orderService.getAllWithId(getUser(user_id)), HttpStatus.OK);
    }

    @GetMapping("/presents/received")
    public ResponseEntity<List<GiftDTO>> presents_received(int user_id) {
        return new ResponseEntity<>(giftService.getAllWithId(getUser(user_id), true), HttpStatus.OK);
    }

    @GetMapping("/presents/sent")
    public ResponseEntity<List<GiftDTO>> presents_sent(int user_id) {
        return new ResponseEntity<>(giftService.getAllWithId(getUser(user_id), false), HttpStatus.OK);
    }

    @GetMapping("/coupons")
    public ResponseEntity<List<CouponDTO>> coupons(int user_id) {
        return new ResponseEntity<>(couponService.getAllWithId(getUser(user_id), false), HttpStatus.OK);
    }

    @GetMapping("/coupons/used")
    public ResponseEntity<List<CouponDTO>> coupons_used(int user_id) {
        return new ResponseEntity<>(couponService.getAllWithId(getUser(user_id), true), HttpStatus.OK);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<LikeDTO>> likes(int user_id) {
        return new ResponseEntity<>(likeService.getAllWithId(getUser(user_id)), HttpStatus.OK);
    }

}

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public User getUser(int id) {
        User user = userRepository.getById(id);
        return user;
    }

    @GetMapping("/purchase")
    public ResponseEntity<List<OrderDTO>> purchase(int id) {
        return new ResponseEntity<>(orderService.getAllWithId(getUser(id)), HttpStatus.OK);
    }

    @GetMapping("/presents/received")
    public ResponseEntity<List<GiftDTO>> presents_received(int id) {
        return new ResponseEntity<>(giftService.getAllWithId(getUser(id), true), HttpStatus.OK);
    }

    @GetMapping("/presents/sent")
    public ResponseEntity<List<GiftDTO>> presents_sent(int id) {
        return new ResponseEntity<>(giftService.getAllWithId(getUser(id), false), HttpStatus.OK);
    }

    @GetMapping("/coupons")
    public ResponseEntity<List<CouponDTO>> coupons(int id) {
        return new ResponseEntity<>(couponService.getAllWithId(getUser(id), false), HttpStatus.OK);
    }

    @GetMapping("/coupons/used")
    public ResponseEntity<List<CouponDTO>> coupons_used(int id) {
        return new ResponseEntity<>(couponService.getAllWithId(getUser(id), true), HttpStatus.OK);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<LikeDTO>> likes(int id) {
        return new ResponseEntity<>(likeService.getAllWithId(getUser(id)), HttpStatus.OK);
    }

    // test change coupon status
//    @PutMapping("/cp")
//    @ResponseBody
//    public HttpStatus coupon_status(int id) {
//        return couponService.changeStatus(id);
//    }

    // test dislike
//    @PutMapping("/dislike")
//    @ResponseBody
//    public HttpStatus dislike(int user_id, int emoticon_id) {
//        User user = userRepository.getById(user_id);
//        Emoticon emoticon = emoticonRepository.getById(emoticon_id);
//        return likeService.dislike(user, emoticon);
//    }

}

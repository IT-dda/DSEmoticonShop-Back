package com.example.dsemoticonshop.controller;

import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.EmoticonRepository;
import com.example.dsemoticonshop.repository.UserRepository;
import com.example.dsemoticonshop.service.interfaces.CouponService;
import com.example.dsemoticonshop.service.interfaces.GiftService;
import com.example.dsemoticonshop.service.interfaces.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class DSController {

    private final GiftService giftService;
    private final CouponService couponService;
    private final LikeService likeService;

    private final UserRepository userRepository;
    private final EmoticonRepository emoticonRepository;

    public HttpStatus changeCouponStatus(int coupon_id) {
        return couponService.changeStatus(coupon_id);
    }

    //  dislike
    @PutMapping("/dislike")
    @ResponseBody
    public HttpStatus dislike(int user_id, int emoticon_id) {
        User user = userRepository.getById(user_id);
        Emoticon emoticon = emoticonRepository.getById(emoticon_id);
        return likeService.dislike(user, emoticon);
    }

    @RequestMapping("/notices")
    public void notices() {
        log.info("========notices===========");
    }

    @RequestMapping("/faq")
    public void faq() {
        log.info("========faq===========");
    }

    @GetMapping("/number")
    public void number() {
        log.info("========number===========");
    }

    @PutMapping("/number")
    @ResponseBody
    public HttpStatus registerGift(int user_id, int gift_id) {
        log.info("========registerGift===========");
        User user = userRepository.getById(user_id);
        return giftService.register(user, gift_id);
    }

    @RequestMapping("/search")
    public void search() {
        log.info("========search===========");
    }
}

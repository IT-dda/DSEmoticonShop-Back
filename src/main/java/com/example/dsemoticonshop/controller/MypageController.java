package com.example.dsemoticonshop.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/mypage/")
public class MypageController {

    @GetMapping("/purchase")
    public void purchase() {
        log.info("purchase=============================");
    }

    @GetMapping("/presents")
    public void presents() {
        log.info("presents=============================");
    }

    @GetMapping("/coupons")
    public void coupons() {
        log.info("coupons=============================");
    }

    @GetMapping("/likes")
    public void likes() {
        log.info("likes=============================");
    }

}

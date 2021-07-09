package com.example.dsemoticonshop.controller;

import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.UserRepository;
import com.example.dsemoticonshop.service.interfaces.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequiredArgsConstructor
public class DSController {

    private final GiftService giftService;

    private final UserRepository userRepository;

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

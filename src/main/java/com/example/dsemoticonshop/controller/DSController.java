package com.example.dsemoticonshop.controller;

import com.example.dsemoticonshop.dto.EmoticonDTO;
import com.example.dsemoticonshop.entity.*;
import com.example.dsemoticonshop.repository.EmoticonRepository;
import com.example.dsemoticonshop.repository.UserRepository;
import com.example.dsemoticonshop.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
public class DSController {

    private final GiftService giftService;
    private final CouponService couponService;
    private final LikeService likeService;
    private final OrderService orderService;
    private final EmoticonService emoticonService;

    private final UserRepository userRepository;
    private final EmoticonRepository emoticonRepository;

    public void changeCouponStatus(int coupon_id) {
        couponService.changeStatus(coupon_id);
    }

    @PostMapping("/like")
    public String like(HttpServletRequest request) {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int emoticon_id = Integer.parseInt(request.getParameter("emoticon_id"));
        Optional<User> user = userRepository.findById(user_id);
        Optional<Emoticon> emoticon = emoticonRepository.findById(emoticon_id);

        if (user.isPresent() && emoticon.isPresent()) {
            Like like = new Like();
            like.setUser_id(user.get());
            like.setEmoticon_id(emoticon.get());
            likeService.like(like);
        } else {
            log.info("wrong parameter");
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @DeleteMapping("/dislike")
    public String dislike(HttpServletRequest request) {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int emoticon_id = Integer.parseInt(request.getParameter("emoticon_id"));
        Optional<User> user = userRepository.findById(user_id);
        Optional<Emoticon> emoticon = emoticonRepository.findById(emoticon_id);

        if (user.isPresent() && emoticon.isPresent()) {
            likeService.dislike(user.get(), emoticon.get());
        } else {
            log.info("wrong parameter");
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/order")
    public String makeOrder(HttpServletRequest request) {
        String method = request.getParameter("method");
        int order_price = Integer.parseInt(request.getParameter("order_price"));
        int emoticon_id = Integer.parseInt(request.getParameter("emoticon_id"));
        int user_id = Integer.parseInt(request.getParameter("purchaser"));
        Optional<Emoticon> emoticon = emoticonRepository.findById(emoticon_id);
        Optional<User> user = userRepository.findById(user_id);

        if (emoticon.isPresent() && user.isPresent()) {
            Order order = new Order();
            order.setOrder_date(LocalDateTime.now());
            order.setMethod(method);
            order.setOrder_price(order_price);
            order.setEmoticon_id(emoticon.get());
            order.setPurchaser(user.get());
            orderService.makeOrder(order);
        } else {
            log.info("wrong parameter");
        }

        String coupon_id = request.getParameter("coupon_id");
        if (coupon_id != null) {
            changeCouponStatus(Integer.parseInt(coupon_id));
        }

        return "redirect:http://localhost:8080";
    }

    @PostMapping("/present")
    public String makePresent(HttpServletRequest request) {
        String method = request.getParameter("method");
        int order_price = Integer.parseInt(request.getParameter("order_price"));
        int emoticon_id = Integer.parseInt(request.getParameter("emoticon_id"));
        int user_id = Integer.parseInt(request.getParameter("purchaser"));
        Optional<Emoticon> emoticon = emoticonRepository.findById(emoticon_id);
        Optional<User> user = userRepository.findById(user_id);

        if (emoticon.isPresent() && user.isPresent()) {
            Gift gift = new Gift();
            gift.setOrder_date(LocalDateTime.now());
            gift.setMethod(method);
            gift.setOrder_price(order_price);
            gift.setEmoticon_id(emoticon.get());
            gift.setFrom_id(user.get());
            gift.setTo_id(null);
            giftService.makeGift(gift);
        } else {
            log.info("wrong parameter");
        }

        String coupon_id = request.getParameter("coupon_id");
        if (coupon_id != null) {
            changeCouponStatus(Integer.parseInt(coupon_id));
        }

        return "redirect:http://localhost:8080";
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
    public String registerGift(int user_id, int gift_id) {
        User user = userRepository.getById(user_id);
        giftService.register(user, gift_id);
        return "redirect:http://localhost:8080";
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmoticonDTO>> search(String q) {
        return new ResponseEntity<>(emoticonService.search(q), HttpStatus.OK);
    }

}

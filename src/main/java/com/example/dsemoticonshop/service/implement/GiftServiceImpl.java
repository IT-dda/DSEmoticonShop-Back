package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.GiftDTO;
import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Gift;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.EmoticonRepository;
import com.example.dsemoticonshop.repository.GiftRepository;
import com.example.dsemoticonshop.repository.OrderRepository;
import com.example.dsemoticonshop.service.interfaces.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

    private final GiftRepository giftRepository;
    private final OrderRepository orderRepository;
    private final EmoticonRepository emoticonRepository;

    @Override
    public List<GiftDTO> getAllWithId(User user, boolean isReceived) {
        List<Gift> giftList;

        if (isReceived) {
            giftList = giftRepository.getReceivedList(user);
        } else {
            giftList = giftRepository.getSentList(user);
        }

        return giftList.stream().map(gift -> entityToDTO(gift)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void makeGift(Gift gift) {
        giftRepository.save(gift);
        Emoticon emoticon = gift.getEmoticon_id();
        emoticonRepository.updateQuantity(emoticon.getEmoticon_id(), emoticon.getQuantity() + 1);
        log.info("gift success");
    }

    @Override
    @Transactional
    public void register(User user, String code) {
        Gift gift = giftRepository.findGiftByCode(code);
        if (gift != null) {
            if (gift.getTo_id() == null) {
                Emoticon emoticon = gift.getEmoticon_id();
                if (orderRepository.findEmoticon(user, emoticon) == 0) {
                    giftRepository.registerGift(user, code);
                    log.info("register gift success");
                } else {
                    log.info("you already have this emoticon");
                }
            } else {
                log.info("this gift is already used");
            }
        } else {
            log.info("wrong gift code");
        }
    }

}

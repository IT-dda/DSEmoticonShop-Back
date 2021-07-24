package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.GiftDTO;
import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Gift;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.GiftRepository;
import com.example.dsemoticonshop.repository.OrderRepository;
import com.example.dsemoticonshop.service.interfaces.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

    private final GiftRepository giftRepository;
    private final OrderRepository orderRepository;

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
    public void makeGift(Gift gift) {
        giftRepository.save(gift);
    }

    @Override
    @Transactional
    public void register(User user, int gift_id) {
        try {
            Gift gift = giftRepository.getById(gift_id);
            if (gift.getTo_id() == null) {
                Emoticon emoticon = gift.getEmoticon_id();
                if (orderRepository.findEmoticon(user, emoticon) == 0) {
                    giftRepository.registerGift(user, gift_id);
                    log.info("register gift success");
                } else {
                    log.info("you already have this emoticon");
                }
            } else {
                log.info("this gift is already used");
            }
        } catch (EntityNotFoundException e) {
            log.info("wrong gift number");
        }
    }

}

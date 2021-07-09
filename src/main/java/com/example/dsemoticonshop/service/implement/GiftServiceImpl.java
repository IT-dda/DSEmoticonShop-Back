package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.GiftDTO;
import com.example.dsemoticonshop.entity.Gift;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.GiftRepository;
import com.example.dsemoticonshop.service.interfaces.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

    private final GiftRepository giftRepository;

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
    public HttpStatus register(User user, int gift_id) {
        if (giftRepository.getById(gift_id).getTo_id() == null) {
            giftRepository.registerGift(user, gift_id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_MODIFIED;
        }
    }
}

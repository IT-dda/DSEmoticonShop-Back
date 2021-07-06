package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.GiftDTO;
import com.example.dsemoticonshop.entity.Gift;
import com.example.dsemoticonshop.repository.GiftRepository;
import com.example.dsemoticonshop.service.interfaces.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

    private final GiftRepository giftRepository;

    @Override
    public List<GiftDTO> getAllWithId(int id, boolean isReceived) {
        List<Gift> giftList;

        if (isReceived) {
            giftList = giftRepository.getReceivedList(id);
        } else {
            giftList = giftRepository.getSentList(id);
        }

        return giftList.stream().map(gift -> entityToDTO(gift)).collect(Collectors.toList());
    }
}

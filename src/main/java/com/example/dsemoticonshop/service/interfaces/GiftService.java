package com.example.dsemoticonshop.service.interfaces;

import com.example.dsemoticonshop.dto.GiftDTO;
import com.example.dsemoticonshop.entity.Gift;
import com.example.dsemoticonshop.entity.User;

import java.util.List;

public interface GiftService {

    List<GiftDTO> getAllWithId(User user, boolean isReceived);

    default Gift dtoToEntity(GiftDTO giftDTO) {
        Gift gift = Gift.builder()
                .gift_id(giftDTO.getGift_id())
                .order_date(giftDTO.getOrder_date())
                .method(giftDTO.getMethod())
                .order_price(giftDTO.getOrder_price())
                .emoticon_id(giftDTO.getEmoticon_id())
                .from_id(giftDTO.getFrom_id())
                .to_id(giftDTO.getTo_id())
                .build();
        return gift;
    }

    default GiftDTO entityToDTO(Gift gift) {
        GiftDTO giftDTO = GiftDTO.builder()
                .gift_id(gift.getGift_id())
                .order_date(gift.getOrder_date())
                .method(gift.getMethod())
                .order_price(gift.getOrder_price())
                .emoticon_id(gift.getEmoticon_id())
                .from_id(gift.getFrom_id())
                .to_id(gift.getTo_id())
                .build();
        return giftDTO;
    }
}

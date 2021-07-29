package com.example.dsemoticonshop.service.interfaces;

import com.example.dsemoticonshop.dto.EmoticonDTO;
import com.example.dsemoticonshop.entity.Emoticon;

import java.util.List;

public interface EmoticonService {

    List<EmoticonDTO> search(String query);

    EmoticonDTO getDetail(int emoticon_id);

    default Emoticon dtoToEntity(EmoticonDTO emoticonDTO) {
        Emoticon emoticon = Emoticon.builder()
                .emoticon_id(emoticonDTO.getEmoticon_id())
                .emoticon_name(emoticonDTO.getEmoticon_name())
                .emoticon_price(emoticonDTO.getEmoticon_price())
                .sale_price(emoticonDTO.getSale_price())
                .quantity(emoticonDTO.getQuantity())
                .creator(emoticonDTO.getCreator())
                .register_date(emoticonDTO.getRegister_date())
                .build();
        return emoticon;
    }

    default EmoticonDTO entityToDTO(Emoticon emoticon) {
        EmoticonDTO emoticonDTO = EmoticonDTO.builder()
                .emoticon_id(emoticon.getEmoticon_id())
                .emoticon_name(emoticon.getEmoticon_name())
                .emoticon_price(emoticon.getEmoticon_price())
                .sale_price(emoticon.getSale_price())
                .quantity(emoticon.getQuantity())
                .creator(emoticon.getCreator())
                .register_date(emoticon.getRegister_date())
                .build();
        return emoticonDTO;
    }
}

package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.EmoticonDTO;
import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.repository.EmoticonRepository;
import com.example.dsemoticonshop.service.interfaces.EmoticonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmoticonServiceImpl implements EmoticonService {

    private final EmoticonRepository emoticonRepository;

    @Override
    public List<EmoticonDTO> search(String query) {
        List<Emoticon> emoticonList = emoticonRepository.search(query);
        return emoticonList.stream().map(emoticon -> entityToDTO(emoticon)).collect(Collectors.toList());
    }

    @Override
    public EmoticonDTO getDetail(int emoticon_id) {
        try {
            Emoticon emoticon = emoticonRepository.getById(emoticon_id);
            return this.entityToDTO(emoticon);
        } catch (EntityNotFoundException e) {
            log.info("emoticon does not exists");
            return null;
        }
    }

}

package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.LikeDTO;
import com.example.dsemoticonshop.entity.Like;
import com.example.dsemoticonshop.repository.LikeRepository;
import com.example.dsemoticonshop.service.interfaces.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public List<LikeDTO> getAllWithId(int id) {
        List<Like> likeList = likeRepository.getList(id);
        return likeList.stream().map(like -> entityToDTO(like)).collect(Collectors.toList());
    }
}

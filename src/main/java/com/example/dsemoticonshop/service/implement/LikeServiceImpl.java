package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.LikeDTO;
import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Like;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.LikeRepository;
import com.example.dsemoticonshop.service.interfaces.LikeService;
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
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public List<LikeDTO> getAllWithId(User user) {
        List<Like> likeList = likeRepository.getList(user);
        return likeList.stream().map(like -> entityToDTO(like)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HttpStatus dislike(User user, Emoticon emoticon) {
        likeRepository.dislike(user, emoticon);
        return HttpStatus.OK;
    }
}

package com.example.dsemoticonshop.service.interfaces;

import com.example.dsemoticonshop.dto.LikeDTO;
import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Like;
import com.example.dsemoticonshop.entity.User;

import java.util.List;

public interface LikeService {

    List<LikeDTO> getAllWithId(User user);
    void like(Like like);
    void dislike(User user, Emoticon emoticon);

    default Like dtoToEntity(LikeDTO likeDTO) {
        Like like = Like.builder()
                .like_id(likeDTO.getLike_id())
                .user_id(likeDTO.getUser_id())
                .emoticon_id(likeDTO.getEmoticon_id())
                .build();
        return like;
    }

    default LikeDTO entityToDTO(Like like) {
        LikeDTO likeDTO = LikeDTO.builder()
                .like_id(like.getLike_id())
                .user_id(like.getUser_id())
                .emoticon_id(like.getEmoticon_id())
                .build();
        return likeDTO;
    }
}

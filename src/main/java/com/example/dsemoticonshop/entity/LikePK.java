package com.example.dsemoticonshop.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class LikePK implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user_id;

    private Emoticon emoticon_id;
}

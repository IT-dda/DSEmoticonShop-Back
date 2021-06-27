package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "liked")
@IdClass(LikePK.class)
public class Like implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user_id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Emoticon emoticon_id;

}

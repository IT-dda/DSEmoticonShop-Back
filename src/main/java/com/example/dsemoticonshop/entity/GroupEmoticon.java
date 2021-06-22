package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GroupEmoticon {

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group_id;

    @ManyToOne
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticon_id;

}
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
    @OneToOne
    private Group group_id;

    @ManyToOne
    private Emoticon emoticon_id;

}

package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "grp")
public class Group {

    @Id
    @Column(name = "group_id")
    private int group_id;

    @Column(name = "group_name")
    private String group_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category_id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private List<GroupEmoticon> group_emoticons;
}

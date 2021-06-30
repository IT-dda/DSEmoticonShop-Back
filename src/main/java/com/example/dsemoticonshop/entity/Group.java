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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_id;

    private String group_name;

    @ManyToOne
    private Category category_id;

    @OneToMany
    private List<GroupEmoticon> group_emoticons;
}

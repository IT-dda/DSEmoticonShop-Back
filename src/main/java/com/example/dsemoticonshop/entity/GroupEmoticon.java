package com.example.dsemoticonshop.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "group_emoticon")
public class GroupEmoticon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_EMOTICON_SEQ")
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticon_id;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}

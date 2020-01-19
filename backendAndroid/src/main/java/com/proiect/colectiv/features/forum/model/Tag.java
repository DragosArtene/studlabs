package com.proiect.colectiv.features.forum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "forum_id")
//    @JsonIgnore
//    @ElementCollection
//    private Forum forum;

    //    @ManyToMany(mappedBy = "tags",cascade = CascadeType.ALL)
//    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tags")
    @JsonIgnore
    private List<Forum> forums;


    public Tag(String name, List<Forum> forums) {
        this.name = name;
        this.forums = forums;
    }
}

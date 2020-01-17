package com.proiect.colectiv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue
    private int id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forum_id")
    @JsonIgnore
    @ElementCollection
    private Forum forum;

    private long userId;

    public Comments(String text, Forum forum) {
        this.text = text;
        this.forum = forum;
    }
}

package com.proiect.colectiv.features.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forum")
public class Forum {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String text;

    private ForumType type;

    private LocalDate createdOn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forum", cascade = CascadeType.MERGE)
    private List<Comments> comments;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "forum_tags",
            joinColumns = {@JoinColumn(name = "forum_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")},
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"forum_id", "tag_id"})})
//    @JsonIgnore
    private List<Tag> tags;

    private int rating;

    private long userId;


    public Forum(String title, String text, ForumType type, LocalDate createdOn, List<Comments> comments, List<Tag> tags, int rating, long userId) {
        this.title = title;
        this.text = text;
        this.type = type;
        this.createdOn = createdOn;
        this.comments = comments;
        this.tags = tags;
        this.rating = rating;
        this.userId = userId;
    }

    public Forum(String text, ForumType type, LocalDate createdOn, List<Comments> comments, List<Tag> tags, int rating, long userId) {
        this.text = text;
        this.type = type;
        this.createdOn = createdOn;
        this.comments = comments;
        this.tags = tags;
        this.rating = rating;
        this.userId = userId;
    }

}

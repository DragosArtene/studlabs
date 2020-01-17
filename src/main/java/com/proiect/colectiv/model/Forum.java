package com.proiect.colectiv.model;

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

    @Column(columnDefinition = "LONGTEXT")
    private String text;

    private ForumType type;

    private LocalDate createdOn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forum", cascade = CascadeType.MERGE)
    private List<Comments> comments;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forum", cascade = CascadeType.MERGE)
//    private List<ForumTag> tags;

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

    public Forum(String text, ForumType type, LocalDate createdOn, List<Comments> comments, List<Tag> tags, long userId) {
        this.text = text;
        this.type = type;
        this.createdOn = createdOn;
        this.comments = comments;
        this.tags = tags;
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

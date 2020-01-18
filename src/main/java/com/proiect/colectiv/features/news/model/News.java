package com.proiect.colectiv.features.news.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue
    @Column(name= "news_id")
    private int id;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String text;

    private LocalDate createdOn;

    private String path;

private long userId;

    public News(String title, String text, LocalDate createdOn, String path) {
        this.title = title;
        this.text = text;
        this.createdOn = createdOn;
        this.path = path;
    }

    public News(String title, String text, LocalDate createdOn){
        this.title=title;
        this.text=text;
        this.createdOn=createdOn;
    }

    public News(String title, String text, LocalDate createdOn, String path, long userId) {
        this.title = title;
        this.text = text;
        this.createdOn = createdOn;
        this.path = path;
        this.userId = userId;
    }


}

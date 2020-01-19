package com.proiect.colectiv.features.quiz.model;

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
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private int id;

    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.MERGE)
    private List<Answer> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    @ElementCollection
    private Quiz quiz;

    public Question(String content, List<Answer> answers, Quiz quiz) {
        this.content = content;
        this.answers = answers;
        this.quiz = quiz;
    }
}

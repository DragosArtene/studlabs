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
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private QuizDifficulty difficulty;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz", cascade = CascadeType.MERGE)
    private List<Question> questions;

    public Quiz(String name, QuizDifficulty difficulty, List<Question> questions) {
        this.name = name;
        this.difficulty = difficulty;
        this.questions = questions;
    }
}

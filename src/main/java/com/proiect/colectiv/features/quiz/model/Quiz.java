//package com.proiect.colectiv.features.quiz.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "quiz")
//public class Quiz {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private QuizDifficulty difficulty;
//
//    @ManyToMany
//    @JoinTable(name = "quiz_questions",
//            joinColumns = {@JoinColumn(name = "quiz_id")},
//            inverseJoinColumns = {@JoinColumn(name = "question_id")},
//            uniqueConstraints = {@UniqueConstraint(
//                    columnNames = {"quiz_id", "question_id"})})
//    private List<Question> questions;
//
//    public Quiz(QuizDifficulty difficulty, List<Question> questions) {
//        this.difficulty = difficulty;
//        this.questions = questions;
//    }
//}

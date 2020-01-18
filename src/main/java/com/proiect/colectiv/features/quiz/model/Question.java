//package com.proiect.colectiv.features.quiz.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@Table(name = "question")
//public class Question {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String text;
//
//    @ManyToMany(mappedBy = "questions", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Quiz> quizes;
//
//    @ManyToMany
//    @JoinTable(name = "questions_answers",
//            joinColumns = {@JoinColumn(name = "questions_id")},
//            inverseJoinColumns = {@JoinColumn(name = "answer_id")},
//            uniqueConstraints = {@UniqueConstraint(
//                    columnNames = {"question_id", "answer_id"})})
//    private List<Answer> answers;
//
//    public Question(String text, List<Quiz> quizes) {
//        this.text = text;
//        this.quizes = quizes;
//    }
//}

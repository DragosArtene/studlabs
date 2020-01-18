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
//@Table(name = "answer")
//public class Answer {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @ManyToMany(mappedBy = "answers", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Question> questions;
//
//    public Answer(List<Question> questions) {
//        this.questions = questions;
//    }
//}

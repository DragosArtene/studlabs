package com.proiect.colectiv.features.quiz.dto;

import com.proiect.colectiv.features.quiz.model.Answer;
import com.proiect.colectiv.features.quiz.model.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String content;
    //private List<AnswerDTO> answers;
    private int quizId;

}

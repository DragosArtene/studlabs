package com.proiect.colectiv.features.quiz.dto;

import com.proiect.colectiv.features.quiz.model.QuizDifficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {

    private String name;
    private QuizDifficulty difficulty;
//    private List<QuestionDTO> questions;
}

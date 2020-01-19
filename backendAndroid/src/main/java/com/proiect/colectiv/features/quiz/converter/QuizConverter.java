package com.proiect.colectiv.features.quiz.converter;

import com.proiect.colectiv.features.quiz.dto.QuizDTO;
import com.proiect.colectiv.features.quiz.model.Quiz;
import org.springframework.stereotype.Component;

@Component
public class QuizConverter {

    private QuestionConverter questionConverter;

    public QuizConverter(QuestionConverter questionConverter) {
        this.questionConverter = questionConverter;
    }

    public Quiz toEntity(QuizDTO quizDTO){
        Quiz quiz=new Quiz();

        quiz.setDifficulty(quizDTO.getDifficulty());
        quiz.setName(quizDTO.getName());
//        quiz.setQuestions(questionConverter.toEntityList(quizDTO.getQuestions()));

        return quiz;

    }

    public QuizDTO toDto(Quiz quiz){
        QuizDTO quizDTO=new QuizDTO();

        quizDTO.setDifficulty(quiz.getDifficulty());
        quizDTO.setName(quiz.getName());
//        quizDTO.setQuestions(questionConverter.toDtoList(quiz.getQuestions()));

        return quizDTO;

    }


}

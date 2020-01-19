package com.proiect.colectiv.features.quiz.converter;

import com.proiect.colectiv.features.quiz.dto.QuestionDTO;
import com.proiect.colectiv.features.quiz.model.Question;
import com.proiect.colectiv.features.quiz.repository.QuizRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionConverter {

    private QuizRepository quizRepository;
    private AnswerConverter answerConverter;

    public QuestionConverter(QuizRepository quizRepository, AnswerConverter answerConverter) {
        this.quizRepository = quizRepository;
        this.answerConverter = answerConverter;
    }

    public Question toEntity(QuestionDTO questionDTO) {
        Question question = new Question();

        question.setContent(questionDTO.getContent());
        question.setQuiz(quizRepository.findById(questionDTO.getQuizId()));
        //question.setAnswers(answerConverter.toEntityList(questionDTO.getAnswers()));

        return question;
    }

    public QuestionDTO toDto(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setContent(question.getContent());
        questionDTO.setQuizId(question.getQuiz().getId());
        //questionDTO.setAnswers(answerConverter.toDtoList(question.getAnswers()));

        return questionDTO;
    }

    public List<QuestionDTO> toDtoList(List<Question> questions) {
        List<QuestionDTO> collect = questions.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return collect;
    }

    public List<Question> toEntityList(List<QuestionDTO> questions) {
        List<Question> collect = questions.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        return collect;
    }
}

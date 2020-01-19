package com.proiect.colectiv.features.quiz.converter;

import com.proiect.colectiv.features.forum.dto.TagDTO;
import com.proiect.colectiv.features.forum.model.Tag;
import com.proiect.colectiv.features.quiz.dto.AnswerDTO;
import com.proiect.colectiv.features.quiz.model.Answer;
import com.proiect.colectiv.features.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AnswerConverter {

    private QuestionRepository questionRepository;

    public AnswerConverter(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Answer toEntity(AnswerDTO answerDTO) {
        Answer answer = new Answer();

        answer.setContent(answerDTO.getContent());
        answer.setCorrect(answerDTO.getCorrect());
        answer.setQuestion(questionRepository.findById(answerDTO.getQuestion()));

        return answer;
    }

    public AnswerDTO toDto(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setContent(answer.getContent());
        answerDTO.setCorrect(answer.getCorrect());
        answerDTO.setQuestion(answer.getQuestion().getId());

        return answerDTO;
    }

    public List<AnswerDTO> toDtoList(List<Answer> answers) {
        List<AnswerDTO> collect = answers.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return collect;
    }

    public List<Answer> toEntityList(List<AnswerDTO> answers) {
        List<Answer> collect = answers.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        return collect;
    }
}

package com.proiect.colectiv.features.quiz.service;

import com.proiect.colectiv.features.quiz.converter.AnswerConverter;
import com.proiect.colectiv.features.quiz.dto.AnswerDTO;
import com.proiect.colectiv.features.quiz.model.Answer;
import com.proiect.colectiv.features.quiz.repository.AnswerRepository;
import com.proiect.colectiv.features.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnswerService {

    private AnswerRepository answerRepository;
    private AnswerConverter answerConverter;
    private QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, AnswerConverter answerConverter, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.answerConverter = answerConverter;
        this.questionRepository = questionRepository;
    }

    public AnswerDTO addAnswer(AnswerDTO answerDTO) throws Exception {
        Answer answer = answerRepository.findByContentAndAndQuestion(answerDTO.getContent(), questionRepository.findById(answerDTO.getQuestion()));

        if (answer != null) {
            throw new Exception("This answer already exists for the given question.");
        } else {
            return answerConverter.toDto(answerRepository.save(answerConverter.toEntity(answerDTO)));
        }
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public void deleteAnswer(int id) throws Exception {

        Answer answer = answerRepository.findById(id);

        if (answer == null) {
            throw new Exception("This answer does not exist.");
        } else {
            answerRepository.delete(answer);
        }

    }

    public void updateAnswer(String content, int id) throws Exception {
        Answer answer = answerRepository.findById(id);

        if (answer == null) {

            throw new Exception("Answer does not exist.");
        } else {
            answer.setContent(content);
            answerRepository.save(answer);
        }
    }
}

package com.proiect.colectiv.features.quiz.service;

import com.proiect.colectiv.features.quiz.converter.QuestionConverter;
import com.proiect.colectiv.features.quiz.dto.QuestionDTO;
import com.proiect.colectiv.features.quiz.model.Question;
import com.proiect.colectiv.features.quiz.repository.QuestionRepository;
import com.proiect.colectiv.features.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    private QuestionRepository questionRepository;
    private QuestionConverter questionConverter;
    private QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuestionConverter questionConverter, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.questionConverter = questionConverter;
        this.quizRepository = quizRepository;
    }

    public QuestionDTO addQuestion(QuestionDTO questionDTO) throws Exception {
        Question question = questionRepository.findByQuizAndContent(quizRepository.findById(questionDTO.getQuizId()), questionDTO.getContent());

        if (question != null) {
            throw new Exception("This question already exists for this quiz.");
        } else {
            return questionConverter.toDto(questionRepository.save(questionConverter.toEntity(questionDTO)));
        }
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public void deleteQuestion(int id) throws Exception {
        Question question = questionRepository.findById(id);

        if (question == null) {
            throw new Exception("This question does not exist.");
        } else {
            questionRepository.delete(question);
        }
    }

    public void updateQuestion(String content, int id) throws Exception {
        Question question = questionRepository.findById(id);

        if (question == null) {

            throw new Exception("Question does not exist.");
        } else {
            question.setContent(content);
            questionRepository.save(question);
        }
    }
}

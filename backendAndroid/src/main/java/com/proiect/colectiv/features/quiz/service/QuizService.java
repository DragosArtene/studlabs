package com.proiect.colectiv.features.quiz.service;

import com.proiect.colectiv.features.quiz.converter.QuizConverter;
import com.proiect.colectiv.features.quiz.dto.QuizDTO;
import com.proiect.colectiv.features.quiz.model.Quiz;
import com.proiect.colectiv.features.quiz.model.QuizDifficulty;
import com.proiect.colectiv.features.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuizService {

    private QuizRepository quizRepository;
    private QuizConverter quizConverter;

    public QuizService(QuizRepository quizRepository, QuizConverter quizConverter) {
        this.quizRepository = quizRepository;
        this.quizConverter = quizConverter;
    }

    public QuizDTO addQuiz(QuizDTO quizDTO) throws Exception {
        Quiz quiz = quizRepository.findByName(quizDTO.getName());

        if (quiz != null) {
            throw new Exception("Quiz with given name already exists.");
        } else {

            return quizConverter.toDto(quizRepository.save(quizConverter.toEntity(quizDTO)));
        }
    }

    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }

    public List<Quiz> getAllByDiff(QuizDifficulty difficulty){
        return quizRepository.findByDifficulty(difficulty);
    }

    public void deleteQuiz(int id) throws Exception{
        Quiz quiz=quizRepository.findById(id);

        if (quiz == null) {
            throw new Exception("Quiz does not exist.");
        }
        else {
            quizRepository.delete(quiz);
        }
    }
}

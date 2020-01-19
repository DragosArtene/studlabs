package com.proiect.colectiv.features.quiz.repository;

import com.proiect.colectiv.features.quiz.model.Answer;
import com.proiect.colectiv.features.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    Answer findByContentAndAndQuestion(String content, Question question);

    Answer findById(int id);

    Answer findByCorrect(boolean correct);
}

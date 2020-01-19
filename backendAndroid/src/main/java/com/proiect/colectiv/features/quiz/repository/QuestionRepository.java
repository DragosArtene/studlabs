package com.proiect.colectiv.features.quiz.repository;

import com.proiect.colectiv.features.quiz.model.Question;
import com.proiect.colectiv.features.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findById(int id);

    Question findByQuizAndContent(Quiz quiz,String content);
}

package com.proiect.colectiv.features.quiz.repository;

import com.proiect.colectiv.features.quiz.model.Quiz;
import com.proiect.colectiv.features.quiz.model.QuizDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

    Quiz findById(int id);

    Quiz findByName(String name);

    List<Quiz> findByDifficulty(QuizDifficulty difficulty);
}

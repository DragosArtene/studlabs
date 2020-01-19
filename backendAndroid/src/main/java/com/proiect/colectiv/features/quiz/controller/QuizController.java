package com.proiect.colectiv.features.quiz.controller;

import com.proiect.colectiv.features.quiz.dto.QuizDTO;
import com.proiect.colectiv.features.quiz.model.Quiz;
import com.proiect.colectiv.features.quiz.model.QuizDifficulty;
import com.proiect.colectiv.features.quiz.service.QuizService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMINISTRATOR')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Quiz> getAll() {
        return quizService.getAll();
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMINISTRATOR')")
    @RequestMapping(value = "/difficulty", method = RequestMethod.GET)
    public List<Quiz> getAllByDifficulty(@RequestParam QuizDifficulty difficulty) {
        return quizService.getAllByDiff(difficulty);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createQuiz(@RequestBody QuizDTO quizDTO) throws Exception{
        QuizDTO quizDTO1 = quizService.addQuiz(quizDTO);

        return new ResponseEntity<>(quizDTO1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void deleteQuiz(@RequestParam int id) throws Exception{
        quizService.deleteQuiz(id);
    }
}

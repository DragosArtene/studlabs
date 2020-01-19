package com.proiect.colectiv.features.quiz.controller;

import com.proiect.colectiv.features.quiz.dto.QuestionDTO;
import com.proiect.colectiv.features.quiz.model.Question;
import com.proiect.colectiv.features.quiz.service.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMINISTRATOR')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createQuestion(@RequestBody QuestionDTO questionDTO) throws Exception {
        QuestionDTO questionDTO1 = questionService.addQuestion(questionDTO);

        return new ResponseEntity<>(questionDTO1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void deleteQuestion(@RequestParam int id) throws Exception{
        questionService.deleteQuestion(id);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/all", method = RequestMethod.PUT)
    public void changeQuestion(@RequestParam int id, @RequestParam String content) throws Exception{
        questionService.updateQuestion(content,id);
    }
}

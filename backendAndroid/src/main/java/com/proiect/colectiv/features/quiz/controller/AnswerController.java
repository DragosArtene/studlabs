package com.proiect.colectiv.features.quiz.controller;

import com.proiect.colectiv.features.quiz.dto.AnswerDTO;
import com.proiect.colectiv.features.quiz.model.Answer;
import com.proiect.colectiv.features.quiz.service.AnswerService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/answer")

public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMINISTRATOR')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Answer> getAll() {
        return answerService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createAnswer(@RequestBody AnswerDTO answerDTO) throws Exception {
        AnswerDTO answerDTO1 = answerService.addAnswer(answerDTO);

        return new ResponseEntity<>(answerDTO1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void deleteAnswer(@RequestParam int id) throws Exception{
        answerService.deleteAnswer(id);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/all", method = RequestMethod.PUT)
    public void changeAnswer(@RequestParam int id, @RequestParam String content) throws Exception{
        answerService.updateAnswer(content,id);
    }
}

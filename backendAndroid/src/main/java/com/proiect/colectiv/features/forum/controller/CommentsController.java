package com.proiect.colectiv.features.forum.controller;

import com.proiect.colectiv.features.forum.dto.CommentsDTO;
import com.proiect.colectiv.features.forum.model.Comments;
import com.proiect.colectiv.features.forum.service.CommentsService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RequestMapping(value = "/comments")
@RestController
public class CommentsController {

    private CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createComment(@RequestBody CommentsDTO commentsDTO) throws Exception {
        CommentsDTO comments = commentsService.addComments(commentsDTO);

        return new ResponseEntity<>(comments, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Comments> getAllComments() {
        return commentsService.getAll();
    }


    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void removeComment(@RequestParam int commId) throws Exception {
        commentsService.deleteComment(commId);
    }


    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public void updteComment(@RequestParam int commId, @RequestParam String text) throws Exception {
        commentsService.updateComment(commId, text);
    }

}

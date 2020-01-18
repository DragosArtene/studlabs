package com.proiect.colectiv.features.forum.controller;

import com.proiect.colectiv.features.forum.dto.ForumDTO;
import com.proiect.colectiv.features.forum.model.Forum;
import com.proiect.colectiv.features.forum.model.ForumType;
import com.proiect.colectiv.features.forum.model.Tag;
import com.proiect.colectiv.features.forum.service.ForumService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RequestMapping(value = "/forum")
@RestController
public class ForumController {

    private ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createForum(@RequestBody ForumDTO forumDTO) throws Exception {
        ForumDTO forum = forumService.addForum(forumDTO);

        return new ResponseEntity<>(forum, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Forum> getAllForums() {
        return forumService.getAll();
    }

//    @PreAuthorize("hasAuthority('USER')")
//    @RequestMapping(value = "/tag", method = RequestMethod.GET)
//    public List<Forum> getAllForumsByTag(@RequestBody Tag tag) {
//        return forumService.getAllByTag(tag);
//    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public int getNoOfCommentsForForum(@RequestParam int forumId) throws Exception {
        return forumService.getNoComments(forumId);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void removeForum(@RequestParam int forumId) throws Exception {
        forumService.deleteForum(forumId);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public void updateForum(@RequestParam int forumId, @RequestParam String text) throws Exception {
        forumService.updateForum(forumId, text);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/type", method = RequestMethod.PUT)
    public void updateForumType(@RequestParam int forumId, @RequestParam ForumType type) throws Exception {
        forumService.updateForumType(forumId, type);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/upvote", method = RequestMethod.PUT)
    public void upvoteRating(@RequestParam int forumId) throws Exception {
        forumService.upvoteForum(forumId);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/downvote", method = RequestMethod.PUT)
    public void downvoteRating(@RequestParam int forumId) throws Exception {
        forumService.downvoteForum(forumId);
    }
}

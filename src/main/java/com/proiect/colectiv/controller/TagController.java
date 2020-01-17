package com.proiect.colectiv.controller;

import com.proiect.colectiv.dto.TagDTO;
import com.proiect.colectiv.model.Tag;
import com.proiect.colectiv.service.TagService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RequestMapping(value = "tags")
@RestController
public class TagController {

    private TagService forumTagService;

    public TagController(TagService forumTagService) {
        this.forumTagService = forumTagService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createTags(@RequestBody TagDTO tagDTO) throws Exception {
        TagDTO forumTag = forumTagService.addTags(tagDTO);

        return new ResponseEntity<>(forumTag, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tag> getAllTags() {
        return forumTagService.getAllTags();
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void removeTag(@RequestParam int tagId) throws Exception {
        forumTagService.deleteTag(tagId);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public void updateTag(@RequestParam int tagId, @RequestParam String name) throws Exception {
        forumTagService.updateTag(tagId, name);
    }


}

package com.proiect.colectiv.controller;

import com.proiect.colectiv.dto.NewsDTO;
import com.proiect.colectiv.model.News;
import com.proiect.colectiv.service.NewsService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api
@RestController
@RequestMapping(value = "/news")
public class NewsController {

    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<News> getAll() {
        return newsService.getAllNews();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createNewNews(@RequestBody NewsDTO newsDTO) throws Exception{
        NewsDTO newsDTO1 = newsService.createNews(newsDTO);

        return new ResponseEntity<>(newsDTO1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNews(@RequestParam int id) throws Exception {
        try {
            newsService.deleteNews(id);
        } catch (Exception e) {
            throw new IllegalStateException("Post with given id does not exist.");
        }

        return ResponseEntity.ok(null);

    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value="/change",method = RequestMethod.PUT)
    public void editNews(@RequestParam String title, @RequestParam String text){
        newsService.updateNews(title,text);
    }


}

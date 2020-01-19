package com.proiect.colectiv.features.news.service;

import com.proiect.colectiv.features.news.converter.NewsConverter;
import com.proiect.colectiv.features.news.dto.NewsDTO;
import com.proiect.colectiv.features.news.model.News;
import com.proiect.colectiv.features.news.repository.NewsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NewsService {

    private NewsRepository newsRepository;
    private NewsConverter newsConverter;

    public NewsService(NewsRepository newsRepository, NewsConverter newsConverter) {
        this.newsRepository = newsRepository;
        this.newsConverter = newsConverter;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public NewsDTO createNews(NewsDTO newsDTO) throws Exception {

        if (newsRepository.existsByTitle(newsDTO.getTitle())) {
            throw new Exception("Post with given title already exists.");
        }
        return newsConverter.toDTO(newsRepository.save(newsConverter.toEntity(newsDTO)));
    }

    public void deleteNews(int id) throws Exception {

        News news = newsRepository.findById(id);

        if (news != null) newsRepository.delete(news);
        else
            throw new Exception("Post with given id does not exist. ");

    }

    public News updateNews(String title, String text) {
        News news = newsRepository.findByTitle(title);

        newsRepository.updateNews(news.getTitle(), text);

        return newsRepository.findByTitle(title);
    }

}

package com.proiect.colectiv.converter;

import com.proiect.colectiv.dto.NewsDTO;
import com.proiect.colectiv.model.News;
import com.proiect.colectiv.utils.SecurityUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NewsConverter {


    public News toEntity(NewsDTO newsDTO) throws Exception{
        News news =new News();
        news.setTitle(newsDTO.getTitle());
        news.setText(newsDTO.getText());
        news.setPath(newsDTO.getPath());
        news.setCreatedOn(LocalDate.now());
        news.setUserId(SecurityUtils.getCurrentUserID());

        return news;
    }

    public NewsDTO toDTO(News news){
        NewsDTO newsDTO =new NewsDTO();
        newsDTO.setTitle(news.getTitle());
        newsDTO.setText(news.getText());
        newsDTO.setPath(news.getPath());

        return newsDTO;
    }


}

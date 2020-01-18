package com.proiect.colectiv.features.news.repository;

import com.proiect.colectiv.features.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findAll();

    News findById(int id);

    News findByTitle(String title);

    Boolean existsByTitle(String title);

    @Modifying
    @Query(value = "UPDATE News set text=?2 where title=?1")
    void updateNews(String title, String text);
}

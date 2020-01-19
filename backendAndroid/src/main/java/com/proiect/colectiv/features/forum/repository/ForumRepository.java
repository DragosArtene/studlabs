package com.proiect.colectiv.features.forum.repository;

import com.proiect.colectiv.features.forum.model.Forum;
import com.proiect.colectiv.features.forum.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer> {

    Forum findById(int id);

    Optional<Forum> findByText(String text);


    List<Forum> findAllByTags(Tag tag);

    @Query(value="SELECT COUNT(comments) FROM Forum WHERE id=?1")
    Integer countNoOfComments(int forumId);
}



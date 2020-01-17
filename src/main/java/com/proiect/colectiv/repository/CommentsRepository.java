package com.proiect.colectiv.repository;

import com.proiect.colectiv.model.Comments;
import com.proiect.colectiv.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    List<Comments> findAllByForum(Forum forum);

    Comments findById(int id);
}

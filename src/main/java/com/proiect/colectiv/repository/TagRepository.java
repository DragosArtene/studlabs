package com.proiect.colectiv.repository;

import com.proiect.colectiv.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {


    Tag findByName(String tag);

//    List<ForumTag> findByName(String tag);

    //List<Tag> findByForumId(int id);


//    Tag findByForumIdAndName(int forumId, String name);

    Tag findById(int tagId);


}

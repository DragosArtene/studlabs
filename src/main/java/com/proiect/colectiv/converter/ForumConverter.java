package com.proiect.colectiv.converter;

import com.proiect.colectiv.dto.ForumDTO;
import com.proiect.colectiv.model.Forum;
import com.proiect.colectiv.repository.UserRepository;
import com.proiect.colectiv.utils.SecurityUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ForumConverter {

    private UserRepository userRepository;
    private TagConverter tagConverter;

    public ForumConverter(UserRepository userRepository, TagConverter tagConverter) {
        this.userRepository = userRepository;
        this.tagConverter = tagConverter;
    }


    public Forum toEntity(ForumDTO forumDTO) {
        Forum forum = new Forum();

        forum.setText(forumDTO.getText());
        forum.setType(forumDTO.getType());
        forum.setUserId(SecurityUtils.getCurrentUserID());
        forum.setCreatedOn(LocalDate.now());
        forum.setTags(tagConverter.toEntityList(forumDTO.getTags()));
        forum.setRating(forumDTO.getRating());

        return forum;
    }

    public ForumDTO toDto(Forum forum) {
        ForumDTO forumDTO = new ForumDTO();

        forumDTO.setText(forum.getText());
        forumDTO.setType(forum.getType());
        //forumDTO.setUserId(forum.getUserId());
        forumDTO.setTags(tagConverter.toDtoList(forum.getTags()));
        forumDTO.setRating(forum.getRating());

        return forumDTO;
    }


}

package com.proiect.colectiv.features.forum.converter;

import com.proiect.colectiv.features.forum.dto.ForumDTO;
import com.proiect.colectiv.features.forum.model.Forum;
import com.proiect.colectiv.features.authentication.repository.UserRepository;
import com.proiect.colectiv.features.authentication.utils.SecurityUtils;
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

        forum.setTitle(forumDTO.getTitle());
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

        forumDTO.setTitle(forum.getTitle());
        forumDTO.setText(forum.getText());
        forumDTO.setType(forum.getType());
        //forumDTO.setUserId(forum.getUserId());
        forumDTO.setTags(tagConverter.toDtoList(forum.getTags()));
        forumDTO.setRating(forum.getRating());

        return forumDTO;
    }


}

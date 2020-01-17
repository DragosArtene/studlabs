package com.proiect.colectiv.converter;

import com.proiect.colectiv.dto.CommentsDTO;
import com.proiect.colectiv.model.Comments;
import com.proiect.colectiv.repository.ForumRepository;
import com.proiect.colectiv.utils.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class CommentsConverter {

    private ForumRepository forumRepository;

    public CommentsConverter(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Comments toEntity(CommentsDTO commentsDTO){
        Comments comments =new Comments();

        comments.setText(commentsDTO.getText());
        comments.setForum(forumRepository.findById(commentsDTO.getForumId()));
        comments.setUserId(SecurityUtils.getCurrentUserID());

        return comments;
    }

    public CommentsDTO toDto(Comments comments){
        CommentsDTO commentsDTO =new CommentsDTO();

        commentsDTO.setForumId(comments.getForum().getId());
        commentsDTO.setText(comments.getText());


        return commentsDTO;
    }
}

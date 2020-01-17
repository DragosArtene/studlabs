package com.proiect.colectiv.service;

import com.proiect.colectiv.converter.CommentsConverter;
import com.proiect.colectiv.dto.CommentsDTO;
import com.proiect.colectiv.model.Comments;
import com.proiect.colectiv.model.Forum;
import com.proiect.colectiv.repository.CommentsRepository;
import com.proiect.colectiv.repository.ForumRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentsService {

    private CommentsRepository commentsRepository;
    private CommentsConverter commentsConverter;
    private ForumRepository forumRepository;

    public CommentsService(CommentsRepository commentsRepository, CommentsConverter commentsConverter, ForumRepository forumRepository) {
        this.commentsRepository = commentsRepository;
        this.commentsConverter = commentsConverter;
        this.forumRepository = forumRepository;
    }

    public CommentsDTO addComments(CommentsDTO commentsDTO) throws Exception {

        Forum forum = forumRepository.findById(commentsDTO.getForumId());

        if (forum == null) {
            throw new Exception("Forum with given id does not exist.");
        } else {
            return commentsConverter.toDto(commentsRepository.save(commentsConverter.toEntity(commentsDTO)));
        }

    }

    public List<Comments> getAll() {
        return commentsRepository.findAll();
    }

    public void deleteComment(int commId) throws Exception {
        Comments comments = commentsRepository.findById(commId);

        if (comments == null) {
            throw new Exception("Comment with given id does not exist.");
        } else {
            commentsRepository.delete(comments);

        }
    }

    public void updateComment(int commId, String text) throws Exception {
        Comments comments = commentsRepository.findById(commId);

        if (comments == null) {
            throw new Exception("Comment with given id does not exist.");
        } else {
            comments.setText(text);

            commentsRepository.save(comments);

        }
    }

}

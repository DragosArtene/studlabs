package com.proiect.colectiv.features.forum.service;

import com.proiect.colectiv.features.authentication.model.User;
import com.proiect.colectiv.features.authentication.utils.SecurityUtils;
import com.proiect.colectiv.features.forum.converter.ForumConverter;
import com.proiect.colectiv.features.forum.dto.ForumDTO;
import com.proiect.colectiv.features.forum.model.Comments;
import com.proiect.colectiv.features.forum.model.Forum;
import com.proiect.colectiv.features.forum.model.ForumType;
import com.proiect.colectiv.features.forum.model.Tag;
import com.proiect.colectiv.features.forum.repository.CommentsRepository;
import com.proiect.colectiv.features.forum.repository.ForumRepository;
import com.proiect.colectiv.features.forum.repository.TagRepository;
import com.proiect.colectiv.features.authentication.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ForumService {

    private ForumRepository forumRepository;
    private ForumConverter forumConverter;
    private TagRepository tagRepository;
    private UserRepository userRepository;
    private CommentsRepository commentsRepository;

    public ForumService(ForumRepository forumRepository, ForumConverter forumConverter, TagRepository tagRepository, UserRepository userRepository, CommentsRepository commentsRepository) {
        this.forumRepository = forumRepository;
        this.forumConverter = forumConverter;
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.commentsRepository = commentsRepository;
    }

    public ForumDTO addForum(ForumDTO forumDTO) {


        forumRepository.findByText(forumDTO.getText()).ifPresent(s -> {
            throw new RuntimeException("This topic already exists.");
        });

        Forum forum = forumConverter.toEntity(forumDTO);
        forum.setRating(0);

        forumRepository.save(forum);
        return forumConverter.toDto(forum);


    }

    public List<Forum> getAll() {
        return forumRepository.findAll();
    }

//    public List<Forum> getAllByTags(String tags) {
//        ForumTag forumTag=forumTagRepository.findByName(tags);
//
//        return forumRepository.findAllByTagsContaining(forumTag);
//    }

    public int getNoComments(int forumId) throws Exception {

        Forum forum = forumRepository.findById(forumId);

        if (forum == null) {
            throw new Exception("Forum wih given id does not exist.");
        }

        List<Comments> comments = commentsRepository.findAllByForum(forum);

        return comments.size();
    }

    public void deleteForum(int forumId) throws Exception {

        Forum forum = forumRepository.findById(forumId);

        if (forum == null) {
            throw new Exception("Forum with given id does not exist.");
        } else {

            forumRepository.delete(forum);
        }
    }

    public void updateForum(int forumId, String text) throws Exception {

        Forum forum = forumRepository.findById(forumId);

        if (forum == null) {
            throw new Exception("Forum with given id does not exist.");
        } else {

            forum.setText(text);

            forumRepository.save(forum);
        }


    }

    public void updateForumType(int forumId, ForumType type) throws Exception {
        Forum forum = forumRepository.findById(forumId);


        if (forum == null) {
            throw new Exception("Forum with given id does not exist.");
        } else {

            forum.setType(type);

            forumRepository.save(forum);
        }
    }

    public void upvoteForum(int forumId) throws Exception {
        Forum forum = forumRepository.findById(forumId);

        if (forum == null) {
            throw new Exception("Forum with given id does not exist.");
        } else {
            forum.setRating(forum.getRating() + 1);
        }
    }

    public void downvoteForum(int forumId) throws Exception {
        Forum forum = forumRepository.findById(forumId);


        if (forum == null) {
            throw new Exception("Forum with given id does not exist.");
        } else {
            forum.setRating(forum.getRating() - 1);
        }


    }

}





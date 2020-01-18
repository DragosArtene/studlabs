package com.proiect.colectiv.features.forum.service;

import com.proiect.colectiv.features.forum.converter.TagConverter;
import com.proiect.colectiv.features.forum.dto.TagDTO;
import com.proiect.colectiv.features.forum.model.Tag;
import com.proiect.colectiv.features.forum.repository.ForumRepository;
import com.proiect.colectiv.features.forum.repository.TagRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagService {

    private TagRepository tagRepository;
    private TagConverter tagConverter;
    private ForumRepository forumRepository;

    public TagService(TagRepository tagRepository, TagConverter tagConverter, ForumRepository forumRepository) {
        this.tagRepository = tagRepository;
        this.tagConverter = tagConverter;
        this.forumRepository = forumRepository;
    }

    public TagDTO addTags(TagDTO tagDTO) throws Exception {
        Tag tag = tagRepository.findByName(tagDTO.getName());

        if (tag != null) {
            throw new Exception("Related tag already exists.");
        } else {

            return tagConverter.toDto(tagRepository.save(tagConverter.toEntity(tagDTO)));
        }
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public void deleteTag(int tagId) throws Exception {
        Tag tags = tagRepository.findById(tagId);

        if (tags == null) {
            throw new Exception("Tag with given id does not exist.");
        } else {
            tagRepository.delete(tags);

        }
    }


    public void updateTag(int tagId, String name) throws Exception {
        Tag tags = tagRepository.findById(tagId);

        if (tags == null) {
            throw new Exception("Tag with given id does not exist.");
        } else {
            tags.setName(name);
            tagRepository.save(tags);

        }
    }


}

package com.proiect.colectiv.features.forum.converter;

import com.proiect.colectiv.features.forum.dto.TagDTO;
import com.proiect.colectiv.features.forum.model.Tag;
import com.proiect.colectiv.features.forum.repository.ForumRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagConverter {

    private ForumRepository forumRepository;

    public TagConverter(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Tag toEntity(TagDTO tagDTO){
        Tag tag =new Tag();

        tag.setName(tagDTO.getName());
//        forumTag.setForum(forumRepository.findById(forumTagDTO.getForumId()));

        return tag;
    }

    public TagDTO toDto(Tag tag){
        TagDTO tagDTO =new TagDTO();

        tagDTO.setName(tag.getName());
//        forumTagDTO.setForumId(forumTag.getId());
//
        return tagDTO;
    }

    public List<TagDTO> toDtoList(List<Tag> tags) {
        List<TagDTO> collect = tags.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return collect;
    }

    public List<Tag> toEntityList(List<TagDTO> tags) {
        List<Tag> collect = tags.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        return collect;
    }
}

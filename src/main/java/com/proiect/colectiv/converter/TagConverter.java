package com.proiect.colectiv.converter;

import com.proiect.colectiv.dto.TagDTO;
import com.proiect.colectiv.model.Tag;
import com.proiect.colectiv.repository.ForumRepository;
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

    public List<TagDTO> toDtoList(List<Tag> forums) {
        List<TagDTO> collect = forums.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return collect;
    }

    public List<Tag> toEntityList(List<TagDTO> forums) {
        List<Tag> collect = forums.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        return collect;
    }
}

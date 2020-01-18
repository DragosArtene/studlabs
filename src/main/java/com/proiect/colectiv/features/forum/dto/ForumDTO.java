package com.proiect.colectiv.features.forum.dto;

import com.proiect.colectiv.features.forum.model.ForumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ForumDTO {

    private String text;
    private String title;
    private ForumType type;
    private List<TagDTO> tags;
    private int rating;

}

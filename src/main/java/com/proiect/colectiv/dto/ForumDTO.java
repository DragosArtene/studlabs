package com.proiect.colectiv.dto;

import com.proiect.colectiv.model.ForumType;
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
    private ForumType type;
    private List<TagDTO> tags;
    private int rating;

}

package com.alura.literalura.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(@JsonAlias String title,
                      @JsonAlias List<AuthorDto> authors,
                      @JsonAlias List<String> languages,
                      @JsonAlias("download_count") Integer downloads) {

}
package com.alura.literalura.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDto(@JsonAlias String name,
                        @JsonAlias("birth_year") Integer birthYear,
                        @JsonAlias("death_year") Integer deathYear) {

}
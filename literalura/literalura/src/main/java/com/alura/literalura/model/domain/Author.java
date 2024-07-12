package com.alura.literalura.model.domain;

import com.alura.literalura.model.dto.AuthorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "author", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    public Author(AuthorDto authorDto) {
        this.name = authorDto.name();
        this.birthYear = authorDto.birthYear();
        this.deathYear = authorDto.deathYear();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("******************** AUTOR ********************\n");
        sb.append("Nome: ").append(name).append("\n");
        sb.append("Ano de nascimento: ").append(birthYear).append("\n");
        sb.append("Ano de falecimento: ").append(deathYear).append("\n");
        sb.append("Livros: ").append(books).append("\n");
        sb.append("***********************************************\n");
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}
package com.alura.literalura.provider.repository;

import com.alura.literalura.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByName(String name);

    Author findByName(String name);

    @Query("SELECT a FROM Author a WHERE :year BETWEEN a.birthYear AND a.deathYear")
    List<Author> findLivingAuthorsByYear(Integer year);

}
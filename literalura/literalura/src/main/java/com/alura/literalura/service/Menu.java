package com.alura.literalura.service;

import com.alura.literalura.model.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Menu {
    Scanner sc = new Scanner(System.in);

    public String showMenu() {
        System.out.println("***********************************************");
        System.out.println("""
                    [1] Buscar livro pelo título
                    [2] Listar livros registrados
                    [3] Listar autores registrados
                    [4] Listar autores vivos em um ano específico
                    [5] Listar livros em um idioma específico
                    [0] Sair""");
        System.out.println("***********************************************");

        return sc.nextLine();
    }

    public String askTitle() {
        System.out.println("Informe o nome do livro que deseja procurar");
        return sc.nextLine();
    }

    public Integer askYear() {
        while (true) {
            System.out.println("Informe o ano que deseja pesquisar");
            try {
                var yearString = sc.nextLine();
                return Integer.parseInt(yearString);
            } catch (NumberFormatException e) {
                System.out.println("Input inválido, tente novamente");
            }
        }
    }

    public void showBookInfo(Book book) {
        System.out.println("******************** LIVRO ********************");
        System.out.println("Título: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor().getName());
        System.out.println("Idioma: " + book.getLanguages());
        System.out.println("Número de downloads: " + book.getDownloads());
        System.out.println("***********************************************");
        System.out.println();
    }

    public String askLanguage() {
        while (true) {
            System.out.println("Informe o código do idioma para realizar a busca");
            System.out.println("[es] espanhol");
            System.out.println("[en] inglês");
            System.out.println("[fr] francês");
            System.out.println("[pt] português");

            var language = sc.nextLine();

            switch (language) {
                case "es":
                    return language;
                case "en":
                    return language;
                case "fr":
                    return language;
                case "pt":
                    return language;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
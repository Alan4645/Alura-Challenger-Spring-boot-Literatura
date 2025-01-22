package com.exemplo.gutendex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.exemplo.gutendex.model.Livro;
import com.exemplo.gutendex.controller.LivroController;

import java.util.List;

@SpringBootApplication
public class GutendexApplication {

    public static void main(String[] args) {
        SpringApplication.run(GutendexApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(LivroController livroController) {
        return args -> {
            List<Livro> livros = livroController.buscarLivros("Pride and Prejudice");
            livros.forEach(livro -> System.out.println("Título: " + livro.getTitle() + ", Autor: " + livro.getAuthor()));
        };
    }
}
package com.exemplo.gutendex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.exemplo.gutendex.model.Livro;
import com.exemplo.gutendex.controller.LivroController;

import java.util.List;

@SpringBootApplication
public class GutendexApplication {

    public static void main(String[] args) {
        SpringApplication.run(GutendexApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(LivroController livroController) {
        return args -> {
            List<Livro> livros = livroController.buscarLivros("Pride and Prejudice");
            livros.forEach(livro -> System.out.println("Título: " + livro.getTitle() + ", Autor: " + livro.getAuthor()));
        };
    }
}

package com.exemplo.gutendex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.exemplo.gutendex.model.Livro;
import java.util.List;
import java.util.Map;

@RestController
public class LivroController {

    @GetMapping("/buscar")
    public List<Livro> buscarLivros(@RequestParam String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

        return results.stream().map(result -> {
            Livro livro = new Livro();
            livro.setTitle((String) result.get("title"));
            livro.setAuthor((String) ((Map<String, Object>) ((List<Object>) result.get("authors")).get(0)).get("name"));
            return livro;
        }).toList();
    }
}

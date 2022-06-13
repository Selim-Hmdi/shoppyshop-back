package com.groupe8.ShoppyShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupe8.ShoppyShop.exception.ResourceNotFoundException;
import com.groupe8.ShoppyShop.model.Article;
import com.groupe8.ShoppyShop.repository.ArticleRepository;

@CrossOrigin
@RestController
@RequestMapping("/articles")
public class ArticleController {
	@Autowired
	private ArticleRepository repository;

	@GetMapping
	public List<Article> findAllArticles() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Article> findArticleById(@PathVariable(name = "id") Integer id) {
		Article article = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("L'article avec l'id " + id + " est introuvable"));
		return ResponseEntity.ok(article);
	}

	@GetMapping("/article/{category}")
	public List<Article> findByCategory(@PathVariable(name = "category") String category) {
		return repository.findByCategorie(category);
	}

	@PostMapping
	public Article create(@RequestBody Article article) {
		return repository.save(article);
	}
}

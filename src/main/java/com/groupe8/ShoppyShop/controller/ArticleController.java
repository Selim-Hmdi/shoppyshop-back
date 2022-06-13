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
import com.groupe8.ShoppyShop.service.ArticleService;

@CrossOrigin
@RestController
@RequestMapping("/articles")
public class ArticleController {
	private ArticleService service;
	
	
	@Autowired
	public ArticleController(ArticleService service) {
		this.service = service;
	}

	@GetMapping
	public List<Article> findAllArticles() {
		return service.findAll();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Article> findArticleById(@PathVariable(name = "id") Integer id) {
		Article article = service.findById(id);
		return ResponseEntity.ok(article);
	}

	@GetMapping("/article/{category}")
	public List<Article> findByCategorie(@PathVariable(name = "category") String categorie) {
		return service.findByCategorie(categorie);
	}

	@PostMapping
	public Article create(@RequestBody Article article) {
		return service.save(article);
	}
}

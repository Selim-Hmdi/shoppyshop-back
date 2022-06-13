package com.groupe8.ShoppyShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe8.ShoppyShop.exception.ResourceNotFoundException;
import com.groupe8.ShoppyShop.model.Article;
import com.groupe8.ShoppyShop.repository.ArticleRepository;

@Service
public class ArticleService {
	private ArticleRepository repository;

	@Autowired
	public ArticleService(ArticleRepository repository) {
		this.repository = repository;
	}
	
	public List<Article> findAll() {
		return repository.findAll();
	}
	
	public List<Article> findByCategorie(String categorie) {
		return repository.findByCategorie(categorie);
	}
	
	public Article findById(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("L'article avec l'id " + id + " est introuvable"));
	}
	
	public Article save(Article article) {
		return repository.save(article);
	}
	
	
}

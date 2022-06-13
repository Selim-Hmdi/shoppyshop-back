package com.groupe8.ShoppyShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe8.ShoppyShop.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	List<Article> findByCategorie(String categorie);
}

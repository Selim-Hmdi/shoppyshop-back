package com.groupe8.ShoppyShop.model;

import java.util.Objects;

public class Ligne {
	private Article article;
	private int quantite;
	private int prixTotal;
	
	public Ligne() {
	}
	
	public Ligne(Article article, int quantite) {
		this.article = article;
		this.quantite = quantite;
		this.prixTotal = article.getPrix() * quantite;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	public int getPrixByLines() {
		int prixUnitaire = getArticle().getPrix();
		int prixByLine = prixUnitaire * getQuantite();
		return prixByLine;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ligne other = (Ligne) obj;
		
		return Objects.equals(article, other.getArticle());
		
	}
	
}

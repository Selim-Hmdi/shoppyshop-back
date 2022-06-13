package com.groupe8.ShoppyShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "lignes")
public class Ligne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double prixligne;

	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commande_id")
	private Commande commande;

	@OneToOne
	@JoinColumn(name = "article_id")
	private Article article;

	@Version
	private int version;

	public Ligne() {
	}

	public Ligne(Integer id, double prixligne, int quantity, Commande commande, Article article) {
		this.id = id;
		this.prixligne = prixligne;
		this.quantity = quantity;
		this.commande = commande;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrixligne() {
		return prixligne;
	}

	public void setPrixligne(double prixligne) {
		this.prixligne = prixligne;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Ligne [prixligne=" + prixligne + ", quantity=" + quantity + ", commande=" + commande + ", article="
				+ article + "]";
	}

}

package com.groupe8.ShoppyShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "articles")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String marque;

	private double prix;

	private String description;

	private String imageUrl;

	private String categorie;

	@Version
	private int version;

	public Article() {
	}

	public Article(String marque, double prix, String description, String imageUrl, String categorie) {
		this.marque = marque;
		this.prix = prix;
		this.description = description;
		this.imageUrl = imageUrl;
		this.categorie = categorie;
	}
	
	public Article(int id, String marque, double prix, String description, String imageUrl, String categorie) {
		this.id = id;
		this.marque = marque;
		this.prix = prix;
		this.description = description;
		this.imageUrl = imageUrl;
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [marque=" + marque + ", prix=" + prix + ", description=" + description + ", imageUrl="
				+ imageUrl + ", categorie=" + categorie + "]";
	}

}

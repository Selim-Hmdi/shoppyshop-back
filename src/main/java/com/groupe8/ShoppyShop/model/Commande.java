package com.groupe8.ShoppyShop.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double prixTotal;

	@CreationTimestamp
	private LocalDateTime date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	private String infos;

	@Version
	private int version;

	public Commande() {
	}

	public Commande(double prixTotal, LocalDateTime date, User user) {
		this.prixTotal = prixTotal;
		this.date = date;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		List<Ligne> lignes = new ArrayList<>();
		String res = "";
		for (Ligne l : lignes) {
			res += l.getArticle().getId() + "-" + l.getQuantite() + "/";
		}
		this.infos = res;
		this.infos = infos;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", prixTotal=" + prixTotal + ", date=" + date + ", user=" + user + ", infos="
				+ infos + "]";
	}

}

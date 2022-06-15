package com.groupe8.ShoppyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupe8.ShoppyShop.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}

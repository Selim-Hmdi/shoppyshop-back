package com.groupe8.ShoppyShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupe8.ShoppyShop.model.Commande;
import com.groupe8.ShoppyShop.service.CommandeService;

@CrossOrigin
@RestController
@RequestMapping("/commandes")
public class CommandeController {
	private CommandeService service;
	
	@Autowired
	public CommandeController(CommandeService service) {
		this.service = service;
	}

	@PostMapping("/add/{userId}")
	public Commande createCommande(@RequestBody Commande commande, @PathVariable("userId") Integer userId) {
		return service.saveCommande(commande, userId);
	}
}

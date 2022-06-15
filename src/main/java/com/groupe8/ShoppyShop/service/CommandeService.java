package com.groupe8.ShoppyShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe8.ShoppyShop.model.Commande;
import com.groupe8.ShoppyShop.model.User;
import com.groupe8.ShoppyShop.repository.CommandeRepository;

@Service
public class CommandeService {
	private CommandeRepository repository;
	private UserService userService;

	@Autowired
	public CommandeService(CommandeRepository repository, UserService userService) {
		this.repository = repository;
		this.userService = userService;
	}
	
	public Commande saveCommande(Commande commande, Integer userId) {
        User user = userService.findById(userId);
        commande.setUser(user);
        return repository.save(commande);
    }

	
	
	
}

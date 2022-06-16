package com.groupe8.ShoppyShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupe8.ShoppyShop.exception.BadArgumentException;
import com.groupe8.ShoppyShop.exception.ResourceNotFoundException;
import com.groupe8.ShoppyShop.model.Article;
import com.groupe8.ShoppyShop.model.User;
import com.groupe8.ShoppyShop.repository.UserRepository;

@Service
public class UserService {
	private UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User findById(Integer id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Utilisateur introuvable. L'id entré est inexistant ou incorrect: " + id));
	}

	public User findByEmail(String email) throws ResourceNotFoundException {
		return repository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(
				"Utilisateur introuvable. L'email entré est inexistant ou incorrect: " + email));
	}

	public User findByEmailAndPassword(String email, String password) throws ResourceNotFoundException {
		return repository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Utilisateur introuvable. L'email ou le mot de passe entré est inexistant ou incorrect: "
								+ email + " " + password));
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User save(User user) {
		if (emailExists(user.getEmail())) {
			throw new BadArgumentException("Un utilisateur existe déjà avec cette adresse email");
		}
		return repository.save(user);
	}

	public User update(Integer id, User user) {
		User userToUpdate = findById(id);
		userToUpdate.setAdresse(user.getAdresse());
		userToUpdate.setVille(user.getVille());
		userToUpdate.setPays(user.getPays());
		userToUpdate.setTelephone(user.getTelephone());
		return repository.save(userToUpdate);
	}
	
	private boolean emailExists(String email) {
		return repository.findByEmail(email).isPresent();
	}

}

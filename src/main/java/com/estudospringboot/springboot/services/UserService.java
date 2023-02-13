package com.estudospringboot.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudospringboot.springboot.domain.User;
import com.estudospringboot.springboot.repository.UserRepository;

@Service
public class UserService {

	// vou ter que instanciar um objeto UserRepository para poder gerar meus servicços
	
	@Autowired
	private UserRepository repo; // injeção de dependencia automática do Spring  a notação @Autowired ja instacia o objeto
	
	public List<User> findAll(){
		return repo.findAll(); // retornando todos os objetos do tipo user
		
	}
}

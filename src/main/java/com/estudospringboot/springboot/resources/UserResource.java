package com.estudospringboot.springboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudospringboot.springboot.domain.User;
import com.estudospringboot.springboot.services.UserService;
// aqui são anotações para dizer que é a classe controller e que vai mapear como nome users

@RestController
@RequestMapping(value="users")
public class UserResource {

	@Autowired
	private UserService service;
	
	
	// criando o metodo que recuperará todos os usuários faz uma list da classe User
	// a notaçao informa que o método será GET
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity< List<User>> finAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}

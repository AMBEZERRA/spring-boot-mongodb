package com.estudospringboot.springboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudospringboot.springboot.domain.User;
// aqui são anotações para dizer que é a classe controller e que vai mapear como nome users

@RestController
@RequestMapping(value="users")
public class UserResource {

	// criando o metodo que recuperará todos os usuários faz uma list da classe User
	// a notaçao informa que o método será GET
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity< List<User>> finAll(){
		User maria = new User(1L, "Maria Brown", "maria@gmail.com");
		User alex = new User(2L, "Alex Magno", "magno@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));  // aqui é um macete pra adicionar os elementos na lista de vez
		return ResponseEntity.ok().body(list);
	}
	
}

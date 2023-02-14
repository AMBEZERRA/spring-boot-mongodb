package com.estudospringboot.springboot.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudospringboot.springboot.domain.User;
import com.estudospringboot.springboot.dto.UserDTO;
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
	public  ResponseEntity< List<UserDTO>> finAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public  ResponseEntity<UserDTO> finById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}

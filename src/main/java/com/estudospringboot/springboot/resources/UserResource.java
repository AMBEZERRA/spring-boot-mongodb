package com.estudospringboot.springboot.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public  ResponseEntity<Void> insert(@RequestBody UserDTO ObjDto){
		User obj = service.fromDTO(ObjDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public  ResponseEntity<UserDTO> delete(@PathVariable String id){
		 service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

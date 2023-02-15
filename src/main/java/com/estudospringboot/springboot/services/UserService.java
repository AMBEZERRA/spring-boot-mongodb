package com.estudospringboot.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudospringboot.springboot.domain.User;
import com.estudospringboot.springboot.dto.UserDTO;
import com.estudospringboot.springboot.repository.UserRepository;
import com.estudospringboot.springboot.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// vou ter que instanciar um objeto UserRepository para poder gerar meus servicços
	
	@Autowired
	private UserRepository repo; // injeção de dependencia automática do Spring  a notação @Autowired ja instacia o objeto
	
	public List<User> findAll(){
		return repo.findAll(); // retornando todos os objetos do tipo user
		
	}
	// Forma correta de chamar por ID
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	// metodo auxiliar para fazer UpDate
	private void updateDate(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}

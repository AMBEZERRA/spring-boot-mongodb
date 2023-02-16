package com.estudospringboot.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudospringboot.springboot.domain.Post;
import com.estudospringboot.springboot.repository.PostRepository;
import com.estudospringboot.springboot.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// vou ter que instanciar um objeto UserRepository para poder gerar meus servicços
	
	@Autowired
	private PostRepository repo; // injeção de dependencia automática do Spring  a notação @Autowired ja instacia o objeto
	
	
	// Forma correta de chamar por ID
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}

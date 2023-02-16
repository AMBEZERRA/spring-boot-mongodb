package com.estudospringboot.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudospringboot.springboot.domain.Post;
import com.estudospringboot.springboot.resources.util.URL;
import com.estudospringboot.springboot.services.PostService;

@RestController
@RequestMapping(value="posts")
public class PostResource {

	@Autowired
	private PostService service;


	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public  ResponseEntity<Post> finById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body((obj));
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public  ResponseEntity<List<Post>> finByIdTitle(@RequestParam(value="text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body((list));
	}
	
	
}

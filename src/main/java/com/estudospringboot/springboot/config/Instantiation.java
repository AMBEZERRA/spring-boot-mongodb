package com.estudospringboot.springboot.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudospringboot.springboot.domain.Post;
import com.estudospringboot.springboot.domain.User;
import com.estudospringboot.springboot.dto.AuthorDTO;
import com.estudospringboot.springboot.dto.CommentDTO;
import com.estudospringboot.springboot.repository.PostRepository;
import com.estudospringboot.springboot.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	// cahmando o UserRepository parafazer a conexao com MongoDb
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		// chamar logo o repository para limmpar o banco excluindo tudo antes de fazer a nova instanciação
		// É um macete pra não encher o Bando de Dados, usar ele pra teste
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@mail.com");
		User alex = new User(null, "Alex Green", "alex@mail.com");
		User bob = new User(null, "Bob Grey", "bob@mail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei Feliz!!!!",  new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa Viagem, Mano", sdf.parse("21/06/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveeite", sdf.parse("23/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
				
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}

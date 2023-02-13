package com.estudospringboot.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudospringboot.springboot.domain.User;
import com.estudospringboot.springboot.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	// cahmando o UserRepository parafazer a conexao com MongoDb
	@Autowired
	private UserRepository userRepository;
		
	@Override
	public void run(String... args) throws Exception {
	
		// chamar logo o repository para limmpar o banco excluindo tudo antes de fazer a nova instanciação
		// É um macete pra não encher o Bando de Dados, usar ele pra teste
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@mail.com");
		User alex = new User(null, "Alex Green", "alex@mail.com");
		User bob = new User(null, "Bob Grey", "bob@mail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}

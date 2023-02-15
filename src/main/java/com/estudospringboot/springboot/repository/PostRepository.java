package com.estudospringboot.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudospringboot.springboot.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}

// só com essas notações e interface extendendo MogoRepository o User pode fazer
// varias requisições Alterar , Incluir , Deletar User
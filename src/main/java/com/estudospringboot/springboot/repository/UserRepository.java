package com.estudospringboot.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudospringboot.springboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

// só com essas notações e interface extendendo MogoRepository o User pode fazer
// varias requisições Alterar , Incluir , Deletar User
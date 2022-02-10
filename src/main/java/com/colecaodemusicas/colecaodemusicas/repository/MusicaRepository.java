package com.colecaodemusicas.colecaodemusicas.repository;

import com.colecaodemusicas.colecaodemusicas.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String>{
    
}

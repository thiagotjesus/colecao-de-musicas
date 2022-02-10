package com.colecaodemusicas.colecaodemusicas.service;

import java.util.List;
import java.util.Optional;

import com.colecaodemusicas.colecaodemusicas.model.Musica;

public interface MusicaService {

    void SalvarMusica(Musica musica);

    List<Musica> ObterTodos();   

    Optional<Musica> BuscarId(String id);

    Optional<Musica> AtualizarMusica(Musica musica);
    
    Optional<Musica> DeletarMusica(String id);

}  

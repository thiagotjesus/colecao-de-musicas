package com.colecaodemusicas.colecaodemusicas.service;

import java.util.List;
import java.util.Optional;

import com.colecaodemusicas.colecaodemusicas.model.Musica;
import com.colecaodemusicas.colecaodemusicas.repository.MusicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceimpl implements MusicaService {
    @Autowired
    private MusicaRepository repositorio;

    @Override
    public void SalvarMusica(Musica musica){
        repositorio.save(musica);
    }

    @Override
    public List<Musica> ObterTodos(){
        return repositorio.findAll();
    }

    @Override
    public Optional<Musica> BuscarId(String id){
        return repositorio.findById(id);
    }
    
    @Override
    public Optional<Musica> AtualizarMusica(Musica musica) {
        if(repositorio.existsById(musica.getId())){
        repositorio.save(musica);
        }
        return repositorio.findById(musica.getId());
    }
    
    @Override
    public Optional<Musica> DeletarMusica(String id) {
        if(repositorio.existsById(id)){
        Optional<Musica> musicaDeletada = repositorio.findById(id);
        repositorio.deleteById(id);
        return musicaDeletada;
        }
        else{
        return repositorio.findById(id);
        }
    } 
    
}
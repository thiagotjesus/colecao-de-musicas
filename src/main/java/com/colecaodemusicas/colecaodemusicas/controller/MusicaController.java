package com.colecaodemusicas.colecaodemusicas.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.colecaodemusicas.colecaodemusicas.model.Musica;
import com.colecaodemusicas.colecaodemusicas.service.MusicaServiceimpl;
import com.colecaodemusicas.colecaodemusicas.shared.MusicaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/musicas")
public class MusicaController {
    @Autowired
    private MusicaServiceimpl servico; 

    @PostMapping
    public ResponseEntity<Object> SalvarMusica(@RequestBody Musica musica){
        servico.SalvarMusica(musica);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> ObterTodos(){
        List<MusicaDTO> ListaDTO = servico.ObterTodos()
        .stream()
        .map(MusicaDTO::from)
        .collect(Collectors.toList());
        return new ResponseEntity<>(ListaDTO, HttpStatus.OK);   
    }
  
    @GetMapping("/{id}")
    public ResponseEntity<MusicaDTO> BuscarId(@PathVariable String id){
        if(!servico.BuscarId(id).isEmpty()){
            MusicaDTO dto = MusicaDTO.from(servico.BuscarId(id).get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping()
    public ResponseEntity<MusicaDTO> AtualizarMusica(@RequestBody Musica musica){
        if(!servico.AtualizarMusica(musica).isEmpty()){
            MusicaDTO dto = MusicaDTO.from(musica);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DeltarMusica(@PathVariable String id){
        if(!servico.DeletarMusica(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

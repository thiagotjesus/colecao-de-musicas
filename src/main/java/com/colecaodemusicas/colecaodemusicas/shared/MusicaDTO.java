package com.colecaodemusicas.colecaodemusicas.shared;

import com.colecaodemusicas.colecaodemusicas.model.Musica;

public class MusicaDTO {
    private String id;
    private String titulo;
    private String artista;
    
    public MusicaDTO(String id, String titulo, String artista) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    } 

    public static MusicaDTO from(Musica musica){
       return new MusicaDTO(musica.getId(), musica.getTitulo(), musica.getArtista());
    }
    
}

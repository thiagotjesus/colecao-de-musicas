package com.colecaodemusicas.colecaodemusicas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("musicas")
public class Musica {
@Id
private String id;
private String titulo;
private String artista;
private String album;
private String genero;
private Integer anoLancamento;
private String compositor;

public Musica(String titulo, String artista, String album, String genero, Integer anoLancamento, String compositor) {
    this.titulo = titulo;
    this.artista = artista;
    this.album = album;
    this.genero = genero;
    this.anoLancamento = anoLancamento;
    this.compositor = compositor;
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

public String getAlbum() {
    return album;
}

public void setAlbum(String album) {
    this.album = album;
}

public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public Integer getAnoLancamento() {
    return anoLancamento;
}

public void setAnoLancamento(Integer anoLancamento) {
    this.anoLancamento = anoLancamento;
}

public String getCompositor() {
    return compositor;
}

public void setCompositor(String compositor) {
    this.compositor = compositor;
}

}

package br.edu.ifpi.playmusic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "musicas")
public class Musica {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String nome;
  @ManyToOne
  @JoinColumn(name = "artista_id", nullable = false)
  private Artista artista;

  public Musica() {
  }

  public Musica(String nome, Artista artista) {
    this.nome = nome;
    this.artista = artista;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Artista getArtista() {
    return artista;
  }

  public void setArtista(Artista artista) {
    this.artista = artista;
  }

}

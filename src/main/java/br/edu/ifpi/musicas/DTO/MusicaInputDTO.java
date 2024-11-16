package br.edu.ifpi.musicas.DTO;

import java.util.Optional;

import br.edu.ifpi.musicas.Model.Musica;
import br.edu.ifpi.musicas.Model.Artista;
import br.edu.ifpi.musicas.Repostitory.ArtistaRepository;

public class MusicaInputDTO {
  private String nome;
  private long idArtista;

  public MusicaInputDTO(long idArtista, String nome) {
    this.idArtista = idArtista;
    this.nome = nome;
  }

  public Musica converte(ArtistaRepository artistaRepository) {
    Optional<Artista> optional = artistaRepository.findById(this.idArtista);
    if (optional.isPresent()) {
      return new Musica(nome, optional.get());
    }
    return null;
  }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(long idArtista) {
        this.idArtista = idArtista;
    }



}

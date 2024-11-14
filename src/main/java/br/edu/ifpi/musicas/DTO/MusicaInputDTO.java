package br.edu.ifpi.musicas.DTO;

import java.util.Optional;

import br.edu.ifpi.musicas.Model.Musica;
import br.edu.ifpi.musicas.Model.Usuario;
import br.edu.ifpi.musicas.Repostitory.UsuarioRepository;

public class MusicaInputDTO {
  private String nome;
  private long idUsuario;

  public MusicaInputDTO(long idUsuario, String nome) {
    this.idUsuario = idUsuario;
    this.nome = nome;
  }

  public Musica converte(UsuarioRepository usuarioRepository) {
    Optional<Usuario> optional = usuarioRepository.findById(this.idUsuario);
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }



}

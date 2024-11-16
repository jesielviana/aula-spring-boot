package br.edu.ifpi.musicas.Repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.musicas.Model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

  List<Artista> findByNome(String nome);

}

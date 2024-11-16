package br.edu.ifpi.playmusic.Repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.playmusic.Model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

  List<Artista> findByNome(String nome);

}

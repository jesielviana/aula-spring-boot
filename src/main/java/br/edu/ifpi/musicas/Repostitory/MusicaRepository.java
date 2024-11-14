package br.edu.ifpi.musicas.Repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.musicas.Model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}

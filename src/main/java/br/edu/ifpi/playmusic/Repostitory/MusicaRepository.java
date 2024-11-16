package br.edu.ifpi.playmusic.Repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.playmusic.Model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}

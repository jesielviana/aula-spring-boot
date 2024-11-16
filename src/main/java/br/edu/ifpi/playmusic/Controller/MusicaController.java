package br.edu.ifpi.playmusic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.playmusic.DTO.MusicaInputDTO;
import br.edu.ifpi.playmusic.Model.Musica;
import br.edu.ifpi.playmusic.Repostitory.ArtistaRepository;
import br.edu.ifpi.playmusic.Repostitory.MusicaRepository;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

  @Autowired
  private MusicaRepository musicaRepository;
  @Autowired
  private ArtistaRepository artistaRepository;

  @GetMapping
  public List<Musica> get() {
    return musicaRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<Musica> add(@RequestBody MusicaInputDTO dto) {
    Musica musica = dto.converte(artistaRepository);
    musicaRepository.save(musica);
    return ResponseEntity.status(201).body(musica);
  }

}

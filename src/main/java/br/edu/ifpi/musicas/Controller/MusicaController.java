package br.edu.ifpi.musicas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.musicas.DTO.MusicaInputDTO;
import br.edu.ifpi.musicas.Model.Musica;
import br.edu.ifpi.musicas.Repostitory.MusicaRepository;
import br.edu.ifpi.musicas.Repostitory.UsuarioRepository;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

  @Autowired
  private MusicaRepository musicaRepository;
  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping
  public List<Musica> get() {
    return musicaRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<Musica> add(@RequestBody MusicaInputDTO dto) {
    Musica musica = dto.converte(usuarioRepository);
    musicaRepository.save(musica);
    return ResponseEntity.status(201).body(musica);
  }

}

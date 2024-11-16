package br.edu.ifpi.playmusic.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.playmusic.Model.Artista;
import br.edu.ifpi.playmusic.Repostitory.ArtistaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

  @Autowired
  private ArtistaRepository artistaRepository;

  @GetMapping
  public List<Artista> get(@RequestParam(required = false) String nome) {
    if (nome == null) {
      return artistaRepository.findAll();
    }
    return artistaRepository.findByNome(nome);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Artista> getById(@PathVariable long id) {
    Optional<Artista> optional = artistaRepository.findById(id);
    if (optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    }
    return ResponseEntity.notFound().build();

  }

  @PostMapping
  public ResponseEntity<Artista> add(@RequestBody @Valid Artista artista) {
    artistaRepository.save(artista);
    return ResponseEntity.status(201).body(artista);
  }

}

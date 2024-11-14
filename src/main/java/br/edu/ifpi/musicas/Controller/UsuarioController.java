package br.edu.ifpi.musicas.Controller;

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

import br.edu.ifpi.musicas.Model.Usuario;
import br.edu.ifpi.musicas.Repostitory.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping
  public List<Usuario> get(@RequestParam(required = false) String nome) {
    if (nome == null) {
      return usuarioRepository.findAll();
    }
    return usuarioRepository.findByNome(nome);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getById(@PathVariable long id) {
    Optional<Usuario> optional = usuarioRepository.findById(id);
    if (optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    }
    return ResponseEntity.notFound().build();

  }

  @PostMapping
  public ResponseEntity<Usuario> add(@RequestBody @Valid Usuario usuario) {
    usuarioRepository.save(usuario);
    return ResponseEntity.status(201).body(usuario);
  }

}

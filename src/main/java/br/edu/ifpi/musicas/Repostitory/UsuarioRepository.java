package br.edu.ifpi.musicas.Repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.musicas.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  List<Usuario> findByNome(String nome);

}

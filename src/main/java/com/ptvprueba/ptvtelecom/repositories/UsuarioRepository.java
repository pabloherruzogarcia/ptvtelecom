package com.ptvprueba.ptvtelecom.repositories;

import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Optional<Usuario> findById(Long id);


}

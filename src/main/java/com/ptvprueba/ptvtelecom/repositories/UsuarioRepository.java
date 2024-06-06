package com.ptvprueba.ptvtelecom.repositories;

import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}

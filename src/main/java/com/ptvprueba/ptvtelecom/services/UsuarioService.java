package com.ptvprueba.ptvtelecom.services;

import com.ptvprueba.ptvtelecom.common.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> getUser(Long id);
}

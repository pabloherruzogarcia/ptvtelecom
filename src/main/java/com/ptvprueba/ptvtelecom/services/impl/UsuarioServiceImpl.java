package com.ptvprueba.ptvtelecom.services.impl;


import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.repositories.UsuarioRepository;
import com.ptvprueba.ptvtelecom.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> getUser(Long id){
        return usuarioRepository.findById(id);
    }
}

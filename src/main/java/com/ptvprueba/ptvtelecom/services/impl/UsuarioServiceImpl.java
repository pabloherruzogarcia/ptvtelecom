package com.ptvprueba.ptvtelecom.services.impl;


import com.ptvprueba.ptvtelecom.common.dtos.UsuarioRequest;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.repositories.UsuarioRepository;
import com.ptvprueba.ptvtelecom.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUser(@RequestParam String id){
        return usuarioRepository.getReferenceById(id);
    }
}

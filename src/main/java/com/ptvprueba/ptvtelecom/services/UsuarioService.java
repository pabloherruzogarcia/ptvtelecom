package com.ptvprueba.ptvtelecom.services;

import com.ptvprueba.ptvtelecom.common.dtos.UsuarioRequest;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import org.springframework.web.bind.annotation.RequestParam;

public interface UsuarioService {
    Usuario getUser(@RequestParam String id);
}

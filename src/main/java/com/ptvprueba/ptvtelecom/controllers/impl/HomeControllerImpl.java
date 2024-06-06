package com.ptvprueba.ptvtelecom.controllers.impl;


import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.controllers.HomeController;
import com.ptvprueba.ptvtelecom.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeControllerImpl implements HomeController {

    private final UsuarioService usuarioService;

    public HomeControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    public Usuario getUser(@RequestParam String id){
        return usuarioService.getUser(id);
    }

    public String index(Model model){
        String id ="1";
        String dni = "80134455Z";
        model.addAttribute("parametro1", id);
        model.addAttribute("parametro2", dni);

        return "index";
    }

}

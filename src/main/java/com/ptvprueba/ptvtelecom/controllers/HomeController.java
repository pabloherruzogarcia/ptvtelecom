package com.ptvprueba.ptvtelecom.controllers;

import com.ptvprueba.ptvtelecom.common.constants.PtvTelecomConstants;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(PtvTelecomConstants.ROUTE)
@Controller
public interface HomeController {
    @GetMapping(value = "/usuario/dni")
    Usuario getUser(@RequestParam String id);

    @RequestMapping(value = "/index")
    String index(Model model);

}

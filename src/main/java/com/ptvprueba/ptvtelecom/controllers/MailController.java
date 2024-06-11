package com.ptvprueba.ptvtelecom.controllers;

import com.ptvprueba.ptvtelecom.common.constants.PtvTelecomConstants;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

@RequestMapping(PtvTelecomConstants.ROUTE)
@Controller
public interface MailController {

    @GetMapping(value= "/enviaEmail")
    String enviarEmail(@RequestParam String email, @RequestParam String nombre, @Param("firma") Canvas firma, Model model);
}

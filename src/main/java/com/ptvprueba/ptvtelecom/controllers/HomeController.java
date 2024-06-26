package com.ptvprueba.ptvtelecom.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.ptvprueba.ptvtelecom.common.constants.PtvTelecomConstants;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileNotFoundException;


@RequestMapping(PtvTelecomConstants.ROUTE)
@Controller
public interface HomeController {
    @GetMapping("/vista")
    String getUser(@RequestParam("id") Long id, @RequestParam("dni") String dni,  @Param("firma") Canvas firma, Model model);

    @GetMapping("/index")
    String index(Model model);



}

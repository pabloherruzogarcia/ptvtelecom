package com.ptvprueba.ptvtelecom.controllers.impl;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ptvprueba.ptvtelecom.common.constants.PtvTelecomConstants;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.controllers.HomeController;
import com.ptvprueba.ptvtelecom.repositories.UsuarioRepository;
import com.ptvprueba.ptvtelecom.services.PdfService;
import com.ptvprueba.ptvtelecom.services.UsuarioService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

@RequestMapping(PtvTelecomConstants.ROUTE)
@Controller
public class HomeControllerImpl implements HomeController {

    private final UsuarioService usuarioService;
    private final PdfService pdfService;
    private final UsuarioRepository usuarioRepository;
    private final JavaMailSender mailSender;

    public HomeControllerImpl(UsuarioService usuarioService, PdfService pdfService, UsuarioRepository usuarioRepository, JavaMailSender mailSender) {
        this.usuarioService = usuarioService;
        this.pdfService = pdfService;
        this.usuarioRepository = usuarioRepository;
        this.mailSender = mailSender;
    }


    public String getUser(@RequestParam("id") Long id, @RequestParam("dni") String dni, @Param("firma") Canvas firma, Model model){
        Optional<Usuario> usu = usuarioService.getUser(id);
        usu.get().setFirma(firma);
        model.addAttribute("user", usu);
        return "vistaFormulario";
    }

    public String index(Model model){
        String id ="";
        String dni = "";
        model.addAttribute("id", id);
        model.addAttribute("dni", dni);

        return "index";
    }






}

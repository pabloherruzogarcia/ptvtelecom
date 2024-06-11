package com.ptvprueba.ptvtelecom.controllers.impl;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.controllers.MailController;
import com.ptvprueba.ptvtelecom.repositories.UsuarioRepository;
import com.ptvprueba.ptvtelecom.services.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.itextpdf.text.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.awt.*;
import java.io.ByteArrayOutputStream;


@Controller
public class MailControllerImpl implements MailController {

    private final UsuarioRepository usuarioRepository;
    private final JavaMailSender mailSender;
    private final MailService mailService;

    public MailControllerImpl(UsuarioRepository usuarioRepository, JavaMailSender mailSender, MailService mailService) {
        this.usuarioRepository = usuarioRepository;
        this.mailSender = mailSender;
        this.mailService = mailService;
    }



    public String enviarEmail(String email, String nombre, Canvas firma, Model model) {
        mailService.enviarEmail(email, nombre, firma, model);
        return "vistaFinal";
    }


}

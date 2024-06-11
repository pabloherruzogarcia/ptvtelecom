package com.ptvprueba.ptvtelecom.services.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.repositories.UsuarioRepository;
import com.ptvprueba.ptvtelecom.services.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.awt.*;
import java.io.ByteArrayOutputStream;

@Service
public class MailServiceImpl implements MailService {

    private final UsuarioRepository usuarioRepository;
    private final JavaMailSender mailSender;

    public MailServiceImpl(UsuarioRepository usuarioRepository, JavaMailSender mailSender) throws DocumentException {
        this.usuarioRepository = usuarioRepository;
        this.mailSender = mailSender;
    }

    public String enviarEmail(String email, String nombre, Canvas firma, Model model) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        usuario.setFirma(firma);
        usuarioRepository.save(usuario);

        try {
            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, pdfOutputStream);
            document.open();
            document.add(new Paragraph("Nombre:" + usuario.getNombre()));
            document.add(new Paragraph("Dni:" + usuario.getDni()));
            document.add(new Paragraph("Email:" + usuario.getEmail()));
            document.add(new Paragraph("Firma:" + usuario.getFirma()));
            document.close();
            byte[] pdfBytes = pdfOutputStream.toByteArray();
            enviarEmailConPdf(email, pdfBytes);

        } catch (DocumentException | MessagingException e) {
            e.printStackTrace();
        }


        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("email", usuario.getEmail());

        return "Email mandado correctamente!";
    }

    private void enviarEmailConPdf(String toEmail, byte[] pdfBytes) throws MessagingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject("Mensaje enviado dedes PTVTelecom");
        helper.setText("Por favor, lea el PDF adjunto con los datos del usuario.");
        Usuario usuario = usuarioRepository.findByEmail(toEmail);
        String nombrePdf = usuario.getNombre() + ".pdf";
        InputStreamSource pdfSource = new ByteArrayResource(pdfBytes);

        helper.addAttachment(nombrePdf, pdfSource);

        mailSender.send(message);
    }
}

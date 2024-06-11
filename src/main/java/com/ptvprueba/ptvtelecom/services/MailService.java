package com.ptvprueba.ptvtelecom.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.awt.*;


public interface MailService {
    String enviarEmail(String email, String nombre, Canvas firma, Model model);
}

package com.ptvprueba.ptvtelecom.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;

import java.io.FileNotFoundException;

public interface PdfService {
    Document creaPdf(Usuario usuario) throws FileNotFoundException, DocumentException;
}

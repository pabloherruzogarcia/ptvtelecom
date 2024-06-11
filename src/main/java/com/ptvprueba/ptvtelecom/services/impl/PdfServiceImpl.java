package com.ptvprueba.ptvtelecom.services.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ptvprueba.ptvtelecom.common.entities.Usuario;
import com.ptvprueba.ptvtelecom.services.PdfService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

        @Override
    public Document creaPdf(Usuario usuario) throws FileNotFoundException, DocumentException {
            Document documento = new Document();
            FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            documento.open();
            documento.add(new Paragraph("Dni:"+ usuario.getDni()));
            documento.add(new Paragraph("Nombre:"+ usuario.getNombre()));
            documento.add(new Paragraph("Email:"+ usuario.getEmail()));
            documento.close();
            return documento;
    }
}

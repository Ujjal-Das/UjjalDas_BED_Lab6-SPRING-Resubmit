package com.Lab.RegistrationManager.service;

import com.Lab.RegistrationManager.entity.Student;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    public ByteArrayInputStream generatePdf(List<Student> students) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Student Records"));

            Table table = new Table(new float[] { 2, 2, 2, 2, 2 });
            table.addHeaderCell("ID");
            table.addHeaderCell("First Name");
            table.addHeaderCell("Last Name");
            table.addHeaderCell("Course");
            table.addHeaderCell("Country");

            for (Student student : students) {
                table.addCell(String.valueOf(student.getId()));
                table.addCell(student.getFirstName());
                table.addCell(student.getLastName());
                table.addCell(student.getCourse());
                table.addCell(student.getCountry());
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

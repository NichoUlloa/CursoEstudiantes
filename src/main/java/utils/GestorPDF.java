package utils;

import model.Estudiante;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Date;


public class GestorPDF {

    public void generarBoleta(Estudiante estudiante) throws IOException {
        // Crear un nuevo documento
        PDDocument documento = new PDDocument();
        // Crear y agregar una nueva página al documento
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
        // Generar un arreglo de líneas que contendrá el archivo PDF
        String[] lineasPdf = obtenerLineasPdf(estudiante);
        rellenarPDF(documento, pagina, lineasPdf);
        // Guardar el documento en la ubicación especificada
        documento.save(generarNombrePdf(estudiante.getRut()));
        documento.close();
    }

    private void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasEstudiante) {
        try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
            for (int linea = 0; linea < lineasEstudiante.length; linea++) {
                contenidoPagina.beginText();
                contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight() - (10 * linea));
                contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
                contenidoPagina.showText(lineasEstudiante[linea]);
                contenidoPagina.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] obtenerLineasPdf(Estudiante estudiante) {
        String[] lineasPdf = new String[3];
        lineasPdf[0] = "Datos del Estudiante";
        lineasPdf[1] = "Nombre: " + estudiante.getNombre();
        lineasPdf[2] = "Email: " + estudiante.getEmail();
        return lineasPdf;
    }

    private String generarNombrePdf(String rut) {
        String nombreArchivo = "target/" + "estudiante_" + rut + ".pdf";
        return nombreArchivo;
    }
}
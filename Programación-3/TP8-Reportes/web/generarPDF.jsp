<%-- 
    Document   : generarPDF
    Created on : 10/11/2020, 16:45:49
    Author     : Bruno Tarditi 
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Country"%>
<%@page import="controlador.GestorCountry"%>
<%@page import="com.lowagie.text.Rectangle"%>
<%@page import="com.lowagie.text.PageSize"%>
<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="com.lowagie.text.pdf.PdfPCell"%>
<%@page import="com.lowagie.text.Font"%>
<%@page import="com.lowagie.text.Phrase"%>
<%@page import="java.io.IOException"%>
<%@page import="com.lowagie.text.DocumentException"%>
<%@page import="java.util.Date"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.Document"%>


<%

    if (request.getParameter("pdf") != null || request.getParameter("region") != null) {

        GestorCountry gc = new GestorCountry();
        String pais = request.getParameter("pais");
        String region = request.getParameter("region");
        List<Country> countrys = gc.dameReportePais(region, pais);

        response.setContentType("application/pdf");

        Font titulo = new Font(Font.COURIER, 14, Font.BOLD);
        Font textoBold = new Font(Font.COURIER, 11, Font.BOLD);
        Font texto = new Font(Font.COURIER, 11, Font.NORMAL);

        Document document = new Document(PageSize.A4, 30, 30, 50, 30);//float marginLeft, float marginRight, float marginTop, float marginBottom

        document.addTitle("PROG 3");
        document.addSubject("UTN");
        document.addKeywords("Reporte");
        document.addAuthor("Bruno");
        document.addCreator("Tarditi");
        PdfWriter.getInstance(document, response.getOutputStream()); // Code 2
        document.open();

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        PdfPCell celdaCiudad = new PdfPCell(new Phrase("Ciudad", textoBold));
        celdaCiudad.setBorder(Rectangle.BOX);
        PdfPCell celdapoblacion = new PdfPCell(new Phrase("Poblacion", textoBold));
        celdapoblacion.setBorder(Rectangle.BOX);
        PdfPCell celdaPais = new PdfPCell(new Phrase("País", textoBold));
        celdaPais.setBorder(Rectangle.BOX);
        PdfPCell celdaregion = new PdfPCell(new Phrase("Región", textoBold));
        celdaregion.setBorder(Rectangle.BOX);
        table.addCell(celdaCiudad);
        table.addCell(celdapoblacion);
        table.addCell(celdaPais);
        table.addCell(celdaregion);

        for (Country c : countrys) {

            celdaCiudad = new PdfPCell(new Phrase(c.getNombreCiudad()));
            celdaCiudad.setBorder(Rectangle.BOX);
            celdapoblacion = new PdfPCell(new Phrase(String.valueOf(c.getPopulation())));
            celdapoblacion.setBorder(Rectangle.BOX);
            celdaPais = new PdfPCell(new Phrase(c.getNombrePais()));
            celdaPais.setBorder(Rectangle.BOX);
            celdaregion = new PdfPCell(new Phrase(c.getRegion()));
            celdaregion.setBorder(Rectangle.BOX);

            table.addCell(celdaCiudad);
            table.addCell(celdapoblacion);
            table.addCell(celdaPais);
            table.addCell(celdaregion);
        }

        document.add(table);
        document.close();

    }

%>
<%-- 
    Document   : generarExcel
    Created on : 11/11/2020, 00:24:46
    Author     : Bruno Tarditi 
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Country"%>
<%@page import="controlador.GestorCountry"%>
<%@page import="org.apache.poi.ss.usermodel.IndexedColors"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFCell"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFRow"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFCellStyle"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFFont"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFSheet"%>
<%@page import="org.apache.poi.xssf.streaming.SXSSFWorkbook"%>
<%@page import="org.apache.poi.ss.usermodel.FillPatternType"%>

<%

    if (request.getParameter("pais") != null || request.getParameter("region") != null) {

        GestorCountry gc = new GestorCountry();
        String pais = request.getParameter("pais");
        String region = request.getParameter("region");
        List<Country> countrys = gc.dameReportePais(region, pais);
        //creo el libro excel
        SXSSFWorkbook libro = new SXSSFWorkbook(50);
        //estilos
        XSSFFont font = (XSSFFont) libro.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) libro.createCellStyle();
        style.setFont(font);
        XSSFCellStyle styleGris = (XSSFCellStyle) libro.createCellStyle();
        styleGris.setFont(font);
        styleGris.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        styleGris.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //Amarillo
        XSSFCellStyle styleAmarillo = (XSSFCellStyle) libro.createCellStyle();
        styleAmarillo.setFont(font);
        styleAmarillo.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
        styleAmarillo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //Verde
        XSSFCellStyle styleGreen = (XSSFCellStyle) libro.createCellStyle();
        styleGreen.setFont(font);
        styleGreen.setFillForegroundColor(IndexedColors.SEA_GREEN.index);
        styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // Se crea una hoja dentro del libro
        SXSSFSheet hoja = libro.createSheet();

        int nroColumna = 0;
        // Se crea una fila dentro de la hoja
        SXSSFRow row = hoja.createRow(0);
        // Se crea una celda dentro de la fila
        SXSSFCell cell = row.createCell(nroColumna);
        cell.setCellValue("Ciudad");
        cell.setCellStyle(styleGris);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("Poblacion");
        cell.setCellStyle(styleGris);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("País");
        cell.setCellStyle(styleGris);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("Región");
        cell.setCellStyle(styleGris);

        int nroFila = 1;
        nroColumna = 0;

        for (Country c : countrys) {
            nroColumna = 0;
            row = hoja.createRow(nroFila);
            ++nroFila;            
            cell = row.createCell(nroColumna);
            if (c.getPopulation() > 5000000) {
            
            cell.setCellValue(c.getNombreCiudad());
            cell.setCellStyle(styleAmarillo);
            cell = row.createCell(++nroColumna);           
            cell.setCellValue(c.getPopulation());
            cell.setCellStyle(styleAmarillo);
            cell = row.createCell(++nroColumna);            
            cell.setCellValue(c.getNombrePais());
            cell.setCellStyle(styleAmarillo);
            cell = row.createCell(++nroColumna);
            cell.setCellValue(c.getRegion());
            cell.setCellStyle(styleAmarillo);

            } else if (c.getPopulation() < 100000) {
            cell.setCellValue(c.getNombreCiudad());
            cell.setCellStyle(styleGreen);
            cell = row.createCell(++nroColumna);           
            cell.setCellValue(c.getPopulation());
            cell.setCellStyle(styleGreen);
            cell = row.createCell(++nroColumna);            
            cell.setCellValue(c.getNombrePais());
            cell.setCellStyle(styleGreen);
            cell = row.createCell(++nroColumna);
            cell.setCellValue(c.getRegion());
            cell.setCellStyle(styleGreen);
            }else{
            cell.setCellValue(c.getNombreCiudad());
            cell = row.createCell(++nroColumna);
            cell.setCellValue(c.getPopulation());
            cell = row.createCell(++nroColumna);
            cell.setCellValue(c.getNombrePais());
            cell = row.createCell(++nroColumna);
            cell.setCellValue(c.getRegion());
            }

        }

        // Se salva el libro.
        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        libro.write(outByteStream);
        byte[] outArray = outByteStream.toByteArray();
        response.setContentType("application/ms-excel");
        response.setContentLength(outArray.length);
        response.setHeader("Expires:", "0"); // eliminates browser caching
        response.setHeader("Content-Disposition", "attachment; filename=paises.xls");
        OutputStream outStream = response.getOutputStream();
        outStream.write(outArray);
        outStream.flush();

    }
%>
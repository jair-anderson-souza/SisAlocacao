/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.commands;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.dao.IHolidayDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Scanner;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 * @since 2015, Jan 30, 2016
 */
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/csv"})
public class ReaderCsvFileCommand extends HttpServlet {

    private String path;
    private String fileName;

    public ReaderCsvFileCommand() {
        path = "/tmp";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            //Ainda ver formato de arquivo 
            //Ver se tem quebra de linha
            // Create path components to save the file
            final Part filePart = request.getPart("file");
            String fileType = filePart.getContentType();
            if (fileType.equals("text/csv")) {
                fileName = getFileName(filePart);
                OutputStream out = out = new FileOutputStream(new File(path + File.separator + fileName));;
                InputStream filecontent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                Scanner scanner = new Scanner(new File(path + "/" + fileName));
                scanner.useDelimiter(",|\\n");

                while (scanner.hasNext()) {
                    String date = scanner.next();
                    String description = scanner.next();
                    Holiday holiday = new Holiday(description, date);
                    Factory factory = new FactoryDao();
                    IHolidayDao dao = factory.createHolidayDao();
                    dao.add(holiday);
                    //eXPRESSÃO REGULAR DE DATA PT-BR
                    //if(data.matches("^([0-9]{2}\\/[0-9]{2}\\/[0-9]{4})$")){
                    //pADRÃO DE TEXTO
                    //if(descricao.matches("^\\w+$")){
                }
                scanner.close();
            }
        } catch (FileNotFoundException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
        response.sendRedirect("error.jsp");
    }
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}

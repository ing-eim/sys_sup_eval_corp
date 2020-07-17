/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.supeval.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pbi.supeval.base.JCGlobals;
import pbi.supeval.model.Upload_File_model;

/**
 *
 * @author depdes10
 */
public class UploadFiles extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadFiles</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadFiles at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int type_file_load = Integer.parseInt(request.getParameter("type_file_load"));
        System.out.println(String.valueOf(type_file_load));
        String c_i_placa;
        String c_v_num_oficio = "";
        String salida = "";
        int type_file = 1; /* ARCHIVOS PDF */
        int pk_i_claseytipo; /* 142 .- para oficios de comision; 143 .- Para Boletas de Arresto */
        int cargados = 0;
        List<Part> fileParts;
        if (type_file_load == 1){
            c_i_placa = request.getParameter("txtc_i_placa");
            c_v_num_oficio = request.getParameter("txtnumoficio");
            System.out.println(c_i_placa + " " +c_v_num_oficio);    
            pk_i_claseytipo = 142;
            fileParts = request.getParts().stream().filter(part -> "in_file" .equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
        }else{
            c_i_placa = request.getParameter("txtc_i_placabol");            
            System.out.println(c_i_placa);    
            pk_i_claseytipo = 53;        
            fileParts = request.getParts().stream().filter(part -> "in_filebol" .equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
        }           
        
        for (Part filePart : fileParts) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();            
            System.out.println("Cargar "+ fileName);
            if(type_file_load == 1){
                if(new Upload_File_model(fileContent,c_i_placa,type_file,pk_i_claseytipo,c_v_num_oficio).InsertaArchivo()){
                    cargados++;               
                }            
            }else{
                if(new Upload_File_model(fileContent,c_i_placa,type_file,pk_i_claseytipo).InsertaArchivoArresto()){
                    cargados++;               
                }            
            }
        }        
        if (cargados  > 0){
            salida = "true|ARCHIVOS CARGADOS";
        }else
            salida = "false|ERROR AL CARGAR \n" + new JCGlobals().getMsg();
        
        response.setContentType("text/plain");               
        response.getWriter().write(salida);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

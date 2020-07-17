/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.supeval.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pbi.supeval.base.JCGlobals;
import pbi.supeval.base.JCSession;
import pbi.supeval.model.Close_Session;

/**
 *
 * @author depdes10
 */
@WebServlet(name = "log_out", urlPatterns = {"/view/log_out"})
public class log_out extends HttpServlet {

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
            out.println("<title>Servlet log_out</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ERROR DE ACCESO</h1>");
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
        String salida="";
        //if(new Close_Session(new JCGlobals().getid_session()).Close()){
        try{
            HttpSession misession= (HttpSession) request.getSession();
            String c_v_session =  misession.getAttribute("c_v_session").toString();
            if(new Close_Session(c_v_session).Close()){
                salida = "true|"+new JCGlobals().getMsg();
                new JCSession().CloseSession(request);
            }else{
                salida = "false|"+new JCGlobals().getMsg();
            }
        }catch(NullPointerException x){
            salida = "true|"+new JCGlobals().getMsg();
            new JCSession().CloseSession(request);
        }
        //if(new Close_Session(new JCGlobals().getid_session()).Close()){
        
        response.setContentType("text/html;charset=UTF-8");
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

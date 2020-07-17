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
import pbi.supeval.base.JCGlobals;
import pbi.supeval.base.JCSession;
import pbi.supeval.model.jcNav;
import pbi.supeval.model.validation;

/**
 *
 * @author depdes10
 */
@WebServlet(name = "log_in", urlPatterns = {"/view/log_in"})
public class log_in extends HttpServlet {

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
            out.println("<title>ERROR DE ACCESSO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ERROR DE ACCESSO</h1>");
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
            new JCGlobals().Clear();
           
            String userName = request.getParameter("us").trim();
            String Pwd = (request.getParameter("pwd").trim()).toUpperCase();
            
            System.out.println(userName);
            System.out.println(Pwd);
            
            String web_cliente_nav = request.getHeader("USER-AGENT");
            jcNav nav_s = new jcNav();
            String web_navegador = nav_s.m_TipoNav(web_cliente_nav);
            String ip = null; // IP del cliente
            String host = null; // Host del cliente

            ip = request.getRemoteAddr();
            host = request.getRemoteHost();
	       
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}
                String salida="";
	
                if(new validation(userName,Pwd,ip).getSesion()){
                    salida = "true|"+new JCGlobals().getMsg();
                    new JCSession().CreateSession(request);
                }else{
                    salida = "false|"+new JCGlobals().getMsg();
                }		
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

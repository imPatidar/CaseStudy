/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.gui;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pro.bean.Loginuserstore;
import pro.dao.Logindao;

/**
 *
 * @author sneha
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
           
             String name=request.getParameter("uname");
             String pswd=request.getParameter("pswd");
             
             String err=null;
             if(name==null || name.equals("") )
             {
                 err="usewr name cant be null";
             }
             if(pswd==null || pswd.equals("") )
             {
                 err="pswd cant be null";
             }
             if(err != null)
             {
                 RequestDispatcher r=request.getRequestDispatcher("/Login.html");
                 out.println(err);
                 r.include(request,response);
                 
                 
             }
             else
             { 
                 try
             {
                 Loginuserstore p=new Loginuserstore(name,pswd);
                 boolean b=Logindao.verifyUser(p);
                 if(b)
                 {
                     request.getRequestDispatcher("/Update.html").include(request, response);
                     HttpSession session=request.getSession();  
        session.setAttribute("name",name);  
                 }
                 else
                 {
                     out.println("user not found ");
  request.getRequestDispatcher("/Login.html").include(request, response);

                 }
                 
             }
             catch(Exception e){};
             
             
             
        }
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
        processRequest(request, response);
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

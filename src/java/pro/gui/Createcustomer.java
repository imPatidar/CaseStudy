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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pro.bean.Customer;
import pro.bean.Loginuserstore;
import pro.dao.Addcust;
import pro.dao.Logindao;

/**
 *
 * @author sneha
 */
public class Createcustomer extends HttpServlet {

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
            String name=request.getParameter("name");
            String addr=request.getParameter("addr");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            int age=Integer.parseInt(request.getParameter("age"));
            int ssnid=Integer.parseInt(request.getParameter("SSN-Id"));
            
            
            
                
                 try
             {
                 Customer p=new Customer(name,age,addr,city,state,ssnid);
                 boolean b=Addcust.addCust(p);
                 if(b)
                 {
                     request.getRequestDispatcher("createcustomer.html").include(request, response);
                     out.println("<b><font color='green' size='10'>Customer created successfully!!!</font></b>");
                      HttpSession session=request.getSession(false);  
                 }
                 else
                 {
  request.getRequestDispatcher("createcustomer.html").include(request, response);
                       out.println("<b><font color='red' size='10'>customer with given ssnid already present!!!  </font></b>");


                 }
                 
             }
             catch(Exception e){};
             
             
                
                
                
            
            
            
            
            
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

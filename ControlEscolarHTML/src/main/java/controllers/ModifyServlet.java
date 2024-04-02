/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAO.CarreraDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.Carreras;

@WebServlet(name = "ModifyServlet", urlPatterns = {"/ModifyServlet"})
public class ModifyServlet extends HttpServlet {

    Carreras oldCarrera = new Carreras();
    
    List<String> show = new ArrayList<String>();
    String oldName = "";
    
    public ModifyServlet(){
        show.add("flex");
        show.add("none");       
        
    }
    
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
           
        if(request.getParameter("display") == null){
            request.setAttribute("display", show.get(1));
        }else{
            request.setAttribute("display", show.get(0));
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
        
        
        oldName = request.getParameter("modify");
        oldCarrera.setNombre(oldName);
        
        request.setAttribute("oldName", oldName);
        
        RequestDispatcher rd = request.getRequestDispatcher("HTML/modify.jsp");
        rd.forward(request, response);
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
        
        String newName = request.getParameter("name");
        Carreras newCarrera = new Carreras(newName);
        
        CarreraDAO carreraDao = new CarreraDAO();        
        List<Carreras> carreras = carreraDao.mostrarCarreras();
        boolean found = false;
        String nombreCarrera = "";        
        
        for (int i = 0; i < carreras.size(); i++) {
            nombreCarrera = carreras.get(i).getNombre();
            if(newName.equals(nombreCarrera)){
                found = true;
            }                        
        }
        
        if(found){
            request.setAttribute("display", show.get(0));
            RequestDispatcher rd = request.getRequestDispatcher("HTML/modify.jsp");
            request.setAttribute("oldName", oldName);
            rd.forward(request, response);
        }else{
            request.setAttribute("carrera", nombreCarrera);
            carreraDao.actualizarCarrera(oldCarrera, newCarrera);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            request.setAttribute("display", show.get(0));
            request.setAttribute("content", "Carrera " + oldName + " modificada a: " + newName);   
            rd.forward(request, response);  
        }      
        
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");

        rd.forward(request, response);
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

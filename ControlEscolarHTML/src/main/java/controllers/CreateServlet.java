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

/**
 *
 * @author Mati
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {
    
    List<String> show = new ArrayList<String>();
    
    public CreateServlet(){
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
                
        RequestDispatcher rd = request.getRequestDispatcher("HTML/crear.jsp");
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
        
        String nuevaCarrera = request.getParameter("name");
        Carreras carrera = new Carreras(nuevaCarrera);
        CarreraDAO carreraDao = new CarreraDAO();
        List<Carreras> carreras = carreraDao.mostrarCarreras();
        boolean found = false;
        String nombreCarrera = "";
                
        for (int i = 0; i < carreras.size(); i++) {
            nombreCarrera = carreras.get(i).getNombre();
            if(nuevaCarrera.equals(nombreCarrera)){
                found = true;
            }                        
        }
        
        if(found){
            request.setAttribute("display", show.get(0));
            RequestDispatcher rd = request.getRequestDispatcher("HTML/crear.jsp");
            rd.forward(request, response);
        }else{
            carreraDao.añadirCarrera(carrera);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            request.setAttribute("display", show.get(0));
            request.setAttribute("content", "Carrera " + nuevaCarrera + " creada!");
            rd.forward(request, response);  
        }        
        
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

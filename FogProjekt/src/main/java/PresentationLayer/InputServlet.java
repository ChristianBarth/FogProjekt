/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.MaterialMapper;
import DataLayer.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian Kolz Barth
 */
@WebServlet(name = "InputServlet", urlPatterns = {"/InputServlet"})
public class InputServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            response.setContentType("text/html;charset=UTF-8");
            String action = request.getParameter("action");

            if ("build".equals(action)) {
                String reqLength = request.getParameter("length");
                double length = Double.parseDouble(reqLength);
                String reqWidth = request.getParameter("width");
                double width = Double.parseDouble(reqWidth);
                String reqHeight = request.getParameter("height");
                int height = Integer.parseInt(reqHeight);
                int lengthint = Integer.parseInt(reqLength);
                

                ArrayList<Product> ListofProducts = LogicFacade.getListOfProducts(length, width);
                
                LogicFacade.PutOrderInDatabase(ListofProducts);
                
                HttpSession session = request.getSession();
                
                String drawing = LogicFacade.getSideCarportDrawing(length, height);
                
                session.setAttribute("length", lengthint);
                session.setAttribute("height", height);
                session.setAttribute("drawing", drawing);
                
                String nextURL = "confirmationPage.jsp";
                request.getRequestDispatcher(nextURL).forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request,response);
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

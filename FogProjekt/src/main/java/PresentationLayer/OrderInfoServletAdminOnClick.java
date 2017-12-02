/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "OrderInfoServletAdminOnClick", urlPatterns = {"/OrderInfoServletAdminOnClick"})
public class OrderInfoServletAdminOnClick extends HttpServlet {

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
        try {

            response.setContentType("text/html;charset=UTF-8");

            String ordernumberString = request.getParameter("ordernumber");
            int number = Integer.parseInt(ordernumberString);
            ArrayList<Order> orderlines = LogicFacade.getOrderLinesAdmin();
            ArrayList<Product> orderdetails = LogicFacade.getOrderDetails();

            if (number <= orderlines.size()) {
                ArrayList<Product> detailsfromid = LogicFacade.getOrderProductsFromID(number, orderdetails);
                int totalPrice = LogicFacade.getTotalPriceForDetails(number, orderdetails);

                request.setAttribute("detailsfromid", detailsfromid);
                request.setAttribute("totalprice", totalPrice);

                String nextURL = "/orderinfoadmin.jsp";
                request.getRequestDispatcher(nextURL).forward(request, response);
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (Exception e) {

            String nextURL = "orderinfoadmin.jsp";
            request.getRequestDispatcher(nextURL).forward(request, response);

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

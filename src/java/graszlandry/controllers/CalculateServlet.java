/*Copyright Jack Landry and Lexa Grasz 2015*/

package graszlandry.controllers;

import graszlandry.business.Calculator;
import java.io.IOException;
import java.lang.String;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graszlandry.business.User;
import static java.lang.Double.parseDouble;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author lexagrasz and Jack Landry
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

    

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
        doPost(request, response);
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
        
        String url = "/index.jsp";
        ServletContext sc = getServletContext();
        
        //Get current action 
        String action = request.getParameter("action");
        
        if (action==null){
            action = "join";
        }
        
        if (action.equals("join")){
            url = "/index.jsp";
        }
       
        else if (action.equals("add")){
        //Get parameters from the request
        String investmentS = request.getParameter("investment");
        Double investment = Double.parseDouble(investmentS);
        String interestS = request.getParameter("interest");
        Double interest = Double.parseDouble(interestS);
        String yearsS = request.getParameter("years");
        Double years = Double.parseDouble(yearsS);
        

        
        //Stores data in User object
        User user = new User(investment, interest, years);
        Calculator calculator = new Calculator();
        
        String message;
        if (investment == null || interest == null || years == null || 
                investment.isNaN() || interest.isNaN() || years.isNaN()) {
            message = "Please fill out all three text boxes.";
            url = "/index.jsp"; 
        }
        else {
            message = null;
            
            calculator.calculate(user);
            url = "/future.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("calculator", calculator);
        request.setAttribute("message", message);
        
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    

}

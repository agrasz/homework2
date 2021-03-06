/*Copyright Jack Landry and Lexa Grasz 2015*/

package graszlandry.controllers;

import graszlandry.business.Calculator;
import java.io.IOException;
import javax.servlet.http.HttpSession;
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
 * Controls interaction with three jsp pages. Mapped to the /calculate URL. 
 * Two methods, doGet and doPost, are written. 
 * The doGet method calls the doPost method.
 *
 * @author lexagrasz and Jack Landry
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

    


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
     * 
     * This method assigns 
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
        HttpSession session = request.getSession();
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
        
        
        session.setAttribute("user", user);
        session.setAttribute("calculator", calculator);
        session.setAttribute("message", message);
        
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    

}

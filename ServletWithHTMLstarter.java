index.html

<!DOCTYPE html>
<html>
    <head>
        <title>Your name here</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Welcome to the Gambling Casino! You must be 18 or older to play.</h1>
        
        <form action ="DemoServlet">
            <p> Name: <input type ="text" name ="userName"></p>
            <p><input type ="submit" value="login"></p>
            
        </form>
    </body>
</html>


////////////////////////////////////////////////////////////////////////////

package com.mycompany.webapplication1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

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
        String name = request.getParameter("userName");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>The Gambling Casino</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemoServlet at " + request.getContextPath() + "</h1>");
            out.println("Hello  " + name + "</p>");
            out.println(name + " Let's play a game.<p>  Guess a number from 1 to 10, " + name + "<p>");
            out.println(name + " If you guess higher than the computer, you WIN!<p>");
            
            out.println("<form action =\"GameServlet\">");
            out.println("<p> Guess: <input type =\"text\" name =\"guess\"></p>");
            out.println("<p><input type =\"submit\" value=\"game\"></p>");
            
        </form>
            
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


//////////////////////////////////////////////////////////

package com.mycompany.webapplication1;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {

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
        String guess = request.getParameter("guess");
        boolean PlayerWins = false;

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>The Gambling Casino</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<H1> Peanut's World Famous Gaming Casino!</h1>");
            out.println("Your Guess is  " + guess + "</p>");

            int computerGuess = ComputerGuess.generateComputerGuess();

            if (Integer.parseInt(guess) > computerGuess) {
                PlayerWins = true;
            }

            out.println("Computer Guess is  " + computerGuess +"</p>");

            if (PlayerWins == true) {
                out.println("Congratulations! You WIN!");
            } else {
                out.println("OUUCH! You LOSE!!!!");
            }

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

class ComputerGuess {

    static Random rand = new Random();

    static public int generateComputerGuess() {
        return rand.nextInt(10);
    }

}



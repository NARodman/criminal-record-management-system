package main.java.com.criminalrecords;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class UpdateCriminalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            //Get updated data from the form 
        String name = request.getParameter("name");
        String crimeCommitted = request.getParameter("crimeCommitted");
        String dateOfCrime = request.getParameter("dateOfCrime");
        String sentence = request.getParameter("sentence");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Criminal Record Updated:</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Crime: " + crimeCommitted + "</p>");
        out.println("<p>Date of Crime: " + dateOfCrime + "</p>");
        out.println("<p>Sentence: " + sentence + "</p>");
        out.println("</body></html>");
        }
    
}

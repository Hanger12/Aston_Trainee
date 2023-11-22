package aston.aston_trainee.ServiceServlet;

import aston.aston_trainee.ServiceServlet.DAO.BeerAndBreweriesOneToManyDAO;
import aston.aston_trainee.ServiceServlet.DAO.BeerReviewAndUsersManyToManyDAO;
import aston.aston_trainee.ServiceServlet.DTO.BeerAndBreweryDTO;
import aston.aston_trainee.ServiceServlet.DTO.BeerReviewAndUsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/OneToMany")
public class OneToManyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Hello
        BeerAndBreweriesOneToManyDAO beerAndBreweriesOneToManyDAO = new BeerAndBreweriesOneToManyDAO();
        ArrayList<BeerAndBreweryDTO> beerAndBreweryDTOS;
        try {
            beerAndBreweryDTOS = beerAndBreweriesOneToManyDAO.getAllBeerAndBrewery();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>All Beer and Brewery</h1><br>");
        out.println("<table border=\"1\"><thead>" +
                "<tr>" +
                "<th>beerName</th>" +
                "<th>breweryName</th>" +
                "<th>location</th>" +
                "</tr>" +
                "</thead><tbody>");
        for (BeerAndBreweryDTO beerAndBreweryDTO : beerAndBreweryDTOS) {
            out.println("<tr>");
            out.println("<td>"+ beerAndBreweryDTO.getBeerName()+ "</td>");
            out.println("<td>"+ beerAndBreweryDTO.getBreweryName()+ "</td>");
            out.println("<td>"+ beerAndBreweryDTO.getLocation()+ "</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</body></html>");
    }
}

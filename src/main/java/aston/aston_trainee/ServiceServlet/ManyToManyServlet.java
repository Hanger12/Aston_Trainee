package aston.aston_trainee.ServiceServlet;

import aston.aston_trainee.ServiceServlet.DAO.BeerReviewAndUsersManyToManyDAO;
import aston.aston_trainee.ServiceServlet.DTO.BeerReviewAndUsersDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/ManyToMany")
public class ManyToManyServlet extends HttpServlet {

    public void init() {

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Hello
        BeerReviewAndUsersManyToManyDAO beerReviewAndUsersManyToManyDAO = new BeerReviewAndUsersManyToManyDAO();
        ArrayList<BeerReviewAndUsersDTO> beerReviewAndUsersDTOArrayList;
        try {
            beerReviewAndUsersDTOArrayList = beerReviewAndUsersManyToManyDAO.getAllBeerReviewAndUsers();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>ALL Beer Review</h1><br>");
        out.println("<table border=\"1\"><thead>" +
                "<tr>" +
                "<th>beerName</th>" +
                "<th>breweryName</th>" +
                "<th>location</th>" +
                "<th>userName</th>" +
                "<th>reviewText</th>" +
                "<th>rating</th>" +
                "</tr>" +
                "</thead><tbody>");
        for (BeerReviewAndUsersDTO beerReviewAndUsersDTO : beerReviewAndUsersDTOArrayList) {
            out.println("<tr>");
            out.println("<td>"+ beerReviewAndUsersDTO.getBeerName()+ "</td>");
            out.println("<td>"+ beerReviewAndUsersDTO.getBreweryName()+ "</td>");
            out.println("<td>"+ beerReviewAndUsersDTO.getLocation()+ "</td>");
            out.println("<td>"+ beerReviewAndUsersDTO.getUserName()+ "</td>");
            out.println("<td>"+ beerReviewAndUsersDTO.getReviewText()+ "</td>");
            out.println("<td>"+ beerReviewAndUsersDTO.getRating()+ "</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}

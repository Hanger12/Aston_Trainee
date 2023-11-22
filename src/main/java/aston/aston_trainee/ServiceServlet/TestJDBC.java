package aston.aston_trainee.ServiceServlet;

import aston.aston_trainee.ServiceServlet.DAO.BeerReviewAndUsersManyToManyDAO;
import aston.aston_trainee.ServiceServlet.DAO.BreweriesDAO;
import aston.aston_trainee.ServiceServlet.DTO.BeerReviewAndUsersDTO;
import aston.aston_trainee.ServiceServlet.Entity.Breweries;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BreweriesDAO breweriesDAO = new BreweriesDAO();
        BeerReviewAndUsersManyToManyDAO beerReviewAndUsersManyToManyDAO = new BeerReviewAndUsersManyToManyDAO();
        for(BeerReviewAndUsersDTO object : beerReviewAndUsersManyToManyDAO.getAllBeerReviewAndUsers()) {
            System.out.println(object);
        }
        System.out.println(beerReviewAndUsersManyToManyDAO.getBeerReviewAndUsersByBeerName("Моспиво"));
    }
}

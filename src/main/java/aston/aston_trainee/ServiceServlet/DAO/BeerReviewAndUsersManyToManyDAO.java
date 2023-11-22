package aston.aston_trainee.ServiceServlet.DAO;

import aston.aston_trainee.ServiceServlet.ConnectionToDataBase;
import aston.aston_trainee.ServiceServlet.DTO.BeerAndBreweryDTO;
import aston.aston_trainee.ServiceServlet.DTO.BeerReviewAndUsersDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BeerReviewAndUsersManyToManyDAO {

    public ArrayList<BeerReviewAndUsersDTO> getAllBeerReviewAndUsers() throws SQLException, ClassNotFoundException {
        ArrayList<BeerReviewAndUsersDTO> beerReviewAndUsersDTOS = new ArrayList<>();
        Statement statement = ConnectionToDataBase.GetConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("" +
                "select b2.beername,b3.breweryname,b3.location,u.username, b.reviewtext, b.rating " +
                "from userreviews " +
                "join public.beerreviews b on userreviews.reviewid = b.reviewid " +
                "join public.users u on userreviews.userid = u.userid " +
                "join public.beer b2 on b2.beerid = b.beerid " +
                "join public.breweries b3 on b3.breweryid = b2.breweryid");
        while (resultSet.next()) {
            String beerName = resultSet.getString(1);
            String breweryName = resultSet.getString(2);
            String location = resultSet.getString(3);
            String userName = resultSet.getString(4);
            String reviewText = resultSet.getString(5);
            int rating = resultSet.getInt(6);
            beerReviewAndUsersDTOS.add(new BeerReviewAndUsersDTO(beerName,breweryName,location,userName,reviewText,rating));
        }
        //statement.close();
        return beerReviewAndUsersDTOS;
    }
    public ArrayList<BeerReviewAndUsersDTO> getBeerReviewAndUsersByBeerName (String BeerName) throws SQLException, ClassNotFoundException {
        ArrayList<BeerReviewAndUsersDTO> beerReviewAndUsersDTOS = new ArrayList<>();
        final String FIND_REVIEW_AND_USERS = "" +
                "select b2.beername,b3.breweryname,b3.location,u.username, b.reviewtext, b.rating " +
                "from userreviews " +
                "join public.beerreviews b on userreviews.reviewid = b.reviewid " +
                "join public.users u on userreviews.userid = u.userid " +
                "join public.beer b2 on b2.beerid = b.beerid " +
                "join public.breweries b3 on b3.breweryid = b2.breweryid where beername = ?";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(FIND_REVIEW_AND_USERS);
        statement.setString(1,BeerName);
        BeerReviewAndUsersDTO beerReviewAndUsersDTO = null;
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String beerName = resultSet.getString(1);
            String breweryName = resultSet.getString(2);
            String location = resultSet.getString(3);
            String userName = resultSet.getString(4);
            String reviewText = resultSet.getString(5);
            int rating = resultSet.getInt(6);
            beerReviewAndUsersDTOS.add(new BeerReviewAndUsersDTO(beerName,breweryName,location,userName,reviewText,rating));
        }
        statement.close();
        return beerReviewAndUsersDTOS;
    }
}

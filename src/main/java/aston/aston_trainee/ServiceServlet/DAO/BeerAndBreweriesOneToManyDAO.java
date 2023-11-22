package aston.aston_trainee.ServiceServlet.DAO;

import aston.aston_trainee.ServiceServlet.ConnectionToDataBase;
import aston.aston_trainee.ServiceServlet.DTO.BeerAndBreweryDTO;
import aston.aston_trainee.ServiceServlet.Entity.Breweries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BeerAndBreweriesOneToManyDAO {
    public ArrayList<BeerAndBreweryDTO> getAllBeerAndBrewery() throws SQLException, ClassNotFoundException {
        ArrayList<BeerAndBreweryDTO> beerAndBreweryDTOS = new ArrayList<>();
        Statement statement = ConnectionToDataBase.GetConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select beername,breweryname,location " +
                "from breweries join public.beer b " +
                "on breweries.breweryid = b.breweryid where beerid <= 20");
        while (resultSet.next()) {
            String beerName = resultSet.getString(1);
            String breweryName = resultSet.getString(2);
            String location = resultSet.getString(3);
            beerAndBreweryDTOS.add(new BeerAndBreweryDTO(beerName,breweryName,location));
        }
        statement.close();
        return beerAndBreweryDTOS;
    }
    public ArrayList<BeerAndBreweryDTO> getBeerAndBreweryByBeerName (String BeerName) throws SQLException, ClassNotFoundException {
        ArrayList<BeerAndBreweryDTO> beerAndBreweryDTOS = new ArrayList<>();
        final String FIND_BEER_AND_BREWERY = "select beername,breweryname,location " +
                "from breweries join public.beer b" +
                " on breweries.breweryid = b.breweryid where beername = ?";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(FIND_BEER_AND_BREWERY);
        statement.setString(1,BeerName);
        BeerAndBreweryDTO beerAndBreweryDTO = null;
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String beerName = resultSet.getString(1);
            String breweryName = resultSet.getString(2);
            String location = resultSet.getString(3);
            beerAndBreweryDTOS.add(new BeerAndBreweryDTO(beerName,breweryName,location));
        }
        statement.close();
        return beerAndBreweryDTOS;
    }
}

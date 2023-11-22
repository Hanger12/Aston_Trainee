package aston.aston_trainee.ServiceServlet.DAO;

import aston.aston_trainee.ServiceServlet.ConnectionToDataBase;
import aston.aston_trainee.ServiceServlet.Entity.Breweries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BreweriesDAO {
    public ArrayList<Breweries> getAllBreweries() throws SQLException, ClassNotFoundException {
        ArrayList<Breweries> breweries = new ArrayList<>();
        Statement statement = ConnectionToDataBase.GetConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from breweries");
        while (resultSet.next()) {
            long id = resultSet.getInt(1);
            String breweryName = resultSet.getString(2);
            String location = resultSet.getString(3);
            breweries.add(new Breweries(id,breweryName,location));
        }
        return breweries;
    }
    public Breweries getBreweriesById (long breweryId) throws SQLException, ClassNotFoundException {
        final String FIND_BREWERY = "SELECT * FROM breweries WHERE breweryId = ?";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(FIND_BREWERY);
        statement.setInt(1,(int) breweryId);
        Breweries breweries = null;
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            long id = resultSet.getInt(1);
            String breweryName = resultSet.getString(2);
            String location = resultSet.getString(3);
            breweries = new Breweries(id,breweryName,location);
        }
        return breweries;
    }
    public void addBrewery (String breweryName,String location) throws SQLException, ClassNotFoundException {
        final String NEW_BREWERY = "INSERT INTO breweries (breweryname,location) VALUES (?,?)";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(NEW_BREWERY);
        statement.setString(1,breweryName);
        statement.setString(2,location);
        if (statement.execute()) {
            System.out.println("Пивоварня стоит, значит пиву быть!!");
        }
    }
}

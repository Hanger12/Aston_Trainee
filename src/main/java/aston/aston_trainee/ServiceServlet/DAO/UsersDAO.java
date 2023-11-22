package aston.aston_trainee.ServiceServlet.DAO;

import aston.aston_trainee.ServiceServlet.ConnectionToDataBase;
import aston.aston_trainee.ServiceServlet.Entity.Breweries;
import aston.aston_trainee.ServiceServlet.Entity.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDAO {
    public ArrayList<Users> getAllUsers() throws SQLException, ClassNotFoundException {
        ArrayList<Users> users = new ArrayList<>();
        Statement statement = ConnectionToDataBase.GetConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            long id = resultSet.getInt(1);
            String userName = resultSet.getString(2);
            String email = resultSet.getString(3);
            users.add(new Users(id,userName,email));
        }
        statement.close();
        return users;
    }
    public Users getUsersById (long userId) throws SQLException, ClassNotFoundException {
        final String FIND_USERS = "SELECT * FROM users WHERE userid = ?";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(FIND_USERS);
        statement.setInt(1,(int) userId);
        Users users = null;
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            long id = resultSet.getInt(1);
            String userName = resultSet.getString(2);
            String email = resultSet.getString(3);
            users = new Users(id,userName,email);
        }
        statement.close();
        return users;
    }
    public void addUser (String userName,String email) throws SQLException, ClassNotFoundException {
        final String NEW_USER = "INSERT INTO users (username,email) VALUES (?,?)";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(NEW_USER);
        statement.setString(1,userName);
        statement.setString(2,email);
        if (statement.execute()) {
            System.out.println("Пользователь добвлен");
        }
    }
    public void deleteUserByID (long userId) throws SQLException, ClassNotFoundException {
        final String DELETE_USER = "DELETE FROM users WHERE breweryId = ?";
        PreparedStatement statement = ConnectionToDataBase.GetConnection().prepareStatement(DELETE_USER);
        statement.setInt(1,(int) userId);
        if (statement.execute()) {
            System.out.println("Пользователь удален");
        }
    }
}

package dao;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<User>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM USER_Ly";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setFavourites(rs.getString("FAVOURITES"));
                user.setRole(rs.getString("ROLE"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
  
    public User getUserById(int id) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM USER_Ly WHERE ID=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setFavourites(rs.getString("FAVOURITES"));
                user.setRole(rs.getString("ROLE"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
     }   

    public void addUser(User user) throws SQLException {

       Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO USER_Ly(NAME, PHONE, USERNAME, PASSWORD, ABOUT, FAVOURITES, ROLE) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getFavourites());
            preparedStatement.setString(7, user.getRole());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void updateUser(User user) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "UPDATE USER SET NAME = ?,PHONE = ?,USERNAME = ?,PASSWORD = ?,ABOUT = ?,FAVOURITES = ?,ROLE = ? WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getFavourites());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setInt(8, user.getId());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(int id) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM USER_Ly WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


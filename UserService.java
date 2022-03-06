package service;

import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserService {
    private UserDao userDao;
    
    public UserService() {
        userDao = new UserDao();
    }
    
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    public void addUser(User user){
        try {
            userDao.addUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteUser(int id){
        try {
            userDao.deleteUser(id);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User getUserById(int id) throws SQLException{
        return userDao.getUserById(id);
    }
    public void updateUser(User user) throws SQLException{
        userDao.updateUser(user);
    }
}

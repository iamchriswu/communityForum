package wt.dao;

import wt.model.User;
import wt.tools.MD5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public static User login(String DB_USER, String DB_PASS, String userName, String password) {
        String sql="SELECT * FROM uauthenticationinfo WHERE uAccount = ? AND uPassword = ?";
        User user = null;
        Connection connection = null;

        try {
            connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, MD5.md5(password));
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setuAccount(userName);
                user.setuPassword(password);
            }
            rs.close();
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBDao.closeConnection(connection);
        }
        return user;
    }

    public static boolean register(String DB_USER, String DB_PASS, String userName, String password) {
        String selectSql = "SELECT * FROM uauthenticationinfo WHERE uAccount=?";
        String sql = "INSERT INTO uauthenticationinfo VALUES (?,?)";
        boolean isFind = false;
        boolean isSuccess = false;

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isFind = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!isFind) {
            try {
                Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,userName);
                statement.setString(2, MD5.md5(password));
                statement.executeUpdate();
                isSuccess = true;
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

}

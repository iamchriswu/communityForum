package wt.dao;

import wt.model.DateModel;
import wt.model.RankByGoldComparator;
import wt.model.User;
import wt.model.UserInfo;
import wt.tools.MD5;

import java.sql.*;
import java.util.Collections;
import java.util.Vector;

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
        String insertSql_ua = "INSERT INTO uauthenticationinfo VALUES (?,?)";
        String insertSql_u = "INSERT INTO uinfo VALUES (?,?,?,?,?)";

        boolean isFind = false;
        boolean isSuccess = false;
        final int gold = 50;

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

                PreparedStatement statement_ua = connection.prepareStatement(insertSql_ua);
                statement_ua.setString(1,userName);
                statement_ua.setString(2, MD5.md5(password));
                statement_ua.executeUpdate();
                statement_ua.close();

                PreparedStatement statement_u = connection.prepareStatement(insertSql_u);
                statement_u.setString(1, userName);
                statement_u.setString(2, MD5.md5(userName) + DateModel.curNumTime() + "");
                statement_u.setString(3, DateModel.curTime());
                statement_u.setString(4, String.valueOf(gold));
                statement_u.setString(5,null);
                statement_u.executeUpdate();
                statement_u.close();

                connection.close();
                isSuccess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    public static UserInfo getUserInfo (String DB_USER, String DB_PASS, String userName) {
        String sql = "SELECT * FROM uinfo WHERE uAccount=?";
        UserInfo userInfo = new UserInfo();

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userInfo.setuAccount(rs.getString(1));
                userInfo.setuID(rs.getString(2));
                userInfo.setuRegisterTime(rs.getString(3));
                userInfo.setuGold(rs.getInt(4));
                userInfo.setuSeleEvaluation(rs.getString(5));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public static boolean selfEvalustion (String DB_USER, String DB_PASS, String userName, String evaluationContent) {
        String sql = "UPDATE uinfo SET uSelfEvaluation=? WHERE uAccount=?";
        boolean isSuccess = false;

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,evaluationContent);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            isSuccess = true;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public static boolean reward (String DB_USER, String DB_PASS, String rewardUser, String rewardedUser) {
        String sql1 = "SELECT uGold FROM uinfo WHERE uAccount=?";
        String sql2 = "UPDATE uinfo SET uGold = uGold - 3 WHERE uAccount=?";
        String sql3 = "UPDATE uinfo SET uGold = uGold + 3 WHERE uAccount=?";
        boolean isSuccess = false;

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1,rewardUser);
            ResultSet rs = preparedStatement1.executeQuery();
            while (rs.next()) {
                int gold = rs.getInt(1);
                if (gold > 3) {
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                    preparedStatement2.setString(1,rewardUser);
                    preparedStatement2.executeUpdate();
                    preparedStatement2.close();
                    PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
                    preparedStatement3.setString(1,rewardedUser);
                    preparedStatement3.executeUpdate();
                    preparedStatement3.close();
                    isSuccess = true;
                }
            }
            rs.close();
            preparedStatement1.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public static boolean modityPassword (String DB_USER, String DB_PASS, String userName, String password) {
        String sql = "UPDATE uauthenticationinfo SET uPassword=? WHERE uAccount=?";
        boolean isSuccess = false;

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MD5.md5(password));
            preparedStatement.setString(2, userName);
            preparedStatement.executeUpdate();
            isSuccess = true;
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public static Vector<UserInfo> rankByGold (String DB_USER, String DB_PASS) {
        String sql = "SELECT * FROM uinfo";
        Vector<UserInfo> userInfos = new Vector<>();

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userInfos.add(getUser(rs));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(userInfos, new RankByGoldComparator());
        return userInfos;
    }

    public static UserInfo getUser(ResultSet rs) {
        UserInfo userInfo = new UserInfo();
        try {
            userInfo.setuAccount(rs.getString(1));
            userInfo.setuID(rs.getString(2));
            userInfo.setuRegisterTime(rs.getString(3));
            userInfo.setuGold(rs.getInt(4));
            userInfo.setuSeleEvaluation(rs.getString(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

}

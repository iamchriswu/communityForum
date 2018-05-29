package wt.dao;

import wt.model.Command;
import wt.model.DateModel;
import wt.tools.MD5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class CommandDao {
    public static Command publish(String DB_USER, String DB_PASS, String userName, String commandContent) {
        String sql = "INSERT INTO ucommandlondon VALUES (?,?,?,?)";
        Command command = new Command();
        DateModel dateModel = new DateModel();
        boolean isSuccess = false;

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2, dateModel.curTime());
            preparedStatement.setString(3, MD5.md5(userName + dateModel.curNumTime() + ""));
            preparedStatement.setString(4, commandContent);
            preparedStatement.executeUpdate();
            isSuccess = true;
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isSuccess) {
            command.setuAccount(userName);
            command.setuCommandTime(dateModel.curTime());
            command.setuCommandID(userName + dateModel.curNumTime() + "");
            command.setuCommandContent(commandContent);
        }
        return command;
    }

    public static Vector<Command> commands (String DB_USER, String DB_PASS) {
        String sql = "SELECT * FROM ucommandlondon";
        Vector<Command> commands = new Vector<>();

        try {
            Connection connection = DBDao.getConnection(DB_USER, DB_PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Command command = new Command();
                command.setuAccount(rs.getString(1));
                command.setuCommandTime(rs.getString(2));
                command.setuCommandID(rs.getString(3));
                command.setuCommandContent(rs.getString(4));
                commands.add(command);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commands;
    }
}

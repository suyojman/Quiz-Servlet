package com.deerwalk.service;

import com.deerwalk.model.Question;
import com.deerwalk.model.Role;
import com.deerwalk.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/30/2017.
 */
public class UserService {

    public User getUser(String email, String password) {
        User user1 = null;
        Dbconnection dbconnection = new Dbconnection();
        Connection connection = dbconnection.getDbconnection();

        String sql = "SELECT * from user where Email=? and Password=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            boolean val = preparedStatement.execute();
            if (val) {
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String email1 = resultSet.getString("Email");
                    String password1 = resultSet.getString("Password");
                    String name=resultSet.getString("Name");
                    user1 = new User();
                    user1.setId(id);
                    user1.setEmail(email1);
                    user1.setPassword(password1);
                    user1.setName(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user1;
    }

    public boolean registerUser(User user) {

        boolean isSucess=false;
        Dbconnection dbconnection = new Dbconnection();
        Connection connection = dbconnection.getDbconnection();

        String sql = "INSERT  INTO user(Name,Email,Password)Values(?,?,?)";


        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            int affected_rows = preparedStatement.executeUpdate();

            if(affected_rows>0){
                isSucess=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

return isSucess;
    }

    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();
        Dbconnection dbconnection = new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT * FROM user";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

           while (resultSet.next()){
               int id=resultSet.getInt("id");
               String name = resultSet.getString("Name");
               String email = resultSet.getString("Email");
               String password = resultSet.getString("Password");

               User user=new User();
               user.setId(id);
               user.setName(name);
               user.setEmail(email);
               user.setPassword(password);

               userList.add(user);

           }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  userList;
    }
    public boolean deleteUser(String id){
        boolean isSucess=false;

        Dbconnection dbconnection=new Dbconnection();
        Connection connection=dbconnection.getDbconnection();
        System.out.println("DB CONNECTED!!");

        String sql="DELETE FROM user WHERE id=? ";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(id));
            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0){
                isSucess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         return isSucess;
    }

    public User editUser(String id){
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT * FROM user where id=?";
        User user = null;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            boolean val=preparedStatement.execute();

            if(val){
                ResultSet resultSet=preparedStatement.getResultSet();

                while (resultSet.next()){
                    int id1=resultSet.getInt("id");
                    String name=resultSet.getString("Name");
                    System.out.println("editusergetconsole: "+name);
                    String email=resultSet.getString("Email");
                    String password=resultSet.getString("Password");

                    user =new User();
                    user.setId(id1);
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(password);
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



        return user;
    }
    public boolean updateUser(User user) {
        boolean isSucess=false;
        Dbconnection dbconnection=new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="UPDATE user set Name=?,Email=?,Password=? where id=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4, user.getId());

            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0){
                isSucess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSucess;
    }

    public void removeUserResult(int id) {
        Dbconnection dbconnection=new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="delete from result where user_id =?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User getUserByEmail(String email) {
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT * FROM user where email=?";
        User user = null;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            boolean val=preparedStatement.execute();

            if(val){
                ResultSet resultSet=preparedStatement.getResultSet();

                while (resultSet.next()){
                    int id1=resultSet.getInt("id");
                    String name=resultSet.getString("Name");
                    String emails=resultSet.getString("Email");
                    String password=resultSet.getString("Password");

                    user =new User();
                    user.setId(id1);
                    user.setName(name);
                    user.setEmail(emails);
                    user.setPassword(password);
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



        return user;
    }

    public void insertRole(int id) {
        Dbconnection dbconnection=new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="insert into role(user_id,role) values(?,?)";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "user");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Role getUserRole(int id) {
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT * FROM role  where user_id=?";
        Role role = null;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            boolean val=preparedStatement.execute();

            if(val){
                ResultSet resultSet=preparedStatement.getResultSet();

                while (resultSet.next()){
                    int userId = resultSet.getInt("user_id");
                    String rol = resultSet.getString("role");

                    role = new Role();
                    role.setUser_id(userId);
                    role.setRole(rol);


                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



        return role;

    }
}



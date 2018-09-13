package com.deerwalk.controller;

import com.deerwalk.model.Question;
import com.deerwalk.model.Role;
import com.deerwalk.model.User;
import com.deerwalk.service.Dbconnection;
import com.deerwalk.service.QuestionService;
import com.deerwalk.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 10/30/2017.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        System.out.println(page);
        if (page.equalsIgnoreCase("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new UserService().getUser(email, password);
            if (user != null) {
                new UserService().removeUserResult(user.getId());

                HttpSession session = request.getSession();
                session.setAttribute("user",user);

                Role role = new UserService().getUserRole(user.getId());

                session.setAttribute("r",role);

                request.setAttribute("u",user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } /*else {
                PrintWriter writer = response.getWriter();
                writer.write("<br>");
                writer.write("Please Enter the correct email and password!!");

            }*/
        } else if (page.equalsIgnoreCase("register")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (name != null && email != null && password != null) {

                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setName(name);

                boolean isSucess = new UserService().registerUser(user);

                if (isSucess) {

                    User user1 = new UserService().getUserByEmail(email);
                    new UserService().insertRole(user1.getId());

                    Role role= new UserService().getUserRole(user1.getId());
                    request.setAttribute("r",role);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/dashboard.jsp");
                    requestDispatcher.forward(request, response);

                }

            } else {
                PrintWriter writer = response.getWriter();
                writer.write("Some information missing");
            }

        } else if (page.equalsIgnoreCase("adduser")) {
            String name1 = request.getParameter("name");
            String email1 = request.getParameter("email");
            String password1 = request.getParameter("password");

            User user = new User();
            user.setName(name1);
            user.setEmail(email1);
            user.setPassword(password1);

            boolean isSucess = new UserService().registerUser(user);

            if (isSucess) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/userList.jsp");
                requestDispatcher.forward(request, response);

            }

        } else if (page.equalsIgnoreCase("edituser")) {

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User();
            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            boolean isSucess = new UserService().updateUser(user);
            if (isSucess) {
                List<User> userList = new UserService().getUserList();

                request.setAttribute("user", userList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/userList.jsp");
                requestDispatcher.forward(request, response);
            }


        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String page=request.getParameter("page");
        if(page.equalsIgnoreCase("createuser")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/addUser.jsp");
            requestDispatcher.forward(request,response);
        }else if(page.equalsIgnoreCase("userlist")){
            List<User> userList = new UserService().getUserList();
            System.out.println(userList.size());
            request.setAttribute("user", userList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/userList.jsp");
            requestDispatcher.forward(request, response);

        }else if(page.equalsIgnoreCase("deleteuser")){
            String id=request.getParameter("id");
            Boolean user=new UserService().deleteUser(id);



            List<User> userList = new UserService().getUserList();
            System.out.println(userList.size());
            request.setAttribute("user",userList);

            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/userList.jsp");
            requestDispatcher.forward(request,response);
        }else if (page.equalsIgnoreCase("edituser")){
            String id=request.getParameter("id");
            User user = new UserService().editUser(id);

            if (user != null) {
                request.setAttribute("q", user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/editUser.jsp");
                requestDispatcher.forward(request, response);
            }

        }else if(page.equalsIgnoreCase("logout")){
            HttpSession session=request.getSession();
            if(session!=null){
                session.invalidate();
            }
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }else if(page.equalsIgnoreCase("home")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/dashboard.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}

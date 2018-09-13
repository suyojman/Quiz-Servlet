package com.deerwalk.controller;

import com.deerwalk.model.Question;
import com.deerwalk.model.Result;
import com.deerwalk.model.User;
import com.deerwalk.service.Dbconnection;
import com.deerwalk.service.QuestionService;
import com.deerwalk.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 10/31/2017.
 */
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("question")) {
            String question1 = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctAnswer = request.getParameter("correct_answer");
            String category = request.getParameter("category");

            Question question = new Question();
            question.setQuestion(question1);
            question.setOption1(option1);
            question.setOption2(option2);
            question.setOption3(option3);
            question.setOption4(option4);
            question.setCorrectAnswer(correctAnswer);
            question.setCategory(category);

            boolean isSucess = new QuestionService().addQuestion(question);

            if (isSucess) {
                List<Question> questionList = new QuestionService().getQuestionList();
                System.out.println(questionList.size());
                request.setAttribute("questions", questionList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/list.jsp");
                requestDispatcher.forward(request, response);

            }

        }
        else if(page.equalsIgnoreCase("editquestion")){
            String id=request.getParameter("ID");
            String question1 = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctAnswer = request.getParameter("correct_answer");
            String category = request.getParameter("category");

            Question question = new Question();
            question.setId(Integer.parseInt(id));
            question.setQuestion(question1);
            question.setOption1(option1);
            question.setOption2(option2);
            question.setOption3(option3);
            question.setOption4(option4);
            question.setCorrectAnswer(correctAnswer);
            question.setCategory(category);

            boolean isSucess = new QuestionService().updateQuestion(question);
            if(isSucess){
                List<Question> questionList = new QuestionService().getQuestionList();
                System.out.println(questionList.size());
                request.setAttribute("questions", questionList);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/list.jsp");
                requestDispatcher.forward(request,response);
            }

        }else if(page.equalsIgnoreCase("playquiz")){
//            String timeTaken=request.getParameter("second");
//            System.out.println("timeTaken = " + timeTaken);
            String id = request.getParameter("id");
            String correctAns = request.getParameter("correct_answer");
            String checkedAns = request.getParameter("option");
            String timeTaken=request.getParameter("second");
            String category=request.getParameter("category");
            User user = (User) request.getSession().getAttribute("user");
            System.out.println(timeTaken);

            System.out.println("--------"+user.getId());

            if (checkedAns==null){
                new QuestionService().storeResult(Integer.parseInt(id),user.getId(),0,5);
//                new QuestionService().storeResult(Integer.parseInt(id),user.getId(),0,Integer.parseInt(timeTaken));
            }else {

                if (checkedAns.equalsIgnoreCase(correctAns)) {
//                    new QuestionService().storeResult(Integer.parseInt(id), user.getId(), 5, Integer.parseInt(timeTaken));
                    new QuestionService().storeResult(Integer.parseInt(id), user.getId(), 5, 5);
                } else {
                    new QuestionService().storeResult(Integer.parseInt(id), user.getId(), 0, 5);
//                    new QuestionService().storeResult(Integer.parseInt(id), user.getId(), 0, Integer.parseInt(timeTaken));
                }
            }
            List<Result> resultList = new QuestionService().getQuestionAlreadyPlayed(user.getId());

            Question question = new QuestionService().getQuestionUserNotPlayed(resultList,category);

            if(question!=null){
                request.setAttribute("q",question);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/playQuiz.jsp");
                requestDispatcher.forward(request,response);
            }else{

                List<Result> result = new QuestionService().getUserResult(user.getId());
                request.setAttribute("result",result);

                new QuestionService().deleteResultList(user.getId());
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/result.jsp");
                requestDispatcher.forward(request,response);
            }



        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");


        if (page.equalsIgnoreCase("createquestion")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/createQuestion.jsp");
            requestDispatcher.forward(request, response);

        }
        else if (page.equalsIgnoreCase("questionlist")) {
            List<Question> questionList = new QuestionService().getQuestionList();
            System.out.println(questionList.size());
            request.setAttribute("questions", questionList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/list.jsp");
            requestDispatcher.forward(request, response);
        }
       else if (page.equalsIgnoreCase("editquestion")) {
            String id = request.getParameter("id");
            Question question1 = new QuestionService().editQuestion(id);

            if (question1 != null) {
                request.setAttribute("q", question1);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/html/editQuestion.jsp");
                requestDispatcher.forward(request, response);
            }
        }

            else if(page.equalsIgnoreCase("deletequestion")){
              String id=request.getParameter("id");
            Boolean question1= new QuestionService().deleteQuestion(id);
            if(question1=true){

            }

          }else if(page.equalsIgnoreCase("playquiz")){
            String category=request.getParameter("category");
            System.out.println(category);
            Question question= new  QuestionService().getRandomQuestion(category);
            request.setAttribute("q",question);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/playQuiz.jsp");
            requestDispatcher.forward(request,response);
        }else if(page.equalsIgnoreCase("category")){

            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/html/category.jsp");
            requestDispatcher.forward(request,response);

        }



    }
}

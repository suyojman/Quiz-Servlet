package com.deerwalk.service;


import com.deerwalk.model.Question;
import com.deerwalk.model.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/31/2017.
 */
public class QuestionService {

    public boolean addQuestion(Question question){

        boolean isSucess = false;
        Dbconnection dbconnection = new Dbconnection();
        Connection connection = dbconnection.getDbconnection();

        String sql = "INSERT INTO question(question,option1,option2,option3,option4,correct_answer,category)VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getOption1());
            preparedStatement.setString(3,question.getOption2());
            preparedStatement.setString(4,question.getOption3());
            preparedStatement.setString(5,question.getOption4());
            preparedStatement.setString(6,question.getCorrectAnswer());
            preparedStatement.setString(7,question.getCategory());
            int affectedRows= preparedStatement.executeUpdate();

            if(affectedRows>0){
                isSucess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSucess;
    }

    public List<Question> getQuestionList(){

        List<Question> arrayList = new ArrayList<Question>();
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT * FROM question";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("ID");
                String question=resultSet.getString("question");
                String option1=resultSet.getString("option1");
                String option2=resultSet.getString("option2");
                String option3=resultSet.getString("option3");
                String option4=resultSet.getString("option4");
                String correctAnwer=resultSet.getString("correct_answer");
                String category=resultSet.getString("category");

                Question question1= new Question();
                question1.setQuestion(question);
                question1.setId(id);
                question1.setOption1(option1);
                question1.setOption2(option2);
                question1.setOption3(option3);
                question1.setOption4(option4);
                question1.setCorrectAnswer(correctAnwer);
                question1.setCategory(category);

                arrayList.add(question1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
return arrayList;
    }

    public Question editQuestion(String id){
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT * FROM question where id=?";
        Question question1=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(id));
             Boolean val=preparedStatement.execute();

            ResultSet resultSet=preparedStatement.getResultSet();



            while (resultSet.next()){
                int id1=resultSet.getInt("ID");
                String question=resultSet.getString("question");
                String option1=resultSet.getString("option1");
                String option2=resultSet.getString("option2");
                String option3=resultSet.getString("option3");
                String option4=resultSet.getString("option4");
                String correctAnswer=resultSet.getString("correct_answer");
                String category=resultSet.getString("category");

                question1 = new Question();
                question1.setQuestion(question);
                question1.setId(id1);
                question1.setOption1(option1);
                question1.setOption2(option2);
                question1.setOption3(option3);
                question1.setOption4(option4);
                question1.setCorrectAnswer(correctAnswer);
                question1.setCategory(category);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question1;
    }

    public boolean deleteQuestion(String id){
        boolean isSucess = false;
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();
        String sql="DELETE FROM question WHERE id=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(id));
           int affectedRows= preparedStatement.executeUpdate();
            if(affectedRows>0){
                isSucess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSucess;
    }

    public boolean updateQuestion(Question question) {
        boolean isSucess=false;
        Dbconnection dbconnection=new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="UPDATE question set question=?,option1=?,option2=?,option3=?,option4=?,correct_answer=?,category=? where id=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getOption1());
            preparedStatement.setString(3,question.getOption2());
            preparedStatement.setString(4,question.getOption3());
            preparedStatement.setString(5,question.getOption4());
            preparedStatement.setString(6,question.getCorrectAnswer());
            preparedStatement.setString(7,question.getCategory());
            preparedStatement.setInt(8, question.getId());
            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0){
                isSucess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSucess;
    }
    public Question getRandomQuestion(String category){
        Question question1=null;
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT *FROM question where category=? limit 1";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,category);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("ID");
                String question2=resultSet.getString("question");
                String option1=resultSet.getString("option1");
                String option2=resultSet.getString("option2");
                String option3=resultSet.getString("option3");
                String option4=resultSet.getString("option4");
                String correctAnwer=resultSet.getString("correct_answer");
                String category1=resultSet.getString("category");

                question1= new Question();
                question1.setQuestion(question2);
                question1.setId(id);
                question1.setOption1(option1);
                question1.setOption2(option2);
                question1.setOption3(option3);
                question1.setOption4(option4);
                question1.setCorrectAnswer(correctAnwer);
                question1.setCategory(category1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question1;
    }



    public void storeResult(int qid, int uid, int mks,int timeTaken) {
        Dbconnection dbconnection = new Dbconnection();
        Connection connnection=dbconnection.getDbconnection();

        String sql = "Insert into result(question_id,user_id,marks,time_taken)Values(?,?,?,?)";

        try {
            PreparedStatement preparedStatement=connnection.prepareStatement(sql);
            preparedStatement.setInt(1,qid);
            preparedStatement.setInt(2,uid);
            preparedStatement.setInt(3,mks);
            preparedStatement.setInt(4,timeTaken);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Result> getQuestionAlreadyPlayed(int id) {
        List<Result> results = new ArrayList<Result>();
        Dbconnection dbconnection= new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="SELECT *from result where user_id=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            boolean val=preparedStatement.execute();
            if(val){
                ResultSet resultSet=preparedStatement.getResultSet();
                while (resultSet.next()){
                    int id1=resultSet.getInt("id");
                    int uid=resultSet.getInt("user_id");
                    int qid=resultSet.getInt("question_id");
                    int marks=resultSet.getInt("marks");
                    int timeTaken=resultSet.getInt("time_taken");

                    Result result= new Result();
                    result.setId(id1);
                    result.setUserId(uid);
                    result.setQuestionId(qid);
                    result.setMarks(marks);
                    result.setTimeTaken(timeTaken);

                    results.add(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public Question getQuestionUserNotPlayed(List<Result> resultList,String category) {
        Question question1=null;
        String param ="";

        for(int i=0;i<resultList.size();i++){
            param+="?";

            if(resultList.size()-1 ==i){
                break;
            }else{
                param += ",";
            }
        }

        System.out.println(resultList.size());
        System.out.println(param);

        String sql = "select * from question where id not in ("+param+")and category=? limit 1";

        Dbconnection dbconnection = new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            int index = 1;
            for(Result result:resultList){
                preparedStatement.setInt(index++,result.getQuestionId());
                System.out.println(index);
            }
            preparedStatement.setString(index,category);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("ID");
                String question=resultSet.getString("question");
                String option1=resultSet.getString("option1");
                String option2=resultSet.getString("option2");
                String option3=resultSet.getString("option3");
                String option4=resultSet.getString("option4");
                String correctAnswer=resultSet.getString("correct_answer");
                String category1=resultSet.getString("category");

                System.out.println("question is : "+ question);

                question1= new Question();
                question1.setId(id);
                question1.setQuestion(question);
                question1.setOption1(option1);
                question1.setOption2(option2);
                question1.setOption3(option3);
                question1.setOption4(option4);
                question1.setCorrectAnswer(correctAnswer);
                question1.setCategory(category1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question1;
    }

    public List<Result> getUserResult(int id) {
        List<Result> userResult = new ArrayList<Result>();
        Dbconnection dbconnection=new Dbconnection();
        Connection connection=dbconnection.getDbconnection();

        String sql="Select *from result where user_id=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                int id1=resultSet.getInt("id");
                int uid=resultSet.getInt("user_id");
                int qid=resultSet.getInt("question_id");
                int marks=resultSet.getInt("marks");
                int timeTaken=resultSet.getInt("time_taken");

                Result result= new Result();
                result.setId(id1);
                result.setUserId(uid);
                result.setMarks(marks);
                result.setQuestionId(qid);
                result.setTimeTaken(timeTaken);

                userResult.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userResult;
    }

    public  boolean deleteResultList(int id) {
        boolean isSucess = false;
       Dbconnection dbconnection=new Dbconnection();
       Connection connection=dbconnection.getDbconnection();

        String sql="Delete from result where user_id=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int affectedRows= preparedStatement.executeUpdate();
            if(affectedRows>0){
                isSucess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSucess;

    }
}

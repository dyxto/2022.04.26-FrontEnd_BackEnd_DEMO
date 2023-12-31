/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MySQLConnection;

/**
 *
 * @author bootcamp
 */
public class StudentAccount implements Serializable {
    String StudentID;
    String StudentPassword;
    String StudentEmail;
    String BookID, BookCopies, donationDate;

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getBookCopies() {
        return BookCopies;
    }

    public void setBookCopies(String BookCopies) {
        this.BookCopies = BookCopies;
    }
    

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentPassword() {
        return StudentPassword;
    }

    public void setStudentPassword(String StudentPassword) {
        this.StudentPassword = StudentPassword;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String StudentEmail) {
        this.StudentEmail = StudentEmail;
    }
    
    public List<StudentAccount> listDonatedBooks(){
        List<StudentAccount> students = new ArrayList<StudentAccount>();
        try{
            Connection conn = MySQLConnection.getConnection();
            String sql = "select StudentEmail, BookID, donationDate from donations";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudentAccount stud = new StudentAccount();
                stud.setStudentEmail(rs.getString(1));
                stud.setBookID(rs.getString(2));
                //stud.setBookCopies(rs.getString(3));
                stud.setDonationDate(rs.getString(3));
                students.add(stud);
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            MySQLConnection.closeConnection();
        }
        return students;
    }
    
    public void donateBooks(StudentAccount stu) {
        //TODO 
        try {
            Connection connection = MySQLConnection.getConnection();
            String sql = "insert into donations(StudentEmail, BookID, BookCopies, donationDate) "+
                    " values(?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, stu.getStudentEmail());
            stmt.setString(2, stu.getBookID());
            stmt.setString(3, stu.getBookCopies());
            stmt.setString(4, stu.getDonationDate());
            stmt.executeUpdate();
            
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            MySQLConnection.closeConnection();
        }
    }
    
    public void registerStudentAccount(StudentAccount stu) {
        try {
            Connection connection = MySQLConnection.getConnection();
            String sql = "insert into studentaccount(StudentEmail, StudentPassword) "+
                    " values(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, stu.getStudentEmail());
            stmt.setString(2, stu.getStudentPassword());
            stmt.executeUpdate();
            
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            MySQLConnection.closeConnection();
        }
    }
    
    public boolean loginStudent(String StudentEmail, String StudentPassword) {
        boolean validated = false;
        try {
            Connection conn = MySQLConnection.getConnection();
            String sql = "select * from studentaccount where StudentEmail = ? and StudentPassword = ?";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, StudentEmail);
            stmt.setString(2, StudentPassword);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                validated = true;
            }
            stmt.close();
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            MySQLConnection.closeConnection();
        }
        return validated;
    }
    
    public static void main(String[] args){
        /*
        Test login function
        */
        String email = "jdoe3@clayton.edu";
        String pwd = "ok123";
        String pwd2 = "ok1234";
        StudentAccount stu = new StudentAccount();
        if(stu.loginStudent(email, pwd)){
            System.out.println("Welcome "+ email);
        }
        else{
            System.out.println("Sorry, "+email+" is not authorized!");
        }
        if(stu.loginStudent(email, pwd2)){
            System.out.println("Welcome "+ email);
        }
        else{
            System.out.println("Sorry, "+email+" is not authorized!");
        }
        
        
        
    }
    
    
}

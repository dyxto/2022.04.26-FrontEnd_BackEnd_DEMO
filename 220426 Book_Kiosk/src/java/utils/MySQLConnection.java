/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.*;


/**
 *
 * @author bootcamp
 */
public class MySQLConnection {
    private static Connection conn = null;
    
    public static Connection getConnection(){
        try {
            // get JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // setup connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookkiosk?useSSL=false", 
                    "root", 
                    "MYP@$$W3rdMYSQL");
        }catch(Exception exp){
            exp.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConnection(){
        try{
            conn.close();
        }catch(Exception exp){
            exp.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try{
            Connection connection = MySQLConnection.getConnection();
            // build SQL
            String sql = "show tables";
            // wrap up sql to DB
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            // process the data
            while(result.next()){
                System.out.println(result.getString(1));
            }
            
        }catch(Exception exp){
            exp.printStackTrace();
        }finally{
            MySQLConnection.closeConnection();
        }
    }
    
}

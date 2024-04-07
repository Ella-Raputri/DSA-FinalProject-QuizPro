/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConnection;
import java.sql.*;

/**
 *
 * @author asus
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6697205", "sql6697205", "qe9cdhDBC1");
            return con;
            
        }catch(Exception e){
            return null;
        }
    }
}

package web_exam.btl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web_exam.btl.model.LoginBean;


public class LoginDao {
	
	
    public int validate(LoginBean loginBean) throws ClassNotFoundException {
    	int keep =-1;
       
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/online_quiz?allowPublicKeyRetrieval=true&&useSSL=false", "root", "12345");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from admin where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
           

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            keep =rs.getInt("admin_ID");
           	
           
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return keep;
    }
    public int validate2(LoginBean loginBean) throws ClassNotFoundException {
    	
    	int keep1=-1;
         Class.forName("com.mysql.jdbc.Driver");

         try (Connection connection = DriverManager
             .getConnection("jdbc:mysql://localhost:3306/online_quiz?allowPublicKeyRetrieval=true&&useSSL=false", "root", "12345");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
             .prepareStatement("select * from register where email = ? and password = ? ")) {
             preparedStatement.setString(1, loginBean.getUsername());
             preparedStatement.setString(2, loginBean.getPassword());

             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();
             

             while ( rs.next()) {
            	 keep1 =Integer.parseInt(rs.getString("register_ID"));
             }
          
                         
            

         } catch (SQLException e) {
             // process sql exception
             printSQLException(e);
         }
         return keep1;
    	
    	
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
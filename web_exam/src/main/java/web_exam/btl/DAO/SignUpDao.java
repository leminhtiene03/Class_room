package web_exam.btl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web_exam.btl.model.SignUp;




public class SignUpDao {

    public int registeraccount(SignUp account) throws ClassNotFoundException {
        
        
        String INSERT_ADMIN_SQL = "INSERT INTO admin" +
                "( name, email, password) VALUES " +
                " (?, ?, ?);";


        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
       
     
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/online_quiz?useSSL=false", "root", "12345");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
        	 preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(1, account.getFullName(account.getFirstName(),account.getLastName()));
           
            preparedStatement.setString(3, account.getPassword());
            //preparedStatement.setInt(1, 1);
           

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    public int normal_user(SignUp account) throws ClassNotFoundException {
    	   String INSERT_USER_SQL = "INSERT INTO register" +
                   "  ( name, email, password) VALUES " +
                   " (?, ?, ?);";


           int result = 0;

           Class.forName("com.mysql.jdbc.Driver");
          
        
           try (Connection connection = DriverManager
               .getConnection("jdbc:mysql://localhost:3306/online_quiz?useSSL=false", "root", "12345");

               // Step 2:Create a statement using connection object
               PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
           	 preparedStatement.setString(2, account.getUsername());
               preparedStatement.setString(1, account.getFullName(account.getFirstName(),account.getLastName()));
              
               preparedStatement.setString(3, account.getPassword());
               //preparedStatement.setInt(1, 1);
              

               System.out.println(preparedStatement);
               // Step 3: Execute the query or update query
               result = preparedStatement.executeUpdate();

           } catch (SQLException e) {
               // process sql exception
               printSQLException(e);
           }
           return result;
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

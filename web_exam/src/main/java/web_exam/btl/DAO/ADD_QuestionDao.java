package web_exam.btl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import web_exam.btl.model.BT_model;
import web_exam.btl.model.Question;



public class ADD_QuestionDao {
	 private static final String INSERT_EXAM = "INSERT INTO exam" +
	            "  (  class_ID, exam_name,  description,type,exam_date, exam_date_end,time_do) VALUES " +
	            " (?, ?,?,?,?,?,?);";
	 private static final String INSERT_QUESTION = "INSERT INTO question" +
	            "  (   exam_ID, question_text, correct_answer, wrong_answer_1, wrong_answer_2, wrong_answer_3, right_answer) VALUES " +
	            " (?, ?,?,?,?,?,?);";
	 private static final String GET_EXAM = "SELECT * from exam where exam_ID = LAST_INSERT_ID() "; 
	
	 
	 public static int keep =0;
	  private static String jdbcURL = "jdbc:mysql://localhost:3306/online_quiz?useSSL=false";
			private static String jdbcName = "root";
			private static  String jdbcPass = "12345";
	 
	 protected static  Connection getConnection() {
	    	Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection =  DriverManager.getConnection(jdbcURL, jdbcName, jdbcPass);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    	
	    private static void printSQLException(SQLException ex) {
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
		
	public static int INSERT_EXAM (BT_model new_exam, int class_id)
	{	int exam_id = 0;
		String hour = "";
	 	int get_minute = new_exam.getMinute_exam();
	 	if (get_minute <60) 
	 	{
	 		hour = "00" + get_minute +"00" ;
	 	}
	 	else 
	 	{
	 		hour = "01" + (get_minute-60) +"00";
	 	}
	 	while (hour.length() <6)
	 	{
	 		hour += "0";
	 	}
		 try (Connection connection = getConnection();

			
				 
 	            // Step 2:Create a statement using connection object
 	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXAM,Statement.RETURN_GENERATED_KEYS);) {
 	        	preparedStatement.setInt(1, class_id);
 	        	preparedStatement.setString(2, new_exam.getName());
 	        	preparedStatement.setString(3, new_exam.getDes());
 	        	preparedStatement.setString(4, new_exam.getType());
 	        	preparedStatement.setString(5, new_exam.getDate_start());
 	        	preparedStatement.setString(6, new_exam.getDate_end());
 	        	preparedStatement.setString(7, hour);
 	        	
 	        	
 	        	preparedStatement.addBatch();
 	        	preparedStatement.executeBatch();
 	            System.out.println(preparedStatement);
 	            // Step 3: Execute the query or update query
 	       
 	            // Step 2:Create a statement using connection object
 	          
 	          ResultSet rs = preparedStatement.getGeneratedKeys();
 	         if (rs.next()){
 	        	exam_id=rs.getInt(1);
 	         }
 	         rs.close();

 	            // Step 4: Process the ResultSet object.
 	          
  	            }
  	            
 	            
 	         catch (SQLException e) {
 	            printSQLException(e);
 	        }
		
		System.out.print("                  " + exam_id +"                       ");
		return exam_id;
	}
	
	public static void INSERT_QUESTION(  List < Question > list_question, int exam_id)
	{
		
		 try (Connection connection = getConnection();
				 PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_QUESTION);) {
	 	           for (int i=0;i< list_question.size();i++ )
	 	           {
	 	        	  
			        	preparedStatement1.setInt(1, exam_id);
			        	preparedStatement1.setString(2, list_question.get(i).getQuestion());
			        	preparedStatement1.setString(3, list_question.get(i).getAnswer_a());
			        	preparedStatement1.setString(4, list_question.get(i).getAnswer_b());
			        	preparedStatement1.setString(5, list_question.get(i).getAnswer_c());
			        	preparedStatement1.setString(6, list_question.get(i).getAnswer_d());
			        	preparedStatement1.setString(7, list_question.get(i).getRight_answer());
			        	System.out.println(preparedStatement1);
			        	 preparedStatement1.executeUpdate ();
			        	
	 	           }
	 	           
	 	        
	 	            
	 	            // Step 3: Execute the query or update query
	 	         
	 	           
	 	            // Step 4: Process the ResultSet object.
	 	          
	 	                
	 	                
	 	            
	 	        } catch (SQLException e) {
	 	            printSQLException(e);
	 	        }
		
	}


}
package web_exam.btl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_exam.btl.model.BT_model;
import web_exam.btl.model.Detail_class;
import web_exam.btl.model.EXAM_list;
import web_exam.btl.model.Question;

public class do_ExamDAO {
	
	 private static final String SELECT_EXAM = "select * from exam where exam_ID = ?";
	 private static final String SELECT_ALL_QUESTION = "select * from question where exam_ID = ?";
	 private static final String CHECK__DONE_EXAM = "select * from student where register_ID = ? and exam_ID =?";
	
	
	
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
	   
	   public static BT_model showI4_exam( int exam_id)
	   {	 BT_model a = new BT_model();
		   try (Connection connection = getConnection();

   	            // Step 2:Create a statement using connection object
   	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXAM);) {
   	        	preparedStatement.setInt(1, exam_id);
   	            System.out.println(preparedStatement);
   	            // Step 3: Execute the query or update query
   	            ResultSet rs = preparedStatement.executeQuery();
   	            
   	            // Step 4: Process the ResultSet object.
   	                rs.next();
   	                String exam_name = rs.getString("exam_name");
   	                String description = rs.getString("description");
   	                String type = rs.getString("type");
   	                String exam_date = rs.getString("exam_date");
   	             String exam_date_end = rs.getString("exam_date_end");
	                String time_do = rs.getString("time_do");
	                int time_don =0;
	                if (time_do != null)
	               if (time_do.charAt(1) == '1'  )
	               {
	            	   time_don +=60;
	               
	              time_don += Integer.parseInt( time_do.substring(3, 5) ) ;
	               }
   	                // String name, String des, String type, String date_start, String date_end, int minute_exam
   	                //exam_ID, class_ID, exam_name, exam_date, description, exam_date_end, type, time_do
   	              a = new BT_model(exam_name, description, type, exam_date,exam_date_end ,time_don);
   	               
   	            
   	        } catch (SQLException e) {
   	            printSQLException(e);
   	        }
   
 
		   return a;
		   
	   }
	   
	   public static  List < Question > selectAllQuestion(int exam_id ) {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Question > des_list = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	       
	        	 try (Connection connection = getConnection();

	        	            // Step 2:Create a statement using connection object
	        	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTION);) {
	        	        	preparedStatement.setInt(1, exam_id);
	        	            System.out.println(preparedStatement);
	        	            // Step 3: Execute the query or update query
	        	            ResultSet rs = preparedStatement.executeQuery();
	        	            System.out.print("");
	        	            // Step 4: Process the ResultSet object.
	        	            //int num, String question, String answer_a, String answer_b, String answer_c, String answer_d, String right_answer
	        	            // question_ID, exam_ID, question_text, correct_answer, wrong_answer_1, wrong_answer_2, wrong_answer_3, right_answer
	        	            int num =0;
	        	            while (rs.next() && rs!=null) {
	        	            	num = num +1;
	        	                String question = rs.getString("question_text");
	        	                String correct_answer = rs.getString("correct_answer");
	        	                String wrong_answer_1 = rs.getString("wrong_answer_1");
	        	                String wrong_answer_2 = rs.getString("wrong_answer_2");
	        	                String wrong_answer_3 = rs.getString("wrong_answer_3");
	        	                String right_answer = rs.getString("right_answer");
	        	                
	        	                des_list.add(new Question(num,question, correct_answer, wrong_answer_1, wrong_answer_2,wrong_answer_3, right_answer));
	        	                System.out.println("\n");
	        	                System.out.println(question);
	        	                
	        	                
	        	            }
	        	        } catch (SQLException e) {
	        	            printSQLException(e);
	        	        }
	        
	      
	     	            
	     	       
	     	        
	        return des_list;
	    }
	   
	   
	   
	   public static List < String > selectAllAnswer(int exam_id ) {

	        // using try-with-resources to avoid closing resources (boiler plate code)
		   List < String > des_list = new ArrayList < > ();	        // Step 1: Establishing a Connection
	       
	        	 try (Connection connection = getConnection();

	        	            // Step 2:Create a statement using connection object
	        	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTION);) {
	        	        	preparedStatement.setInt(1, exam_id);
	        	            System.out.println(preparedStatement);
	        	            // Step 3: Execute the query or update query
	        	            ResultSet rs = preparedStatement.executeQuery();
	        	            System.out.print("");
	        	            // Step 4: Process the ResultSet object.
	        	            //int num, String question, String answer_a, String answer_b, String answer_c, String answer_d, String right_answer
	        	            // question_ID, exam_ID, question_text, correct_answer, wrong_answer_1, wrong_answer_2, wrong_answer_3, right_answer
	        	            int num =0;
	        	            while (rs.next() && rs!=null) {
	        	            	
	        	                String right_answer = rs.getString("right_answer");
	        	                
	        	                des_list.add(right_answer);
	        	               
	        	                
	        	                
	        	            }
	        	        } catch (SQLException e) {
	        	            printSQLException(e);
	        	        }
	        
	      
	     	            
	     	       
	     	        
	        return des_list;
	    }
	   
	   public static boolean check_do_exam(int student_id, int exam_id)
	   {	
		   try (Connection connection = getConnection();

   	            // Step 2:Create a statement using connection object
   	            PreparedStatement preparedStatement = connection.prepareStatement(CHECK__DONE_EXAM);) {
			   preparedStatement.setInt(1, student_id);
			   preparedStatement.setInt(2, exam_id);
			   ResultSet rs = preparedStatement.executeQuery();
			   while (rs.next())
			   {
				   return true;
			   }
			   
		   
		   }
		   catch (SQLException e) {
	            printSQLException(e);
	        }

		   return false;
	   }
}

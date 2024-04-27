package web_exam.btl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;



public class Student_Join {
	
	
	private static final String JOIN_CLASS_SQL = "INSERT INTO student_class" +
            "  (  class_ID, register_ID) VALUES " +
            " (?, ?);";
	
	private static final String FINE_I4 = "select * from student_class where class_ID = ? and register_ID =? ";
	private static final String CHECK_CLASS = "select * from class where class_ID = ?   ";
	private static final String UPDATE ="UPDATE register  SET class_id = ?  WHERE id =?" ;
		
	public Student_Join() {}
    
	private static String jdbcURL = "jdbc:mysql://localhost:3306/online_quiz?useSSL=false";
	private static String jdbcName = "root";
	private static  String jdbcPass = "12345";
	
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

  
    public static String join_class(int class_id, int register_id) throws SQLException {
    
       System.out.print(class_id + "\n");
    	 try (Connection connection = getConnection();
    			 
 	            // Step 2:Create a statement using connection object
 	            PreparedStatement preparedStatement = connection.prepareStatement(FINE_I4);) {
    		 	
 	        	preparedStatement.setInt(1, class_id);
 	        	preparedStatement.setInt(2,register_id);
 	            System.out.println(preparedStatement);
 	            // Step 3: Execute the query or update query
 	            ResultSet rs = preparedStatement.executeQuery();
 	            while(rs.next())
 	            {
 	            	return " Bạn đang học lớp " + class_id + " rồi !";
 	            }
 	            // Step 4: Process the ResultSet object.
 	           
 	           try (Connection test = getConnection();
 	     			 
 	   	            // Step 2:Create a statement using connection object
 	   	            PreparedStatement test2 = test.prepareStatement(CHECK_CLASS);) {
 	        	 
 	        	  test2.setInt(1, class_id);
 	        	 ResultSet rs3 = test2.executeQuery();
 	        	 while (rs3.next())
 	        	 {
 	        		  try (Connection try_cn = getConnection();
 	        	 	           PreparedStatement READY2 = try_cn.prepareStatement(JOIN_CLASS_SQL);)
 	        	 	           {	rs.next();
 	        	 	           		
 	        	 	        	
 	        	 	        	 READY2.setInt(2, register_id);
 	        	 	        	
 	        	 	        	READY2.setInt(1, class_id);
 	        	 	        	
 	        	 	        	System.out.println(READY2);
 	        	 	        	READY2.executeUpdate();
 	        	 	        	return " Gia nhập lớp " + class_id +" thành công";
 	        	 	           }
 	        	 }
 	        	
 	           }
 	           
 	             
 	         
 	        	   
 	        	   
 	        	 
 	           
 	           
 	        
 	        }
    	
    	 catch (SQLException e) {
	            printSQLException(e);
    	 }
    	
    	 return " Lớp không tồn tại !";

	         
               
    }

			
    }



    


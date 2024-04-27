package web_exam.btl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web_exam.btl.model.Class_struct;

public class Save_ResultDAO {
	
	
	
	private static final String SAVE_RESULT = "INSERT INTO student" +
	            "  (  register_ID, exam_ID, score) VALUES " +
	            " (?, ?,?);";
	
	
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
			    
			    public static boolean insert_Result( int register_ID,int exam_ID,double score) throws SQLException {
			        boolean rowUpdated;
			        try (Connection connection = getConnection();
			        		PreparedStatement statement = connection.prepareStatement(SAVE_RESULT);) {
			          
			            statement.setInt(1, register_ID);
			            statement.setInt(2, exam_ID);
			            statement.setDouble(3, score);
				           
			            rowUpdated = statement.executeUpdate() > 0;
			        }
			        return rowUpdated;
			    }
			    
}

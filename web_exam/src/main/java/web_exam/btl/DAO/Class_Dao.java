package web_exam.btl.DAO;


import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_exam.btl.model.Class_struct;



public class Class_Dao {	
	

	 private static final String INSERT_USERS_SQL = "INSERT INTO class" +
            "  ( class_name, admin_ID,description) VALUES " +
            " (?, ?,?);";

	   private static final String SELECT_CLASS_BY_ID = "select id,class_name,description from class where admin_ID =?";
	    private static final String SELECT_ALL_CLASS = "select * from class where admin_ID = ?";
private static final String SELECT_CLASS = "select * from class where class_ID = ?";
	    private static final String SELECT_ALL_CLASS_STUDENT = "select * from student_class where register_ID = ?";
	    private static final String DELETE_CLASS_SQL = "delete from class where class_ID = ?;";
	    private static final String DELETE_EXAM_SQL =  "delete from exam where exam_ID = ?;";
	    private static final String UPDATE_CLASS_SQL = "update class set class_name = ?,description= ? where id = ?;";
	    private static final String SELECT_EXAM_WITHCLASS = "select * from exam where class_ID = ?;";
	    private static final String DELETE_STUDENT_WITHEXAM = "delete from student where exam_ID = ?;";
	    private static final String DELETE_question = "delete  from question where exam_ID = ?;";
	    private static final String REMOVE_CLASS_STUDENT = "delete  from student_class where class_ID = ? and register_ID = ?;";
	    private static final String REMOVE_CLASS_STUDENT_EXAM = "delete  from student where exam_ID = ? and register_ID = ?;";
	    
	private static String jdbcURL = "jdbc:mysql://localhost:3306/online_quiz?useSSL=false";
	private static String jdbcName = "root";
	private static  String jdbcPass = "12345";
	
	public Class_Dao() {}
    

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
	
    public static  List < Class_struct > selectAllClass(int admin,int register_id) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Class_struct > class_list = new ArrayList < > ();
        // Step 1: Establishing a Connection
        if(admin >0 )
        {
        	 try (Connection connection = getConnection();

        	            // Step 2:Create a statement using connection object
        	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS);) {
        	        	preparedStatement.setInt(1, admin);
        	            System.out.println(preparedStatement);
        	            // Step 3: Execute the query or update query
        	            ResultSet rs = preparedStatement.executeQuery();

        	            // Step 4: Process the ResultSet object.
        	            while (rs.next()) {
        	                int id = rs.getInt("class_ID");
        	                String name = rs.getString("class_name");
        	                String tacgia = rs.getString("admin_ID");
        	                String namxb = rs.getString("description");
        	                class_list.add(new Class_struct(id, name, tacgia, namxb));
        	                System.out.print(id + name + tacgia + namxb );
        	            }
        	        } catch (SQLException e) {
        	            printSQLException(e);
        	        }
        }
        else 
        {
        	 try (Connection connection = getConnection();

     	            // Step 2:Create a statement using connection object
     	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS_STUDENT);) {
     	        	preparedStatement.setInt(1,	register_id);
     	            System.out.println(preparedStatement);
     	            // Step 3: Execute the query or update query
     	            ResultSet rs = preparedStatement.executeQuery();

     	            // Step 4: Process the ResultSet object.
     	            while (rs.next()) {
     	                int id = rs.getInt("class_ID");
     	               try (Connection READY = getConnection();

     	       	            // Step 2:Create a statement using connection object
     	       	            PreparedStatement READY2 = connection.prepareStatement(SELECT_CLASS);) {
     	            	  READY2.setInt(1,	id);
     	       	           
     	       	            // Step 3: Execute the query or update query
     	       	            ResultSet rs2 = READY2.executeQuery();
     	       	        
     	       	        while (rs2.next()) {
        	               
        	                String name = rs2.getString("class_name");
        	                String tacgia = rs2.getString("admin_ID");
        	                String namxb = rs2.getString("description");
        	                class_list.add(new Class_struct(id, name, tacgia, namxb));
        	                
        	            }
     	       	           
     	       	        } catch (SQLException e) {
     	       	            printSQLException(e);
     	       	        }
     	          }
     	         
     	          return class_list;
     	      
     	            
     	        } catch (SQLException e) {
     	            printSQLException(e);
     	        
     	        }
     	        }
        return class_list;
    }
	 public static boolean inseartClass(Class_struct Class_i, int admin) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);) {
	            statement.setString(1, Class_i.getName());
	           
	            statement.setInt(2, admin);
	            statement.setString(3, Class_i.getDescription());
	         
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	 public static boolean updateClass(Class_struct Class_i) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CLASS_SQL);) {
	            statement.setString(1, Class_i.getName());
	            statement.setString(2, Class_i.getDescription());
	           
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	 
	  public static void deleteClass(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); 
	        		PreparedStatement statement = connection.prepareStatement(SELECT_EXAM_WITHCLASS);) {
	            statement.setInt(1, id);
	           System.out.println(statement);
	            ResultSet rs = statement.executeQuery();
	            
	            
	            
	            
	            while ( rs.next() && rs!=null )
	            {	int a = rs.getInt("exam_ID");
	            	System.out.println( a);
	            	
	            	try (Connection connect3 = getConnection(); 
	     	        		PreparedStatement getques = connect3.prepareStatement(DELETE_STUDENT_WITHEXAM);) {
	            		 getques.setInt(1, a);
	            		 System.out.println(getques);
	            		
	            		 getques.executeUpdate();}
	            	
	            	 try (Connection connect = getConnection(); 
	     	        		PreparedStatement getques = connect.prepareStatement(DELETE_question);) {
	            		 getques.setInt(1, a);
	            		 System.out.println(getques);
	            		 getques.executeUpdate();}
	            	 
	            	 try (Connection connect1 = getConnection(); 
		     	        		PreparedStatement getques = connect1.prepareStatement(DELETE_EXAM_SQL);) {
		            		 getques.setInt(1, a);
		            		 System.out.println(getques);
		            		 getques.executeUpdate();}
	            }
	            
	        }
	        try (Connection connection2 = getConnection(); 
	        		PreparedStatement statement1 = connection2.prepareStatement(DELETE_CLASS_SQL);) {
	            statement1.setInt(1, id);
	            System.out.println(statement1);
	            statement1.executeUpdate();
	        }
	      
	        
	        
	    }
	  
	  
	  public static void remove_class(int register_id, int class_id) throws SQLException {
		  try (Connection connection = getConnection(); 
	        		PreparedStatement statement = connection.prepareStatement(REMOVE_CLASS_STUDENT);) {
	            statement.setInt(1, class_id);
	            statement.setInt(2, register_id);
	           System.out.println(statement);
	            statement.executeUpdate();
		  
		  }
		  
		  try (Connection connection = getConnection(); 
	        		PreparedStatement statement = connection.prepareStatement(SELECT_EXAM_WITHCLASS);) {
	            statement.setInt(1, class_id);
	           System.out.println(statement);
	            ResultSet rs = statement.executeQuery();
	            
	            
	            while (rs.next())
	            {	int exam_id = rs.getInt("exam_ID");
	            	  try (Connection connection2 = getConnection(); 
	      	        		PreparedStatement statement2 = connection.prepareStatement(REMOVE_CLASS_STUDENT_EXAM);) {
	      	            statement2.setInt(1, exam_id);
	      	            statement2.setInt(2,register_id);
	      	           
	      	           System.out.println(statement2);
	      	            statement2.executeUpdate();
	      		  
	      		  }
	            }
		  
		  }
		  
		 
	  }
	 
	  
	  
}


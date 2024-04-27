package web_exam.btl.DAO;



import java.io.IOException;
import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_exam.btl.model.Class_struct;
import web_exam.btl.model.Detail_class;
import web_exam.btl.model.EXAM_list;
import web_exam.btl.model.Student;


public class EXAM_DAO {



	

	
		
		 private static final String INSERT_USERS_SQL = "INSERT INTO class" +
	            "  ( class_name, admin_ID,description) VALUES " +
	            " (?, ?,?);";

		   private static final String SELECT_CLASS_BY_ID = "select id,class_name,description from class where admin_ID =?";
		    private static final String SELECT_ALL_EXAM = "select * from exam where class_ID = ?";
	private static final String SELECT_CLASS = "select * from class where class_ID = ?";
		    private static final String SELECT_ALL_CLASS_STUDENT = "select * from student_class where register = ?";
		    private static final String DELETE_CLASS_SQL = "delete from class where id = ?;";
		    private static final String UPDATE_CLASS_SQL = "update class set class_name = ?,description= ? where id = ?;";
		    private static final String SELECT_EXAM_DES = "select * from exam where exam_ID = ?";
		    private static final String SELECT_All_STUDENT = "select * from student_class where class_ID = ?";
		    private static final String SELECT_ADMIN = "select * from class where class_ID = ? ";
		    		private static final String SELECT_All_STUDENT_REAL = "select * from register where register_ID = ?";
		    
		    private static final String SELECT_EXAM_WITHCLASS = "select * from exam where class_ID = ?;";
		    private static final String DELETE_STUDENT_WITHEXAM = "delete from student where exam_ID = ?;";
		    private static final String DELETE_question = "delete  from question where exam_ID = ?;";
		    private static final String DELETE_EXAM_SQL =  "delete from exam where exam_ID = ?;";
		    private static String jdbcURL = "jdbc:mysql://localhost:3306/online_quiz?useSSL=false";
		private static String jdbcName = "root";
		private static  String jdbcPass = "12345";
		
		public EXAM_DAO() {}
	    

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
	    private static final String SELECT_ADMIN_2 = "select * from admin where admin_ID = ? ";
	    public static  Student selectAdmin(int class_id )
	    {
	    	
	    	Student Admin = new Student();
	    	 try (Connection connection = getConnection();

     	            // Step 2:Create a statement using connection object
     	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN);) {
	    		 preparedStatement.setInt(1, class_id);
	    		 ResultSet rs = preparedStatement.executeQuery();
	    		 while (rs.next())
	    		 {
	    			 int admin_ID = rs.getInt("admin_ID");
	    			 PreparedStatement get_Admin = connection.prepareStatement(SELECT_ADMIN_2); {
	    				 get_Admin.setInt(1, admin_ID);
	    	    		 ResultSet rs2 = get_Admin.executeQuery(); 
	    				 rs2.next();
	    				 Admin.setEmail(rs2.getString("email"));
	    				 Admin.setFullname(rs2.getString("name"));
	    				 
	    			 }
	    		 }
	    }
	    		 
	    		 
	    	 
	    	
	    	 catch (SQLException e) {
 	            printSQLException(e);
 	        }
	   
	    	return Admin;
	    }
	    public static  List < Detail_class > selectAllDescription(int exam_id , int admin_id) {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Detail_class > des_list = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        if(admin_id != 0)
	        {
	        	 try (Connection connection = getConnection();

	        	            // Step 2:Create a statement using connection object
	        	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXAM_DES);) {
	        	        	preparedStatement.setInt(1, exam_id);
	        	            System.out.println(preparedStatement);
	        	            // Step 3: Execute the query or update query
	        	            ResultSet rs = preparedStatement.executeQuery();
	        	            System.out.print("");
	        	            // Step 4: Process the ResultSet object.
	        	            while (rs.next() && rs!=null) {
	        	                int id = rs.getInt("exam_ID");
	        	                int class_id2 = rs.getInt("class_ID");
	        	                String name = rs.getString("exam_name");
	        	                String date_start = rs.getString("exam_date");
	        	                String date_end = rs.getString("exam_date_end");
	        	                String des = rs.getString("description");
	        	                
	        	                des_list.add(new Detail_class(id, class_id2,name, date_start, date_end,des));
	        	                System.out.println("\n");
	        	                System.out.println(rs);
	        	                
	        	                
	        	            }
	        	        } catch (SQLException e) {
	        	            printSQLException(e);
	        	        }
	        
	      
	     	            
	     	       
	     	        }
	        else
	        {

	        	 try (Connection connection = getConnection();

	        	            // Step 2:Create a statement using connection object
	        	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXAM_DES);) {
	        	        	preparedStatement.setInt(1, exam_id);
	        	            System.out.println(preparedStatement);
	        	            // Step 3: Execute the query or update query
	        	            ResultSet rs = preparedStatement.executeQuery();
	        	            System.out.print("");
	        	            // Step 4: Process the ResultSet object.
	        	            while (rs.next() && rs!=null) {
	        	                int id = rs.getInt("exam_ID");
	        	                int class_id2 = rs.getInt("class_ID");
	        	                String name = rs.getString("exam_name");
	        	                String date_start = rs.getString("exam_date");
	        	                String date_end = rs.getString("exam_date_end");
	        	                String des = rs.getString("description");
	        	                
	        	                des_list.add(new Detail_class(id, class_id2,name, date_start, date_end,des));
	        	                System.out.println("\n");
	        	                System.out.println(rs);
	        	                
	        	                
	        	            }
	        	        } catch (SQLException e) {
	        	            printSQLException(e);
	        	        }
	        }
	        return des_list;
	    }
	    
	    public static  List < Student > selectAllPeople(int class_id) {
	    	
	    	List < Student > list_student =  new ArrayList < > ();
	    	 try (Connection connection = getConnection();
	    			  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_All_STUDENT);) {
	    		 preparedStatement.setInt(1, class_id);
	    		 ResultSet rs = preparedStatement.executeQuery();
	    		 while (rs.next())
	    		 {
	    			 PreparedStatement get_student = connection.prepareStatement(SELECT_All_STUDENT_REAL); {
	    				 get_student.setInt(1, rs.getInt("register_ID"));
	    				 ResultSet rs2 = get_student.executeQuery();
	    				 rs2.next();
	    				 list_student.add(new Student(rs2.getString("name"),rs2.getString("email")));
	    			 }
	    		 }
	    		 
	    	 }
	    	 catch (SQLException e) {
 	            printSQLException(e);
 	        }
	      
	      return list_student;
	      
	    }
	    public static  List < EXAM_list > selectAllEXAM(int class_id) {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < EXAM_list > exam_list = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	      
	        	 try (Connection connection = getConnection();

	        	            // Step 2:Create a statement using connection object
	        	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EXAM);) {
	        	        	preparedStatement.setInt(1, class_id);
	        	            System.out.println(preparedStatement);
	        	            // Step 3: Execute the query or update query
	        	            ResultSet rs = preparedStatement.executeQuery();
	        	            
	        	            // Step 4: Process the ResultSet object.
	        	            while (rs.next() && rs!=null) {
	        	                int id = rs.getInt("exam_ID");
	        	                String name = rs.getString("exam_name");
	        	                String tacgia = rs.getString("description");
	        	                String namxb = rs.getString("exam_date");
	        	                exam_list.add(new EXAM_list(id, name, tacgia, namxb));
	        	                System.out.print(id + name + tacgia + namxb );
	        	            }
	        	        } catch (SQLException e) {
	        	            printSQLException(e);
	        	        }
	        
	      
	     	            
	     	       
	     	        
	        return exam_list;
	    }
	    
	    
		 public static boolean inseartClass(Class_struct Class_i, int admin_id) throws SQLException {
		        boolean rowUpdated;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);) {
		            statement.setString(1, Class_i.getName());
		           
		            statement.setInt(2, admin_id);
		            statement.setString(3, Class_i.getDescription());
		         
		            rowUpdated = statement.executeUpdate() > 0;
		        }
		        return rowUpdated;
		    }
		 
		 
		  public static void deleteExam(int id) throws SQLException {
		        boolean rowDeleted;
		        try (Connection connection = getConnection(); 
		        		PreparedStatement statement = connection.prepareStatement(DELETE_question);) {
		            statement.setInt(1, id);
		           System.out.println(statement);
		          statement.executeUpdate();
		            
		            
		            
		            
		           
		            	
		            	try (Connection connect3 = getConnection(); 
		     	        		PreparedStatement getques = connect3.prepareStatement(DELETE_STUDENT_WITHEXAM);) {
		            		 getques.setInt(1, id);
		            		 System.out.println(getques);
		            		
		            		 getques.executeUpdate();}
		            	
		            	 
		            	 
		            	 try (Connection connect1 = getConnection(); 
			     	        		PreparedStatement getques = connect1.prepareStatement(DELETE_EXAM_SQL);) {
			            		 getques.setInt(1, id);
			            		 System.out.println(getques);
			            		 getques.executeUpdate();}
		            }
		            
		        }
		      
		      
		        
		        
		    }
		  
		 
		  
		  
		  
	




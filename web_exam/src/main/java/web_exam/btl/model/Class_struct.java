package web_exam.btl.model;import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Ramesh Fadatare
 */
public class Class_struct implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
    private String  name; 
    private String author;
    private String  description;
  
    
    public Class_struct() {
		
	}
	public Class_struct(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Class_struct(int id, String name, String description) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
	}
	public Class_struct(int id, String name, String author,String description) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

 
}


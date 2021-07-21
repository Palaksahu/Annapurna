package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category {

	private String category;
	private Integer categoryId;
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~ Constructor ~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
    public Category() {
    	super();
    }
    
    public Category(Integer categoryId) {
    	super();
    	
    	this.categoryId = categoryId;
    }
    
    public Category(Integer categoryId , String category) {
    	super();
    	
    	this.categoryId = categoryId;
    	this.category = category;
    }
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~  Method  ~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public static ArrayList<Category> getAllCategory(){
		ArrayList<Category> catlist = new ArrayList<Category>(); 
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			String query = "select * from categories ";
			PreparedStatement pst = con.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 
			 while(rs.next()){
				 catlist.add(new Category(rs.getInt(1),rs.getString(2)));
			 }
			
		}catch(SQLException |ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return catlist;
	}

	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~  Setter getter~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	}

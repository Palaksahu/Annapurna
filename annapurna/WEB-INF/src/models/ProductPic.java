package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductPic {

	private Integer productPicId;
	private Product product;
	private String picPath;
	
	public ProductPic() {
		super();
	}
	
	
	public static boolean deletePic(Product product){
		  boolean flag = false;
		  
		  Connection con = null;
		  
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			  String query = "delete from product_pics where product_id = ?";
			  PreparedStatement pst = con.prepareStatement(query);
			  pst.setInt(1,product.getProductId());
			 int rs =  pst.executeUpdate();
			 if(rs != 0 ){
				 flag = true;
			 }
		  }catch(SQLException |ClassNotFoundException e) {
			  e.printStackTrace();
		  }
		  return flag;
	}
	
	public static ArrayList<String> getAllPics(Product product){
	  ArrayList<String> allPicList = new ArrayList<String>();
	  
	  Connection con = null;
	  try {
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
		
		  String query = "select pic_path from product_pics where product_id= ?";
		  
		  PreparedStatement pst = con.prepareStatement(query);
		  pst.setInt(1,product.getProductId());
		  
		  ResultSet rs = pst.executeQuery();
		   
		   while(rs.next()) {
			   allPicList.add(rs.getString(1));
		   }
		   con.close();
		  
	  }catch(SQLException |ClassNotFoundException e) {
		  e.printStackTrace();
	  }
		return allPicList;
		
	}
	
	
	public static boolean saveProductPics(Product product,String picPath) {
	    boolean success = false;
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			
			String query = "insert into product_pics(product_id,pic_path) value(?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,product.getProductId());
			pst.setString(2,picPath);
			
			int rs = pst.executeUpdate();
			
			if(rs==1){
				success = true;
			}
		
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		return success;
		
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Integer getProductPicId() {
		return productPicId;
	}
	public void setProductPicId(Integer productPicId) {
		this.productPicId = productPicId;
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	
	
	
}

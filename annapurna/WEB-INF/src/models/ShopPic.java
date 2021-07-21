package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopPic {
 
	private Integer shopPicId;
	private Shop shop;
	private String picPath;
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     Constructors      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	  ShopPic(){
		 super();
		}
		
	
	  public ShopPic(Shop shop , String picPath) {
		 
		  super();
		  this.shop = shop;
		  this.picPath = picPath;
		  
	  }
	  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     Methods summary   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  
	  
	//---------------------------------------  delPath(deleting other shop pics )  - -----------------------------------------------
	  
	  public static boolean delPath(String picPath) {
		  boolean flag = false;
		  
		  Connection con = null ;
		  try {
			  
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			  String query = "delete from shop_pics where pic_path = ?";
			  PreparedStatement pst = con.prepareStatement(query);
			  pst.setString(1,picPath);
			  
			 int rs =  pst.executeUpdate();
			 
			 if(rs!=0){
				 flag=true;
			 }
			  
		  }catch(SQLException |ClassNotFoundException e) {
			  e.printStackTrace();
		  }
		  return flag;
	  }
	  
	//---------------------------------------  getAllPicPath   - -----------------------------------------------
	  public static ArrayList<String> getAllPicPath(Shop shop){
		   ArrayList<String> picPathList = new ArrayList<String>();
		   
		   Connection con = null;
		   try {
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			   String query = "select pic_path from shop_pics where shop_id = ? order by shop_pic_id desc";
			   PreparedStatement pst = con.prepareStatement(query);
			   pst.setInt(1, shop.getShopId());
			   
			   ResultSet rs = pst.executeQuery();
			   
			   while(rs.next()) {
				   picPathList.add(rs.getString(1));
			   }
			   con.close();
			  
		     }catch(SQLException | ClassNotFoundException e) {
			   e.printStackTrace();
		     }
		    
		  return picPathList;
	  }
	  
	  
	 //---------------------------------------  SaveOtherPicPath   - -----------------------------------------------
	  
	  public boolean saveOtherPicPath(){
		  boolean flag= false;
		  Connection con = null;
		  
		  try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			    
			    String query = "insert into shop_pics(shop_id,pic_path) value(?,?)";
			    
			    PreparedStatement pst = con.prepareStatement(query);
			  
			   pst.setInt(1, shop.getShopId()) ;
			   pst.setString(2,picPath);
			   int ra =  pst.executeUpdate();
			   if(ra == 1) {
				   
				   flag = true;
			   }
			   
		  }catch(SQLException | ClassNotFoundException e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	  
	  
	  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     Getter Setters           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Integer getShopPicId() {
		return shopPicId;
	}
	public void setShopPicId(Integer shopPicId) {
		this.shopPicId = shopPicId;
	}
	
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	
	
}

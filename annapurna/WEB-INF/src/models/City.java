package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class City {
     private Integer cityId;
     private String city;
     private  State state ;
     //--------------------------COnstructor------------
     
     public City(Integer cityId) {
    	 super();
    	 this.cityId = cityId;
     }
     
     public City(Integer cityId,String city,State state) {
    	 
    	 super();
    	 this.cityId = cityId;
    	 this.city = city;
    	 this.state = state;
     }
     public City(Integer cityId,String city) {
    	 super();
    	 this.cityId = cityId;
    	 this.city = city;
     }
     
   
     
     //---------------------------
	 public void setCityId( Integer cityId) {
		   this.cityId =  cityId;
	 }
	 public Integer getCityId() {
		 return cityId;
	 }
	 
	 public void setCity(String city) {
		 this.city = city;
	 }
	 public  String getCity() {
	        return city;
	 }
	 
	 public void setState(State state) {
		 this.state = state;
	 }
	 public State getState() {
		 return state;
	 }
//--------------------------------   Method Sumamry-----------------------------------



public static ArrayList<City> getAllCities(){
	ArrayList<City> cityArrList = new ArrayList<City>();
	
		Connection con = null;
		try {
			
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			  String query = "select city_id,city,c.state_id,state "
			  		+ "from cities as c inner join states as s where s.state_id= c.state_id";
			  PreparedStatement pst = con.prepareStatement(query);
			   ResultSet rs = pst.executeQuery();
			  while(rs.next()) {
				  
				  State state = new State(rs.getInt(3),rs.getString(4));
				  City city = new City(rs.getInt(1),rs.getString(2),state);
				  cityArrList.add(city);
			  }
			 con.close();
		}catch(SQLException|ClassNotFoundException e){
			
			e.printStackTrace();
			
		}
		return cityArrList;
	
   }
}
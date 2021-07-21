package models;

import java.sql.Connection;
import org.jasypt.util.password.StrongPasswordEncryptor;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Shop {
 
 //#################################Private Variables#################################

	private Integer shopId;
	private String  name;
	private String  email;
	private String  phone;
	private String  password;
	private Date    date;
	private String  address;
	private String  details;
	private City city;
	private Status status;
	private Integer totalProducts;
    private String  propic ;
	private String  activationCode;

    //#################################Constructors#################################

	Shop(){
	 super();
	}
	
	Shop(Integer shopId){
		super();
		this.shopId = shopId;
	}
	
	public Shop(String name,String email,String phone,String password,String activationCode){
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.activationCode = activationCode;
	}
	
	public Shop(String email,String password){
		super();
		this.email = email;
		this.password = password;
	}
	
    public Shop(Integer shopId, String name , String propic) {
    	   super();
    	   this.shopId = shopId;
    	   this.name = name;
    	   this.propic = propic;
    } 
	
	//################################# Method Summary #################################
    
    
    public static ArrayList<Shop> getShopLike(String like){
            ArrayList<Shop> shopLikeList = new ArrayList<Shop>();
            
            Connection con = null;
            try{
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
            	String query = "select shop_id,shop_name,propic from shops where shop_name like ?";
            	PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,like+"%");
                
              ResultSet rs =   pst.executeQuery();
              
              while(rs.next()) {
            	  Shop shop = new Shop(rs.getInt(1),rs.getString(2),rs.getString(3));
            	  shopLikeList.add(shop);
              }
            }catch(SQLException | ClassNotFoundException e) {
            	e.printStackTrace();
            }
            
            return shopLikeList;
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~9  update total product~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
         public static void updateTotalProducts(Boolean flag , Integer shopId) {
        	 Connection con = null;
        	 try {
        		  Class.forName("com.mysql.cj.jdbc.Driver");
        		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password = 1234");
        		  String query = "";
        		  if(flag) {
        			  
        		  query = "update shops set total_products = total_products+1 where shop_id = ?";
        		
        		  }else {
        			  query = "update shops set total_products = total_products-1 where shop_id = ?";
        		  }
        		  PreparedStatement pst = con.prepareStatement(query);
        		  pst.setInt(1,shopId);
        		  pst.executeUpdate();
        		  
        	 }catch(SQLException | ClassNotFoundException e) {
        		 e.printStackTrace();
        	 }
        	 
         }
  //~~~~~~~~~~~~~~~~~~~ 8 shopNameand Like~~~~~~~~~~~~~~~~~~~
    
    public static ArrayList<String> shopNameLike(String nameLike){
    	
    	ArrayList<String> nameLikeList = new ArrayList<String>();
    	
    	Connection con = null;
    	
    	try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
    		
    		String query2 = "select shop_name from shops where shop_name like ? ";
    		
    		
    		PreparedStatement pst2 = con.prepareStatement(query2);
    		
    		pst2.setString(1,nameLike+"%");
    	    
    	    ResultSet rs2 = pst2.executeQuery();
    	    
    	    while(rs2.next()) {
    	    	nameLikeList.add(rs2.getString(1));
    	    }
    		con.close();
    	}catch(SQLException |ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	return nameLikeList;
    	
    }
    
  //~~~~~~~~~~~~~~~~~~~ 7 get SHop List~~~~~~~~~~~~~~~~~~~
	
	public static ArrayList<Shop>  getShopList(){
	        ArrayList<Shop>  shopList = new ArrayList<Shop>();
	        
	        Connection con = null;
	        try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	        	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
	        	 String query ="select shop_id ,shop_name , propic from shops order by shop_id desc";
	        	 PreparedStatement pst = con.prepareStatement(query);
	        	 
	        	 ResultSet rs = pst.executeQuery();
	        	 while(rs.next()) {
	        	Shop shop = new Shop(rs.getInt(1),rs.getString(2),rs.getString(3));
	        	shopList.add(shop);
	        	 }
	        	
	        }catch(SQLException |ClassNotFoundException e ) {
	        	e.printStackTrace();
	        }
	        return shopList;
	}
	
	//~~~~~~~~~~~~~~~~~~~ 6 Save Propic URL ~~~~~~~~~~~~~~~~~~~
	
	
	public void savePropicUrl(String propicPath) {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
		
		    String query = "update shops set propic = ? where shop_id=?";
		    
		    PreparedStatement pst = con.prepareStatement(query);
		    
		    pst.setString(1, propicPath);
		    pst.setInt(2, shopId);
		    
		   int i = pst.executeUpdate();
		   
		    
		}catch(SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
			con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//~~~~~~~~~~~~~~~~~~~ 5 Update Profile~~~~~~~~~~~~~~~~~~~
	
	
	public boolean updateProfile(String name, String details, String address , String phone,City city) {
		boolean updated = false;
		
		Connection con = null;
		
		try {
			
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
		   String query = "update shops set shop_name = ?,details= ?,address =?,phone =? ,status_id = 1 ,city_id =? where shop_id=?";
		   PreparedStatement pst = con.prepareStatement(query);
		   pst.setString(1,name);
		   pst.setString(2, details);
		   pst.setString(3, address);
		   pst.setString(4, phone);
		   pst.setInt(5,city.getCityId());
		   pst.setInt(6,shopId);
		   
		   int rowaffected = pst.executeUpdate();
		   if(rowaffected == 1) {
		       this.name = name ;
		       this.details = details;
		       this.address = address ;
		       this.phone = phone;
		       this.city = city;
			   updated = true;
		   }
		   
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		 return updated;
	}
	
	
	
	//~~~~~~~~~~~~~~~~~~~ 4 SignIn~~~~~~~~~~~~~~~~~~~
	
	public int signin(){
		int flag = 0;
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			
			String query ="select password,shop_id,shop_name,phone,date,address,details,propic,status_id,"
					+ "total_products,s.city_id,city from shops as s inner join cities as c "
					+ "where email=? and  c.city_id = s.city_id" ;
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
           ResultSet rs =  pst.executeQuery();
           
          if(rs.next()){
        	String  encryptedPassword = rs.getString(1);
        	StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        	if(spe.checkPassword(password,encryptedPassword)){
        		
        		shopId = rs.getInt(2);
        		name   = rs.getString(3);
        		phone = rs.getString(4); 
        		date  = rs.getDate(5);
        		address = rs.getString(6);
        		
        		details = rs.getString(7);
        		propic = rs.getString(8);
        		status = new Status(rs.getInt(9));
        		totalProducts = rs.getInt(10);
        		city = new City(rs.getInt(11),rs.getString(12));
        		
        		flag = 2;
        		
        	   }else {
            	   flag = 1;
               }
           }
		}catch(SQLException|ClassNotFoundException e){
			 e.printStackTrace();
		}
		return flag;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~ 3 Exist~~~~~~~~~~~~~~~~~~~
	
	public static boolean exist(String email){
		 boolean exist = false;
		 
		 Connection con = null;
		 
		 try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			   
			   String query = "select * from shops where email = ?";
			   PreparedStatement pst = con.prepareStatement(query);
			   pst.setString(1,email);
			   
			  ResultSet rs = pst.executeQuery();
			  exist =  rs.next();
		 }catch(SQLException|ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 
		 return exist;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~ 2 Activation ~~~~~~~~~~~~~~~~~~~
	
	public static boolean activation(String email,String activationCode){
		boolean activate = false;
		
		Connection con = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			 
			String query = "UPDATE shops SET status_id = 5,activation_code = NULL WHERE email= ? AND activation_code=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,activationCode);
		    int sach = pst.executeUpdate();
		    
		    if(sach==1) {
		    	activate = true;
		    }
		    
			
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		 return activate;
	}
	
	
//~~~~~~~~~~~~~~~~~~~ 1 SignUp~~~~~~~~~~~~~~~~~~~
	
	
	public void signUp(){
	   Connection con = null;
	   try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			String query = "insert into shops(shop_name,email,phone,password,date,activation_code) value(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,phone);
			
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			ps.setString(4, spe.encryptPassword(password));
			
			Long ldate = new java.util.Date().getTime();
			ps.setDate(5,new Date(ldate));
			ps.setString(6,activationCode);
			ps.executeUpdate();
	   }catch(ClassNotFoundException | SQLException e){
	             e.printStackTrace();
	   }
	}
	
	
	
	//#################################Getter / Setters#################################
	
	
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getShopId() {
		return shopId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
	   return name;	
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	public void setDate(Date date){
		this.date = date;
	}
	public Date getDate(){
		return date;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDetails() {
		return details;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	public City getCity() {
		return city;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	
	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}
	public Integer getTotalProducts() {
		return totalProducts;
	 }
	
	
	public String getPropic() {
		return propic;
	}
	public void setPropic(String propic) {
		this.propic = propic;
	}

	
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getActivationCode() {
		return activationCode;
	}
}

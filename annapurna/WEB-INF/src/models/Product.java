package models;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ProductDetail;

public class Product {

	private Integer productId;
	private String  productName;
	private String  details;
	private float weight;
	private Integer quantity;
	private float mrp;
	private float price;
	private Date   exdate;
	private Integer starRank;
	private Shop shop;
	private Integer starRankCount;
	private ProductDetail product;
	private String brand;
	private Category category;
	
	// ```````````````````````````~~~~~~~~~~~~Constructor~~~~~~~~~~~~~````````````````````````````
	
	
	
	public Product(){
		super();
	}
	
	public Product(Integer productId) {
		
		super();
		this.productId = productId;
	}
	
	
	public Product(Integer productId,String productName,String brand,float mrp, Integer quantity,float weight,float price,Date exdate,Shop shop,String details){
		super();
		this.productId = productId;
		this.productName = productName;
	    this.weight = weight ;
	    this.mrp = mrp;
	    this.price = price;
	    this.details = details;
	    this.exdate = exdate;
	    this.brand = brand;
	    this.quantity = quantity;
	    this.shop = shop;
	 
	}
	
	public Product(Integer productId,String productName,float weight,float mrp,float price,String details,String brand, Integer quantity,Date exdate){
		super();
		this.productId = productId;
		this.productName = productName;
	    this.weight = weight ;
	    this.mrp = mrp;
	    this.price = price;
	    this.details = details;
	    this.exdate = exdate;
	    this.brand = brand;
	    this.quantity = quantity;
	}
	
	
	public Product(String productName,Category category,float weight,String brand,float mrp,float price,Date exdate,Integer quantity,String details){
		super();
		this.productName = productName;
		this.category = category;
	    this.weight = weight ;
	    this.mrp = mrp;
	    this.price = price;
	    this.details = details;
	    this.exdate = exdate;
	    this.brand = brand;
	    this.quantity = quantity;
	}
	
	public Product(Shop shop,ProductDetail productDetail){
		super();
		this.shop = shop;
		this.productName = productDetail.getProductName() ;
		this.weight = productDetail.getWeight();
		this.mrp = productDetail.getMrp();
		this.details = productDetail.getDetails();
		this.quantity = productDetail.getQuantity();
		this.price = productDetail.getPrice();
		this.brand = productDetail.getBrand();
	    this.category = new Category(productDetail.getCategoryId());
	}
	
	
	// ```````````````````````````~~~~~~~~~~~~Methods~~~~~~~~~~~~~````````````````````````````
	
	
	
	//"""""""""""""""""""""""""""""""""""""""""""  getProductsLike(like)          """""""""""""""""""""""""""""""""""""""""""""""""""
	
	
	
	public static ArrayList<Product> getProductsLike(String like){
		
		ArrayList<Product> likeList = new ArrayList<Product>();
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			
			String query = "select product_id,product_name,brand,mrp,quantity,weight,price,expiry_date,shop_id,details from products where product_name like ? ";
		    PreparedStatement pst = con.prepareStatement(query);
		    pst.setString(1,like+"%");
		    
		    ResultSet rs = pst.executeQuery();
		    
		    while(rs.next()){
		    	
		    	 Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getFloat(6),rs.getFloat(7),rs.getDate(8),new Shop(rs.getInt(9)),rs.getString(10));
		         likeList.add(product);
		    }
		}catch(SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return likeList;
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       productNameLike(namelike)            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	  public static ArrayList<String> productNameLike(String nameLike){
	    	
	    	ArrayList<String> nameLikeList = new ArrayList<String>();
	    	
	    	Connection con = null;
	    	
	    	try {
	    		
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
	    		String query = "select product_name from products where product_name like ? ";
	    		
	    		
	    		PreparedStatement pst = con.prepareStatement(query);
	    		
	    		pst.setString(1,nameLike+"%");
	    		
	    	    ResultSet rs =	pst.executeQuery();
	    	   
	    	    while(rs.next()) {
	    	    	nameLikeList.add(rs.getString(1));
	    	    }
	    	    
	    	    
	    		con.close();
	    	}catch(SQLException |ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return nameLikeList;
	    	
	    }
	    
	
	
	
	
	
	
	
	//!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   editProduct(productId) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
     public static Product editProduct(Integer productId) {
    	 Product product1 = null;     
    	 Connection con = null;
    	      try {
    	    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
    	    	    String query = "select product_name,category_id,weight,brand,mrp,price,expiry_date,quantity,details from products where product_id=?";
    	    	    
    	    	    PreparedStatement pst = con.prepareStatement(query);
    	    	    pst.setInt(1, productId);
    	    	    
    	    	    ResultSet rs = pst.executeQuery();
    	    	    
    	    	    if(rs.next()){
    	    	    	
    	    	    	product1 = new Product(rs.getString(1),new Category(rs.getInt(2)),rs.getFloat(3),rs.getString(4),rs.getFloat(5),rs.getFloat(6),rs.getDate(7),rs.getInt(8),rs.getString(9));
     	    	    }
    	    	   
    	      }catch(SQLException|ClassNotFoundException e) {
    	    	  e.printStackTrace();
    	      }
    	      return product1;
     }
	
	
	
	//!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     getAllProducts() ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static ArrayList<Product> gellAllProducts(){
		ArrayList<Product> prolist = new ArrayList<Product>();
		
		Connection con = null;
		
		try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
		   String query = "select product_id,product_name,brand,mrp,quantity,weight,price,expiry_date,shop_id,details from products order by product_id desc";
		   
		   PreparedStatement pst = con.prepareStatement(query);
		   
		   ResultSet rs = pst.executeQuery();
		   while(rs.next()){
			   Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getFloat(6),rs.getFloat(7),rs.getDate(8),new Shop(rs.getInt(9)),rs.getString(10));
			   prolist.add(product);
		   }
		}catch(SQLException | ClassNotFoundException e){
			 e.printStackTrace();
		}
		
		return prolist;
		
	}
	
	
	//!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     deleteProduct() ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 
	public boolean deleteProduct() {
		boolean flag = false;
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			String query = "delete from products where product_id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,productId);
			int rs = pst.executeUpdate();
			if(rs == 1) {
				flag = true;
			} 
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     getSellerProducts(shop)     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static ArrayList<Product> getSellerProducts(Shop shop){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			
			String query = "select product_id,product_name,weight,mrp,price,details,brand,quantity,expiry_date from products where shop_id = ? order by product_id desc";
			 PreparedStatement pst = con.prepareStatement(query);
			 pst.setInt(1,shop.getShopId());
			 
			ResultSet rs =  pst.executeQuery();
			 while(rs.next()) {
				 
				    Product product = new Product (rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getDate(9));
			
				    productList.add(product);
			 }
			 con.close();
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return productList;
	} 
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ AddProduct() ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public  Integer addProduct(){
		
		Connection con = null;
		Integer flag = 0;
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/annapurna?user=root&password=1234");
			 
			 String query2 = "";
			 
			 if(productId == null ){
			     
				  query2= "insert into products(product_name,details,weight,quantity,mrp,price,expiry_date,shop_id,brand,category_id)value(?,?,?,?,?,?,?,?,?,?)";
			 }else {
				 query2 = "update products set product_name =?,details=?,weight=?,quantity=?,mrp=?,price=?,expiry_date=?,shop_id=?,brand=?,category_id=? where product_id=?";
			     flag = 1;
			 }
			    
				 PreparedStatement pst = con.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
				 
				 pst.setString(1, productName);
				 pst.setString(2,details);
				 pst.setFloat(3,weight);
				 pst.setInt(4,quantity);
				 pst.setFloat(5,mrp);
				 pst.setFloat(6,price);
				 pst.setDate(7, exdate);
				 pst.setInt(8,shop.getShopId());
				 pst.setString(9,brand);
				 pst.setInt(10,category.getCategoryId());
				 if(flag==1) {
					 pst.setInt(11, productId);
				 }
				 int i =  pst.executeUpdate();
				 
				 if(i == 1) {
					 
					 ResultSet rs2 =pst.getGeneratedKeys();
					 if(rs2.next()){
						 productId = rs2.getInt(1);
						 if(flag==1) {
							 flag=2;
						 }else if(flag==0) {
							 flag = 3;
						 }
					 }
				 }
			 
		  	}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	 return flag; 
	}
	/*public ProductDetail getProduct() {
		return product;
	}

	public void setProduct(ProductDetail product) {
		this.product = product;
	}*/

	
	public Integer getProductId() {
		return productId;
	}
	public ProductDetail getProduct() {
		return product;
	}

	public void setProduct(ProductDetail product) {
		this.product = product;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public Date getExdate() {
		return exdate;
	}
	public void setExdate(Date exdate) {
		this.exdate = exdate;
	}
	
	
	public Integer getStarRank() {
		return starRank;
	}
	public void setStarRank(Integer starRank) {
		this.starRank = starRank;
	}
	
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	public Integer getStarRankCount() {
		return starRankCount;
	}
	public void setStarRankCount(Integer starRankCount) {
		this.starRankCount = starRankCount;
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}

package models;

public class Wishlist {

	private Integer wishlistId;
	private Customer customer;
	private Product product;
	
	
	public Integer getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}

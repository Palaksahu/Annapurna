package models;

public class CartProduct {

	private Integer cartProductId;
	private Product product;
	private Integer quantity;
	private Cart    cart;
	private Status  status;
	
	
	public Integer getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(Integer cartProductId) {
		this.cartProductId = cartProductId;
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}

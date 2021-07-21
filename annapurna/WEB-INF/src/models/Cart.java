package models;
import java.sql.Date;

public class Cart {
  
	private Integer cartId;
	private Customer customer;
	private Date date ;
	private Integer numOfProducts;
	private Integer totalAmount;
	private Status status;
	private PaymentMode paymentMode;
	
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Integer getNumOfProducts() {
		return numOfProducts;
	}
	public void setNumOfProducts(Integer numOfProducts) {
		this.numOfProducts = numOfProducts;
	}
	
	
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}

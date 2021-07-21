package models;

public class PaymentMode {

	  private Integer paymentModeId;
	  private String  paymentMode;
	  
	  public void setPaymentModeId(Integer paymentModeId) {
		  this.paymentModeId = paymentModeId;
	  }
	  public Integer getPaymentModeId() {
		  return paymentModeId;
	  }
	  
	  public void setPaymentMode(String paymentMode) {
		  this.paymentMode = paymentMode;
	  }
	  public String getPaymentMode() {
		  return paymentMode;
	  }
}


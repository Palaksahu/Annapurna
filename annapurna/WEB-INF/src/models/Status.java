package models;

public class Status{
	
	
	
//-------------------------------------------    Field Summary       --------------------------------------
	
public static final int  ACTIVE = 1;
public static final int  INACTIVE = 2;
public static final int  BLOCKED = 3;
public static final int  DELETED = 4;
public static final int  PROFILEPAGE =5;

	
	
	
	
//-------------------------------------------      CONSTRUCTOR       --------------------------------------
	
	
 private Integer statusId;
 private String  status;
 
 public Status(Integer statusId) {
	  super();
	 this.statusId = statusId;
 }
 public void setStatusId(Integer statusId) {
	 this.statusId = statusId;
 }
 public Integer getStatusId() {
	 return statusId;
 }
 
 
 public void setStatus(String status) {
	 this.status = status;
 }
 public String getStatus() {
	 return status;
 }
 
}

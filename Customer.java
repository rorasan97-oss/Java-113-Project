public class Customer {
	    private String customerID;
	    private String customerName;

	    public Customer(String customerID, String customerName) {
	        this.customerID = customerID;
	        this.customerName = customerName;
	    }

	    // Getters and Setters
	    public String getCustomerID() {
	        return customerID;
	    }

	    public void setCustomerID(String customerID) {
	        this.customerID = customerID;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	
   
	    public String toString() {
	        return "Customer ID: " + customerID + ", Name: " + customerName;
	    }
	}
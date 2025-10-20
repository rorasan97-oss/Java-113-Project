package project;

public abstract class Products {
protected String ProductName ;
protected double price ;
public Products(String ProductName , double price) {
	this.ProductName = ProductName ;
    this.price = price ;
}
public Products(Products p) {
	ProductName = p.ProductName ;
    price = p.price ;	
}
public abstract double calculatePrice();
@Override
public String toString() {
	return "Products [ProductName=" + ProductName + ", price=" + price + "]";
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
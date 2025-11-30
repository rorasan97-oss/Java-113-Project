
import java.io.*;

public class Console extends ElectronicItem implements Serializable{
 private int Storage;
 private  char CDPort;
 
 
 public Console(int Storage , char CDPort , int yearOfRelease ,String ProductName , double price)
 {
    super(yearOfRelease,ProductName,price);
	 this.Storage = Storage;
	 this.CDPort= CDPort;
 }
 public Console(Console c)
 {
 
	   super(c.yearOfRelease,c.ProductName,c.price);
	 this.Storage = c.Storage;
	 this.CDPort= c.CDPort;

 }
 public boolean hasCDPort(){
 if (CDPort == 'Y' || CDPort == 'y')
 return true; 
 else
 return false;
 }
 public double calculatePrice()
 {
	 double totalPrice =0;
	 
	 if(Storage==256)
		 totalPrice  +=super.calculatePrice()+50;
	 else
		 if(Storage==512)
			 totalPrice +=super.calculatePrice()+75;

	 if(hasCDPort())
		 totalPrice+=super.calculatePrice()+60;
	 return  totalPrice;
 }
 public String toString()
 { 
	 return super.toString()+" ,The storage:"+"("+Storage+")"+" ,CD port:"+"("+CDPort+")";
 }   
}

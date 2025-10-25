public class Console extends ElectronicItem
{
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
	 
	 if(Storage==256)
		 price +=super.calculatePrice()+50;
	 else
		 if(Storage==512)
			 price+=super.calculatePrice()+75;

	 if(hasCDPort())
		 price+=super.calculatePrice()+60;
	 return  price;
 }
 public String toString()
 { 
	 return super.toString()+" ,The storage:"+"("+Storage+")"+" ,CD port:"+"("+CDPort+")";
 }
}
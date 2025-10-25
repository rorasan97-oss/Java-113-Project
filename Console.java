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
	 double price = super.calculatePrice();
	 if(Storage==256)
		 price +=50;
	 else 
		 if(Storage==512)
			 price+=75;

	 if(hasCDPort())
		 price+=60;
	 return  price;
 }
 public String toString()
 { 
	 return super.toString()+" ,The storage:"+Storage+" ,CD port:"+CDPort;
 }
}
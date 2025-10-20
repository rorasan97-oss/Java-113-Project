package project;

public class Console extends ElectronicItem
{
  private int Storage;
 private  boolean hasCDProt;
 
 public Console(int yearOfRelease , String brand , String PrdctName , double price ,int Storage , boolean hasCDProt )
 {
	 super(yearOfRelease , brand ,  PrdctName ,  price );
	 this.Storage = Storage;
	 this.hasCDProt= hasCDProt;
 }
 public double calculatePrice()
 {
	 double price = super.calculatePrice();
	 if(Storage==256)
		 price +=50;
	 else 
		 if(Storage==512)
			 price+=75;
		 else
			 if(Storage==1024)
				 price+=150;
			 else
				 if(Storage==2048)
					 price+=250;
	 if(hasCDProt)
		 price+=60;
	 return  price;
 }
 public String toString()
 { 
	 return super.toString()+" ,The storage:"+Storage+" ,CD port:"+hasCDProt;
 }
}

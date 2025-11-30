import java.io.*;


public class ElectronicItem extends Products implements Serializable{
    protected  int yearOfRelease ;

public ElectronicItem()
{
	yearOfRelease = 0;


}
public ElectronicItem (int yearOfRelease ,String ProductName , double price ){
super ( ProductName , price);
this.yearOfRelease = yearOfRelease;

 }
public  ElectronicItem( ElectronicItem e) {
	super(e.ProductName, e.price);
	this.yearOfRelease = e.yearOfRelease;

}

public String toString(){
return super.toString() + " \n The year: " +"(" +yearOfRelease+")"; }

public double calculatePrice(){
double totalprice = price;
if (yearOfRelease < 2015)
totalprice = totalprice * 0.50;
return totalprice;
}
public void setYearOfRelease(int yearOfRelease){
this.yearOfRelease = yearOfRelease;
}

public int getyearOfRelease(){
return yearOfRelease;
}
}

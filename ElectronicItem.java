public class ElectronicItem extends Products {
private int yearOfRelease ;

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
@Override
public String toString(){
return super.toString() + " \n The year of release of the electronic Item: " + yearOfRelease; }
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
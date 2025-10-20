public class ElectronicItem extends Products {
private int yearOfRelease ;
private String brand;
 public ElectronicItem (int yearOfRelease , String brand , String PrdctName , double price ){
super ( PrdctName , price);
this.yearOfRelease = yearOfRelease;
this.brand = brand;
 }
@Override
public String toString(){
return super.toString() + " \n The year of release of the electronic Item: " + yearOfRelease + " The brand of the electronic Item: " + brand; }
public double calculateGrade(){
double totalprice = price;
totalprice = price;
if (yearOfRelease < 2015)
totalprice = totalprice * 0.50;
return totalprice;
}
public void setYearOfRelease(int yearOfRelease){
this.yearOfRelease = yearOfRelease;
}
public void setBrand(String brand){
this.brand = brand;
}
public int getyearOfRelease(){
return yearOfRelease;
}
public String getBrand(){
return brand;
}
}

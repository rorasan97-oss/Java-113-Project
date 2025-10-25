public class VideoGame extends Products
{
private boolean Status;
private char type;
public VideoGame (char type, String ProductName , double price){
super (ProductName , price);
this.type = type;
}
public VideoGame(VideoGame v) {
	super(v.ProductName, v.price);
	this.type = v.type;
}

public String toString(){
return super.toString() + ", Game Type:" +"("+ type+")";
}
public double calculatePrice(){
double totalprice = price;
if ( type==('D') || type==('d')){
totalprice = totalprice - 0.50 * totalprice;
}
return totalprice;
}
public void setType(char type){
this.type = type;
}
public char getType(){
return type;
}
}
public class VideoGame extends Products
{
private boolean Status;
private String type;
public VideoGame (boolean Status, String type, String PrdctName , double price){
super (PrdctName , price);
this.Status = Status;
this.type = type;
}
@Override
public String toString(){
return super.toString() + ", Game Type:" + type + " is the Video Game new? " + ( Status? " New Game": "");
}
public double calculatePrice(){
double totalprice = price;
if ( type.equalsIgnoreCase("digital")){
totalprice = totalprice - 0.50 * totalprice;
}
if (Status == false){ // game is old 
totalprice = totalprice * 0.30;
}
return totalprice;
}
public void setType(String type){
this.type = type;
}
public void setStatus(boolean Status){
this.Status = Status;
}
public String getType(){
return type;
}
public boolean getStatus(){
return Status;
}
}

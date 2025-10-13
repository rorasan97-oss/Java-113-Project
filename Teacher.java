public class Teacher extends Employee{
private int Sections;
public Teacher(int Empid , String name , double salary , int Sections){
super ( Empid , name , salary );
this.Sections =Sections;
}
public int getSections(){
return Sections;
}
public void setSections(int Sections){
this.Sections =Sections;
}
public double CalculateSalary(){
return getSalary() + ( Sections * 1500 );
}

public String toString(){
return super.toString() + ", Sections" + Sections;
}
}
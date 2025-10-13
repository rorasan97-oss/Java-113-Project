public class Staff extends Employee{
private double hours;

public Staff(int Empid , String name , double salary , double hours){
super ( Empid , name , salary );
this.hours =hours;
}
public double CalculateSalary(){
return getSalary()  + ( getSalary() * 0.2 * hours );
}

public String toString(){
return super.toString() + ", Hours" + hours;
}
}
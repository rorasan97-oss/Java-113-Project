public class Employee {
protected int Empid;
protected String name;
protected double salary;
public Employee ( int Empid , String name , double salary){
this.Empid =Empid;
  this.name=name ;
   this.salary=salary;  
}
public String toString(){
return "Employee ID" + Empid + " Employee Name: " +name + " Employee Salary: " + salary ;

}
public int getEmpid(){
return Empid;
}
public void setEmpid(int empid){
this.Empid =empid;
}
public String getName(){
return name;
}
public void setName(String name){
this.name =name;
}
public double getSalary(){
return salary;
}
public void setSalary(double salary){
this.salary =salary;
}}
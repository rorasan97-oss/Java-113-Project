public class TestEmp{
public static void main(String [] args){
Employee obj1 = new Employee(111,"Ahmad", 10000);
Teacher obj2 = new Teacher(222,"Ali", 3000 ,5 );
Staff obj3 = new Staff(333,"Saad", 8000 ,3 );
System.out.println(obj1.toString());
System.out.println(obj2.toString() + " , Final salary" + obj2.CalculateSalary());
System.out.println(obj3.toString()+ " , Final salary" + obj3.CalculateSalary());

}
}
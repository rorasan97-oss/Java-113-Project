public class Computer_Lab extends lab{
private boolean computerDamage ;
 public Computer_Lab (boolean hasProject , String courseID , String courseName , double Grade,boolean computerDamage ){
 super(hasProject ,courseID , courseName ,Grade);
 this.computerDamage = computerDamage;
 }
@Override
public String toString(){
return super.toString() + " \n Does the computer have dammage after use?: " + (computerDamage? " There is a damage": "");
}
public double calculateGrade(){
double totalGrade = super.calculateGrade();

if (computerDamage == true)
totalGrade = totalGrade - 5;
return totalGrade;
}
}

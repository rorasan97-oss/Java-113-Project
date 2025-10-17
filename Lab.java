public class Lab 
{
private boolean hasProject;
public Lab (boolean hasProject , String courseID , String courseName , double Grade){
super (courseID , courseName , Grade);
this.hasProject = hasProject;
}
@Override
public String toString(){
return super.toString() + " Does the Lab course have a a project? " + ( hasProject? " There is a project": "");
}
public double calculateGrade(){
double totalGrade = Grade;
if (hasProject == true)
totalGrade = totalGrade + 10;
return totalGrade;
}
}

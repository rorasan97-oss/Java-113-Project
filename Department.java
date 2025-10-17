package project;

public class Department {
     private String deptName;
     private  Course[] clist; 
     private int numOfCourses;
     
     public Department(String deptName , int size )
     {
    	 this.setDeptName(deptName);
    	 clist=new Course[size];
     }
     public boolean addCourse(Course c)
     {
    	 if(numOfCourses < clist.length)
    	 {
    		 clist[numOfCourses++]=new Course (c);
    		 return true;
    	 }
    	 else
    		 return false;
     }
     public int searchCourse(String courseID) 
     {
    	 for(int i=0;i<numOfCourses;i++)
    	 {
    		 if(clist[i].getCourseID().equals(courseID))
    			 return i;
    	 }
    	 return -1;
     }
     
     public boolean removeCourse(String courseID)
     {
    	 int indexOfTheCourse = searchCourse(courseID);
    	 if( indexOfTheCourse!=-1)
    	 { 
    		for(int i= indexOfTheCourse;i<numOfCourses-1;i++)
    			clist[ indexOfTheCourse]= clist[ indexOfTheCourse+1];
    		clist[--numOfCourses]=null;
    			return true;
         }	 
    	 return false;
     }
	 public String getDeptName() {
		return deptName;
	 }
	 public void setDeptName(String deptName) {
		this.deptName = deptName;
	 }
	 public int getNumOfCourses() {
			return numOfCourses;
		 }
	 
}

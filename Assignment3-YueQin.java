//Problem3_1
package Assignment3_1;

public class Student {
	String name;
	int id;
	

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
        return name;
	}
	
	 public void setName(String name) {
	        
	    	this.name = name;
	    }

	 public static void main(String[] args) {
	        int n=100000;
	        double di= ((double)5)/81;
	        System.out.println(di);
	 }
}
//------------------------------------------------------------------------------------------------------------
package Assignment3_1;

import java.util.ArrayList;

public class Course {
	String name;
	int numberOfStudent;
	ArrayList<Student> list ;

	public Course(String name,ArrayList<Student> list) {
		this.name= name;   
		this.numberOfStudent=0;
		this.list= list;
	} 
	
	public void  getStudents() {
		for (int i=0;i<this.list.size();i++) {
			Student g = (Student)this.list.get(i);
			System.out.println(g.name+" "+g.id+" ");
		}
	}
	
	public boolean isFull() {
		if (this.numberOfStudent==10)
			return true;
		else
			return false;
	}
	
	public void getData() {
		System.out.println("Course Name: "+this.name+"  |  "+"Number of Students: "+this.numberOfStudent);
	}
	
	public void registerStudent(Student student) {
		
		if(this.numberOfStudent<10) {
			this.list.add(student);
			this.numberOfStudent+=1;
			for(int i=0;i<this.list.size();i++){
	            for(int j=i+1;j<this.list.size();j++){
	                if(this.list.get(i)==this.list.get(j)){
	                    this.list.remove(j);
	                    this.numberOfStudent-=1;
	                    System.out.println("You have already registered in this course.");
	                    j--;
	                }
	            }
		    }
			
		}
		else {
			System.out.println("This course is full. Your registration fails.");
		}
	}
	

}

//------------------------------------------------------------------------------------------------------------
package Assignment3_1;

import java.util.ArrayList;

import Assignment3_2.ReverseBuilder;
import Assignment3_3.Professor;
import Assignment3_3.Professor.Builder;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Student anne = new Student("Anne",1);
		Student bob = new Student("Bob",2);
		Student carmelo = new Student("Carmelo",3);
		Student dell = new Student("Dell",4);
		Student ella = new Student("Ella",5);
		Student fiona = new Student("Fiona",6);
		Student gary = new Student("Gary",7);
		Student helen = new Student("Helen",8);
		Student irene = new Student("Irene",9);
		Student jane = new Student("Jane",10);
		Student kevin = new Student("Kevin",11);
		
		ArrayList<Student> mathStudents = new ArrayList<Student>();
		Course math = new Course("Math",mathStudents);
		
	    math.registerStudent(kevin);
	    math.registerStudent(jane);
	    math.registerStudent(irene);
	    math.registerStudent(helen);
	    math.registerStudent(gary);
	    math.registerStudent(fiona);
	    math.getData();
	    math.registerStudent(ella);
	    math.registerStudent(ella);
	    math.registerStudent(dell);
	    math.registerStudent(carmelo);
	    math.registerStudent(bob);
	    math.registerStudent(anne);
	    
	    math.getData();
	    math.getStudents();
	    math.isFull();
	}
}
//------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------
//Problem3_2
package Assignment3_2;

public class ReverseBuilder {

	public static void main(String[] args) {
		ReverseBuilder r = new ReverseBuilder();
		System.out.println(r.reverse("  I    love you till the world ends    "));
		System.out.println(r.reverse("  I love you     till the world ends   "));
		System.out.println(r.reverse("I love you till the world ends "));
		System.out.println(r.reverse("I love you till the world ends"));
	}
	

    public String reverse(String s){
	    int pos=0;
	    StringBuilder sb=new StringBuilder();
	    for(int h=0;h<s.length();h++) {
	    	char b = s.charAt(h);
	    	if(b==' ') {
	    		continue;
	    	}
	    	else {
	    		for(int i=h;i<s.length()-1;i++){
	    			  char c=s.charAt(i);
	    			  char d=s.charAt(i+1);
	    			  if(c==' '){
	    				  if(d==' ') {
	    					  continue;
	    				  }
	    				  else {
	    					  pos=0;
	    				  }
	    			  }
	    			  sb.insert(pos,c);
	    			  if(c!=' '){
	    				  pos++;
	    			  }
	    		  }
	    		break;
	    	}
	    }
	    int j=s.length()-1;
	    char e =s.charAt(j);
	    if(e==' ') {
	    	return sb.toString();
	    }
	    else {
	    	sb.insert(pos,e);
	    	return sb.toString();
	    }
	}
}
//------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------
//Credit problem
package Assignment3_3;

public class Professor {
	private String firstName;
	private String lastName;
	private int id;
	
	public static class Builder{
		private String firstName;
		private String lastName;
		private int id;
		
		public Builder(String firstName, String lastName) {
			this.firstName=firstName;
			this.lastName= lastName;
		}
		
		public Builder setProfessorID(int id) {
			this.id=id;
			return this;
		}
		
		public Professor build() {
			return new Professor(firstName, lastName, id);
		}
	
	}
	
	public Professor(String firstName, String lastName, int id) {
		this.firstName= firstName;
		this.lastName = lastName;
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getID() {
		return id;
	}

}
//------------------------------------------------------------------------------------------------------------
package Assignment3_3;

public class Test {

	public static void main(String[] args) {
		Professor professor = new Professor.Builder("Kobe","Bryant")
				.setProfessorID(8024).build();
		System.out.println(professor.getFirstName()+" "
				+professor.getLastName()+" "+professor.getID());
	}

}

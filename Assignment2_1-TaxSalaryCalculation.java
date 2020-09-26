package assignment2_1;

public class Employee {
	String name;
	int age;
	Gender gender;
	double salary;

	// Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
         this.name =name;
         this.age = age;
         this.gender = gender;
         this.salary= salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        return name;
    	
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        //write your code here
    	this.name = name;
    }

    //Try to add a new method in Employee class: public void raiseSalary(double byPercent)
    public void raiseSalary(double byPercent) {
    	this.salary = this.salary*(1+byPercent);
    }
	
	
}

enum Gender {
    MALE,
    FEMALE;
}

//----------------------------------------------------------------------------------------


package assignment2_1;

import java.util.ArrayList;
import java.util.Comparator;

public class TaxSalaryCalculation {
	
	/*
    * Write a method to calculate the Social Security Tax of an employee and print it.
    * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
    * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
    */
	public double socialSecurityTax(Employee employee) {
        //write your code here
		double ssTax = 0;
		if(employee.salary <= 8900) {
		    ssTax = employee.salary * 0.062;
		}
		else if(employee.salary > 8900){
			ssTax = 106800 * 0.062;
		}
	
		return ssTax;
    }
	
	
	/*
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
	public double insuranceCoverage(Employee employee) {
	    //write your code here
		double coverage= 0;
		if(employee.age<35) {
			coverage= employee.salary*0.03;
		}
		else if(employee.age>=35 && employee.age<=50) {
			coverage= employee.salary*0.04;
		}
		else if(employee.age>50 && employee.age<60) {
			coverage= employee.salary*0.05;
		}
		else if(employee.age>60) {
			coverage= employee.salary*0.06;
		} 
		return coverage;
	}


	/*
    * Write a method to sort three employees' salary from low to high, and then print their name in order.
    * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
    * John Alice Jenny
    */
	public void sortSalary(Employee e1, Employee e2, Employee e3) {
	    //write your code here
		ArrayList<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

		list.sort(Comparator.comparingDouble(e -> e.salary));
		
		for(Employee e:list) {
			System.out.println(e.getName());
		}
	}
	
	
	/*
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
	public void tripleSalary(Employee employee) {
        //write your code here
		employee.raiseSalary(2.00);
    }

	
	

    //Test
	public static void main(String[] args) {
		Employee Jane = new Employee("jane",25, Gender.FEMALE, 9000.11);
		Employee Melo = new Employee("melo",23, Gender.MALE, 6700.22);
		Employee Rose = new Employee("rose",24, Gender.MALE,10000.88);
		TaxSalaryCalculation cal = new TaxSalaryCalculation();
		double result = cal.socialSecurityTax(Jane);
		double result1= cal.insuranceCoverage(Jane);
		System.out.println(result);
		System.out.println(result1);
		cal.sortSalary(Jane,Melo,Rose);
		cal.tripleSalary(Melo);
		System.out.println(Melo.salary);
		
	}
	
	/*
	 * Extra Credit
	 * The problem is in the swap function. 
	 * This function only changes the pointing of the variables,
	 * but doesn't change their original value.
	 * To solve this problem, an array should be used,
	 * or we can reset the values of the variables.
	 */
}

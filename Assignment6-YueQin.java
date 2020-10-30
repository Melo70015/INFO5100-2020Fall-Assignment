//Assignment6-A

package Assignment6_A;
import java.util.*;
import java.text.DecimalFormat;

public class Mreview implements Comparable<Mreview>{
	private String title;
	private ArrayList<Integer> ratings;

	public Mreview() {
		this.title="";
		this.ratings= new ArrayList<Integer>();
	}
	
	public Mreview(String title) {
		this.title= title;
		this.ratings = new ArrayList<Integer>();
		
	}
	
	public Mreview (String title, int firstRating) {
		this.title= title;
		this.ratings= new ArrayList<Integer>();
		this.ratings.add(firstRating);
		//System.out.println(this.ratings.size());
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addRating(int r) {
		this.ratings.add(r);
	}
	
	public double aveRating() {
		double aveRating;
		int sumRatings=0;
		int ir=0;
		for (int i = 0; i < this.ratings.size(); i++) {
			ir = this.ratings.get(i);
			sumRatings=sumRatings+ir;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		aveRating= Double.parseDouble(df.format((float)sumRatings/this.numRatings()));
		return aveRating;
	}
	
	public int numRatings() {
		int num;
		num= this.ratings.size();
		return num;
	}
	
	public int compareTo(Mreview mr) {
		if(this.title.compareTo(mr.title)>0) 
		    return 1;
		if(this.title.compareTo(mr.title)<0)
			return -1;
		return 0;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Mreview) {
			Mreview mr = (Mreview) obj;
			if(this.title==mr.title) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String s = this.getTitle()+", average "+this.aveRating()+" out of "+this.numRatings()
		+" ratings";
		return s;
	}
	

	public static void main(String[] args) {
		Mreview bm = new Mreview("Batman2",10);
		Mreview im = new Mreview("Ironman1",9);
		Mreview tdkr= new Mreview("Batman2",9);
		bm.addRating(8);
		bm.addRating(9);
		bm.addRating(9);
		bm.addRating(10);
		bm.addRating(7);
		bm.addRating(7);
		System.out.println(bm.toString());
		if(bm.equals(tdkr)==true)  System.out.println("They equal.");
		else System.out.println("They are different.");
		if(bm.equals(im)==true)  System.out.println("They equal.");
		else System.out.println("They are different.");
	}
}

//-----------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------

//Assignment6-B

package Assignment6_B;

public class Account {
	protected String fName;
	protected String lName;
	protected double curBalance;
	
	public Account(String fName, String lName, double curBalance) {
		this.fName= fName;
		this.lName= lName;
		this.curBalance= curBalance;
	}
	
	public String getAcctType(){
		return this.getClass().getSimpleName();
	}
	
	public double DebitTransaction(double debitAmount) {
		this.curBalance= this.curBalance-debitAmount;
		return this.curBalance;		
	}
	
	public double CreditTransaction(double creditAmount) {
		this.curBalance=this.curBalance+creditAmount;
		return this.curBalance;
	}
	
	public String toString(){
		String s = "Account Name: "+this.fName+" "+this.lName+", Account Type: "+this.getAcctType()
		+", Balance $"+String.format("%.2f", this.curBalance);
		return s;
	}
	
	public static void main(String[] args)
    {
        Account ac1 = new Account("John", "Smith", 100);
        System.out.println(ac1);

        ac1.DebitTransaction(30.25); // should be $69.75
        System.out.println(ac1);

        ac1.CreditTransaction(10.10);
        System.out.println(ac1); // should be $79.85
    }
}

//-----------------------------------------------------------------------------------------------

package Assignment6_B;

public class CheckingAccount extends Account{
	static private double chargeFee=10;
	static private double MinBalance=100;

	public CheckingAccount(String fName, String lName, double cb) {
		super(fName,lName,cb);
	}

	public double DebitTransaction(double debitAmount) {
		super.DebitTransaction(debitAmount);
		this.ChargeFee();
		return this.curBalance;
	}
	
	public double CreditTransaction (double creditAmount) {
		super.CreditTransaction(creditAmount);
		this.ChargeFee();
		return this.curBalance;
	}
	
	private void ChargeFee() {
		if (this.curBalance<MinBalance) {
			this.curBalance= this.curBalance-chargeFee;
		}
	}
	
	public static void main(String[] args) {
	    CheckingAccount ch1 = new CheckingAccount("Steve", "Jobs", 50); // he was poor once before
        System.out.println(ch1);

        ch1.DebitTransaction(0.25); // he was cheap back then too
        System.out.println(ch1);    // should be $39.75 (= $49.75 - $10 fee)

        ch1.CreditTransaction(7.00); // small expense check
        System.out.println(ch1);     // should be $36.75 (= $39.75 + $7.00 - $10 fee)

        ch1.CreditTransaction(1000000); // a huge bonus!!
        System.out.println(ch1); // should be $1000036.75

	}

}

//-----------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------

//Assignment6-C

package Assignment6_C;
import java.util.HashMap;

import Assignment6_C.Boardable;
import Assignment6_C.Pet;

public class Pet {
	private String petName;
	private String ownerName;
	private String color;
	protected int sex;
	
	protected static final int indexMale = 1;
	protected static final int indexFemale= 2;
	protected static final int indexSpayed= 3;
	protected static final int indexNeutered = 4;
	
	protected static final String Male = "Male";
	protected static final String Female = "Female";
	protected static final String Spayed = "Spayed";
	protected static final String Neutered = "Neutered";
	
	protected static final HashMap<Integer,String>sexMap = new HashMap<Integer,String>();
	static {
		sexMap.put(indexMale, Male);
		sexMap.put(indexFemale, Female);
		sexMap.put(indexSpayed, Spayed);
		sexMap.put(indexNeutered, Neutered);
	}
	

	public Pet(String petName, String ownerName, String color) {
		this.petName= petName;
		this.ownerName= ownerName;
		this.color= color;
	}
	
	public String getPetName() {
		return petName;		
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setSex(int sexid) {
		this.sex= sexid;
	}
	
	public String getSex() {
		String s = sexMap.get(this.sex);
		return s;
	}
	

	public String toString() {
		String s =this.getPetName()+" owned by "+this.getOwnerName()+"\nColor: "
	    +this.getColor()+"\nSex: "+this.getSex();
		return s;
	}
	
	public static void main(String[] args) {
		Cat c1 = new Cat("Tom","Bob","black","short");
		Dog d1 = new Dog("Spot", "Susan","white","medium");
		c1.setSex(3);
		d1.setSex(3);
		c1.setBoardEnd(4, 15, 2020);
		c1.setBoardStart(1,1,2000);
		if(c1.boarding(3, 12, 2021)==true) 
			System.out.println("Chosen date boardable");
		else
			System.out.println("Chosen date not boardable");
	    System.out.println(c1.toString());
		System.out.println(d1.toString());
	}
}

//-----------------------------------------------------------------------------------------------

package Assignment6_C;

public interface Boardable {
	void setBoardStart(int month, int day, int year); 
	void setBoardEnd(int month, int day, int year); 
	boolean boarding(int month, int day, int year); 

}

//-----------------------------------------------------------------------------------------------

package Assignment6_C;

public class Cat extends Pet implements Boardable{
	private String hairLength;
	
	private int startMonth;
	private int startDay;
	private int startYear;
	
	private int endMonth;
	private int endDay;
	private int endYear;
	
	

	public Cat(String petName, String ownerName, String color,String hairLength) {
		super(petName,ownerName,color);
		this.hairLength= hairLength;
	}
	
	public String getHairLength() {
		return hairLength;
	}
	
	
	public void setBoardStart(int month, int day, int year) {
		this.startMonth= month;
		this.startDay= day;
		this.startYear= year;
	}
	
	public void setBoardEnd(int month, int day, int year){
		this.endMonth= month;
		this.endDay= day;
		this.endYear= year;
		
	}
	
	public boolean boarding(int month, int day, int year) {
		if(year>startYear && year< endYear)
		    return true;
	    if (year== startYear && month > startMonth)
			return true;
	    if(year == startYear && month == startMonth && day>=startDay)
	    	return true;
	    if (year== endYear && month <endMonth)
	    	return true;
	    if (year== endYear && month== endMonth && day<=endDay)
	    	return true;
		return false;
	}
	
	@Override
	public String toString() {
	    String s ="CAT: \n"+this.getPetName()+" owned by "+this.getOwnerName()+"\nColor: "
		    +this.getColor()+"\nSex: "+this.getSex()+"\nHair: "+this.getHairLength();
	    return s;
	}

}

//-----------------------------------------------------------------------------------------------

package Assignment6_C;

public class Dog extends Pet implements Boardable{

private String size;
	
	private int startMonth;
	private int startDay;
	private int startYear;
	
	private int endMonth;
	private int endDay;
	private int endYear;
	
	

	public Dog(String petName, String ownerName, String color,String size) {
		super(petName,ownerName,color);
		this.size= size;
	}
	
	public String getSize() {
		return size;
	}
	
	
	public void setBoardStart(int month, int day, int year) {
		this.startMonth= month;
		this.startDay= day;
		this.startYear= year;
	}
	
	public void setBoardEnd(int month, int day, int year){
		this.endMonth= month;
		this.endDay= day;
		this.endYear= year;
		
	}
	
	public boolean boarding(int month, int day, int year) {
		if(year>startYear && year< endYear)
		    return true;
	    if (year== startYear && month > startMonth)
			return true;
	    if(year == startYear && month == startMonth && day>=startDay)
	    	return true;
	    if (year== endYear && month <endMonth)
	    	return true;
	    if (year== endYear && month== endMonth && day<=endDay)
	    	return true;
		return false;
	}
	
	@Override
	public String toString() {
	    String s ="DOG: \n"+this.getPetName()+" owned by "+this.getOwnerName()+"\nColor: "
		    +this.getColor()+"\nSex: "+this.getSex()+"\nSize: "+this.getSize();
	    return s;
	}

}


//-----------------------------------------------------------------------------------------------
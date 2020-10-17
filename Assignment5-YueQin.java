package Assignment5;

import java.util.Vector;
import Assignment5.DessertShoppe;
import java.text.DecimalFormat;

public class Checkout {
	Vector itemlist = new Vector();
	
	public int numberOfItems() {
		int n = itemlist.size();
		return n;
	}
	
	public void enterItem(DessertItem item) {
		this.itemlist.addElement(item);
	}
	
	public void clear() {
		this.itemlist.clear();
	}
	
	public int totalCost() {
		int totalcost=0;
		
		for(int i=0; i <= itemlist.size()-1;i++) {
			Object item = itemlist.get(i);
			if(item instanceof Sundae) {
				Sundae sundae = (Sundae)item;
				totalcost= totalcost+ sundae.getCost();
				continue;
			}
			else if(item instanceof IceCream) {
				IceCream icecream = (IceCream)item;
				totalcost = totalcost + icecream.getCost();
				continue;
			}
			else if(item instanceof Cookie) {
				Cookie cookie = (Cookie)item;
				totalcost = totalcost + cookie.getCost();
			}
			else if(item instanceof Candy) {
				Candy candy = (Candy)item;
				totalcost = totalcost + candy.getCost();
			}
		}
		 return totalcost;
	}
	
	public int totalTax() {
        int totalcost=0;
		for(int i=0; i <= itemlist.size()-1;i++) {
			Object item = itemlist.get(i);
			if(item instanceof Sundae) {
				Sundae sundae = (Sundae)item;
				totalcost= totalcost+ sundae.getCost();
				continue;
			}
			else if(item instanceof IceCream) {
				IceCream icecream = (IceCream)item;
				totalcost = totalcost + icecream.getCost();
				continue;
			}
			else if(item instanceof Cookie) {
				Cookie cookie = (Cookie)item;
				totalcost = totalcost + cookie.getCost();
			}
			else if(item instanceof Candy) {
				Candy candy = (Candy)item;
				totalcost = totalcost + candy.getCost();
			}
		}
		double tax = Math.round(DessertShoppe.taxRate*totalcost);
		int totaltax= (int)tax;
		return totaltax;
	}
	
	@Override
	public String toString() {
		String s="";
		s=s+DessertShoppe.nameShop+"\n";
		int length = DessertShoppe.nameShop.length();
		for(int i=1;i<=length;i++){
			s=s+"-";
		}
		s=s+"\n"+"\n";
		for(int i=0; i<=itemlist.size()-1;i++) {
			Object item= itemlist.get(i);
			if(item instanceof Sundae) {
				Sundae sundae = (Sundae)item;
				String s2=DessertShoppe.cents2DollarsAndCents(sundae.getCost());
				String s1= sundae.nameTopping+" Sundae with\n"+sundae.name+" "+s2+"\n";
				s=s+s1;
				continue;
			}
			else if(item instanceof IceCream) {
				IceCream ic = (IceCream)item;
				String ic2= DessertShoppe.cents2DollarsAndCents(ic.getCost());
				String ic1= ic.name+" "+ic2+"\n";
				s=s+ic1;
				continue;
			}
			else if(item instanceof Cookie) {
				Cookie cookie= (Cookie) item;
				String cookie2u= DessertShoppe.cents2DollarsAndCents(cookie.unitPrice);
				String cookie2= DessertShoppe.cents2DollarsAndCents(cookie.getCost());
				String cookie1= cookie.number+" @ "+cookie2u+" /dz.\n"+cookie.name+" "+cookie2+"\n";
				s=s+cookie1;
			}
			else if(item instanceof Candy) {
				Candy candy = (Candy)item;
				DecimalFormat df = new DecimalFormat("######0.00");  
				String weightu=df.format(candy.weight);
				String candy2u= DessertShoppe.cents2DollarsAndCents(candy.unitPrice);
				String candy2= DessertShoppe.cents2DollarsAndCents(candy.getCost());
				String candy1= weightu+" lbs. @ "+candy2u+" lb.\n"+candy.name+" "+candy2+"\n";
				s=s+candy1;
			}
		}
	    int totalcost=0;
			for(int i=0; i <= itemlist.size()-1;i++) {
				Object item = itemlist.get(i);
				if(item instanceof Sundae) {
					Sundae sundae = (Sundae)item;
					totalcost= totalcost+ sundae.getCost();
					continue;
				}
				else if(item instanceof IceCream) {
					IceCream icecream = (IceCream)item;
					totalcost = totalcost + icecream.getCost();
					continue;
				}
				else if(item instanceof Cookie) {
					Cookie cookie = (Cookie)item;
					totalcost = totalcost + cookie.getCost();
				}
				else if(item instanceof Candy) {
					Candy candy = (Candy)item;
					totalcost = totalcost + candy.getCost();
				}
			}
			double tax = Math.round(DessertShoppe.taxRate*totalcost);
			int totaltax= (int)tax;
			String ttax= DessertShoppe.cents2DollarsAndCents(totaltax);
			String tcost= DessertShoppe.cents2DollarsAndCents(totalcost);
			String ftax="Tax "+ttax+"\n";
			String fcost="Total Cost "+tcost;
			s=s+ftax+fcost;
		return s;
	}
	
}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class DessertItem
package Assignment5;

public abstract class DessertItem {
	 String name;

	public DessertItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class DessertShoppe 
package Assignment5;

public class DessertShoppe {
	static String nameShop;
	static double taxRate;
	static int nameSize;
	static int displayWidth;

	static public void nameValue(String x) {
		nameShop =x;
	}
	static public void rateValue(double x) {
		taxRate=x;
	}
	static public void sizeValue(int x) {
		nameSize=x;
	}
	static public void widthValue(int x) {
		displayWidth = x;
	}
	
	static public String cents2DollarsAndCents(int cents) {
		int a = cents/100;
		int b = cents%100;
		if(a>0){
			if(b>=0 && b<=9) {
				return (a+".0"+b);
			}
			else {
				return(a+"."+b);
			}
		}
		else {
			if(b>=0 && b<=9) {
				return (".0"+b);
			}
			else {
				return("."+b);
			}
		}
		
	}
}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class Candy
package Assignment5;

public class Candy extends DessertItem{
	double weight;
	int unitPrice;//cent

	public Candy(String name, double weight, int unitPrice) {
		super(name);
		this.weight=weight;
		this.unitPrice= unitPrice;
	}
	
	public int getCost() {
		double cost1 = Math.round(this.unitPrice*this.weight);
		int cost= (int)cost1;
		return cost;
	}

}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class Cookie
package Assignment5;


public class Cookie extends DessertItem{
	int number;
	int unitPrice;//cent

	public Cookie(String name, int number, int unitPrice) {
		super(name);
		this.number= number;
		this.unitPrice= unitPrice;
	}
	
	public int getCost() {
		double cost1 = Math.round((this.unitPrice*this.number)/12);
		int cost= (int)cost1;
		return cost;
	}

}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class IceCream
package Assignment5;

public class IceCream extends DessertItem{
	int cost;//cent

	public IceCream(String name, int cost) {
		super(name);
		this.cost= cost;
	}
	
	public int getCost() {
		return cost;
	}

}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class Sundae
package Assignment5;

public class Sundae extends IceCream{
	String nameTopping;
	int costTopping;

	public Sundae(String name, int cost, String nameTopping, int costTopping) {
		super(name, cost);
		this.nameTopping= nameTopping;
		this.costTopping= costTopping;
	}
	
	public int getCost() {
		int cost1 = this.cost+this.costTopping;
		return cost1;
	}

}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//Class TestCheckOut
package Assignment5;

public class TestCheckOut {

	public static void main(String[] args) {
		DessertShoppe.nameValue("\nM & M Dessert Shoppe");
		DessertShoppe.rateValue(0.065);
		Checkout checkout = new Checkout();
	     checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
	     checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
	     checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
	     checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
	     System.out.println("Number of items: " + checkout.numberOfItems());
	     System.out.println("Total cost: " + checkout.totalCost() );
	     System.out.println("Total tax: " + checkout.totalTax() );
	     System.out.println("Cost + Tax: " + (checkout.totalCost() +checkout.totalTax()) );
	     System.out.println(checkout);
	     checkout.clear();
	     checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
	     checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel",50));
	     checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
	     checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
	     checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
	     checkout.enterItem(new Candy("Candy Corn", 3.0, 109));
	     System.out.println("Number of items: " + checkout.numberOfItems());
	     System.out.println("Total cost: " + checkout.totalCost() );
	     System.out.println("Total tax: " + checkout.totalTax());
	     System.out.println("Cost + Tax: " + (checkout.totalCost() +checkout.totalTax()) );
	     System.out.println(checkout);
	}
	
}

//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

//The answer to the credit problem is in another file.


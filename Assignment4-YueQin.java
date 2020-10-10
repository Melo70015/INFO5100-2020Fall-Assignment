//Assignment4_1
package Assignment4_1;

public class Test {

	

	public static void main(String[] args) {
		Test t = new Test();
		int[] a= {3, 2, 1, 5, 6, 4};
		Element a1 = new Element(a,3);
		int[] b = {1,2,2,2,3,3,4,4,4,5};
		Element b1 = new Element(b,1);
		Element b2 = new Element(b,2);
		Element b3 = new Element(b,3);
		Element b4 = new Element(b,4);
		Element b5 = new Element(b,5);
		Element b6 = new Element(b,6);
		Element b7= new Element(b,0);
		int[] c = {1,1,1,1,1,1,1};
		Element c1 = new Element(c,1);
		Element c2 = new Element(c,2);
		Element c3 = new Element(c,3);
		t.elementFinder(a1);
		t.elementFinder(b1);
		t.elementFinder(b2);
		t.elementFinder(b3);
		t.elementFinder(b4);
		t.elementFinder(b5);
		t.elementFinder(b6);
		t.elementFinder(b7);
		t.elementFinder(c1);
		t.elementFinder(c2);
		t.elementFinder(c3);

	}
	
	public void elementFinder(Element example) {
		if(example.kth<=0 || example.kth>example.elements.length || example.elements.length==0) {
			System.out.println("Wrong input!");
		}
		else {
			for (int i = 0; i < example.elements.length; i++)
				 for (int j = 0; j < example.elements.length - 1 - i; j++)
				    if (example.elements[j + 1] > example.elements[j]) {
				        int temp = example.elements[j + 1];
				        example.elements[j + 1] = example.elements[j];
				        example.elements[j] = temp;
				    }
			int output = example.elements[example.kth-1];
			if(example.kth!=1 && example.elements[example.kth-1]==example.elements[example.kth-2]) {
				int j=0;
				for(int i=example.kth-2;i>=0;i--) {
					if(example.elements[i]==example.elements[i+1]) {
						j=i+1;
						continue;
					}
				}
				System.out.println("There are same elements in the array. The '"+example.kth+"'th largerst "
						+ "element is also the '"+j+"'th largest element: "+output);
			}
			else {
				System.out.println(output);
			}
		}
	}

}

//---------------------------------------------------------------------------------------------------------------

package Assignment4_1;

public class Element {
	int[] elements;
	int kth;
	

	public Element(int[] elements, int kth) {
		this.elements=elements;
		this.kth= kth;
	}

}

//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------


//Assignment4_2
package Assignment4_2;

import Assignment4_2.Circle;
import Assignment4_2.Cylinder;

public class Test {

	public static void main(String[] args) {
		
		Circle cc1 = new Circle();
		cc1.setRadius(2.0);
		cc1.setColor("yellow");
		System.out.println("Radius:"+cc1.getRadius()+" Color:"+cc1.getColor()+" Base Area:"+cc1.getArea());
		
		Cylinder cl1 = new Cylinder();
		cl1.setRadius(1.0);
		cl1.setColor("red");
		cl1.setHeight(1.0);
		System.out.println("Radius:"+cl1.getRadius()+" Color:"+cl1.getColor()+
				" Base Area:"+cl1.getBaseArea()+" Volume:"+cl1.getVolume());
		
		Cylinder cl2 = new Cylinder(5.0,2.0);
		cl2.setColor("red");
		System.out.println("Radius:"+cl2.getRadius()+" Color:"+cl2.getColor()+
				" Base Area:"+cl2.getBaseArea()+" Volume:"+cl2.getVolume());
		
	    System.out.println("cl1 Surface Area: "+cl1.getArea()+"  cl2 Surface Area: "+cl2.getArea());

	}

}

//---------------------------------------------------------------------------------------------------------------

package Assignment4_2;

public class Circle {
	double radius;
	String color;
	
	public Circle() {
	}

	public Circle(double radius) {
		this.radius=radius;
	}
	
	public Circle(double radius, String color) {
		this.radius= radius;
		this.color= color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius= radius;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color= color;
	}
	
	public double getArea() {
		double area;
		area = Math.PI*Math.pow(this.radius, 2);
		return area;
	}
}

//---------------------------------------------------------------------------------------------------------------

package Assignment4_2;

public class Cylinder extends Circle {
		double height;
		
		Cylinder() {
		}

		Cylinder(double height) {
			this.height=height;
		}
		
		Cylinder(double height, double radius) {
			super(radius);
			this.height = height;
		}
		
		Cylinder(double height, double radius, String color) {
			super(radius,color);
			this.height=height;
		}
		
		public double getHeight() {
			return height;
		}
		
		public void setHeight(double height) {
			this.height= height;
		}
		
		public double getVolume() {
			double volume;
			volume= Math.PI*Math.pow(this.radius, 2)*this.height;
			return volume;
		}
		
		//Because we use override to change the area calculation.
		//We use another method to calculate the base area of a cylinder.
		public double getBaseArea() {
			double area;
			area = Math.PI*Math.pow(this.radius, 2);
			return area;
		}
		
		
		@Override
		public double getArea() {
			double area;
			area= 2*Math.PI*this.radius*(this.radius+this.height);
			return area;
		}

}

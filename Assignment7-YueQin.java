//Question1
package Assignment7_A;

import java.util.ArrayList;
import java.util.Random;

public class SumValue {

	static void generateRandomArray(int[] arr) {
		Random rand = new Random();
		for(int i= 0; i<arr.length-1;i++) {
			int random = rand.nextInt(arr.length);
			arr[i]= random;
			//System.out.println(random);
		}
	}
	
	static long sum(int[] arr)  {
		int threadNum= 4;
		int avgLength= arr.length/threadNum;
		System.out.println(avgLength);
		long total=0;
		ArrayList<sumThread> tList = new ArrayList<sumThread>(); 
		
		for(int i= 0; i<threadNum; i++) {
			sumThread s = new sumThread(arr, (i*avgLength), (i+1)*avgLength);
			System.out.println(i*avgLength+" "+(i+1)*avgLength);
			System.out.println(s.getName()+" activated");
			s.start();
			try {
				s.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(s.getCount()==2) {
				tList.add(s);
				System.out.println(s.getName()+" added");
			}
		}
		
		for(int i = 0; i< tList.size();i++	) {
			System.out.println("\n"+total);
			total= total+ tList.get(i).getSum();
			System.out.println(tList.get(i).getSum());
			System.out.println(total);
		}
		
		return total;
	}

	public static void main(String[] args) {
		int[] arr = new int[4000000];
		 generateRandomArray(arr);
		 long sum = sum(arr);
		 System.out.println("Sum: " + sum);
		
	}

}

//---------------------------------------------------------------------------------------

class sumThread  extends Thread {
	private int[] ts;
	private int start;
	private int end;
	public long sum= 0;
	private int count= 1;

	
	public sumThread (int[] ts, int start, int end) {
		this.ts= ts;
		this.start= start;
		this.end= end;
		this.sum= 0;
		this.count= 1;
	}
	
	public long getSum()	{
		return sum;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setSum(int sum) {
		this.sum= sum;
	}
	
	public void run() {
		    String s= String.valueOf(2);
		    String s1= "thread"+s;
		    this.setName(s1);
			System.out.println("start");
			while(start<end) {
				sum+=ts[start];
				start++;
			}
			System.out.println("end");
			System.out.println(this.getName());
			this.count=2;
			//System.out.println(count);
	}

}

//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------

//Question2
package Assignment7_B;

public class HospitalRoom {
    //TODO: implement your code here
	int docNum=0;
	int paNum=0;
	private final Object lock1= new Object();
	private final Object lock2= new Object();
	public static int count=0; //To avoid the patient printing waiting to enter twice.
    //This is actually a very hard measure. But I don't know how to notify only one thread once.
	


    public boolean doctorEnter(Doctor d) throws InterruptedException {
        synchronized(lock1) {
        	while(true) {
        		if(docNum==1) {
        			System.out.println("Doctor "+d.name+" is waiting to enter, number of doctor "+docNum);
                	lock1.wait();
                }else {
                	docNum+=1;
                	System.out.println("Doctor "+d.name+" Entered, number of doctor "+docNum);
                	lock1.notify();
                	return true;
                	
                }
        	}
        }
    }	
  

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        synchronized(lock1) {
        	while(true) {
        		if(docNum==0 ) {
        			lock1.wait();
        		}else {
        			docNum-=1;
        			System.out.println("Doctor "+d.name+" left, number of doctor "+docNum);
        			lock1.notify();
        			return true;
        		}
        	}
        }
    }


    public boolean patientEnter(Patient p) throws InterruptedException {
    	synchronized(lock2)   {
    		while(true){
    			if(paNum==3) {
    				if(count<2) {
    					count=count+1;
    					// System.out.println("count = "+count);
    					System.out.println("Patient "+p.name+" is waiting to enter, number of patients "+paNum);
    				}
    				lock2.wait();
    			}else {
    				paNum+=1;
    				System.out.println("Patient "+p.name+" entered, number of patients "+paNum);
    				lock2.notify(); 
    				return true;
    			}
    		}
    	}
    }


    public boolean patientLeave(Patient p) throws InterruptedException {
    	 synchronized(lock2)  {
        	while(true){
        		if(paNum==0) {
        			lock2.wait();
        		}else {
        			paNum-=1;
        	    	System.out.println("Patient "+p.name+"left");
        	    	lock2.notifyAll();
        	    	return true;
        		}
        	}
        }
    } 


}

//---------------------------------------------------------------------------------------

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

//---------------------------------------------------------------------------------------

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

//---------------------------------------------------------------------------------------

class Main2 {
    public static void main(String[] args) {
    	HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                //System.out.println("siva enter end");
                Thread.sleep(50);
                while(!room.doctorLeave(siva)) {}
               // System.out.println("siva leave end");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                //System.out.println("john enter end");
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
                //System.out.println("john leave end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread patient1 = new Thread(() -> {
            try {
                    while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                    while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        doctor1.start();
        doctor2.start();
       
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
    
}

//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------

//Bonus question
package Assignment7_C;


public class hellos {
	public static void main(String[] args) {
		helloThread t1= new helloThread();
		t1.start();
		
	}
	
}


class helloThread extends Thread{
	static int count = 0;
	
	public helloThread() {
		
	}
	
	public String threadName() {
		String s = String.valueOf(count);
		String name= "Thread"+s;
		return name;
	}
	
	public void run() {
		count=count+1;
		this.setName(this.threadName());
		if(count<50) {
			helloThread next= new helloThread();
			next.start();
			try {
				next.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hello From "+this.getName());
		
		
		
	}
}
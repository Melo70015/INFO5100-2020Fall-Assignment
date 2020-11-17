//QuestionA
package Assignment8_A;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String password;
    private String emailAddress;
    private static String emailName;


    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
    	this.firstName= firstName;
    	this.lastName= lastName;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getDepartment() {
    	return department;
    }
    
    public String getCompanySuffix() {
    	return this.companySuffix;
    }
    
    public int getPLength() {
    	return this.defaultPasswordLength;
    }
    
    public int getMBC() {
    	return this.mailboxCapacity;
    }
    
    public String getPassword() {
    	return password;
    }
    public String getEmailAddress() {
    	return this.emailAddress;
    }
    
    public String getEmailSuffix() {
    	if(department=="none"||department==null) {
    		String suffix1="@"+this.getCompanySuffix();
    		return suffix1;
    	}
    	else {
    		String suffix2="@"+this.getDepartment()+"."+this.getCompanySuffix();
    		return suffix2;
    	}
    }
    
    public void setPassword(String s) {
    	this.password=s;
    }
    
    public void setCapacity(int c) {
    	this.mailboxCapacity=c;
    }
    
    public void setEmailAddress(String s) {
    	this.emailAddress= s+this.getEmailSuffix();
    	emailName=s;
    }
   
    // Ask for the department
    private String SetDepartment() {
    	Scanner scanner1 = new Scanner(System.in);
    	System.out.println("New Worker: "+this.getFirstName()+" "+this.getLastName()+". Department Codes:");
    	System.out.println("1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
    	System.out.println("Enter department code: ");
    	
    	if (scanner1.hasNextInt()) {
            int dcode = scanner1.nextInt();
            switch(dcode){
            
    		case(1):
    			this.department="sal";
    		    break;
    		case(2):
    			this.department="dev";
    		    break;
    		case(3):
    			this.department="acc";
    		    break;
    		case(0):
    			this.department="none";
    		    break;
    		default:
    			this.department="Wrong input!";
    			System.out.println("Wrong input!");
    	    }
        } else {
            System.out.println("Wrong input!");
        }
    	//scanner1.close();
    	//if we only need to type once, we can add this close clause.
    	return department;
    }


    // Generate a random password
    private String randomPassword(int length) {
    	char set[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
    			'O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2',
    			'3','4','5','6','7','8','9','!','@','#','$','%'};
    	password="";
    	for (int i =0; i<length; i++) {
    		int index;
    		index=(int)(Math.random()*(set.length));
    		password= password + set[index];
    	}
    	return password;
    }
    
    public String showInfo() {
    	this.SetDepartment();
    	if(this.getDepartment()!="Wrong input!") {
    	String s1= "DISPLAY NAME: "+this.getFirstName()+" "+this.getLastName();
    	String s2="\nDEPARTMENT: "+this.getDepartment();
    	
    	String s3="";
    	if(this.getEmailAddress()==null) {
    		s3="\nCOMPANY EMAIL: "+this.getFirstName().toLowerCase()+"."
        			+this.getLastName().toLowerCase()+this.getEmailSuffix();
    		this.emailAddress=s3;
    	}else if (this.getEmailAddress()!=null&&this.getDepartment()!="none") {
    		s3="\nCOMPANY EMAIL: "+emailName+this.getEmailSuffix();
    	}
    	else if (this.getEmailAddress()!=null&&this.getDepartment()=="none") {
    		s3="\nCOMPANY EMAIL: "+this.getEmailAddress();
    	}
    	
    	String s4="";
    	if(this.getPassword()==null) {
    	    s4="\nPASSWORD: "+this.randomPassword(this.getPLength());
    	}
    	else if(this.getPassword()!=null) {
    		s4="\nPASSWORD: "+this.getPassword();
    	}
    	String s5="\nMAILBOX CAPACITY: "+this.getMBC()+"mb";
    	return s1+s2+s3+s4+s5;
    	}
    	else
    		return "Info Error: Infromation can not be showed.";
    	
    }


}

//----------------------------------------------------------------------------------------

package Assignment8_A;

public class EmailApp {
    
	public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        System.out.println(em1.showInfo());
    
        Email em2 = new Email("John", "Lennon");
        em2.setEmailAddress("lennon");
        em2.setPassword("1234567890");
        System.out.println(em2.showInfo());
    } 
}

//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------

//QuestionB
package Assignment8_B;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	public static int reinput;
	public static int count=0;

	public TicTacToe() {
		// TODO Auto-generated constructor stub
	}
	
    public static void printGameBoard(char[][] gameBoard) {
        int xl = gameBoard.length;
        int yl = gameBoard[0].length;
        for(int i = 0; i<xl;i++) {
        	for(int j = 0; j<yl;j++) {
        		char space= gameBoard[i][j];
        		System.out.print(space);
        	}
        	System.out.print("\n");
        }
    }
    
    public static void cpuPlacePiece(char[][] gameBoard) {
    	 char symbol = 'O';
    	 Random rand = new Random();
    	 while(true) {
    		 int pos=rand.nextInt(9)+1;
    		 int xpos=(pos-1)/3*2;
    		 //System.out.println(xpos);
             int ypos=(pos-1)%3*2;
             //System.out.println(ypos);
             if(gameBoard[xpos][ypos]==' ') {
                 gameBoard[xpos][ypos]=symbol;
                 count=count+1;
                 break;
             }
            continue;
    	 }
    }
    
    public static void userPlacePiece(char[][] gameBoard, int pos) {
        char symbol = 'X';
        int xpos=(pos-1)/3*2;
        //System.out.println(xpos);
        int ypos=(pos-1)%3*2;
        //System.out.println(ypos);
        if(gameBoard[xpos][ypos]==' ') {
            gameBoard[xpos][ypos]=symbol;
            count=count+1;
        }else {
        	reinput=1;
            System.out.println("Selected postition is occupied, please select another one");
        }
    }
    
    public static boolean checkWinner(char[][] gameBoard) {
        for(int i = 0;i<5; i=i+2) {
        	if(gameBoard[i][0]+gameBoard[i][2]+gameBoard[i][4]==237||
        	   gameBoard[0][i]+gameBoard[2][i]+gameBoard[4][i]==237||
        	   gameBoard[0][0]+gameBoard[2][2]+gameBoard[4][4]==237||
        	   gameBoard[0][4]+gameBoard[2][2]+gameBoard[4][0]==237)
        	{
        	    System.out.println("CPU wins! Sorry:(");
        	    return true;
        	}
        	else if(gameBoard[i][0]+gameBoard[i][2]+gameBoard[i][4]==264||
        	   gameBoard[0][i]+gameBoard[2][i]+gameBoard[4][i]==264||
        	   gameBoard[0][0]+gameBoard[2][2]+gameBoard[4][4]==264||
        	   gameBoard[0][4]+gameBoard[2][2]+gameBoard[4][0]==264) 
        	{
        		System.out.println("Congratulations you won!");
        		return true;
        	}
        }
        if(count==9) {
    		System.out.println("CAT!");
    		return true;
    	}
    	return false;
    }

	public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };
        printGameBoard(gameBoard);
        
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            if (scan.hasNextInt()) {
            	reinput=0;
                int playerPos = scan.nextInt();
                if(playerPos>0&&playerPos<10) {
                	 userPlacePiece(gameBoard,playerPos);
                     if(reinput==1) {
                     	continue;
                     }
                     else {
                     	printGameBoard(gameBoard);
                     	if(checkWinner(gameBoard)==true) {
                     		break;
                     	}else {
                     		cpuPlacePiece(gameBoard);
                     		System.out.println("Cpu makes its move.");
                     		printGameBoard(gameBoard);
                     		if(checkWinner(gameBoard)==true) {
                         		break;
                     		}
                     	}
                     }
                 }
                else {
                	System.out.println("Wrong input,please input again");
                 	continue;
                }
            }
            else {
                System.out.println("Wrong input,please input again");
            	continue;
            }
        }
	}
}

//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------

//QuestionC
package Assignment8_C;

import java.util.Random;

public class maxValue {
	public static long allMax=-1;

	static void generateRandomArray(int[] arr) {
		Random rand = new Random();
		for(int i= 0; i<arr.length-1;i++) {
			int random = rand.nextInt(arr.length);
			arr[i]= random;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[4000000];
		//int threadNum= 5;
		generateRandomArray(arr);
		
		maxThread t1 = new maxThread(arr, 0, 800000);
		maxThread t2 = new maxThread(arr, 800000, 160000);
		maxThread t3 = new maxThread(arr, 800000*2, 800000*3);
		maxThread t4 = new maxThread(arr, 800000*3, 800000*4);
		maxThread t5 = new maxThread(arr, 800000*4, 800000*5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * Optional solution to execute the function
		int avgLength= arr.length/threadNum;
		System.out.println(avgLength);
		//ArrayList<maxThread> tList = new ArrayList<maxThread>(); 
		for(int i= 0; i<threadNum; i++) {
			maxThread s = new maxThread(arr, (i*avgLength), (i+1)*avgLength);
			System.out.println(i*avgLength+" "+(i+1)*avgLength);
			System.out.println(s.getName()+" activated");
			s.start();
			try {
				s.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		
		System.out.println("\nFinal Maximum Value: "+allMax);
	}
}

//For optional solution use
class maxThread  extends Thread {
	private int[] ts;
	private int start;
	private int end;

	public maxThread (int[] ts, int start, int end) {
		this.ts= ts;
		this.start= start;
		this.end= end;

	}
	
	public void run() {
			System.out.println("start");
			while(start<end) {
				if(Assignment8_C.maxValue.allMax<ts[start])
					Assignment8_C.maxValue.allMax=ts[start];
				start++;
			}
			System.out.println("end");
			System.out.println(Assignment8_C.maxValue.allMax);
	}
}
//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------

//Extra credit
package Assignment8_C;

import java.util.Random;

public class Account {
		private static int curBalance=100;
		
		public  Account(int Balance) {
			curBalance= Balance;
		}
		
		public static void deposit(int debitAmount) {
			curBalance= curBalance-debitAmount;
			System.out.println("after deposit: "+getBalance());	
		}
		
		public static void withdraw(int creditAmount) {
			curBalance=curBalance+creditAmount;
			System.out.println("after withdrawal: "+getBalance());
		}
		
		private static int getBalance(){
			return curBalance;
		}
		
	
		//I'm not sure whether I should use join here.
		public static void main(String[] args)
	    {
	        
	        Thread b1 = new Thread(() -> {
	            try {
	            System.out.println("b1 start");
	            	Random rand = new Random();
	            	
	    		int type = rand.nextInt(2);
	    		 System.out.println(type);
	    		if(type==0) {
	    			int amount0= rand.nextInt(101);
	    			System.out.println(amount0);
	    			deposit(amount0);
	    		}
	    		else {
	    			int amount1=rand.nextInt(101);
	    			System.out.println(amount1);
	    			withdraw(amount1);
	    		}
	    		System.out.println("b1 end"); 
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	        
	        Thread b4 = new Thread(() -> {
	            try {
	            	System.out.println("b4 start");
	            	Random rand4 = new Random();
	    		int type = rand4.nextInt(2);
	    		if(type==0) {
	    			int amount0= rand4.nextInt(101);
	    			System.out.println(amount0);
	    			deposit(amount0);
	    		}
	    		else {
	    			int amount1=rand4.nextInt(101);
	    			System.out.println(amount1);
	    			withdraw(amount1);
	    		}
	    		System.out.println("b4 end");  
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	        
	        Thread b2 = new Thread(() -> {
	            try {
	            	System.out.println("b2 start");
	            	Random rand = new Random();
	    		int type = rand.nextInt(2);
	    		if(type==0) {
	    			int amount0= rand.nextInt(101);
	    			System.out.println(amount0);
	    			deposit(amount0);
	    		}
	    		else {
	    			int amount1=rand.nextInt(101);
	    			System.out.println(amount1);
	    			withdraw(amount1);
	    		}
	    		System.out.println("b2 end");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	        
	        Thread b3 = new Thread(() -> {
	            try {
	            	System.out.println("b3 start");
	            	Random rand = new Random();
	    		int type = rand.nextInt(2);
	    		if(type==0) {
	    			int amount0= rand.nextInt(101);
	    			System.out.println(amount0);
	    			deposit(amount0);
	    		}
	    		else {
	    			int amount1=rand.nextInt(101);
	    			System.out.println(amount1);
	    			withdraw(amount1);
	    		}
	    		System.out.println("b3 end");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	        
	        b1.start();
	       
	        try {
				b1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        b2.start();
	        try {
				b2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        b3.start();
	        try {
				b3.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        b4.start();
	        try {
				b4.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	        System.out.println("program stops");

	    }
}




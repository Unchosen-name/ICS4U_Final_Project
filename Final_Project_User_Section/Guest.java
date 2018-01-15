   import java.util.*;
   import java.io.*;

//Guest user class. Extends User
    public class Guest extends User{
	 
	 	 private final String MENU = "Guest_Menu.txt";
   
       public void displayMenu(){
         Scanner sc = new Scanner(System.in);
         int choice;
			boolean keepOnGoing = true;
      
			while(keepOnGoing){
	      //display Menu
	         try{
	            BufferedReader in = new BufferedReader(new FileReader(MENU));
	            String st = in.readLine();
					
	            while(st != null){
	               System.out.println(st);
	               st = in.readLine();
	            }
	         }
	         catch(IOException iox){
	         	System.out.println("Error reading from file");
	         }
	      
		      //Take in user choice
		      choice = sc.nextInt();
		      
		      //executes the choice number				
		      switch (choice){
		         case 1:
		            	QNAGuest.initQNA();
				QNAGuest.displayMenu();
		         	break;
		         	
		    	   case 2:
							//call program list method
							
						break;
		         	
					case 3:
						keepOnGoing = false;
						break;
							
					default:
						System.out.println("Enter a valid option");
						break;
		  	   }
			}
      }
   }

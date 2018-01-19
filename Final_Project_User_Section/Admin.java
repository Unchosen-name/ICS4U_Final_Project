   import java.util.*;
   import java.io.*;

//Guest user class. Extends User
    public class Admin extends User{
	
	 	 private final String MENU = "Admin_Menu.txt";
		 private String adminNumber;
	    	 		 
		 //admin constructor. takes in username, password, and admin number as strings
		 //respectively
		 public Admin(String username, String password, String adminNum){
		 	super(username, password);
			adminNumber = adminNum;
		 }
		 
		 public String getAdminNumber () {
		 	return adminNumber;
		 }
		 
		 public void setAdminNumber (String num) {
		 	adminNumber = num;
		 }
		 
   	//displays the menu for admin users
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
		            	QNAAdmin.initQNA();
				QNAAdmin.displayMenu();
		         	break;
		         	
		    	  case 2:
				//call program list method
							
				break;
		         	
			  case 3:
				//MORE IMPLEMENTATION
				System.out.println("Execute updateMark Method");
				      
			  case 4: 
				//Add program 			
					
			  case 5: 
				keepOnGoing = false;
				break;
							
			  default:
				System.out.println("Enter a valid option");
			 	break;
		  	   }
			}
      }
   }

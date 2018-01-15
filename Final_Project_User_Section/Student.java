   import java.util.*;
   import java.io.*;

//Guest user class. Extends User
    public class Student extends User{
	 
	 	 private Scanner sc = new Scanner(System.in);
	 
	 	 private final String MENU = "Student_Menu.txt";
		 private String firstName;
		 private String lastName;
		 private String oen;
		 private String studentNumber;
		 private CourseTracker courseTracker;
		 private boolean acceptedToUni;
		 
		 //admin constructor. takes in username, password, and admin number as strings
		 //respectively
		 public Student(String username, String password, String firstName, String lastName, String oen, String studentNumber, CourseTracker courseTracker, boolean accepted){
		 	super(username, password);
			this.firstName = firstName;
			this.lastName = lastName;
			this.oen = oen;
			this.studentNumber = studentNumber;
			this.courseTracker = courseTracker;
			acceptedToUni = accepted;
			
		 }
		 
		 //accessors
		 public String getfirstName(){
		 	return firstName;
		 }
		 
		 public String getLastName(){
		 	return lastName;
		 }
		 
		 public String getOEN(){
		 	return oen;
		 }
		 
		 public String getStudentNumber(){
		 	return studentNumber;
		 }
		 
		 public CourseTracker getCourseTracker(){
		 	return courseTracker;
		 }
		 
		 public boolean getAcceptedToUni(){
		 	return acceptedToUni;
		 }
		 
		 //mutators
		 public void setFirstName(String s){
		 	firstName = s;
		 }
		 
		 public void setLastName(String s){
		 	lastName = s;
		 }
		 
		 public void setOEN(String s){
		 	oen = s;
		 }
		 
		 public void setStudentNumber(String s){
		 	studentNumber = s;
		 }
		 
		 public void setCourseTracker(CourseTracker c){
		 	courseTracker = c;
		 }
		 
		 public void setAcceptedToUni(boolean b){
		 	acceptedToUni = b;
		 }
		 
		 
		 
		 //student update mark
		 public boolean updateMark(String course_name, double mark){
		 	courseTracker.udpatemark(course_name, mark);
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
					in.close();
	         }
	         catch(IOException iox){
	         	System.out.println("Error reading from file");
	         }
	      
		      //Take in user choice
		      choice = sc.nextInt();
		      
		      //executes the choice number				
		      switch (choice){
		         case 1:
		            	QNAStudent.initQNA();
				QNAStudent.displayMenu();
		         	break;
		         	
		    	   case 2:
						//call program list method
							
						break;
		         	
					case 3:
						//MORE IMPLEMENTATION
						System.out.print("Enter course name: ");
						String course_name = sc.nextLine();
						System.out.print("Enter the updated mark: ");
						double mark = sc.nextDouble();
						this.updateMark(course_name, mark);
						break;
						
					
					case 4: 
						keepOnGoing = false;
						break;
							
					default:
						System.out.println("Enter a valid option");
						break;
		  	   }
			}
      }
   }

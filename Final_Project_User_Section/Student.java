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
	private int numMenuOptions;
	private String[] menuOptions;

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
		loadMenu();
	}

	//accessors
	public String getFirstName(){
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

	public boolean setPassword (String oldPass, String newPass) {
		if (oldPass.equals(password)) {
			password = newPass;
			return true;
		}
		return false;
	}

	public boolean setUsername (String oldPass, String newUsername) {
		if (oldPass.equals(password)) {
			username = newUsername;
			return true;
		}
		return false;
	}

	public void loadMenu () {
		try {
			BufferedReader in = new BufferedReader(new FileReader(MENU));
			numMenuOptions = Integer.parseInt(in.readLine());
			in.readLine();

			menuOptions = new String[numMenuOptions];
			for (int i = 0; i < numMenuOptions; i++) {
				menuOptions[i] = in.readLine();
			}

			in.close();
		}
		catch(IOException iox){
			System.out.println("Error reading student menu from file.");
		}
	}

	//displays the menu for admin users
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		boolean keepOnGoing = true;

		while (keepOnGoing) {

			System.out.println("\nStudent Menu (logged in as " + username + ")");
			for (int i = 0; i < numMenuOptions; i++) {
				System.out.println(menuOptions[i]);
			}

			while (!(choice > 0 && choice <= numMenuOptions)) {
				try {
						System.out.print("Enter an option: ");
						choice = sc.nextInt();
						sc.nextLine();
					} catch (InputMismatchException ime) {
						sc.nextLine();
						System.out.print("Invalid input. ");
				}
			}

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
					updateMarkByStandardInput();
					break;
				case 4: 
					keepOnGoing = false;
					break;
			}
			choice = 0;
		}
	}

	//student update mark
	public void updateMarkByStandardInput () {
		final int MIN_MARK = 0;
		final int MAX_MARK = 100;
		String courseCode;
		double mark = -1;

		do {
			System.out.print("Enter course name: ");
			courseCode = sc.nextLine();
			if (!courseTracker.courseExists(courseCode)) {
				System.out.println("Course not found!");
			}
		} while(!courseTracker.courseExists(courseCode));

		do {
			System.out.print("Enter mark: ");
			try {
				mark = sc.nextDouble();
				sc.nextLine();
			} catch (InputMismatchException ime) {
				sc.nextLine();
				System.out.println("Invalid input! Please try again.");
			}

			if (mark != -1 && !(mark >= MIN_MARK && mark <= MAX_MARK)) {
				mark = -1;
				System.out.println("Invalid input! Please try again.");
			}
		} while (mark == -1);

		courseTracker.updateMark(courseCode, mark);
		System.out.println("Mark updated successfully!");
	}
}

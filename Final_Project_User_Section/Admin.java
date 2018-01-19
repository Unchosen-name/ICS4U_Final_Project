import java.util.*;
import java.io.*;

//Guest user class. Extends User
public class Admin extends User{

	private final String MENU = "Admin_Menu.txt";
	private String adminNumber;
	private int numMenuOptions;
	private String[] menuOptions;
	private Scanner sc;
	private ArrayList<Student> studentList;
	//private ProgramDatabase programDatabase;

	//admin constructor. takes in username, password, and admin number as strings
	//respectively
	public Admin(String username, String password, String adminNumber, ArrayList<Student> studentList/*, ProgramDatabase programDatabase*/){
		super(username, password);
		this.adminNumber = adminNumber;
		this.studentList = studentList;
		//this.programDatabase = programDatabase;
		sc = new Scanner(System.in);
		loadMenu();
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public String getAdminNumber(){
		return adminNumber;
	}

	public void setUsername(String user){
		username = user;
	}

	public void setPassword(String pass){
		password = pass;
	}

	public void setAdminNumber(String num){
		adminNumber = num;
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
		} catch(IOException iox){
			System.out.println("Error reading admin menu from file.");
		}
	}


	//displays the menu for admin users
	public void displayMenu(){
		int choice = 0;
		boolean keepOnGoing = true;

		while(keepOnGoing){	   
			System.out.println("\nAdmin Menu (logged in as " + username + ")");
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
					QNAAdmin.initQNA();
					QNAAdmin.displayMenu();
					break;
				case 2:
					//search programs
					break;
				case 3:
					updateStudentMark();
					break;
				case 4: 
					//add program
					break;
				case 5:
					//delete program
					break;
				case 6:
					keepOnGoing = false;
					break;
			}
			choice = 0;
		}
	}

	private void updateStudentMark() {
		final int EXIT = -1;
		final int MIN_MARK = 0;
		final int MAX_MARK = 100;
		boolean markUpdated = false;
		String studentNumber, courseCode;
		double newMark = -1;
		Student student;
		ActiveCourse course;

		System.out.println("\nUpdate Student Mark");
		System.out.print("Student OEN: ");
		studentNumber = sc.nextLine();
		student = searchStudentByOEN(studentNumber);
		while (student == null) {
			System.out.println("That student number does not exist. Enter " +  EXIT + " to cancel.");
			System.out.print("Student OEN: ");
			studentNumber = sc.nextLine();
			try {
				if (Integer.parseInt(studentNumber) == EXIT) {
					return;
				}
			} catch (NumberFormatException nfe) {};
			student = searchStudentByOEN(studentNumber);
		}

		student.updateMarkByStandardInput();

		/*
		while (!markUpdated) {
			System.out.print("Course code: ");
			courseCode = sc.nextLine();

			while (!(newMark >= MIN_MARK && newMark <= MAX_MARK)) {
				System.out.print("Mark: ");
				try {
					newMark = sc.nextDouble();
					sc.nextLine();
				} catch (InputMismatchException ime) {
					sc.nextLine();
					System.out.print("Invalid input! ");
				}
			}

			markUpdated = student.updateMark(courseCode, newMark);
			if (!markUpdated) {
				System.out.println("Course not found!");
				newMark = -1;
			}
		}
		System.out.println("Mark updated successfully!");*/
	}

	private Student searchStudentByOEN (String OEN) {
		for(Student student: studentList){
			if(student.getOEN().equals(OEN)){
				return student;
			}
		}
		return null;
	}
}

import java.io.*;
import java.util.*;

public class InformationSystem {
	private static String MENU_FILE = "main_menu.txt";
	private UserDatabase users;
	//private ProgramDatabase programs;
	private User currentUser;
	private String[] menuOptions;
	private int numMenuOptions;
	private Scanner sc;
	private boolean endProgram;

	public InformationSystem(){
		users = new UserDatabase();
		//programs = new ProgramDatabase();
		sc = new Scanner(System.in);
		endProgram = false;
		loadMenu();
		displayMenu();
	}

	public void loadMenu () {
		try {
			BufferedReader in = new BufferedReader(new FileReader(MENU_FILE));
			numMenuOptions = Integer.parseInt(in.readLine());
			menuOptions = new String[numMenuOptions];
			for (int i = 0; i < numMenuOptions; i++) {
				menuOptions[i] = in.readLine();
			}
			in.close();
		} catch (IOException iox) {
			System.out.println("Error reading main menu from file.");
		}
	}

	public void displayMenu () {
		do {
			System.out.println("\nInformation System");
			for (int i = 0; i < numMenuOptions; i++) {
				System.out.println(menuOptions[i]);
			}
			processMenuChoice();
		} while (!endProgram);
	}

	public void processMenuChoice () {
		int choice = -1;

		do {
			try {
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException ime) {
				sc.nextLine();
				System.out.print("Invalid input. ");
			}
		} while (!(choice > 0 && choice <= numMenuOptions));

		switch (choice) {
			case 1:
				logInStudent();
				break;
			case 2:
				logInAdmin();
				break;
			case 3:
				currentUser = UserDatabase.getGuest();
				break;
			case 4:
				createStudentAccount();
				break;
			case 5:
				createAdminAccount();
				break;
			case 6:
				endProgram = true;
				break;
		}

		if (currentUser != null) {
			currentUser.displayMenu();
		}
	}

	public void logInStudent () {
		String username, password;

		System.out.println("\nStudent Login");

		System.out.print("Username: ");
		username = sc.nextLine();
		System.out.print("Password: ");
		password = sc.nextLine();

		while (users.searchStudentByLoginInfo(username, password) == null) {
			System.out.println("Invalid username or password!");
			System.out.print("Username: ");
			username = sc.nextLine();
			System.out.print("Password: ");
			password = sc.nextLine();
		}

		currentUser = users.searchStudentByLoginInfo(username, password);
	}


	public void logInAdmin () {
		String username, password;

		System.out.println("\nAdmin Login");

		System.out.print("Username: ");
		username = sc.nextLine();
		System.out.print("Password: ");
		password = sc.nextLine();

		while (users.searchAdminByLoginInfo(username, password) == null) {
			System.out.println("Invalid username or password!");
			System.out.print("Usernasme: ");
			username = sc.nextLine();
			System.out.print("Password: ");
			password = sc.nextLine();
		}

		currentUser = users.searchAdminByLoginInfo(username, password);
	}

	public void createStudentAccount () {
		String username, password, firstName, lastName, oen, studentNum;
		int numCourses = 0;

		System.out.println("\nStudent Registration");

		System.out.print("Username: ");
		username = sc.nextLine();
		while (!users.checkStudentUsername(username)) {
			System.out.println("Username unavailable. Please enter a new one.");
			System.out.print("Username: ");
			username = sc.nextLine();
		}
		System.out.print("Password: ");
		password = sc.nextLine();
		System.out.print("First Name: ");
		firstName = sc.nextLine();
		System.out.print("Last Name: ");
		lastName = sc.nextLine();
		System.out.print("OEN: ");
		oen = sc.nextLine();
		System.out.print("Student Number: ");
		studentNum = sc.nextLine();
		do {
			try {
				System.out.print("How many courses are you taking? ");
				numCourses = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException ime) {
				sc.nextLine();
				System.out.println("Invalid input.");
			}
		} while (!(numCourses > 0));

		ArrayList<ActiveCourse> courseList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			String courseCode;
			int mark = -1;

			System.out.print("Course: ");
			courseCode = sc.nextLine();
			while (!CourseTracker.isValidCourse(courseCode)) {
				System.out.println("That course is not offered at AY Jackson.");
				System.out.print("Enter a new course: ");
				courseCode = sc.nextLine();
			}

			do {
				try {
					System.out.print("Mark: ");
					mark = sc.nextInt();
					sc.nextLine();
				} catch (InputMismatchException ime) {
					sc.nextLine();
					System.out.println("Invalid input.");
				}
				if (!(mark >= 0 && mark <= 100)) {
					System.out.println("Invalid mark.");
				}
			} while (!(mark >= 0 && mark <= 100));

			courseList.add(new ActiveCourse(courseCode, mark));
		}

		Student student = new Student(username, password, firstName, lastName, oen, studentNum, new CourseTracker(courseList), false);
		users.addStudent(student);

		System.out.println("Registration successful.");
		displayMenu();
	}

	public void createAdminAccount () {
		System.out.println("\nAdmin Login");

		System.out.print("Username: ");
		String username = sc.nextLine();
		while (!users.checkAdminUsername(username)) {
			System.out.println("Username unavailable. Please enter a new one.");
			System.out.print("Username: ");
			username = sc.nextLine();
		}
		System.out.print("Password: ");
		String password = sc.nextLine();
		System.out.print("Admin Number: ");
		String adminNumber = sc.nextLine();

		Admin admin = new Admin(username, password, adminNumber);
		users.addAdmin(admin);

		System.out.println("Registration successful.");
		displayMenu();
	}

	public static void main (String[] args) {
		InformationSystem is = new InformationSystem();
	}
}

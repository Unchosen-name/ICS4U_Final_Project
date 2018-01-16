public class InformationSystem{
  
  private UserDatabase users;
  private ProgramDatabase programs;
  private User currentUser;
  
  //Constructor for InformationSystem. Initializes all the needed managers and databases
  public InformationSystem(){
    users = new Userdatabase();
    programs = new ProgramDatabase();
  }
  
  public void displayMenu(){
  
  }
  
public createStudentAccount () {
	System.out.print("Username: ");
	String username = sc.nextLine();
	System.out.print("Password: ");
	String password = sc.nextLine();
	System.out.print("First Name: ");
	String firstName = sc.nextLine();
	System.out.print("Last Name: ");
	String lastName = sc.nextLine();
	System.out.print("OEN: ");
	String oen = sc.nextLine();
	System.out.print("Student Number: ");
	String studentNum = sc.nextLine();
	System.out.print("How many courses are you taking? ");
	int numCourses = sc.nextInt();

	ArrayList<ActiveCourse> courseList = new ArrayList<>();

	for (int i = 0; i < numCourses; i++) {
		System.out.print("Course: ");
		String courseCode = sc.nextLine();
		System.out.print("Mark: ");
		int mark = sc.nextInt();
		courseList.add(new ActiveCourse(courseCode, mark));
	}

	Student student = new Student(username, password, firstName, lastName, oen, studentNum, new CourseTracker(courseList), false);
	if (!users.addStudent(student)) {
		System.out.println("Your username, OEN, and studnet number must be unique. Please");
		System.out.println("verify that you have entered your information correctly.");
	}
}
  
  public static void main(){
    
  }
}

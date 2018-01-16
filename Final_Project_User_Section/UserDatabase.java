import java.util.*;
import java.io.*;

//Guest user class. Extends User
public class UserDatabase{

	private static final String ADMINFILE = "Admin_List.txt";
	private static final String STUDENTFILE = "Student_List.txt"; 


	private ArrayList<Admin> adminTracker;
	private ArrayList<Student> studentTracker;

	//default constructors
	public UserDatabase(){

		adminTracker = new ArrayList<Admin>();
		studentTracker = new ArrayList<Student>();
		loadAdminList();
		loadStudentList();
	}

	//load admin list from file
	public void loadAdminList(){
		try{
			BufferedReader in = new BufferedReader(new FileReader(ADMINFILE));

			String st = in.readLine();
			int num = Integer.parseInt(st);

			for(int i=0; i<num; i++){
				in.readLine();
				Admin admin = new Admin(in.readLine(), in.readLine(), in.readLine());
				adminTracker.add(admin);
			}
			in.close();
		}
		catch(IOException iox){
			System.out.println("Error reading from file");
		}
		catch(NumberFormatException nfe){
			System.out.println("Error converting from string to integer");
		}
	}

	//load staff list from file
	public void loadStudentList(){

		try{
			BufferedReader in = new BufferedReader(new FileReader(STUDENTFILE));

			String st = in.readLine();
			int num = Integer.parseInt(st);

			for(int i=0; i<num; i++){
				in.readLine();

				String username = in.readLine();
				String password = in.readLine();
				String firstName = in.readLine();
				String lastName = in.readLine();
				String oen = in.readLine();
				String studentNumber = in.readLine();

				int counter = Integer.parseInt(in.readLine());
				ArrayList<ActiveCourse> courseList = new ArrayList<>();
				for(int j=0; j<counter; j++){
					ActiveCourse active = new ActiveCourse(in.readLine(), Double.parseDouble(in.readLine()));
					courseList.add(active);
				}
				CourseTracker courseTracker = new CourseTracker(courseList);
				boolean acceptedToUni = Boolean.parseBoolean(in.readLine());

				Student stu = new Student(username, password, firstName, lastName, oen, studentNumber, courseTracker, acceptedToUni);
				studentTracker.add(stu);
			}

			in.close();
		}
		catch(IOException iox){
			System.out.println("Error reading from file");
		}
		catch(NumberFormatException nfe){
			System.out.println("Error converting from string to integer");
		}

	}

	//save admin list to file
	public void saveAdminList(){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(ADMINFILE));

			out.write(adminTracker.size());
			out.newLine();

			for(Admin admin : adminTracker) {
				out.newLine();

				out.write(admin.getUsername());
				out.newLine();
				out.write(admin.getPassword());
				out.newLine();
				out.write(admin.getAdminNumber());
				out.newLine();

			}

		}
		catch(IOException iox){
			System.out.println("Error writing to file");
		}
	}

	//save student list to file
	public void saveStudentList(){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(STUDENTFILE));

			out.write(studentTracker.size());
			out.newLine();

			for(Student stu : studentTracker) {
				out.newLine();

				out.write(stu.getUsername());
				out.newLine();
				out.write(stu.getPassword());
				out.newLine();
				out.write(stu.getFirstName());
				out.newLine();
				out.write(stu.getLastName());
				out.newLine();
				out.write(stu.getOEN());
				out.newLine();
				out.write(stu.getStudentNumber());
				out.newLine();

				for(ActiveCourse course : stu.getCourseTracker().getCourseList()){
					out.write(course.getCourseCode() + "");
					out.newLine();
					out.write(course.getMark() + "");
					out.newLine();
				}

				out.write(stu.getAcceptedToUni() + "");
				out.newLine();

			}
			out.close();
		}
		catch(IOException iox){
			System.out.println("Error writing to file");
		}


	}

	private void createStudentByStandardInput () {
		System.out.print("Username: ");
		String username = sc.nextLine();
		while (!checkStudentUsername(username)) {
			System.out.println("Username unavailable. Please enter a new one.");
			System.out.print("Username: ");
			username = sc.nextLine();
		}
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
		studentTracker.add(student);
	}

	//checks if a the student parameter is unique in the list. Checks username password OEN and student number
	public boolean checkStudentUsername (String username) {
		for (Student curStudent : studentTracker) {
			if (username.equals(curStudent.getUsername())) {
				return false;
			}
		}
		return true;
	}

	//check to see if the parameter admin is unique in the list of admins. Checking fields include username password and admin number
	public boolean checkAdminUsername (String username) {
		for (Admin curAdmin : adminTracker) {
			if (username.equals(curAdmin.getUsername())) {
				return false;
			}
		}
		return true;
	}

	//delete method
	public boolean delete(User person){
		if(person instanceof Admin){
			adminTracker.remove((Admin)person);
			return true;
		}
		else if(person instanceof Student){
			studentTracker.remove((Student)person);
			return true;
		}

		return false;
	}

	//update the password, takes in the type of user, username old password and new password
	//only updates if the user is found and old password match
	public boolean updatePassword(String type, String user, String oldpass, String newpass){
		if(type.equals("Admin")){
			for(Admin admin: adminTracker){
				if(admin.getUsername().equals(user) && admin.getPassword().equals(oldpass)){
					admin.setPassword(newpass);
					return true;
				}
			}
			return false;
		}
		else{
			for(Student student: studentTracker){
				if(student.getUsername().equals(user) && student.getPassword().equals(oldpass)){
					student.setPassword(oldpass, newpass);
					return true;
				}
			}
			return false;
		}
	}

	//update the username, takes in the type of user, username old password and new username
	//only updates if the user is found and old password match
	public boolean updateUsername(String type, String user, String oldpass, String newuser){
		if(type.equals("Admin")){
			for(Admin admin: adminTracker){
				if(admin.getUsername().equals(user) && admin.getPassword().equals(oldpass)){
					admin.setUsername(newuser);
					return true;
				}
			}
			return false;
		}
		else{
			for(Student student: studentTracker){
				if(student.getUsername().equals(user) && student.getPassword().equals(oldpass)){
					student.setUsername(oldpass, newuser);
					return true;
				}
			}
			return false;
		}
	}

	//Search for a user given type of user, the username, password.
	public User searchUser(String type, String user, String pass){
		if(type.equals("Admin")){
			for(Admin admin: adminTracker){
				if(admin.getUsername().equals(user) && admin.getPassword().equals(pass)){
					return admin;
				}
			}
			return null;
		}
		else{
			for(Student student: studentTracker){
				if(student.getUsername().equals(user) && student.getPassword().equals(pass)){
					return student;
				}
			}
			return null;
		}
	}


}

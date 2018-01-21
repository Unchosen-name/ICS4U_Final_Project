/**
* UserDatabase.java
* Responsible for managing all users.
*/

import java.util.*;
import java.io.*;

public class UserDatabase {
	private static final String ADMINFILE = "admin_list.txt";
	private static final String STUDENTFILE = "student_list.txt"; 
	public static final Guest GUEST = new Guest();

	private ArrayList<Admin> adminTracker;
	private ArrayList<Student> studentTracker;
	private ProgramDatabase programDatabase;

	public UserDatabase () {
		adminTracker = new ArrayList<Admin>();
		studentTracker = new ArrayList<Student>();
		programDatabase = new ProgramDatabase();
		loadAdminList();
		loadStudentList();
	}

	public void loadAdminList () {
		try {
			BufferedReader in = new BufferedReader(new FileReader(ADMINFILE));

			int numAdmins = Integer.parseInt(in.readLine());

			for(int i = 0; i < numAdmins; i++){
				in.readLine();
				Admin admin = new Admin(in.readLine(), in.readLine(), in.readLine(), studentTracker, programDatabase);
				adminTracker.add(admin);
			}

			in.close();
		}
		catch(IOException iox){
			System.out.println("Error reading admin list from file.");
		}
		catch(NumberFormatException nfe){
			System.out.println("Error converting from string to integer (while loading admin list).");
		}
	}

	public void loadStudentList(){
		try {
			BufferedReader in = new BufferedReader(new FileReader(STUDENTFILE));

			int num = Integer.parseInt(in.readLine());

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
			System.out.println("Error reading from student file");
		}
		catch(NumberFormatException nfe){
			System.out.println("Error converting from string to integer (user database - load student list)");
		}

	}

	//save admin list to file
	public void saveAdminList(){
		try {
			BufferedWriter out = new BufferedWriter (new FileWriter(ADMINFILE));

			out.write(adminTracker.size() + "");
			out.newLine();

			for (Admin admin : adminTracker) {
				out.newLine();

				out.write(admin.getUsername());
				out.newLine();
				out.write(admin.getPassword());
				out.newLine();
				out.write(admin.getAdminNumber());
				out.newLine();
			}

			out.close();
		} catch (IOException iox) {
			System.out.println("Error writing to admin file.");
		}
	}

	//save student list to file
	public void saveStudentList(){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(STUDENTFILE));

			out.write(studentTracker.size() + "");
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

				out.write(stu.getCourseTracker().getCourseList().size() + "");
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

	public void addStudent (Student student) {
		studentTracker.add(student);
		saveStudentList();
	}

	public void addAdmin (String username, String password, String adminNumber) {
		Admin admin = new Admin(username, password, adminNumber, studentTracker, programDatabase);
		adminTracker.add(admin);
		saveAdminList();
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
			saveAdminList();
			return true;
		}
		else if(person instanceof Student){
			studentTracker.remove((Student)person);
			saveStudentList();
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
					saveAdminList();
					return true;
				}
			}
			return false;
		}
		else{
			for(Student student: studentTracker){
				if(student.getUsername().equals(user) && student.getPassword().equals(oldpass)){
					student.setPassword(oldpass, newpass);
					saveStudentList();
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
					saveAdminList();
					return true;
				}
			}
			return false;
		}
		else{
			for(Student student: studentTracker){
				if(student.getUsername().equals(user) && student.getPassword().equals(oldpass)){
					student.setUsername(oldpass, newuser);
					saveStudentList();
					return true;
				}
			}
			return false;
		}
	}

	public Student searchStudentByOEN (String OEN) {
		for(Student student: studentTracker){
			if(student.getOEN().equals(OEN)){
				return student;
			}
		}
		return null;	
	}

	public Student searchStudentByLoginInfo (String user, String password) {
		for(Student student: studentTracker){
			if(student.getUsername().equals(user) && student.getPassword().equals(password)){
				return student;
			}
		}
		return null;
	}

	public Admin searchAdminByLoginInfo (String user, String password) {
		for(Admin admin: adminTracker){
			if(admin.getUsername().equals(user) && admin.getPassword().equals(password)){
				return admin;
			}
		}
		return null;
	}
}

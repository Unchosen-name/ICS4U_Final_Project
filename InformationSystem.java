public class InformationSystem{
  
  private UserDatabase users;
  private ProgramDatabase programs;
  private User currentUser;
  
  //Constructor for InformationSystem. Initializes all the needed managers and databases
  public InformationSystem(){
    users = new Userdatabase();
    programs = new ProgramDatabase();
  }
  
  /*
  1. log in as stu
  2. log in as admin
  3. log in as guest
  4. register as stu
  5. register as admin
  */
  
  public void displayMenu(){
    
  }
  
public void processMenuChoice () {
	int choice;

	do {
		try {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
		} catch (InputMismatchException ime) {
			sc.nextLine();
			System.out.println("Invalid input.");
		}
	} while (!(choice > 0 && choice <= 5));

	switch (choice) {
		case 1:
			//log in as student
			break;
		case 2:
			//log in as student
			break;
		case 3:
			//log in as student
			break;
		case 4:
			createStudentByStandardInput();
			break;
		case 5:
			//log in as student
			break;
	}
}
  
  public static void main(){
    
  }
}

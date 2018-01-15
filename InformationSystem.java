public class InformationSystem{
  
  private UserDatabase users;
  private ProgramDatabase programs;
  private User currentUser;
  private int curYear;
  
  //Constructor for InformationSystem. Initializes all the needed managers and databases
  public InformationSystem(String username, String password, int currentY){
    users = new Userdatabase();
    programs = new ProgramDatabase();
    currentUser = new User(username, password);
  }
  
  public void displayMenu(){
  
  }
  
  public createNewAccount(User user){
    if(user instanceof student){
      users.studentTracker.add(user);
    }
    else if(user instanceof admin){
      users.adminTracker.add(user);
    }
  }
  
  public static void main(){
    
  }
}

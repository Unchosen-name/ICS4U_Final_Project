import java.util.*;

public class ProgramDatabase
{	
	
	private final String MENU = "program database.txt";
	private final String ORDER = "sort.txt";
   private final String ERROR = "List not found, press 0 to return to previous menu...";
   
	private ArrayList<Program> programs;
	private PastData_Manager pastdata;
	private ArrayList<String> menu;
   private ArrayList<String> order;
   
	public ProgramDatabase()
	{
		menu = Method.readMenu(MENU);
		order = Method.readMenu(ORDER);
	}
	
	//////////////////
	public void displayMenu()
	{
		boolean exit = false;
		int option = menu.size();
      String input;
      ArrayList<Program> p;
      
		do
		{
			switch(Method.getOption(option))
			{
				case 1:
               System.out.print("Enter the OUAC code: ");
               input = sc.nextLine();
               p = searchByCode(input);
					Method.outputPrograms(searchByCode());
				break;
				case 2:
               System.out.print("Enter the university: ");
               input = sc.nextLine();
               p = searchByUni(input);
					Method.outputPrograms(searchByUni());
					break;
				case 3:
               System.out.print("Enter the major: ");
               input = sc.nextLine();
               p = searchByMajor(input);
					Method.outputPrograms(searchByCode());
					break;
				case 4:
					System.out.print("Enter the program: ");
               input = sc.nextLine();
               p = searchByProgram(input);
					Method.outputPrograms(searchByProgram(input));
				break;
				case 5:
					exit = true;
			}
		}while(!exit);
	}
	////////////
	
	public void menu()
	{
		for (int i = 0; i < pastdata.size(); i++)
         System.out.println(i+ ": " + menu.get(i));
	}
	
	public ArrayList<Program> searchByUni(String s)
	{
		ArrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchUni(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}
   
	public ArrayList<Program> searchByCode(String s)
	{
		ArrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchCode(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}
	
	public ArrayList<Program> searchByMajor(String s)
	{
		ArrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchMajor(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}

	public ArrayList<Program> searchByProgram(String s)
	{
		ArrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchProgram(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}
	
	public ArrayList<Program> searchByAdmissionAverage(double k)
	{
		ArrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).lowerThan(k))
				p.add(); //add the element from the list programs
		}
		return p;
	}
////////////////////////
	private ArrayList<PastData> findPastData(int programID)
	{
	}
/////////////////////////////
	public void addProgram()// by prompt
	{
		Program p = new Program(program.size());
		programs.add(p);
		
		//intitate all variables with user input.
		
	}
	
	public void deleteProgram()
	{
		  
	}// delete from a list
	
	public void deleteProgram(int a )
	{
	}
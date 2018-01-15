import java.util.*;

public class ProgramDatabase
{
	private ArrayList<Program> programs;
   Scanner sc = new Scanner (System.in);
	private PastData_Manager pastdata;
	
	public ProgramDatabase()
	{
			//read from file
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

	public void addProgram()// by prompt
	{
		Program p = new Program();
		programs.add(p);
		
		//intitate all variables with user input.
		
	}
	
	public void deleteProgram()
	{
		
	}// delete from a list
	
	public void deleteProgram(int index)
	{
		programs.remove(index);
	}
}
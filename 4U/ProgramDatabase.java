import java.util.*;

public class ProgramDatabase
{
	private arrayList<Program> programs;

	
	public ProgramDatabse()
	{
		//read from file
	}
	
	public void displayList()
	{
		
	}
	public arrayList<Program> searchByUni(String s)
	{
		arrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchUni(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}
	public arrayList<Program> searchByCode(String s)
	{
		arrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchCode(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}
	public arrayList<Program> searchByMajor(String s)
	{
		arrayList<Program> p = new ArrayList<Program>();
		int size = programs.size();
		for (int i = 0; i < size; i++)
		{
			if (programs.get(i).searchMajor(s))
				p.add(); //add the element from the list programs
		}
		return p;
	}
	
	private static boolean inputCheck (String s, int option)
	{
		try
		{
			if (Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= option)
				return true;
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
	}
	
	
	
	public void addProgram()
	{
		Program p;
		//intitate all variables with user input.
		
	}
	
	public void deleteProgram(int index)
	{
		programs.remove(index);
	}
}
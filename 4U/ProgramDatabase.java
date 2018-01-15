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

   /////////////////
	public arrayList<Program> searchByAdmissionAverage(double k)
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
   ///////////////////

	public void addProgram()// by prompt
	{
		Program p = new Program();
		programs.add(p);
		
		//intitate all variables with user input.
		
	}
	
	public void deleteProgram()
	{
		
	}
	
	public void deleteProgram(int index)
	{
		programs.remove(index);
	}
}
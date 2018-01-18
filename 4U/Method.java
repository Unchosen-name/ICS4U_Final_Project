import java.util.*;
import java.io.*;

public class Method {
	public static final int CURYEAR = 2018;
	public static final int PASTDATA = 5;
	public static Scanner sc = new Scanner(System.in);

    
   public static boolean inputCheck (String s, int option)
	{
		try
		{
			if (Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= option)
				return true;
			else
				return false;
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
	}
    
	 public static ArrayList <String> readMenu(String file)
	 {
	 	ArrayList<String> menu = new ArrayList<String> ();
	 	try 
      {
         BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine())!= null)
			{
				menu.add(line);
			}
			in.close();
      }
      catch (IOException iox)
      {
			System.out.print("Cannot load files.");
      }
		return menu;
	 }
	 
	 public static int getOption (int option)
	 {
	 		String choice;
	 		System.out.print("Enter your choice:");
			choice = sc.nextLine();
			while (!inputCheck(choice, option))
			{
				System.out.println("The previous entry is invalid.");
				System.out.print("Enter your choice:");
				choice = sc.nextLine();
			}
			return Integer.parseInt(choice);
	 }
	 
    public static void displayProgramList(ArrayList<Program> p)
    {
   		for (int i = 0; i < p.size(); i++)
         	System.out.println(i+ ": " + p.get(i));

    }
    
   public static void displayPastData(ArrayList<PastData> p)
	{
		int size = p.size();
		for (int i = 0; i < size; i++)
		{
			System.out.println(p.get(i));
		}
	}
	
    public static void displayMenu(ArrayList<String> s)
    {
		for (int i = 0; i < s.size(); i++)
		{
			System.out.println(i + ". " + s.get(i));
		}
    }
    
    public static void outputPrograms(ArrayList<Program> p)
	 {
      if(p.isEmpty())
      {
         System.out.print(ERROR);
         Method.getOption(1);
      }
      else
      {
         Method.displayProgramList(p);
         p.get(Method.getOption(p.size()).displayMenu());
      }
	}
   /*public static void sort(ArrayList<Program>p)
    {
		int length = p.size();
		boolean swapped = false;
		
    }*/
}
import java.util.*;

public class Method {
	public static final int CURYEAR = 2018;

    public Method() {
    }
    
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
    
    public static void sort()
    {
    }
    
}
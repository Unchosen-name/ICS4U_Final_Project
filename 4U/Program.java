import java.util.*;

public class Program
{
	private ProgramOverview overview;
	private int numYear;
	private ArrayList< CourseRequirement> course;
	private AdditionalInfo additionalInfo;
	private ContactInfo contact;
	private ArrayList<Graduate> allGraduates;
	private int id;
	Scanner sc = new Scanner(System.in);
	
	public Program()
	{
		//read from file
	}
	public void displayOption()
	{
		//wait for the rest to finish
	}
	
	public void displayPastData()
	{
		int size = pastData.size();
		String input;
		boolean exit;
		if (size > 0 )
		{
			do
			{
				for (int i = 1; i <= size; i++)
				{
					System.out.printf("%d: Year %d%n", i ,i);
				}
				
				System.out.print("Enter any other input to return to previous list.");
				input = sc.nextLine();
				exit = !inputCheck (input,size);
				if (!exit)
					pastData.get(Integer.parseInt(input)).display();
			} while(!exit);
		}
		else
			System.out.println("The past data is empty");
	}
	
	public String toString()
	{
		return "hehe";
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
	public boolean searchProgram(String s)
	{
			return (overview.getName().get.toLowerCase().contains(s.toLowerCase()));
	}
	public boolean searchOuacCode(String s)
	{
			return (overview.getOuacCode().toLowerCase().contains(s.toLowerCase()));
	}
	public boolean searchUni(String s)
	{
			return (overview.getUniversity().toLowerCase().contains(s.toLowerCase()));
	}
	public boolean searchMajor(String s)
	{
			return (overview.getMajor().toLowerCase().contains(s.toLowerCase()));
	}
}
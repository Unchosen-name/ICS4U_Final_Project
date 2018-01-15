import java.util.*;

public class Program
{
	private ProgramOverview overview;
	private ArrayList<CourseRequirement> course;
	private AdditionalInfo additionalInfo;
	private ContactInfo contact;
	private int id;
	private double admissionAverage;
	Scanner sc = new Scanner(System.in);
	
	public Program(ProgramOverview po, ArrayList<CourseRequirement> c, AdditionalInfo info, ContactInfo c, int programID, double average)
	{
		overview = po;
		course = c;
		additionalInfo = info;
		contact = c;
		id = programID;
		admissionAverage = average;
	}//file is read from the ProgramDatabase class to initialize Program class
	
   public Program ()
   {
      overview = new ProgramOverview();
      AdditionalInfo = new AdditionalInfo();
      contact = new ContactInfo();
      CoureseRequirement c;
      boolean exit;
      int input;
      System.out.print ("Enter an input that is not positve integers to exit from entering courses: ");
      input = Integer.parseInt(sc.nextLine());
      exit = checkInput(input, 0);
      for (int i = 0;  i <6 && !exit; i++)
      {
         
         c = new CourseRequirement();
         course.add(c);
         System.out.print ("Enter an input that is not positve integers to exit from entering courses: ");
         input = Integer.parseInt(sc.nextLine());
         exit = !checkInput(input, 0);
      }
      
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
				exit = !Method.inputCheck (input,size);
				if (!exit)
					pastData.get(Integer.parseInt(input)).display();
			} while(!exit);
		}
		else
			System.out.println("The past data is empty");
	}
	
	public String toString()
	{
		return overview.overview();
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
      
   private void save()
   {
      try 
      {
         
      }
      catch (IOException iox)
      {
      }
   }
}
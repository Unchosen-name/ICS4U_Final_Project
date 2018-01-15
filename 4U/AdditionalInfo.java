import java.util.*;

public class AdditionalInfo
{

	private String scholarship;
	private String supplementary;
	private String earlyAdm;
    Scanner sc = new Scanner (System.in);
   
	public AdditionalInfo(String sc, String su, String e)
	{
		scholarship = sc;
		supplementary = su;
		earlyAdm = e;
	}
   public AdditionalInfo()
	{
      System.out.print ("Enter scholarship options: ");
      scholarship=sc.nextLine();
      System.out.print ("Enter supplementary requirement: ");
      supplementary=sc.nextLine();
      System.out.print ("Enter early admission information: ");
      earlyAdm=sc.nextLine();

	}
	public void display()
	{
		Scanner sc  = new Scanner (System.in);
		String input;
		System.out.print(this);
		System.out.print("Press any key to return to previous menu.");
		input = sc.nextLine(); 
	}
	
	public String toString ()
	{
		return("Scholarship options: " + scholarship + "\nSupplementary requirement: " + supplementary + "\nEarly admission date: "+ earlyAdm + "\n\n");
	}
}
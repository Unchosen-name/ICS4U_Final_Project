import java.util.*;

public class PastData_Manager
{

	private ArrayList<PastData> pastData;
	private GraduateDatabase gradData;
	Scanenr sc = new Scanenr (System.in);
	
	public PastData_Manager()
	{
		pastData = new ArrayList<PastData>();
		gradData = new GraduateDatabase(); // graduate database loads from a text file.
	}
	

	
	public static ArrayList<PastData> findPastData (int programID)
	{
		ArrayList<PastData> p;
		for (int i = 0; i < pastData.size(); i++)
		{
			if (pastData.get(i).checkProgram(programID))
				p.add(pastData.get(i));
		}
		return p;
	}
	
	public double admissionAverage(int programID)
	{
		return gradData.calculateMean(programID);
	}
	
	public void addPastData()
	{	
		int year;
		String input;
	
		PastData p;
		System.out.print("Enter the year: ");
		do{
			input = sc.nextLine();
		}
		while{!Method.inputCheck (input, Method.CURYEAR)}
		year = Integer.parseInt(Input);
		System.out.print("Search program: ");
		// input info about the program here
	}

}
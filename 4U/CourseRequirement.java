import java.util.*;

public class CourseRequirement
{

	private String course;
	private double minMark;
   Scanner sc = new Scanner (System.in);
   
	public CourseRequirement(String c, double m)
	{
		course = c;
		minMark = m;
	}
	public CourseRequirement()
   {
      System.out.print ("Enter the required course: ");
      course=sc.nextLine();
      System.out.print ("Enter the minimum average required in this course: ");
      minMark=sc.nextInt();
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
		return("Course code: " + course + "\nMinimum average: " + minMark + "\n");
	}
}
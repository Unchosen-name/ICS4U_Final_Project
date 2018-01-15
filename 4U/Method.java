

public class Method {
	public static final CURYEAR = 2018;

    public Method() {
    }
    
   	public static boolean inputCheck (String s, int option)
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
    
    public static void displayProgramList(ArrayList<Program> p)
    {
   		for (int i = 0; i < p.size(); i++)
         	System.out.println(i+ ": " + p.get(i));
      	String input;
    }
    
    public static void displayPastData(ArrayList<PastData> p)
	{
		int size = p.size();
		for (int i = 0; i < size; i++)
		{
			
		}
	}
	
    public static void displayMenu(String file)
    {
    	try
    	{
    		BufferedReader in = new BufferedReader(new FileReader());
    		
    		
    	}
    	catch(IOException iox)
    	{
    		System.out.println("Problems with the file.");
    	}
    }
    
    public static void chooseOption()
    
    public static void sort()
    {
    }
    
}
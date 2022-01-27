package LockedMe.com;

import java.io.*;
import java.util.*;

public class LockedMe 
{
	
	static final String projFilesPath = "C:\\LockedMeFiles";
	static final String errMsg = "Some error occured. Please contact admin@lockedme.com";

	public static void main(String[] args) {

		
	int ch;
	Scanner  obj = new Scanner(System.in);
	boolean tryAgain = true;
	
	while(tryAgain)
	{
		try 
		{
		    do
		    {
		    	displayMenu();
		    	System.out.println("\n\t Enter your choice");
	    		ch = Integer.parseInt(obj.nextLine());
	 
	    		
	            switch(ch)
	            {
		            case 1:getAllFiles();
		            break;
		            case 2:createFile(obj);
		            break;
		            case 3:deleteFile(obj);
		            break;
		            case 4:searchFiles(obj);
		            break;
		            case 5:System.out.println("Good bye!!");
		            System.exit(0);
		            break;
		            default:System.out.println("Invalid option, please enter the correct option");
		            break;
	            }
	          }
		      while(true);
		}
		
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
	}
}
	   
	
	/**
	 * This method is used to display the options
	 */
	public static void displayMenu()
	{
		System.out.println("\n\n\t\t****************************************************");
		System.out.println("\t\t*                                                  *");
		System.out.println("\t\t*              Welcome to LockedMe.com             *");
		System.out.println("\t\t*                                                  *");
		System.out.println("\t\t****************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("\t 1. Display all the files");
		System.out.println("\t 2. Add a new file");
		System.out.println("\t 3. Delete a file");
		System.out.println("\t 4. Search a file");
		System.out.println("\t 5. Exit");
	}
	
	/**
	 * This method will retrieve all Files names 
	 * under the project directory
	 */
	public static void getAllFiles()
	{
		File folder = new File(projFilesPath);
		File[] listOfFiles = folder.listFiles();
		int n = 1;
		
		System.out.println("\n\nList of files under project folder "+projFilesPath+":\n=====================================================\n");
		try
		{
			if(listOfFiles.length == 0)
				System.out.println("No files exist in the directory");
			else
			{
				for(var l:listOfFiles)
				{
					System.out.println("File "+n+" : "+l.getName());
					n++;
				}
			}
		}
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
		
				
	}
	
	/**
	 * This method will create the files under project folder
	 */
	public static void createFile(Scanner obj)
	{
		
		try
		{
		//Scanner obj = new Scanner(System.in);
		
		String ow="Y";
		
		String fileName;
		System.out.println("Please enter the file name to be created:");
		fileName=obj.nextLine();
		
		File file = new File (projFilesPath+"\\"+ fileName);
	
		if (file.exists())
		{
			boolean cond = true;
			while (cond == true)
			{
			System.out.println("File exists with the same name," +fileName+" Do you want to proceed (Y/N)");
			ow=obj.nextLine();
				if (ow.equals("N"))
				{
					System.out.println("Skipping the file creation due to overlapping file name, good bye");
					cond = false;
				}
				else if (ow.equals("Y"))
				{
					System.out.println("Will proceed with overwriting the existing file");
					cond = false;
				}
				else
					System.out.println("Please enter the correct input");
				}	
		}
		
		if (ow.equals("Y"))
		{
			int linesCount;
			System.out.println("Please enter the line count of the file:");
			linesCount=Integer.parseInt(obj.nextLine());
			FileWriter myWriter = new FileWriter(projFilesPath+"\\"+ fileName);
				for (int i=1;i<=linesCount;i++)
				{
					System.out.println("Please enter the text of line "+i+" for the new file "+fileName);
					myWriter.write(obj.nextLine()+"\n");
				}
			System.out.println("File created successully");
			myWriter.close();
			}
			
		}
		
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
		finally
		{
			
		}		
		
	}
	
	/**
	 * This method will delete the file from the project folder
	 * based on the user input
	 */
	public static void deleteFile(Scanner obj)
	{

		String fileName;
		String conf;
		boolean cond = true;
				
		try
		{
		
		System.out.println("\n\nPlease enter the filename to be deleted:");
		fileName = obj.nextLine();
		
		File file = new File (projFilesPath+"\\"+ fileName);
		
			if(file.exists())
			{
				while (cond==true)
				{
				System.out.println("Not too late, delete "+fileName+" (Y/N)?");
				conf=obj.nextLine();
					if (conf.equals("N"))
					{
						System.out.println("Skipping the deletion of file, "+fileName+".U-Turn isnt always bad. good bye");
						cond = false;
					}
					else if (conf.equals("Y"))
					{
						if(file.delete())
						{
							System.out.println("Mentioned file, "+fileName+" deleted successfully");
							cond = false;
						}
					}
					else
					{
						System.out.println("Please enter the correct input");
					}	
				}				
			}
			else
			{
					System.out.println("Not able to delete the mentioned file, "+fileName+" File not found. Check the list of files \n");
					getAllFiles();
			}	
		}
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
		
	}
	
	/**
	 *  This method is used to search for the file 
	 *  under the project directory
	 */
	public static void searchFiles(Scanner obj)
	{
		String fileName;
		File folder = new File(projFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		try
		{
		
		System.out.println("\n\nPlease enter the filename to be searched:");
		fileName = obj.nextLine();
		int FNF=1; // This variable is used to set the flag for File not found status
			
		for(var l:listOfFiles)
			if(l.getName().equals(fileName))
			{
				System.out.println("File "+fileName+" is available under project directory");
				FNF=0;
				break;
			}
		
		if(FNF==1)
			System.out.println("File "+fileName+" is not available under project directory");
		
		//obj1.close();
		//System.out.println("obj closed");
		
		}
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
		
	}

}

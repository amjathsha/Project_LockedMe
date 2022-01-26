package LockedMe.com;

import java.io.*;
import java.util.*;

public class LockedMe {
	
	static final String projFilesPath = "C:\\LockedMeFiles";
	static final String errMsg = "Some error occured. Please contact admin@lockedme.com";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchFiles();

	}
	
	public static void displayMenu()
	{
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("\t\t****************************************************");
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
		System.out.println("\n\t Enter your choice");
		
		
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
	
	public static void createFile()
	{
		
	}
	
	/**
	 * This function will delete the file from the project folder
	 * based on the user input
	 */
	public static void deleteFile()
	{

		String fileName;
		Scanner obj = new Scanner(System.in);
		
		try
		{
		
		System.out.println("\n\nPlease enter the filename to be deleted:");
		fileName = obj.nextLine();
		
		File file = new File (projFilesPath+"\\"+ fileName);
		
			if(file.exists())
			{
				if(file.delete())
				{
					System.out.println("Mentioned file delete successfully");
				}
			}
			else
			{
					System.out.println("Not able to delete the mentioned file, File not found");
					getAllFiles();
			}	
		}
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
		finally
		{
			obj.close();
		}
	}
	
	/**
	 *  This method is used to search for the file 
	 *  under the project directory
	 */
	public static void searchFiles()
	{
		String fileName;
		Scanner obj = new Scanner(System.in);
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
		
			
		}
		catch (Exception Ex)
		{
			System.out.println(errMsg);
		}
		finally
		{
			obj.close();
		}		
	}

}

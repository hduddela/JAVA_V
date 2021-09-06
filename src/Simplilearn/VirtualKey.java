package Simplilearn;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class VirtualKey {
	static void addmethod(String newfilename) throws FileNotFoundException, IOException
	{
		File file = new File("F://phase1//"+newfilename);
		if (file.createNewFile())
			System.out.println("New File is created...");	
		else
			throw new FileNotFoundException("File Already Found");
	}
	
	static void delmethod(String delfilename) throws FileNotFoundException, IOException
	{
		File file = new File("F://phase1//");
		String content1[] = file.list();
		File file1 = new File("F://phase1//"+delfilename);
		boolean flag = false;
		for (int i = 0; i < content1.length; i++) {
			Object check1 = content1[i];
			if (delfilename.equals(check1)) {
				if (file1.delete())
				flag = true;
				break;
			}
		}

		if (flag == true)
			System.out.println("File deleted successfully");
		else
			throw new FileNotFoundException("File Not Found");
	}
	
	static void sermethod(String serfilename) throws FileNotFoundException, IOException
	{
		File file = new File("F://phase1//");
		String content1[] = file.list();
		boolean flag = false;
		for (int i = 0; i < content1.length; i++) {
			Object check1 = content1[i];
			if (serfilename.equals(check1)) {
				flag = true;
				break;
			}
		}

		if (flag == true)
			System.out.println("File Found");
		else
			throw new FileNotFoundException("File Not Found");
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		char ch;
		do{
            System.out.println("\nFile Operations");
            System.out.println("1. Display all files");
            System.out.println("2. Add a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Search a file");
            System.out.println("5. Close the application");
            System.out.println("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 :
            	File d = new File("F://phase1//");
    			if(d.isDirectory())
    			{
    				File[] f = d.listFiles();
    				System.out.println("Total files in Directory");
    				for(File file:f)
    				{
    					System.out.println(file.getName());
    				}
    				Arrays.sort(f);
    			}
    			break;
            	
            case 2 :
            	System.out.println("Enter the file name you want to create: ");
            	String newfilename = scan.next();
            	try {
            		addmethod(newfilename);
            	} catch (Exception m) {
            		System.out.println("Exception occured: "+ m.getMessage());
        		}
            	break;
            	
            case 3 :
            	System.out.println("Enter the file name you want to delete: ");
            	String delfilename = scan.next();
            	try {
            		delmethod(delfilename);
            	} catch (Exception m) {
            		System.out.println("Exception occured: "+ m.getMessage());
        		}
            	break;
            	
            case 4 :
            	System.out.println("Enter the file name you want to search: ");
            	String serfilename = scan.next();
            	try {
            		sermethod(serfilename);
            	} catch (Exception m) {
            		System.out.println("Exception occured: "+ m.getMessage());
            	}
            	break;
            	
            case 5 :
            	scan.close();
            	System.exit(choice);
            	break;
            	
            default :
            	System.out.println("Invalid Choice \nPlease enter valid choice ");
            	break;
            
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);

		}while (ch == 'Y'|| ch == 'y');

	}
}

class FileNotFoundException extends Exception {
	FileNotFoundException(String s) {
		super(s);
	}
}

	
	
	


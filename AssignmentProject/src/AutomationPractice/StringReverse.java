package AutomationPractice;

import java.util.Scanner;

public class StringReverse 
{
	public static void main(String[] args)
	{
		String original;
		String rev= "";
		
		System.out.println("Enter the string to reverse");
		Scanner sc =  new Scanner(System.in);
		original = sc.nextLine();
		
		int len = original.length();
		
		for(int i = len-1; i>=0; i--)
			rev = rev + original.charAt(i);
		
		System.out.println("Original string is : "+original);
		System.out.println("Reverse of string is : "+rev);
	}
	

}

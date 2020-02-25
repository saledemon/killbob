package Kill_bob;

import java.util.Scanner;

public class Start {
	
	Scanner scan = new Scanner(System.in);
	
	public int Dialog(){
		
		String x;
		
		System.out.println(StartLines.Q0.getLine());
		x = scan.nextLine();
		System.out.println(StartLines.Q1.getLine());
		System.out.println("\nWhat do you whish to respond? \n" + 
							" 1  " + StartLines.A11.getLine() + 
							"\n 2  " + StartLines.A12.getLine());
		x = scan.nextLine();
		if (x.equals("1")) {System.out.println(StartLines.Q21.getLine());}
		else {  if (x.equals("2")) {System.out.println(StartLines.Q22.getLine());}
				else {System.out.println("You fucked up.");return(0);}}
		
		System.out.println("\nWhat do you whish to respond? \n" + 
				" 1  " + StartLines.A21.getLine() + 
				"\n 2  " + StartLines.A22.getLine());
		x = scan.nextLine();
		if (x.equals("1")) {System.out.println(StartLines.Q31.getLine());}
		else {  if (x.equals("2")) {System.out.println(StartLines.Q32.getLine());}
				else {System.out.println("You fucked up.");return (0);}}
		
		System.out.println("\nWhat do you whish to respond? \n" + 
				" 1  " + StartLines.A31.getLine() + 
				"\n 2  " + StartLines.A32.getLine());
		x = scan.nextLine();
		if (x.equals("1")) {System.out.println(StartLines.Q41.getLine());
							x = scan.nextLine(); return (1);}
		else {  if (x.equals("2")) {System.out.println(StartLines.Q42.getLine());
									
		x = scan.nextLine(); return (2);}
				else {System.out.println("You fucked up.");return (0);}}
	}
	

}


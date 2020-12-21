package Theater;

import java.util.Scanner;

public class Booth {
	
	static Scanner scan = new Scanner(System.in);

	//allows for lower case y
	static String yesno = "";

	public static void main(String[] args)
	{
		
		Chart theater = new Chart();
		
		//loop for buying seats
		do
		{
			theater.printSeats();
			theater.chooseSeat();
			theater.printSeats();
			
			//stops loop if all seats are full
			if(!theater.checkFull())
			{
				System.out.println("Purchase another seat? (Y/N) ");

			}
			else if(theater.checkFull())
			{
				System.out.println("Sorry, all seats are taken. Enter anything to exit.");
			}
			yesno = scan.next();
		}
		while(yesno.equals("Y") || yesno.equals("y"));
		
		
		
	
		
	}

}

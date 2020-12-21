package Theater;

import java.util.Random;
import java.util.Scanner;

public class Chart {

	
	Scanner scan = new Scanner(System.in);
	
	//stops user from buying a seat by price if all seats of that price are taken
	int tencounter = 0;
	int twencounter = 0;
	int thirtcounter = 0;
	int fourtcounter = 0;
	int ficounter = 0;
	
	//assigned a value based on user interaction
	int time = 0;
	int incorrect = 0;
	
	//records choice of way to purchase
	int choose;
	
	//price of seat chosen
	int seatprice;
	
	//choice of seat if purchased directly, not by price
	int seatchoice;
	
	//official column and row of selection by user "translated" so the program can understand
	int offcol;
	int offrow;
	
	//chart
	int[][] seating = 
		{		
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},

			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},

			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},

			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},

			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},

			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},

			{20, 20, 30, 30, 40, 40, 30, 30, 20, 20},

			{20, 30, 30, 40, 50 ,50, 40, 30, 30, 20},

			{30, 40, 50, 50, 50, 50, 50, 50, 40, 30},
		};

	
	//methods
	
	//prints out chart, and updates for all future times
	public void printSeats()
	{
		if(time == 0)
		{
			System.out.println("This is the seating chart by price: ");
			time = 1;
		}
		else if(time != 0)
		{
			System.out.println("This is the updated seating chart: ");
		}
		
		for(int i = 0; i < seating.length; i++)
		{
			for(int j = 0; j < seating[0].length; j++)
			{
				System.out.print(seating[i][j]+" ");
			}
			System.out.println();
		}
	}

	//main method for user to choose way of seat selection and then which seat, doesn't allow seats already chosen
	public void chooseSeat()
	{
		System.out.println();
		System.out.println("Would you like to choose a seat or a price? ");
		System.out.println("Enter 1 for seat.");
		System.out.println("Enter 2 for price.");
		choose = scan.nextInt();
		if(choose == 1)
		{
			System.out.println("Each row is assigned a letter from 'A' to 'I'.");
			System.out.println("Each Column is assigned a number, from '1' to '10'");
			System.out.println("Choose a seat: Example: A2");
			String seatchoice = scan.next();
			String seatrow = seatchoice.substring(0,1);
			String seatcol = seatchoice.substring(1, seatchoice.length());
			switch(seatrow)
			{
			case "A":
				offrow = 0;
				break;
			case "B":
				offrow = 1;
				break;
			case "C":
				offrow = 2;
				break;
			case "D":
				offrow = 3;
				break;
			case "E":
				offrow = 4;
				break;
			case "F":
				offrow = 5;
				break;
			case "G":
				offrow = 6;
				break;
			case "H":
				offrow = 7;
				break;
			case "I":
				offrow = 8;
				break;
			default:
				System.out.println("Incorrect Value, Please Re-enter.");
				chooseSeat();
				incorrect = 1;
				break;
			}
			if(incorrect != 1)
			{
				offcol = Integer.parseInt(seatcol);
				offcol--;
				if(calculatePrice()) 
				{
					System.out.println("You purchased seat "+seatchoice+" for $"+seatprice+".");
					seating[offrow][offcol] = 0;
				}
			}
		}
		else if(choose == 2)
		{
			System.out.println("Choose a price by entering it: (10 - 50) ");
			seatprice = scan.nextInt();
			randomSeat(seatprice);
			System.out.println("You purchased a seat for $"+seatprice+".");
		}
		else
		{
			System.out.println("That is not a valid output, please retry.");
			chooseSeat();
		}
	}

	//allows the computer to choose a random seat, doesn't choose seats already chosen
	private void randomSeat(int price)
	{
		if(price == 10)
		{
			Random rand = new Random();
			int tenchoice = rand.nextInt(42);
			int[] tenseatrow = {1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6};
			int[] tenseatcol = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,9,10,1,2,9,10,1,2,9,10};
			if(tencounter != 42)
			{
				while(seating[tenseatrow[tenchoice] -1][tenseatcol[tenchoice] -1] == 0)
				{
					tenchoice = rand.nextInt(42);
				}
				seating[tenseatrow[tenchoice] -1][tenseatcol[tenchoice] -1] = 0;
				tencounter++;
			}
			else if(tencounter == 42)
			{
				System.out.println("Sorry, all ten dollar seats are full. Please buy a different seat.");
				chooseSeat();
			}
			
		}
		else if(price == 20)
		{
			Random rand = new Random();
			int twenchoice = rand.nextInt(24);
			int[] twenseatrow = {4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,8,8};
			int[] twenseatcol = {3,4,5,6,7,8,3,4,5,6,7,8,3,4,5,6,7,8,1,2,9,10,1,10};
			if(twencounter != 24)
			{
				while(seating[twenseatrow[twenchoice] - 1][twenseatcol[twenchoice] -1] == 0)
				{
					twenchoice = rand.nextInt(24);
				}
				seating[twenseatrow[twenchoice] - 1][twenseatcol[twenchoice] -1] = 0;
				twencounter++;
			}
			else if(twencounter == 24)
			{
				System.out.println("Sorry, all twenty dollar seats are full. Please buy a different seat.");
				chooseSeat();
			}
		}
		else if(price == 30)
		{
			Random rand = new Random();
			int thirtchoice = rand.nextInt(10);
			int[] thirtseatrow = {7,7,7,7,8,8,8,8,9,9};
			int[] thirtseatcol = {3,4,7,8,2,3,8,9,1,10};
			if(thirtcounter != 10)
			{
				while(seating[thirtseatrow[thirtchoice] - 1][thirtseatcol[thirtchoice] -1] == 0)
				{
					thirtchoice = rand.nextInt(10);
				}
				seating[thirtseatrow[thirtchoice] - 1][thirtseatcol[thirtchoice] -1] = 0;
				thirtcounter++;
			}
			else if(thirtcounter == 10)
			{
				System.out.println("Sorry, all thirty dollar seats are full. Please buy a different seat.");
				chooseSeat();
			}
			

		}
		else if(price == 40)
		{
			Random rand = new Random();
			int fourtchoice = rand.nextInt(6);
			int[] fourtseatrow = {7,7,8,8,9,9};
			int[] fourtseatcol = {5,6,4,7,2,9};
			if(fourtcounter != 6)
			{
				while(seating[fourtseatrow[fourtchoice] - 1][fourtseatcol[fourtchoice] -1] == 0)
				{
					fourtchoice = rand.nextInt(6);
				}
				seating[fourtseatrow[fourtchoice] - 1][fourtseatcol[fourtchoice] -1] = 0;
				fourtcounter++;
			}
			else if(fourtcounter == 6)
			{
				System.out.println("Sorry, all fourty dollar seats are full. Please buy a different seat.");
				chooseSeat();
			}

		}
		else if(price == 50)
		{
			Random rand = new Random();
			int fichoice = rand.nextInt(8);
			int[] fiseatrow = {8,8,9,9,9,9,9,9};
			int[] fiseatcol = {5,6,3,4,5,6,7,8};
			if(ficounter != 8)
			{
				while(seating[fiseatrow[fichoice] - 1][fiseatcol[fichoice] -1] == 0)
				{
					fichoice = rand.nextInt(8);
				}
				seating[fiseatrow[fichoice] - 1][fiseatcol[fichoice] -1] = 0;
				ficounter++;
			}
			else if(ficounter == 8)
			{
				System.out.println("Sorry, all fifty dollar seats are full. Please buy a different seat.");
				chooseSeat();
			}
			

		}
		else
		{
			System.out.println("That is not a valid price. Please choose another.");
			chooseSeat();
		}
		
	}
	
	//calculates the price of seats if user selects the seat directly
	private boolean calculatePrice() {
		if(seating[offrow][offcol] != 0)
		{
			this.seatprice = seating[offrow][offcol];
			return true;
		}
		else if(seating[offrow][offcol] == 0)
		{
			System.out.println("That seat is taken. Please choose another.");
			chooseSeat();
			return false;
		}
		return true;
	}
	
	//checks to make sure there are any seats available
	public boolean checkFull()
	{
		int total = 0;
		for(int[] i : seating)
		{
			for(int j : i)
			{
				total = j + j;
			}
		}
		if(total == 0)
		{
			return true;
		}
		return false;
	}
}

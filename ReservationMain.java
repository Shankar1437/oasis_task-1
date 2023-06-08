package oasisTask;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ReservationMain 
{
	private static String userId = "Shankar";
	private static String password = "Shankar@1234";
	private static Reservation r1 ;
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Train Reservation System Portal !");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your UserName : ");
		String login = sc.nextLine();
		
		System.out.println("Enter your Password : ");
		String pass = sc.nextLine();
		
		
		if(userId.equals(login) && password.equals(pass))
		{
			System.out.println("Login Sccessfully !");
			System.out.println("===============================================");
			
			while(true)
			{
				System.out.println("\n1. Make a Ticket Reservation for your Journey ");
				System.out.println("2. Cancel your Ticket Reservation");
				System.out.println("\nEnter your choiced option : ");
				int select = sc.nextInt();
				System.out.println("===============================================");

				
				switch(select)
				{
				case 1:
					makeReservation(sc);
					break;
					
				case 2:
					cancelReservation(sc);
					break;
				
				case 3:
					System.out.println("Logout");
					System.exit(0);
					
								
				default:
					System.out.println("Entered data is Invalid");
				}
			}	
		}
		else
		{
			System.out.println("Entered UserName or Password is Incorrect !");
		}
		
		
	}
	
	private static void makeReservation( Scanner sc)
	{
		sc.nextLine();
	
		System.out.println("\nEnter your first and Sirname : ");
		String name = sc.nextLine();
		
		System.out.println("Enter your journey form : ");
		String start = sc.nextLine();
		
		System.out.println("Enter your destination : ");
		String end = sc.nextLine();
		
        System.out.println("Enter a date (DD-MM-YYYY) : ");
        String date = sc.nextLine();
        
        System.out.println("Enter a train name :");
        String trainName = sc.nextLine();
        
        System.out.println("Reservation successfully made!");
		System.out.println("===============================================");
	
		int pnrNumber=pnrNumber();
		r1 = new Reservation(pnrNumber, name, start, end, date, trainName);
		System.out.println("\nYour Genrated PNR Number is : "+pnrNumber);
		System.out.println("Full Name : "+name);
		System.out.println("Journey : "+start+" to "+end);
		System.out.println("Date : "+date);
		System.out.println("Train Name : "+trainName);
		System.out.println("===============================================");


	}

	private static void cancelReservation(Scanner sc)
	{
		if(r1!=null)
		{
		System.out.println("Enter your PNR Number : ");
		int enteredNum = sc.nextInt();
		
		if((r1.getPNRNumber())==(enteredNum))
		{
	
		        System.out.println("\nYour Reservation Details : ");
				System.out.println("Your Genrated PNR Number is : "+r1.getPNRNumber());
				System.out.println("Full Name : "+r1.getName());
				System.out.println("Journey : "+r1.getStart()+" to "+r1.getEnd());
				System.out.println("Date : "+r1.getDate());
				System.out.println("Train Name : "+r1.getTrainName());
				sc.nextLine();

				System.out.println("Enter 'ok' for Confirm cancellation : ");
				String cancel = sc.nextLine().toLowerCase();
				
				if("ok".equals(cancel))
				{
					System.out.println("Reservation successfully canceled!");
				}
				else
				{
					System.out.println("Cancellation canceled.");
				}
				System.out.println("===============================================");

			
		}
		else
		{
			System.out.println("Entered PNR Number is Worng.");
		}
		}
		else
		{
			System.out.println("You Not make any Reservation.");
		}
	}
	
	private static int pnrNumber()
	{
		return ThreadLocalRandom.current().nextInt(100000, 1000000);
		
	}
}

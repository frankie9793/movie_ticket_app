package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MoblimaApp {

	public static void main(String[] args) throws IOException, ParseException {

		int i = 1;

		Scanner sc = new Scanner(System.in);
		CinemaStaff staff1 = new CinemaStaff();
		NormalCinema NM1 = new NormalCinema(1);
		MovieGoer customer = new MovieGoer();
		String[][] somearray;
		String dummy;
		boolean done = true;
		boolean tempCheck = true;
		// staff1.login();
		int userInput = 0;
		String userInputS = null;
		int x = 1;

		do {
			System.out.println("=======================================================================");
			System.out.println("|                       WELCOME TO MOBLIMA APP                        |");
			System.out.println("=======================================================================");
			System.out.println("|1 Search/List Movie                                                  |");
			System.out.println("|2 Book and purchase ticket                                           |");
			System.out.println("|3 View booking history                                               |");
			System.out.println("|4 List Top 5 ranking by ticket sales or by overall reviewer's rating |");
			System.out.println("|5 Login                                                              |");
			System.out.println("|6 Exit Application                                                   |");
			System.out.println("=======================================================================");
			do {
				try {
					System.out.println("Enter option");
					System.out.println("---------------------------");
					userInput = sc.nextInt();
					tempCheck = false;
				} catch (Exception e) {
					System.out.println("Please enter number from 1-7");
					sc.nextLine();
					tempCheck = true;
				}
			} while (tempCheck);

			switch (userInput) {
			case 1:
				System.out.println("1) Search Movie");
				System.out.println("2) List Movie");
				do {
					try {
						System.out.println("Enter option");
						System.out.println("---------------------------");
						userInput = sc.nextInt();
						if (userInput <= 2 && userInput >= 1)
							tempCheck = false;
						else {
							System.out.println("Please enter number 1 or 2");
							System.out.println("");
							tempCheck = true;
						}

					} catch (Exception e) {

						System.out.println("Please enter number 1 or 2");
						System.out.println("");
						sc.nextLine();
						tempCheck = true;
					}
				} while (tempCheck);
				switch (userInput) {
				case 1:
					// search movie
					customer.SearchMovie();
					break;
				case 2:
					// list Movie
					customer.ListMovie();
					break;
				default:
					System.out.println("Please enter number 1 or 2");
					break;
				}
				if (userInput == 1 && !TableProcessor.IsEmpty("Searching.txt"))
					customer.ViewMovieDetails();
				else if (userInput == 2)
					customer.ViewMovieDetails();

				break;
			case 2:
				// Check seat availability and selection of seat's
				TableProcessor.printMS();
				customer.seatbook();
				break;
			case 3:
				// View past booking
				System.out.println("Please enter Name/Phone/Email to search for past booking");
				sc.nextLine();
				userInputS = sc.nextLine();
				customer.ViewPastBooking(userInputS);
				break;
			case 4:
				do {
					try {
						System.out.println("\nPlease enter your choice");
						System.out.println("-------------------------------------------");
						System.out.println("1:| View by ticket sales     		  |");
						System.out.println("2:| View by overall rating   		  |");
						System.out.println("3:| Back                 		  |");
						System.out.println("-------------------------------------------");
						userInput = sc.nextInt();
						switch (userInput) {
						case 1:
							customer.ViewTopMovies(true);
							break;
						case 2:
							customer.ViewTopMovies(false);
							break;
						case 3:
							tempCheck = false;
							break;
						default:
							System.out.println("That is an invalid choice.Please enter again");
							dummy = sc.nextLine();
							break;
						}
					
					} catch (InputMismatchException e) {
						System.out.println("That is an invalid input.Please enter again.");
						dummy = sc.nextLine();
						continue;
					}
				}while(tempCheck);
				break;
			case 5:
				System.out.println("Login as staff? (Y/N)");
				String choice;
				dummy = sc.nextLine();
				choice = sc.nextLine();
				if (choice.equalsIgnoreCase("Y")) {
					staff1.login();
				} else
					break;
				while (done) {
					System.out.println("===========================================");
					System.out.println("|               Admin Module              |");
					System.out.println("===========================================");
					System.out.println("Please enter your choice");
					System.out.println("-------------------------------------------");
					System.out.println("1:| Create/Update/Delete movie            |");
					System.out.println("2:| Create/Update/Delete Movie Schedules  |");
					System.out.println("3:| Configure system settings             |");
					System.out.println("4:| List Top 5 movies                     |");
					System.out.println("5:| Exit                                  |");
					System.out.println("-------------------------------------------");
					i = sc.nextInt();
					switch (i) {
					case 1:
						do{
							try{
								System.out.println("\nPlease enter your choice");
								System.out.println("-------------------------------------------");
								System.out.println("1:| Create new movie			  |");
								System.out.println("2:| Update movie                          |");
								System.out.println("3:| Delete movie                          |");
								System.out.println("4:| Back                                  |");
								System.out.println("-------------------------------------------");

								userInput = sc.nextInt();
								switch (userInput) {
								case 1:
									staff1.CreateMovie();
									break;
								case 2:
									staff1.UpdateMovie();
									break;
								case 3:
									staff1.RemoveMovie();
									break;
								case 4:
									tempCheck = false;
									break;
								}
							}
							catch(InputMismatchException e){
								System.out.println("That is an invalid input.Please enter again.");
								dummy = sc.nextLine();
								continue;
							}
						}while(tempCheck);
						break;
					case 2:
						do{
							try{
								System.out.println("\nPlease enter your choice");
								System.out.println("-------------------------------------------");
								System.out.println("1:| Create new Movie Schedules            |");
								System.out.println("2:| Update Movie Schedules		  |");
								System.out.println("3:| Delete Movie Schedules		  |");
								System.out.println("4:| Back				  |");
								System.out.println("-------------------------------------------");
								userInput = sc.nextInt();
								switch (userInput) {
								case 1:
									staff1.CreateShowtimes();
									break;
								case 2:
									staff1.UpdateShowtimes();
									break;
								case 3:
									staff1.RemoveShowtimes();
									break;
								case 4:
									tempCheck = false;
									break;
								}
							}
							catch(InputMismatchException e){
								System.out.println("That is an invalid input.Please enter again.");
								dummy = sc.nextLine();
								continue;
							}
						}while(tempCheck);
						break;
						
					case 3:
						do{
							try{
								System.out.println("\nPlease enter your choice");
								System.out.println("-------------------------------------------");
								System.out.println("1:| Create Public Holiday		  |");
								System.out.println("2:| Delete Public Holiday		  |");
								System.out.println("3:| Adjust Ticket Price			  |");
								System.out.println("4:| Back				  |");
								System.out.println("-------------------------------------------");
								userInput = sc.nextInt();
								switch (userInput) {
								case 1:
									staff1.CreatePH();
									break;
								case 2:
									staff1.RemovePH();
									break;
								case 3:
									staff1.ManipulatePrice();
									break;
								case 4:
									tempCheck = false;
									break;
								default:
									System.out.println("That is an invalid choice.Please enter again");
									dummy = sc.nextLine();
									break;
								}
							}
							catch(InputMismatchException e){
								System.out.println("That is an invalid input.Please enter again.");
								dummy = sc.nextLine();
								continue;
							}
						}while(tempCheck);
						break;
					case 4:
						do {
							try {
								System.out.println("\nPlease enter your choice");
								System.out.println("-------------------------------------------");
								System.out.println("1:| View by ticket sales     		  |");
								System.out.println("2:| View by overall rating   		  |");
								System.out.println("3:| Back                 		  |");
								System.out.println("-------------------------------------------");
								userInput = sc.nextInt();
								switch (userInput) {
								case 1:
									customer.ViewTopMovies(true);
									break;
								case 2:
									customer.ViewTopMovies(false);
									break;
								case 3:
									tempCheck = false;
									break;
								default:
									System.out.println("That is an invalid choice.Please enter again");
									dummy = sc.nextLine();
									break;
								}
							
							} catch (InputMismatchException e) {
								System.out.println("That is an invalid input.Please enter again.");
								dummy = sc.nextLine();
								continue;
							}
						}while(tempCheck);
						break;
					case 5:
						done = false;
						break;
					}
				}
				done=true;
				break;
			case 6:
				x = 2;
				System.out.println("Exiting Application...");
				break;

			}
		} while (x == 1);

	}

}

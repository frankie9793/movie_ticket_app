package assignment;

import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import assignment.Enumclasses.Genre;
import assignment.Enumclasses.MovieRating;
import assignment.Enumclasses.MovieType;
import assignment.Enumclasses.ShowingStatus;
import assignment.TableProcessor;

public class CinemaStaff extends User {

	// staff has their own username and password to login to the system
	private String username;
	private String password;
	private boolean loggedin;

	// simple login method for staff to login (additional decoding can be added
	// here)
	public CinemaStaff() {
		loggedin = false;
	}

	public void login() throws IOException {

		Console console = System.console();
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		this.username = sc.next();
		//System.out.println("Password: ");
		//this.password = this.username + "," + sc.next();
		password = new String(console.readPassword("Password: "));
		this.password = this.username + "," + password;
		try {
			FileReader frStream = new FileReader("LoginDatabase.txt");
			BufferedReader reader = new BufferedReader(frStream);
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				if (currentLine != null && currentLine.equals(password)) {
					this.loggedin = true;
					System.out.println("Login successful!\n");
				} else {
					System.out.println("Username and Password did not match\n");
					login();
				}
			}
			frStream.close();
			reader.close();
		}
		// error handled for when database of username and password could not be
		// found
		catch (FileNotFoundException e) {
			System.out.println("Error opening the database file!" + e.getMessage());
			System.exit(0);
		}
	}

	// Functioning method. Sub modules need to handle exceptions
	public void CreateMovie() throws IOException {

		int i = 8;
		int k = 99;
		int j = 1;
		int l = 1;
		int m = 99;
		int userchoice;
		int genrecount = 0;

		String title;
		String flush;
		String genre = "";

		boolean tempCheck = true;
		// check if staff is logged in or not in order to access these functions
		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			Movie newmovie1 = new Movie();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome!");
			System.out.println("Enter Movie Title");
			System.out.println("---------------------------------------");
			while (true) {
				title = sc.nextLine();
				if (TableProcessor.IsEmpty("MovieListingTable.txt")) {
					newmovie1.setTitle(title);
					break;
				} else {
					// exception handled here to check if such movie title
					// already exists in the database
					if (TableProcessor.Search(title, 2, "MovieListingTable.txt")) {
						System.out.println("Movie title already exists.Please enter a new movie title");
						continue;
					} else {
						newmovie1.setTitle(title);
						break;
					}

				}
			}
			System.out.println("Enter Director.");
			System.out.println("---------------------------------------");
			newmovie1.setDirector(sc.nextLine());
			System.out.println("Enter Cast Members seperated by comma");
			System.out.println("---------------------------------------");
			newmovie1.setCast(sc.nextLine());
			System.out.println("Write a Synopsis. Press Enter to submit");
			System.out.println("---------------------------------------");
			newmovie1.writeSynopsis(sc.nextLine());
			do {
				try {
					System.out.println("Please select the genre\n");
					System.out.println("----------------------------------------------------------------");
					System.out.println("[1]  Action  [2]  Adventure [3]  Animation   [4]  Biography");
					System.out.println("[5]  Comedy  [6]  Crime     [7]  Documentary [8]  Drama");
					System.out.println("[9]  Family  [10] Fantasy   [11] Film_Noir   [12] History");
					System.out.println("[13] Horror  [14] Music     [15] Musical     [16] Mystery");
					System.out.println("[17] Romance [18] SciFi     [19] Sports      [20] Thriller");
					System.out.println("             [21] War       [22] Western");
					System.out.println("----------------------------------------------------------------");
					System.out.println("Select your choice. Enter -1 to finish adding genre");
					userchoice = sc.nextInt();
					switch (userchoice) {
					case 1:
						genre += "," + Genre.Action;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 2:
						genre += "," + Genre.Adventure;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 3:
						genre += "," + Genre.Animation;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 4:
						genre += "," + Genre.Biography;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 5:
						genre += "," + Genre.Comedy;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 6:
						genre += "," + Genre.Crime;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 7:
						genre += "," + Genre.Documentary;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 8:
						genre += "," + Genre.Drama;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 9:
						genre += "," + Genre.Family;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 10:
						genre += "," + Genre.Fantasy;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 11:
						genre += "," + Genre.Film_Noir;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 12:
						genre += "," + Genre.History;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 13:
						genre += "," + Genre.Horror;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 14:
						genre += "," + Genre.Music;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 15:
						genre += "," + Genre.Musical;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 16:
						genre += "," + Genre.Mystery;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 17:
						genre += "," + Genre.Romance;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 18:
						genre += "," + Genre.SciFi;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 19:
						genre += "," + Genre.Sports;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 20:
						genre += "," + Genre.Thriller;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 21:
						genre += "," + Genre.War;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case 22:
						genre += "," + Genre.Western;
						genrecount = 1;
						System.out.println("Added!");
						break;
					case -1:
						if (genrecount == 0) {
							System.out.println("You have not selected a single genre");
						} else {
							tempCheck = false;
							break;
						}
					default:
						System.out.println("That is an invalid choice.Please enter again");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("That is an invalid input. Please enter again");
					flush = sc.nextLine();
					continue;
				}
			} while (tempCheck);
			genre = genre.substring(1);
			newmovie1.setGenre(genre);
			while (true) {
				try {
					System.out.println("Please select the rating for the movie");
					System.out.println("---------------------------------------");
					System.out.print("1: G \n2: PG_13 \n3: NC_16 \n4: M_18 \n5: R_21 \n");
					i = sc.nextInt();
					switch (i) {
					case 1:
						newmovie1.setRating(MovieRating.G);
						break;
					case 2:
						newmovie1.setRating(MovieRating.PG13);
						break;
					case 3:
						newmovie1.setRating(MovieRating.NC16);
						break;
					case 4:
						newmovie1.setRating(MovieRating.M18);
						break;
					case 5:
						newmovie1.setRating(MovieRating.R21);
						break;
					default:
						System.out.println("Invalid choice please enter again\n");
						continue;
					}
					break;
				} catch (InputMismatchException ex) {
					System.out.println("This is an invalid input. Please try again.\n");
					flush = sc.nextLine();
					continue;
				}
			}
			while (true) {
				try {
					System.out.println("Set the showing status of the movie");
					System.out.println("---------------------------------------");
					System.out.println("1: ComingSoon");
					System.out.println("2: Preview");
					System.out.println("3: NowShowing");
					k = sc.nextInt();
					switch (k) {
					case 1:
						newmovie1.setShowingStatus(ShowingStatus.ComingSoon);
						j = 0;
						break;
					case 2:
						newmovie1.setShowingStatus(ShowingStatus.Preview);
						j = 0;
						break;
					case 3:
						newmovie1.setShowingStatus(ShowingStatus.NowShowing);
						j = 0;
						break;
					default:
						System.out.println("Invalid choice please enter again\n");
						continue;
					}
					break;
				} catch (InputMismatchException ex) {
					System.out.println("This is an invalid input. Please try again.\n");
					flush = sc.nextLine();
					continue;
				}
			}
			while (true) {
				try {
					System.out.println("Please set the type of the movie");
					System.out.println("---------------------------------------");
					System.out.println("1: 3D");
					System.out.println("2: NORMAL");
					m = sc.nextInt();

					switch (m) {
					case 1:
						newmovie1.setMovieType(MovieType._3D);
						l = 0;
						break;
					case 2:
						newmovie1.setMovieType(MovieType.NORMAL);
						l = 0;
						break;
					default:
						System.out.println("Invalid choice please enter again\n");
						continue;
					}
					break;
				} catch (InputMismatchException ex) {
					System.out.println("This is an invalid input. Please try again.\n");
					flush = sc.nextLine();
					continue;
				}
			}
			TableProcessor.Insert(newmovie1.ConvertToRecord(), "MovieListingTable.txt");
			System.out.println("New Movie Listing Created!");
		}
	}

	public void UpdateMovie() throws IOException, ParseException {

		int serialno;
		int choice;
		int choice2;
		int userchoice;
		int genrecount = 0;
		boolean tempCheck = true;
		String genre = "";
		Scanner sc = new Scanner(System.in);
		String value;
		@SuppressWarnings("unused")
		String dummy;
		String movietitle;

		if (!TableProcessor.IsEmpty("MovieListingTable.txt")) {
			while (true) {
				try {
					System.out.println("\nPlease select the movie you want to update");
					System.out.println("------------------------------------------");
					TableProcessor.PrintList(2, "MovieListingTable.txt");
					System.out.println("------------------------------------------");
					serialno = sc.nextInt();
					if (serialno <= TableProcessor.NoOfRecords("MovieListingTable.txt"))
						break;
					else {
						System.out.println("That is an invalid choice. Please enter again.");
						dummy = sc.nextLine();
						continue;
					}
				} catch (InputMismatchException e) {
					System.out.println("That is an invalid input.Please enter again.");
					dummy = sc.nextLine();
					continue;
				}
			}
			TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
			while (true) {
				try {
					System.out.println("\nPlease select the attribute you want to update");
					System.out.println("------------------------------------------");
					System.out.println("1: Director");
					System.out.println("2: Cast");
					System.out.println("3: Rating");
					System.out.println("4: Genre");
					System.out.println("5: MovieStatus");
					System.out.println("6: Synopsis");
					System.out.println("7: Movie Type");
					System.out.println("------------------------------------------");
					choice = sc.nextInt();
					switch (choice) {

					case 1:
						System.out.println("Enter new director name");
						System.out.println("------------------------------------------");
						dummy = sc.nextLine();
						value = sc.nextLine();
						TableProcessor.Update(serialno, 1, 3, value, "MovieListingTable.txt");
						System.out.println("Changes updated!\n");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						break;
					case 2:
						System.out.println("Enter new cast members");
						System.out.println("------------------------------------------");
						dummy = sc.nextLine();
						value = sc.nextLine();
						TableProcessor.Update(serialno, 1, 4, value, "MovieListingTable.txt");
						System.out.println("Changes updated!\n");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						break;
					case 3:
						while (true) {
							try {
								System.out.println("/nChoose new rating");
								System.out.println("------------------------------------------");
								System.out.println("1: G");
								System.out.println("2: PG13");
								System.out.println("3: NC16");
								System.out.println("4: M18");
								System.out.println("5: R21");
								System.out.println("------------------------------------------");
								dummy = sc.nextLine();
								choice2 = sc.nextInt();
								switch (choice2) {
								case 1:
									TableProcessor.Update(serialno, 1, 5, "G", "MovieListingTable.txt");
									break;
								case 2:
									TableProcessor.Update(serialno, 1, 5, "PG13", "MovieListingTable.txt");
									break;
								case 3:
									TableProcessor.Update(serialno, 1, 5, "NC16", "MovieListingTable.txt");
									break;
								case 4:
									TableProcessor.Update(serialno, 1, 5, "M18", "MovieListingTable.txt");
									break;
								case 5:
									TableProcessor.Update(serialno, 1, 5, "R21", "MovieListingTable.txt");
									break;
								default:
									System.out.println("Invalid choice please enter again");
									TableProcessor.UpdateSerialNo("MovieListingTable.txt");
									break;
								}
								break;
							} catch (InputMismatchException ex) {
								System.out.println("This is an invalid input. Please try again.");
								continue;
							}
						}
						System.out.println("Changes updated!\n");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						break;
					case 4:
						do {
							try {
								System.out.println("Please select the genre\n");
								System.out.println("----------------------------------------------------------------");
								System.out.println("[1]  Action  [2]  Adventure [3]  Animation   [4]  Biography");
								System.out.println("[5]  Comedy  [6]  Crime     [7]  Documentary [8]  Drama");
								System.out.println("[9]  Family  [10] Fantasy   [11] Film_Noir   [12] History");
								System.out.println("[13] Horror  [14] Music     [15] Musical     [16] Mystery");
								System.out.println("[17] Romance [18] SciFi     [19] Sports      [20] Thriller");
								System.out.println("             [21] War       [22] Western");
								System.out.println("----------------------------------------------------------------");
								System.out.println("Select your choice. Enter -1 to finish adding genre");
								userchoice = sc.nextInt();
								switch (userchoice) {
								case 1:
									genre += "," + Genre.Action;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 2:
									genre += "," + Genre.Adventure;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 3:
									genre += "," + Genre.Animation;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 4:
									genre += "," + Genre.Biography;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 5:
									genre += "," + Genre.Comedy;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 6:
									genre += "," + Genre.Crime;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 7:
									genre += "," + Genre.Documentary;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 8:
									genre += "," + Genre.Drama;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 9:
									genre += "," + Genre.Family;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 10:
									genre += "," + Genre.Fantasy;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 11:
									genre += "," + Genre.Film_Noir;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 12:
									genre += "," + Genre.History;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 13:
									genre += "," + Genre.Horror;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 14:
									genre += "," + Genre.Music;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 15:
									genre += "," + Genre.Musical;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 16:
									genre += "," + Genre.Mystery;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 17:
									genre += "," + Genre.Romance;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 18:
									genre += "," + Genre.SciFi;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 19:
									genre += "," + Genre.Sports;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 20:
									genre += "," + Genre.Thriller;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 21:
									genre += "," + Genre.War;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case 22:
									genre += "," + Genre.Western;
									genrecount = 1;
									System.out.println("Added!");
									break;
								case -1:
									if (genrecount == 0) {
										System.out.println("You have not selected a single genre");
										break;
									} else {
										tempCheck = false;
										break;
									}
								default:
									System.out.println("That is an invalid choice.Please enter again");
									break;
								}
							} catch (InputMismatchException e) {
								System.out.println("That is an invalid input. Please enter again");
								dummy = sc.nextLine();
								continue;
							}

						} while (tempCheck);
						genre = genre.substring(1);
						TableProcessor.Update(serialno, 1, 6, genre, "MovieListingTable.txt");
						System.out.println("Changes updated!\n");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						break;
					case 5:
						while (true) {
							try {
								System.out.println("\nChoose new moviestatus");
								System.out.println("------------------------------------------");
								System.out.println("1: ComingSoon");
								System.out.println("2: Preview");
								System.out.println("3: NowShowing");
								System.out.println("4: End of Showing");
								System.out.println("------------------------------------------");
								dummy = sc.nextLine();
								choice2 = sc.nextInt();
								// error handling for invalid characters
								switch (choice2) {
								case 1:
									TableProcessor.Update(serialno, 1, 7, "ComingSoon", "MovieListingTable.txt");
									break;
								case 2:
									TableProcessor.Update(serialno, 1, 7, "Preview", "MovieListingTable.txt");
									break;
								case 3:
									TableProcessor.Update(serialno, 1, 7, "NowShowing", "MovieListingTable.txt");
									break;
								case 4:
									System.out.println("Updating the status to 'End of Showing' will delete its showtimes. Proceed? (Y / N)");
									dummy = sc.nextLine();
									value = sc.nextLine();
									if (value.equalsIgnoreCase("Y")) {
										TableProcessor.Update(serialno, 1, 7, "End of Showing", "MovieListingTable.txt");
										movietitle = TableProcessor.Find(serialno, 1, "MovieListingTable.txt", 2);
										TableProcessor.Delete(movietitle, 7, "MovieScheduleTable.txt");								
										TableProcessor.SortMS();
									} else if (value.equalsIgnoreCase("N")) {
										break;
									}
									break;
								default:
									System.out.println("That is an invalid choice.Please enter again");
									continue;
								}
								break;
							} catch (InputMismatchException e) {
								System.out.println("That is an invalid input. Please enter again");
								continue;
							}
						}
						System.out.println("Changes updated!\n");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						break;
					case 6:
						System.out.println("Enter new synopsis");
						System.out.println("------------------------------------------");
						dummy = sc.nextLine();
						value = sc.nextLine();
						TableProcessor.Update(serialno, 1, 8, value, "MovieListingTable.txt");
						System.out.println("Changes updated!\n");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						break;
					case 7:
						while (true) {
							try {
								System.out.println("/nChoose new movie type");
								System.out.println("------------------------------------------");
								System.out.println("1: _3D");
								System.out.println("2: NORMAL");
								System.out.println("------------------------------------------");
								dummy = sc.nextLine();
								choice2 = sc.nextInt();
								// invalid char error handling
								switch (choice2) {
								case 1:
									TableProcessor.Update(serialno, 1, 9, "_3D", "MovieListingTable.txt");
									break;
								case 2:
									TableProcessor.Update(serialno, 1, 9, "NORMAL", "MovieListingTable.txt");
									break;
								default:
									System.out.println("That is an invalid choice.Please enter again");
									continue;
								}
								break;
							} catch (InputMismatchException e) {
								System.out.println("That is an invalid input. Please enter again.");
								continue;
							}
						}
						System.out.println("Changes updated!\n");
						TableProcessor.PrintMLRecord(serialno, "MovieListingTable.txt");
						TableProcessor.UpdateSerialNo("MovieListingTable.txt");
						break;
					default:
						System.out.println("That is an invalid choice. Please enter again");
						continue;
					}
					break;
				} catch (InputMismatchException ex) {
					System.out.println("This is an invalid input. Please try again.");
					dummy = sc.nextLine();
					continue;
				}
			}
		} else
			System.out.println("There are no movies added to be updated");
		// working method errors all handled
	}

	public void RemoveMovie() throws IOException {

		Scanner sc = new Scanner(System.in);
		int userchoice;
		String flushdummy;
		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			if (!TableProcessor.IsEmpty("MovieListingTable.txt")) {
				while (true) {
					try {
						System.out.println("\nPlease select the movie you want to remove");
						System.out.println("------------------------------------------");
						TableProcessor.PrintList(2, "MovieListingTable.txt");
						System.out.println("------------------------------------------");
						userchoice = sc.nextInt();
						if (userchoice <= TableProcessor.NoOfRecords("MovieListingTable.txt"))
							break;
						else {
							System.out.println("That is an invalid choice. Please enter again.");
							flushdummy = sc.nextLine();
							continue;
						}
					} catch (InputMismatchException e) {
						System.out.println("That is an invalid input.Please enter again.");
						flushdummy = sc.nextLine();
						continue;
					}
				}
				TableProcessor.Delete(Integer.toString(userchoice), 1, "MovieListingTable.txt");
				System.out.println("Movie Succesffully deleted!\n");
				TableProcessor.UpdateSerialNo("MovieListingTable.txt");
				System.out.println("New List of movies");
				System.out.println("------------------------------------------");
				TableProcessor.PrintList(2, "MovieListingTable.txt");
				System.out.println("------------------------------------------");
			} else
				System.out.println("There are no movies to be deleted");
		}
		// working method errors handled

	}

	public void CreateShowtimes() throws IOException, ParseException {

		Date today = new Date();
		CalendarDate cd = new CalendarDate();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

		int userchoice;
		int serialno;

		boolean earlier = true;

		Scanner sc = new Scanner(System.in);

		String Status;
		String userinput = null;
		String record;
		String flushdummy;
		String date1 = null;
		String Cineplex;
		String CineplexID;
		String CinemaID;
		String TypeOfCinema;

		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			if (TableProcessor.IsEmpty("MovieListingTable.txt"))
				System.out.println("There are currently no movies to be assigned a schedule to\n");
			else {
				MovieSchedule MS = new MovieSchedule();
				while (true) {
					try {
						System.out.println("\nPlease select the movie to create schedules\n");
						System.out.println("------------------------------------------");
						TableProcessor.PrintList(2, "MovieListingTable.txt");
						System.out.println("------------------------------------------");
						serialno = sc.nextInt();
						if (serialno <= TableProcessor.NoOfRecords("MovieListingTable.txt")) {
							record = TableProcessor.Find(serialno, 1, "MovieListingTable.txt", 2);
							break;
						} else {
							System.out.println("That is an invalid choice. Please try again.");
							flushdummy = sc.nextLine();
							continue;
						}
					} catch (InputMismatchException e) {
						System.out.println("This is an invalid input. Please try again.");
						flushdummy = sc.nextLine();
						continue;
					}
				}
				Status = TableProcessor.Find(serialno, 1, "MovieListingTable.txt", 7);
				flushdummy = sc.nextLine();
				if (Status.equalsIgnoreCase("NowShowing") || Status.equalsIgnoreCase("Preview")) {
					while (true) {
						try {
							System.out.println("\nPlease select the cinema to add the schedule");
							System.out.println("------------------------------------------");
							TableProcessor.printCineplex();
							System.out.println("------------------------------------------");
							userchoice = sc.nextInt();
							if (userchoice <= TableProcessor.NoOfRecords("CineplexTable.txt")) {
								Cineplex = TableProcessor.Find(userchoice, 1, "CineplexTable.txt", 3);
								CineplexID = TableProcessor.Find(userchoice, 1, "CineplexTable.txt", 2);
								CinemaID = TableProcessor.Find(userchoice, 1, "CineplexTable.txt", 4);
								TypeOfCinema = TableProcessor.Find(userchoice, 1, "CineplexTable.txt", 5);
								break;
							} else {
								System.out.println("That is an invalid choice. Please enter again.");
								flushdummy = sc.nextLine();
								continue;
							}

						} catch (InputMismatchException e) {
							System.out.println("That is an invalid input. Please enter again.");
							continue;
						}
					}
					flushdummy = sc.nextLine();
					while (earlier) {
						System.out.println("\nPlease enter the movie date in dd/mm/yy format");
						System.out.println("------------------------------------------");
						date1 = sc.nextLine();
						Date date2 = format.parse(date1);
						if (today.after(date2)) {
							System.out.println("The date you entered is in the past. Please re-enter.");
						} else if (!cd.isValidDate(date1)) {
							System.out.println("Such a date doesnt exist.Please re-enter");
						} else
							earlier = false;
					}
					MS.setDate(date1);
					userchoice = cd.getDayofWeek(date1);
					switch (userchoice) {
					case 1:
						MS.setDay("SUN");
						break;
					case 2:
						MS.setDay("MON");
						break;
					case 3:
						MS.setDay("TUE");
						break;
					case 4:
						MS.setDay("WED");
						break;
					case 5:
						MS.setDay("THURS");
						break;
					case 6:
						MS.setDay("FRI");
						break;
					case 7:
						MS.setDay("SAT");
						break;
					}
					boolean tempCheck = true;
					do {
						try
						{
							System.out.println("Please enter the timing in HH:MM [24hr format]");
							System.out.println("------------------------------------------");
							userinput = sc.nextLine();
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
							Date nDate = sdf.parse(userinput);
							long msTime = nDate.getTime();
							if (msTime > 59400000 || msTime < 0) {
								System.out.println("This is not a valid 24 hour format");
								tempCheck = true;
							}
							else
							{
								MS.setTime(userinput);

								record = MS.ConvertToRecord() + "|" + Cineplex + "|" + CineplexID + "|" + CinemaID + "|"
										+ TypeOfCinema + "|" + record;
								TableProcessor.Insert(record, "MovieScheduleTable.txt");
								TableProcessor.SortMS();
								System.out.println("Success!\n");
								System.out.println("------------------------------------------");
								TableProcessor.printMS();
								System.out.println("------------------------------------------");
								tempCheck=false;
							}
						}
						catch(Exception e)
						{
							sc.nextLine();
							tempCheck=true;
						}

					} while (tempCheck);
					
				} else {
					System.out.println(
							"The Movie status is not set to NowShowing. Please update it to 'Preview' or 'Now Showing' first.\n");
				}
			}
		}
	}

	public void UpdateShowtimes() throws IOException {

		int userchoice;
		String update;
		String flushdummy;
		Scanner sc = new Scanner(System.in);

		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			if (TableProcessor.IsEmpty("MovieScheduleTable.txt"))
				System.out.println("There are no schedules to be updated");
			else {
				while (true) {
					try {
						System.out.println("Please select the show time you want to update indicated in [ ]\n");
						TableProcessor.printMS();
						userchoice = sc.nextInt();
						if (userchoice <= TableProcessor.NoOfRecords("MovieScheduleTable.txt"))
							break;
						else {
							System.out.println("That is an invalid choice. Please enter again.");
							flushdummy = sc.nextLine();
							continue;
						}
					} catch (InputMismatchException e) {
						System.out.println("That is an invalid input. Please enter again.");
						flushdummy = sc.nextLine();
						continue;
					}
				}
				boolean tempCheck = true;
				do {
					try
					{
						System.out.println("Please enter the timing in HH:MM [24hr format]");
						System.out.println("------------------------------------------");
						flushdummy = sc.nextLine();
						update = sc.nextLine();
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						Date nDate = sdf.parse(update);
						long msTime = nDate.getTime();
						if (msTime > 59400000 || msTime < 0) {
							System.out.println("This is not a valid 24 hour format");
							tempCheck = true;
						}
						else
						{
							TableProcessor.Update(userchoice, 1, 4, update, "MovieScheduleTable.txt");
							System.out.println("Success!\n");
							TableProcessor.SortMS();
							System.out.println("------------------------------------------");
							TableProcessor.printMS();
							System.out.println("------------------------------------------");
							tempCheck=false;
						}
					}
					catch(Exception e)
					{
						sc.nextLine();
						tempCheck=true;
					}

				} while (tempCheck);
			}
			// errors all handled except checking if the date is earlier than
			// today or not
		}
	}

	public void RemoveShowtimes() throws IOException {

		int serialno;
		String flushdummy;

		Scanner sc = new Scanner(System.in);

		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			if (TableProcessor.IsEmpty("MovieScheduleTable.txt"))
				System.out.println("There are no schedules to be removed");
			else {
				while (true) {
					try {
						System.out.println("Please enter the showtime's serial number indicated in {}\n");
						TableProcessor.printMS();
						serialno = sc.nextInt();
						if (serialno <= TableProcessor.NoOfRecords("MovieScheduleTable.txt"))
							break;
						else {
							System.out.println("That is an invalid choice. Please enter agian.");
							flushdummy = sc.nextLine();
							continue;
						}

					} catch (InputMismatchException e) {
						System.out.println("That is an invalid input. Please enter agian.");
						flushdummy = sc.nextLine();
						continue;
					}
				}
				TableProcessor.Delete(Integer.toString(serialno), 1, "MovieScheduleTable.txt");
				System.out.println("Succesfully deleted!");
				TableProcessor.printMS();
			}
		}
	}

	public void CreatePH() throws IOException {

		String userinput;
		Scanner sc = new Scanner(System.in);

		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			System.out.println("Please enter the PH date in dd/mm/yy format");
			System.out.println("------------------------------------------");
			userinput = sc.nextLine();
			if (TableProcessor.IsEmpty("PublicHolidayTable.txt")) {
				PublicHolidays PH = new PublicHolidays();
				PH.setDate(userinput);
				System.out.println("Please enter the name of the holiday");
				System.out.println("------------------------------------------");
				userinput = sc.nextLine();
				PH.setName(userinput);
				userinput = PH.ConvertToRecord();
				TableProcessor.Insert(userinput, "PublicHolidayTable.txt");
			} else {
				if (TableProcessor.Search(userinput, 3, "PublicHolidayTable.txt")) {
					System.out.println("Date already assigned as public holiiday");
				} else {
					PublicHolidays PH = new PublicHolidays();
					PH.setDate(userinput);
					System.out.println("Please enter the name of the holiday");
					System.out.println("------------------------------------------");
					userinput = sc.nextLine();
					PH.setName(userinput);
					userinput = PH.ConvertToRecord();
					TableProcessor.Insert(userinput, "PublicHolidayTable.txt");
					System.out.println("Successfully added a public holiday.");
					TableProcessor.PrintPHList("PublicHolidayTable.txt");
				}
			}
			// errors handled
		}
	}

	public void RemovePH() throws IOException {

		int userchoice;
		String flushdummy;

		Scanner sc = new Scanner(System.in);

		if (!loggedin) {
			System.out.println("Please login first\n");
		} else {
			if (TableProcessor.IsEmpty("PublicHolidayTable.txt"))
				System.out.println("There are no public holidays to be removed\n");
			else {
				while (true) {
					try {
						System.out.println("Please choose which Public holiday you want to remove");
						TableProcessor.PrintPHList("PublicHolidayTable.txt");
						userchoice = sc.nextInt();
						if (userchoice <= TableProcessor.NoOfRecords("PublicHolidayTable.txt"))
							break;
						else {
							System.out.println("That is an invalid input. Please enter again.");
							flushdummy = sc.nextLine();
							continue;
						}

					} catch (InputMismatchException e) {
						System.out.println("That is an invalid input. Please enter again.");
						flushdummy = sc.nextLine();
						continue;
					}
				}
				TableProcessor.Delete(Integer.toString(userchoice), 1, "PublicHolidayTable.txt");
				TableProcessor.UpdateSerialNo("PublicHolidayTable.txt");
				System.out.println("Success!\n");
				System.out.println("New Public Holidays\n");
				TableProcessor.PrintPHList("PublicHolidayTable.txt");
			}
		}
		// errors all handled
	}

	public void ManipulatePrice() throws IOException {

		TicketPrices tp;
		int k = 1;
		if (TableProcessor.IsEmpty("TicketPrices.txt")) {
			tp = new TicketPrices();
		} else {
			File inputFile = new File("TicketPrices.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String currentLine;
			String[] temp;
			currentLine = reader.readLine();
			temp = currentLine.split("\\|");
			tp = new TicketPrices(Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Double.parseDouble(temp[3]),
					Double.parseDouble(temp[4]), Double.parseDouble(temp[5]), Double.parseDouble(temp[6]),
					Double.parseDouble(temp[7]), Double.parseDouble(temp[8]));
			reader.close();
		}

		while (k == 1) {

			tp.displayTicket_price();

			Scanner sc = new Scanner(System.in);
			int userInput;

			System.out.println("Select ticket price to be changed");

			userInput = sc.nextInt();
			double changeTicketPrice;
			switch (userInput) {
			case 1:
				System.out.println("Enter New Student Price");
				changeTicketPrice = sc.nextDouble();
				tp.setStudent_price(changeTicketPrice);
				break;
			case 2:
				System.out.println("Enter New Senior citizen Price");
				changeTicketPrice = sc.nextDouble();
				tp.setSenior_citizen_price(changeTicketPrice);
				break;
			case 3:
				System.out.println("Enter New Normal Weekday Price");
				changeTicketPrice = sc.nextDouble();
				tp.setNormal_Weekday_price(changeTicketPrice);
				break;
			case 4:
				System.out.println("Enter New Weekend Price");
				changeTicketPrice = sc.nextDouble();
				tp.setWeekend_price(changeTicketPrice);
				break;
			case 5:
				System.out.println("Enter New Platinum Movie Suite Weekday price");
				changeTicketPrice = sc.nextDouble();
				tp.setPms_weekday_price(changeTicketPrice);
				break;
			case 6:
				System.out.println("Enter New Platinum Movie Suite Weekend price");
				changeTicketPrice = sc.nextDouble();
				tp.setPms_weekend_price(changeTicketPrice);
				break;
			case 7:
				System.out.println("Enter New Student 3D Price");
				changeTicketPrice = sc.nextDouble();
				tp.setthreeD_stud(changeTicketPrice);
				break;
			case 8:
				System.out.println("Enter New Normal 3D ticket Price");
				changeTicketPrice = sc.nextDouble();
				tp.setthreeD(changeTicketPrice);
				break;

			case 9:
				k = 0;
				if (!TableProcessor.IsEmpty("TicketPrices.txt")) {
					TableProcessor.Delete(1, 1, "TicketPrices.txt");
				}
				TableProcessor.Insert(tp.ConvertToRecord(), "TicketPrices.txt");
				break;
			default:
				break;
			}
		}
	}
}

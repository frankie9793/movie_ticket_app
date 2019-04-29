package assignment;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieGoer extends User {

	public MovieGoer() {
	}

	public void ListMovie() throws IOException {

		if (!TableProcessor.IsEmpty("MovieListingTable.txt")) {
			System.out.println("MOVIE CODE	MOVIE TITLE");
			System.out.println("===========================");
			TableProcessor.PrintList(2, "MovieListingTable.txt");
		} else
			System.out.println("There are currently no movies available for viewing");
	}

	public void ViewMovieDetails() throws IOException {
		int choice = 0, check = 0;

		boolean tempCheck = true;
		Scanner sc = new Scanner(System.in);
		if (!TableProcessor.IsEmpty("Searching.txt")) {
			do {
				do {
					try {
						System.out.println("Please enter Movie code to view Movie details");
						choice = sc.nextInt();
						check = choice;
						tempCheck = false;
					} catch (Exception e) {

						System.out.println("Please enter movie code!");
						System.out.println("");
						sc.nextLine();
						tempCheck = true;
					}
				} while (tempCheck);
			} while (TableProcessor.PrintMLRecord(choice, "Searching.txt") == 0);
		} else {
			do {
				do {
					try {
						System.out.println("Please enter Movie code to view Movie details");
						choice = sc.nextInt();
						check = choice;
						tempCheck = false;
					} catch (Exception e) {

						System.out.println("Please enter number movie code");
						sc.nextLine();
						tempCheck = true;
					}
				} while (tempCheck);
			} while (TableProcessor.PrintMLRecord(choice, "MovieListingTable.txt") == 0);
		}
		int d=0;
		while(!TableProcessor.IsEmpty("Searching.txt")){
			TableProcessor.Delete(Integer.toString(d), 1, "Searching.txt");
			d++;
		}
		String ufeedback;
		String currentLine;
		File inputFile = new File("MovieListingTable.txt");
		String[] temp = null;
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (Integer.parseInt(temp[0]) == choice)
				break;
		}
		System.out.println("\nDo you wish to see this movie's reviews. Y/N");
		sc.nextLine();
		ufeedback = sc.nextLine();
		if (ufeedback.equalsIgnoreCase("y")) {
			TableProcessor.PrintReviews(temp[1]);
		}
		System.out.println("\nDo you wish to leave a review for this movie? Y/N");
		ufeedback = sc.nextLine();
		if (ufeedback.equalsIgnoreCase("y")) {
			leaveReview(temp[1]);
		}
		reader.close();
	}

	public void SearchMovie() throws IOException {

		File inputFile = new File("MovieListingTable.txt");
		File outputFile = new File("Searching.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

		String currentLine;
		String recorda;
		String[] temp = null;
		String searchstring;
		int noOfresults = 0;
		int j = 0;
		int noofrecords = TableProcessor.NoOfRecords("MovieListingTable.txt");
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
		}
		String[][] twoDary = new String[noofrecords][temp.length];

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the keywords to be searched");
		searchstring = sc.nextLine();
		System.out.println("MOVIE CODE    MOVIE TITLE");
		System.out.println("===========================");

		while ((currentLine = reader1.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[1].toLowerCase().contains(searchstring.toLowerCase())) {
				System.out.println("   " + "[" + (temp[0]) + "]" + "   " + temp[1]);
				for (int i = 0; i < (temp.length); i++)
					twoDary[j][i] = temp[i];
				j++;
				noOfresults++;
			}
		}
		if (noOfresults == 0) {
			System.out.println("No matching keywords found");
		} else {
			for (int a = 0; a < (noOfresults); a++) {
				recorda = (twoDary[a][0] + "|");
				for (int b = 1; b < (temp.length); b++) {
					recorda += (twoDary[a][b] + "|");
				}
				writer.write(recorda + System.getProperty("line.separator"));
			}
		}

		writer.close();
		reader.close();
		reader1.close();

	}

	public void leaveReview(String movieName) throws IOException {

		String UserReview;
		String record;
		String Uname;
		boolean tempCheck = true;
		double UserRating = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Whats your name");
		Uname = sc.nextLine();
		System.out.println("Write your reviews and press enter when you are done");
		UserReview = sc.nextLine();
		System.out.println("Give your rating from 1-5 ");

		do {
			try {
				UserRating = sc.nextDouble();
				if (UserRating <= 5 && UserRating >= 1)
					tempCheck = false;
				else {
					System.out.println("Please enter number between 1 to 5");
					System.out.println("");
					tempCheck = true;
				}
			} catch (Exception e) {
				System.out.println("Please enter number between 1 to 5");
				System.out.println("");
				sc.nextLine();
				tempCheck = true;
			}
		} while (tempCheck);
		record = ConvertToRecord(movieName, Uname, UserReview, UserRating);
		TableProcessor.Insert(record, "Reviews.txt");

	}

	public void seatbook() throws IOException, ParseException {

		File inputFile = new File("MovieScheduleTable.txt");
		File outputFile = new File("TransactionLogTable.txt");
		File tempo = new File("tempo.txt");

		BufferedWriter writer = new BufferedWriter(new FileWriter(tempo));
		BufferedReader Trareader = new BufferedReader(new FileReader(outputFile));
		BufferedReader Msreader = new BufferedReader(new FileReader(inputFile));

		int noofrecords = TableProcessor.NoOfRecords("MovieScheduleTable.txt");
		int noofTrans = TableProcessor.NoOfRecords("TransactionLogTable.txt");
		int j = 0, k = 0, f = 0;
		int seatcount=0;

		int userInput = 0;
		Scanner sc = new Scanner(System.in);
		String ffstring;

		String currentLine;
		String tracurrentLine;
		String tracurrentLine1;
		String[] temp;
		String[] traTemp;
		String[][] twoDary = new String[noofrecords][9];
		while ((tracurrentLine = Trareader.readLine()) != null) {
			writer.write(tracurrentLine + System.getProperty("line.separator"));
		}

		while ((currentLine = Msreader.readLine()) != null) {

			temp = currentLine.split("\\|");
			for (int i = 0; i < 9; i++)
				twoDary[j][i] = temp[i];
			j++;
		}

		int r = 1, count = 0;
		int tempAry[] = new int[50];
		boolean tempCheck = true;

		do {
			try {
				System.out.println("Please select a timeslot to view seat availability ");
				userInput = sc.nextInt();
				if (userInput >= 0 && userInput <= noofrecords) {
					tempCheck = false;
				} else {
					sc.nextLine();
					tempCheck = true;
				}
			} catch (Exception e) {
				sc.nextLine();
				tempCheck = true;
			}
		} while (tempCheck);

		TableProcessor.getMovieTimeSlot(userInput);
		ffstring = sc.nextLine();
		int seatCount=0;
		do {
			String bookseat = "";
			String uQuit = " ";
			seatCount=0;
			do {
				System.out.println("Please select seats and type \"-1\" when you are finish");
				//
				uQuit = sc.nextLine();
				if (uQuit.equalsIgnoreCase("-1") && bookseat.equalsIgnoreCase("")) {
					r = 0;
					break;
				}
				else if(uQuit.equalsIgnoreCase("-1")){
					bookseat = bookseat.substring(0, bookseat.length() - 1);
					r = 0;
					break;
				} else if (uQuit.length() == 2) {
					if (Character.isAlphabetic(uQuit.charAt(0)) && Character.isDigit(uQuit.charAt(1))) {
						seatCount++;
						bookseat += uQuit + ",";

					} else {
						System.out.println("Please enter a valid seat number");
					}
				} else {
					System.out.println("Please enter a valid seat number");
				}

			} while (!uQuit.equalsIgnoreCase("-1"));
			for (; k < twoDary.length; k++) {
				if (userInput == Integer.parseInt(twoDary[k][0])) {
					break;
				}
			}

			StringTokenizer token = new StringTokenizer(bookseat, ",");

			int z = 1;
			while (token.hasMoreTokens() && z == 1) {
				// System.out.println(token.nextToken());
				String seat = token.nextToken();
				int ss;
				int seatNum;

				seatNum = Integer.parseInt(Character.toString(seat.charAt(1)));
				if (twoDary[k][7].equalsIgnoreCase("platinumsuite")) {

					if (seatNum >= 1 && seatNum <= 4) {

						if (Character.toString(seat.charAt(0)).equalsIgnoreCase("a")) {
							count++;
							tempAry[count - 1] = 0 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("b")) {
							count++;
							tempAry[count - 1] = 4 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("c")) {
							count++;
							tempAry[count - 1] = 8 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("d")) {
							count++;
							tempAry[count - 1] = 12 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("e")) {
							count++;
							tempAry[count - 1] = 16 + (seatNum - 1);
						} else {
							System.out.println("Please enter a valid seats number");
							z = 0;
							count = 0;
						}
					} else {
						System.out.println("Please enter a valid seats number");
						z = 0;
						count = 0;
					}
				} else if (twoDary[k][7].equalsIgnoreCase("normal")) {
					if (seatNum >= 1 && seatNum <= 10) {

						if (Character.toString(seat.charAt(0)).equalsIgnoreCase("a")) {
							count++;
							tempAry[count - 1] = 0 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("b")) {
							count++;
							tempAry[count - 1] = 10 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("c")) {
							count++;
							tempAry[count - 1] = 20 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("d")) {
							count++;
							tempAry[count - 1] = 30 + (seatNum - 1);
						} else if (Character.toString(seat.charAt(0)).equalsIgnoreCase("e")) {
							count++;
							tempAry[count - 1] = 40 + (seatNum - 1);
						} else {
							System.out.println("Please enter a valid seats number");
							z = 0;
							count = 0;
						}
					} else {
						System.out.println("Please enter a valid seats number");
						z = 0;
						count = 0;
					}
				}
			}

			for (int o = 0; o < count; o++) {
				for (int p = 0; p < noofTrans; p++) {
					if (TableProcessor.Search(Integer.toString(tempAry[o]), 11, "TransactionLogTable.txt")) {

						if (TableProcessor.Search((twoDary[p][3]), 10, "TransactionLogTable.txt")
								&& TableProcessor.Search((twoDary[p][1]), 9, "TransactionLogTable.txt")
								&& TableProcessor.Search((twoDary[p][8]), 8, "TransactionLogTable.txt")
								&& TableProcessor.Search((twoDary[p][6]), 7, "TransactionLogTable.txt")
								&& TableProcessor.Search((twoDary[p][5]), 6, "TransactionLogTable.txt")) {
							System.out.println(
									"The Seat that you had selected is already booked, Please select other seats");
							r = 1;
							count = 0;

							break;
						}
					}
				}
			}
		} while (r == 1);
		if(seatCount!=0){
		System.out.println("your selected seat is ");
		for (int t = 0; t < count; t++) {
			// writer.write(st + System.getProperty("line.separator"));
			if (t == (count - 1) && count >= 2)
				System.out.println(toSeatAlpha(twoDary[k][7], (tempAry[t])));
			else
				System.out.print(toSeatAlpha(twoDary[k][7], (tempAry[t])) + " ");
		}
		String confirmSeat;
		String insertintofile;
		String uInput;
		String timeinMS;
		boolean sUser = false;
		boolean scUser = false;
		System.out.println("Are you a Senior Citizen? Y/N");
		uInput = sc.nextLine();
		if (uInput.equalsIgnoreCase("y"))
			scUser = true;
		else {
			System.out.println("Are you a Student? Y/N");
			uInput = sc.nextLine();
			if (uInput.equalsIgnoreCase("y"))
				sUser = true;
		}
		System.out.println("\nTotal Number of Ticket " + (count));
		File tpinputFile = new File("TicketPrices.txt");
		File mlinputFile = new File("MovieListingTable.txt");
		BufferedReader tpreader = new BufferedReader(new FileReader(tpinputFile));
		BufferedReader mlreader = new BufferedReader(new FileReader(mlinputFile));

		String tpcurrentLine;
		String mlcurrentLine;
		String[] mlTemp = null;
		String[] tpTemp;
		while ((mlcurrentLine = mlreader.readLine()) != null) {

			mlTemp = mlcurrentLine.split("\\|");
			if (twoDary[k][8].equalsIgnoreCase(mlTemp[1]))
				break;

		}
		tpcurrentLine = tpreader.readLine();
		tpTemp = tpcurrentLine.split("\\|");
		TicketPrices tp = new TicketPrices(Double.parseDouble(tpTemp[1]), Double.parseDouble(tpTemp[2]),
				Double.parseDouble(tpTemp[3]), Double.parseDouble(tpTemp[4]), Double.parseDouble(tpTemp[5]),
				Double.parseDouble(tpTemp[6]), Double.parseDouble(tpTemp[7]), Double.parseDouble(tpTemp[8]));
		int iDayOfWeek = 0;
		if (twoDary[k][2].equalsIgnoreCase("mon"))
			iDayOfWeek = 1;
		else if (twoDary[k][2].equalsIgnoreCase("tue"))
			iDayOfWeek = 2;
		else if (twoDary[k][2].equalsIgnoreCase("wed"))
			iDayOfWeek = 3;
		else if (twoDary[k][2].equalsIgnoreCase("thurs"))
			iDayOfWeek = 4;
		else if (twoDary[k][2].equalsIgnoreCase("fri"))
			iDayOfWeek = 5;
		else if (twoDary[k][2].equalsIgnoreCase("sat"))
			iDayOfWeek = 6;
		else if (twoDary[k][2].equalsIgnoreCase("sun"))
			iDayOfWeek = 7;
		int movie_type = 0;
		if (twoDary[k][7].equalsIgnoreCase("platinumsuite")) {
			movie_type = 2;
		} else if (mlTemp[8].equalsIgnoreCase("normal")) {
			movie_type = 0;
		} else if (mlTemp[8].equalsIgnoreCase("_3D")) {
			movie_type = 1;
		}
		PublicHolidays ph = new PublicHolidays();
		boolean publicHoliday = ph.isHoliday(twoDary[k][1]);

		timeinMS = twoDary[k][3];
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date nDate = sdf.parse(timeinMS);
		long msTime = nDate.getTime();

		System.out.println("Total Price = "
				+ tp.CalculateTicketPrice(iDayOfWeek, msTime, movie_type, count, sUser, scUser, publicHoliday));
		System.out.println("Confirm Seat with Y/N");
		confirmSeat = sc.nextLine();
		int serialNo = TableProcessor.NoOfRecords("TransactionLogTable.txt") + 1;
		String Uname;
		String Uemail;
		int Uphone;
		if (confirmSeat.equalsIgnoreCase("y")) {
			System.out.println("Please enter your Name");
			Uname = sc.nextLine();
			System.out.println("Please enter your Phone Number");
			Uphone = sc.nextInt();
			System.out.println("Please enter your Email");
			ffstring = sc.nextLine();
			Uemail = sc.nextLine();
			TransactionLog tl = new TransactionLog(Uname, Uphone, Uemail, Integer.parseInt(twoDary[k][6]));
			for (int t = 0; t < count; t++) {
				insertintofile = (serialNo + t) + "|" + tl.getTId() + "|" + Uname + "|" + Uphone + "|" + Uemail + "|"
						+ twoDary[k][5] + "|" + twoDary[k][6] + "|" + twoDary[k][8] + "|" + twoDary[k][1] + "|"
						+ twoDary[k][3] + "|" + tempAry[t];
				writer.write(insertintofile + System.getProperty("line.separator"));
			}

		}
	
		mlreader.close();
		tpreader.close();
		Msreader.close();
		Trareader.close();
		writer.close();
		outputFile.delete();
		tempo.renameTo(outputFile);
		}
	}

	public static String toSeatAlpha(String cineType, int num) {
		if (cineType.equalsIgnoreCase("normal"))
			if (num >= 0 && num < 10)
				return "A" + (num + 1);
			else if (num >= 10 && num < 20)
				return "B" + ((num % 10) + 1);
			else if (num >= 20 && num < 30)
				return "C" + ((num % 10) + 1);
			else if (num >= 30 && num < 40)
				return "D" + ((num % 10) + 1);
			else
				return "E" + ((num % 10) + 1);
		else if (num >= 0 && num < 4)
			return "A" + (num + 1);
		else if (num >= 4 && num < 8)
			return "B" + ((num % 4) + 1);
		else if (num >= 8 && num < 12)
			return "C" + ((num % 4) + 1);
		else if (num >= 12 && num < 16)
			return "D" + ((num % 4) + 1);
		else
			return "E" + ((num % 4) + 1);
	}

	public void ViewPastBooking(String input) throws IOException {
		File inputFile = new File("TransactionLogTable.txt");
		File cineInputFile = new File("CineplexTable.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedReader cineReader = new BufferedReader(new FileReader(cineInputFile));
		String cineCurrentLine;
		String currentLine;
		String temp[];
		String cineTemp[];
		int noofrecord = TableProcessor.NoOfRecords("TransactionLogTable.txt");
		int cinenoofreocrd = TableProcessor.NoOfRecords("CineplexTable.txt");
		int j = 0, u = 0;
		String cineTwoDary[][] = new String[cinenoofreocrd][5];
		String twoDary[][] = new String[noofrecord][11];
		while ((cineCurrentLine = cineReader.readLine()) != null) {
			cineTemp = cineCurrentLine.split("\\|");
			for (int i = 0; i < 5; i++)
				cineTwoDary[u][i] = cineTemp[i];
			u++;
		}
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			for (int i = 0; i < 11; i++)
				twoDary[j][i] = temp[i];
			j++;
		}
		Arrays.sort(twoDary, new Comparator<String[]>() {

			@Override
			public int compare(String[] entry1, String[] entry2) {
				String time1 = entry1[1];
				String time2 = entry2[1];
				return time1.compareTo(time2);
			}
		});
		int h = 0, a = 0;
		for (; h < noofrecord; h++) {
			if (twoDary[h][2].equalsIgnoreCase(input) || twoDary[h][3].equalsIgnoreCase(input)
					|| twoDary[h][4].equalsIgnoreCase(input)) {
				a++;
				break;
			}

		}
		if (a == 0) {
			System.out.println("No records found");
		}
		else
		{
			System.out.print("Name : " + twoDary[h][2] + "\t\t");
			System.out.print("Phone : " + twoDary[h][3] + "\t");
			System.out.println("Email : " + twoDary[h][4] + "\n");
			for (int k = 0; k < (noofrecord); k++) {

				if (twoDary[k][2].equalsIgnoreCase(input) || twoDary[k][3].equalsIgnoreCase(input)
						|| twoDary[k][4].equalsIgnoreCase(input)) {
					// check current tid same as next tid and prievous
					if (k + 1 < noofrecord && k - 1 >= 0) {
						if (twoDary[k][1].equalsIgnoreCase(twoDary[k + 1][1])
								&& twoDary[k][1].equalsIgnoreCase(twoDary[k - 1][1])) {
							int z;
							for (z = 0; z < 5; z++) {
								twoDary[k][6].equalsIgnoreCase(cineTwoDary[z][3]);
								break;
							}

							System.out.print(toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])) + " ");
						}
						// check if current tid same as previous tid
						else if (twoDary[k][1].equalsIgnoreCase(twoDary[k - 1][1])) {
							int z;
							for (z = 0; z < 5; z++) {
								twoDary[k][6].equalsIgnoreCase(cineTwoDary[z][3]);
								break;
							}
							System.out.println(toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])));
						}
						// check if current tid same as next tid
						else if (twoDary[k][1].equalsIgnoreCase(twoDary[k + 1][1])) {
							int z;
							for (z = 0; z < 5; z++) {
								twoDary[k][6].equalsIgnoreCase(cineTwoDary[z][3]);
								break;
							}

							System.out.println("Transaction ID " + twoDary[k][1]);
							System.out.println("Movie " + twoDary[k][7]);
							System.out.println("Date " + twoDary[k][8]);
							System.out.println("Time " + twoDary[k][9]);
							System.out.print(
									"Seats " + toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])) + " ");
						} else {
							int z;
							for (z = 0; z < 5; z++) {
								twoDary[k][6].equalsIgnoreCase(cineTwoDary[z][3]);
								break;
							}
							System.out.println("Transaction ID " + twoDary[k][1]);
							System.out.println("Movie " + twoDary[k][7]);
							System.out.println("Date " + twoDary[k][8]);
							System.out.println("Time " + twoDary[k][9]);
							System.out.println(
									"Seats " + toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])));
						}
					} else {
						int z;
						for (z = 0; z < 5; z++) {
							twoDary[k][6].equalsIgnoreCase(cineTwoDary[z][3]);
							break;
						}
						if (k == 0 && twoDary[k][1].equalsIgnoreCase(twoDary[k + 1][1])) {
							System.out.println("Transaction ID " + twoDary[k][1]);
							System.out.println("Movie " + twoDary[k][7]);
							System.out.println("Date " + twoDary[k][8]);
							System.out.println("Time " + twoDary[k][9]);
							System.out.print(
									"Seats " + toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])) + " ");
						} else if (k == 0) {
							System.out.println("Transaction ID " + twoDary[k][1]);
							System.out.println("Movie " + twoDary[k][7]);
							System.out.println("Date " + twoDary[k][8]);
							System.out.println("Time " + twoDary[k][9]);
							System.out.println(
									"Seats " + toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])));
						} else {
							if (twoDary[k][1].equalsIgnoreCase(twoDary[k - 1][1])) {
								System.out.println(toSeatAlpha(cineTwoDary[z][4], Integer.parseInt(twoDary[k][10])));
							}
						}
					}
				}
			}
		}

		reader.close();
		cineReader.close();

	}

	public String ConvertToRecord(String movieName, String Rname, String Review, double Urating) throws IOException {

		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("Reviews.txt") + 1;

		record = serialno + "|" + movieName + "|" + Rname + "|" + Review + "|" + Urating;
		return record;
	}
}

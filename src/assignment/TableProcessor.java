package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TableProcessor {

	public static boolean Search(String st, int col, String table) throws IOException {

		File inputFile = new File(table);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;
		boolean found = false;
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[col - 1].equalsIgnoreCase(st)) {
				found = true;
				break;
			}
		}
		reader.close();
		return found;
	}

	public static String Find(int serialno, int col, String table, int col2) throws IOException {
		// finds a certain string from the column keyed in
		// takes in paramaters serial no == the number listed in the table at
		// left most, col is col 1, col2 is the destination of the string u want
		// to search
		File inputFile = new File(table);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;
		String found = "-999";
		String st = Integer.toString(serialno);
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[col - 1].equalsIgnoreCase(st)) {
				found = temp[col2 - 1];
				break;
			}
		}
		reader.close();
		return found;
	}

	public static void Insert(String record, String table) throws IOException {

		File inputFile = new File(table);
		File tempFile = new File("temp.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.write(record);
		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
	}

	public static void Delete(int serialno, int col, String table) throws IOException {

		File inputFile = new File(table);
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		String trimmedLine;
		String[] temp;
		String number = Integer.toString(serialno);

		while ((currentLine = reader.readLine()) != null) {
			trimmedLine = currentLine.trim();
			temp = trimmedLine.split("\\|");
			if (temp[col - 1].equalsIgnoreCase(number))
				continue;
			writer.write(currentLine + System.getProperty("line.separator"));
		}

		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
	}

	public static void Delete(String key, int col, String table) throws IOException {

		File inputFile = new File(table);
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		String trimmedLine;
		String[] temp;

		while ((currentLine = reader.readLine()) != null) {
			trimmedLine = currentLine.trim();
			temp = trimmedLine.split("\\|");
			if (temp[col - 1].equalsIgnoreCase(key))
				continue;
			writer.write(currentLine + System.getProperty("line.separator"));
		}

		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
	}

	public static void Update(int serialno, int col1, int col2, String value, String table) throws IOException {

		File inputFile = new File(table);
		File tempFile = new File("tempt.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		String st = "";
		String[] temp;
		String key = Integer.toString(serialno);

		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (null != currentLine && !temp[col1 - 1].equalsIgnoreCase(key)) {
				writer.write(currentLine + System.getProperty("line.separator"));
			} else {
				temp[col2 - 1] = value;
				for (int i = 0; i < temp.length; i++) {
					st += temp[i] + "|";
				}
				st = st.substring(0, st.length() - 1);
			}
		}
		writer.write(st + System.getProperty("line.separator"));
		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);

	}

	public static void PrintList(int col, String table) throws IOException {

		File inputFile = new File(table);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;
		int noOfelements = 0;
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			System.out.println("   " + "[" + (noOfelements + 1) + "]" + "		" + temp[col - 1]);
			noOfelements++;
		}
		reader.close();
	}

	public static int NoOfRecords(String table) throws IOException {

		File inputFile = new File(table);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		int noOfRecords = 0;
		String currentLine;
		while ((currentLine = reader.readLine()) != null) {
			noOfRecords++;
		}
		reader.close();
		return noOfRecords;
	}

	public static boolean IsEmpty(String table) throws IOException {

		File inputFile = new File(table);
		if (inputFile.length() == 0)
			return true;
		else
			return false;
	}

	public static void UpdateSerialNo(String table) throws IOException {

		File inputFile = new File(table);
		File tempFile = new File("tempt.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		String st = "";
		String[] temp;

		int serialno = 1;

		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			temp[0] = Integer.toString(serialno);
			for (int i = 0; i < temp.length; i++) {
				st += temp[i] + "|";
			}
			st = st.substring(0, st.length() - 1);
			writer.write(st + System.getProperty("line.separator"));
			serialno++;
			temp = null;
			st = "";
		}
		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
	}

	public static int PrintMLRecord(int serialno, String table) throws IOException {

		File inputFile = new File(table);
		File reInputFile = new File("Reviews.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedReader rReader = new BufferedReader(new FileReader(reInputFile));

		String number = Integer.toString(serialno);
		String currentLine;
		String reCurrentLine;
		String[] reTemp;
		int count = 0;
		String[] temp;
		

		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[0].equalsIgnoreCase(number)) {
				while ((reCurrentLine = rReader.readLine()) != null) {
					reTemp = reCurrentLine.split("\\|");
					if (reTemp[1].equalsIgnoreCase(temp[1])) {
						count++;
					}
				}
				System.out.println("MOVIE TITLE\t\t" + temp[1]);
				System.out.println("=======================================================================");
				System.out.println("[1] Director\t\t" + temp[2]);
				System.out.println("[2] Cast\t\t" + temp[3]);
				System.out.println("[3] Rating\t\t" + temp[4]);
				System.out.println("[4] Genre\t\t" + temp[5]);
				System.out.println("[5] Status\t\t" + temp[6]);
				System.out.println("[6] Synopsis\t\t" + temp[7]);
				System.out.println("[7] Type\t\t" + temp[8]);
				if(count >1)
					System.out.println("[8] Overall Rating\t" + Movie.OverrallRating(temp[1]));
				else
					System.out.println("[8] Overall Rating\tNA");
				reader.close();
				rReader.close();
				return 1;
			}
		}
		rReader.close();
		reader.close();
		return 0;
	}

	public static void PrintPHList(String table) throws IOException {

		File inputFile = new File(table);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;

		System.out.println("====================================");
		System.out.println("           Public Holidays      ");
		System.out.println("====================================");
		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
			System.out.printf("[" + temp[0] + "]" + ":" + " " + temp[1] + " - " + temp[2] + "\n");

		}
		reader.close();
	}

	public static void SortMS() throws IOException, ParseException {
		// works but find more efficient ways to sort
		File inputFile = new File("MovieScheduleTable.txt");
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		int noofrecords = TableProcessor.NoOfRecords("MovieScheduleTable.txt");
		int key[] = new int[] { 4, 8, 7, 1, 3 };
		int keycolumn;
		int j = 0;

		DateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		DateFormat sdf2 = new SimpleDateFormat("HH:mm");

		String currentLine;
		String record = "";
		String[] temp = null;
		String[][] twoDary = new String[noofrecords][9];
		String[][] temp2 = new String[noofrecords][9];

		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
			for (int i = 0; i < 9; i++)
				twoDary[j][i] = temp[i];
			j++;
		}

		keycolumn = key[0];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (twoDary[h - 1][keycolumn].compareToIgnoreCase(twoDary[h][keycolumn]) > 0) {
					for (int k = 0; k < 9; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}
		keycolumn = key[1];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (twoDary[h - 1][keycolumn].compareToIgnoreCase(twoDary[h][keycolumn]) > 0
						&& (twoDary[h - 1][4].equalsIgnoreCase(twoDary[h][4]))) {
					for (int k = 0; k < 9; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}
		keycolumn = key[2];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (twoDary[h - 1][keycolumn].compareToIgnoreCase(twoDary[h][keycolumn]) > 0
						&& (twoDary[h - 1][4].equalsIgnoreCase(twoDary[h][4]))
						&& (twoDary[h - 1][8].equalsIgnoreCase(twoDary[h][8]))) {
					for (int k = 0; k < 9; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}

		keycolumn = key[3];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (sdf.parse(twoDary[h - 1][keycolumn]).compareTo(sdf.parse(twoDary[h][keycolumn])) > 0
						&& (twoDary[h - 1][4].equalsIgnoreCase(twoDary[h][4]))
						&& (twoDary[h - 1][8].equalsIgnoreCase(twoDary[h][8]))
						&& (twoDary[h - 1][7].equalsIgnoreCase(twoDary[h][7]))) {
					for (int k = 0; k < 9; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}
		keycolumn = key[4];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (sdf2.parse(twoDary[h - 1][keycolumn]).compareTo(sdf2.parse(twoDary[h][keycolumn])) > 0
						&& (twoDary[h - 1][4].equalsIgnoreCase(twoDary[h][4]))
						&& (twoDary[h - 1][8].equalsIgnoreCase(twoDary[h][8]))
						&& (twoDary[h - 1][7].equalsIgnoreCase(twoDary[h][7]))
						&& (twoDary[h - 1][1].equalsIgnoreCase(twoDary[h][1]))) {
					for (int k = 0; k < 9; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}
		for (int i = 0; i < noofrecords; i++) {
			for (int p = 0; p < 9; p++) {
				record += twoDary[i][p] + "|";
			}
			record = record.substring(0, record.length() - 1);
			writer.write(record + System.getProperty("line.separator"));
			record = "";
		}

		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
		UpdateSerialNo("MovieScheduleTable.txt");

	}

	public static void printMS() throws IOException {

		File inputFile = new File("MovieScheduleTable.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		int noofrecords = TableProcessor.NoOfRecords("MovieScheduleTable.txt");
		int j = 0, k = 0, l = 1;

		String currentLine;
		String[] temp;
		String[][] twoDary = new String[noofrecords][9];

		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
			for (int i = 0; i < 9; i++)
				twoDary[j][i] = temp[i];
			j++;
		}
		int diffcineplexes = 0;

		for (int i = 1; i < noofrecords; i++) {
			if (!twoDary[i - 1][4].equalsIgnoreCase(twoDary[i][4])) {
				diffcineplexes++;
			}
		}

		for (int i = 0; i < diffcineplexes; i++) {
			System.out.println("");
			System.out.println("=================================");
			System.out.println(twoDary[l - 1][4]);// print cinplex
			System.out.println("=================================");
			System.out.println("---------------------------------");
			// print movie name
			if (twoDary[l - 1][7].equalsIgnoreCase("PlatinumSuite"))
				System.out.println(twoDary[l - 1][8] + " " + twoDary[l - 1][7]);
			else
				System.out.println(twoDary[l - 1][8]);
			System.out.println("---------------------------------");
			System.out.println(twoDary[l - 1][1] + " : [" + twoDary[l - 1][0] + "] " + twoDary[l - 1][3] + " ");// print
																												// movie
																												// date
																												// and
																												// time
			for (k = 0; k < noofrecords - 1; k++) {
				// same cineplex
				if (twoDary[l][4].equalsIgnoreCase(twoDary[l - 1][4])) {
					// same movie title
					if (twoDary[l][8].equalsIgnoreCase(twoDary[l - 1][8])) {
						// same cinemaType
						if (twoDary[l][7].equalsIgnoreCase(twoDary[l - 1][7])) {
							// same movie date
							if (twoDary[l][1].equalsIgnoreCase(twoDary[l - 1][1])
									&& twoDary[l][1].equalsIgnoreCase(twoDary[l + 1][1])) {
								System.out.print("[" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
								l++;
							} else if (twoDary[l][1].equalsIgnoreCase(twoDary[l - 1][1])) {
								System.out.print("[" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
								System.out.println("");
								l++;
							} else// different movie date
							{

								System.out.println(
										"\n" + twoDary[l][1] + " : [" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
								l++;
							}
						} else {
							System.out.println("");
							System.out.println("---------------------------------");
							// print movie name with platinumsuite
							if (twoDary[l][7].equalsIgnoreCase("PlatinumSuite"))
								System.out.println(twoDary[l][8] + " " + twoDary[l][7]);
							else
								System.out.println(twoDary[l][8]);
							if (twoDary[l][1].equalsIgnoreCase(twoDary[l + 1][1])) {
								System.out.println("---------------------------------");
								System.out.print(twoDary[l][1] + " : [" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
							} else {
								System.out.println("---------------------------------");
								System.out.println(twoDary[l][1] + " : [" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
							}

							l++;

						}
					} else {
						System.out.println("");
						System.out.println("---------------------------------");
						// print movie name
						if (twoDary[l][7].equalsIgnoreCase("PlatinumSuite"))
							System.out.println(twoDary[l][8] + " " + twoDary[l][7]);
						else
							System.out.println(twoDary[l][8]);
						System.out.println("---------------------------------");
						System.out.println(twoDary[l][1] + " : [" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
						l++;
					} // name

				} else {
					System.out.println("");
					System.out.println("=================================");
					System.out.println(twoDary[l][4]);
					System.out.println("=================================");
					System.out.println("---------------------------------");
					// print movie name
					if (twoDary[l][7].equalsIgnoreCase("PlatinumSuite"))
						System.out.println(twoDary[l][8] + " " + twoDary[l][7]);
					else
						System.out.println(twoDary[l][8]);
					System.out.println("---------------------------------");
					System.out.println(twoDary[l][1] + " : [" + twoDary[l][0] + "] " + twoDary[l][3] + " ");
					l++;
				}
			}
		}
		reader.close();
	}

	public static void getMovieTimeSlot(int serialno) throws IOException {

		File inputFile = new File("MovieScheduleTable.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		int noofrecords = NoOfRecords("MovieScheduleTable.txt");
		int j = 0, k = 0;

		String currentLine;
		String[] temp;
		String[][] twoDary = new String[noofrecords][9];

		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
			for (int i = 0; i < 9; i++)
				twoDary[j][i] = temp[i];
			j++;
		}
		for (; k < twoDary.length; k++) {
			if (serialno == Integer.parseInt(twoDary[k][0])) {
				break;
			}
		}
		if (twoDary[k][7].equalsIgnoreCase("PlatinumSuite")) {
			PlatinumSuiteCinema psc = new PlatinumSuiteCinema();
			psc.DisplaySeats(Integer.parseInt(twoDary[k][5]), twoDary[k][6], twoDary[k][1], twoDary[k][3],
					twoDary[k][8]);
		} else {
			NormalCinema nc = new NormalCinema();
			nc.DisplaySeats(Integer.parseInt(twoDary[k][5]), twoDary[k][6], twoDary[k][1], twoDary[k][3],
					twoDary[k][8]);
		}
		reader.close();

	}

	public static int CountSameMovie(String key, int col, String table) throws IOException {
		// to count how many of the same appears in the table, used for counting
		// ticket sales
		File inputFile = new File(table);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String trimmedLine;
		String[] temp;

		int counter = 0;

		while ((currentLine = reader.readLine()) != null) {
			trimmedLine = currentLine.trim();
			temp = trimmedLine.split("\\|");
			if (temp[col - 1].equalsIgnoreCase(key))
				counter++;

		}
		reader.close();
		return counter;
	}

	public static ArrayList<String> MovieTitles(String col,String table) throws IOException {
        // used in the listing of best selling movie titles by cinema staff
        File inputFile = new File(table);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        int noOfrecords = NoOfRecords(table);

        String currentLine;
        String trimmedLine;
        String[] temp;
        String[][] temp2 = new String[noOfrecords][1];
        int col1 = Integer.parseUnsignedInt(col);
        ArrayList<String> MovieTitles = new ArrayList<String>();

        int i = 0;
        int j = 0;

        while ((currentLine = reader.readLine()) != null) {
            trimmedLine = currentLine.trim();
            temp = trimmedLine.split("\\|");
            temp2[i][j] = temp[col1-1];
            i++;
        }
        Arrays.sort(temp2, new Comparator<String[]>() {
            @Override
            public int compare(String[] entry1, final String[] entry2) {

                String time1 = entry1[0];
                String time2 = entry2[0];
                return -time1.compareTo(time2);
            }
        });
        for (int k = 1; k < noOfrecords; k++) {
            if (k == 1) {
                MovieTitles.add(temp2[k-1][0]);
            }
            if(!temp2[k - 1][0].equalsIgnoreCase(temp2[k][0])){
                MovieTitles.add(temp2[k][0]);
            }
        }
        reader.close();
        return MovieTitles;

    }




	public static void PrintReviews(String movieName) throws IOException {
		File inputFile = new File("Reviews.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[1].compareToIgnoreCase(movieName) == 0) {
				System.out.println("");
				System.out.println(temp[2] + " : " + temp[4] + " / 5"); // Reviewer
																		// Name
																		// and
																		// rating
				System.out.println(temp[3]);// reviewer review

			}
		}
		reader.close();
	}

	public static void printCineplex() throws IOException {

		File inputFile = new File("CineplexTable.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		int noofrecords = NoOfRecords("CineplexTable.txt");
		int j = 0;
		int l = 1;
		int diffcineplexes = 0;

		String currentLine;
		String[] temp;
		String[][] twoDary = new String[noofrecords][5];

		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
			for (int i = 0; i < 5; i++)
				twoDary[j][i] = temp[i];
			j++;
		}
		for (int i = 1; i < noofrecords; i++) {
			if (!twoDary[i - 1][4].equalsIgnoreCase(twoDary[i][4])) {
				diffcineplexes++;
			}
		}

		System.out.println("");
		System.out.println("=================================");
		System.out.println(twoDary[l - 1][2] + "\tID:" + twoDary[l - 1][1]);// print
																			// cinplex
		System.out.println("=================================");
		System.out
				.println("[" + twoDary[l - 1][0] + "]" + "\tCinemaID:" + twoDary[l - 1][3] + "\t" + twoDary[l - 1][4]);
		for (int k = 1; k < noofrecords; k++) {
			if (twoDary[l][2].equalsIgnoreCase(twoDary[l - 1][2])) {
				System.out.println("[" + twoDary[l][0] + "]" + "\tCinemaID:" + twoDary[l][3] + "\t" + twoDary[l][4]);
				l++;
			} else {
				System.out.println("");
				System.out.println("=================================");
				System.out.println(twoDary[l][2] + "\tID:" + twoDary[l][1]);// print
																			// cinplex
				System.out.println("=================================");
				System.out.println("[" + twoDary[l][0] + "]" + "\tCinemaID:" + twoDary[l][3] + "\t" + twoDary[l][4]);
				l++;
			}
		}
		reader.close();
	}

	public static void sortCineplexTable() throws IOException {

		File inputFile = new File("CineplexTable.txt");
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		int noofrecords = TableProcessor.NoOfRecords("CineplexTable.txt");
		int key[] = new int[] { 2, 3 };
		int keycolumn;
		int j = 0;

		String currentLine;
		String record = "";
		String[] temp = null;
		String[][] twoDary = new String[noofrecords][5];
		String[][] temp2 = new String[noofrecords][5];

		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
			for (int i = 0; i < 5; i++)
				twoDary[j][i] = temp[i];
			j++;
		}

		keycolumn = key[0];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (twoDary[h - 1][keycolumn].compareToIgnoreCase(twoDary[h][keycolumn]) > 0) {
					for (int k = 0; k < 5; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}
		keycolumn = key[1];
		for (int i = 0; i < noofrecords; i++) {
			for (int h = 1; h < noofrecords - i; h++) {
				if (twoDary[h - 1][keycolumn].compareToIgnoreCase(twoDary[h][keycolumn]) > 0
						&& (twoDary[h - 1][2].equalsIgnoreCase(twoDary[h][2]))) {
					for (int k = 0; k < 5; k++) {
						temp2[i][k] = twoDary[h - 1][k];
						twoDary[h - 1][k] = twoDary[h][k];
						twoDary[h][k] = temp2[i][k];
					}
				}
			}
		}
		for (int i = 0; i < noofrecords; i++) {
			for (int p = 0; p < 5; p++) {
				record += twoDary[i][p] + "|";
			}
			record = record.substring(0, record.length() - 1);
			writer.write(record + System.getProperty("line.separator"));
			record = "";
		}

		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
		UpdateSerialNo("CineplexTable.txt");

	}

}

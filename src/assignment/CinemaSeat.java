package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CinemaSeat {

	private int CinemaSeatID;
	private boolean seatBooked;

	public CinemaSeat(int CinemaSeatID) {
		this.CinemaSeatID = CinemaSeatID;
		seatBooked = false;

	}

	public int getCinemaSeatID() {
		return CinemaSeatID;
	}

	public void setSeatBooked() {// take im parameter which is show time and
									// date

		seatBooked = true;
	}

	public boolean getSeatBooked() {
		return seatBooked;
	}

	public boolean isOccupied(String cinplexID, String cinemacode, String iDate, String itime, String movieTitle,
			int seatID) throws NumberFormatException, IOException {
		File inputFile = new File("TransactionLogTable.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[5].equalsIgnoreCase(cinplexID) && temp[6].equalsIgnoreCase(cinemacode)
					&& temp[8].equalsIgnoreCase(iDate) && temp[9].equalsIgnoreCase(itime)
					&& temp[7].equalsIgnoreCase(movieTitle) && Integer.parseInt(temp[10]) == (seatID)){
				reader.close();
				return true;
			}
				
		}
		reader.close();
		return false;
	}

	public void unBookSeat() {
		seatBooked = false;
	}

}

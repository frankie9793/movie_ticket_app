package assignment;

import java.io.IOException;

public class TransactionLog {
	private String tId;

	private String userName;
	private int userPhoneNumber;
	private String userEmail;
	
	CalendarDate cd = new CalendarDate();

	public TransactionLog(String userName, int userPhoneNumber, String userEmail, int CinemaCode) {

		tId = Integer.toString(CinemaCode);
		tId = tId.concat(cd.getNowTime());
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmail = userEmail;

	}

	public String getTId() {
		return tId;
	}

	public String ConvertToRecord(String CineplexID, String CinemaID, String MovieTitle, String ShowDate,
			String ShowTime, String seatID) throws IOException {

		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("TransactionLog.txt") + 1;

		record = serialno + "|" + tId + "|" + userName + "|" + userPhoneNumber + "|" + userEmail + "|" + CineplexID
				+ "|" + CinemaID + "|" + MovieTitle + "|" + ShowDate + "|" + ShowTime + "|" + seatID; 
		return record;
	}



}

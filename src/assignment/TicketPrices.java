package assignment;

import java.io.IOException;

public class TicketPrices {

	private double Student_price;
	private double Senior_citizen_price;
	private double Normal_Weekday_price;
	private double Weekend_price;
	private double threeD_stud;
	private double threeD;
	private double Pms_weekday_price;
	private double Pms_weekend_price;

	public TicketPrices() {
		Student_price = 7;
		Senior_citizen_price = 5;
		Normal_Weekday_price = 9;
		Weekend_price = 13;
		threeD_stud = 10;
		threeD = 16;
		Pms_weekday_price = 28;
		Pms_weekend_price = 38;
	}

	public TicketPrices(double Student_price, double Senior_citizen_price, double Normal_Weekday_price,
			double Weekend_price, double threeD_stud, double threeD, double Pms_weekday_price,
			double Pms_weekend_price) {
		this.Student_price = Student_price;
		this.Senior_citizen_price = Senior_citizen_price;
		this.Normal_Weekday_price = Normal_Weekday_price;
		this.Weekend_price = Weekend_price;
		this.threeD_stud = threeD_stud;
		this.threeD = threeD;
		this.Pms_weekday_price = Pms_weekday_price;
		this.Pms_weekend_price = Pms_weekend_price;
	}

	public double getStudent_price() {
		return Student_price;
	}

	public void setStudent_price(double set) {
		Student_price = set;
	}

	public double getSenior_citizen_price() {
		return Senior_citizen_price;
	}

	public void setSenior_citizen_price(double set) {
		Senior_citizen_price = set;
	}

	public double getNormal_Weekday_price() {
		return Normal_Weekday_price;
	}

	public void setNormal_Weekday_price(double set) {
		Normal_Weekday_price = set;
	}

	public double getWeekend_price() {
		return Weekend_price;
	}

	public void setWeekend_price(double set) {
		Weekend_price = set;
	}

	public double getthreeD_stud() {
		return threeD_stud;
	}

	public void setthreeD_stud(double set) {
		threeD_stud = set;
	}

	public double getthreeD() {
		return threeD;
	}

	public void setthreeD(double set) {
		threeD = set;
	}

	public double getPms_weekday_price() {
		return Pms_weekday_price;
	}

	public void setPms_weekday_price(double set) {
		Pms_weekday_price = set;
	}

	public double getPms_weekend_price() {
		return Pms_weekend_price;
	}

	public void setPms_weekend_price(double set) {
		Pms_weekend_price = set;
	}

	public void displayTicket_price() {
		System.out.println("");
		System.out.println("============================================");
		System.out.println("             Ticket Price Table");
		System.out.println("============================================");
		System.out.println("2D Movie ticket Pricing");
		System.out.println("-------------------------------------");
		System.out.println("1) Student price\t\t\t" + "$ " + getStudent_price());
		System.out.println("2) Senior Citizen Price\t\t\t" + "$ " + getSenior_citizen_price());
		System.out.println("3) Normal Weekday Price\t\t\t" + "$ " + getNormal_Weekday_price());
		System.out.println("4) Normal Weekend Price\t\t\t" + "$ " + getWeekend_price());
		System.out.println("5) Platinum Moive Suites Weekday Price\t" + "$ " + getPms_weekday_price());
		System.out.println("6) Platinum Moive Suites Weekend Price\t" + "$ " + getPms_weekend_price());
		System.out.println("");
		System.out.println("3D Movie ticket Pricing");
		System.out.println("-------------------------------------");
		System.out.println("7) Student Price\t\t\t" + "$ " + getthreeD_stud());
		System.out.println("8) Normal 3D ticket price\t\t" + "$ " + getthreeD());
		System.out.println("9) Back ");
		System.out.println("");

	}

	public double CalculateTicketPrice(int DayOfWeek, long time, int movie_type, int numOfTix, boolean student,
			boolean seniorCitizen, boolean publicHoliday) {
		double price = 0;

		switch (movie_type) {
		// 2d movie
		case 0:
			// time 24 = 59400000 18hr =37800000 11hr =12600000 ms
			if ((student || seniorCitizen) && (DayOfWeek >= 1 && DayOfWeek <= 5)
					&& (time < 37800000 && time >= 12600000) && !publicHoliday) {
				if (student)
					// student price
					price += Student_price;
				else
					// senior citizen price
					price += Senior_citizen_price;
			} else if (DayOfWeek >= 1 && DayOfWeek <= 4 && !publicHoliday)
				price += Normal_Weekday_price;
			else
				price += Weekend_price;
			break;
		// 3d
		case 1:
			if ((student) && (DayOfWeek >= 1 && DayOfWeek <= 5) && (time < 37800000 && time >= 12600000)
					&& !publicHoliday)
				// student price
				price += (threeD_stud);
			else
				price += threeD;
			break;
		// Platinum Moive Suites
		case 2:
			// PMS only available on thurs to sun unless stated otherwise
			if (DayOfWeek >= 1 && DayOfWeek <= 4 && !publicHoliday)
				price += Pms_weekday_price;
			else
				price += Pms_weekend_price;
		}

		return price * numOfTix;

	}

	public String ConvertToRecord() throws IOException {

		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("TicketPrices.txt") + 1;
		record = serialno + "|" + Student_price + "|" + Senior_citizen_price + "|" + Normal_Weekday_price + "|"
				+ Weekend_price + "|" + threeD_stud + "|" + threeD + "|" + Pms_weekday_price + "|" + Pms_weekend_price;
		return record;
	}
}

package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cineplex {
	
	private int CineplexID;
	private String Location;
	private int NoOfCinema;
	ArrayList<AbstractCinema> ctheatre = new ArrayList<AbstractCinema>();
	private int CinemaType;

	Scanner sc = new Scanner(System.in);
	
	public Cineplex(int CineplexID, String Location, int NoOfCinema) throws IOException {
		this.CineplexID = CineplexID;
		this.Location = Location;
		this.NoOfCinema = NoOfCinema;
		for (int i = 1; i <= NoOfCinema; i++) {
			AddCinema();
			String record = ConvertToRecord(i-1);
			TableProcessor.Insert(record, "CineplexRecords.txt");
		}
	}

	public String getLocation() {
		return Location;
	}

	public void AddCinema() {
		
		int choice,CinemaID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please what type of cinema would you like to add?");
		System.out.println("1: Standard Cinema");
		System.out.println("2: Platinum Suite");
		choice = sc.nextInt();
		System.out.println("Please enter the CinemaID");
		CinemaID = sc.nextInt();
		boolean done = false;
		while (!done)
		switch(choice){
			case 1: ctheatre.add(new NormalCinema(CinemaID));
					System.out.println("Standard Cinema succesfully added to cineplex");
					done = true;
					break;
			case 2: ctheatre.add(new PlatinumSuiteCinema(CinemaID));
					System.out.println("Platinum Suite successfully added to cineplex");
					done = true;
					break;
			default: System.out.println("Invalid choice.Please enter again");
					break;		
		}
	}
	public void removeCinema(int CinemaID)
	{
		ctheatre.remove(CinemaID-1);
	}
	public void DisplayCinema(){
		for(int i=0;i<ctheatre.size();i++)
		{
			System.out.println("CinemaID "+ctheatre.get(i).getCinemaID() );
		}
	}
	public String ConvertToRecord(int i) throws IOException {

		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("CineplexRecords.txt") + 1;

		record = serialno + "|" + Location + "|" + CineplexID + "|" + ctheatre.get(i).getCinemaID();
		return record;
	}

}
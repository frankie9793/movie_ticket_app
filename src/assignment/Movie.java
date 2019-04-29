package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import assignment.Enumclasses.MovieRating;
import assignment.Enumclasses.MovieType;
import assignment.Enumclasses.ShowingStatus;
import assignment.TableProcessor;


public class Movie {
	
	private MovieRating Rating;
	private ShowingStatus MovieStatus;
	private MovieType Type;
	
	private String Genre;
	private String Title;
	private String Director;
	private String Cast;
	private String Synopsis;
	
	public Movie(){}
	
	public void setTitle(String title) {
		this.Title = title;
	}
	
	public void setDirector(String director){
		this.Director = director;
	}
	
	public void setCast(String Cast){
		this.Cast = Cast;
		
	}
	
	public void setRating(MovieRating rating){
		this.Rating = rating;
	}
	
	public void setGenre(String genre){
		this.Genre = genre;
	}
	
	public void setShowingStatus(ShowingStatus status){
		this.MovieStatus = status;
	}
	
	public void writeSynopsis(String synopsis){
		this.Synopsis = synopsis;
	}
	
	public void setMovieType(MovieType type){
		this.Type = type; 
	}
	

	public static double OverrallRating(String movieName) throws IOException 
	{
		File inputFile = new File("Reviews.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		String currentLine;
		String[] temp;
		double avg = 0, count = 0;
		while ((currentLine = reader.readLine()) != null) {
			temp = currentLine.split("\\|");
			if (temp[1].compareToIgnoreCase(movieName) == 0) {
				avg += Double.parseDouble(temp[4]);
				count++;
			}
		}
		if(count <=1)
		{
			reader.close();
			return 0;
		}	
		else
		{
			reader.close();
			avg = avg / count;
			return Double.parseDouble(String.format("%.2f", avg));
			
		}
	}

	
	public String ConvertToRecord() throws IOException{
		
		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("MovieListingTable.txt")+1;
	
		record = serialno + "|" + Title + "|" + Director + "|" + Cast + "|" + Rating + "|" + Genre + "|" + MovieStatus + 
				"|" + Synopsis + "|" + Type + "|";
		return record;
	}
	
}

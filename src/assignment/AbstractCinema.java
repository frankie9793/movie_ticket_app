package assignment;

import java.io.IOException;

public abstract class AbstractCinema {
    
    private int CinemaID;
    public AbstractCinema() {
    }
    
    public AbstractCinema(int CinemaID){
   	 this.CinemaID = CinemaID;
    }
    public void setCinemaID(int CinemaID){
   	 this.CinemaID = CinemaID;
    }
    public int getCinemaID(){
   	 return CinemaID;
    }
    
    public abstract void ShowNumOfSeatEmpty(int cinplexID,String CineCode, String iDate, String iTime,String movieTitle)throws NumberFormatException, IOException;
    public abstract void DisplaySeats(int cinplexID,String CineCode,String iDate, String iTime,String movieTitle)throws NumberFormatException, IOException;
    
    
}




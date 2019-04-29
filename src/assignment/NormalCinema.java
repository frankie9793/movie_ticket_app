package assignment;

import java.io.IOException;

public class NormalCinema extends AbstractCinema {

    private CinemaSeat[] CSeat;
    private int NoOfSeatEmpty;
    private String CinemaType;
    
    public NormalCinema(){
   	 CSeat = new CinemaSeat[50];
   	 for (int i = 0; i < CSeat.length; i++) {
   		 CSeat[i] = new CinemaSeat(i + 1);
   	 }
    }
    
    public NormalCinema(int CinemaID){
   	 
   	 super(CinemaID);
   	 
   	 CSeat = new CinemaSeat[50];
   	 for (int i = 0; i < CSeat.length; i++) {
   		 CSeat[i] = new CinemaSeat(i + 1);
   	 }
   	 NoOfSeatEmpty = 50;
   	 CinemaType = "Normal";
    }
    
    public String getCinemaType(){
   	 return CinemaType;   	 
    }
    @Override
    public void ShowNumOfSeatEmpty(int cinplexID,String CineCode,String iDate, String iTime,String movieTitle) throws NumberFormatException, IOException{
   	 NoOfSeatEmpty = 50;
   	 for(int i =0; i<50; i++){
   		 if(CSeat[i].isOccupied( Integer.toString(cinplexID),  CineCode,  iDate,  iTime, movieTitle,  i))
   			 NoOfSeatEmpty--;
   	 }
   	 System.out.printf("There are %d seats empty\n",NoOfSeatEmpty);
    }
    @Override
    public void DisplaySeats(int cinplexID,String CineCode,String iDate, String iTime,String movieTitle) throws NumberFormatException, IOException {
   	 System.out.println("======================================");
   	 System.out.println("\t\tScreen");
   	 System.out.println("======================================");
   	 System.out.print(  "   1  2     3  4  5  6  7  8     9 10");

   		 System.out.println("\n");

   	 for (int i = 0; i < (50 - 20) / 10; i++) {
   		 switch(i)
   		 {
   		 case 0:
   			 System.out.print("A ");
   			 break;
   		 case 1:
   			 System.out.print("B ");
   			 break;
   		 case 2:
   			 System.out.print("C ");
   			 break;
   		 }
   		 for (int j = 0; j < 10; j++) {
   			 
   			 if (!CSeat[(i * 10) + j].isOccupied(Integer.toString(cinplexID), CineCode,  iDate,  iTime, movieTitle,  ((i * 10) + j)))
   				 System.out.print("[O]");
   			 else
   				 System.out.print("[X]");
   			 if (j == 1 || j == 7)
   				 System.out.print("   ");
   		 
   		 }
   		 System.out.println(" ");
   		 System.out.println("");
   	 }
   	 for (int i = 3; i < 50 / 10; i++) {
   		 switch(i)
   		 {
   		 case 3:
   			 System.out.print("D ");
   			 break;
   		 case 4:
   			 System.out.print("E ");
   			 break;
   		 }
   		 for (int j = 0; j < 10; j+=2) {
   			 if (!CSeat[(i * 10) + j].isOccupied(Integer.toString(cinplexID),  CineCode,  iDate,  iTime, movieTitle,  ((i * 10) + j)))
   				 System.out.print("[O  O]");
   			 else
   				 System.out.print("[X  X]");
   			 if (j == 0 || j == 6)
   				 System.out.print("   ");
   			 
   		 }
   		 System.out.println(" ");
   		 System.out.println(" ");
   	 }
   	 System.out.println("--------------------------------------");
   	 
    }

}



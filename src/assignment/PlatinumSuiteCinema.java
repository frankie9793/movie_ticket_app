package assignment;

import java.io.IOException;

public class PlatinumSuiteCinema extends AbstractCinema{
    
    private CinemaSeat[] CSeat;
    private int NoOfSeatEmpty;
    private String CinemaType;
    
    public PlatinumSuiteCinema(){
   	 CSeat = new CinemaSeat[20];
   	 for (int i = 0; i < CSeat.length; i++) {
   		 CSeat[i] = new CinemaSeat(i + 1);
   	 }
    }
    
    public PlatinumSuiteCinema(int CinemaID){
   	 
   	 super(CinemaID);
   	 
   	 CSeat = new CinemaSeat[20];
   	 for (int i = 0; i < CSeat.length; i++) {
   		 CSeat[i] = new CinemaSeat(i + 1);
   	 }
   	 NoOfSeatEmpty = 20;
   	 CinemaType = "PlatinumSuite";
    }
    public String getCinemaType(){
   	 return CinemaType;   	 
    }
    @Override
    public void ShowNumOfSeatEmpty(int cinplexID,String CineCode,String iDate, String iTime,String movieTitle) throws NumberFormatException, IOException{
   	 NoOfSeatEmpty = 20;
   	 for(int i =0; i<20; i++){
   		 if(CSeat[i].isOccupied( Integer.toString(cinplexID),  CineCode,  iDate,  iTime, movieTitle,  i))
   			 NoOfSeatEmpty--;
   	 }
   	 System.out.printf("There are %d seats empty\n",NoOfSeatEmpty);
    }
    @Override
    public void DisplaySeats(int cinplexID,String CineCode,String iDate, String iTime ,String movieTitle) throws NumberFormatException, IOException {
   	 System.out.println("==================");
   	 System.out.println("     Screen       ");
   	 System.out.println("==================");
   	 System.out.print("   1  2	3  4");
   	 System.out.println("\n");
   	 for (int i = 0; i < 20 / 4; i++) {
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
   		 case 3:
   			 System.out.print("D ");
   			 break;
   		 case 4:
   			 System.out.print("E ");
   			 break;
   		 }
   		 for (int j = 0; j < 4; j++) {
   			 if (!CSeat[(i * 4) + j].isOccupied(Integer.toString(cinplexID),  CineCode,  iDate,  iTime, movieTitle,  ((i * 4) + j)))
   				 System.out.print("[O]");
   			 else
   				 System.out.print("[X]");
   			 if (j == 1)
   				 System.out.print("  ");
   		 }
   		 System.out.println(" ");
   		 System.out.println("");
   	 }
   	 
    }
}




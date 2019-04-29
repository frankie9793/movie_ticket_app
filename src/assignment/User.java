package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class User {
    
    public User(){}
    
    public void ViewTopMovies(boolean byTicketsales) throws IOException {

        ArrayList<String> movietitles = TableProcessor.MovieTitles("8","TransactionLogTable.txt");

        double avgrating;

        String[][] record = new String[movietitles.size()][2];
        
        String movietitle;
        

        int noOftickets;

        if (byTicketsales) {
            for (int i = 0; i < movietitles.size(); i++) {
                movietitle = movietitles.get(i);
                record[i][0] = movietitle;
                noOftickets = TableProcessor.CountSameMovie(movietitle, 8, "TransactionLogTable.txt");
                record[i][1] = Integer.toString(noOftickets);
            }
            Arrays.sort(record, new Comparator<String[]>() {
                @Override
                public int compare(String[] entry1, final String[] entry2) {

                    String time1 = entry1[1];
                    String time2 = entry2[1];
                    return -time1.compareTo(time2);
                }
            });
            System.out.println("=====================================");
            System.out.println("The top 5 movies by ticket sales are ");
            System.out.println("-------------------------------------");
            if(movietitles.size()<0){
                System.out.println("There are currently no tickets purchased.");
            }
            else if(movietitles.size()>= 5){
                for (int j = 0; j < 5; j++) {
                    System.out.println("[" + (j + 1) + "]" + ": " + record[j][0] + " - " + record[j][1] + " ticketsales");
                }
            }
            else{
                for (int k =0; k<movietitles.size();k++){
                    System.out.println("[" + (k + 1) + "]" + ": " + record[k][0] + " - " + record[k][1] + " ticketsales");
                }
            }
            System.out.println("-------------------------------------");
        } else {
            
             ArrayList<String> movietitles2 = TableProcessor.MovieTitles("2","Reviews.txt");
             String[][] recordTwo = new String[movietitles2.size()][2];
            
            for (int i = 0; i < movietitles2.size(); i++) {
                movietitle = movietitles2.get(i);
                recordTwo[i][0] = movietitle;
                avgrating = Movie.OverrallRating(movietitle);
                recordTwo[i][1] = Double.toString(avgrating);
            }
            Arrays.sort(recordTwo, new Comparator<String[]>() {
                @Override
                public int compare(String[] entry1, String[] entry2) {
                    String time1 = entry1[1];
                    String time2 = entry2[1];
                    return -time1.compareTo(time2);
                }
            });
            System.out.println("=========================================");
            System.out.println("The top 5 movies by customer ratings are ");
            System.out.println("-----------------------------------------");
            
            if(movietitles2.size() < 0){
                
                System.out.println("There are currently no tickets purchased.");
                
            }
            
            else if(movietitles2.size()>= 5){
                for (int j = 0; j < 5; j++) {
                    if (recordTwo[j][1].equals("0.0"))
                        continue;
                    else
                        System.out.println((j + 1) + " :  " + recordTwo[j][0] + " - " + recordTwo[j][1] + " rating");
                }
            }
            else{
                for (int k =0; k < movietitles2.size();k++){
                    if (recordTwo[k][1].equals("0.0"))
                        continue;
                    else
                        System.out.println("[" + (k + 1) + "]" + ": " + recordTwo[k][0] + " - " + recordTwo[k][1] + " rating");
                }
            }
            System.out.println("-----------------------------------------");
        }
    }
}




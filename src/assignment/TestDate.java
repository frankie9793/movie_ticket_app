package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		
		String[][] dates = new String[][]{{"1","12-12-17"},{"2","12-11-17"},{"3","11-12-17"},{"4","01-01-17"}};
		String[][] temp2 = new String[4][2];
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		Date date1 = format.parse(dates[0][1]);
		Date date2 = format.parse(dates[1][1]);
		Date date3 = format.parse(dates[2][1]);
		Date date4 = format.parse(dates[3][1]);
		
	
		
		for(int l=0;l<4;l++){
			for(int m=0;m<2;m++){
				System.out.print(dates[l][m]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		System.out.println();
		
		for(int i=0; i <4; i++){
			for(int h=1; h < 4-i; h++){
				if(dates[h-1][1].equalsIgnoreCase(dates[h][1]) ){
					for(int k=0; k<2;k++){
						temp2[i][k] = dates[h-1][k];
						dates[h-1][k] = dates[h][k];
						dates[h][k] = temp2[i][k];
					}			
				}
			}
		}
		for(int l=0;l<4;l++){
			for(int m=0;m<2;m++){
				System.out.print(dates[l][m]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		if (date1.compareTo(date2) >= 0) {
	        System.out.println("dateString1 is an later date than dateString2");
	    }
	}
}

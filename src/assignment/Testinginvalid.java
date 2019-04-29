package assignment;
import java.util.*;

public class Testinginvalid {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
        int i = 0; 
        String flush;
        System.out.println("Please enter an integer: ");

        while(true){
          try{
             i = reader.nextInt();
             break;  
          }catch(InputMismatchException ex){
             System.out.println("You did not enter an int. Please enter an integer:");
             flush = reader.nextLine();
             continue;
          }
        }

        System.out.println("Input of type int: " + i);

	}

}

import java.util.*;
import javax.swing.JTextArea;
import java.io.*;

public class Logik {
	
	private Grafik g;
	
	public String random() {
		
		String lottoRad = "";
		
		int lotto[] = new int[7];
		Random nr = new Random();
		
		/*
		 * Algoritm för att slumpa lottorad.
		 */
		for(int i = 0; i < 7; i++) {
			
		    lotto[i] = nr.nextInt(35);
		}
		
		/*
		 * Algoritm för att undvika dubbletter och tilldela nytt random tal.
		 */
		for(int m = 0; m < 7; m++) {
            
            for(int j = 0; j < 7; j++) {
                
                int temp = lotto[m];
                lotto[m] = 0;
                
                while(temp == lotto[j]) {
                	
                    temp = nr.nextInt(35);
                }
                
                lotto[m] = temp;
            }
        }
		
		/*
		 * Ändrar array med lottorad till String.
		 * Returnerar till lyssnare.
		 */
		for(int i = 0; i < 7; i++) {
			
			String temp = Integer.toString(lotto[i]);
			
			lottoRad+=(temp + " ");
		}
		
		return lottoRad;
	}
	
	public void quit() {
		
		/*
		 * Avslutar programmet.
		 */
		
		System.exit(1);
	}

}

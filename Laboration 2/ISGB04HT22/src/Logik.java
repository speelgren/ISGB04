import java.util.*;
import javax.swing.JTextArea;
import java.io.*;

public class Logik {
	
	private Grafik g;
	
	public String random() {
		
		String lottoRad = "";
		
		int lotto[] = new int[7];
		
		for(int i = 0; i < 7; i++) {
			Random nr = new Random();
		    lotto[i] = nr.nextInt(35);
		}
		
		for(int i = 0; i < 7; i++) {
			String temp = Integer.toString(lotto[i]);
			
			lottoRad+=(temp + " ");
		}
		
		return lottoRad;
	}
	
	public void quit() {
		
		System.exit(1);
	}

}
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Filhant {
	
	private Grafik g;
	private BufferedReader reader;
	private BufferedWriter writer;
	private String in;

	public void save(String s) {
		
		try {
			
			/*
			 * Skriver den mottagna String s till filen lotto.txt.
			 * 
			 */
			writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("lotto.txt"))));

			writer.write(s + '\n');
			
			/*
			 * Stänger BufferedWriter.
			 */
		    writer.close();
		    
		    System.out.println("file saved");
		}
		catch (IOException e) {
			
			System.out.println("issue with file");
		}
	}

	public String[] read() {
		
		/*
		 *  Skapar lottoList som ArrayList med typ String.
		 */
		List <String> lottoList = new ArrayList<String>();
		
		try {
			
			/*
			 * Läser det som finns i filen lotto.txt
			 */
			reader = new BufferedReader (new InputStreamReader(new BufferedInputStream(new FileInputStream("lotto.txt"))));
			in = reader.readLine();
			
			/*
			 * Så länge filen inte är tom fortsätter programmet läsa filen tills den är slut.
			 */
			while (in != null) {
				
				lottoList.add(in);
				in = reader.readLine();
			}
			
		}
		/*
		 * Om filen är tom kastas ett felmeddelande.
		 */
		catch (IOException e) {
			
			System.out.println("File is empty");
		}
		
		/*
		 * Innehållet i filen läses och ändras till lottoArray och returneras till lyssnaren
		 */
		String[] lottoArray = lottoList.toArray(new String[0]);
		
		return lottoArray;
	}

}

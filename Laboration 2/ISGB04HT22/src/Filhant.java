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
			
			writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("lotto.txt"))));

			writer.write(s + '\n');
		    writer.close();
		    
		    System.out.println("file saved");
		}
		catch (IOException e) {
			
			System.out.println("issue with file");
		}
	}

	public String[] read() {
		
		List <String> lottoList = new ArrayList<String>();
		
		try {
			
			reader = new BufferedReader (new InputStreamReader(new BufferedInputStream(new FileInputStream("lotto.txt"))));
			in = reader.readLine();
			
			while (in != null) {
				lottoList.add(in);
				in = reader.readLine();
			}
			
		}
		catch (IOException e) {
			System.out.println("File is empty");
		}
		String[] lottoArray = lottoList.toArray(new String[0]);
		
		return lottoArray;
	}

	public Filhant() {


	}

}

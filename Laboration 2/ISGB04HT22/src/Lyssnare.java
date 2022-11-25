import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Lyssnare extends WindowAdapter implements ActionListener {

	private Grafik g;
	
	public Logik l = new Logik();
	public Filhant fh = new Filhant();
	
	/*
	 * För att kunna använda lyssnarna i grafik.
	 */
	public Lyssnare(Grafik gIn) {
		
		g = gIn;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("random")) {
			
			/*
			 * Lägger till lottorad i JTextArea.
			 */
			String lotto = l.random();
			g.getTextField().append(lotto + '\n');
		} 
		if(e.getActionCommand().equals("clear")) {
			
			//Rensar all information i JTextArea.
			g.getTextField().setText("");
		} 
		if(e.getActionCommand().equals("save")) {
			
			/* 
			 * Sparar text till textfil.
			 * Sparar texten som ligger i JTextArea i String s.
			 * Skickar String s till metoden save.
			 * */
			String s = g.getTextField().getText();
			fh.save(s);
		} 
		if(e.getActionCommand().equals("read")) {
			
			String[] lottoLista = fh.read();
			
			/*
			 *  Loop för att läsa igenom alla rader i filen och append dem till JTextArea.
			 */
			for(int i = 0; i < lottoLista.length; i++) {
				
				g.getTextField().append(lottoLista[i] + '\n');
			}
		}
		if((e.getActionCommand().equals("quit"))) {
			
			l.quit();
		}
	}
    
	public void windowClosing(WindowEvent e) {
		
		System.exit(0);
	}

}

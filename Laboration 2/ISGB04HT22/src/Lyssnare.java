import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Lyssnare extends WindowAdapter implements ActionListener {

	private Grafik g;
	//private Filhant fh;

	public Logik l = new Logik();
	public Filhant fh = new Filhant();
	
	public Lyssnare(Grafik gIn) {
		g = gIn;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("random")) {
			
			String lotto = l.random();
			g.getTextField().append(lotto + '\n');
		} 
		if(e.getActionCommand().equals("clear")) {
			
			g.getTextField().setText("");
		} 
		if(e.getActionCommand().equals("save")) {
			
			String s = g.getTextField().getText();
			fh.save(s);
		} 
		if(e.getActionCommand().equals("read")) {
			
			String[] lottoLista = fh.read();
			
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

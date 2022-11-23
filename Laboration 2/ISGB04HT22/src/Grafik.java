import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;

public class Grafik {
	
	private JFrame f;
	private JTextArea t;
	private JScrollPane sb;
	private JMenuBar mainMenu;
	private JMenu menu;
	private JMenuItem random, clear, save, read, quit;
	private Lyssnare ly;

	public Grafik() {
		
		f=new JFrame("Lotto");
		t=new JTextArea();
		sb=new JScrollPane(t);
		ly=new Lyssnare(this);
		
		mainMenu = new JMenuBar();
		menu = new JMenu("Menu");
		random = new JMenuItem("random"); 
		clear = new JMenuItem("clear");
		save = new JMenuItem("save");
		read = new JMenuItem("read");
		quit = new JMenuItem("quit");
		
		menu.add(random);
		menu.add(clear);
		menu.add(save);
		menu.add(read);
		menu.addSeparator();
		menu.add(quit);
		mainMenu.add(menu);
		f.setJMenuBar(mainMenu);
		
		random.addActionListener(ly);
		clear.addActionListener(ly);
		save.addActionListener(ly);
		read.addActionListener(ly);
		quit.addActionListener(ly);
		
		f.getContentPane().add(sb);
		f.setSize(250,200);
		f.setLocation(100,100);
		f.setVisible(true);
		
	}
	
	public JTextArea getTextField() {
		
		return t;
	}
	
	public static void main(String[] args) {

		new Grafik();
	}

}

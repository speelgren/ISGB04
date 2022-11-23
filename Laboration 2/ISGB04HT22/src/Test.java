import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Test {
	
	private JFrame f;
	private JLabel l;
	private JButton b1,b2;
	
	public Test() {
		
		this.f=new JFrame("Question?");
		this.l=new JLabel("Do you want to Save?");
		this.b1=new JButton("Yes");
		this.b2=new JButton("No");
		this.f.setSize(200,100);
		this.f.setLocation(700,500);
		this.f.setLayout(new FlowLayout());
		this.f.add(l);
		this.f.add(b1);
		this.f.add(b2);
		this.f.setVisible(true);
		}

	public static void main(String[] args) {
		
		new Test();
	}
}
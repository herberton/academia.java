import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing {
	
	// main
	
	public static void main(String... args) {
		new Swing(); 
	}
	
	
	// property
	
	private JFrame jframe;
	private JPanel jpanel;
	private JButton jbutton1;
	private JButton jbutton2;
	private JButton jbutton3;
	private JButton jbutton4;
	private JButton jbutton5;
	
	
	// constructor
	
	public Swing() {
	
		// instance
		
		jframe = new JFrame("Swing");
		
		jpanel = new JPanel(new GridLayout(3, 2));
		
		jbutton1 = new JButton("JButton 1");
		jbutton2 = new JButton("JButton 2");
		jbutton3 = new JButton("JButton 3");
		jbutton4 = new JButton("JButton 4");
		jbutton5 = new JButton("JButton 5");
		
		
		// bind
		
		jpanel.add(jbutton1);
		jpanel.add(jbutton2);
		jpanel.add(jbutton3);
		jpanel.add(jbutton4);
		jpanel.add(jbutton5);
		
		jframe.add(jpanel);
		
		
		// configure
		
		jpanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(800, 600);
		jframe.setVisible(true);
	}
	
	
	// method
	
}

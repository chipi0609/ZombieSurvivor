package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Application extends JFrame{

	public Application() throws IOException {
		//add(new Board());
		
		setSize(800,600);
		
		setTitle("Zombie Survivor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		BackgroundPanel panel = new BackgroundPanel("resources/front.jpg");
		
		setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		
		JLabel enter = new JLabel();
		enter.setBorder(BorderFactory.createEmptyBorder());
		ImageIcon enterIcon = new ImageIcon("resources/enter.png");
		Image img = enterIcon.getImage();
		Image scaledImage = img.getScaledInstance(280, 255, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		enter.setIcon(scaledIcon);
		panel.add(enter);
		setContentPane(panel);
		
		pack();
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				Application app = null;
				try {
					app = new Application();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				app.setVisible(true);
			}
			
		});
	}
}

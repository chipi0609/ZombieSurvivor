package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Application extends JFrame{

	public Application() throws IOException {
		//add(new Board());
		
		setSize(800,600);
		
		setTitle("Zombie Survivor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
//		JLabel background = new JLabel(new ImageIcon("resources/front.jpg")); 
//		add(background);
		setContentPane(new BackgroundPanel("resources/front.jpg"));
		
	   
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

package ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {


	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//new MainMenu();
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/menuu.jpg"));
		setBounds(new Rectangle(0,0, 1184, 671));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 1184, 671));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		
		JButton b3 = new JButton();
		
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b3.setFocusPainted(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		ImageIcon icon = new ImageIcon("img/helpme.png") ;  
		Image newimg = icon.getImage().getScaledInstance( 200,50,  java.awt.Image.SCALE_SMOOTH ) ; 
		
		icon = new ImageIcon(newimg);
		b3.setIcon(icon);
		b3.setBounds(600, 370, 349, 62);
		b3.setFont(new Font("Ancient", Font.PLAIN, 40));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AideFenetre();
			}
		});
		
		
		JButton b1 = new JButton();
		
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setFocusPainted(false);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		icon = new ImageIcon("img/playy.png") ;  
		newimg = icon.getImage().getScaledInstance( 200,50,  java.awt.Image.SCALE_SMOOTH ) ; 
		
		icon = new ImageIcon(newimg);
	
		b1.setIcon(icon);
		b1.setBounds(600, 290, 349, 62);
		b1.setFont(new Font("Ancient", Font.PLAIN, 40));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MakeChoices();
			}
		});
		
		
		
		JButton b2 = new JButton();
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.setFocusPainted(false);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		icon = new ImageIcon("img/quitt.png") ;  
		newimg = icon.getImage().getScaledInstance( 200,50,  java.awt.Image.SCALE_SMOOTH ) ; 
		icon = new ImageIcon(newimg);
		b2.setIcon(icon);
		b2.setBounds(600, 450, 349, 62);
		b2.setFont(new Font("Ancient", Font.PLAIN, 40));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		
		panel.setLayout(null);
		
		
		
	
		
		panel.add(b2);
		panel.add(b1);
		panel.add(b3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		icon = new ImageIcon("img/menuu.jpg") ;  
		newimg = icon.getImage().getScaledInstance(  1184, 671,  java.awt.Image.SCALE_SMOOTH ) ; 
		icon = new ImageIcon(newimg);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 1184, 671);
		panel.add(lblNewLabel);
		setVisible(true);
	}

}

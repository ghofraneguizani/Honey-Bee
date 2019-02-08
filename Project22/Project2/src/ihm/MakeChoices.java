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
import java.util.Random;

import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import models.Application;
import models.Forager;
import models.Interface;


public class MakeChoices extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Interface cb; 
	private int nbFleurs , nbBees;


	

	private SwingWorker<Void, Void> worker;


		private JPanel contentPane;

		
		
	
		public MakeChoices() {
			setBackground(Color.WHITE);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("img/26337149-illustration-of-a-bee-above-the-stump-and-a-tree-with-a-beehive.jpg"));
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
			
			
			JLabel label1 = new JLabel("Entrez le nombre d'abeilles");
			label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label1.setBounds(600, 300, 349, 62);
			label1.setFont(new Font("Ancient", Font.PLAIN, 20));
			label1.setForeground(Color.white);
			
			
			JLabel label2 = new JLabel("Entrez le nombre de fleurs");
			label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label2.setBounds(600, 400, 349, 62);
			label2.setFont(new Font("Ancient", Font.PLAIN, 20));
			label2.setForeground(Color.white);
			
			JTextField text1 = new JTextField(10);
			text1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			text1.setBounds(600, 450, 349, 62);
			text1.setFont(new Font("Ancient", Font.PLAIN, 40));
			
			JTextField text2= new JTextField(10);
			text2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			text2.setBounds(600, 350, 349, 62);
			text2.setFont(new Font("Ancient", Font.PLAIN, 40));

			JButton b2 = new JButton();
			b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b2.setFocusPainted(false);
			b2.setBorderPainted(false);
			b2.setContentAreaFilled(false);
			ImageIcon icon = new ImageIcon("img/fl.PNG") ;  
			Image newimg = icon.getImage().getScaledInstance( 200,50,  java.awt.Image.SCALE_SMOOTH ) ; 
			icon = new ImageIcon(newimg);
			b2.setIcon(icon);
			b2.setBounds(600, 520, 349, 62);
			b2.setFont(new Font("Ancient", Font.PLAIN, 40));
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//dispose();
					nbFleurs= Integer.parseInt(text1.getText());
					nbBees =Integer.parseInt(text2.getText());
					Application a = new Application();
					a.create(nbFleurs, nbBees);
				
					
					//new lancerJeu();
					
					a.getFrame().repaint();
					//new Interface();
					
			}
				
				
			});
			
			panel.setLayout(null);
			
				
				
			
			
			panel.add(label1);panel.add(text1);
			panel.add(label2);panel.add(text2);
		
			panel.add(b2);
		
			
			
	

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			icon = new ImageIcon("img/26337149-illustration-of-a-bee-above-the-stump-and-a-tree-with-a-beehive.jpg") ;  
			newimg = icon.getImage().getScaledInstance(  1184, 671,  java.awt.Image.SCALE_SMOOTH ) ; 
			icon = new ImageIcon(newimg);
			lblNewLabel.setIcon(icon);
			lblNewLabel.setBounds(0, 0, 1184, 671);
			panel.add(lblNewLabel);
			setVisible(true);
		}




		public int getNbFleurs() {
			return nbFleurs;
		}




		public int getNbBees() {
			return nbBees;
		}
		
		

}

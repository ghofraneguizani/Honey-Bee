package ihm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Color;

public class AideFenetre extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");

	
	/**
	 * Create the frame.
	 */
	public AideFenetre() {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/menuu.jpg"));
		setTitle("Honey bee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1184, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 671);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon icon = new ImageIcon("img/back.png") ;  
		Image newimg = icon.getImage().getScaledInstance( 149, 62,  java.awt.Image.SCALE_SMOOTH ) ; 
		
		icon = new ImageIcon(newimg);
		btnNewButton.setIcon(icon);
		btnNewButton.setBounds(650, 536, 349, 62);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MainMenu();
			}
		});
		panel.setLayout(null);
		btnNewButton.setFont(new Font("Ancient", Font.PLAIN, 40));
		panel.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("About the Game :");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setFont(new Font("Ancient", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setBounds(630, 130, 200, 29);
		panel.add(lblNewLabel_3);
		/*
		JLabel lblMort = new JLabel("Mort :");
		lblMort.setVerticalAlignment(SwingConstants.TOP);
		lblMort.setForeground(Color.BLACK);
		lblMort.setFont(new Font("Ancient", Font.PLAIN, 30));
		lblMort.setBounds(659, 338, 65, 29);
		panel.add(lblMort);
		
		JLabel lblLeGagnant = new JLabel("Le Gagnant :");
		lblLeGagnant.setVerticalAlignment(SwingConstants.TOP);
		lblLeGagnant.setForeground(Color.BLACK);
		lblLeGagnant.setFont(new Font("Ancient", Font.PLAIN, 30));
		lblLeGagnant.setBounds(630, 447, 123, 29);
		panel.add(lblLeGagnant);
		*/
		JLabel lbl1 = new JLabel("This game simulates the life of bees and how they collect");
		lbl1.setVerticalAlignment(SwingConstants.TOP);
		lbl1.setForeground(Color.BLACK);
		lbl1.setOpaque(true);
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl1.setBounds(549, 170, 420, 29);
		panel.add(lbl1);
		
		JLabel lbl2 = new JLabel("nectar to reproduce and make honey.");
		lbl2.setVerticalAlignment(SwingConstants.TOP);
		lbl2.setForeground(Color.BLACK);
		lbl2.setOpaque(true);
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl2.setBounds(549, 195, 420, 29);
		panel.add(lbl2);
		
		JLabel lblb2 = new JLabel("Carnivore and poisoned flowers are very dangerous and");
		lblb2.setVerticalAlignment(SwingConstants.TOP);
		lblb2.setForeground(Color.BLACK);
		lblb2.setOpaque(true);
		lblb2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblb2.setBounds(549, 220, 420, 29);
		panel.add(lblb2);
		
		JLabel lblb3 = new JLabel("bees should avoid them to accomplish the task. ");
		lblb3.setVerticalAlignment(SwingConstants.TOP);
		lblb3.setForeground(Color.BLACK);
		lblb3.setOpaque(true);
		lblb3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblb3.setBounds(549, 245, 420, 29);
		panel.add(lblb3);
		
		/*JLabel lblUnCombattantEst_1 = new JLabel("Un combattant est mort s'il rentre en collision avec ");
		lblUnCombattantEst_1.setVerticalAlignment(SwingConstants.TOP);
		lblUnCombattantEst_1.setForeground(Color.BLACK);
		lblUnCombattantEst_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnCombattantEst_1.setBounds(449, 365, 311, 29);
		panel.add(lblUnCombattantEst_1);*/
		
		JLabel lbl3 = new JLabel(" How to Play :");
		lbl3.setVerticalAlignment(SwingConstants.TOP);
		lbl3.setFont(new Font("Ancient", Font.PLAIN, 25));
		lbl3.setForeground(Color.MAGENTA);
		lbl3.setOpaque(true);
		lbl3.setBounds(640, 285, 160, 29);
		panel.add(lbl3);
		
		JLabel lbl4 = new JLabel("To start the game, press PLAY then select a number of ");
		lbl4.setVerticalAlignment(SwingConstants.TOP);
		lbl4.setForeground(Color.BLACK);
		lbl4.setOpaque(true);
		lbl4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	
		lbl4.setBounds(549, 320, 420, 29);
		panel.add(lbl4);
		
		JLabel lbl5 = new JLabel("flowers and bees to start with. Then press PLAY");
		lbl5.setVerticalAlignment(SwingConstants.TOP);
		lbl5.setForeground(Color.BLACK);
		lbl5.setOpaque(true);
		lbl5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	
		lbl5.setBounds(549, 345, 420, 29);
		panel.add(lbl5);
		
		JLabel lbls = new JLabel(" Now it is up to the bees to collect the nectar.The more");
		lbls.setVerticalAlignment(SwingConstants.TOP);
		lbls.setOpaque(true);
		lbls.setForeground(Color.BLACK);
		lbls.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbls.setBounds(549, 380, 420, 29);
		panel.add(lbls);
		

		JLabel lbl2s = new JLabel("nectar there is in the hive, the more bees are born.");
		lbl2s.setVerticalAlignment(SwingConstants.TOP);
		lbl2s.setOpaque(true);
		lbl2s.setForeground(Color.BLACK);
		lbl2s.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl2s.setBounds(549,405, 420, 29);
		panel.add(lbl2s);
		
		JLabel lbl3s = new JLabel("When all the nectar has been collected and no flowers left");
		lbl3s.setVerticalAlignment(SwingConstants.TOP);
		lbl3s.setOpaque(true);
		lbl3s.setForeground(Color.BLACK);
		lbl3s.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl3s.setBounds(549,430, 420, 29);
		panel.add(lbl3s);
		
		JLabel lbl4s = new JLabel("or when there are no more bees, the game ends. ");
		lbl4s.setVerticalAlignment(SwingConstants.TOP);
		lbl4s.setOpaque(true);
		lbl4s.setForeground(Color.BLACK);
		lbl4s.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl4s.setBounds(549,455, 420, 29);
		panel.add(lbl4s);

	/*	JLabel lbln = new JLabel("When all the nectar has been collected, or when there are \n no more bees, the game ends.");
		lbln.setVerticalAlignment(SwingConstants.TOP);
		lbln.setOpaque(true);
		lbln.setForeground(Color.BLACK);
		lbln.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbln.setBounds(549, 485, 420, 29);
		lbln.add(lbln);
		
		/*JLabel lblLeSeulClan = new JLabel("When all the nectar has been collected, or when there are no more bees, the game ends. ");
		lblLeSeulClan.setVerticalAlignment(SwingConstants.TOP);
		lblLeSeulClan.setForeground(Color.BLACK);
		lblLeSeulClan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLeSeulClan.setBounds(449, 487, 349, 29);
		panel.add(lblLeSeulClan);
		
		JLabel lblSignifie = new JLabel("> : signifie plus fort que");
		lblSignifie.setVerticalAlignment(SwingConstants.TOP);
		lblSignifie.setForeground(Color.BLACK);
		lblSignifie.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSignifie.setBounds(449, 424, 311, 29);
		panel.add(lblSignifie);
		
		*/
		
		
		
		
		
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
}

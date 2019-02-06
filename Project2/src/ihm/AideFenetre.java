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
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon icon = new ImageIcon("img/Button.png") ;  
		Image newimg = icon.getImage().getScaledInstance( 349, 80,  java.awt.Image.SCALE_SMOOTH ) ; 
		
		icon = new ImageIcon(newimg);
		btnNewButton.setIcon(icon);
		btnNewButton.setBounds(417, 536, 349, 62);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MainMenu();
			}
		});
		panel.setLayout(null);
		btnNewButton.setFont(new Font("Ancient", Font.PLAIN, 40));
		panel.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Vie :");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Ancient", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(665, 251, 53, 29);
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
		
		JLabel lblUnCombattantEst = new JLabel("Un combattant est n\u00E9 si deux combattants du m\u00EAme");
		lblUnCombattantEst.setVerticalAlignment(SwingConstants.TOP);
		lblUnCombattantEst.setForeground(Color.BLACK);
		lblUnCombattantEst.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnCombattantEst.setBounds(449, 279, 349, 29);
		panel.add(lblUnCombattantEst);
		
		JLabel lblClanEtDe = new JLabel("clan et de gendre diff\u00E9rent rentrent en collision");
		lblClanEtDe.setVerticalAlignment(SwingConstants.TOP);
		lblClanEtDe.setForeground(Color.BLACK);
		lblClanEtDe.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblClanEtDe.setBounds(449, 298, 349, 29);
		panel.add(lblClanEtDe);
		
		JLabel lblUnCombattantEst_1 = new JLabel("Un combattant est mort s'il rentre en collision avec ");
		lblUnCombattantEst_1.setVerticalAlignment(SwingConstants.TOP);
		lblUnCombattantEst_1.setForeground(Color.BLACK);
		lblUnCombattantEst_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnCombattantEst_1.setBounds(449, 365, 311, 29);
		panel.add(lblUnCombattantEst_1);
		
		JLabel lblUnCombattantDun = new JLabel("un combattant d'un autre clan plus fort que lui");
		lblUnCombattantDun.setVerticalAlignment(SwingConstants.TOP);
		lblUnCombattantDun.setForeground(Color.BLACK);
		lblUnCombattantDun.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnCombattantDun.setBounds(449, 384, 311, 29);
		panel.add(lblUnCombattantDun);
		
		JLabel lblTheBad = new JLabel("The Bad > The Good > The Ugly > The Bad");
		lblTheBad.setVerticalAlignment(SwingConstants.TOP);
		lblTheBad.setForeground(Color.BLACK);
		lblTheBad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTheBad.setBounds(449, 405, 311, 29);
		panel.add(lblTheBad);
		
		JLabel lblLeSeulClan = new JLabel("Le seul clan restant \u00E0 la fin est le gagnant");
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

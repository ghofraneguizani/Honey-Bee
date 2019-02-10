package ihm;

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

public class FinFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FinFenetre(Boolean foragersWin, int numbForagers, long numbPollen, int rounds) {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/menuu.jpg"));
		setTitle("Honey bee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1184, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 671);
		contentPane.add(panel);

		// le bouton pour revenir au menu
		JButton btnNewButton = new JButton();
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon icon = new ImageIcon("img/back.png");
		Image newimg = icon.getImage().getScaledInstance(149, 62, java.awt.Image.SCALE_SMOOTH);

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

		// Modifiez les valeurs données dans les strings pour les afficher à l'écran
		String foragers = Integer.toString(numbForagers);
		String pollen = Integer.toString((int) numbPollen);
		String roundsString = Integer.toString(rounds);

		// Différentes intitulés, selon le vainqueur
		if (foragersWin) {
			JLabel titel = new JLabel("The foregers won the game");
			titel.setVerticalAlignment(SwingConstants.TOP);
			titel.setOpaque(true);
			titel.setFont(new Font("Ancient", Font.PLAIN, 35));
			titel.setForeground(Color.MAGENTA);
			titel.setBounds(350, 100, 480, 45);
			panel.add(titel);
		} else {
			JLabel titel = new JLabel("The foregers lost the game");
			titel.setVerticalAlignment(SwingConstants.TOP);
			titel.setOpaque(true);
			titel.setFont(new Font("Ancient", Font.PLAIN, 35));
			titel.setForeground(Color.MAGENTA);
			titel.setBounds(350, 100, 480, 45);
			panel.add(titel);
		}
		// Les données sont affichées
		JLabel lblNewLabel_3 = new JLabel("Total foragers in the game : " + foragers);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setFont(new Font("Ancient", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setBounds(555, 251, 430, 35);
		panel.add(lblNewLabel_3);

		JLabel lblMort = new JLabel("Collected pollen : " + pollen);
		lblMort.setVerticalAlignment(SwingConstants.TOP);
		lblMort.setOpaque(true);
		lblMort.setForeground(Color.MAGENTA);
		lblMort.setFont(new Font("Ancient", Font.PLAIN, 25));
		lblMort.setBounds(555, 338, 430, 35);
		panel.add(lblMort);

		JLabel roundsInGame = new JLabel("Total rounds : " + roundsString);
		roundsInGame.setVerticalAlignment(SwingConstants.TOP);
		roundsInGame.setOpaque(true);
		roundsInGame.setForeground(Color.MAGENTA);
		roundsInGame.setFont(new Font("Ancient", Font.PLAIN, 25));
		roundsInGame.setBounds(555, 425, 430, 35);
		panel.add(roundsInGame);

		// image de fond
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		icon = new ImageIcon("img/backgroundFenetres.jpg");
		newimg = icon.getImage().getScaledInstance(1184, 671, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 1184, 671);
		panel.add(lblNewLabel);
		setVisible(true);
	}
}

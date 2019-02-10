package ihm;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Application;

public class MakeChoices extends JFrame {
	private static final long serialVersionUID = 1L;
	private int nbFleurs, nbBees;

	private JPanel contentPane;

	public MakeChoices() {
		setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/backgroundFenetres.jpg"));
		setBounds(new Rectangle(0, 0, 1184, 671));
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

		// Le nombre d'abeilles est déterminé
		JLabel label1 = new JLabel("Entrez le nombre d'abeilles (500 max)");
		label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label1.setBounds(600, 300, 390, 62);
		label1.setFont(new Font("Ancient", Font.PLAIN, 20));
		label1.setForeground(Color.white);

		JTextField text1 = new JTextField(10);
		text1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		text1.setBounds(600, 350, 390, 62);
		text1.setFont(new Font("Ancient", Font.PLAIN, 40));

		// le nombre de fleurs est déterminé
		JLabel label2 = new JLabel("Entrez le nombre de fleurs (500 max)");
		label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label2.setBounds(600, 400, 390, 62);
		label2.setFont(new Font("Ancient", Font.PLAIN, 20));
		label2.setForeground(Color.white);

		JTextField text2 = new JTextField(10);
		text2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		text2.setBounds(600, 450, 390, 62);
		text2.setFont(new Font("Ancient", Font.PLAIN, 40));

		// La simulation est lancée
		JButton b2 = new JButton();
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.setFocusPainted(false);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		ImageIcon icon = new ImageIcon("img/play1.png");
		Image newimg = icon.getImage().getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		b2.setIcon(icon);
		b2.setBounds(600, 520, 349, 62);
		b2.setFont(new Font("Ancient", Font.PLAIN, 40));
		b2.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				nbBees = Integer.parseInt(text1.getText());
				nbFleurs = Integer.parseInt(text2.getText());
				// Contrôle d'entrée
				if (nbFleurs > 500 && nbBees >= 500) {
					text1.setText("");
					text2.setText("");
					nbBees = (Integer) null;
					nbFleurs = (Integer) null;
				} else if (nbBees > 500) {
					text1.setText("");
					nbFleurs = (Integer) null;
				}
				if (nbFleurs > 500) {
					text2.setText("");
					nbBees = (Integer) null;
				}

				Application a = new Application();
				a.create(nbFleurs, nbBees);

				a.getFrame().repaint();

			}

		});

		panel.setLayout(null);

		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);

		panel.add(b2);

		// fond d'écran
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

	public int getNbFleurs() {
		return nbFleurs;
	}

	public int getNbBees() {
		return nbBees;
	}

}

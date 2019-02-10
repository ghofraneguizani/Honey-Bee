package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import models.Flowers.Flowerstate;

public class Interface extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private Thread t;
	private Application a;

	ImageIcon backgroundImg = new ImageIcon("img/champ.png");
	ImageIcon img = new ImageIcon("img/icons8-abeille-48.png");
	ImageIcon imgc = new ImageIcon("img/carnivore.png");
	ImageIcon imge = new ImageIcon("img/poisenned.png");
	ImageIcon imgn = new ImageIcon("img/normal.png");

	ImageIcon imgvieu = new ImageIcon("img/deadBee.png");
	ImageIcon imgdf = new ImageIcon("img/deadFlower3.png");

	public Interface(Application a) {
		this.a = a;
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Thread(this);
		t.start();
		setBounds(0, 0, 1184, 671);

	}

	public void draw() {

	}

	// Méthode pour trouver le centre de la fenêtre
	public Point getCenter() {
		return new Point(this.getWidth() / 2, this.getHeight() / 2);
	}

	// la méthode qui affiche tout sur l'écran
	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 1184, 671);

		g2.drawImage(backgroundImg.getImage(), 0, 0, 1184, 671, null);

		// objets non pertinents dans le jeu
		g2.drawImage((Image) new ImageIcon("img/icons8-tuyau-d'arrosage-48.png").getImage(), 100, 150, 100, 100, null);
		g2.drawImage((Image) new ImageIcon("img/icons8-cactus-48.png").getImage(), 500, 150, 100, 100, null);
		g2.drawImage((Image) new ImageIcon("img/icons8-arrosoir-48.png").getImage(), 800, 505, 100, 100, null);

		// les abeilles mortes
		for (int i = 0; i < Hive.lForagerMorts.size(); i++) {
			g2.drawImage((Image) imgvieu.getImage(), Hive.lForagerMorts.get(i).getPosition().x,
					Hive.lForagerMorts.get(i).getPosition().y, 30, 30, null);
		}
		// le ruche
		g2.drawImage((Image) new ImageIcon("img/icons8-ruche-480.png").getImage(), this.getWidth() / 2 - 50,
				this.getHeight() / 2 - 50, 200, 200, null);
		// les fleurs vivantes
		for (int i = 0; i < Garden.fleurs.size(); i++) {
			if (Garden.fleurs.get(i).getState().equals(Flowerstate.carnivore)) {
				g2.drawImage((Image) imgc.getImage(), Garden.fleurs.get(i).getPosition().x,
						Garden.fleurs.get(i).getPosition().y, null);
			} else if (Garden.fleurs.get(i).getState().equals(Flowerstate.normal)) {
				g2.drawImage((Image) imgn.getImage(), Garden.fleurs.get(i).getPosition().x,
						Garden.fleurs.get(i).getPosition().y, null);
			} else {
				g2.drawImage((Image) imge.getImage(), Garden.fleurs.get(i).getPosition().x,
						Garden.fleurs.get(i).getPosition().y, null);
			}

		}
		// les fleurs mortes
		for (int i = 0; i < Garden.fleursMortes.size(); i++) {
			g2.drawImage((Image) imgdf.getImage(), Garden.fleursMortes.get(i).getPosition().x,
					Garden.fleursMortes.get(i).getPosition().y, 30, 30, null);
		}

		// les abeilles vivantes
		for (int i = 0; i < Hive.lForager.size(); i++) {
			// si les abeilles sont dans la ruche, elles ne doivent pas être vues
			if (Hive.lForager.get(i).getPosition().x == 612 && Hive.lForager.get(i).getPosition().y == 395) {

			} else {

				g2.drawImage((Image) img.getImage(), Hive.lForager.get(i).getPosition().x,
						Hive.lForager.get(i).getPosition().y, null);
			}

		}
		// Calcul du prochain tour de jeu
		a.nextFrame();
		try {
			Thread.sleep(100L);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		// une courte pause pour s'assurer que toutes les données du jeu sont calculées
		try {
			Thread.sleep(300L);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// La boucle pour maintenir la simulation de jeu en cours d'exécution
		while (a.garden.ruche.getlForager().size() != 0 && Garden.getFleurs().size() != 0) {
			repaint();
			// Pause pour assurer la présentation des données de chaque tour
			try {
				Thread.sleep(100L);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}

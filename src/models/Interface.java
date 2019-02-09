package models;

/*
 * to do : private static final int liveTime	done
 * if foragerWin boolean						done
 * modern design
 * control int in the beginning
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ihm.AideFenetre;
import ihm.MakeChoices;
import models.Flowers.Flowerstate;
import models.Forager.foragerState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements Runnable {

	private Thread t;
	private Application a;

	// private static final long serialVersionUID = 1L; // necessaire ???
	// protected int NumFrame = 1;
	// private Panneau panneau;
	// private int counter;
	// public MakeChoices m = new MakeChoices();

	ImageIcon backgroundImg = new ImageIcon("img/champ.png");
	ImageIcon img = new ImageIcon("img/icons8-abeille-48.png");
	ImageIcon imgc = new ImageIcon("img/carnivore.png");
	ImageIcon imge = new ImageIcon("img/poisenned.png");
	ImageIcon imgn = new ImageIcon("img/normal.png");
	
	ImageIcon imgvieu = new ImageIcon("img/viee.png");
	ImageIcon imgdf = new ImageIcon("img/deadFlower3.png");

	public Interface(Application a) {
		this.a = a;
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Thread(this);
		t.start();
		// alication a = new alication();
		// a.create(m.getNbFleurs(),m.getNbBees());
		// panneau = new Panneau(a);
		setBounds(0, 0, 1184, 671);
		// add(panneau);

		/*
		 * while (counter<50) { System.out.println(); System.out.println("ROUND: " +
		 * counter); System.out.println(); // //a.nextFrame(); counter++; }
		 */

		// new Interface(nbFleurs,nbBees);
		// new JeuFenetre(a);

	}

//	public Interface(int NumFrame) {
//		 this.NumFrame = NumFrame;
//
//	}

	public void draw() {

	}

	public Point getCenter() {
		return new Point(this.getWidth() / 2, this.getHeight() / 2);
	}

	public void paint(Graphics g) {
		System.out.println("we are in the method paint");

		// super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 1184, 671);

		// backgroundImg.paintIcon(null, g, 0, 0);

		g2.drawImage(backgroundImg.getImage(), 0, 0, 1184, 671, null);

		
		g2.drawImage((Image) new ImageIcon("img/icons8-tuyau-d'arrosage-48.png").getImage(), 100, 150, 100, 100, null);

		g2.drawImage((Image) new ImageIcon("img/icons8-cactus-48.png").getImage(), 500, 150, 100, 100, null);
		g2.drawImage((Image) new ImageIcon("img/icons8-arrosoir-48.png").getImage(), 800, 505, 100, 100, null);


		for (int i = 0; i < a.ruche.lForagerMorts.size(); i++) {
			System.out.println("in the loop for dead bees : " + a.ruche.lForagerMorts.size() + " / " + i);
			g2.drawImage((Image) imgvieu.getImage(), a.ruche.lForagerMorts.get(i).getPosition().x,
					a.ruche.lForagerMorts.get(i).getPosition().y, 30, 30, null);
		}
		g2.drawImage((Image) new ImageIcon("img/icons8-ruche-480.png").getImage(), this.getWidth() / 2 - 50,
				this.getHeight() / 2 - 50, 200, 200, null);
		
		for (int i = 0; i < a.garden.fleurs.size(); i++) {

			// System.out.println(a.garden.fleurs.size());
			if (a.garden.fleurs.get(i).getState().equals(Flowerstate.carnivore)) {
				g2.drawImage((Image) imgc.getImage(), a.garden.fleurs.get(i).getPosition().x,
						a.garden.fleurs.get(i).getPosition().y, null);
			} else if (a.garden.fleurs.get(i).getState().equals(Flowerstate.normal)) {
				g2.drawImage((Image) imgn.getImage(), a.garden.fleurs.get(i).getPosition().x,
						a.garden.fleurs.get(i).getPosition().y, null);
			} else {
				g2.drawImage((Image) imge.getImage(), a.garden.fleurs.get(i).getPosition().x,
						a.garden.fleurs.get(i).getPosition().y, null);
			}

		}
		
		for (int i = 0; i < a.garden.fleursMortes.size(); i++) {
			g2.drawImage((Image) imgdf.getImage(), a.garden.fleursMortes.get(i).getPosition().x,
					a.garden.fleursMortes.get(i).getPosition().y, 30, 30, null);

			// System.out.println(a.garden.fleurs.size());
//			if (a.garden.fleursMortes.get(i).getState().equals(Flowerstate.carnivore)) {
//				g2.drawImage((Image) imgdf.getImage(), a.garden.fleursMortes.get(i).getPosition().x,
//						a.garden.fleursMortes.get(i).getPosition().y, 30, 30, null);
//			} else if (a.garden.fleursMortes.get(i).getState().equals(Flowerstate.normal)) {
//				g2.drawImage((Image) imgdf.getImage(), a.garden.fleursMortes.get(i).getPosition().x,
//						a.garden.fleursMortes.get(i).getPosition().y, 30, 30, null);
//			} else {
//				g2.drawImage((Image) imgdf.getImage(), a.garden.fleursMortes.get(i).getPosition().x,
//						a.garden.fleursMortes.get(i).getPosition().y, 30, 30, null);
//			}

		}
		
		
		for (int i = 0; i < a.ruche.lForager.size(); i++) {
			// System.out.println("painting bees, position test : " +
			// a.ruche.lForager.get(i).getPosition() +" / " + a.ruche.positionHiveDoor);
			// if (a.ruche.lForager.get(i).getPosition().equals(a.ruche.positionHiveDoor)) {
			// System.out.println("in the pool, but at the door");
			//
			// } else {

			g2.drawImage((Image) img.getImage(), a.ruche.lForager.get(i).getPosition().x,
					a.ruche.lForager.get(i).getPosition().y, null);
			// }

		}
		a.nextFrame();
//		try {
//			a.wait();
//
//		} catch (Exception e) {
//			System.out.println("ok");
//		}
//
//		try {
//
//			Thread.sleep(84L);
//
//		} catch (Exception e) {
//			System.out.println("ok");
//		}

	}

	@Override
	public void run() {
		try {
			Thread.sleep(300L);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("we are before entering the while loop!!!!!!!!!!");
	
		int temp = 0;
		while (a.garden.ruche.getlForager().size() != 0 &&  a.garden.getFleurs().size()!= 0) {
//		while (temp<2) {
			repaint();

			try {
				Thread.sleep(84L);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("no sleep");
			}


			temp++;
		}
	}

}

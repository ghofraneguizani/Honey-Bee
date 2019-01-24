package project;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // necessaire ???
	protected int NumFrame = 1;
	// static ArrayList<Point> l ;
	private Panneau panneau;

	public Interface() {
		panneau = new Panneau(new Dimension(600, 400));
		setSize(600, 400);
		add(panneau);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public Interface(int NumFrame) {
		this.NumFrame = NumFrame;

	}

	public void draw() {

	}

	public Point getCenter() {
		return new Point(this.getWidth() / 2, this.getHeight() / 2);
	}

	private class Panneau extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L; // necessaire??

		public Panneau(Dimension dim) {
			this.setSize(dim);
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			String fichier = "img/menu.png";
			FontMetrics fm = g.getFontMetrics(); // necessaire???

			try {
				BufferedImage img = ImageIO.read(new File(fichier));
				g.drawImage(img, 0, 0, 600, 373, null);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}

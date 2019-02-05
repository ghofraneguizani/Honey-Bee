package project;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface extends JFrame {

	
	 private JMenuBar menuBar = new JMenuBar();

	 private JMenu animation = new JMenu("Animation"),

			    forme = new JMenu("Forme");




			  private JMenuItem lancer = new JMenuItem("Lancer l'animation"),

			    arreter = new JMenuItem("Arrêter l'animation"),

			    quitter = new JMenuItem("Quitter"),

			    aProposItem = new JMenuItem("?");



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // necessaire ???
	protected int NumFrame = 1;
	// static ArrayList<Point> l ;
	private Panneau panneau;

	
	public Interface() {
		panneau = new Panneau(new Dimension(600, 400));
		this.initMenu();
		setSize(600, 400);
		add(panneau);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}
	private void initMenu(){
	    //Menu animation
	    animation.add(lancer);
	    arreter.setEnabled(false);
	    animation.add(arreter);
	    animation.addSeparator();
	    //Pour quitter l'application
	    quitter.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){
	        System.exit(0);
	      }
	    });
	    
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
			System.out.println(fichier);
			FontMetrics fm = g.getFontMetrics(); // necessaire???

			try {
				BufferedImage img = ImageIO.read(new File(fichier));
				g.drawImage(img, 30, 30, 100, 173, null);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}

package models;

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
import ihm.MainMenu;
import ihm.MakeChoices;
import models.Flowers.Flowerstate;
import models.Forager.foragerState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*public class Interface extends JFrame implements Runnable {

	
	
	private static final long serialVersionUID = 1L; // necessaire ???
	protected int NumFrame = 1;
	private Panneau panneau;
	private int counter; 
	public MakeChoices m = new MakeChoices();
	private  Application a ; 
	private Thread t;


	public Interface(Application a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Thread(this);
		t.start();
	//	alication a = new alication(); 
		//a.create(m.getNbFleurs(),m.getNbBees());
		panneau = new Panneau(a);
		setBounds(0,0, 1184, 671);
		add(panneau);
		
		
		
		this.a=a;
		
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
		//Application a;
		ImageIcon backgroundImg = new ImageIcon("img/champ.png"); 
		ImageIcon img = new ImageIcon("img/icons8-abeille-48.png");
		ImageIcon imgc = new ImageIcon("img/carnivore.png");
		ImageIcon imge = new ImageIcon("img/poisenned.png");
		ImageIcon imgn = new ImageIcon("img/normal.png");
		private final JLabel label = new JLabel("");
		private JButton b = new JButton("start");
		
		public Panneau(Application a ){
			this.setBounds(0,0, 1184, 671);
		   
		    setIconImage(Toolkit.getDefaultToolkit().getImage("img/champ.png"));
			//setBounds(0, 0, 1184, 671);
			add(b);
			b.addActionListener (new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
				
		
		
			

			});
		}
			
		protected void paintComponent(Graphics g) {
				
			//super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			
			backgroundImg.paintIcon(null, g2, 0, 0);
			g2.drawImage((Image)new ImageIcon("img/icons8-ruche-480.png").getImage(),this.getWidth()/2-50,this.getHeight()/2-50, 200 , 200,null);
			g2.drawImage((Image)new ImageIcon("img/icons8-tuyau-d'arrosage-48.png").getImage(),100,150,100 , 100,null);

			g2.drawImage((Image)new ImageIcon("img/icons8-cactus-48.png").getImage(),500,150, 100 , 100,null);
			g2.drawImage((Image)new ImageIcon("img/icons8-arrosoir-48.png").getImage(),800,505, 100 , 100,null);

		
			for (int i = 0; i < a.ruche.lForager.size(); i++) {
				g2.drawImage((Image)img.getImage(),  a.ruche.lForager.get(i).getPosition().x,
						 a.ruche.lForager.get(i).getPosition().y, null);
			}
			for (int i = 0; i < a.garden.fleurs.size(); i++) {
				
			//	System.out.println(a.garden.fleurs.size());
				if(a.garden.fleurs.get(i).getState().equals(Flowerstate.carnivore)){
					g2.drawImage((Image)imgc.getImage(),  a.garden.fleurs.get(i).getPosition().x,
							 a.garden.fleurs.get(i).getPosition().y, null);	
				}else if (a.garden.fleurs.get(i).getState().equals(Flowerstate.normal)){
					g2.drawImage((Image)imgn.getImage(),   a.garden.fleurs.get(i).getPosition().x,
							 a.garden.fleurs.get(i).getPosition().y, null);
				}else{
					g2.drawImage((Image)imge.getImage(),   a.garden.fleurs.get(i).getPosition().x,
							 a.garden.fleurs.get(i).getPosition().y, null);	
				}
				
				
				
			}
			
			
			}
		
		
			
		
			
		}
		
@Override
public void run() {
	
	while (true) {

	
	a.nextFrame();
	
//	
	try {
		//a.wait(40);
		Thread.sleep(40);
	} catch (Exception e) {
		
		System.out.println("ok");
	}
	repaint();
	//counter++;

	}

}
	
	
	
	
}
}*/


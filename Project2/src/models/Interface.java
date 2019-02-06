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
import ihm.MakeChoices;
import models.Flowers.Flowerstate;
import models.Forager.foragerState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface extends JFrame {

	
	
	private static final long serialVersionUID = 1L; // necessaire ???
	protected int NumFrame = 1;
	private Panneau panneau;
	private int counter; 
	public MakeChoices m = new MakeChoices();
	private Application a ; 

	
	public Interface(Application a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	alication a = new alication(); 
		//a.create(m.getNbFleurs(),m.getNbBees());
		panneau = new Panneau(a);
		setBounds(0,0, 1184, 671);
		add(panneau);
		
		/* while (counter<50) {
		 System.out.println();
		 System.out.println("ROUND: " + counter);
		 System.out.println();
		//
		//a.nextFrame();
		 counter++;
		 }*/

		//new Interface(nbFleurs,nbBees);
		//new JeuFenetre(a);
		
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
			setBounds(0, 0, 1184, 671);
			add(b);
			b.addActionListener (new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					while (a.garden.getFleurs().size() != 0 && a.garden.ruche.getlForager().size() != 0) {
					
					
						a.nextFrame();
						

						System.out.println(" je suis la : " + a.garden.getRuche().lForager.get(0));
						
//						dessiner(a);
						try {
							//Thread.sleep(40);
							a.wait(100000);
							
						} catch (Exception e) {
							// TODO: handle exception
							//System.out.println("ok");
						}
						
						System.out.println("ok");
						repaint();
						
						counter++;
					
					}
					
				
				}
				
			

			});
		}
			
		protected void paintComponent(Graphics g) {
				
			super.paintComponent(g);
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
		
		
			
			
			/*label.setIcon(new ImageIcon("img/champ.png"));
			label.setBounds(0, 0,  1184, 671);
			add(label);*/
			
		}
		

	
	
	
	

}

package models;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.Flowers.Flowerstate;



public class Interface extends JFrame implements Runnable {

	
	
//	private static final long serialVersionUID = 1L; // necessaire ???
	private Thread t; 
//	private Panneau panneau;
	//private int counter; 
	
	private  Application a ; 
	
	ImageIcon backgroundImg = new ImageIcon("img/champ.png"); 
	ImageIcon img = new ImageIcon("img/icons8-abeille-48.png");
	ImageIcon imgc = new ImageIcon("img/carnivore.png");
	ImageIcon imge = new ImageIcon("img/poisenned.png");
	ImageIcon imgn = new ImageIcon("img/normal.png");
	
	ImageIcon imgm = new ImageIcon("img/deedbee.jpg");
	ImageIcon imgvieu = new ImageIcon("img/viee.png");


	public Interface(Application a) {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Thread(this);
		t.start();
		setBounds(0,0, 1184, 671);
		
		  //ImageIcon  icon = new ImageIcon("img/champ.png") ;  
		  //Image newimg = icon.getImage().getScaledInstance( 200,50,  java.awt.Image.SCALE_SMOOTH ) ; 
		  //setIconImage(newimg);
		
		
		
		
		this.a=a;
		
	}
	


	/*public Interface(int NumFrame) {
		this.NumFrame = NumFrame;

	}

	public void draw() {

	}

	public Point getCenter() {
		return new Point(this.getWidth() / 2, this.getHeight() / 2);
	}*/
	public Point getCenter() {
		return new Point(this.getWidth() / 2, this.getHeight() / 2);
	}

	
		
		
		
	
			
		public void paint(Graphics g) {
				
		//super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.black);
			g2.fillRect(0,0, 1184, 671);
			
			//backgroundImg.paintIcon(null, g, 0, 0);
			
			g2.drawImage(backgroundImg.getImage(),0,0,1184, 671,null);

			
			
			g2.drawImage((Image)new ImageIcon("img/icons8-ruche-480.png").getImage(),this.getWidth()/2-50,this.getHeight()/2-50, 200 , 200,null);
			g2.drawImage((Image)new ImageIcon("img/icons8-tuyau-d'arrosage-48.png").getImage(),100,150,100 , 100,null);

			g2.drawImage((Image)new ImageIcon("img/icons8-cactus-48.png").getImage(),500,150, 100 , 100,null);
			g2.drawImage((Image)new ImageIcon("img/icons8-arrosoir-48.png").getImage(),800,505, 100 , 100,null);

		
			
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
			for (int i = 0; i < a.ruche.lForager.size(); i++) {
				
				if(a.ruche.lForager.get(i).isalive){
					
						g2.drawImage((Image)img.getImage(),  a.ruche.lForager.get(i).getPosition().x,
								 a.ruche.lForager.get(i).getPosition().y, null);
					}
			
				else{ 
					g2.drawImage((Image)imgvieu.getImage(),  a.ruche.lForager.get(i).getPosition().x,
							 a.ruche.lForager.get(i).getPosition().y,30,30, null);
					}
					
				
			}
			a.nextFrame();
			try {
				a.wait();
				
				
			} catch (Exception e) {
				System.out.println("ok");
			}
			
			try {
				t.sleep(84L);
				
				
			} catch (Exception e) {
				System.out.println("ok");
			}
			
			
			
			}
		
		
		
			@Override
			public void run() {
				
				
				while(a.garden.ruche.getlForager().size() < 2 &&  a.garden.getFleurs().size()!= 0 ){

					repaint();
				
					
				}
				try {
					Thread.sleep(200L);
				} catch (Exception e) {
					
				}
				
				
				
				
			}
					
				
				
				
				
					
					

					
					
					
					

					

				
			
			
	
		
		



	

	
	
	

}

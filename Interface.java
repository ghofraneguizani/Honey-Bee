package project;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Interface  extends JFrame{
	protected int NumFrame=1;
	//static  ArrayList<Point> l ; 
	private Panneau panneau; 
	
	
	public Interface() {
		panneau = new Panneau();
		setSize(600,400);
		add(panneau);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}
	public  Interface(int NumFrame){
		this.NumFrame=NumFrame;
	
	}
	
	public void draw(){
		
	}
	public Point getCenter(){
		return new Point(this.getWidth()/2,this.getHeight()/2);
	}
	
		
	
	private class Panneau extends JPanel{
		public Panneau(){
			
		}
		
		
	}

}

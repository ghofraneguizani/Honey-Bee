package project;

import java.awt.Frame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import project.Flowers.Flowerstate;


public class Garden {
	protected static ArrayList<Flowers> fleurs ;
	protected Hive ruche; 
	private Point point; 
	

	public Garden() {
		fleurs = new ArrayList<>();
		point =new Point();
	}
	
	public Garden(Hive ruche) {
	
		this.ruche = ruche;
		
	}
	public void addFlower(Flowers f){
		fleurs.add(f);
	}
	
	public Point getPosition(int width, int height){
		Point p ;
		Random rand = new Random();
		int x= rand.nextInt(width);
		int y= rand.nextInt(height);
		p= new Point(x,y);
	
		return p;
		
	}
	
	public Boolean existe(Point po){
		for (Flowers flower : fleurs) {
			if(flower.getPosition().equals(po)){
				return true;
			} 
		}
		return false;
		
	}
	public int getState(int nbFlowers){
		return ((10*nbFlowers) /100);
		
	}
	
	public void create(int nbFlowers,int width, int height){
		boolean condition;
		Flowers f; 
		
		
		for (int i = 0; i < nbFlowers; i++) {
			point= getPosition(30,30);
			condition = existe(point);
			if(condition){
				point= getPosition(30,30);
			}
			f=new Flowers(point,Flowerstate.normal, true,0, "imahe");
			fleurs.add(f);
		}
		
		int s= getState(nbFlowers);
		for (int i = 0; i <s; i=i+2) {
			fleurs.get(i).setState(Flowerstate.carnivore);
			fleurs.get(i+1).setState(Flowerstate.poisoned);
			
		}
		
	
			
		
	}

	public void nextFrame(){//minuteSuivante
		this.ruche.nextFrame(); 
	}
	

}

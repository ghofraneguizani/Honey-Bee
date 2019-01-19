package com.polytech.projet.classes;

import java.awt.Frame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

import com.polytech.projet.classes.Forager.foragerState;

public class Application {
	
	final static double vitesse=0.04;// m/frame
	final static int nectarPerFrame=1;
	final static int MaxNectar=10;
	
	private Garden jarda; 
	protected Interface frame;
	protected Hive ruche;
	

	public Application(  ) {
		frame= new Interface();
		jarda = new Garden();
		ruche = new Hive();
		
		 
	}
	
	public Garden getGarden() {
		return jarda;
	}

	public Interface getFrame() {
		return frame;
	}

	public Hive getRuche() {
		return ruche;
	}

	public void load(String path){
		// charger le fichier d'initialisation :
			//read the file 
			//parse it ( le convertir en objet java)
			//fill object
	}
	
	
	// ou creer les objet 
	public void create(int nbFlowers,int nbBees){
		// creation d'objet 
		this.jarda.create(nbFlowers, this.frame.getWidth(), this.frame.getHeight());
		
		//garden.create(nbFlowers,frame.getWidth(),frame.getHeight());
		//System.out.println("ok");
		this.jarda.ruche.create(nbBees);
	//	this.jarda.ruche = new Hive(0,frame.getCenter());

	}
	
	public void nextFrame(){// = minuteSuivante permet de simuler le passage d'une frame a une autre 
		this.jarda.nextFrame();
		//this.frame.draw();//12 frames par secondes
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Forager> f = new ArrayList<>();
		
		
		System.out.println("donner le nombre de Fleurs ? ");
		Scanner as = new Scanner(System.in);
		int NbFlowers= as.nextInt();
		System.out.println("donner le nombre d'abeilles? ");
		int NbBees=as.nextInt();
		
		Application a= new Application() ; 
		
		a.create(NbFlowers, NbBees);
		
		while(!(NbFlowers== 0 || NbBees== 0) ){
			
			a.nextFrame();
			for (int i = 0; i <a.jarda.ruche.lForager.size(); i++) {
				System.out.println(a.jarda.ruche.lForager.get(i));
			}
			
		}
		
		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Garden g = new Garden();
		g.create(NbFlowers, 30,30);
		for (int i = 0; i <Garden.fleurs.size(); i++) {
			System.out.println(Garden.fleurs.get(i));
		}
		
		Hive h= new Hive();
		
		
		
		
		
		h.create(NbBees);
		for (int i = 0; i <h.lForager.size(); i++) {
			System.out.println(h.lForager.get(i));
		}
		//ArrayList<Forager> f = new ArrayList<>();
		*/
		
		//System.out.println(f.size());
	
	}

}

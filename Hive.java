package com.polytech.projet.classes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.polytech.projet.classes.Flowers.Flowerstate;
import com.polytech.projet.classes.Forager.foragerState;

public class Hive {
	private long pollen; 
	protected static ArrayList<Forager> lForager ;
	protected Garden garden;
	protected  Point positionHive ;

	public Hive() {
		lForager = new ArrayList<>();
		
	}
	public Hive(long pollen,Point positionHive) {
		this.pollen = pollen;
		this.positionHive= positionHive;
	}

	public long getPollen() {
		return pollen;
	}

	public void setPollen(long pollen) {
		this.pollen = pollen;
	}
	
	

	public Point getPositionHive() {
		return positionHive;
	}
	public void setPositionHive(Point positionHive) {
		this.positionHive = positionHive;
	}
	public List<Forager> getlForager() {
		return lForager;
	}

	public void setlForager(ArrayList<Forager> lForager) {
		this.lForager = lForager;
	}
	
	
	public void incrementerPollen(int cap){
		setPollen( getPollen()+cap );
	}
	
	public void create(int nbBees){
		Flowers fleur=new Flowers();
		
		for (int i = 0; i < nbBees; i++) {
			fleur= findFlower();
			Forager f = new Forager(foragerState.lookfor, fleur, true, new Point(0,0), 0,this);
			lForager.add(f);
		}
	}
	
	public Flowers  findFlower(){// algo qui va retourner la position des fleurs 
		
		int taille= Garden.fleurs.size();
		Random rand = new Random();
		int n = rand.nextInt(taille-1);
		return Garden.fleurs.get(n) ; 
		
	}
	public void nextFrame(){
		for (Forager forager : lForager) {
			if(forager.isalive == true){
				forager.nextFrame();
			}
		}
	}

	
	

}

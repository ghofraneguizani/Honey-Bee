package com.polytech.projet.classes;

import java.util.ArrayList;
import java.util.List;

public class Hive {
	private long pollen; 
	protected List<Forager> lForager ; 

	public Hive() {
		lForager = new ArrayList<>();
	}
	public Hive(long pollen) {
		this.pollen = pollen;
	}

	public long getPollen() {
		return pollen;
	}

	public void setPollen(long pollen) {
		this.pollen = pollen;
	}

	public List<Forager> getlForager() {
		return lForager;
	}

	public void setlForager(List<Forager> lForager) {
		this.lForager = lForager;
	}
	public void incrementerPollen(int cap){
		setPollen( getPollen()+cap );
	}
	public void minuteSuivante(){
		for (Forager buti : lForager) {
			if(buti.getState().equals("lookfor")){
				//search flowers 
			}
		}
	}

	
	

}

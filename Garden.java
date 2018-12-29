package com.polytech.projet.classes;

import java.util.ArrayList;
import java.util.List;

public class Garden {
	protected  List<Flowers> fleurs ;
	private Hive ruche; 
	

	public Garden() {
		fleurs = new ArrayList<>();
		
	}
	
	public Garden(Hive ruche) {
	
		this.ruche = ruche;
		
	}

	public void minuteSuivante(){
		//a  implementer 
	}

}

package models;

import models.Garden;
import models.Hive;

public class Application {

	final static double vitesse = 20;// m/frame
	final static int nectarPerFrame = 1;
	final static int MaxNectar = 10;

	public Garden garden;
	public Interface frame;
	public Hive ruche;

	public Application() {
		frame = new Interface(this);
		garden = new Garden();
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public Interface getFrame() {
		return frame;
	}

	public void setFrame(Interface frame) {
		this.frame = frame;
	}

	public Hive getRuche() {
		return ruche;
	}

	public void setRuche(Hive ruche) {
		this.ruche = ruche;
	}

	// ou creer les objet
	public void create(int nbFlowers, int nbBees) {
		// creation d'objet
		garden.createFlowers(nbFlowers, frame.getWidth(), frame.getHeight());
		garden.ruche = new Hive(garden, frame.getCenter());
		garden.ruche.createForagers(nbBees);

	}

	public void nextFrame() { // = minuteSuivante permet de simuler le passage d'une frame a une autre
		this.garden.nextFrame();
	}

}

package models;

import java.util.Random;
import java.util.Scanner;

import ihm.MakeChoices;
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

	public void nextFrame() {// = minuteSuivante permet de simuler le passage d'une frame a une autre
		System.out.println("|||we are in the aplication|||");
		this.garden.nextFrame();
		System.out.println("|||here is the end of nextFrame|||");
		// this.frame.repaint();//12 frames par secondes
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("donner le nombre de Fleurs ? "); Scanner as = new
	 * Scanner(System.in); int NbFlowers = as.nextInt();
	 * System.out.println("donner le nombre d'abeilles? "); int NbBees =
	 * as.nextInt(); as.close(); Application a = new Application(); // // a.frame =
	 * new Interface(); // not necessaire a.createApplication(NbFlowers, NbBees);
	 * int counter = 1; while (!(a.garden.getFleurs().size() == 0 ||
	 * !(a.garden.ruche.getlForager().size() == 0))) {
	 * 
	 * System.out.println(); System.out.println("ROUND: " + counter);
	 * System.out.println(); a.nextFrame(); // dessiner(a); try { a.wait(40); }
	 * catch (Exception e) { // TODO: handle exception System.out.println("ok"); }
	 * 
	 * //counter++; }
	 */
	// while (counter<50) {
	// System.out.println();
	// System.out.println("ROUND: " + counter);
	// System.out.println();
	//
	// a.nextFrame();
	// counter++;
	// }

	// System.out.println("before fight:");
	// for (Forager temp : a.garden.ruche.getlForager())
	// System.out.println(temp.getPosition());
	// Forager f = a.garden.ruche.getlForager().get(4);
	// for (Forager forager : a.garden.ruche.getlForager()) {
	// System.out.println("surch fight"+counter);
	// if ( f.getPosition().equals(forager.getPosition())
	// && !f.equals(forager)) {
	// System.out.println("fight begins");
	// f.fightOfForager(forager);
	// }
	// System.out.println("surching forager: "+f.getPosition());
	// System.out.println("compared forager: "+forager.getPosition());
	// }
	// System.out.println("after fight");
	// for (Forager temp : a.garden.ruche.getlForager())
	// System.out.println(temp);

	// Random rand = new Random();
	// int n = rand.nextInt(3);
	// System.out.println(n);
	//

	// Garden g = new Garden();
	// g.createFlowers(16, 4,4);
	// for (int i = 0; i <g.fleurs.size(); i++) {
	// System.out.println(g.fleurs.get(i));
	// }
	//
	// Hive h= new Hive();
	// h.createForagers(5);
	// for (int i = 0; i <h.lForager.size(); i++) {
	// System.out.println(h.lForager.get(i));
	// }

	// Application app= new Application();
	// int numFrame = app.frame.NumFrame;
	// app.create(NbFlowers,NbBees);
	// frame=1; // commence avec la premi�re frame
	// numFrame=1;
	// //app.nextFrame();
	// sleep(40);//en ms / il faut trouver la fonction qui permet de faire wait
	//
	// numFrame ++;

	// }

}

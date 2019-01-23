package project;

import java.util.Scanner;

public class Application {

	final static double vitesse = 0.04;// m/frame
	final static int nectarPerFrame = 1;
	final static int MaxNectar = 10;

	protected Garden garden;
	protected Interface frame;

	public Application() {
		frame = new Interface();
		garden = new Garden();
	}

	public void load(String path) {
		// charger le fichier d'initialisation :
		// read the file
		// parse it ( le convertir en objet java)
		// fill object
	}

	public void save(String Path) {

	}

	// ou creer les objet
	public void createApplication(int nbFlowers, int nbBees) {
		// creation d'objet
		garden.createFlowers(nbFlowers, frame.getWidth(), frame.getHeight());
		garden.ruche.createForagers(nbBees);
		garden.ruche = new Hive(garden, frame.getCenter());

	}

	public void nextFrame() {// = minuteSuivante permet de simuler le passage d'une frame a une autre
		this.garden.nextFrame();
		// this.frame.draw();//12 frames par secondes
	}

	public static void main(String[] args) {

		System.out.println("donner le nombre de Fleurs ? ");
		Scanner as = new Scanner(System.in);
		int NbFlowers = as.nextInt();
		System.out.println("donner le nombre d'abeilles? ");
		int NbBees = as.nextInt();
		as.close();
		Application a = new Application();
		a.frame = new Interface();
		a.createApplication(NbFlowers, NbBees);
		while (!(NbFlowers == 0 || NbBees == 0)) {

			a.nextFrame();
		}

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

	}

}

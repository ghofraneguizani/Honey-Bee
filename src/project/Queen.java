package project;

import java.awt.Point;

public class Queen extends Bees {
	// private int minute;
	private Hive ruche;

	private long pollen = 0;

	private int newForagers = 0;

	public Queen(Hive ruche) {
		// TODO Auto-generated constructor stub
		this.ruche = ruche;
	}

	public int calculateNewForagers(long input) {
		int output = (int) input / 7;
		int temp = output;
		output = output - newForagers;
		newForagers = temp;
		return output;
	}

	// public void createNewForager() {
	// boolean check = true;
	// if (this.ruche.getPollen() == this.pollen) check = false;
	// if (check) {
	// this.pollen = this.ruche.getPollen();
	// int temp = calculateNewForagers(this.pollen);
	// if (temp != 0) {
	// for(int i=0;i<temp;i++) {
	// Forager f = new Forager(null, new Point(ruche.getPositionHive()), ruche, 0);
	// ruche.getlForager().add(f);
	// System.out.println("New forager: " + f);
	// this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
	// }
	// }
	// }
	// System.out.println("Pollen for new foragers: " + this.pollen);
	// if (this.pollen % 10 == 0 && check) {
	// Flowers fleur = new Flowers();
	//
	// fleur = ruche.findFlower();
	// Forager f = new Forager(fleur, new Point(ruche.getPositionHive()), ruche, 0);
	// ruche.getlForager().add(f);
	// this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
	// }
	//
	// minute++;
	// System.out.println("minute after createNewForager: " + this.minute);
	// }

	public void nextFrame() {
		boolean check = true;
		if (this.ruche.getPollen() == this.pollen)
			check = false;
		if (check) {
			this.pollen = this.ruche.getPollen();
			System.out.println("Pollen for new foragers: " + this.pollen);
			int temp = calculateNewForagers(this.pollen);
			if (temp != 0) {
				for (int i = 0; i < temp; i++) {
					Forager f = new Forager(null, new Point(ruche.getPositionHive()), ruche, 0);
					ruche.getlForager().add(f);
					System.out.println("New forager: " + f);
					this.ruche.setForagersAtAll(this.ruche.getForagersAtAll() + 1);
				}
			}
		}
		// if (this.minute % 5 == 0) {
		// // this.ruche.abeilles.add(new Forager())
		// // this.ruche.abeilles.add(new Butineuse())
		//
		// }
		// this.minute++;
		// System.out.println("minute after nextFrame: " + this.minute);
	}

}

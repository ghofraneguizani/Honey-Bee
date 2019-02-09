package models;

import java.awt.Point;


import models.Flowers.Flowerstate;

public class Forager extends Bees {

	protected enum foragerState {
		lookfor, onway, collecting, wayback, storing
	};

	private foragerState state;
	private Flowers target;
	protected boolean isalive;
	private Point position;
	private Hive ruche;
	private int pollen;
	private int liveTime;
	private String path;

	public Forager() {

		isalive = true;
	}

	public Forager(Flowers target, Point position, Hive ruche, int liveTime,String path) {
		super();
		state = foragerState.lookfor;
		this.target = target;
		this.isalive = true;
		this.position = position;
		this.pollen = 0;
		this.ruche = ruche;
		this.liveTime = liveTime;
	}

	public Forager(foragerState state, Flowers target, boolean isalive, Point position, int pollen) {
		super();
		this.state = state;
		this.target = target;
		this.isalive = isalive;
		this.position = position;
		this.pollen = pollen;
	}
	public Forager(foragerState state, Flowers target, boolean isalive, Point position, int pollen,String path) {
		super();
		this.state = state;
		this.target = target;
		this.isalive = isalive;
		this.position = position;
		this.pollen = pollen;
		this.path=path;
	}
	

	public foragerState getState() {
		return state;
	}

	public void setState(foragerState state) {
		this.state = state;
	}

	public Flowers getTarget() {
		return target;
	}

	public void setTarget(Flowers target) {
		this.target = target;
	}

	public int getPollen() {
		return pollen;
	}

	public void setPollen(int pollen) {
		this.pollen = pollen;
	}

	public int getLiveTime() {
		return liveTime;
	}

	public void setLiveTime(int liveTime) {
		this.liveTime = liveTime;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean isIsalive() {
		return isalive;
	}

	public void setIsalive(boolean isalive) {
		this.isalive = isalive;
	}


	public void fightOfForager(Forager input) { // pas teste encore
		System.out.println("in fight method");
		if (this.liveTime <= input.liveTime) {
			for (Forager f : ruche.getlForager()) {
				if (input.equals(f))
					f.setIsalive(false);
			}
			for (Forager f : ruche.getlForager()) {
				System.out.println("forager isAlive: " + f.isalive);
			}
		} else {
			for (Forager f : ruche.getlForager()) {
				if (this.equals(f))
					this.setIsalive(false);
			}
			for (Forager f : ruche.getlForager()) {
				System.out.println("forager isAlive: " + f.isalive);
			}
		}
	}

	public boolean moveTo(Point position) {
		System.out.println("forager is in the moveTo method");
		boolean arrived = true;
		if (position.x != this.position.x) {
			// System.out.println("forager use the first if");
			arrived = false;
			int distance = position.x - this.position.x;
			this.position.x += (distance > 0 ? 1 : -1) * Math.min(Application.vitesse, Math.abs(distance));
		}
		if (position.y != this.position.y) {
			// System.out.println("forager use the second if");
			arrived = false;
			int distance = position.y - this.position.y;
			this.position.y += (distance > 0 ? 1 : -1) * Math.min(Application.vitesse, Math.abs(distance));
		}
		// if(this.getTarget()!=null) System.out.println("target
		// :"+this.getTarget().getPosition());
		if (this.target != null)
			System.out
					.println("position of forager :" + this.getPosition() + "flying to: " + this.target.getPosition());
		return arrived;
	}

	public void nextFrame() {
		// lookfor , onway , collecting, wayback, storing

		switch (this.state) {
		case lookfor:

			// this.target = this.ruche.garden.fleurs.get( Math.floor(Math.random(0,
			// this.ruche.garden.fleurs.size())));

			target = ruche.findFlower();
			System.out.println("forager possition is: " + this.position);
			System.out.println("forager target is:" + this.target.getPosition());
			if (this.target.isIsalive()) {
				this.state = foragerState.onway;
				System.out.println("forager state is:" + this.state);
			}
			break;

		case onway:
			// System.out.println("Forager is in case onway:");
			// System.out.println("position of target is:" + this.target.getPosition());
			// System.out.println("position of forager is:" + this.position);
			if (this.moveTo(this.target.getPosition())) {
				this.state = foragerState.collecting;
				System.out.println("forager state is:" + this.state);
			}
			break;

		case collecting:
			for (Forager forager : ruche.getlForager()) { // pas encore teste
				if (forager.position.equals(this.position) && !forager.equals(this) && forager.isalive
						&& this.isalive) {
					this.fightOfForager(forager);
				}
			}

			if (target.getState() == (Flowerstate.carnivore) || target.getState() == (Flowerstate.poisoned)) {
				System.out.println("forager is in DANGER");
				this.setIsalive(false);
				// ruche.getlForager().remove(this);
				target.setIsalive(false); // fleur est mort
			} else {
				System.out.println("forager is collecting");
				int collected = this.target.decrementerPollen();
				this.setPollen(collected + pollen);
				// this.pollen += collected;
				// target.setPollen(target.getPollen() - collected); // c'est deux fois
				if (this.pollen >= Application.MaxNectar || collected == 0) {
					this.state = foragerState.wayback;
					System.out.println("forager state is:" + this.state);
					this.setTarget(null);
				}

			}
			break;

		case wayback:
			if (this.moveTo(this.ruche.getPositionHiveDoor())) {
				this.state = foragerState.storing;
				System.out.println("forager state is:" + this.state);
			}
			break;

		case storing:
			System.out.println("forager is storing, her number of pollen is: " + this.pollen);
			int toStore = Math.min(Application.nectarPerFrame, this.pollen);
			System.out.println("int toStore is: " + toStore);
			// this.pollen -= toStore;
			setPollen(pollen - toStore);
			this.ruche.setPollen(this.ruche.getPollen() + toStore);
			System.out.println("ruche pollen is: " + this.ruche.getPollen());
			if (this.pollen == 0) {
				this.state = foragerState.lookfor;
				System.out.println("forager state is:" + this.state);
			}
			break;
		}

	}

	@Override
	public String toString() {
		return "Forager [state=" + state + ", target=" + target + ", isalive=" + isalive + ", position=" + position
				+ ", pollen=" + pollen + ", liveTime=" + liveTime + "]";
	}

}

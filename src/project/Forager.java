package project;

import java.awt.Point;
import project.Flowers.Flowerstate;

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
	private int liveTime = 0;

	public Forager() {

		isalive = true;
	}

	public Forager(Flowers target, Point position, Hive ruche) {
		super();
		state = foragerState.lookfor;
		this.target = target;
		this.isalive = true;
		this.position = position;
		this.pollen = 0;
		this.ruche = ruche;
	}

	public Forager(foragerState state, Flowers target, boolean isalive, Point position, int pollen) {
		super();
		this.state = state;
		this.target = target;
		this.isalive = isalive;
		this.position = position;
		this.pollen = pollen;
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
		// System.out.println("position of forager :"+this.getPosition());
		return arrived;
	}

	public void nextFrame() {
		// lookfor , onway , collecting, wayback, storing

		switch (this.state) {
		case lookfor:

			// this.target = this.ruche.garden.fleurs.get( Math.floor(Math.random(0,
			// this.ruche.garden.fleurs.size())));

			target = ruche.findFlower();
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
				if (this.getTarget() == forager.target && !forager.equals(this) && forager.isalive == true) {
					this.fightOfForager(forager);
				}
			}
			// for (int i = 0; i < ruche.getlForager().size(); i++) { // deja teste
			// System.out.println("check if there is another forager");
			// if (this.target == ruche.getlForager().get(i).getTarget() &&
			// !ruche.getlForager().get(i).equals(this)) {
			// this.fightOfForager(ruche.getlForager().get(i));
			// }
			// }
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
				target.setPollen(target.getPollen() - collected);
				if (this.pollen >= Application.MaxNectar || collected == 0) {
					this.state = foragerState.wayback;
					System.out.println("forager state is:" + this.state);
					this.setTarget(null);
				}

			}
			break;

		case wayback:
			if (this.moveTo(this.ruche.getPositionHive())) {
				this.state = foragerState.storing;
				System.out.println("forager state is:" + this.state);
			}
			break;

		case storing:
			int toStore = Math.min(Application.nectarPerFrame, this.pollen);
			// this.pollen -= toStore;
			setPollen(pollen - toStore);
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
				+ ", pollen=" + pollen + "]";
	}

}

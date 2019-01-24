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
		System.out.println("fight");
		if (this.liveTime <= input.liveTime) {
			ruche.getlForager().remove(input);
		} else
			ruche.getlForager().remove(this);
	}

	public boolean moveTo(Point position) {
		System.out.println("on the run");
		boolean arrived = true;
		if (position.x != this.position.x) {
			arrived = false;
			int distance = position.x - this.position.x;
			this.position.x += (distance > 0 ? 1 : -1) * Math.min(Application.vitesse, Math.abs(distance));
		}
		if (position.y != this.position.y) {
			arrived = false;
			int distance = position.y - this.position.y;
			this.position.y += (distance > 0 ? 1 : -1) * Math.min(Application.vitesse, Math.abs(distance));
		}
		return arrived;
	}

	public void nextFrame() {
		// lookfor , onway , collecting, wayback, storing

		switch (this.state) {
		case lookfor:

			// this.target = this.ruche.garden.fleurs.get( Math.floor(Math.random(0,
			// this.ruche.garden.fleurs.size())));

			if (this.target == null)
				target = ruche.findFlower();
			if (this.target.isIsalive()) {
				this.state = foragerState.onway;
				System.out.println(this);
			}
			break;

		case onway:
			if (this.moveTo(this.target.getPosition()))
				this.state = foragerState.collecting;
			break;

		case collecting:
			for (Forager forager : ruche.getlForager()) { // pas encore teste
				if (this.position == forager.position && !forager.equals(this)) {
					this.fightOfForager(forager);
				}
			}
			// for (int i = 0; i < ruche.getlForager().size(); i++) { //deja teste
			// if (this.position == ruche.getlForager().get(i).position &&
			// !ruche.getlForager().get(i).equals(this)) {
			// this.fightOfForager(ruche.getlForager().get(i));
			// }
			// }
			if (target.getState() == (Flowerstate.carnivore) || target.getState() == (Flowerstate.poisoned)) {
				this.setIsalive(false);
				ruche.getlForager().remove(this);
				target.setIsalive(false); // fleur est mort
			} else {
				int collected = this.target.decrementerPollen();
				this.setPollen(collected + pollen);
				// this.pollen += collected;
				target.setPollen(target.getPollen() - collected);
				if (this.pollen >= Application.MaxNectar || collected == 0) {
					this.state = foragerState.wayback;
					this.setTarget(null);
				}
				if (target.getPollen() == 0) {
					target.setIsalive(false);
				}
			}
			break;

		case wayback:
			if (this.moveTo(this.ruche.positionHive))
				this.state = foragerState.storing;
			break;

		case storing:
			int toStore = Math.min(Application.nectarPerFrame, this.pollen);
			// this.pollen -= toStore;
			setPollen(pollen - toStore);
			if (this.pollen == 0)
				this.state = foragerState.lookfor;
			break;
		}

	}

	@Override
	public String toString() {
		return "Forager [state=" + state + ", target=" + target + ", isalive=" + isalive + ", position=" + position
				+ ", pollen=" + pollen + "]";
	}

}
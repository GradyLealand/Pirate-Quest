
public abstract class Ship {
	//----Stat's----
	private String name = "";
	private int hpMax = 0;
	private int hpMin = 0;
	private int speed = 0;
	private int attack = 0;
	private int deffence = 0;
	
	//----Equipment----
	private Cannon cannon = (Cannon) new CardboardCannon();
	private Sail sail = (Sail) new PapperSail();
	private Hull haul = (Hull) new CardboardHull();
	
	//----Methods----
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHpMax() {
		return hpMax;
	}
	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
	public int getHpMin() {
		return hpMin;
	}
	public void setHpMin(int hpMin) {
		this.hpMin = hpMin;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDeffence() {
		return deffence;
	}
	public void setDeffence(int deffence) {
		this.deffence = deffence;
	}
	public Cannon getCannon() {
		return cannon;
	}
	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}
	public Sail getSail() {
		return sail;
	}
	public void setSail(Sail sail) {
		this.sail = sail;
	}
	public Hull getHaul() {
		return haul;
	}
	public void setHaul(Hull haul) {
		this.haul = haul;
	}
	
	public abstract int attack();
	
	public abstract int defend();
}

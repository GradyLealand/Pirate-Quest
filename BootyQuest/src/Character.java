
public abstract class Character {
	private String name;
	private int hp;
	private int hpMax;
	private int defence;
	private int speed;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getHpMax() {
		return hpMax;
	}
	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}

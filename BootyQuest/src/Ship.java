import java.util.Random;

public class Ship extends Character{
	//----Stat's----
	private String shipClass = "";
	private int minAtk = 0;
	private int maxAtk = 0;
	private int booty = 0;

	//----Equipment----
	private Cannon cannon = new Cannon();
	private Sail sail = new Sail();
	private Hull hull = new Hull();
	
	//----Methods----
	
	public String getShipClass() {
		return shipClass;
	}
	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}
	public int getMinAtk() {
		return minAtk;
	}
	public void setMinAtk(int minAtk) {
		this.minAtk = minAtk;
	}
	public int getMaxAtk() {
		return maxAtk;
	}
	public void setMaxAtk(int maxAtk) {
		this.maxAtk = maxAtk;
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
	public Hull getHull() {
		return hull;
	}
	public void setHull(Hull hull) {
		this.hull = hull;
	}
	public int getBooty() {
		return booty;
	}
	public void setBooty(int booty) {
		this.booty = booty;
	}
	
	//---- Class Methods ----
	//generate an attack roll to be used by monster in defense
	public int attack(Ship ship){
		Random r = new Random();
		int min = ship.minAtk + ship.cannon.getAttackMod();
		int max = ship.maxAtk + ship.cannon.getAttackMod();
		return r.nextInt(max - min + 1) + min;
	};
	// take the monster attack roll and apply it to player defense
	public int defend(int atk, Ship ship){
		int dmg = atk - ship.getDefence();
		//never let dmg be a negative
		if (dmg < 0){
			dmg = 0;
		}
		ship.setHp(ship.getHp() - dmg);
		return dmg;
	}
	
	//---- constructors ----
	//skiff constructor
	public Ship Skiff(Ship ship, String name){
		// set stats
		ship.setName(name);
		ship.shipClass = "Skiff";
		ship.setHpMax(50);
		ship.setHp(50);
		ship.maxAtk = 5;
		ship.minAtk = 3;
		ship.setDefence(2);
		ship.setSpeed(7);
		ship.booty = 50;
		
		//set starting equipment
		ship.cannon.cardbordCannon(cannon);
		ship.sail.papperSail(sail);
		ship.hull.cardboardHull(hull);
		
		return ship;
	}
	
	//gally constructor
	public Ship Gally(Ship ship, String name){
		// set stats
		ship.setName(name);
		ship.shipClass = "Gally";
		ship.setHpMax(70);
		ship.setHp(70);
		ship.maxAtk = 7;
		ship.minAtk = 4;
		ship.setDefence(4);
		ship.setSpeed(5);
		ship.booty = 50;
		
		//set starting equipment
		ship.cannon.cardbordCannon(cannon);
		ship.sail.papperSail(sail);
		ship.hull.cardboardHull(hull);
		
		return ship;
	}
	
	//frigate constructor
	public Ship Frigate(Ship ship, String name){
		// set stats
		ship.setName(name);
		ship.shipClass = "Frigate";
		ship.setHpMax(100);
		ship.setHp(100);
		ship.maxAtk = 10;
		ship.minAtk = 1;
		ship.setDefence(3);
		ship.setSpeed(4);
		ship.booty = 50;
		
		//set starting equipment
		ship.cannon.cardbordCannon(cannon);
		ship.sail.papperSail(sail);
		ship.hull.cardboardHull(hull);
		
		return ship;
	}
}

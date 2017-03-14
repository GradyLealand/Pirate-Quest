
public class Ship {
	//----Stat's----
	private String name = "";
	private String shipClass = "";
	private int maxHp = 0;
	private int hp = 0;
	private int speed = 0;
	private int minAtk = 0;
	private int maxAtk = 0;
	private int deffence = 0;
	private int booty = 0;

	//----Equipment----
	private Cannon cannon = new Cannon();
	private Sail sail = new Sail();
	private Hull hull = new Hull();
	
	//----Methods----
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShipClass() {
		return shipClass;
	}
	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
	public Hull getHull() {
		return hull;
	}
	public void setHull(Hull hull) {
		this.hull = hull;
	}
	
	//---- Class Methods ----
	public int attack(){
		return 1;
	};
	public int getBooty() {
		return booty;
	}
	public void setBooty(int booty) {
		this.booty = booty;
	}
	
	//---- constructors ----
	
	public Ship Skiff(Ship ship, String name){
		// set stats
		ship.name = name;
		ship.shipClass = "Skiff";
		ship.maxHp = 50;
		ship.hp = 40;
		ship.maxAtk = 5;
		ship.minAtk = 2;
		ship.deffence = 2;
		ship.speed = 7;
		ship.booty = 500;
		
		//set starting equipment
		ship.cannon.cardbordCannon(cannon);
		ship.sail.papperSail(sail);
		ship.hull.setHullType(1);
		ship.hull.setHullName("Cardboard Haul");
		ship.hull.setDefenceMod(0);
		
		return ship;
	}
	
	//---- Ship Constructors ----
	public Ship Gally(Ship ship, String name){
		// set stats
		ship.name = name;
		ship.shipClass = "Gally";
		ship.maxHp = 70;
		ship.hp = 70;
		ship.maxAtk = 8;
		ship.minAtk = 5;
		ship.deffence = 4;
		ship.speed = 6;
		ship.booty = 50;
		
		//set starting equipment
		ship.cannon.setCannonType(1);
		ship.cannon.setCannonName("Cardboard Cannon");
		ship.cannon.setAttackMod(0);
		ship.sail.setSailType(1);
		ship.sail.setSailName("Papper sail");
		ship.sail.setSpeedMod(0);
		ship.hull.setHullType(1);
		ship.hull.setHullName("Cardboard Haul");
		ship.hull.setDefenceMod(0);
		
		return ship;
	}
	
	public Ship Frigate(Ship ship, String name){
		// set stats
		ship.name = name;
		ship.shipClass = "Frigate";
		ship.maxHp = 110;
		ship.hp = 100;
		ship.maxAtk = 10;
		ship.minAtk = 1;
		ship.deffence = 3;
		ship.speed = 4;
		ship.booty = 50;
		
		//set starting equipment
		ship.cannon.setCannonType(1);
		ship.cannon.setCannonName("Cardboard Cannon");
		ship.cannon.setAttackMod(0);
		ship.sail.setSailType(1);
		ship.sail.setSailName("Papper sail");
		ship.sail.setSpeedMod(0);
		ship.hull.setHullType(1);
		ship.hull.setHullName("Cardboard Haul");
		ship.hull.setDefenceMod(0);
		
		return ship;
	}
}

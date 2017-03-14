
public class Cannon extends Item {
	private int attackMod;
	private int cannonType;
	private String cannonName;

	public String getCannonName() {
		return cannonName;
	}

	public void setCannonName(String cannonName) {
		this.cannonName = cannonName;
	}

	public int getCannonType() {
		return cannonType;
	}

	public void setCannonType(int cannonType) {
		this.cannonType = cannonType;
	}

	public int getAttackMod() {
		return attackMod;
	}

	public void setAttackMod(int attackMod) {
		this.attackMod = attackMod;
	}
	
	public Cannon cardbordCannon(Cannon cannon){
		cannon.attackMod = 0;
		cannon.cannonName = "Cardboard Cannon";
		cannon.cannonType = 1;
		cannon.cost = 0;
		return cannon;
	}
	
	public Cannon copperCannon(Cannon cannon){
		cannon.attackMod = 1;
		cannon.cannonName = "Copper Cannon";
		cannon.cannonType = 2;
		cannon.cost = 50;
		return cannon;
	}
	
	public Cannon brassCannon(Cannon cannon){
		cannon.attackMod = 3;
		cannon.cannonName = "Brass Cannon";
		cannon.cannonType = 3;
		cannon.cost = 250;
		return cannon;
	}
	
	public Cannon ironCannon(Cannon cannon){
		cannon.attackMod = 5;
		cannon.cannonName = "Iron Cannon";
		cannon.cannonType = 4;
		cannon.cost = 500;
		return cannon;
	}
}


public class Sail extends Item{
	private int speedMod;
	private int sailType;
	private String sailName;

	public String getSailName() {
		return sailName;
	}

	public void setSailName(String sailName) {
		this.sailName = sailName;
	}

	public int getSailType() {
		return sailType;
	}

	public void setSailType(int sailType) {
		this.sailType = sailType;
	}

	public int getSpeedMod() {
		return speedMod;
	}

	public void setSpeedMod(int speedMod) {
		this.speedMod = speedMod;
	}
	
	public Sail papperSail(Sail sail){
		sail.speedMod = 0;
		sail.sailName = "Papper Sail";
		sail.sailType = 1;
		sail.cost = 0;
		return sail;
	}
	
	public Sail clothSail(Sail sail){
		sail.speedMod = 1;
		sail.sailName = "Cloth Sail";
		sail.sailType = 2;
		sail.cost = 100;
		return sail;
	}
	
	public Sail syntheticSail(Sail sail){
		sail.speedMod = 2;
		sail.sailName = "Synthetic Sail";
		sail.sailType = 3;
		sail.cost = 350;
		return sail;
	}
	
}

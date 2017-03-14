
public class Hull extends Item{
	private int defenceMod;
	private int hullType;
	private String hullName;

	public int getDefenceMod() {
		return defenceMod;
	}
	public void setDefenceMod(int defenceMod) {
		this.defenceMod = defenceMod;
	}
	public int getHullType() {
		return hullType;
	}
	public void setHullType(int hullType) {
		this.hullType = hullType;
	}
	public String getHullName() {
		return hullName;
	}
	public void setHullName(String haulName) {
		this.hullName = haulName;
	}
	
	//----Constructors----
	public Hull cardboardHull(Hull hull){
		hull.defenceMod = 0;
		hull.hullName = "Cardboard hull";
		hull.hullType = 1;
		hull.cost = 0;
		return hull;
	}
	
	public Hull woodenHull(Hull hull){
		hull.defenceMod = 1;
		hull.hullName = "Wooden hull";
		hull.hullType = 2;
		hull.cost = 150;
		return hull;
	}
	
	public Hull reinforcedHull(Hull hull){
		hull.defenceMod = 3;
		hull.hullName = "Reinforced hull";
		hull.hullType = 3;
		hull.cost = 400;
		return hull;
	}
	
}


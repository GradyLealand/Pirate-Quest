public class Monster {
	//----Stat's----
	private String name = "";
	private  int hp = 0;
	private int attack = 0;
	private int deffence = 0;
	private int speed = 0;
	private int drop = 0;
	
	//----Methos----
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDrop() {
		return drop;
	}
	public void setDrop(int drop) {
		this.drop = drop;
	}
	
	public int attack(){
		return 1;
	}
	
	public int defence(){
		return 1;
	}
	
	//----Constructors----
	public Monster angryCrab(Monster monster){
		monster.setHp(20);
		monster.setAttack(1);
		monster.setDeffence(1);
		monster.setSpeed(3);
		monster.setDrop(20);
		
		return monster;
	}
	
	public Monster giantClam(Monster monster){
		monster.setHp(60);
		monster.setAttack(2);
		monster.setDeffence(3);
		monster.setSpeed(4);
		monster.setDrop(50);
		
		return monster;
	}
	
	public Monster giantSquid(Monster monster){
		monster.setHp(100);
		monster.setAttack(4);
		monster.setDeffence(1);
		monster.setSpeed(3);
		monster.setDrop(80);
		
		return monster;
	}
	
	public Monster kracken(Monster monster){
		monster.setHp(200);
		monster.setAttack(6);
		monster.setDeffence(3);
		monster.setSpeed(3);
		monster.setDrop(150);
		
		return monster;
	}
}


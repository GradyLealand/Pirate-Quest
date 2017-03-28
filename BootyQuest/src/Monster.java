import java.util.Random;

public class Monster extends Character{
	//----Stat's----
	private int attack = 0;
	private int drop = 0;
	
	//----Methos----
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDrop() {
		return drop;
	}
	public void setDrop(int drop) {
		this.drop = drop;
	}
	
	//monster rolls for attack to be used by player defense
	public int attack(Monster mob){
		Random r = new Random();
		int min = mob.attack;
		int max = mob.attack + 3;
		return r.nextInt(max - min + 1) + min;
	}
	
	//monster defends against players attack
	public int defence(int atk, Monster mob){
		int dmg = atk - mob.getDefence();
		//never let dmg be a negative
		if (dmg < 0){
			dmg = 0;
		}
		mob.setHp(mob.getHp() - dmg);
		return dmg;
	}
	
	//----Constructors----
	//construct an angry crab
	public Monster angryCrab(Monster monster){
		monster.setName("Angry Crab");
		monster.setHp(20);
		monster.setHpMax(20);
		monster.setAttack(2);
		monster.setDefence(1);
		monster.setSpeed(6);
		monster.setDrop(20);
		
		return monster;
	}
	
	//construct a giant clam
	public Monster giantClam(Monster monster){
		monster.setName("Giant Clam");
		monster.setHp(50);
		monster.setHpMax(50);
		monster.setAttack(4);
		monster.setDefence(3);
		monster.setSpeed(5);
		monster.setDrop(50);
		
		return monster;
	}
	
	//construct a giant squid
	public Monster giantSquid(Monster monster){
		monster.setName("Giant Squid");
		monster.setHp(80);
		monster.setHpMax(80);
		monster.setAttack(6);
		monster.setDefence(2);
		monster.setSpeed(5);
		monster.setDrop(80);
		
		return monster;
	}
	
	//construct a kracken
	public Monster kracken(Monster monster){
		monster.setName("Kracken");
		monster.setHp(150);
		monster.setHpMax(150);
		monster.setAttack(8);
		monster.setDefence(4);
		monster.setSpeed(4);
		monster.setDrop(150);
		
		return monster;
	}
}

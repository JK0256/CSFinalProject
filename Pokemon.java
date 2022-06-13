package pkg;
import java.util.Scanner;
import java.util.Random;


public class Pokemon {
	private int lvl;
	private String name;
	private int maxHP = lvl*3 + 15; 
	private int HP;
	private int buff = 1;
	private int atk = lvl*2*buff; 
	private boolean protecting = false;
	
	public Pokemon(String name, int lvl) {
		name = this.name;
		lvl = this.lvl;
		HP = maxHP;
	}
	// public Pokemon(Pokemon first) {
	// 	name = first.getName();
	// 	lvl = first.getLvl();
	// }4
	public void setLvl(int a) {
		lvl = a;
	}
	public int getLvl() {
		return lvl;
	}
	public void setName(String a) {
		name = a;
	}
	public String getName() {
		return name;
	}
	public int getAtk() {
		// return atk;	not working?
		return 5*2;
	}
	public int getHP() {
		return HP;
	}
	public void minusHP(int damage) {	//Subtract hp
		if(protecting) {
			return;
		}
		HP = HP - damage;
	}
	public void heal() {
		HP = maxHP;
	}
	public void isProtecting(boolean protect) {
		protecting = protect;
	}
	public void buff() {
		buff+=0.25;
	}
	
	
	public boolean hasFainted() {
		if(HP <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString(){
		return name;
	}
}


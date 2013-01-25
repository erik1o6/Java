/**
 * Lab 5: Video Game Enemy Class
understand different kinds of class data members
use class member functions
Suppose we're building a video game where there are several vertical levels on the screen, numbered starting at 1. There are various things on the screen, but we're going to focus on the enemies of the player. The player can change his/her vertical location. Enemies behave as follows:

They live at some vertical level on the screen. There could be more than one enemy on each level. The locations of enemies could change due to actions in the game.
Enemies have a strength measured from 0 to 100. When an enemy starts out, it has full strength.
When an enemy has a strength level less than Strengththresh, it is of no threat to the player. (This threshold should be configurable by the programmer of the class, but not any client.)
The player can shoot the enemies. Each hit causes the enemy to lose strength. How much strength an enemy loses per hit varies from enemy to enemy, but never changes throughout the game.
Things that happen in the game can cause the player to render all enemies inactive temporarily. (In a sense, the player becomes invincible, but this is represented by tagging the enemies as active or inactive.)
Task 1: Your main task is to build a class that models (partially, perhaps) an enemy in this video game, as follows:

Define data members to model how strong enemies are, how much strength they lose per hit, the threshold strength level for enemies being dangerous, their vertical levels, and whether or not they are active. Think critically as you do so; pay attention to what kinds of data members you use and how you format the data dictionary.
Provide a default constructor for an enemy. You decide what the default properties are if nothing in the specifications above says otherwise.
Provide an initializer constructor for an enemy. Allow initialization of all properties whose initial value isn't dictated by the specifications above.
Provide a modifier that processes the effects of an enemy suffering a single hit.
Provide a modifier that allows enemies to be rendered inactive.
Provide a modifier than allows enemies to be rendered active.
Provide an accessor to get the current strength of an enemy.
Provide an accessor to get the danger the enemy poses to the player located at a given vertical level. When an enemy is active and the enemy's strength level is at least Strengththresh, the danger is defined as the enemy's strength with the number of vertical levels away from the player the enemy is subtracted. Otherwise, the danger is 0.
Provide an accessor that allows two enemies' strengths to be compared. It should take as a parameter a second enemy and return true when this enemy is stronger than the parameter enemy.
Provide a toString() for an enemy.
List the methods requested in #2 through #10 in the order of the directions.

Task 2: Write a test driver for this class. Do this in a separate file. Construct at least 3 instances of the class and test each of the methods, one at a time. Show the effect of each change you make to verify that each modifier works. No documentation is required in the test driver.

Report: Create a report with your source code and the output of your test driver. Read Section 1 of the Programming Assignment Guidelines and pay special attention to setting up a report with multiple code files.
 */
/**
 * Name: Erik Arfvidson
 * Program: Lab 5
 * Date: 9/15/2012
 **/

public class EnemyClass {
	private int levels;//level the enemy is on
	private int lvlStrength;//Strength that enemy has
	private boolean active;//If enemy is active or not
	private String name;//the name of the enemy
	private int Strengththresh=15;//Strength threshold that determines when enemy becomes inactive
	private static final int DAMAGE=25;//the damage the player has over enemies
	/**
	 * 
	 */
	public EnemyClass() //default constructor
	{
		this(3, 100, true);
	}
	public EnemyClass(int levels, int lvlStrength, boolean active, String name) //added this for fun so that I could name enemies
	{

		this.levels=levels;
		this.lvlStrength=lvlStrength;
		this.name=name+this.lvlStrength;
		this.active=active;
		if(lvlStrength<Strengththresh)//checks if active
		{
			this.active=false;
		}

	}
	public EnemyClass(int levels, int lvlStrength, boolean active) //Initializer constructor takes in levels, lvlStrength , and active

	{

		this.levels=levels;
		this.lvlStrength=lvlStrength;
		this.active=active;
		this.name="Grunt"+ this.lvlStrength;
		if(lvlStrength<Strengththresh)//checks if active
		{
			this.active=false;
		}

	}
	public void Hit(int playerLevel)//returns modifies
	{
		lvlStrength-=DAMAGE-1*playerLevel;
		if(lvlStrength<0)
		{
			lvlStrength = 0;
		}
		if(lvlStrength<Strengththresh)
		{
			this.active=false;
		}
	}	
	public void Deactivate()//Deactivate enemy
	{
		this.active=false;
	}
	public void Activate()//Activate enemy
	{
		this.active=true;
	}
	public int getStr ()//returns Strength
	{	
		return lvlStrength;
	}
	public int Danger (int playerLevel)//returns the danger of enemy
	{
		int danger=0; //the danger of an opponent to the player
		if(lvlStrength>=Strengththresh&&active)
		{
			danger = lvlStrength - this.levels + playerLevel;

			if(danger<0)
			{
				danger = 0;
			}

		}
		else
		{
			danger = 0;
		}

		return danger;

	}




	public boolean secondEnemy(EnemyClass loro) 
	{
		if(lvlStrength<loro.getStr()+1)
		{
			return false;
		}
		else
			return true;
	}
	public String toString() 
	{
		return "EnemyClass [levels=" + levels + ", lvlStrength=" + lvlStrength
				+ ", active=" + active + ", name=" + name + "]";
	}

}

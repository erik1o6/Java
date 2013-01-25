/** 
 * Name: Erik Arfvidson
 * Program: Lab 2 
 * Date: 9/5/2012
 **/
public class testDriver
{
	public static void main(String[] args)
	{

		EnemyClass EnemyClass1;
		EnemyClass EnemyClass2;
		EnemyClass EnemyClass3;


		EnemyClass[] allEnemies = new EnemyClass[3];


		int danger1;
		int danger2;
		int danger3;
		int playerLevel=2;

		EnemyClass1 = new EnemyClass();
		EnemyClass2 = new EnemyClass(10, 60, true);
		EnemyClass3 = new EnemyClass(12, 15, true);

		System.out.println("\nNow begin the test driver");
		System.out.println("\nEnemyClass1: " + EnemyClass1.toString());
		System.out.println("EnemyClass2: " + EnemyClass2.toString());
		System.out.println("EnemyClass3: " + EnemyClass3.toString());

		//test the CurrentStrength accessor.
		System.out.println("\nNow we test the CurrentStrength accessor to see if it works. ");
		System.out.println("\nthe strength of EnemyClass1: "+ EnemyClass1.getStr());
		System.out.println("the strength of EnemyClass2: "+ EnemyClass2.getStr());
		System.out.println("the strength of EnemyClass3: "+ EnemyClass3.getStr());

		//test the SingleHit accessor.
		System.out.println("\nNow we test the EnemyClass with a single hit ");
		System.out.println("EnemyClass's strength after one hit:");
		allEnemies[0] = EnemyClass1;
		allEnemies[1] = EnemyClass2;
		allEnemies[2] = EnemyClass3;
		for(int count = 0 ; count<allEnemies.length ; count++)
		{
			allEnemies[count].Hit(playerLevel);
		}
		System.out.println("\nthe strength of EnemyClass1: "+ EnemyClass1.getStr());
		System.out.println("the strength of EnemyClass2: " + EnemyClass2.getStr());
		System.out.println("the strength of EnemyClass3: " + EnemyClass3.getStr());

		for(int count = 0 ; count<allEnemies.length ; count++)
		{
			allEnemies[count].Deactivate();
		}

		System.out.println("\nAfter deactivation, the EnemyClasss are now: ");
		System.out.println("\nEnemyClass1: " + EnemyClass1.toString());
		System.out.println("EnemyClass2: " + EnemyClass2.toString());
		System.out.println("EnemyClass3: " + EnemyClass3.toString());

		System.out.println("\nAfter becoming active, the EnemyClasss are now: ");


		for(int count = 0 ; count<allEnemies.length ; count++)
		{
			allEnemies[count].Activate();
		}

		System.out.println("\nEnemyClass1: " + EnemyClass1.toString());
		System.out.println("EnemyClass2: " + EnemyClass2.toString());
		System.out.println("EnemyClass3: " + EnemyClass3.toString());


		System.out.println("\n Player at line"+ playerLevel);

		danger1 = EnemyClass1.Danger(playerLevel);
		danger2 = EnemyClass2.Danger(playerLevel);
		danger3 = EnemyClass3.Danger(playerLevel);

		System.out.println("\nThe danger of the first EnemyClass to the player is: "+ danger1);
		System.out.println("\nThe danger of the second EnemyClass to the player is: "+ danger2);
		System.out.println("\nThe danger of the third EnemyClass to the player is: "+ danger3);


		System.out.println("\nTesting the EnemyClass Comparison method.");
		System.out.println("Comparing EnemyClass1 and EnemyClass2: ");


		if (EnemyClass1.secondEnemy(EnemyClass2))
		{
			System.out.println("\nEnemyClass1 is stronger");
		}
		else
		{
			System.out.println("\nEnemyClass2 is stronger");
		}

	}

}


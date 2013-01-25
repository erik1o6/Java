//Name:		Michael Mikulski
//Section:	2
//Date:		1/20/2011
//Program:	BankAccount Enhancement
//Description:	Create a bank account program which distinguished from
//                 savings and checking


public class BankAccount
{
   private String name;        // name of account holder
   private double balance;     // how much money is in account, $
   private String accountType; // the type of account the user has

   public BankAccount()
   // POST: A default BankAccount object is created with the name set to blank, 
   //          the balance set to $0.00, and a checking account is created
   {
      this(" ", 0.0, "checking");
  }

   
  public BankAccount(String type)
   // PRE: the new account type must be initialized as a string
   // POST: A BankAccount object is created the name set to a blank,
   // 		 the account type set to type, and the balance set to 0.
   {
      this(" ", 0.0,type);
   }


   public BankAccount(String name, double balance, String accountType)
   // PRE:  balance >= 0.00 and is in dollars, name and accountType must be of type String
   // POST: A BankAccount object is created with the name set to a blank,
   //          the class member balance set to balance, and a checking account is created
   {
      this.name=name;

      if(balance>0)
      {
         this.balance = balance;
      }
      else
      {
         balance = 0.0;
      }

      this.accountType = accountType;
   }

   public BankAccount(double d) {
	// TODO Auto-generated constructor stub
}

public Boolean Withdraw(double amount)
   // PRE:  amount >= 0.00 and is in dollars
   // POST: FCTVAL== false if amount is greater than balance and the withdraw will not be processed,
   //          otherwise FCTVAL== true and amount will be deducted from the balance. 
   {
      //error check the amount to see if it is larger than the current balance             
      if(amount <= balance)
      {
         this.balance = balance - amount;
         return true;
      }

      else
      {
         return false;
      }         
   }

    

   public double GetBalance() 
   // POST: Returns the current balance of the account
   {
      return balance;
   }

   public String GetType()
   // POST: Return the type of account.
   {
      return accountType;
   }

   public void DisplayBalance() 
   // POST: Displays the current balance of the account to the screen
   {
      System.out.printf("Your balance is currently $%.2f\n", balance); 
   }


   @Override
public String toString() {
	return "BankAccount [name=" + name + ", balance=" + balance
			+ ", accountType=" + accountType + "]";
}

   public static void main(String[] args)
   //POST: We will do three things in main to test our accessors and modifiers:
   //         1: We will test the each of the three constructors by using the toString() method
   //         2: We will test the accessor of BankAccount. The accessor will be called twice     
   //               to see if it can display the information correctly when the account
   //         3: We will test the withdraw function by initializing the account to $100 and deducting
   //               $50 three times within a for loop. The first two attempts will display correct
   //               results and fail on the third attempt when there will be insufficient funds 
   {  
      //the BankAccount to the test the program 
      BankAccount Michael;

      //1:Test the three constructors
      Michael = new BankAccount();					
      System.out.println(Michael.toString());												
      Michael = new BankAccount(100.0);
      System.out.println(Michael.toString());
	    	
      Michael = new BankAccount("saving");
      System.out.println(Michael.toString());

      //2.Test the accessor
      Michael = new BankAccount("saving");									 
      System.out.println("\nThis BankAccount is a "+Michael.GetType()+" account");

      System.out.println("Now change the bank account to checking");
      Michael = new BankAccount("checking");

      System.out.println("This BankAccout is a "+Michael.GetType()+" account\n");
	    	
      











      //Part3: test the withdraw method. 
      Michael = new BankAccount(100);
   
      //for loop designed to withdraw for 3 times. It will be able to
      //withdraw twice but fails the third							
      for(int i=0;i<3;i++)	
      {								             
         System.out.println("Now try to withdraw $50. ");
         if(Michael.Withdraw(50))
         {
            System.out.println("Withdraw successfully. ");
            Michael.DisplayBalance();
         }
         else
         {
            System.out.println("Unable to withdraw, insufficient funds");
         }   
      }            
   }
}
   


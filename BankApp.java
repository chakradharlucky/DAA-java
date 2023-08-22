import java.util.*;
class BankException extends Exception{
   String str;
   BankException(String str)
   {
      this.str = str;
   }
   public String toString()
   {
      return str;
   }
}
interface BankInterface
{
   public void balance();
   public void withdraw(int amount)throws BankException;
   public void deposit(int amount)throws BankException;
}
class Bank implements BankInterface{
int totalAmount =1_000; 
@Override
public void balance()
{
   System.out.println("Avilable amount: "+totalAmount);
}
@Override
public void withdraw(int amount)throws BankException{
   if(amount>totalAmount){
      throw new BankException("Insufficient balance");
   }
   else{
      totalAmount-=amount;
   }
}
@Override
public void deposit(int amount)throws BankException {
   if(amount<1){
      throw new BankException("Money not found");
   }
   else{
      totalAmount+=amount;
   }
}
}
public class BankApp {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Bank obj = new Bank();
      System.out.print("\nWelcome to Chakradhar Bank\n\n");
      System.out.print("1.Balance Enquiry\n2.Deposit\n3.Withdraw\n\nEnter the number opposite to the operation: ");      
      int n = scan.nextInt(),amount ;
      switch (n) {
         case 1:
            obj.balance();;
            break;
         case 2:
            System.out.print("Enter amount: ");
            amount = scan.nextInt();
            try {
               obj.deposit(amount);
            } catch (Exception e) {
               System.out.println(e);
            }
            break;
         case 3:
            System.out.print("Enter amount: ");
            amount = scan.nextInt(); 
            try {
               obj.withdraw(amount);
            } catch (Exception e) {
               System.out.println(e);
            }       
             break;
         default:
            System.out.println("Invalid option you are choosed,try with correct option");
            break;
      }
      scan.close();
   }
}

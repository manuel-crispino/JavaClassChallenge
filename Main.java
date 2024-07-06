
import java.net.InetAddress;
import java.util.Scanner;
import java.net.UnknownHostException;


public class Main {
    public static void main(String[] args) {
        boolean in = true;
        int count = 0;
        Account account = new Account();
        while( in ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("insert your iban");
            String iban = scanner.nextLine();
            try {
            int newIban = Integer.parseInt(iban);
                account.setIban(newIban);
               if(account.check(newIban)){
                  System.out.println(" Welcome back  ");
                  System.out.println(" This is your account balance = "+account.getBalance());
                  boolean rightAnswer = false ;
                  while(!rightAnswer) {
                      System.out.println(" Do you like to withdraw ? Yes / No");
                      String answer = scanner.nextLine();
                      if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                          System.out.println("How much you like to withdraw ?  ");
                          try {
                              String amount = scanner.nextLine();
                             int   withdraw = Integer.parseInt(amount);
                             if ( (account.getBalance() - withdraw) >= 0 ){
                                 account.setMoneyToWithDraw(withdraw);
                                 int balance = account.getBalance();
                                 int newBalance = balance - withdraw ;
                                 account.setBalance(newBalance);
                                 System.out.println(" Thank you for choosing  my App =)");
                                 rightAnswer = true;
                                 in = closeProgram();
                                 scanner.close();
                             }
                             else{
                                 System.out.println("Invalid amount ") ;
                                 System.out.println(" Your account balance = " + account.getBalance()+"€");
                                 System.out.println("Requested withdraw  = "+withdraw +"€");
                                 System.out.println(" total remain = "+(account.getBalance()-withdraw)+"€");
                                 System.out.println("try again do not go over your account balance ");
                             }
                          }catch(NumberFormatException e){
                              System.out.println("Invalid input ");
                          }

                      } else if (answer.equalsIgnoreCase("no")) {
                          System.out.println("do you like to deposit ? yes/no ");{
                               answer = scanner.nextLine();
                              if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                  System.out.println("Insert amount ");
                                  String deposit = scanner.nextLine();
                                  try{
                                      int depositAmount = Integer.parseInt(deposit);
                                     long total =  depositAmount + account.getBalance();
                                      if (  total > 0){
                                          System.out.println(" your account balance is " + total);
                                          rightAnswer = true;  }
                                  }catch(NumberFormatException e){
                                      System.out.println(" insert valid amount ");
                                  }
                              }else if(answer.equalsIgnoreCase("no")){
                                  System.out.println(" Do you like to exit ? yes/no ");
                                  answer = scanner.nextLine();
                                  if(answer.equalsIgnoreCase("no")){
                                      System.out.println(" ok restarting... ");
                                  }
                                  else{
                                      System.out.println("Thank you for choosing my app  =)");
                                      rightAnswer= true;
                                      scanner.close();
                                      in = closeProgram();
                                  }
                              }
                          }

                      } else {
                          System.out.println(" invalid answer use Yes/No  ");
                      }
                  }
               }
               else{
                   count++;
                   System.out.println("*** Iban not Found ! ");
                   System.out.println("*** Warning !!! " + (4-count) + " attempts left.\n");

                   if ( count > 3) {
                       System.out.println("***** iban not found !***** ");
                       System.out.println("***** Your attempt limit is over!***** ");
                       System.out.println(" for security reason we have stopped your account! ");
                       System.out.println(" call 60839423 to get help !! ");
                       System.out.println("  Program ended...");
                       try {

                           InetAddress localHost = InetAddress.getLocalHost();
                           String canonicalHostName = localHost.getCanonicalHostName();
                           System.out.println("Canonical Host Name: " + canonicalHostName);
                           System.out.println("Local Host: " + localHost.getHostName());
                           System.out.println("Local IP Address: " + localHost.getHostAddress());
                       } catch (UnknownHostException e) {
                           e.printStackTrace();
                       }
                       in = closeProgram();
                       scanner.close();
                   }
               }
            }
            catch(NumberFormatException invalidInput){
                System.out.println("invalid input must contain only numbers  ");
                count++;
                System.out.println("*** Warning !!! " + (4-count) + " attempts left.\n");
                if (count > 3 ){
                    System.out.println("***** Your attempt limit is over!***** ");
                    System.out.println(" For security reason we have stopped your Account! ");
                    System.out.println(" call 60839423 to get help !! ");
                    System.out.println("  Program ended...");
                    try {
                        InetAddress localHost = InetAddress.getLocalHost();
                        String canonicalHostName = localHost.getCanonicalHostName();
                        System.out.println("Canonical Host Name: " + canonicalHostName);
                        System.out.println("Local Host: " + localHost.getHostName());
                        System.out.println("Local IP Address: " + localHost.getHostAddress());
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    scanner.close();
                   in = closeProgram();
                }
            }
        }

    }
    public static boolean closeProgram(){
        return false;
    }

}

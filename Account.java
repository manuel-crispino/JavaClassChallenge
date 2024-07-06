public class Account {
   private int iban ;
   private int balance = 10000;
   private int moneyToWithDraw;
   private int remainMoney;
   private  int storedIban = 123456;

    public int getIban() {
        return iban;
    }

    public boolean check(int iban) {
        this.iban = iban ;
        if (iban == storedIban) {
            return true;
        }
        else {
            return false;
        }
    }


    public int getBalance() {
        return balance;
    }



    public int getRemainMoney() {
        remainMoney = balance - moneyToWithDraw;
        return remainMoney;
    }

    public void setIban( int iban) {
        this.iban = iban;
    }

    public void setBalance (int balance) {
        this.balance = balance;

    }

    public void setMoneyToWithDraw(int moneyToWithDraw) {
        if (moneyToWithDraw <= balance  ) {
            this.moneyToWithDraw = moneyToWithDraw;
          int   newBalance = balance- moneyToWithDraw;
            setRemainMoney(newBalance);
        }
        else{
            System.out.println( " not able to withdraw your credit is  "+ getBalance());
        }
    }

    public void setRemainMoney(int remainMoney) {
        if ( remainMoney >= 0 ) {
            this.remainMoney = remainMoney;
            setBalance(remainMoney);
            checkCard();

        }
       else{
           System.out.println( "no money available");
        }
    }

    public void checkCard (){
        System.out.println(" well done you have successfully withdraw the amount of  "+ moneyToWithDraw +" $");
        System.out.println("your remain balance is " + balance +" $");
    }

}

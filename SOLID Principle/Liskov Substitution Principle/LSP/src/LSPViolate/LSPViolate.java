package LSPViolate;

import java.util.ArrayList;
import java.util.List;

interface Account{
    void deposite(long amount);
    void withdraw(double amount);
}

class SavingAccount implements Account{

    private double balance=0;

    public SavingAccount(){
        balance=0;
    }

    @Override
    public void deposite(long amount) {
        balance+=amount;
        System.out.println("Current amount: "+balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class CurrentAccount implements Account{

    private double balance=0;

    public CurrentAccount(){
        balance=0;
    }

    @Override
    public void deposite(long amount) {
        balance+=amount;
        System.out.println("Current amount: "+balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}


class FDAccount implements Account{

    private double balance=0;

    public FDAccount(){
        balance=0;
    }

    @Override
    public void deposite(long amount) {
        balance+=amount;
        System.out.println("Current amount: "+balance);
    }



    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");
    }
}

class BankClient{
    private List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransaction(){
        for (Account acc:accounts){
            acc.deposite(5000);
            try{
                acc.withdraw(2000);
            }catch (UnsupportedOperationException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class LSPViolate {
    static void main() {
        List<Account> acc=new ArrayList<>();
        acc.add(new SavingAccount());
        acc.add(new CurrentAccount());
        acc.add(new FDAccount());
        BankClient bc=new BankClient(acc);
        bc.processTransaction();
    }
}

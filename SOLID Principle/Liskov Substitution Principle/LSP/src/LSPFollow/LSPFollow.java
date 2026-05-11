package LSPFollow;
import java.util.ArrayList;
import java.util.List;


interface DepositeOnlyAcc{
    void deposite(long amount);
}
interface WithdrawableAcc extends DepositeOnlyAcc{
    void withdraw(double amount);
}

class SavingAccount implements WithdrawableAcc {

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

class CurrentAccount implements WithdrawableAcc {

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


class FDAccount implements DepositeOnlyAcc {

    private double balance=0;

    public FDAccount(){
        balance=0;
    }

    @Override
    public void deposite(long amount) {
        balance+=amount;
        System.out.println("Current amount: "+balance);
    }

}

class BankClient{
    private List<WithdrawableAcc> waccounts;
    private List<DepositeOnlyAcc> daccounts;

    public BankClient(List<WithdrawableAcc> waccounts, List<DepositeOnlyAcc> daccounts) {
        this.waccounts = waccounts;
        this.daccounts = daccounts;
    }

    public void processTransaction(){
        for(DepositeOnlyAcc dacc:daccounts){
            dacc.deposite(1000);
        }
        for(WithdrawableAcc wacc:waccounts){
            wacc.deposite(1000);
            wacc.withdraw(500);
        }
    }
}

public class LSPFollow {
    static void main() {
        List<WithdrawableAcc> wa=new ArrayList<>();
        List<DepositeOnlyAcc> da=new ArrayList<>();
        wa.add(new CurrentAccount());
        wa.add(new SavingAccount());
        da.add(new FDAccount());
        BankClient bc=new BankClient(wa,da);
        bc.processTransaction();
    }
}

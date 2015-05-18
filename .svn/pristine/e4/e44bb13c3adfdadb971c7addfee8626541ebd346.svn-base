import java.util.Calendar;

/**
 * Created by Yifan Xiao on 04/14/15.
 */

// A Bank class that is implemented as a Singleton.

public class Bank {
    private static Bank bankInstance = null;


    // make sure Bank is Singleton
    public static Bank getBankInstance() {
        if(bankInstance == null) {
            bankInstance = new Bank();
        }
        return  bankInstance;
    }

    public CheckingAccount openCheckingAccount() {
        CheckingAccount checkingAccount = new CheckingAccount(Calendar.getInstance(), 0.0);
        return checkingAccount;
    }

    public SavingsAccount openSavingAccount() {
        SavingsAccount savingsAccount = new SavingsAccount(Calendar.getInstance(), 0.0);
        return savingsAccount;
    }

}

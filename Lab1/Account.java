import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Yifan Xiao on 04/16/15.
 */


public abstract class Account {
    public static int accountID = 0;

    protected String accountNo;

    protected Calendar openDate;
    protected Calendar updatedDate;
    protected double balance;
    protected double currentInterest;

    public void accountSetup(Calendar openDate, double initialBalance) {
        accountNo = Integer.toString(accountID);
        accountID++;

        this.openDate = openDate;
        this.updatedDate = openDate;
        this.balance = initialBalance;
        this.currentInterest = 0.0;
    }

    public void getAccountSummary(){
        calInterest();
        updateBalance();
        printSummary();
    }

    public abstract void calInterest();

    public void updateBalance(){
        balance = balance + currentInterest;
        updatedDate = Calendar.getInstance();
    }

    public void printSummary(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        if(this.getClass().getSimpleName().equals("SavingsAccount"))
            this.accountNo = "SavingsAccount_No." + accountNo;
        else
            this.accountNo = "CheckingAccount_No." + accountNo;

        System.out.println("Here's the summary of account:  " + accountNo + ":\n");
        System.out.println("\tAccount Balance: $" + String.format("%.2f", balance));
        System.out.println("\tOpen Date: " + dateFormatter.format(openDate.getTime()));
        System.out.println("\tUpdated Date: " + dateFormatter.format(updatedDate.getTime()) + "\n");
    }

}

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Yifan Xiao on 04/15/15.
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        Bank myBank = Bank.getBankInstance();
        Scanner in = new Scanner(System.in);

        // Two examples to demonstrate account info
        openAccount(myBank, 2000.0, 2004, 1, 27, 'C'); // open a checking account
        openAccount(myBank, 5000.0, 1997, 5, 27,'S'); // open a saving account


        // Let user open their own account(s)
        System.out.println("How many accounts do you want to open?");
        int numberOfAcc = in.nextInt();

        while (numberOfAcc > 0) {
            System.out.printf("Enter the type of your account (S for Saving, C for Checking): ");
            char accType = in.next().trim().charAt(0);

            while(Character.toUpperCase(accType) != 'S' && Character.toUpperCase(accType) != 'C') {
                System.out.println("Invalid input. Please try again: ");
                accType = in.next().trim().charAt(0);
            }

            System.out.println("Enter initial balance:");
            double balance = in.nextDouble();

            openAccount(myBank, balance, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH)+1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), accType);

            numberOfAcc--;
        }

        System.out.println("It's done");
    }

    private static void openAccount (Bank bank, double balance, int year, int month, int date, char type) {
        double checkingBalance = balance;
        Calendar checkingDate = Calendar.getInstance();
        checkingDate.set(Calendar.YEAR, year);
        checkingDate.set(Calendar.MONTH, month-1);
        checkingDate.set(Calendar.DAY_OF_MONTH, date);
        Account account;

        if (type == 'C')
            account = bank.openCheckingAccount();
        else
            account = bank.openSavingAccount();

        account.accountSetup(checkingDate, checkingBalance);
        account.getAccountSummary();
    }
}

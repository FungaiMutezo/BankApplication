package com.fungaimutezo;

import com.fungaimutezo.accounts.CurrentAccount;
import com.fungaimutezo.accounts.ISA;
import com.fungaimutezo.accounts.SavingsAccount;

public class FungaiBankApplication {
    public static void main(String[] args) {
        new FungaiBankApplication();
    }

    public FungaiBankApplication() {

    }

    // Run to see 100% code coverage.
    private void hundredPercentRun() {
        CurrentAccount current = new CurrentAccount("ab",1, 0);
        ISA isa1 = new ISA("bc",2);
        ISA isa2 = new ISA("cd",3);
        SavingsAccount savings1 = new SavingsAccount("de",4,10);
        SavingsAccount savings2 = new SavingsAccount("ef",5,20);

        // Accounts can also be passed as an array (BankAccount[])
        Customer customer = new Customer("Fungai", "Mutezo", current, isa1, isa2, savings1, savings2);
        System.out.println("--- INITIAL CONFIGURATION ---");
        System.out.println(customer);

        System.out.println("--- ADD FUNDS ---");
        current.depositFunds(100);
        isa1.depositFunds(100);
        isa2.depositFunds(100);
        savings1.depositFunds(100);
        savings2.depositFunds(100);
        System.out.println(customer);

        System.out.println("--- APPLY INTEREST RATE ---");
        customer.applyInterestRate();
        System.out.println(customer);

        System.out.println("--- REMOVE INTEREST RATE ---");
        isa1.withdrawFunds(14.5f);
        isa2.withdrawFunds(14.5f);
        savings1.withdrawFunds(10.0f);
        savings2.withdrawFunds(20.0f);
        System.out.println(customer);

        System.out.println("--- CHANGE ISA RATE AND APPLY ---");
        ISA.setInterestRate(25);
        customer.applyInterestRate();
        System.out.println(customer);

        System.out.println("--- OVERDRAFT CURRENT-ACCOUNT OVER LIMIT");

        current.withdrawFunds(200);

        System.out.println(current + "\n\n");

        System.out.println("--- ADJUST OVERDRAFT LIMIT AND TRY AGAIN");

        current.setOverdraftData(2500,15);

        current.withdrawFunds(200);

        System.out.println(current + "\n\n");

        System.out.println(" --- APPLY OVERDRAFT FEES ---");

        current.withdrawFunds(current.calculateOvedraftCharges());

        System.out.println(current + "\n\n");

        // Additional testing
        Customer customer2 = new Customer("Test", "Customer");
        customer2.addAccount(isa1);

        boolean douplicate = customer2.addAccount(isa1);

        System.out.println("Duplicate possible: " + douplicate);

        CurrentAccount currentAccount = new CurrentAccount("gh", 6,200,100);
        currentAccount.withdrawFunds(300);
        System.out.println(currentAccount + "\n\n");

        currentAccount.setMaxOverdraft(300);
        currentAccount.withdrawFunds(300);
        System.out.println(currentAccount + "\n\n");

        currentAccount.setOverdraftChargesInterestRate(20);
        System.out.println(currentAccount.calculateOvedraftCharges());

        savings1.setInterestRate(30);
        System.out.println(savings1);
    }
}

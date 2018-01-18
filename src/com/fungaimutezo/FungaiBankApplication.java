package com.fungaimutezo;

import com.fungaimutezo.accounts.CurrentAccount;
import com.fungaimutezo.accounts.ISA;
import com.fungaimutezo.accounts.SavingsAccount;

public class FungaiBankApplication {
    public static void main(String[] args) {
        new FungaiBankApplication();
    }

    public FungaiBankApplication() {
        try {
            // Test page 1 of specification document
            System.out.println("TESTING: Savings-Account");
            SavingsAccount savingsAccount = new SavingsAccount("abcdef",12345678,14.5f);
            System.out.println("Initial balance: " + savingsAccount.getBalance());
            savingsAccount.depositFunds(100);
            System.out.println("Balance after deposit (100): " + savingsAccount.getBalance());
            savingsAccount.applyInterestRate();
            System.out.println("Balance after applied interest rate (14.5): " + savingsAccount.getBalance());
            savingsAccount.withdrawFunds(200);
            System.out.println("Balance after withdraw (200): " + savingsAccount.getBalance());
            savingsAccount.setInterestRate(30);
            System.out.println("Changed interest rate from 14.5 to: " + savingsAccount.getInterestRate());
            savingsAccount.depositFunds(100);
            System.out.println("Balance after deposit (100): " + savingsAccount.getBalance());

            System.out.println("\nTESTING: Current-Account");
            CurrentAccount currentAccountNoOverdraft = new CurrentAccount("abcdef",12345678);
            System.out.println("Current-Account without overdraft: " + currentAccountNoOverdraft.getOverdraft());
            currentAccountNoOverdraft.withdrawFunds(100);
            System.out.println("After withdrawal (100): " + currentAccountNoOverdraft.getBalance());

            System.out.println("Switching to Current-Account with overdraft...");
            CurrentAccount currentAccount = new CurrentAccount("abcdef",12345678,100,14.5f);
            currentAccount.withdrawFunds(3000);
            System.out.println("After withdrawal (3000): " + currentAccount.getBalance());
            System.out.println("Overdraft charges (14.5 percent): " + currentAccount.calculateOverdraftCharges());
            currentAccount.setOverdraftFee(100);
            System.out.println("Overdraft charges (100 percent): " + currentAccount.calculateOverdraftCharges());

            System.out.println("\nTESTING: ISA-Account");
            ISA isa1 = new ISA("abcdef",12345678);
            ISA isa2 = new ISA("abcdef",12345678);
            System.out.println("After withdrawal (100 - isa1): " + isa1.getBalance());
            isa1.depositFunds(100);
            isa2.depositFunds(100);
            System.out.println("After deposit (100 - isa1): " + isa1.getBalance());
            isa1.applyInterestRate();
            System.out.println("After applying interest rate (isa1): " + isa1.getBalance());
            isa1.withdrawFunds(14.5f);
            System.out.println("Withdraw interest rate (isa1): " + isa1.getBalance());
            ISA.setInterestRate(30);
            isa1.applyInterestRate();
            isa2.applyInterestRate();
            System.out.println("Change interest rate to 30 and apply (isa1, isa2): " + isa1.getBalance() + ", " + isa2.getBalance());

            // Test page 2 of specification document
            System.out.println("\n\nTESTING: Customer");
            Customer customer = new Customer("Test", "User", savingsAccount, currentAccount, isa1, isa2);
            System.out.println("--- Accounts added ---");
            System.out.println(customer);
            System.out.println("--- Update interest for customer ---");
            customer.applyInterestRate();
            System.out.println(customer);
        } catch (IllegalArgumentException e) {
            System.out.println("\nTestet ended early with message:");
            System.out.println(e.getMessage());
        }
    }
}

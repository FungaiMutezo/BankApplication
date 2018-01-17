package com.fungaimutezo.accounts;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount {
    private final float maxOverdraft;
    private float overdraftChargesInterestRate;

    public CurrentAccount(String sortCode, int accountNumber) {
        super(sortCode, accountNumber);

        maxOverdraft = 0;
    }

    public CurrentAccount(String sortCode, int accountNumber, float overdraftChargesInterestRate) {
        super(sortCode, accountNumber);

        this.maxOverdraft = 2500;
        this.overdraftChargesInterestRate = overdraftChargesInterestRate;
    }

    @Override
    public void withdrawFunds(float amount) {
        if(balance + maxOverdraft >= amount) {
            super.withdrawFunds(amount);
        } else {
            super.withdrawFunds(balance + maxOverdraft);
        }
    }

    public float calculateOverdraftCharges() {
        if(balance < 0) {
            return abs(balance) * (overdraftChargesInterestRate / 100);
        } else {
            return 0;
        }
    }

    public void setOverdraftChargesInterestRate(float overdraftChargesInterestRate) {
        if(maxOverdraft == 0) {
            System.out.println("ERROR: Max. overdraft must be filled.");
            return;
        }

        this.overdraftChargesInterestRate = overdraftChargesInterestRate;
    }

    @Override
    public String toString() {
        return "Account-Type: Current-Account\nMax.-Overdraft: " + maxOverdraft +
                "\nOverdraft-Charge-Rate: " + overdraftChargesInterestRate +
                "\n" + super.toString();
    }

    public float getMaxOverdraft() {
        return maxOverdraft;
    }

    public float getOverdraftChargesInterestRate() {
        return overdraftChargesInterestRate;
    }
}

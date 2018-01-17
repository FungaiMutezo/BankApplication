package com.fungaimutezo.accounts;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount {
    private float maxOverdraft = 2500.0f;
    private float overdraftChargesInterestRate;

    public CurrentAccount(String sortCode, int accountNumber, float overdraftChargesInterestRate) {
        super(sortCode, accountNumber);

        if(overdraftChargesInterestRate != 0) {
            this.overdraftChargesInterestRate = overdraftChargesInterestRate;
        } else {
            maxOverdraft = 0;
        }
    }

    public CurrentAccount(String sortCode, int accountNumber, float maxOverdraft, float overdraftChargesInterestRate) {
        super(sortCode, accountNumber);

        this.maxOverdraft = maxOverdraft;
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

    public float calculateOvedraftCharges() {
        if(balance < 0) {
            return abs(balance) * (overdraftChargesInterestRate / 100);
        } else {
            return 0;
        }
    }

    public void setMaxOverdraft(float maxOverdraft) {
        if(overdraftChargesInterestRate == 0) {
            System.out.println("ERROR: Interest rate must be filled.");
            return;
        }

        this.maxOverdraft = maxOverdraft;
    }

    public void setOverdraftChargesInterestRate(float overdraftChargesInterestRate) {
        if(maxOverdraft == 0) {
            System.out.println("ERROR: Max. overdraft must be filled.");
            return;
        }

        this.overdraftChargesInterestRate = overdraftChargesInterestRate;
    }

    public void setOverdraftData(float maxOverdraft, float overdraftChargesInterestRate) {
        this.maxOverdraft = maxOverdraft;
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

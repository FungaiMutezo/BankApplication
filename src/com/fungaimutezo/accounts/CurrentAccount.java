package com.fungaimutezo.accounts;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount {
    private final static float MAX_ALLOWED_OVERDRAFT_VALUE = 2500;

    private float overdraft = 0;
    private float overdraftChargesInterestRate = 0;

    // Create a current-account without allowed overdraft.
    public CurrentAccount(String sortCode, int accountNumber) throws IllegalArgumentException {
        super(sortCode, accountNumber);
    }

    public CurrentAccount(String sortCode, int accountNumber, float overdraft, float overdraftChargesInterestRate) throws IllegalArgumentException {
        super(sortCode, accountNumber);

        if(overdraft < 0 || overdraftChargesInterestRate < 0) {
            throw new IllegalArgumentException("Overdraft and charge rate must be greater than zero.");
        } else if(overdraft > MAX_ALLOWED_OVERDRAFT_VALUE) {
            throw new IllegalArgumentException("Overdraft can't be higher than 2500.");
        }

        this.overdraft = overdraft;
        this.overdraftChargesInterestRate = overdraftChargesInterestRate;
    }

    @Override
    public void withdrawFunds(float amount) {
        if(balance + overdraft >= amount) {
            super.withdrawFunds(amount);
        } else {
            super.withdrawFunds(balance + overdraft);
        }
    }

    public float calculateOverdraftCharges() {
        if(balance < 0) {
            return abs(balance) * (overdraftChargesInterestRate / 100);
        } else {
            return 0;
        }
    }

    public void setOverdraftData(float overdraft, float overdraftChargesInterestRate) {
        if(overdraft <= 0 || overdraftChargesInterestRate <= 0) {
            throw new IllegalArgumentException("Overdraft and charge rate must be greater than zero.");
        } else if(overdraft > MAX_ALLOWED_OVERDRAFT_VALUE) {
            throw new IllegalArgumentException("Overdraft can't be higher than 2500.");
        }

        this.overdraft = overdraft;
        this.overdraftChargesInterestRate = overdraftChargesInterestRate;
    }

    public void setOverdraft(float overdraft) {
        if(overdraftChargesInterestRate == 0) {
            System.out.println("ERROR: Charge interest rate must be filled.\nPlease use setOverdraftData(...)");
            return;
        } else if(overdraft <= 0) {
            throw new IllegalArgumentException("Overdraft must be greater than zero.");
        } else if(overdraft > MAX_ALLOWED_OVERDRAFT_VALUE) {
            throw new IllegalArgumentException("Overdraft can't be higher than 2500.");
        }

        this.overdraft = overdraft;
    }

    public void setOverdraftChargesInterestRate(float overdraftChargesInterestRate) throws IllegalArgumentException {
        if(overdraft == 0) {
            System.out.println("ERROR: Max. overdraft must be filled.\nPlease use setOverdraftData(...)");
            return;
        } else if(overdraftChargesInterestRate <= 0) {
            throw new IllegalArgumentException("Interest rates must be greater than zero.");
        }

        this.overdraftChargesInterestRate = overdraftChargesInterestRate;
    }

    @Override
    public String toString() {
        return "Account-Type: Current-Account\nMax.-Overdraft: " + overdraft +
                "\nOverdraft-Charge-Rate: " + overdraftChargesInterestRate +
                "\n" + super.toString();
    }

    public float getOverdraft() {
        return overdraft;
    }

    public float getOverdraftChargesInterestRate() {
        return overdraftChargesInterestRate;
    }
}

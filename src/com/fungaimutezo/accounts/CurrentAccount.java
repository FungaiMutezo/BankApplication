package com.fungaimutezo.accounts;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount {
    private final static float MAX_ALLOWED_OVERDRAFT_VALUE = 2500;

    // The amount of overdraft currently allowed
    private float overdraft = 0;
    // The fee to apply for overdraft in percent (e.g. 14.5)
    private float overdraftFee = 0;

    // Create a current-account without allowed overdraft.
    public CurrentAccount(String sortCode, int accountNumber) throws IllegalArgumentException {
        super(sortCode, accountNumber);
    }

    public CurrentAccount(String sortCode, int accountNumber, float overdraft, float overdraftFee) throws IllegalArgumentException {
        super(sortCode, accountNumber);

        if(overdraft < 0 || overdraftFee < 0) {
            throw new IllegalArgumentException("Overdraft and charge rate must be greater than zero.");
        } else if(overdraft > MAX_ALLOWED_OVERDRAFT_VALUE) {
            throw new IllegalArgumentException("Overdraft can't be higher than " + MAX_ALLOWED_OVERDRAFT_VALUE + ".");
        }

        this.overdraft = overdraft;
        this.overdraftFee = overdraftFee;
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
            return abs(balance) * (overdraftFee / 100);
        } else {
            return 0;
        }
    }

    public void setOverdraftData(float overdraft, float overdraftFee) {
        if(overdraft <= 0 || overdraftFee <= 0) {
            throw new IllegalArgumentException("Overdraft and charge rate must be greater than zero.");
        } else if(overdraft > MAX_ALLOWED_OVERDRAFT_VALUE) {
            throw new IllegalArgumentException("Overdraft can't be higher than 2500.");
        }

        this.overdraft = overdraft;
        this.overdraftFee = overdraftFee;
    }

    public void setOverdraft(float overdraft) {
        if(overdraftFee == 0) {
            System.out.println("ERROR: Charge interest rate must be filled.\nPlease use setOverdraftData(...)");
            return;
        } else if(overdraft <= 0) {
            throw new IllegalArgumentException("Overdraft must be greater than zero.");
        } else if(overdraft > MAX_ALLOWED_OVERDRAFT_VALUE) {
            throw new IllegalArgumentException("Overdraft can't be higher than 2500.");
        }

        this.overdraft = overdraft;
    }

    public void setOverdraftFee(float overdraftFee) throws IllegalArgumentException {
        if(overdraft == 0) {
            System.out.println("ERROR: Max. overdraft must be filled.\nPlease use setOverdraftData(...)");
            return;
        } else if(overdraftFee <= 0) {
            throw new IllegalArgumentException("Interest rates must be greater than zero.");
        }

        this.overdraftFee = overdraftFee;
    }

    @Override
    public String toString() {
        return "Account-Type: Current-Account\nMax.-Overdraft: " + overdraft +
                "\nOverdraft-Charge-Rate: " + overdraftFee +
                "\n" + super.toString();
    }

    public float getOverdraft() {
        return overdraft;
    }

    public float getOverdraftFee() {
        return overdraftFee;
    }
}

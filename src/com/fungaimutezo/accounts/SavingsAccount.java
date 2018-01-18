package com.fungaimutezo.accounts;

public class SavingsAccount extends PersonalSaver {
    private float interestRate;

    public SavingsAccount(String sortCode, int accountNumber, float interestRate) throws IllegalArgumentException {
        super(sortCode, accountNumber);

        if(interestRate < 0) {
            throw new IllegalArgumentException("Interest rates must be greater than zero.");
        }

        this.interestRate = interestRate;
    }

    public void setInterestRate(float interestRate) throws IllegalArgumentException {
        if(interestRate < 0) {
            throw new IllegalArgumentException("Interest rates must be greater than zero.");
        }

        this.interestRate = interestRate;
    }

    @Override
    public void applyInterestRate() {
        applyInterestRate(interestRate);
    }

    @Override
    public String toString() {
        return "Account-Type: Savings-Account\nInterest-Rate: " + interestRate +
                "\n" + super.toString();
    }

    public float getInterestRate() {
        return interestRate;
    }
}

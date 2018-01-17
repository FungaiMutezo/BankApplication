package com.fungaimutezo.accounts;

public class SavingsAccount extends PersonalSaver {
    private float interestRate;

    public SavingsAccount(String sortCode, int accountNumber, float interestRate) {
        super(sortCode, accountNumber);

        this.interestRate = interestRate;
    }

    @Override
    public void updateInterestRate() {
        interestRate = updateInterestRate(interestRate);
    }

    public void setInterestRate(float interestRate) {
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
}

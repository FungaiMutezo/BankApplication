package com.fungaimutezo.accounts;

public abstract class PersonalSaver extends BankAccount {
    public PersonalSaver(String sortCode, int accountNumber) {
        super(sortCode, accountNumber);
    }

    @Override
    public void withdrawFunds(float amount) {
        if(balance >= amount) {
            super.withdrawFunds(amount);
        } else {
            super.withdrawFunds(balance);
        }
    }

    public abstract void updateInterestRate();

    protected float updateInterestRate(float interestRate) {
        return balance + (balance * (interestRate / 100));
    }

    public abstract void applyInterestRate();

    protected void applyInterestRate(float interestRate) {
        balance += balance * (interestRate / 100);
    }
}

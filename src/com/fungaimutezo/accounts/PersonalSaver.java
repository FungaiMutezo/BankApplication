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

    /**
     * Since subclasses have different ways to save interest rates (ISA - static, SavingsAccount - per object)
     * it can't be stored in this class. Through implementation of this method we can still gain access to
     * this functionality even when using polymorphism.
     *
     * E.g. PersonalSaver personalSaver = new SavingsAccount(...)
     * personalSaver.applyInterestRate();
     */
    public abstract void applyInterestRate();

    protected void applyInterestRate(float interestRate) {
        balance += balance * (interestRate / 100);
    }
}

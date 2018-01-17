package com.fungaimutezo.accounts;

import com.fungaimutezo.UIDGenerator;

public abstract class BankAccount {
    protected final int UID;
    protected String sortCode;
    protected int accountNumber;

    protected float balance;

    public BankAccount(String sortCode, int accountNumber) {
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;

        UID = UIDGenerator.generateUID();
    }

    /**
     * Method to deposit money (increase balance).
     *
     * @param amount The amount of money to deposit.
     * @return If the operation was successful.
     */
    public boolean depositFunds(float amount) {
        balance += amount;

        return true;
    }

    /**
     * Method to withdraw money (decrease balance).
     *
     * @param amount The amount of money to withdraw.
     * @return If the operation was successful.
     */
    public boolean withdrawFunds(float amount) {
        balance -= amount;

        return true;
    }

    @Override
    public String toString() {
        return "UID: " + UID +
                "\nSort-Code: " + sortCode +
                "\nAccount-Number: " + accountNumber +
                "\nBalance: " + balance;
    }
}

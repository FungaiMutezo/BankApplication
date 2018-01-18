package com.fungaimutezo.accounts;

import com.fungaimutezo.UIDGenerator;

public abstract class BankAccount {
    protected final int UID;
    protected String sortCode;
    protected int accountNumber;

    protected float balance;

    protected BankAccount(String sortCode, int accountNumber) throws IllegalArgumentException {
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;

        if(sortCode.length() != 6) {
            throw new IllegalArgumentException("Sortcode requires 6 digits.");
        } else if(String.valueOf(accountNumber).length() != 8) {
            throw new IllegalArgumentException("Accountnumber requires 8 digits.");
        }

        UID = UIDGenerator.generateUID();
    }

    /**
     * Method to deposit money (increase balance).
     *
     * @param amount The amount of money to deposit.
     */
    public void depositFunds(float amount) {
        balance += amount;
    }

    /**
     * Method to withdraw money (decrease balance).
     *
     * @param amount The amount of money to withdraw.
     */
    public void withdrawFunds(float amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "UID: " + UID +
                "\nSort-Code: " + sortCode +
                "\nAccount-Number: " + accountNumber +
                "\nBalance: " + balance;
    }

    public int getUID() {
        return UID;
    }

    public String getSortCode() {
        return sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }
}

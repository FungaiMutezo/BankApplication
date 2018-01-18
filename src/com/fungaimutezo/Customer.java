package com.fungaimutezo;

import com.fungaimutezo.accounts.BankAccount;
import com.fungaimutezo.accounts.PersonalSaver;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private final int UID;
    private String firstName, lastName;

    private ArrayList<BankAccount> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        UID = UIDGenerator.generateUID();

        accounts = new ArrayList<>();
    }

    public Customer(String firstName, String lastName, BankAccount... accounts) {
        this.firstName = firstName;
        this.lastName = lastName;

        UID = UIDGenerator.generateUID();

        this.accounts = new ArrayList<>(Arrays.asList(accounts));
    }

    public boolean addAccount(BankAccount account) {
        if(accounts.contains(account)) {
            return false;
        } else {
            accounts.add(account);

            return true;
        }
    }

    public void applyInterestRate() {
        for(BankAccount account : accounts) {
            // Only personal saving accounts have an applicable interest rate
            // (in contrast to e.g. current accounts)
            if(account instanceof PersonalSaver) {
                ((PersonalSaver) account).applyInterestRate();
            }
        }
    }

    /**
     * This method generates a report a user. It provides information on first & last name,
     * UID as well as String representations of connected accounts which vary by account
     * type. For this purpose all account types also implement toString methods. Since a
     * user can be connected to a large amount of accounts we don't want to use a lot of
     * String concatenations (Strings are immutable) and instead use the StringBuilder class.
     * This leads to faster performance and a smaller memory footprint.
     *
     * @return A string containing first and last name of the user as well as connected accounts.
     */
    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();

        data.append("Report for: ").append(firstName).append(" ").append(lastName).append(" (UID: ").append(UID).append(")\n");

        for(BankAccount account : accounts) {
            data.append(account).append("\n\n");
        }

        return data.toString();
    }

    public int getUID() {
        return UID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

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
            if(account instanceof PersonalSaver) {
                ((PersonalSaver) account).applyInterestRate();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();

        data.append("Report for: ").append(firstName).append(" ").append(lastName).append("\n");

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

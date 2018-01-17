package com.fungaimutezo.accounts;

public class ISA extends PersonalSaver {
    private static float interestRate = 14.5f;

    public ISA(String sortCode, int accountNumber) {
        super(sortCode, accountNumber);
    }

    public static void setInterestRate(float interestRate) {
        ISA.interestRate = interestRate;
    }

    public void updateInterestRate() {
        interestRate = updateInterestRate(interestRate);
    }

    public void applyInterestRate() {
        applyInterestRate(interestRate);
    }

    @Override
    public String toString() {
        return "Account-Type: ISA\nInterest-Rate: " + interestRate +
                "\n" + super.toString();
    }
}

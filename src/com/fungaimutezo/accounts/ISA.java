package com.fungaimutezo.accounts;

public class ISA extends PersonalSaver {
    private static float interestRate = 14.5f;

    public ISA(String sortCode, int accountNumber) throws IllegalArgumentException {
        super(sortCode, accountNumber);
    }

    public static void setInterestRate(float interestRate) throws IllegalArgumentException {
        if(interestRate < 0) {
            throw new IllegalArgumentException("Interest rates must be greater than zero.");
        }

        ISA.interestRate = interestRate;
    }

    @Override
    public void applyInterestRate() {
        applyInterestRate(interestRate);
    }

    @Override
    public String toString() {
        return "Account-Type: ISA\nInterest-Rate: " + interestRate +
                "\n" + super.toString();
    }

    public static float getInterestRate() {
        return interestRate;
    }
}

package uk.ac.ncl.teach.ex.factory.acc;

public interface Account {
    void deposit(int amount);

    int getAccountNumber();

    int getBalance();

    void transferBalance(Account acc);

    int withdraw(int amount);
}
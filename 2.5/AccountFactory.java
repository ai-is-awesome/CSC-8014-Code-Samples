package uk.ac.ncl.teach.ex.factory.acc;

import java.util.HashMap;
import java.util.Map;

// abstract class providing partial implementation of Account
public abstract class AccountFactory implements Account {
    public static final String FREE_ACCOUNT = "free";
    public static final String OVERDRAFT_ACCOUNT = "overdraft";

    // map of account number to instantiated account
    // note static, so per-class map
    private static final Map<Integer, Account> accounts = new HashMap<Integer, Account>();
    private final int accountNumber;
    private int balance;
    private static int nbOverdraft = 0;

    AccountFactory(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Return an account of the specified type with the specified
     * account number.
     *
     * @param account       the type of account to return
     * @param accountNumber the account number
     * @return an account of the specified type. An existing account
     *         is returned if accountNumber is already known. Otherwise
     *         a new account with the given number is returned.
     * @throws NullPointerException     if accountType is null
     * @throws IllegalArgumentException if accountType is an
     *                                  invalid accounttype
     */
    public static Account getInstance(String account, int accountNumber) {
        // enforce single instance per accountNumber
        Account acc = accounts.get(accountNumber);

        if (acc != null) // impose uniqueness
            return acc;

        if (account.equals(FREE_ACCOUNT)) {
            acc = new FreeAccount(accountNumber);
        } else if (account.equals(OVERDRAFT_ACCOUNT)) {
            if (nbOverdraft < 3) {
                acc = new OverdraftAccount(accountNumber);
                nbOverdraft = nbOverdraft + 1;
            } else {
                acc = new FreeAccount(accountNumber);
            }
        } else {
            throw new IllegalArgumentException("invalid account type: " + account);
        }

        // put acc in accounts map
        accounts.put(accountNumber, acc);

        // return the instance
        return acc;
    }

    public void deposit(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Negative deposit: " + amount);

        balance = balance + amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void transferBalance(Account acc) {
        final int accBalance = acc.getBalance();
        
        if (accBalance < 0) 
            throw new IllegalArgumentException("Transfer from overdrawn account not allowed: " + acc);
        
        deposit(acc.withdraw(accBalance));
    }

    public String toString() {
        return "account number: " + accountNumber + " (balance: " + balance + ")";
    }

    // utility method to allow subclasses to set the account balance
    void setBalance(int balance) {
        this.balance = balance;
    }
}
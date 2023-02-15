package uk.ac.ncl.teach.ex.factory.acc;

/**
 * OverdraftAccount - bank account that allows overdrafts that
 * incur a charge. This OverdraftAccount can only be instantiated
 * by classes in this same package.
 * Use AccountFactory.getInstance("overdraft") to get an instance.
 *
 */
// package-private class definition
// - cannot be imported to other packages
final class OverdraftAccount extends AccountFactory {
    private final static int OVERDRAFT_CHARGE = 10;

    // package-private constructor cannot be directly instantiated by
    // clients outside this package.
    // Use AccountFactory.getInstance("overdraft") instead.
    OverdraftAccount(int accountNumber) {
        super(accountNumber);
    }

    /**
     * Withdraw allows accounts to go into to the red and imposes
     * a fixed charge for withdrawals from overdrawn accounts.
     * 
     * @see uk.ac.ncl.teach.ex.factory.acc.Account#withdraw(int)
     */
    public int withdraw(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Negative withdrawal: " + amount);

        final int newBalance = getBalance() - amount;

        if (newBalance < 0) {
            setBalance(newBalance - OVERDRAFT_CHARGE);
        } else {
            setBalance(newBalance);
        }

        return amount;
    }
}
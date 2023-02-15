package uk.ac.ncl.teach.ex.factory.acc;

/**
 * FreeAccount - bank account with no overdraft and no charges.
 * This FreeAccount can only be instantiated by classes in
 * this same package. Use the AccountFactory.getInstance("free")
 * to get an instance.
 *
 */
// package-private class definition
// - cannot be imported to other packages
final class FreeAccount extends AccountFactory {
    // package-private constructor cannot be directly instantiated by
    // clients outside this package.
    // Use AccountFactory.getInstance("free") instead.
    FreeAccount(int accountNumber) {
        super(accountNumber);
    }

    /**
     * A withdrawal that puts the account into the red will not
     * be permitted.
     * 
     * @see uk.ac.ncl.teach.ex.factory.acc.Account#withdraw(int)
     */
    public int withdraw(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Negative withdrawal: " + amount);

        final int currentBalance = getBalance();

        if (currentBalance < amount)
            return 0;

        setBalance(currentBalance - amount);

        return amount;
    }
}
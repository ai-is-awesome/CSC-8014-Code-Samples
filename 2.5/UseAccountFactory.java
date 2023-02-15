public package uk.ac.ncl.teach.ex.factory;

import uk.ac.ncl.teach.ex.factory.acc.Account;
import uk.ac.ncl.teach.ex.factory.acc.AccountFactory;

// cannot import FreeAccount or OverdraftAccount since they are package private
//import uk.ac.ncl.teach.ex.factory.acc.FreeAccount; 
//import uk.ac.ncl.teach.ex.factory.acc.OverdraftAccount; 
public class UseAccountFactory {
    public static void main(String[] args) {
        System.out.println("Using account factory");
        /*
         * // cannot create a FreeAccount directly because we've limited access (is
         * pkg-private)
         * //FreeAccount f = new FreeAccount(); // won't work
         * 
         * // get free account with number 1234
         * final Account freeAccount1 =
         * AccountFactory.getInstance(AccountFactory.FREE_ACCOUNT, 1234);
         * 
         * // try to get another free account with number 1234.
         * // If factory imposes uniqueness this will be the same instance
         * final Account freeAccount2 =
         * AccountFactory.getInstance(AccountFactory.FREE_ACCOUNT, 1234);
         * 
         * // check that freeAccount1 == freeAccount2 - same instance
         * System.out.println("Only have single instance of freeAccount "
         * + freeAccount1.getAccountNumber() + ": "
         * + (freeAccount1 == freeAccount2));
         * // freeAccount1 and freeAccount2 are same
         * printAccountInfo(AccountFactory.FREE_ACCOUNT, freeAccount1);
         * printAccountInfo(AccountFactory.FREE_ACCOUNT, freeAccount2);
         * 
         */
        // now we demo an overdraftAccount
        final Account overdraftAccount1 = AccountFactory.getInstance(AccountFactory.OVERDRAFT_ACCOUNT, 4567);
        printAccountInfo("", overdraftAccount1);
        final Account overdraftAccount2 = AccountFactory.getInstance(AccountFactory.OVERDRAFT_ACCOUNT, 5678);
        printAccountInfo("", overdraftAccount2);
        final Account overdraftAccount3 = AccountFactory.getInstance(AccountFactory.OVERDRAFT_ACCOUNT, 6789);
        printAccountInfo("", overdraftAccount3);
        final Account overdraftAccount4 = AccountFactory.getInstance(AccountFactory.OVERDRAFT_ACCOUNT, 7890);
        printAccountInfo("", overdraftAccount4);
        final Account overdraftAccount5 = AccountFactory.getInstance(AccountFactory.OVERDRAFT_ACCOUNT, 8901);
        printAccountInfo("", overdraftAccount5);

    }

    private static void printAccountInfo(String accType, Account account) {
        System.out.println(accType + " " + account + " is implemented by: " +
                account.getClass());
    }
}

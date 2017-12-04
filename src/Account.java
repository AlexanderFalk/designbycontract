public class Account {

    private /*@ spec_public @*/ double account_balance;

    //@ public invariant account_balance >= 0;

    //@ assignable account_balance;
    //@ ensures account_balance == 0;
    public Account() {
        this.account_balance = 0;
    }

    //@ assignable account_balance;
    //@ ensures account_balance \old(account_balance) + amount;
    public double deposit(double amount) {
        return this.account_balance += amount;
    }

    //@ requires amount > 0 && account_balance > amount;
    //@ assignable account_balance > 0;
    //@ ensures account_balance \old(account_balance) - amount;
    //@ also
    //@ requires account_balance < amount
    //@ signals_only BankException(String message);
    public double withdraw(double amount) throws BankException {
        if(amount <= this.account_balance)
            return this.account_balance -= amount;
        else {
            throw new BankException("The balance is too low compared to the withdrawn amount.");
        }
    }

    //@ ensures \result == account_balance;
    //@ pure
    public /*@ pure @*/ double getAccount_balance() {
        return account_balance;
    }
}

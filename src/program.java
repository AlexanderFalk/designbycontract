public class program {



    public static void main(String[] args) throws BankException {
        Account bank = new Account();
        bank.deposit(100);
        System.out.println(bank.getAccount_balance());
        bank.withdraw(99);
        System.out.println(bank.getAccount_balance());
    }

}

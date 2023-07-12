import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private BankCustomer customer;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, BankCustomer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankCustomer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String transaction = "Dépôt : +" + amount + "€";
            transactionHistory.add(transaction);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String transaction = "Retrait : -" + amount + "€";
            transactionHistory.add(transaction);
        }
    }

    public void transfer(double amount, Account targetAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            String transaction = "Virement vers le compte " + targetAccount.getAccountNumber() + " : -" + amount + "€";
            transactionHistory.add(transaction);
            targetAccount.addTransferTransaction(this.getAccountNumber(), amount);
            System.out.println("Virement effectué avec succès.");
        } else {
            System.out.println("Montant invalide ou solde insuffisant.");
        }
    }

    private void addTransferTransaction(String sourceAccountNumber, double amount) {
        String transaction = "Virement reçu depuis le compte " + sourceAccountNumber + " : +" + amount + "€";
        transactionHistory.add(transaction);
    }


    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class ATM {
    private Map<String, Account> accounts;
    private Scanner scanner;
    private String accountNumber;

    public ATM() {
        this.accounts = new HashMap<>();
        this.scanner = new Scanner(System.in);
        initializeAccounts();
    }

    private void initializeAccounts() {
        BankCustomer customer1 = new BankCustomer("Karim", "123 Rue Principale", "12345", "Paris");
        Account account1 = new Account("123", customer1);
        accounts.put(account1.getAccountNumber(), account1);

        BankCustomer customer2 = new BankCustomer("Sofiane", "456 Rue Secondaire", "67890", "Lyon");
        Account account2 = new Account("12345", customer2);
        account2.deposit(600.0);
        accounts.put(account2.getAccountNumber(), account2);

        BankCustomer customer3 = new BankCustomer("Nadir", "789 Rue Tertiaire", "54321", "Marseille");
        Account account3 = new Account("123456", customer3);
        account3.deposit(200.0);
        accounts.put(account3.getAccountNumber(), account3);
    }

    public void displayMenu() {
    System.out.println("╔═════════════════════════════╗");
    System.out.println("           Bienvenue           ");
    System.out.println("        " + getAccountByNumber(accountNumber).getCustomer().getName() + " !       ");
    System.out.println("╚═════════════════════════════╝");
    System.out.println();
    System.out.println("╔════════════════════════════════╗");
    System.out.println("║            ATM  Menu           ║");
    System.out.println("╠════════════════════════════════╣");
    System.out.println("║ [1]. Consulter le solde        ║");
    System.out.println("║ [2]. Déposer de l'argent       ║");
    System.out.println("║ [3]. Retirer de l'argent       ║");
    System.out.println("║ [4]. Historique des opérations ║");
    System.out.println("║ [5]. Modifier les informations ║");
    System.out.println("║      du client                 ║");
    System.out.println("║ [6]. Visualiser les            ║");
    System.out.println("║      informations              ║");
    System.out.println("║ [7]. Effectuer un virement     ║");
    System.out.println("║ [8]. Quitter                   ║");
    System.out.println("╚════════════════════════════════╝");
	System.out.println();
    System.out.print("Choisissez une option : ");
}


    public void performAction(int choice) {
        switch (choice) {
            case 1:
                Account account = getAccountByNumber(accountNumber);
                double balance = account.getBalance();
                System.out.println("════════════════════════════════");
                System.out.println("   Solde actuel: " + balance + "€");
                break;
            case 2:
                account = getAccountByNumber(accountNumber);
                System.out.println("════════════════════════════════");
                System.out.print("Entrez le montant à déposer : ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Montant déposé avec succès.");
                break;
            case 3:
                account = getAccountByNumber(accountNumber);
                System.out.println("════════════════════════════════");
                System.out.print("Entrez le montant à retirer : ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                System.out.println("Montant retiré avec succès.");
                break;
            case 4:
                account = getAccountByNumber(accountNumber);
                System.out.println("════════════════════════════════");
                System.out.println("Historique des opérations :");
                ArrayList<String> transactionHistory = account.getTransactionHistory();
                if (transactionHistory.isEmpty()) {
                    System.out.println("Aucune opération enregistrée.");
                } else {
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                }
                break;
            case 5:
                System.out.println("════════════════════════════════");
                System.out.print("Entrez le nouveau nom : ");
                scanner.nextLine(); // Consomme le caractère de nouvelle ligne en attente
                String name = scanner.nextLine();
                BankCustomer customer = getAccountByNumber(accountNumber).getCustomer();
                customer.updateName(name);
                System.out.println("Informations du client mises à jour avec succès.");
                break;
            case 6:
                System.out.println("════════════════════════════════");
                account = getAccountByNumber(accountNumber);
                account.getCustomer().displayInfo();
                break;
            case 7:
                System.out.println("════════════════════════════════");
                System.out.println("Liste des comptes disponibles :");
                displayAccountList();
                System.out.print("Entrez le numéro du compte bénéficiaire : ");
                String targetAccountNumber = scanner.next();
                Account targetAccount = getAccountByNumber(targetAccountNumber);
                if (targetAccount != null) {
                    System.out.print("Entrez le montant à transférer : ");
                    double amount = scanner.nextDouble();
                    account = getAccountByNumber(accountNumber);
                    account.transfer(amount, targetAccount);
                } else {
                    System.out.println("Compte bénéficiaire introuvable.");
                }
                break;
            case 8:
                System.out.println("Merci d'avoir utilisé notre ATM. À bientôt !");
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                break;
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.displayAccountCreationPrompt();
        atm.enterAccountNumber();
        while (true) {
            atm.displayMenu();
            int choice = atm.scanner.nextInt();
            atm.performAction(choice);
        }
    }

    private void displayAccountList() {
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            String accountNumber = entry.getKey();
            String customerName = entry.getValue().getCustomer().getName();
            System.out.println(accountNumber + " - " + customerName);
        }
    }

    private void displayAccountCreationPrompt() {
        System.out.print("Avez-vous déjà un compte bancaire ? (Oui/Non) : ");
        String hasAccount = scanner.nextLine();

        if (hasAccount.equalsIgnoreCase("Non")) {
            System.out.print("Création d'un nouveau compte bancaire.\nEntrez votre nom : ");
            String name = scanner.nextLine();
            System.out.print("Entrez votre adresse : ");
            String address = scanner.nextLine();
            System.out.print("Entrez votre code postal : ");
            String postalCode = scanner.nextLine();
            System.out.print("Entrez votre ville : ");
            String city = scanner.nextLine();
            System.out.print("Entrez le numéro de compte : ");
            String accountNumber = scanner.nextLine();

            BankCustomer customer = new BankCustomer(name, address, postalCode, city);
            Account account = new Account(accountNumber, customer);
            accounts.put(accountNumber, account);

            System.out.println("Compte créé avec succès !\nBienvenue !");
        }
    }

    private Account getAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    private void enterAccountNumber() {
        System.out.print("Entrez votre numéro de compte : ");
        accountNumber = scanner.nextLine();
        Account account = getAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Numéro de compte invalide. Le programme se termine.");
            System.exit(0);
        }
    }

}

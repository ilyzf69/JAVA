public class Main {
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
}

import java.util.Scanner;

public class DistributeurBillets {
    private static final int SOLDE_INITIALE = 1000;
    private static final int CODE_CORRECT = 1234;
    private static final int MONTANT_MINIMUM = 20;
    private int solde;
    private int tentativesRestantes;
    private String prenom;

    public DistributeurBillets(String prenom) {
        this.solde = SOLDE_INITIALE;
        this.tentativesRestantes = 3;
        this.prenom = prenom;
    }

    public void insererCarte() {
        System.out.println("--------------------------------------------------");
        System.out.println("           DISTRIBUTEUR DE BILLETS");
        System.out.println("--------------------------------------------------");
        System.out.println("Bonjour " + prenom + " !");
        System.out.println("Insérez vôtre carte.");
    }

    public boolean verifierCode(int code) {
        if (code == CODE_CORRECT) {
            tentativesRestantes = 3;
            return true;
        } else {
            tentativesRestantes--;
            if (tentativesRestantes > 0) {
                System.out.println("Code incorrect. Tentatives restantes : " + tentativesRestantes);
            } else {
                System.out.println("Code incorrect. Votre carte est avalée.");
            }
            return false;
        }
    }

    public void afficherMenu() {
        clearConsole();
        System.out.println("--------------------------------------------------");
        System.out.println("           DISTRIBUTEUR DE BILLETS");
        System.out.println("--------------------------------------------------");
        System.out.println("Bonjour " + prenom + " !");
        System.out.println("[1]. Retrait");
        System.out.println("[2]. Sortir du distributeur");
        afficherSolde();
    }

    public void retirerArgent(Scanner scanner) {
        System.out.print("Montant à retirer : ");
        int montant = scanner.nextInt();

        if (montant >= MONTANT_MINIMUM && montant <= solde) {
            System.out.println("------------------------------");
            System.out.println("Vous avez demandé de retirer " + montant + " €.");
            System.out.println("Voulez-vous continuer ? (O/N)");
            String choixConfirmation = scanner.next();
            if (choixConfirmation.equalsIgnoreCase("O")) {
                System.out.println("------------------------------");
                System.out.println("Veuillez choisir la coupure :");
                System.out.println("[1]. Grosse coupure");
                System.out.println("[2]. Petite coupure");
                System.out.print("Vôtre choix : ");
                int choixCoupure = scanner.nextInt();

                if (choixCoupure == 1) {
                    int billets50 = montant / 50;
                    int reste = montant % 50;
                    if (reste >= 10 && reste < 20) {
                        billets50--;
                        reste += 50;
                    }
                    System.out.println("------------------------------");
                    System.out.println("Vous avez retirez " + billets50 + " billet(s) de 50€.");
                    if (reste > 0) {
                        System.out.println("Vous avez retirez " + reste + " € en petite coupure.");
                    }
                } else if (choixCoupure == 2) {
                    int billets20 = montant / 20;
                    int billets10 = (montant % 20) / 10;
                    int reste = (montant % 20) % 10;
                    System.out.println("------------------------------");
                    System.out.println("Vous avez retirez " + billets20 + " billet(s) de 20€ et " + billets10 + " billet(s) de 10€.");
                    if (reste > 0) {
                        System.out.println("Vous avez retirez " + reste + " € en pièces.");
                    }
                } else {
                    System.out.println("------------------------------");
                    System.out.println("Option invalide. Retrait annulé.");
                    return;
                }

                solde -= montant;
                System.out.println("Retrait effectué : " + montant + " €");
            } else {
                System.out.println("------------------------------");
                System.out.println("Retrait annulé.");
            }
        } else {
            System.out.println("------------------------------");
            System.out.println("Montant invalide ou solde insuffisant !");
        }
        afficherSolde();
    }

    public void afficherSolde() {
        System.out.println("------------------------------");
        System.out.println("Solde actuel : " + solde + " €");
        System.out.println("------------------------------");
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du nettoyage de la console.");
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DistributeurBillets distributeur = new DistributeurBillets("Ilyes Aïdoudi");
        Scanner scanner = new Scanner(System.in);

        distributeur.insererCarte();

        boolean codeValide = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Veuillez entrer vôtre code : ");
            int code = scanner.nextInt();
            codeValide = distributeur.verifierCode(code);
            if (codeValide) {
                break;
            }
        }

        if (codeValide) {
            boolean sortir = false;
            while (!sortir) {
                distributeur.afficherMenu();
                System.out.print("Vôtre choix : ");
                int choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        distributeur.retirerArgent(scanner);
                        break;
                    case 2:
                        System.out.println("------------------------------");
                        System.out.println("Sortie du distributeur.");
                        sortir = true;
                        break;
                    default:
                        System.out.println("------------------------------");
                        System.out.println("Choix invalide !");
                }
                System.out.println();
            }
        }

        System.out.println("------------------------------");
        System.out.println("Au revoir !");
        System.out.println("------------------------------");
        scanner.close();
    }
}

import java.util.Scanner;

public class Exo4 {
    public static void main(String[] args) {
        clearConsole();
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de saisir un nombre entier
        System.out.print("Entrez un nombre entier : ");
        int nombre = scanner.nextInt();

        // Conversion en binaire, octal et hexadecimal
        String binaire = Integer.toBinaryString(nombre);
        String octal = Integer.toOctalString(nombre);
        String hexa = Integer.toHexString(nombre);

        // Affichage des resultats
        System.out.println("Valeur en binaire : " + binaire);
        System.out.println("Valeur en octal : " + octal);
        System.out.println("Valeur en hexadecimal : " + hexa);
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
        } catch (final Exception e) {
            // Ignorer les erreurs lors de l'effacement de l'affichage
        }
    }
}

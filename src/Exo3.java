import java.util.Random;
import java.util.Scanner;

public class Exo3 {
    public static void main(String[] args) {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;  // Plage minimale du prix
        int maxRange = 100;  // Plage maximale du prix
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        
        System.out.println("Bienvenue dans le jeu du Juste Prix !");
        System.out.println("Un nombre aleatoire entre 1 et 100 a ete genere.");
        System.out.println("Vous devez deviner ce nombre en faisant le moins de tentatives possible.");
        System.out.println("Entrez votre proposition :");
        
        long startTime = System.currentTimeMillis();  // Temps de depart
        
        int userGuess;
        int numAttempts = 0;
        
        do {
            userGuess = scanner.nextInt();
            numAttempts++;
            
            if (userGuess < randomNumber) {
                System.out.println("C'est plus !");
            } else if (userGuess > randomNumber) {
                System.out.println("C'est moins !");
            } else {
                System.out.println("Bravo, vous avez trouve le juste prix en " + numAttempts + " tentative(s) !");
            }
        } while (userGuess != randomNumber);
        
        long endTime = System.currentTimeMillis();  // Temps d'arrêt
        long totalTime = endTime - startTime;  // Temps ecoule en millisecondes
        
        System.out.println("Temps ecoule : " + totalTime / 1000 + " secondes");
        
        scanner.close();
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

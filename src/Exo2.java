import java.util.Random;

public class Exo2 {
    public static void main(String[] args) {
        clearConsole();
        int count = 0;
        
        while (true) {
            int num1 = generateRandomNumber();
            int num2 = generateRandomNumber();
            int num3 = generateRandomNumber();
            
            count++;
            
            if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 != 0) {
                System.out.println("Combinaison trouvee apres " + count + " essais.");
                System.out.println("Nombre de la combinaison : " + num1 + ", " + num2 + ", " + num3 + "\n");
                break;
            }
        }
    }
    
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1001);
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

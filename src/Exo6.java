public class Exo6 {
    private String nom;
    private String prenom;
    private String adresse;
    private int codePostal;
    private String ville;

    public Exo6(String nom, String prenom, String adresse, int codePostagit l, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public static void main(String[] args) {
        clearConsole();
        // Test du bon fonctionnement de la classe Exo6
        Exo6 client = new Exo6("Dupont", "Jean", "123 Rue de la Poste", 75001, "Paris");
        System.out.println("Nom du client : " + client.getNom());
        System.out.println("Prenom du client : " + client.getPrenom());
        System.out.println("Adresse du client : " + client.getAdresse());
        System.out.println("Code postal du client : " + client.getCodePostal());
        System.out.println("Ville du client : " + client.getVille());
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
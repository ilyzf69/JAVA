public class Exo7 {
    private int numero;
    private String date;
    private Client client;
    private String[] articles;
    private int[] quantites;

    public Exo7(int numero, String date, Client client, String[] articles, int[] quantites) {
        this.numero = numero;
        this.date = date;
        this.client = client;
        this.articles = articles;
        this.quantites = quantites;
    }

    public int getNumero() {
        return numero;
    }

    public String getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public String[] getArticles() {
        return articles;
    }

    public int[] getQuantites() {
        return quantites;
    }

    public static void main(String[] args) {
        clearConsole();
        String[] articles = {"Article 1", "Article 2", "Article 3"};
        int[] quantites = {2, 1, 3};
        Client client = new Client("Mirak", "Karim", "90 rue Parmentier", 69400, "Villefranche s/s");
        Exo7 commande = new Exo7(1, "2023-07-12", client, articles, quantites);
        System.out.println("Numero de commande : " + commande.getNumero());
        System.out.println("Date de commande : " + commande.getDate());
        System.out.println("Client : " + commande.getClient().getNom() + " " + commande.getClient().getPrenom());
        System.out.println("Articles commandes : ");
        for (int i = 0; i < commande.getArticles().length; i++) {
            System.out.println(commande.getArticles()[i] + " - Quantite : " + commande.getQuantites()[i]);
        }
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
        }
    }
}

class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private int codePostal;
    private String ville;

    public Client(String nom, String prenom, String adresse, int codePostal, String ville) {
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
}
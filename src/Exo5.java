public class Exo5 {
    private String reference;
    private String designation;
    private double prix;

    public Exo5(String reference, String designation, double prix) {
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public static void main(String[] args) {
        clearConsole();
        Exo5 article = new Exo5("REF001", "Article 1", 19.99);
        System.out.println("Article : " + article.getDesignation());
        System.out.println("Prix : " + article.getPrix());
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

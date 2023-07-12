import java.util.HashMap;
import java.util.Map;

public class Utilisateur {
    private String idCarte;
    private String prenom;

    private static Map<String, Utilisateur> utilisateurs = new HashMap<>();

    public Utilisateur(String idCarte, String prenom) {
        this.idCarte = idCarte;
        this.prenom = prenom;
    }

    public String getIdCarte() {
        return idCarte;
    }

    public String getPrenom() {
        return prenom;
    }

    public static Utilisateur getUtilisateurByIdCarte(String idCarte) {
        return utilisateurs.get(idCarte);
    }

    static {
        utilisateurs.put("123456789", new Utilisateur("123456789", "Alice"));
        utilisateurs.put("987654321", new Utilisateur("987654321", "Bob"));
        utilisateurs.put("111111111", new Utilisateur("111111111", "Eve"));
    }
}

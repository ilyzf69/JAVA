public class BankCustomer {
    private String name;
    private String address;
    private String postalCode;
    private String city;

    private String customer;

    public BankCustomer(String name, String address, String postalCode, String city) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.customer = customer;
    }

    public void updateName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("     Informations du client     ");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("Nom          : " + name);
        System.out.println("Adresse      : " + address);
        System.out.println("Code postal  : " + postalCode);
        System.out.println("Ville        : " + city);
        System.out.println();
    }

}

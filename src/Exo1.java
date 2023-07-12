import java.util.Arrays;

public  class Exo1  
{	 
     static String[] adresses; 
     static String[] listeBruteFournisseurs; 
     static String[] listeFournisseursDistincts; 
     static int[] nombreClients;
     
     public static void main(String[] args) 
     { 
          //INITIALISATION DU TABLEAU
          clearConsole();
         adresses=new String[10];
         adresses[0]="jpp@sfr.fr";
         adresses[1]="tom@gmail.com";
         adresses[2]="fred@sfr.fr";
         adresses[3]="victor@sfr.fr"; 
         adresses[4]="chris@sfr.fr"; 
         adresses[5]="robert@orange.fr"; 
         adresses[6]="paul@sfr.fr"; 
         adresses[7]="lise@gmail.com"; 
         adresses[8]="thierry@isitech.fr"; 
         adresses[9]="marie@isitech.fr"; 
         
         //RECUPERATION DES FOURNISSEURS DE CHAQUE ADRESSE
         listeBruteFournisseurs =new String[10]; 
         for (int i=0;i<adresses.length;i++) 
         { 
        	 //Pour chaque adresse, récupération de la chaine après le @:
             listeBruteFournisseurs[i]=adresses[i].substring(adresses[i].indexOf('@')+1); 
         } 
         System.out.println("\n Liste brute des fournisseurs:");
         System.out.println(Arrays.toString(listeBruteFournisseurs));
         
         //RECUPERATION DE LA LISTE DES FOURNISSEURS DISTINCTS ET NOMBRE CLIENTS
         //1-Trier le tableau
         Arrays.sort(listeBruteFournisseurs);
         System.out.println("\n Liste triee des fournisseurs:");
         System.out.println(Arrays.toString(listeBruteFournisseurs));
         //2-Initialiser le tableau des fournisseurs distincts avec une taille de 1 (car il y a au moins 1 fournisseur)
         //et initialiser le tableau du nombre de clients par fournisseurs
         listeFournisseursDistincts = new String[1];
         nombreClients = new int[1];
         //3-Ajouter le premier fournisseur et lui associer 1 client:
         listeFournisseursDistincts[0]=listeBruteFournisseurs[0];
         nombreClients[0]=1;
         //4-Parcourir le tableau trié des fournisseurs pour détecter d'éventuels autres fournisseurs
         //Le parcours commence à l'index 1 car celui de l'index 0 a été ajouté à la liste des fournisseurs distincts
         for(int i=1;i<listeBruteFournisseurs.length;i++)
         {
        	 //5-Si le fournisseur actuel est différent du dernier fournisseur distinct ajouté
        	 //C'est que c'est un nouveau fournisseur.
        	 if(!listeBruteFournisseurs[i].equals(listeFournisseursDistincts[listeFournisseursDistincts.length-1]))
        	 {
        		//Agrandir le tableau des fournisseurs distincts d'une case
        		//et agrandir le tableau du nompbre de clients d'une case
        		listeFournisseursDistincts = Arrays.copyOf(listeFournisseursDistincts, listeFournisseursDistincts.length+1);
        		nombreClients = Arrays.copyOf(nombreClients, nombreClients.length+1);
        		//Ajouter ce nouveau fournisseur dans le tableau et lui associer 1 client
        		listeFournisseursDistincts[listeFournisseursDistincts.length-1]=listeBruteFournisseurs[i];
        		nombreClients[nombreClients.length-1]=1;
        	 }
        	 else
        	 {
        		 //C'est un fournisseur déjà référencé, il suffit d'ajouter un client
        		 nombreClients[nombreClients.length-1]+=1;
        	 }
         }
         System.out.println("\n Liste des fournisseurs distincts:");
         System.out.println(Arrays.toString(listeFournisseursDistincts));
         System.out.println("\n Nombre de clients pour chaque fournisseurs");
         System.out.println(Arrays.toString(nombreClients));
         
         //AFFICHAGE DE LA PART DE MARCHE DE CHACUN DES FOURNISSEURS:
         System.out.println("\n Parts de marce:");
         for(int i=0;i<listeFournisseursDistincts.length;i++)
         {
        	 System.out.println(String.format("=> %s \t: %d clients sur %d (%.1f%%)"
        			 											, listeFournisseursDistincts[i]
        			 											, nombreClients[i]
        			 											, adresses.length,
        			 											(nombreClients[i]*100.0/adresses.length)));
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
            // Ignorer les erreurs lors de l'effacement de l'affichage
        }
    }
 }
/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */

import java.util.Random;

public class Dico {
    //Atributs de la classe Dico
    private int t;
    private ListeChainee[] table;
    private Random gen;

    // Constructeur
    public Dico(int taille) {
        this.t = taille;
        table = new ListeChainee[taille];
        for (int i = 0; i < taille; i++) {
            table[i] = new ListeChainee();
        }
        gen = new Random();
    }




    public void ajtelmalea(int nbelems) {
        for (int i = 0; i < nbelems; i++) {
            // Génération aléatoire des clés entre 0 et la taille
            int cle = gen.nextInt(t);
            // Génération aléatoire des valeurs aléatoire entre 0 et 100
            double valeur = gen.nextDouble() * 100;
            Elements element = new Elements(cle, valeur);
            ajout(cle, element);
        }
    }

    // Méthode pour ajouter un élément dans le dictionnaire
    public void ajout(int cle, Elements valeur) {
        table[cle].ajouterTete(valeur);
    }
    // Méthode pour supprimer un élément aléatoire du dictionnaire
    public void suppelemalea(int nombreElements) {
        for (int i = 0; i < nombreElements; i++) {
            int cle = gen.nextInt(t); // Génère une clé aléatoire dans l'intervalle [0, taille)
            supprimer(cle);
        }
    }

    // Méthode pour supprimer un élément du dictionnaire
    public void supprimer(int cle) {
        Elements element = rechercheElement(cle);
        if (element != null) {
            table[cle].retirePos(cle);
        }
    }

    // Méthode pour rechercher un élément dans le dictionnaire
    public Elements rechercheElement(int cle) {
        return table[cle].rechercheElement(cle);
    }


    public static void main(String[] args) {
        int tailleDictionnaire = 100000;
        int nombreElementsAjout = 20000;
        int nombreElementsSuppression = 17000;

        // Création du dictionnaire
        Dico dico = new Dico(tailleDictionnaire);

        // Mesurer le temps d'ajout
        long startAjout = System.currentTimeMillis();
        dico.ajtelmalea(nombreElementsAjout);
        long stopAjout = System.currentTimeMillis();
        long tempsAjout = stopAjout - startAjout;
        System.out.println("Temps d'ajout : " + tempsAjout + " millisecondes");
        System.out.println(dico.toString())  ;
        // Mesurer le temps de recherche (exemple)
        int cleRecherche = 78;
        long startRecherche = System.currentTimeMillis();
        Elements elementRecherche = dico.rechercheElement(cleRecherche);
        long stopRecherche = System.currentTimeMillis();
        long tempsRecherche = stopRecherche - startRecherche;
        if (false) {
            System.out.println("element trouve pour la cle " + cleRecherche + ": " + elementRecherche);
        } else {
            System.out.println("Aucun element trouve pour la cle " + cleRecherche);
        }
        System.out.println("Temps de recherche : " + tempsRecherche + " millisecondes");

        // Mesurer le temps de suppression
        long startSuppression = System.currentTimeMillis();
        dico.suppelemalea(nombreElementsSuppression);
        long stopSuppression = System.currentTimeMillis();
        long tempsSuppression = stopSuppression - startSuppression;
        System.out.println("Temps de suppression : " + tempsSuppression + " millisecondes");
    }
}

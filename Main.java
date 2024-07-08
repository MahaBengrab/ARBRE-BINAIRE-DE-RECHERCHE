/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */
import java.util.Random;
public class Main {
    // taille du tableau d'éléments
    final static int nb_elem = 1000;
    // constante pour génerer aleatoirement
    final static int K = 100000;
    // taille du tableau ASUPPRIMER
    final static int nb_elem1 = 1000;
    // méthode static pour remplir le tableau aléatoirement
    public static Elements[] alearemp(int taille) {
        Random r = new Random();
        Elements[] tab = new Elements[taille];
        for(int i = 0 ; i<taille ; i++ )
        {
            tab[i] = new Elements(r.nextInt(K + 1),i) ;
        }
        return tab ;
    }
    public static void main(String[] args) {

        System.out.println("------------------------------------------------------------Première étape du test------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------On test la fonction ajouter ------------------------------------------------------------------");

        ArbreBinaire testerArbre = new ArbreBinaire() ; // créer un arbre pour les testes
        testerArbre.ajouter(new Elements(12,1.3) );
        long debutUneInsertion = System.currentTimeMillis();  //mesurer le temps d'une seule insertion
        testerArbre.ajouter(new Elements(25,3.6) );
        long finUneInsertion = System.currentTimeMillis();
        System.out.println("Temps d'une seule insertion: " + (finUneInsertion - debutUneInsertion) + " ms");
        testerArbre.ajouter(new Elements(7,3.6) );
        testerArbre.ajouter(new Elements(9,4.3)) ;
        testerArbre.ajouter(new Elements (11,5.2));
        testerArbre.ajouter(new Elements(4,6.8));
        testerArbre.ajouter(new Elements(1,7.4));
        testerArbre.Afficher();
        System.out.println(testerArbre.ajouter(new Elements(1,3))) ;
        //testerArbre.Afficher() ;
        System.out.println("-----------------------------------------------------------On test la fonction de recherche ------------------------------------------------------------------");
        long debrech = System.currentTimeMillis(); // mesurer le temps d'une seule recherche
        System.out.println("element recherché c'est :  "+ testerArbre.recherche(11))  ;
        long finrech = System.currentTimeMillis();
        System.out.println("Temps d'une seule recherche: " + ( finrech - debrech) + " ms");
        System.out.println("l'element recherché est :  "+ testerArbre.recherche(4))  ;
        System.out.println("l'element recherché est :  "+ testerArbre.recherche(13))  ;
        System.out.println("----------------------------------------------------------On test la fonction de suppression ------------------------------------------------------------------");
        long debutUneSuppression = System.currentTimeMillis(); // mesurer le temps d'une supression
        testerArbre.supprimer(new Elements(1,7.4)) ;
        long finUneSuppression = System.currentTimeMillis();
        System.out.println("Le temps d'une suppression est : " + ( finUneSuppression - debutUneSuppression) + " ms");
        testerArbre.Afficher() ;
        System.out.println("-----------------------------------------------------------------Ajout d'autre élément ------------------------------------------------------------------");
        testerArbre.ajouter(new Elements(5,112));
        testerArbre.ajouter(new Elements(20,123));
        testerArbre.ajouter(new Elements(22,320));
        testerArbre.supprimer(new Elements(12,1.3));
        testerArbre.Afficher() ;

        System.out.println("-------------------------------------------------------------Deuxième pétape du test à effectuer ------------------------------------------------------------------");
        System.out.println("****************************************************************************ABR********************************************************************************************");
        System.out.println("******************************************************************** Effectuer l'ajout **************************************************************");

        ArbreBinaire arbre = new ArbreBinaire();
        Elements[] tab = alearemp(nb_elem);
        Random r = new Random();
        Elements[] ASUPPRIMER = new Elements[nb_elem1];
        for(int i = 0 ; i<nb_elem1 ; i++ )
        {
            ASUPPRIMER[i] = new Elements();
        }
        //L'ajout dans l'arbre et remplissage de ASUPPRIMER
        int j = 0;
        long debaj = System.currentTimeMillis();
        for(int i = 0 ; i<nb_elem ; i++ )
        {
            arbre.ajouter(tab[i]);
            //tirage pour le tablea ASSUPPRIMER avec la probabilité donnée
            if (r.nextDouble() < 0.15 && j < nb_elem1) {
                ASUPPRIMER[j] = tab[i];
                j++;
            }
        }
        long finaj = System.currentTimeMillis();
        arbre.Afficher();
        System.out.println("Temps d'insertion des elements du  tableau est de  : " + (finaj - debaj) + " ms");
        arbre.Afficher();

        /////////////////////////////////////////////
        System.out.println("********************************************** Effectuer 1000 insertions supplémentaires **************************************************************");
        long debaj1 = System.currentTimeMillis();
        for(int k=0; k<nb_elem1 ; k++)
        {
            arbre.ajouter(new Elements(r.nextInt(1000000 + 1),k));
        }
        long finaj1 = System.currentTimeMillis();
        arbre.Afficher();
        System.out.println("Temps d'insertion des 1000 elements : " + (finaj1 - debaj1) + " ms");


        System.out.println("********************************************** Effectuer la suppression **************************************************************");

        System.out.println("Le tableau ASUPPRIMER : ") ;
        long debsup1 = System.currentTimeMillis();
        for(int i = 0; i < nb_elem1; i++){

            arbre.supprimer(ASUPPRIMER[i]);
        }
        long finsup1 = System.currentTimeMillis();
        arbre.Afficher();
        System.out.println("Le temps de suppression est :" + (finsup1-debsup1)+"ms");


        System.out.println(" \n --------------------------------------------Test sur les listes chainée--------------------------------------------------------------") ;
        ListeChainee liste = new ListeChainee() ; // CRÉER UNE LISTE
        long debutajout1 = System.currentTimeMillis(); //mesurer le temps d'ajout des 10000 elems
        for(int i = 0 ; i<nb_elem ; i++ )
        {
            liste.ajouterTete(tab[i]) ;
        }
        long finajout1 = System.currentTimeMillis();
        System.out.println("Temps d'insertion ListeChainee: " + (finajout1 - debutajout1) + " ms");
//System.out.println("Liste apres l'ajout  : ") ;liste apres le premier ajout // comme l'affichage est long la liste est mise en commentaire
//System.out.println(liste.toString()) ;
        System.out.println(" ----------Effectuer 1000 insertions supplémentaires liste  --------");
        long debutInsertion2 = System.currentTimeMillis(); //mesurer le temps en nanosecondes  // cas etudié ici c'est l'ajout tete
        for(int k=0; k<nb_elem1 ; k++)
        {
            liste.ajouterTete(new Elements(r.nextInt(1000000 + 1),k));
        }
        long finInsertion2 = System.currentTimeMillis();
        System.out.println("Temps d'insertion supplémentaire Liste chainee  : " + (finInsertion2 - debutInsertion2) + " ms");
        System.out.println("Liste apres l'ajout supplementaire   : ") ; //
        System.out.println(liste.toString())  ;
        System.out.println(" ----------Supprimer les 1000 élements qui vient du tableau ASUPPRIMER De la liste chainée  --------");
        long debutSuppression2 = System.currentTimeMillis();  // mesurer le temps de suppression
        for(int K=0; K<nb_elem1 ; K++)
        {
            liste.retirer(ASUPPRIMER[K]); ;

        }
        long finSuppression2 = System.currentTimeMillis();
        System.out.println("Temps de suppression: " + (finSuppression2 - debutSuppression2) + " ms");
        System.out.println("Liste apres la suppression : ");
        System.out.println(liste.toString());

    }
}
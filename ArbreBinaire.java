/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */

public class ArbreBinaire {
    // Attribut de la classe ArbreBinaire
    private Noeuds racine;

    //Constructeur
    public ArbreBinaire(){
        racine= null;
    }

    //Accesseur
    public Noeuds getRacine()  // accesseur
    {
        return racine ;
    }

    /**
     * La méthode recherche permet la recherche d'un noeud spécifique dans un arbre binare de recherche
     * */
    private Noeuds recherche(int cle, Noeuds n){
        if(n == null){
            return null;
        } else if(cle == n.getElement().getCle()){
            return n;
        } else if(cle > n.getElement().getCle()){
            return recherche(cle, n.getFilsDroit());
        } else{
            return recherche(cle, n.getFilsGauche());
        }
    }
    public Noeuds recherche(int cle){
        return recherche(cle, racine);
    }

    /**
     * La méthode ajouter permet l'ajout d'un noeud dans l'arbre
     * */
    
    private boolean ajouterRec(Noeuds noeud, Elements elem) {
        if (elem.getCle() < noeud.getElement().getCle()) {
            if (noeud.getFilsGauche() == null) {
                noeud.setFilsGauche(new Noeuds(elem)); //appel recursif
                return true;
            } else {
                return ajouterRec(noeud.getFilsGauche(), elem);
            }
        } else if (elem.getCle() > noeud.getElement().getCle()) {
            if (noeud.getFilsDroit() == null) {
                noeud.setFilsDroit(new Noeuds(elem));  // appel recursif
                return true;
            } else {
                return ajouterRec(noeud.getFilsDroit(), elem);
            }
        } else {
            // Element de même clé déjà présent, insertion impossible
            System.out.println("la clé de l'élément " + elem + " existe déja" ) ;// affichage de msg sur la console
            return false;
        }
    }
    public boolean ajouter(Elements elem)
    {
        if (racine == null)
        {
            racine = new Noeuds(elem) ;
            return true ;
        }
        else {
            return ajouterRec(racine,elem) ;
        }
    }
    
    /**
     * La méthode afficher est utilisé pour afficher tous les noeuds dans un ordre croissant
     * */
    private int AfficherRec(Noeuds noeud) {
        if (noeud == null) {
            return 0;
        }
        // Affichage des noeuds gauches
        int hauteurGauche = AfficherRec(noeud.getFilsGauche());
        // Affichage de la racine
        System.out.print("\n"+noeud.getElement() + " ");
        // Affichage des noeuds droits
        int hauteurDroite = AfficherRec(noeud.getFilsDroit());
        // Calcul de la hauteur de l'arbre
        int hauteur = Math.max(hauteurGauche, hauteurDroite) + 1;
        return hauteur;
    }
    public void Afficher() {
        int hauteur = AfficherRec(racine);
        System.out.println("\nHauteur de l'arbre : " + hauteur);
    }

    /**
     * La méthode supprimer permet la suppression des noeuds dans l'arbre binaire de recherche
     * */
    private Noeuds supprimer(Noeuds noeud, Elements elem) {
        if (noeud == null) {
            return null;
        }
        if (elem.getCle() < noeud.getElement().getCle()) {
            noeud.setFilsGauche(supprimer(noeud.getFilsGauche(), elem));
        } else if (elem.getCle() > noeud.getElement().getCle()) {
            noeud.setFilsDroit(supprimer(noeud.getFilsDroit(), elem));
        } else {
            if (noeud.getFilsGauche() == null) {
                return noeud.getFilsDroit();
            } else if (noeud.getFilsDroit() == null) {
                return noeud.getFilsGauche();
            } else {
                Noeuds successeurParent = noeud;
                Noeuds successeur = noeud.getFilsDroit();
                while (successeur.getFilsGauche() != null) {
                    successeurParent = successeur;
                    successeur = successeur.getFilsGauche();
                }
                if (successeurParent != noeud) {
                    successeurParent.setFilsGauche(successeur.getFilsDroit());
                    successeur.setFilsDroit(noeud.getFilsDroit());
                }
                successeur.setFilsGauche(noeud.getFilsGauche());
                if(noeud==racine) {
                    racine=successeur; // mettre à jour la racine de l'arbre si le noeud supprimé est la racine
                }
                return successeur;
            }
        }
        return noeud;
    }

    public boolean supprimer(Elements elem) {
        if(recherche(elem.getCle())==null || racine == null )   // si l'element recherché n'est pas retrouvé on retourne false
        {
            return false ;
        }
        else
        {
            supprimer(racine,elem) ;
            return true ;
        }
    }
}

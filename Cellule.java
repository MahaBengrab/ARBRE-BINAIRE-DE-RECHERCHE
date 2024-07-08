/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */
public class Cellule {
    /**
     * objet encapsulé dans la cellule
     */
    private Elements contenu;
    /**
     * pointeur sur la cellule suivante
     */
    private Cellule suivant;

    /**
     * constructeur créant une cellule sans contenu ni suivant
     */
    public Cellule() {
        contenu = null;
        suivant = null;
    }


    public Cellule(Elements contenu) {
        this.contenu = contenu;
        this.suivant = null;
    }

    /**
     * acceseur de la cellule suivante
     * @return suivant
     */
    public Cellule getSuivant() {
        return suivant;
    }



    public void setSuivant(Cellule suivant) {
        this.suivant=suivant;
    }

    /**
     * accesseur du contenu
     * @return contenu
     */
    public Elements getContenu() {
        return contenu;
    }

    /**
     * modificateur du contenu
     * @param _c le nouveau contenu
     */
    public void setContenu(Elements _c) {
        contenu = _c;
    }

    /**
     * repésentation de la cellule en chaîne de caractères
     */
    public String toString() {
        if (contenu == null) {
            return "nil";
        }
        else {
            return contenu.toString();
        }
    }
}

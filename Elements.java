/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */

public class Elements {
    private double valeur;
    private int cle;

    // Constructeur

    /*
     * Constructeur créant un élément sans valeur ni cle
     */
    public Elements(){
        cle = 0;
        valeur = 0;
    }

    /*
     * Constructeur créant un élément avec a et b representant
     * respectivement la cle et le valeur
     * @param a la clé
     * @param b le valeur
     * */
    public Elements(int cle, double valeur){
        this.cle = cle;
        this.valeur = valeur;
    }
    // accesseur

    /*
     * accesseur au valeur de l'élément
     * @return valeur
     * */
    public double getvaleur(){
        return valeur;
    }

    /*
     * accesseur à la clé de l'élément
     * @return cle
     * */
    public int getCle(){
        return cle;
    }

    // modificateur

    /*
     * modificateur du valeur
     * @param val le nouveau valeur
     * */
    public void setvaleur(double _valeur){
        this.valeur = _valeur;
    }

    /*
     * modificateur de la cle
     * @param cle la nouvelle cle
     */
    public void setCle(int _cle){
        this.cle = _cle;
    }

    /*
     * repésentation de l'élément en chaîne de caractères
     */
    public String toString()
    {
        String resultat = "" ;
        resultat = "[" + cle + "," + valeur + "]" ;
        return resultat ;
    }

    public static void main(String[] args) {
        Elements e1 = new Elements();
        e1.setCle(20);
        e1.setvaleur(19.75);
        System.out.println(e1);
    }
}

/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */
public class Noeuds {
    //Les attributs
    protected Elements element;
    protected Noeuds filsGauche;
    protected Noeuds filsDroit;

    //Constructeurs

    public Noeuds(Elements _element){
        filsGauche = null;
        filsDroit = null;
        this.element = _element;
    }

    public Noeuds(Noeuds g, Noeuds d, Elements c){
        filsGauche = g;
        filsDroit = d;
        element = c;
    }

    // Accesseurs
    public Noeuds getFilsGauche(){
        return filsGauche;
    }

    public Noeuds getFilsDroit(){
        return filsDroit;
    }

    public Elements getElement(){
        return element;
    }
    //Modificateurs

    public void setFilsGauche(Noeuds _fils_Gauche){
        filsGauche = _fils_Gauche;
    }

    public void setFilsDroit(Noeuds _fils_Droit){
        filsDroit = _fils_Droit;
    }

    public void setElement(Elements a){
        element = a;
    }

    public String toString()
    {
        String res ="" ;
        res += element.toString();
        return res ;
    }

    /*public String toString(){
        if(element == null){
            return "nil";
        }
        String noeud = new String();
        noeud = "FilsGauche : " + getFilsGauche()+ "," + " filsDroit : " + getFilsDroit();
        return noeud;
    }
    public static void main(String[] args) {

        Elements a1 = new Elements(2, 18.00);
        Elements a2 = new Elements(3, 18.00);
        Elements a3 = new Elements(4, 18.00);
        //Elements d = new Elements(5, 18.00);
        Noeuds b1 = new Noeuds(a1);
        Noeuds b2 = new Noeuds(a2);
        Noeuds b3 = new Noeuds(a3);

        b1.setFilsGauche(b2);
        b1.setFilsDroit(b3);
        System.out.println(b1.getFilsGauche().getElement());
        System.out.println(b1.getFilsDroit().getElement());
        b1.getFilsDroit().getElement().setCle(12);
        System.out.println(b1.getFilsDroit().getElement());

    }*/
}

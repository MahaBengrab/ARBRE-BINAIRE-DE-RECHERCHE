import java.util.Random;

/**
 * @author Ilias Halmi && Maha Bengrab
 * @version avril 2024
 */

public class ListeChainee{

    private Cellule tete;
    private Cellule queue;
    private Cellule courant;



    public ListeChainee(){
        tete=null;
        queue=null;
        courant=null;
    }

    public ListeChainee(Cellule _tete){
        tete=_tete;
        queue=tete;
        Cellule courant=tete;
        if(courant!=null){
            while(courant.getSuivant()!=null){
                courant=courant.getSuivant();
            }
            queue=courant;
        }
    }

    public Cellule getTete(){
        return tete;
    }

    public Cellule getQueue(){
        return queue;
    }

    public Cellule getCourant(){
        return courant;
    }

    public Object enTete(){
        if(tete==null){
            return null;
        }
        return tete.getContenu();

    }

    public Object enQueue(){
        if(queue==null){
            return null;
        }
        return queue.getContenu();
    }

    public Object enCourant(){
        if(courant==null){
            return null;
        }
        return courant.getContenu();
    }

    public boolean estVide(){
        return(tete==null);
    }

    public void razCourant(){
        courant=getTete();
    }

    public void suivant(){
        if(courant!=null){
            courant=courant.getSuivant();
        }
    }

    public void ajouterTete(Elements o_tete){
        Cellule ajout=new Cellule (o_tete);
        if(estVide()){
            tete=ajout;
            queue=ajout;
            courant=ajout;
        }else{
            ajout.setSuivant(tete);
            tete=ajout;
        }
    }


    public void ajouteQueue(Elements o_queue){
        Cellule ajout=new Cellule (o_queue);
        if(estVide()){
            tete=queue=courant=ajout;
        }else{
            queue.setSuivant(ajout);
            queue=ajout;
        }
    }

    public void retireTete(){
        if(estVide()){
            tete=null;
        }else{
            tete=tete.getSuivant();
            tete.setSuivant(null);
        }
    }
    public void retireQueue(){
        if(tete==queue){
            tete=null;
            queue=null;
        }else{
            Cellule courant=tete;
            while(courant.getSuivant()!=queue){
                courant =courant.getSuivant();

            }
            courant.setSuivant(null);
            queue=courant;

        }

    }
    public void retirer(Elements contenu) {
        if (estVide()) {
            return;
        }
        if (tete.getContenu().equals(contenu)) {
            retireTete();
            return;
        }
        Cellule courante = tete.getSuivant();
        Cellule precedente = tete;
        while (courante != null) {
            if (courante.getContenu().equals(contenu)) {
                precedente.setSuivant(courante.getSuivant());
                if (precedente.getSuivant() == null) {
                    queue = precedente;
                }
                return;
            }
            precedente = courante;
            courante = courante.getSuivant();
        }
    }
    public void ajouteApresCourant(Elements o_){
        Cellule c =new Cellule(o_);
        if(estVide()){
            tete=queue=courant=c;
        }
        else{
            Cellule apres=tete;
            while(apres!=null){
                apres=apres.getSuivant();
            }
            if(apres==null){
                System.out.println("position non valide");
            }
            c.setSuivant(apres.getSuivant());
            apres.setSuivant(c);
        }
    }



    public void retirePos(int pos){
        if (pos <= 0){
            System.out.println("position non valide");
        }
        else {
            if(pos == 1){
                retireTete();
            }
            else {
                Cellule avant = null;
                Cellule aSupprimer = tete;
                int i = 1;
                while (i !=pos && aSupprimer !=null){
                    avant = aSupprimer;
                    aSupprimer = aSupprimer.getSuivant();
                    i++;
                }
                if (aSupprimer != null){
                    avant.setSuivant(aSupprimer.getSuivant());
                    aSupprimer.setSuivant(null);
                }
                else {
                    System.out.println("Position hors de la liste, suppression impossible");
                }
            }
        }
    }


    public Elements rechercheElement(int cle) {
        return rechercheRec(cle, this.getTete());
    }

    // Méthode de recherche récursive
    private Elements rechercheRec(int cle, Cellule c) {
        if (c == null) {
            return null;
        } else {
            if (c.getContenu().getCle() == cle) {
                return c.getContenu();
            } else {
                return rechercheRec(cle, c.getSuivant());
            }
        }
    }

    public String toString(){
        if(estVide()){
            return "nil";
        }
        Cellule courante = tete;
        String resu = courante.toString();
        courante = courante.getSuivant();
        while(courante != null){
            resu = resu + " -> " +courante.toString() ;
            courante = courante.getSuivant();
        }
        return resu + "->nil";
    }




    public static void main (String[] args) {
            Cellule c = new Cellule(new Elements(0,1)) ;
            ListeChainee liste = new ListeChainee(c) ;
            System.out.println("liste " + liste.toString()) ;


    }
}
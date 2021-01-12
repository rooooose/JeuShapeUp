package fr.utt.lo02.shapeUp.modele;

import java.util.Queue;
/**
 * Cette classe permet d'avoir dans laquelle les joueurs vont pouvoir piocher de nouvelles cartes au fur et � mesure de la partie.
 * La pioche est cr��e en d�but de partie en fonction du mode jeu choisi.
 * 
 * 
 * @author Shir F, Math�a Z
 * @see StrategieMode#creerLaPiocheDeLaPartie(Partie)
 */

public class Pioche {
	/**
	 * Entier correspondant au nombre de cartes dans la pioche
	 */
   private int nbreDeCartes;
   
   /*
    * Collection de type Queue mod�lisant les cartes pr�sentes dans la pioche
    * 
    */
   private Queue<Carte> pioche;
   
   /**
    * Cette m�thode permet de conna�tre le nombre de cartes dans la pioche
    * 
    * @return le nombre de carte dans la pioche
    */
    public int getNbreDeCartes() {
		return nbreDeCartes;
	}

    /**
     * Permet d'attribuer un nombre de cartes � la pioche
     * @param nbreDeCartes
     */
    public void compterNbCartes(int nbreDeCartes) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    }
    
  
	/**
	 * Cette m�thode permet de r�cup�rer les cartes pr�sentes dans la pioche
	 * @return la collection contenant les cartes de la pioche
	 */
	public Queue<Carte> getPioche() {
		return pioche;
	}

	/**
	 * Cette m�thode permet de d�finir les cartes pr�sentes dans la pioche
	 * 
	 * @param pioche - Collection de type Queue contenant des cartes 
	 */
	public void setPioche(Queue<Carte> pioche) {
		this.pioche = pioche;
	}
	
	/**
	 * Constructeur de la classe, permet de cr�er une pioche.
	 * @param pioche
	 */
	Pioche (Queue<Carte> pioche) {
		this.pioche = pioche;
		
	}


    	    public String toString() {
    	    	 StringBuffer sbPioche = new StringBuffer();
    	    	
    	    	 sbPioche.append("\n");
    	    	 sbPioche.append(this.pioche);
    	    	 sbPioche.append("\n");
    	    	 return sbPioche.toString();
    	    	}
    	}


    
    




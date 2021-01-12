package fr.utt.lo02.shapeUp.modele;

import java.util.Queue;
/**
 * Cette classe permet d'avoir dans laquelle les joueurs vont pouvoir piocher de nouvelles cartes au fur et à mesure de la partie.
 * La pioche est créée en début de partie en fonction du mode jeu choisi.
 * 
 * 
 * @author Shir F, Mathéa Z
 * @see StrategieMode#creerLaPiocheDeLaPartie(Partie)
 */

public class Pioche {
	/**
	 * Entier correspondant au nombre de cartes dans la pioche
	 */
   private int nbreDeCartes;
   
   /*
    * Collection de type Queue modélisant les cartes présentes dans la pioche
    * 
    */
   private Queue<Carte> pioche;
   
   /**
    * Cette méthode permet de connaître le nombre de cartes dans la pioche
    * 
    * @return le nombre de carte dans la pioche
    */
    public int getNbreDeCartes() {
		return nbreDeCartes;
	}

    /**
     * Permet d'attribuer un nombre de cartes à la pioche
     * @param nbreDeCartes
     */
    public void compterNbCartes(int nbreDeCartes) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    }
    
  
	/**
	 * Cette méthode permet de récupérer les cartes présentes dans la pioche
	 * @return la collection contenant les cartes de la pioche
	 */
	public Queue<Carte> getPioche() {
		return pioche;
	}

	/**
	 * Cette méthode permet de définir les cartes présentes dans la pioche
	 * 
	 * @param pioche - Collection de type Queue contenant des cartes 
	 */
	public void setPioche(Queue<Carte> pioche) {
		this.pioche = pioche;
	}
	
	/**
	 * Constructeur de la classe, permet de créer une pioche.
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


    
    




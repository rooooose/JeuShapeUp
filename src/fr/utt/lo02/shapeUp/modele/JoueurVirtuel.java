package fr.utt.lo02.shapeUp.modele;

import java.util.Random;

import fr.utt.lo02.shapeUp.vue.Console;
/**
 * 
 * Repr�sente un joueur virtuel du jeu ShapeUp. Le joueur virtuel est bas� sur des actions al�atoires qui respectent les r�gles du jeu.
 * Tout comme un joueur r�el, il peut �tre actif (ou non).
 * Le joueur virtuel est une impl�mentation de l'interface StrategieJoueur et et il h�rite de la classe Joueur.
 * 
 * @see {@link Joueur}, {@link StrategieJoueur}
 * 
 * @author Shir F, Math�a Z
 *
 */
public class JoueurVirtuel extends Joueur implements StrategieJoueur{

	/**
	 * Constructeur de la classe, appelle le constructeur de la classe m�re Joueur.
	 * 
	 * @see {@link Joueur#Joueur(String)}
	 * 
	 * @param nom - nom du joueur virtuel
	 */
	public JoueurVirtuel(String nom) {
		super(nom);
		
	}
    
/**
 * Permet au joueur virtuel de d�finir la carte qu'il va jouer de fa�on al�atoire dans les r�gles avanc�es.
 *<br>
 * Sinon, le joueur virtuel utilisera automatiquement la seule carte dans sa main.
 * 
 */
    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {

    	Carte carteAJouer;
    	
    	if (modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie ) {
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		int randomIndex = 0;
    		do {
    		  randomIndex = new Random().nextInt(joueur.getMainDuJoueur().size());
    		}while(joueur.getMainDuJoueur().get(randomIndex) == null);

    		carteAJouer = joueur.getMainDuJoueur().remove(randomIndex);
    		this.notifyObservers(joueur.getNom()+" a choisi la carte � jouer : " + carteAJouer);    		
    		
    		return carteAJouer;
    	
    	}
    	

	
    	
    }

/**
 * Permet au joueur virtuel de choisir de fa�on al�atoire (mais coh�rente avec le tapis de jeu) une ligne pour placer ou d�placer une carte.
 * 
 */
	public int choisirLigneCarte(TapisDeJeu tapis) {
		Random rand = new Random();
		int nb;
	    nb = rand.nextInt(tapis.getContainer().size());
        return nb;
	}


/**
 * Permet au joueur virtuel de choisir de fa�on al�atoire (mais coh�rente avec le tapis de jeu) une colonne pour placer ou d�placer une carte.
 * 
 */
	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Random rand = new Random();
		int nb;
	    nb = rand.nextInt(tapis.getContainer().get(0).size());
        return nb;
	}

/**
 * Propose au joueur virtuel de d�placer une carte. <br>
 * Le joueur pourra choisir de fa�on al�atoire si il souhaite d�placer une carte ou non.
 */

	public boolean proposerDeplacement(TapisDeJeu tapis, Partie partie) {


       Random rand = new Random();
       int choix;
	   choix = rand.nextInt(2);
        	
       if(choix == 1) {

    	  this.notifyObservers("Le joueur souhaite d�placer une carte."); 
         
          this.deplacerCarte(tapis, partie);
          return true;
          
        } else return false;
		
	}
	
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("- " + this.getNom() + " -> joueur virtuel" + "\n");
		
		return sb.toString();
	}
}



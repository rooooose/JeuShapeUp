package fr.utt.lo02.shapeUp.modele;

import java.util.Random;

import fr.utt.lo02.shapeUp.vue.Console;
/**
 * 
 * Représente un joueur virtuel du jeu ShapeUp. Le joueur virtuel est basé sur des actions aléatoires qui respectent les règles du jeu.
 * Tout comme un joueur réel, il peut être actif (ou non).
 * Le joueur virtuel est une implémentation de l'interface StrategieJoueur et et il hérite de la classe Joueur.
 * 
 * @see {@link Joueur}, {@link StrategieJoueur}
 * 
 * @author Shir F, Mathéa Z
 *
 */
public class JoueurVirtuel extends Joueur implements StrategieJoueur{

	/**
	 * Constructeur de la classe, appelle le constructeur de la classe mère Joueur.
	 * 
	 * @see {@link Joueur#Joueur(String)}
	 * 
	 * @param nom - nom du joueur virtuel
	 */
	public JoueurVirtuel(String nom) {
		super(nom);
		
	}
    
/**
 * Permet au joueur virtuel de définir la carte qu'il va jouer de façon aléatoire dans les règles avancées.
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
    		this.notifyObservers(joueur.getNom()+" a choisi la carte à jouer : " + carteAJouer);    		
    		
    		return carteAJouer;
    	
    	}
    	

	
    	
    }

/**
 * Permet au joueur virtuel de choisir de façon aléatoire (mais cohérente avec le tapis de jeu) une ligne pour placer ou déplacer une carte.
 * 
 */
	public int choisirLigneCarte(TapisDeJeu tapis) {
		Random rand = new Random();
		int nb;
	    nb = rand.nextInt(tapis.getContainer().size());
        return nb;
	}


/**
 * Permet au joueur virtuel de choisir de façon aléatoire (mais cohérente avec le tapis de jeu) une colonne pour placer ou déplacer une carte.
 * 
 */
	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Random rand = new Random();
		int nb;
	    nb = rand.nextInt(tapis.getContainer().get(0).size());
        return nb;
	}

/**
 * Propose au joueur virtuel de déplacer une carte. <br>
 * Le joueur pourra choisir de façon aléatoire si il souhaite déplacer une carte ou non.
 */

	public boolean proposerDeplacement(TapisDeJeu tapis, Partie partie) {


       Random rand = new Random();
       int choix;
	   choix = rand.nextInt(2);
        	
       if(choix == 1) {

    	  this.notifyObservers("Le joueur souhaite déplacer une carte."); 
         
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



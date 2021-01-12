package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;

//import java.util.Collections;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
//import java.util.Set;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * Cette classe correspond aux r�gles de base de ShapeUp.
 * C'est une impl�mentation de l'interface StrategieMode.
 * Les r�gles de base correspondent au fait de pouvoir voir sa carte de victoire et de jouer avec une seule carte dans sa main.
 * @author Shir F, Math�a Z
 * @see StrategieMode
 *
 */
public class StrategieDeBase extends Observable implements StrategieMode {

/**
 * Cette m�thode permet de distribuer les cartes en d�but de Partie.
 * Ici, une carte de victoire est attribu�e � chaque joueur.
 * 
 * @see StrategieMode#distribuerCartes(Partie)
 */
	public List<Carte> distribuerCartes(Partie maPartie) {
		
		
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		
		
		
		//On r�cup�re les cartes du jeu (toutes les cartes)
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		while(iteratorRecupJoueurs.hasNext())  {
			
		  //Param�tres pour r�cup�rer une carte au hasard
			
		  int longueurListeCarte = (recupCarteJeu.size())-(maPartie.getQueueJoueurs().size())-1;
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  Joueur joueurAssocie = iteratorRecupJoueurs.next();

    		  
    		  CouleurType recupCouleur = recupCarteJeu.get(randomIndex).getCouleur();
    		  FormeCarte recupForme = recupCarteJeu.get(randomIndex).getForme();
    		  boolean recupRemplissage = recupCarteJeu.get(randomIndex).estRemplie;
    		  
    		  //On r�cup�re la carte al�atoirement
    		  Carte carteRecup = new Carte(recupCouleur, recupForme, recupRemplissage);
    		  // On enl�ve la carte du jeu pour garantir l'unicit�
    		  recupCarteJeu.remove((randomIndex)); 
    		  //On d�finit la carte r�cup�r�e comme une carte de victoire
    		  Carte carteVictJoueur = carteRecup;

    		  joueurAssocie.setCarteDeVictoire(carteVictJoueur);

    		  //R�initialisation des param�tres pour r�cuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  
      	}

		
    	return recupCarteJeu;    		
    }
/**
 * On cr�e la pioche de la partie en fonction des cartes d�j� distribu�es, ici toutes les cartes qui ne sont pas assign�es comme carte de victoire seront dans la pioche.
 * 
 * 
 * @see StrategieMode#creerLaPiocheDeLaPartie(Partie)
 */
		
	public Pioche creerLaPiocheDeLaPartie (Partie maPartie) {
		
		
		Queue<Carte> pioche = new LinkedList<Carte> ();
		int nombreDeCartes = 0;
		
		List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);
 
	    for (int nbreDeCartes = 0; nbreDeCartes < maPartie.getNbCartesJouables(); nbreDeCartes++) {

	    	pioche.add(recupCarteJeu.get(nbreDeCartes));

	    	nombreDeCartes = nbreDeCartes;
	    	
	    	
	    }
			
		Pioche piocheDeLaPartie = new Pioche (pioche);	
		piocheDeLaPartie.compterNbCartes(nombreDeCartes);
		return piocheDeLaPartie;

	}
    	
	/**
	 * Ici, la carte de victoire est visible uniquement par le joueur associ� � celle-ci.
	 * 
	 *@see StrategieMode#voirCarteVictoire(Partie, Joueur)
	 */

    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	
    	this.notifyObservers("Votre carte de victoire est "+ joueur.getCarteDeVictoire());
    	
    	
    }

    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("Strat�gie de base");
		return sb.toString();
    }


	
	/**
	 * Cette m�thode permet en fin de partie de rendre visible toutes les cartes de victoires. En fonction des cartes de victoire, les scores seront calcul�es.
	 */
	public void finirLaPartie(Partie maPartie) {
		// TODO Auto-generated method stub
		this.notifyObservers("\n" +"La partie est finie, place aux r�sultats ! :) "+ "\n");
		
		
		Iterator<Joueur> it = maPartie.getQueueJoueurs().iterator();
		
		while(it.hasNext()) {
    		
    		Joueur joueur = it.next();
    		this.notifyObservers("La carte de victoire de " +joueur.getNom()+ " est " +joueur.getCarteDeVictoire());
    	
    		int score = maPartie.calculerScoreTotal(joueur);
    		this.notifyObservers("Score total de " + joueur.getNom() + " : " + score);
    		
    	}
		
		maPartie.definirGagnant();
	}

}

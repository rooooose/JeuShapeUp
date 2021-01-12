package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * Cette classe correspond aux r�gles de "Victoire Ennemie", c'est une impl�mentation imagin�e par les auteurs de cette classe.
 * C'est une impl�mentation de l'interface StrategieMode.
 * Les r�gles en victoire ennemie sont semblables aux r�gles de base, sauf que le joueur ne peut pas voir sa carte de victoire. Il ne pourra voir que les cartes de victoire des ses ennemies. Ainsi, il devra faire en sorte que ceux-ci perdent sans pour autant conna�tre sa carte de victoire.
 * 
 * @author Shir F, Math�a Z
 * @see StrategieMode
 */


public class StrategieVictoireEnnemie extends Observable implements StrategieMode {
	
/**
 * Ici, le joueur ne peut pas voir sa carte de victoire pendant la partie. Cependant, il peut voir la carte de victoire de chaque adversaire de jeu.
 * 
 * @see StrategieMode#voirCarteVictoire(Partie, Joueur)
 */

	
    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	
    	
		Iterator <Joueur> voirCartesEnnemies = maPartie.getQueueJoueurs().iterator();
		
		int i = 0;
		while (i < maPartie.getQueueJoueurs().size()) {
			Joueur joueurNext = voirCartesEnnemies.next();
		if (joueur != joueurNext ) {
		this.notifyObservers("Vous ne pouvez voir que la carte de victoire de vos ennemis "+joueurNext.getNom()+ " : " +joueurNext.getCarteDeVictoire());
		
	   }else {
		this.notifyObservers("Vous ne pouvez pas voir votre carte de victoire");
		
		}
		i++;
	}
    	
    }


	/**
	 * Les cartes sont distribu�es de fa�on semblable aux r�gles de base.
	 * Une carte de victoire est assign�e � chaque joueur.
	 * @see StrategieDeBase#distribuerCartes(Partie)
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
    		  Carte carteRecup = new Carte (recupCouleur, recupForme, recupRemplissage);
    		  // On enl�ve la carte du jeu pour garantir l'unicit�
    		  recupCarteJeu.remove(randomIndex); 
    		  //On d�finit la carte r�cup�r�e comme une carte de victoire
    		  Carte carteVictJoueur = carteRecup;
    		  
    		  //R�cup�rer les diff�rents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  joueurAssocie.setCarteDeVictoire(carteVictJoueur);
    		 
    		 
    		  
 
    		  
    		  //R�initialisation des param�tres pour r�cuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  
      	}

		
    	return recupCarteJeu;    		
    	  		}



	/**
	 * 
	 */
	public Pioche creerLaPiocheDeLaPartie(Partie maPartie) {
		
		//this.addObserver(maPartie.getConsoleDuJeu());
		
		Queue<Carte> pioche = new LinkedList<Carte> ();
		int nombreDeCartes = 0;
		
		
		
		List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);
    	//Collections.shuffle(recupCarteJeu);
		

	    
	    for (int nbreDeCartes = 0; nbreDeCartes < maPartie.getNbCartesJouables(); nbreDeCartes++) {
	    		
	    	

	    	pioche.add(recupCarteJeu.get(nbreDeCartes));

	    	
	    	nombreDeCartes = nbreDeCartes;
	    	
	    }
				
		Pioche piocheDeLaPartie = new Pioche (pioche);	
		piocheDeLaPartie.compterNbCartes(nombreDeCartes);
		return piocheDeLaPartie;
	}

	
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("Strat�gie victoire ennemie, vous pouvez voir les cartes de victoire de vos ennemis!");
		return sb.toString();
    }


	/**
	 * Cette m�thode, permettant de finir la partie, permet de voir chaque carte de victoire associ�e au joueur.
	 * On fait des appels � des m�thodes de la partie pour calculer le score et d�finir le gagnant.
	 * 
	 * @see StrategieMode#finirLaPartie(Partie)
	 */
	public void finirLaPartie(Partie maPartie) {

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

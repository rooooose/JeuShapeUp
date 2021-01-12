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
 * Cette classe correspond aux règles de "Victoire Ennemie", c'est une implémentation imaginée par les auteurs de cette classe.
 * C'est une implémentation de l'interface StrategieMode.
 * Les règles en victoire ennemie sont semblables aux règles de base, sauf que le joueur ne peut pas voir sa carte de victoire. Il ne pourra voir que les cartes de victoire des ses ennemies. Ainsi, il devra faire en sorte que ceux-ci perdent sans pour autant connaître sa carte de victoire.
 * 
 * @author Shir F, Mathéa Z
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
	 * Les cartes sont distribuées de façon semblable aux règles de base.
	 * Une carte de victoire est assignée à chaque joueur.
	 * @see StrategieDeBase#distribuerCartes(Partie)
	 */
	public List<Carte> distribuerCartes(Partie maPartie) {
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		
		
		
		//On récupère les cartes du jeu (toutes les cartes)
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		while(iteratorRecupJoueurs.hasNext())  {
			
		  //Paramètres pour récupérer une carte au hasard
			
		  int longueurListeCarte = (recupCarteJeu.size())-(maPartie.getQueueJoueurs().size())-1;
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  Joueur joueurAssocie = iteratorRecupJoueurs.next();
  		
    		  CouleurType recupCouleur = recupCarteJeu.get(randomIndex).getCouleur();
    		  FormeCarte recupForme = recupCarteJeu.get(randomIndex).getForme();
    		  boolean recupRemplissage = recupCarteJeu.get(randomIndex).estRemplie;
    		  
    		  //On récupère la carte aléatoirement
    		  Carte carteRecup = new Carte (recupCouleur, recupForme, recupRemplissage);
    		  // On enlève la carte du jeu pour garantir l'unicité
    		  recupCarteJeu.remove(randomIndex); 
    		  //On définit la carte récupérée comme une carte de victoire
    		  Carte carteVictJoueur = carteRecup;
    		  
    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  joueurAssocie.setCarteDeVictoire(carteVictJoueur);
    		 
    		 
    		  
 
    		  
    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    		  
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
    	sb.append("Stratégie victoire ennemie, vous pouvez voir les cartes de victoire de vos ennemis!");
		return sb.toString();
    }


	/**
	 * Cette méthode, permettant de finir la partie, permet de voir chaque carte de victoire associée au joueur.
	 * On fait des appels à des méthodes de la partie pour calculer le score et définir le gagnant.
	 * 
	 * @see StrategieMode#finirLaPartie(Partie)
	 */
	public void finirLaPartie(Partie maPartie) {

		this.notifyObservers("\n" +"La partie est finie, place aux résultats ! :) "+ "\n");
		
		
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

	package shapeUp;
	
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.ListIterator;
	import java.util.Map;
	import java.util.Queue;
	import java.util.Random;
	import java.util.Set;

import vue.Console;
	/**
	 * Cette classe correspond aux règles avancées de ShapeUp.
	 * C'est une implémentation de l'interface StrategieMode.
	 * Les règles avancées de ShapeUp permettent d'avoir trois cartes dans la main du joueur. La carte de victoire d'un joueur est la dernière carte présente dans la main du joueur.
	 * @author Shir F, Mathéa Z
	 * @see StrategieMode
	 */
	public class StrategieAvance extends Observable implements StrategieMode {
		
/**
 * Ici, le joueur ne peut pas voir sa carte de victoire avant le dernier tour. En effet, la dernière carte dans la main du joueur sera sa carte de victoire.
 */
	
	    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
	    	this.notifyObservers("La dernière carte dans votre main sera votre carte de victoire.");
	    	
	    }
	
		
		/**
		 * Dans cette implémentation, la distribution en début de partie est faite pour que le joueur ait toujours 3 cartes dans sa main.
		 * 
		 *@see StrategieMode#distribuerCartes(Partie)
		 */
		public List<Carte> distribuerCartes(Partie maPartie) {
			// TODO Auto-generated method stub
			
			Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
			
			
			//On récupère les cartes du jeu (toutes les cartes)
			List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
	    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
	    	
	    	
	    	
			while(iteratorRecupJoueurs.hasNext())  {
				
				
				Joueur joueurAssocie = iteratorRecupJoueurs.next();
				
				while (joueurAssocie.getMainDuJoueur().size()<3) {
			  //Paramètres pour récupérer une carte au hasard
			
				  int longueurListeCarte = (recupCarteJeu.size())-(3*(maPartie.getQueueJoueurs().size()));
				 
		  		  int randomIndex = new Random().nextInt(longueurListeCarte);
	    		
	    		  //Récupérer les différents joueurs ajouter les cartes récupérées dans leur main
	    		   
	    		  joueurAssocie.getMainDuJoueur().add(recupCarteJeu.remove(randomIndex));

	    		  
	    		  //Réinitialisation des paramètres pour récuperer une autre carte au hasard
	    		  
	    		  longueurListeCarte = 0;
	    		  randomIndex = 0;
	    		 
	    		  
				}
	      	}
			return recupCarteJeu;
	    	    		
	    }
		
		/**
		 * 
		 *
		 */
		public Pioche creerLaPiocheDeLaPartie(Partie maPartie) {
			
			
			Queue<Carte> pioche = new LinkedList<Carte> ();
			int nombreDeCartes = 0;
			
			int nbreDeJoueurs = maPartie.getQueueJoueurs().size();
			
			
			List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);

		    
		    for (int nbreDeCartes = 0; nbreDeCartes <maPartie.getNbCartesJouables()-(maPartie.getQueueJoueurs().size()*2); nbreDeCartes++) {
		    		

		    	
		    	pioche.add(recupCarteJeu.get(nbreDeCartes));
		    
		    	nombreDeCartes = nbreDeCartes;
		    	
		    }
	
			Pioche piocheDeLaPartie = new Pioche (pioche);	
			piocheDeLaPartie.compterNbCartes(nombreDeCartes);
			return piocheDeLaPartie;
		}
		
		
		
	
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append("Stratégie avancée");
			return sb.toString();
	    }
	
		/**
		 * Cette méthode permet, en stratégie avancée, de récupérer la dernière carte dans la main du joueur pour la définir comme sa carte de victoire.
		 * A partir de cette carte, on va pouvoir calculer le score et définir un gagnant.
		 * @see StrategieMode#finirLaPartie(Partie)
		 */
		public void finirLaPartie(Partie maPartie) {
			// TODO Auto-generated method stub
			
			
			this.notifyObservers("\n" +"La partie est finie, place aux résultats ! :) "+ "\n");
			
			
			Iterator<Joueur> it = maPartie.getQueueJoueurs().iterator();
			
			while(it.hasNext()) {
		    		
		    	Joueur joueur = it.next();
		    	Carte recupValeur = joueur.getMainDuJoueur().get(0);
		    		
		    	Carte carteVictJoueur = new Carte (recupValeur.getCouleur(),recupValeur.getForme(),recupValeur.EstRemplie());
		    		
		    	joueur.setCarteDeVictoire(carteVictJoueur);
		    	this.notifyObservers("La carte de victoire de " +joueur.getNom()+ " est " +joueur.getCarteDeVictoire());
		    	
		    	int score = maPartie.calculerScoreTotal(joueur);
		    	this.notifyObservers("Score total de " + joueur.getNom() + " : " + score);
		    	

		    }
			maPartie.definirGagnant();
	
		}
				
				
	
	}




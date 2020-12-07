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
	
	public class StrategieAvance implements StrategieMode {
	
	    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
	    	System.out.println("La dernière carte dans votre main sera votre carte de victoire.");
	    }
	
		@Override
		public List<Carte> distribuerCartes(Partie maPartie) {
			// TODO Auto-generated method stub
			
			Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
			//int i = 1;
			
			//On récupère les cartes du jeu (toutes les cartes)
			List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
	    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
	    	//System.out.println("Cartes pour distribution : " + recupCarteJeu);
	    	
	    	
			while(iteratorRecupJoueurs.hasNext())  {
				
				
				Joueur joueurAssocie = iteratorRecupJoueurs.next();
				
				while (joueurAssocie.getMainDuJoueur().size()<3) {
			  //Paramètres pour récupérer une carte au hasard
			
				  int longueurListeCarte = (recupCarteJeu.size())-(3*(maPartie.getQueueJoueurs().size()));
				  //System.out.println("LongueurListeCarte : " + longueurListeCarte);
		  		  int randomIndex = new Random().nextInt(longueurListeCarte);
	    		  //Carte carteRecup = recupCarteJeu.get(randomIndex);
	    		  //System.out.println(carteRecup);
	    		 
	    		  //Récupérer les différents joueurs ajouter les cartes récupérées dans leur main
	    		   
	    		  joueurAssocie.getMainDuJoueur().add(recupCarteJeu.remove(randomIndex));
	    		  
	    		  //System.out.println(joueurAssocie.getNom() + joueurAssocie.getMainDuJoueur());
	    		  
	    		  //On enlève la carte mise dans la main de la liste de récupération des cartes pour garantir l'unicité
	    		  
	    		 // recupCarteJeu.remove((randomIndex));
	    		
	    		  
	    		  //Réinitialisation des paramètres pour récuperer une autre carte au hasard
	    		  
	    		  longueurListeCarte = 0;
	    		  randomIndex = 0;
	    		  //i++;
	    		  
				}
	      	}
			return recupCarteJeu;
	    	    		
	    }
		
		@Override
		public Pioche creerLaPiocheDeLaPartie(Partie maPartie) {
			// TODO Auto-generated method stub
			Queue<Carte> pioche = new LinkedList<Carte> ();
			int nombreDeCartes = 0;
			
			int nbreDeJoueurs = maPartie.getQueueJoueurs().size();
			
			
			List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);
	    	//Collections.shuffle(recupCarteJeu);
	    	//System.out.println("Cartes pour pioche : " + recupCarteJeu);
	    	
	//    	ListIterator<Carte> it = recupCarteJeu.listIterator();
	//    	while(it.hasNext()) {
	//    		pioche.add(it.next());
	//    		nombreDeCartes++;
	//    	}
	//	    System.out.println(pioche);
		    
		    for (int nbreDeCartes = 0; nbreDeCartes <maPartie.getNbCartesJouables()-(maPartie.getQueueJoueurs().size()*2); nbreDeCartes++) {
		    		
		    	
		    	//int arrayLength = recupCarteJeu.size(); 
		    	//int randomIndex = new Random().nextInt(arrayLength);
		    	
		    	/*while (pioche.contains(recupCarteJeu.get(randomIndex)))
		    		
		    	{
		        	arrayLength = 0; 
		        	randomIndex = 0; 
		        	arrayLength = recupCarteJeu.size(); 
		        	randomIndex = new Random().nextInt(arrayLength);
		    	}*/
		    	
		    	pioche.add(recupCarteJeu.get(nbreDeCartes));
		    	//recupCarteJeu.remove((randomIndex));
		    	//arrayLength = 0; 
		    	//randomIndex = 0; 
		    	
		    	
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
	
		@Override
		public void finirLaPartie(Partie maPartie) {
			// TODO Auto-generated method stub
			
			
			System.out.println("\n" +"La partie est finie, place aux résultats ! :) "+ "\n");
			
			Iterator<Joueur> it = maPartie.getQueueJoueurs().iterator();
			
			while(it.hasNext()) {
		    		
		    	Joueur joueur = it.next();
		    	Carte recupValeur = joueur.getMainDuJoueur().get(0);
		    		
		    	Carte carteVictJoueur = new Carte (recupValeur.getCouleur(),recupValeur.getForme(),recupValeur.EstRemplie());
		    		
		    	joueur.setCarteDeVictoire(carteVictJoueur);
		    	System.out.println("La carte de victoire de " +joueur.getNom()+ " est " +joueur.getCarteDeVictoire());
		    	int score = maPartie.calculerScoreTotal(joueur);
		    	System.out.println("Score total de " + joueur.getNom() + " : " + score);

		    }
			maPartie.definirGagnant();
	
		}
				
				
	
	}




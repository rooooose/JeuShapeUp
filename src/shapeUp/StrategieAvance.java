package shapeUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StrategieAvance implements StrategieMode {

    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	System.out.println("La dernière carte dans votre main sera votre carte de victoire.");
    }

	@Override
	public void distribuerCartes(Partie maPartie) {
		// TODO Auto-generated method stub
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		//int i = 1;
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		while(iteratorRecupJoueurs.hasNext())  {
			
			
			Joueur joueurAssocie = iteratorRecupJoueurs.next();
			for (int nbreMain = 0; nbreMain < 3; nbreMain++) {
		  //Paramètres pour récupérer une carte au hasard
			
			  int longueurListeCarte = (recupCarteJeu.size())-(3*(maPartie.getQueueJoueurs().size()))-1;
	  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  
  
        	//On récupère les cartes du jeu (toutes les cartes)
        	
        	
        	
        	//On fait en sorte que la carte ne soit pas dans la pioche
    		  while(maPartie.getPioche().getPioche().contains(recupCarteJeu.get(randomIndex))) {
    			  
    			  longueurListeCarte = 0;
        		  randomIndex = 0;
        		  longueurListeCarte = (recupCarteJeu.size())-(3*(maPartie.getQueueJoueurs().size()))-1;
          		  randomIndex = new Random().nextInt(longueurListeCarte);
          		  
    		  }

    		  
    		  Carte carteRecup = recupCarteJeu.get(randomIndex);
    		  System.out.println(carteRecup);
    		  
    		  //Récupérer les différents joueurs ajouter les cartes récupérées dans leur main
    		   
    		  
    		  joueurAssocie.getMainDuJoueur().add(carteRecup);
    		  System.out.println(joueurAssocie.getNom() + joueurAssocie.getMainDuJoueur());
    		  
    		  //On enlève la carte mise dans la main de la liste de récupération des cartes pour garantir l'unicité
    		  
    		  recupCarteJeu.remove(recupCarteJeu.get(randomIndex));
    		
    		  
    		  //Réinitialisation des paramètres pour récuperer une autre carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  //i++;
    		  
			}
      	}
    	    		
    }

		
		
		
		
	


	@Override
	public void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur) {
		// TODO Auto-generated method stub
		
		joueur.setCarteDeVictoire(carteVictoire);
		
		
		
		//A utiliser en fin de partie
		 /* CouleurType recupCouleur = joueur.getMainDuJoueur().get(0).getCouleur();
		  FormeCarte recupForme = joueur.getMainDuJoueur().get(0).getForme();
		  boolean recupRemplissage = joueur.getMainDuJoueur().get(0).estRemplie;
		  CarteDeVictoire carteDeVictJoueur = new CarteDeVictoire (recupCouleur, recupForme, recupRemplissage);
		 
		  
		  joueur.setCarteDeVictoire(carteDeVictJoueur);
		  */
		
	}


	@Override
	public Pioche creerLaPiocheDeLaPartie(Partie maPartie) {
		// TODO Auto-generated method stub
		Set<Carte> pioche = new HashSet<Carte> ();
		int nombreDeCartes = 0;
		
		int nbreDeJoueurs = maPartie.getQueueJoueurs().size();
		
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
    	Collections.shuffle(recupCarteJeu);
		

	    
	    for (int nbreDeCartes = 0; nbreDeCartes < ((maPartie.getNbCartesJouables()) - (nbreDeJoueurs*2)); nbreDeCartes++) {
	    		
	    	
	    	int arrayLength = recupCarteJeu.size(); 
	    	int randomIndex = new Random().nextInt(arrayLength);
	    	
	    	while (pioche.contains(recupCarteJeu.get(randomIndex)))
	    		
	    	{
	        	arrayLength = 0; 
	        	randomIndex = 0; 
	        	arrayLength = recupCarteJeu.size(); 
	        	randomIndex = new Random().nextInt(arrayLength);
	    	}
	    	
	    	pioche.add(recupCarteJeu.get(randomIndex)); 
	    	arrayLength = 0; 
	    	randomIndex = 0; 
	    	
	    	
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

}

package shapeUp;

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

public class StrategieVictoireEnnemie implements StrategieMode {

	
    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	
    	
		Iterator <Joueur> voirCartesEnnemies = maPartie.getQueueJoueurs().iterator();
		
		int i = 0;
		while (i < maPartie.getQueueJoueurs().size()) {
			Joueur joueurNext = voirCartesEnnemies.next();
		if (joueur != joueurNext ) {
		System.out.println("Tu ne peux voir que la carte de victoire des tes ennemis "+joueurNext.getNom()+ " : " +joueurNext.getCarteDeVictoire());
	   }else {
		System.out.println("Tu ne peux pas voir ta carte de victoire");
		}
		i++;
	}
    	
    }


	@Override
	public List<Carte> distribuerCartes(Partie maPartie) {
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		Map<CarteDeVictoire,Joueur> CarteVictAssociationJoueur = new HashMap <CarteDeVictoire, Joueur>();
		
		
		//On récupère les cartes du jeu (toutes les cartes)
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		while(iteratorRecupJoueurs.hasNext())  {
			
		  //Paramètres pour récupérer une carte au hasard
			
		  int longueurListeCarte = (recupCarteJeu.size())-(maPartie.getQueueJoueurs().size())-1;
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  Joueur joueurAssocie = iteratorRecupJoueurs.next();
  		  
        	//On fait en sorte que la carte ne soit pas dans la pioche
    		  /*while(maPartie.getPioche().getPioche().contains(recupCarteJeu.get(randomIndex))) {
    			  
    			  longueurListeCarte = 0;
        		  randomIndex = 0;
        		  longueurListeCarte = (recupCarteJeu.size())-(maPartie.getQueueJoueurs().size())-1;
          		  randomIndex = new Random().nextInt(longueurListeCarte);
          		  
    		 }*/
    		  
    		  CouleurType recupCouleur = recupCarteJeu.get(randomIndex).getCouleur();
    		  FormeCarte recupForme = recupCarteJeu.get(randomIndex).getForme();
    		  boolean recupRemplissage = recupCarteJeu.get(randomIndex).estRemplie;
    		  
    		  //On récupère la carte aléatoirement
    		  Carte carteRecup = new CarteDeVictoire(recupCouleur, recupForme, recupRemplissage);
    		  // On enlève la carte du jeu pour garantir l'unicité
    		  recupCarteJeu.remove(randomIndex); 
    		  //On définit la carte récupérée comme une carte de victoire
    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) carteRecup;
    		  
    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  joueurAssocie.setCarteDeVictoire(carteVictJoueur);
    		 
    		  CarteVictAssociationJoueur.put(carteVictJoueur,joueurAssocie);
    		  
 
    		  
    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  
      	}

		maPartie.setCarteVictAssociationJoueur(CarteVictAssociationJoueur);
    	return recupCarteJeu;    		
    	  		}



	@Override
	public Pioche creerLaPiocheDeLaPartie(Partie maPartie) {
		Queue<Carte> pioche = new LinkedList<Carte> ();
		int nombreDeCartes = 0;
		
		
		
		List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);
    	//Collections.shuffle(recupCarteJeu);
		

	    
	    for (int nbreDeCartes = 0; nbreDeCartes < maPartie.getNbCartesJouables(); nbreDeCartes++) {
	    		
	    	
//	    	int arrayLength = recupCarteJeu.size(); 
//	    	int randomIndex = new Random().nextInt(arrayLength);
	    	
	    	/*while (pioche.contains(recupCarteJeu.get(randomIndex)))
	    		
	    	{
	        	arrayLength = 0; 
	        	randomIndex = 0; 
	        	arrayLength = recupCarteJeu.size(); 
	        	randomIndex = new Random().nextInt(arrayLength);
	    	}*/
	    	
	    	// On remove pour garantir l'unicité
//	    	pioche.add(recupCarteJeu.remove(randomIndex)); 
	    	pioche.add(recupCarteJeu.get(nbreDeCartes));
	    	//recupCarteJeu.remove((randomIndex));
//	    	arrayLength = 0; 
//	    	randomIndex = 0; 
	    	
	    	
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


	@Override
	public void finirLaPartie(Partie maPartie) {
		// TODO Auto-generated method stub
		System.out.println("\n" +"La partie est finie, place aux résultats ! :) "+ "\n");
		
		Iterator<Joueur> it = maPartie.getQueueJoueurs().iterator();
		
		while(it.hasNext()) {
    		
    		Joueur joueur = it.next();
    		System.out.println("La carte de victoire de " +joueur.getNom()+ " est " +joueur.getCarteDeVictoire());
    		int score = maPartie.calculerScoreTotal(joueur);
    		System.out.println("Score total de " + joueur.getNom() + " : " + score);
    	}
		
	}
	

}

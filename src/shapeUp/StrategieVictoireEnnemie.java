package shapeUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
		
		
		//On r�cup�re les cartes du jeu (toutes les cartes)
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		while(iteratorRecupJoueurs.hasNext())  {
			
		  //Param�tres pour r�cup�rer une carte au hasard
			
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
    		  
    		  //On r�cup�re la carte al�atoirement
    		  Carte carteRecup = new CarteDeVictoire(recupCouleur, recupForme, recupRemplissage);
    		  // On enl�ve la carte du jeu pour garantir l'unicit�
    		  recupCarteJeu.remove(randomIndex); 
    		  //On d�finit la carte r�cup�r�e comme une carte de victoire
    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) carteRecup;
    		  
    		  //R�cup�rer les diff�rents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  definirCarteVictoire( carteVictJoueur, joueurAssocie);
    		 
    		  CarteVictAssociationJoueur.put(carteVictJoueur,joueurAssocie);
    		  
 
    		  
    		  //R�initialisation des param�tres pour r�cuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  
      	}

		maPartie.setCarteVictAssociationJoueur(CarteVictAssociationJoueur);
    	return recupCarteJeu;    		
    	  		}


	@Override
	public void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur) {
		// TODO Auto-generated method stub
		joueur.setCarteDeVictoire(carteVictoire);
	}


	@Override
	public Pioche creerLaPiocheDeLaPartie(Partie maPartie) {
		Set<Carte> pioche = new HashSet<Carte> ();
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
	    	
	    	// On remove pour garantir l'unicit�
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
    	sb.append("Strat�gie victoire ennemie, vous pouvez voir les cartes de victoire de vos ennemis!");
		return sb.toString();
    }

}

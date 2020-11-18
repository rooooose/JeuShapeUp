package shapeUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class StrategieDeBase implements StrategieMode {
    //private Pioche piocheDeLaPartie; 
	
	
	//public Pioche getPiocheDeLaPartie() {
	//	return piocheDeLaPartie;
	//}

	//public void setPiocheDeLaPartie(Pioche piocheDeLaPartie) {
	//	this.piocheDeLaPartie = piocheDeLaPartie;
	//}


	public void distribuerCartes(Partie maPartie) {
		
		
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		
		while(iteratorRecupJoueurs.hasNext())  {
			
		  //Paramètres pour récupérer une carte au hasard
			
		  int longueurListeCarte = maPartie.getCarteDuJeu().size();
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  
  		  
      	//if (nbreDeJoueurs == 2) {
    		//Pioche pioche = new Pioche (16, maPartie); 
    		//this.piocheDeLaPartie = pioche;}
 
        	//On récupère les cartes du jeu (toutes les cartes)
        	List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
        	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
        	
        	
        	//On fait en sorte que la carte ne soit pas dans la pioche
    		  while(creerLaPiocheDeLaPartie(maPartie).getPioche().contains(recupCarteJeu.get(randomIndex))) {
    			  
    			  longueurListeCarte = 0;
        		  randomIndex = 0;
        		  longueurListeCarte = maPartie.getCarteDuJeu().size();
          		  randomIndex = new Random().nextInt(longueurListeCarte);
          		  
    		  }
    		  
    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) recupCarteJeu.get(randomIndex);
    		  
    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    		   
    		  definirCarteVictoire( carteVictJoueur, iteratorRecupJoueurs.next());;
    		  maPartie.getCarteVictAssociationJoueur().put(carteVictJoueur, iteratorRecupJoueurs.next());
    		  
    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
      	}

    	    		
    	  		}

		
	public Pioche creerLaPiocheDeLaPartie (Partie maPartie) {
		
		Set<Carte> pioche = new TreeSet<Carte> ();
		int nombreDeCartes = 0;
		
		int nbreDeJoueurs = maPartie.getListeJoueurs().size();
		
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		if (nbreDeJoueurs == 2) {
	    
	    	for (int nbreDeCartes = 0; nbreDeCartes < 15; nbreDeCartes++) {
	    		
	    	
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
				
		}else if (nbreDeJoueurs == 3) {
			
			
	    	for (int nbreDeCartes = 0; nbreDeCartes < 14; nbreDeCartes++) {
	    		
		    	
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
			
		}
		
		Pioche piocheDeLaPartie = new Pioche (pioche);	
		piocheDeLaPartie.compterNbCartes(nombreDeCartes);
		return piocheDeLaPartie;
	}
    	
	
	
	@Override
	public void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur) {
		// TODO Auto-generated method stub
	    	joueur.setCarteDeVictoire(carteVictoire);
	    	
	}



    public void voirCarteVictoire(Joueur joueur) {
    	
    }









	





}

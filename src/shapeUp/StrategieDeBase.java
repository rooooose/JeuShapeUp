package shapeUp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StrategieDeBase implements StrategieMode {
     
	
	
	public void distribuerCartes(Joueur joueur, Partie maPartie) {
    	
		int nbreDeJoueurs = maPartie.getListeJoueurs().size();
	
		Iterator<String> iteratorRecup = maPartie.getListeJoueurs().keySet().iterator();

		while(iteratorRecup.hasNext())  {
			
		  //Paramètres pour récupérer une carte au hasard
			
		  int longueurListeCarte = maPartie.getCarteDuJeu().size();
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  
  		  
      	if (nbreDeJoueurs == 2) {
    		Pioche pioche = new Pioche (16, maPartie); 

    		
    		
        	
        	//On récupère les cartes du jeu (toutes les cartes)
        	List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
        	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
        	
        	
        	//On fait en sorte que la carte ne soit pas dans la pioche
    		  while(pioche.getPioche().contains(recupCarteJeu.get(randomIndex))) {
    			  
    			  longueurListeCarte = 0;
        		  randomIndex = 0;
        		  longueurListeCarte = maPartie.getCarteDuJeu().size();
          		  randomIndex = new Random().nextInt(longueurListeCarte);
          		  
    		  }
    		  
    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) recupCarteJeu.get(randomIndex);
    		  
    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    		  Object key   = iteratorRecup.next();
    		  definirCarteVictoire( carteVictJoueur, maPartie.getListeJoueurs().get(key));;
    		  
    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
      	}
    	      	else if (nbreDeJoueurs == 3 ) {
    	    		Pioche pioche= new Pioche (15, maPartie);
    	    		
    	    	
    	        	
    	        	//On récupère les cartes du jeu (toutes les cartes)
    	        	List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	        	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
    	        	
    	        	
    	        	//On fait en sorte que la carte ne soit pas dans la pioche
    	    		  while(pioche.getPioche().contains(recupCarteJeu.get(randomIndex))) {
    	    			  
    	    			  longueurListeCarte = 0;
    	        		  randomIndex = 0;
    	        		  longueurListeCarte = maPartie.getCarteDuJeu().size();
    	          		  randomIndex = new Random().nextInt(longueurListeCarte);
    	          		  
    	    		  }
    	    		  
    	    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) recupCarteJeu.get(randomIndex);
    	    		  
    	    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    	    		  Object key   = iteratorRecup.next();
    	    		  definirCarteVictoire( carteVictJoueur, maPartie.getListeJoueurs().get(key));;
    	    		  
    	    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    	    		  
    	    		  longueurListeCarte = 0;
    	    		  randomIndex = 0;
    	    		
    	  		}
  		}
      		
    	}
      	
		
		

    	
	@Override
	public void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur) {
		// TODO Auto-generated method stub
	    	joueur.setCarteDeVictoire(carteVictoire);
	}



    public void voirCarteVictoire(Joueur joueur) {
    }









	





}

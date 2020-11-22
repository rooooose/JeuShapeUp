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

public class StrategieDeBase implements StrategieMode {

	public void distribuerCartes(Partie maPartie) {
		
		
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		Map<CarteDeVictoire,Joueur> CarteVictAssociationJoueur = new HashMap <CarteDeVictoire, Joueur>();
		int i = 1;
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
		
		while(iteratorRecupJoueurs.hasNext())  {
			
		  //Paramètres pour récupérer une carte au hasard
			
		  int longueurListeCarte = (recupCarteJeu.size())-(maPartie.getQueueJoueurs().size())-1;
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  Joueur joueurAssocie = iteratorRecupJoueurs.next();

 
        	//On récupère les cartes du jeu (toutes les cartes)
        	
        	
        	
        	//On fait en sorte que la carte ne soit pas dans la pioche
    		  while(maPartie.getPioche().getPioche().contains(recupCarteJeu.get(randomIndex))) {
    			  
    			  longueurListeCarte = 0;
        		  randomIndex = 0;
        		  longueurListeCarte = (recupCarteJeu.size())-(maPartie.getQueueJoueurs().size())-1;
          		  randomIndex = new Random().nextInt(longueurListeCarte);
          		  
    		  }
    		  
    		  CouleurType recupCouleur = recupCarteJeu.get(randomIndex).getCouleur();
    		  FormeCarte recupForme = recupCarteJeu.get(randomIndex).getForme();
    		  boolean recupRemplissage = recupCarteJeu.get(randomIndex).estRemplie;
    		  
    		  Carte carteRecup = new CarteDeVictoire(recupCouleur, recupForme, recupRemplissage);
    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) carteRecup;
    		  
    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  definirCarteVictoire( carteVictJoueur, joueurAssocie);
    		 
    		  CarteVictAssociationJoueur.put(carteVictJoueur,joueurAssocie);
    		  
    		  recupCarteJeu.remove(recupCarteJeu.get(randomIndex));
    		  
    		 //non// maPartie.getCarteVictAssociationJoueur().put(carteVictJoueur, iteratorRecupJoueurs.next());
    		  
    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  i++;
      	}

		maPartie.setCarteVictAssociationJoueur(CarteVictAssociationJoueur);
    	    		
    	  		}

		
	public Pioche creerLaPiocheDeLaPartie (Partie maPartie) {
		
		Set<Carte> pioche = new HashSet<Carte> ();
		int nombreDeCartes = 0;
		
		//int nbreDeJoueurs = maPartie.getQueueJoueurs().size();
		
		
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
    	Collections.shuffle(recupCarteJeu);
		
		//if (nbreDeJoueurs == 2) {
	    
	    for (int nbreDeCartes = 0; nbreDeCartes < (maPartie.getNbCartesJouables()); nbreDeCartes++) {
	    		
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
	    	//System.out.print("NB CARTES DANS LA PIOCHE :" + nombreDeCartes);
	    	
	    }
				
		//}else if (nbreDeJoueurs == 3) {
			
//			
//	    	for (int nbreDeCartes = 0; nbreDeCartes < 14; nbreDeCartes++) {
//	    		
//		    	
//	    	int arrayLength = recupCarteJeu.size(); 
//	    	int randomIndex = new Random().nextInt(arrayLength);
//	    	
//	    	while (pioche.contains(recupCarteJeu.get(randomIndex)))
//	    		
//	    	{
//	        	arrayLength = 0; 
//	        	randomIndex = 0; 
//	        	arrayLength = recupCarteJeu.size(); 
//	        	randomIndex = new Random().nextInt(arrayLength);
//	    	}
//	    	
//	    	
//	    	pioche.add(recupCarteJeu.get(randomIndex)); 
//	    	
//	    	arrayLength = 0; 
//	    	randomIndex = 0; 
//	    	
//	    	
//	    	nombreDeCartes = nbreDeCartes;
//	    	}
//			
//		}
		
		Pioche piocheDeLaPartie = new Pioche (pioche);	
		piocheDeLaPartie.compterNbCartes(nombreDeCartes);
		return piocheDeLaPartie;
	}
    	
	
	
	@Override
	public void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur) {
		// TODO Auto-generated method stub
	    	joueur.setCarteDeVictoire(carteVictoire);
	    	
	}



    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	
    	System.out.println("Ta carte de victoire est "+ joueur.getCarteDeVictoire());
    	
    }
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("Stratégie de base");
		return sb.toString();
    }








	





}

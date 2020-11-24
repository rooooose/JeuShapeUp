package shapeUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StrategieDeBase implements StrategieMode {

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
    		  recupCarteJeu.remove((randomIndex)); 
    		  //On définit la carte récupérée comme une carte de victoire
    		  CarteDeVictoire carteVictJoueur = (CarteDeVictoire) carteRecup;
    		  
    		  //Récupérer les différents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  definirCarteVictoire( carteVictJoueur, joueurAssocie);
    		 
    		  CarteVictAssociationJoueur.put(carteVictJoueur,joueurAssocie);
    		  
    		 
    		  
    		 //non// maPartie.getCarteVictAssociationJoueur().put(carteVictJoueur, iteratorRecupJoueurs.next());
    		  
    		  //Réinitialisation des paramètres pour récuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  
      	}

		maPartie.setCarteVictAssociationJoueur(CarteVictAssociationJoueur);
    	return recupCarteJeu;    		
    }

		
	public Pioche creerLaPiocheDeLaPartie (Partie maPartie) {
		
		Set<Carte> pioche = new HashSet<Carte> ();
		int nombreDeCartes = 0;
		
		//int nbreDeJoueurs = maPartie.getQueueJoueurs().size();
		
		
		List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);
    	//Collections.shuffle(recupCarteJeu);
		
		//if (nbreDeJoueurs == 2) {
    	
//    	ListIterator<Carte> it = recupCarteJeu.listIterator();
//    	while(it.hasNext()) {
//    		pioche.add(it.next());
//    	}
//	    System.out.println(pioche);
	    for (int nbreDeCartes = 0; nbreDeCartes < maPartie.getNbCartesJouables(); nbreDeCartes++) {
	    		
	    	//int arrayLength = recupCarteJeu.size(); 
	    	//int randomIndex = new Random().nextInt(arrayLength);
	    	
	    	/*while (pioche.contains(recupCarteJeu.get(randomIndex)))
	    		
	    	{
	        	arrayLength = 0; 
	        	randomIndex = 0; 
	        	arrayLength = recupCarteJeu.size(); 
	        	randomIndex = new Random().nextInt(arrayLength);
	    	}*/
	    	
	    	//pioche.add(recupCarteJeu.remove(randomIndex));
	    	pioche.add(recupCarteJeu.get(nbreDeCartes));
	    	//recupCarteJeu.remove((randomIndex));
	    	//arrayLength = 0; 
	    	//randomIndex = 0; 
	    	
	    	
	    	nombreDeCartes = nbreDeCartes;
	    	//System.out.print("NB CARTES DANS LA PIOCHE :" + nombreDeCartes);
	    	
	    }
				

	    //System.out.println(pioche);
		Pioche piocheDeLaPartie = new Pioche (pioche);	
		piocheDeLaPartie.compterNbCartes(nombreDeCartes);
		return piocheDeLaPartie;
		//}else if (nbreDeJoueurs == 3) {
		
//		
//    	for (int nbreDeCartes = 0; nbreDeCartes < 14; nbreDeCartes++) {
//    		
//	    	
//    	int arrayLength = recupCarteJeu.size(); 
//    	int randomIndex = new Random().nextInt(arrayLength);
//    	
//    	while (pioche.contains(recupCarteJeu.get(randomIndex)))
//    		
//    	{
//        	arrayLength = 0; 
//        	randomIndex = 0; 
//        	arrayLength = recupCarteJeu.size(); 
//        	randomIndex = new Random().nextInt(arrayLength);
//    	}
//    	
//    	
//    	pioche.add(recupCarteJeu.get(randomIndex)); 
//    	
//    	arrayLength = 0; 
//    	randomIndex = 0; 
//    	
//    	
//    	nombreDeCartes = nbreDeCartes;
//    	}
//		
//	}
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

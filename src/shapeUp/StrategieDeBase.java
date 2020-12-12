package shapeUp;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
//import java.util.Set;

public class StrategieDeBase extends Observable implements StrategieMode {

	public StrategieDeBase(Console console) {
		this.addObserver(console);
	}
	
	public List<Carte> distribuerCartes(Partie maPartie) {
		
		
		//this.addObserver(maPartie.getConsoleDuJeu());
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		
		
		
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
    		  Carte carteRecup = new Carte(recupCouleur, recupForme, recupRemplissage);
    		  // On enl�ve la carte du jeu pour garantir l'unicit�
    		  recupCarteJeu.remove((randomIndex)); 
    		  //On d�finit la carte r�cup�r�e comme une carte de victoire
    		  Carte carteVictJoueur = carteRecup;
    		  
    		  //R�cup�rer les diff�rents joueurs pour leur attribuer une carte 
    		   
    		  
    		 
    		  joueurAssocie.setCarteDeVictoire(carteVictJoueur);
    		 
    		  
    		  
    		 
    		  
    		 //non// maPartie.getCarteVictAssociationJoueur().put(carteVictJoueur, iteratorRecupJoueurs.next());
    		  
    		  //R�initialisation des param�tres pour r�cuperer une carte au hasard
    		  
    		  longueurListeCarte = 0;
    		  randomIndex = 0;
    		  
      	}

		
    	return recupCarteJeu;    		
    }

		
	public Pioche creerLaPiocheDeLaPartie (Partie maPartie) {
		
		
		Queue<Carte> pioche = new LinkedList<Carte> ();
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
    	
	

    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	
    	this.notifyObservers("Votre carte de victoire est "+ joueur.getCarteDeVictoire());
    	//System.out.println("Ta carte de victoire est "+ joueur.getCarteDeVictoire());
    	
    }
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("Strat�gie de base");
		return sb.toString();
    }


	@Override
	public void finirLaPartie(Partie maPartie) {
		// TODO Auto-generated method stub
		this.notifyObservers("\n" +"La partie est finie, place aux r�sultats ! :) "+ "\n");
		//System.out.println("\n" +"La partie est finie, place aux r�sultats ! :) "+ "\n");
		
		Iterator<Joueur> it = maPartie.getQueueJoueurs().iterator();
		
		while(it.hasNext()) {
    		
    		Joueur joueur = it.next();
    		this.notifyObservers("La carte de victoire de " +joueur.getNom()+ " est " +joueur.getCarteDeVictoire());
    		//System.out.println("La carte de victoire de " +joueur.getNom()+ " est " +joueur.getCarteDeVictoire());
    		int score = maPartie.calculerScoreTotal(joueur);
    		this.notifyObservers("Score total de " + joueur.getNom() + " : " + score);
    		//System.out.println("Score total de " + joueur.getNom() + " : " + score);
    	}
		
		maPartie.definirGagnant();
	}

}

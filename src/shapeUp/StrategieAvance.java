package shapeUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class StrategieAvance implements StrategieMode {

    public void voirCarteVictoire(Partie maPartie, Joueur joueur) {
    	System.out.println("La derni�re carte dans votre main sera votre carte de victoire.");
    }

	@Override
	public List<Carte> distribuerCartes(Partie maPartie) {
		// TODO Auto-generated method stub
		
		Iterator<Joueur> iteratorRecupJoueurs = maPartie.getQueueJoueurs().iterator();
		//int i = 1;
		
		//On r�cup�re les cartes du jeu (toutes les cartes)
		List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
    	System.out.println("Cartes pour distribution : " + recupCarteJeu);
    	
    	
		while(iteratorRecupJoueurs.hasNext())  {
			
			
			Joueur joueurAssocie = iteratorRecupJoueurs.next();
			
			while (joueurAssocie.getMainDuJoueur().size()<3) {
		  //Param�tres pour r�cup�rer une carte au hasard
		
			  int longueurListeCarte = (recupCarteJeu.size())-(3*(maPartie.getQueueJoueurs().size()));
			  System.out.println("LongueurListeCarte : " + longueurListeCarte);
	  		  int randomIndex = new Random().nextInt(longueurListeCarte);
    		  //Carte carteRecup = recupCarteJeu.get(randomIndex);
    		  //System.out.println(carteRecup);
    		 
    		  //R�cup�rer les diff�rents joueurs ajouter les cartes r�cup�r�es dans leur main
    		   
    		  joueurAssocie.getMainDuJoueur().add(recupCarteJeu.remove(randomIndex));
    		  
    		  //System.out.println(joueurAssocie.getNom() + joueurAssocie.getMainDuJoueur());
    		  
    		  //On enl�ve la carte mise dans la main de la liste de r�cup�ration des cartes pour garantir l'unicit�
    		  
    		 // recupCarteJeu.remove((randomIndex));
    		
    		  
    		  //R�initialisation des param�tres pour r�cuperer une autre carte au hasard
    		  
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
		Set<Carte> pioche = new HashSet<Carte> ();
		int nombreDeCartes = 0;
		
		int nbreDeJoueurs = maPartie.getQueueJoueurs().size();
		
		
		List<Carte> recupCarteJeu = this.distribuerCartes(maPartie);
    	//Collections.shuffle(recupCarteJeu);
    	System.out.println("Cartes pour pioche : " + recupCarteJeu);
    	
//    	ListIterator<Carte> it = recupCarteJeu.listIterator();
//    	while(it.hasNext()) {
//    		pioche.add(it.next());
//    		nombreDeCartes++;
//    	}
//	    System.out.println(pioche);
	    
	    for (int nbreDeCartes = 0; nbreDeCartes < (15 - (nbreDeJoueurs*2)); nbreDeCartes++) {
	    		
	    	
	    	int arrayLength = recupCarteJeu.size(); 
	    	int randomIndex = new Random().nextInt(arrayLength);
	    	
	    	/*while (pioche.contains(recupCarteJeu.get(randomIndex)))
	    		
	    	{
	        	arrayLength = 0; 
	        	randomIndex = 0; 
	        	arrayLength = recupCarteJeu.size(); 
	        	randomIndex = new Random().nextInt(arrayLength);
	    	}*/
	    	
	    	pioche.add(recupCarteJeu.remove(randomIndex));
	    	//recupCarteJeu.remove((randomIndex));
	    	arrayLength = 0; 
	    	randomIndex = 0; 
	    	
	    	
	    	nombreDeCartes = nbreDeCartes;
	    	
	    }

		Pioche piocheDeLaPartie = new Pioche (pioche);	
		piocheDeLaPartie.compterNbCartes(nombreDeCartes);
		return piocheDeLaPartie;
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

    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("Strat�gie avanc�e");
		return sb.toString();
    }


	public int definirNbCartesJouables(Partie partie) {
		
		return partie.getCarteDuJeu().size() - (partie.getQueueJoueurs().size()*2);
	}

}

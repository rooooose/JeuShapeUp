package shapeUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StrategieJoueurReel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
		
		
		if (pioche.getNbreDeCartes() <0) {
		System.out.println("Aucune carte disponible dans la pioche");
		return null;
		}else {
		
		//On récupère les cartes de la pioche
		List<Carte> recupCartePioche = new ArrayList<Carte>(); 
    	recupCartePioche.addAll(pioche.getPioche()); 
    	
    	//On pioche une carte
    	Carte cartePiochee = recupCartePioche.get(1);
		
    	
    	//On enlève la carte de la pioche
    	
    	Set<Carte> transition = new TreeSet();
    	transition.addAll(pioche.getPioche());
    	transition.remove(cartePiochee);
    	pioche.setPioche(transition);
    	
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    	
    	System.out.println("Vous avez pioché une carte");
    	return cartePiochee;
    
		}	
    }

	/* 	public Carte piocherCarte(StrategieMode strategie) {
    	
    	
    	strategie.getPiocheDeLaPartie().compterNbCartes(pioche.getNbreDeCartes() - 1);
		return null;
    }
	 
	 
	 
	 */
    public void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carteDejaPlacee) {
    	
    	carteDejaPlacee.setEstPlacee(false);    	
 
    	carteDejaPlacee.setEstPlacee(true);
    }
   
    // A METTRE DANS JOUEUR
    public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte, TapisDeJeu tapis) {

    	//controle de si aucune carte n'est sur le tapis
    	if(tapis.getNbCartes()==0) {
    		
    		tapis.getContainer().get(ligneCase).add(colonneCase, carte);
    		
    	}else {
    		
    		if(tapis.placementPossible(ligneCase,colonneCase) && !tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).add(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    			System.out.println("Case remplie "+ tapis.caseRemplie(ligneCase,colonneCase));
    			
    			carte.setEstPlacee(true); 
    			
    		} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    			System.out.println("DECALAGE POSSIBLE ");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    
    		    //pas obligé ?
    		    //ligne.remove(colonneCase);
    		    System.out.print("/n container = " +tapis.getContainer());
    		    tapis.getContainer().get(ligneCase).add(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    			
    			carte.setEstPlacee(true); 
    		    
    		}
    		else {
    			//DEMANDER DE REPLACER CARTE
    		}
    	}
    	System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);
    	System.out.println("NB CARTES : " + tapis.getNbCartes());
    	//nbLignesVides FAUX
    	//System.out.println(tapis.getNbLignesVides());
    }

    public CarteJouable definirCarteAJouer(Carte carte, Joueur joueur, StrategieMode modeDeJeu) {
    	   
    	
    	
    	if (modeDeJeu instanceof StrategieDeBase) {
    		
    		CarteJouable carteAJouer = (CarteJouable) joueur.getMainDuJoueur();
    		return carteAJouer;
    		
    	} else {
    		
    		System.out.println("Ces modes de jeu ne sont pas encore disponibles");
    		return null;
    	
    	}
    	
    
    }
}

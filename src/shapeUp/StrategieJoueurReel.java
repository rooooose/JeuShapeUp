package shapeUp;

import java.util.ArrayList;

public class StrategieJoueurReel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
		return null;
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
   

    public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte, TapisDeJeu tapis) {
    	//SCANNER
    	//variables
    	ArrayList<CarteJouable> ligne = tapis.getContainer().get(ligneCase);
    	
    	//controle de si aucune carte n'est sur le tapis
    	if(tapis.getNbCartes()==0) {
    		
    		ligne.add(colonneCase, carte);
    		
    	}else {
    		
    		if(tapis.placementPossible(ligneCase,colonneCase) && !tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			ligne.add(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    			tapis.setNbCartes(tapis.getNbCartes()+1);
    			carte.setEstPlacee(true); 
    			
    		} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    			System.out.println("DECALAGE POSSIBLE ");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    
    		    //pas obligé ?
    		   //tapis.getContainer().get(ligneCase).remove(colonneCase);
    		    ligne.add(colonneCase, carte);
    			
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
    	System.out.println("NB CARTES : " + tapis.getNbCartes());
    	//nbLignesVides FAUX
    	//System.out.println(tapis.getNbLignesVides());
    }

    public CarteJouable definirCarteAJouer(Carte carte, StrategieMode modeDeJeu) {
		return null;
    }
}

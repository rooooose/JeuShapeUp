package shapeUp;

public class ScoreCouleur implements VisiteurScore {
	/*
	 * Pour le score de couleur on prend en considération à partir de 3 cartes côte à côte
	 * 3 cartes = + 4 points
		...
	 * 5 cartes = + 6 points
	 * 
	 */
	
	
    public int visiter(Partie partie, CarteDeVictoire carteVictoire) {
    	
    	partie.getTapisDeJeu().getContainer();
    	int scoreCouleur = 0;
    	int compteNbCartesCouleurLigne = 0;
    	int scoreCompteCouleurLigne = 0;
    	int compteNbCartesCouleurColonne = 0;
    	int scoreCompteCouleurColonne = 0 ;
    	
    
    	
    
    	for (int ligne = 0 ; ligne < partie.getTapisDeJeu().getModele().length; ligne++) {
    		
    		for (int colonne = 0; colonne < (partie.getTapisDeJeu().getModele()[0].length)-1; colonne++) {
    		if (partie.getTapisDeJeu().caseRemplie(ligne, colonne) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).getCouleur().ordinal() == carteVictoire.getCouleur().ordinal()) {
    		
    			if (partie.getTapisDeJeu().caseRemplie(ligne, colonne+1) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne+1).getCouleur().ordinal() == carteVictoire.getCouleur().ordinal()) {
    				compteNbCartesCouleurLigne = compteNbCartesCouleurLigne+1;
    			} 	
    			else {
    				if (compteNbCartesCouleurLigne >= 2) {
    				compteNbCartesCouleurLigne = compteNbCartesCouleurLigne+ 2; 	
    				scoreCompteCouleurLigne = scoreCompteCouleurLigne+compteNbCartesCouleurLigne;
    				
    				}
    				compteNbCartesCouleurLigne = 0;
    			}
    			
    		}
    		}
    		if (compteNbCartesCouleurLigne >= 2) {
			compteNbCartesCouleurLigne = compteNbCartesCouleurLigne+ 2; 	
			scoreCompteCouleurLigne = scoreCompteCouleurLigne+compteNbCartesCouleurLigne;
    		}
    		compteNbCartesCouleurLigne = 0;
    	}
    	
    	for (int colonne = 0; colonne < (partie.getTapisDeJeu().getModele()[0].length); colonne++) {
    		
    		for (int ligne = 0 ; ligne < (partie.getTapisDeJeu().getModele().length)-1; ligne++) {
    		if (partie.getTapisDeJeu().caseRemplie(ligne, colonne) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).getCouleur().ordinal() == carteVictoire.getCouleur().ordinal()) {
    		
    			if (partie.getTapisDeJeu().caseRemplie(ligne+1, colonne) && partie.getTapisDeJeu().getContainer().get(ligne+1).get(colonne).getCouleur().ordinal() == carteVictoire.getCouleur().ordinal()) {
    				compteNbCartesCouleurColonne = compteNbCartesCouleurColonne+1;
    			} 	
    			else {
    				if (compteNbCartesCouleurColonne >= 2) {
    				compteNbCartesCouleurColonne = compteNbCartesCouleurColonne+ 2; 	
    				scoreCompteCouleurColonne = scoreCompteCouleurColonne+ compteNbCartesCouleurColonne;
    				
    				}
    				compteNbCartesCouleurColonne = 0;
    			}
    		}
    		}
    		if (compteNbCartesCouleurColonne >= 2) {
			compteNbCartesCouleurColonne = compteNbCartesCouleurColonne+ 2; 	
			scoreCompteCouleurColonne = scoreCompteCouleurColonne+ compteNbCartesCouleurColonne;
			
			}
    		compteNbCartesCouleurColonne = 0;
    	}
    
    	scoreCouleur = scoreCompteCouleurColonne + scoreCompteCouleurLigne;
		return scoreCouleur;
    }


   	
    }



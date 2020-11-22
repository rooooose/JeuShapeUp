package shapeUp;


public class ScoreRemplissage implements VisiteurScore {

	/*
	 * Pour le score de REMPLISSAGE on prend en considération à partir de 3 cartes côte à côte
	 * 3 cartes = + 3 points
		...
	 * 5 cartes = + 5 points
	 * 
	 */
	
    public int visiter(Partie partie, CarteDeVictoire carteVictoire) {
    	
    	partie.getTapisDeJeu().getContainer();
    	int scoreRemplissage = 0;
    	int compteNbCartesRemplissageLigne = 0;
    	int scoreCompteRemplissageLigne = 0;
    	int compteNbCartesRemplissageColonne = 0;
    	int scoreCompteRemplissageColonne = 0 ;
    	
    
    	
    
    	for (int ligne = 0 ; ligne < partie.getTapisDeJeu().getModele().length; ligne++) {
    		
    		for (int colonne = 0; colonne < (partie.getTapisDeJeu().getModele()[0].length)-1; colonne++) {
    		if (partie.getTapisDeJeu().caseRemplie(ligne, colonne) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).EstRemplie() == carteVictoire.EstRemplie()) {
    		
    			if (partie.getTapisDeJeu().caseRemplie(ligne, colonne+1) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne+1).EstRemplie() == carteVictoire.EstRemplie()) {
    				compteNbCartesRemplissageLigne = compteNbCartesRemplissageLigne+1;
    			} 	
    			else {
    				if (compteNbCartesRemplissageLigne >= 2) {
    				compteNbCartesRemplissageLigne = compteNbCartesRemplissageLigne+ 1; 	
    				scoreCompteRemplissageLigne = scoreCompteRemplissageLigne+compteNbCartesRemplissageLigne;
    				
    				}
    				compteNbCartesRemplissageLigne = 0;
    			}
    			
    		}
    		}
    		if (compteNbCartesRemplissageLigne >= 2) {
			compteNbCartesRemplissageLigne = compteNbCartesRemplissageLigne+ 1; 	
			scoreCompteRemplissageLigne = scoreCompteRemplissageLigne+compteNbCartesRemplissageLigne;
    		}
    		compteNbCartesRemplissageLigne = 0;
    	}
    	
    	for (int colonne = 0; colonne < (partie.getTapisDeJeu().getModele()[0].length); colonne++) {
    		
    		for (int ligne = 0 ; ligne < (partie.getTapisDeJeu().getModele().length)-1; ligne++) {
    		if (partie.getTapisDeJeu().caseRemplie(ligne, colonne) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).EstRemplie() == carteVictoire.EstRemplie()) {
    		
    			if (partie.getTapisDeJeu().caseRemplie(ligne+1, colonne) && partie.getTapisDeJeu().getContainer().get(ligne+1).get(colonne).EstRemplie() == carteVictoire.EstRemplie()) {
    				compteNbCartesRemplissageColonne = compteNbCartesRemplissageColonne+1;
    			} 	
    			else {
    				if (compteNbCartesRemplissageColonne >= 2) {
    				compteNbCartesRemplissageColonne = compteNbCartesRemplissageColonne+ +1; 	
    				scoreCompteRemplissageColonne = scoreCompteRemplissageColonne+ compteNbCartesRemplissageColonne;
    				
    				}
    				compteNbCartesRemplissageColonne = 0;
    			}
    		}
    		}
    		if (compteNbCartesRemplissageColonne >= 2) {
			compteNbCartesRemplissageColonne = compteNbCartesRemplissageColonne+ 1; 	
			scoreCompteRemplissageColonne = scoreCompteRemplissageColonne+ compteNbCartesRemplissageColonne;
			
			}
    		compteNbCartesRemplissageColonne = 0;
    	}
    
    	scoreRemplissage = scoreCompteRemplissageColonne + scoreCompteRemplissageLigne;
		return scoreRemplissage;
    }



    	
    	
    }



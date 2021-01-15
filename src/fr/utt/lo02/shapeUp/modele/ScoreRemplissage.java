package fr.utt.lo02.shapeUp.modele;

/**
 * Implémentation de l'interface VisiteurScore permettant de calculer le score en fonction du remplissage des cartes
 * 
 * @author Shir F, Mathéa Z
 * @see VisiteurScore
 *
 */
public class ScoreRemplissage implements VisiteurScore {

	/**
	 * Permet de calculer le score de remplissage en fonction du paramètre de remplissage de la carte de victoire <br>
	 * Pour le score de remplissage, on prend en considération à partir de 3 cartes côte à côte ayant le même remplissage que la carte de victoire (forme rempli ou non) <br>
	 * 
	 * 3 cartes = +3 points;
	 * 4 cartes = +4 points;
	 * 5 cartes = +5 points
	 * 
	 * @see VisiteurScore#visiter(Partie, Carte), Carte
	 */
    public int visiter(Partie partie, Carte carteVictoire) {
    	
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



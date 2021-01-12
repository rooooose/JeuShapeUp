package fr.utt.lo02.shapeUp.modele;

/**
 * Implémentation de l'interface VisiteurScore permettant de calculer le score en fonction de la couleur des cartes
 * @author Shir F, Mathéa Z
 * @see VisiteurScore
 *
 */
public class ScoreCouleur implements VisiteurScore {

	/**
	 * Permet de calculer le score de couleur en fonction du paramètre de couleur de la carte de victoire <br>
	 * Pour le score de couleur, on prend en considération à partir de 3 cartes côte à côte ayant la même couleur que la carte de victoire (rouge, vert ou bleu) <br>
	 * 
	 * 3 cartes = +4 points;
	 * 4 cartes = +5 points;
	 * 5 cartes = +6 points;
	 * 
	 * 
	 * @see {@link VisiteurScore#visiter(Partie, Carte)}, {@link Carte}
	 */
    public int visiter(Partie partie, Carte carteVictoire) {
    	
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



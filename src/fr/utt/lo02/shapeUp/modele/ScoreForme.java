package fr.utt.lo02.shapeUp.modele;

/**
 * Implémentation de l'interface VisiteurScore permettant de calculer le score en fonction de la forme des cartes
 * @author Shir F, Mathéa Z
 * @see VisiteurScore
 *
 */

public class ScoreForme implements VisiteurScore {

	/**
	 * Permet de calculer le score de la forme en fonction du paramètre de forme de la carte de victoire <br>
	 * Pour le score de forme, on prend en considération à partir de 2 cartes côte à côte ayant la même forme que la carte de victoire (triangle, carré ou cercle) <br>
	 * 
	 * 2 cartes = +1 points;
	 * 3 cartes = +2 points;
	 * 4 cartes = +3 points;
	 * 5 cartes = +4 points;
	 * 
	 * @see VisiteurScore#visiter(Partie, Carte), Carte
	 */
    public int visiter(Partie partie, Carte carteVictoire) {
    	
    	
    	partie.getTapisDeJeu().getContainer();
    	int scoreForme = 0;
    	int compteNbCartesFormeLigne = 0;
    	int scoreCompteFormeLigne = 0;
    	int compteNbCartesFormeColonne = 0;
    	int scoreCompteFormeColonne = 0 ;
    	
    
    	
    
    	for (int ligne = 0 ; ligne < partie.getTapisDeJeu().getModele().length; ligne++) {
    		
    		for (int colonne = 0; colonne < (partie.getTapisDeJeu().getModele()[0].length)-1; colonne++) {
    		if (partie.getTapisDeJeu().caseRemplie(ligne, colonne) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).getForme().ordinal() == carteVictoire.getForme().ordinal()) {
    		
    			if (partie.getTapisDeJeu().caseRemplie(ligne, colonne+1) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne+1).getForme().ordinal() == carteVictoire.getForme().ordinal()) {
    				compteNbCartesFormeLigne = compteNbCartesFormeLigne+1;
    			} 	
    			else {
    				scoreCompteFormeLigne = scoreCompteFormeLigne+compteNbCartesFormeLigne;
    				compteNbCartesFormeLigne = 0;
    			}
    		}
    		}
    		scoreCompteFormeLigne = scoreCompteFormeLigne+compteNbCartesFormeLigne;
			compteNbCartesFormeLigne = 0;
    	}
    	
    	for (int colonne = 0; colonne < (partie.getTapisDeJeu().getModele()[0].length); colonne++) {
    		
    		for (int ligne = 0 ; ligne < (partie.getTapisDeJeu().getModele().length)-1; ligne++) {
    		if (partie.getTapisDeJeu().caseRemplie(ligne, colonne) && partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).getForme().ordinal() == carteVictoire.getForme().ordinal()) {
    		
    			if (partie.getTapisDeJeu().caseRemplie(ligne+1, colonne) && partie.getTapisDeJeu().getContainer().get(ligne+1).get(colonne).getForme().ordinal() == carteVictoire.getForme().ordinal()) {
    				compteNbCartesFormeColonne = compteNbCartesFormeColonne+1;
    			} 	
    			else {
    				scoreCompteFormeColonne = scoreCompteFormeColonne + compteNbCartesFormeColonne;
    				compteNbCartesFormeColonne = 0;
    			}
    		}
    		}
    		scoreCompteFormeColonne = scoreCompteFormeColonne + compteNbCartesFormeColonne;
			compteNbCartesFormeColonne = 0;
    	}
    
    	scoreForme = scoreCompteFormeColonne + scoreCompteFormeLigne;
		return scoreForme;
    }

}

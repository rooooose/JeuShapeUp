package shapeUp;


public class ScoreForme implements VisiteurScore {

	/*
	 * Pour le score de FORME on prend en considération à partir de 2 cartes côte à côte
	 * 2 cartes = + 1 point
		...
	 * 5 cartes = + 4 points
	 * 
	 */
	
    public int visiter(Partie partie, CarteDeVictoire carteVictoire) {
    	
    	
    	partie.getTapisDeJeu().getContainer();
    	int scoreForme = 0;
    	int compteNbCartesFormeLigne = 0;
    	int scoreCompteFormeLigne = 0;
    	int compteNbCartesFormeColonne = 0;
    	int scoreCompteFormeColonne = 0 ;
    	//Si plusieurs cartes de même forme que la carte de Victoire sont côte à côte alors
    	// on leur attribue le score du nombre de cartes qui sont à côté (à partir de 3 sinon le score vaut 0)
    
    	
    
    	for (int ligne = 0 ; ligne < partie.getTapisDeJeu().getModele().length; ligne++) {
    		
    		for (int colonne = 0; colonne < partie.getTapisDeJeu().getModele()[ligne].length; colonne++) {
    		if (partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).getForme().ordinal() == carteVictoire.getForme().ordinal() ) {
    		
    			if (partie.getTapisDeJeu().getContainer().get(ligne).get(colonne+1).getForme().ordinal() == carteVictoire.getForme().ordinal()) {
    				compteNbCartesFormeLigne = compteNbCartesFormeLigne+1;
    			} 	
    			else {
    				scoreCompteFormeLigne += compteNbCartesFormeLigne;
    				compteNbCartesFormeLigne = 0;
    			}
    		}
    		}
    	}
    	
    	for (int colonne = 0; colonne < partie.getTapisDeJeu().getModele()[0].length; colonne++) {
    		
    		for (int ligne = 0 ; ligne < partie.getTapisDeJeu().getModele().length; ligne++) {
    		if (partie.getTapisDeJeu().getContainer().get(ligne).get(colonne).getForme().ordinal() == carteVictoire.getForme().ordinal() ) {
    		
    			if (partie.getTapisDeJeu().getContainer().get(ligne+1).get(colonne).getForme().ordinal() == carteVictoire.getForme().ordinal()) {
    				compteNbCartesFormeColonne = compteNbCartesFormeColonne+1;
    			} 	
    			else {
    				scoreCompteFormeColonne += compteNbCartesFormeColonne;
    				compteNbCartesFormeColonne = 0;
    			}
    		}
    		}
    	}
    
    	scoreForme = scoreCompteFormeColonne + scoreCompteFormeLigne;
		return scoreForme;
    }

}

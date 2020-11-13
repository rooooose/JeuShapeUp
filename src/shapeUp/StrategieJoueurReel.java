package shapeUp;


public class StrategieJoueurReel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
		return null;
    }

    public void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carteDejaPlacee) {
    	
    	carteDejaPlacee.setEstPlacee(false);    	
 
    	carteDejaPlacee.setEstPlacee(true);
    }
   

    public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte, TapisDeJeu tapis) {
    	//SCANNER
		if(tapis.placementPossible(ligneCase,colonneCase)) {
			
			tapis.getContainer().get(ligneCase).put(colonneCase, carte);
			carte.setEstPlacee(true); 
			System.out.println(tapis);
		} else {
			//DEMANDER DE REPLACER CARTE
		}
		
    	   	
    }

    public CarteJouable definirCarteAJouer(Carte carte) {
		return null;
    }
}

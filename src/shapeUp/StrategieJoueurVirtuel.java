package shapeUp;


public class StrategieJoueurVirtuel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    }

    public void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carteDejaPlacee) {
    	carteDejaPlacee.setEstPlacee(false);    	
    	 
    	carteDejaPlacee.setEstPlacee(true);
    }

    public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte) {
    	
    	carte.setEstPlacee(true);
    }

    public CarteJouable definirCarteAJouer(Carte carte) {
    }
}

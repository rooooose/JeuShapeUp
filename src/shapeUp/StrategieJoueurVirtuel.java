package shapeUp;


public class StrategieJoueurVirtuel implements StrategieJoueur {
    public Carte piocherCarte(Pioche pioche) {
    }

    public void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carte) {
    	carte.setEstPlacee(false);    	
    	 
    	carte.setEstPlacee(true);
    	
    	
    }

    public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte) {
    	
    	carte.setEstPlacee(true);
    	

    }

    public CarteJouable definirCarteAJouer(Carte carte) {
    }

}

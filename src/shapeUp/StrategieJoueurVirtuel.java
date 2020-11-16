package shapeUp;


public class StrategieJoueurVirtuel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    }

    public void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carteDejaPlacee) {
    	carteDejaPlacee.setEstPlacee(false);    	
    	 
    	carteDejaPlacee.setEstPlacee(true);
    }

    public CarteJouable definirCarteAJouer(Carte carte) {
    }

	@Override
	public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte, TapisDeJeu tapis) {
		// TODO Auto-generated method stub
		
		
		carte.setEstPlacee(true);
	}
}

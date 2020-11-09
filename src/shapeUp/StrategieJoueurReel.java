package shapeUp;


public class StrategieJoueurReel implements StrategieJoueur {
    public Carte piocherCarte(Pioche pioche) {
    	
    	
    	pioche.compterNbCartes(pioche.nbreDeCartes - 1);
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

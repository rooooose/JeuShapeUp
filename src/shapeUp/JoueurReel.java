package shapeUp;


public class JoueurReel extends Joueur implements StrategieJoueur{
	
	JoueurReel(String nom) {
		super(nom);
	}
	
public Carte piocherCarte(Pioche pioche) {
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
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

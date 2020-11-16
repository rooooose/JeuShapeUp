package shapeUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StrategieJoueurVirtuel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
    	
		//On récupère les cartes de la pioche
		List<Carte> recupCartePioche = new ArrayList<Carte>(); 
    	recupCartePioche.addAll(pioche.getPioche()); 
    	
    	//On pioche une carte
    	Carte cartePiochee = recupCartePioche.get(1);
		
    	
    	//On enlève la carte de la pioche
    	
    	Set<Carte> transition = new TreeSet();
    	transition.addAll(pioche.getPioche());
    	transition.remove(cartePiochee);
    	pioche.setPioche(transition);
    	
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    	return cartePiochee;
    	
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

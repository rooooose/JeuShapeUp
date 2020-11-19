package shapeUp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StrategieJoueurVirtuel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
    	
		if (pioche.getNbreDeCartes() < 0) {
			
			System.out.println("Aucune carte disponible dans la pioche");
			return null;
			}
		else {
		
		//On récupère les cartes de la pioche
		List<Carte> recupCartePioche = new ArrayList<Carte>(); 
    	recupCartePioche.addAll(pioche.getPioche()); 
    	
    	//On pioche une carte
    	Carte cartePiochee = recupCartePioche.get(0);
		
    	
    	//On enlève la carte de la pioche
    	
    	Set<Carte> transition = new HashSet();
    	transition = pioche.getPioche();
    	transition.remove(cartePiochee);	
    	pioche.setPioche(transition);
    	
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    	
    	//System.out.println("Le joueur virtuel a pioché sa carte");
    	return cartePiochee;
    	
    }
	}
	

    public void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carteDejaPlacee) {
    	carteDejaPlacee.setEstPlacee(false);    	
    	 
    	carteDejaPlacee.setEstPlacee(true);
    }

    public CarteJouable definirCarteAJouer(Carte carte, Joueur joueur, StrategieMode modeDeJeu) {
		
   
    	
    	
    	if (modeDeJeu instanceof StrategieDeBase) {
    		
    		CarteJouable carteAJouer = (CarteJouable) joueur.getMainDuJoueur();
    		return carteAJouer;
    		
    	} else {
    		System.out.println("Ces modes de jeu ne sont pas encore disponibles");
    		return null;
    		
    	}
    	

	
    	
    }

	@Override
	public void placerCarte(int ligneCase, int colonneCase, CarteJouable carte, TapisDeJeu tapis) {
		// TODO Auto-generated method stub
		
		
		carte.setEstPlacee(true);
	}
}

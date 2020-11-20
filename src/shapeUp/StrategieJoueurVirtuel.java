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

    public Carte definirCarteAJouer(Carte carte, Joueur joueur, StrategieMode modeDeJeu) {

    	
    	//Inclure le choix de la carte dans la main du joueur pour mode AVANCE
    	
    	if (modeDeJeu instanceof StrategieDeBase) {
    		
    		Carte carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		System.out.println("Ces modes de jeu ne sont pas encore disponibles");
    		return null;
    	
    	}
    	

	
    	
    }
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("joueur réel");
		
		return sb.toString();
	}


	@Override
	public void deplacerCarte(TapisDeJeu tapis) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void placerCarte(Carte carte, TapisDeJeu tapis) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int choisirLigneCarte() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int choisirColonneCarte() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void proposerDeplacement(TapisDeJeu tapis) {
		// TODO Auto-generated method stub
		
	}
}

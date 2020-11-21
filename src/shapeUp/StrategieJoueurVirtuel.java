package shapeUp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
	

    public void deplacerCarte(TapisDeJeu tapis) {
    	
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	System.out.println("Le joueur choisit une carte à déplacer :");

    	ligneCase = choisirLigneCarte(tapis);
        colonneCase = choisirColonneCarte(tapis);

    	
    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	System.out.println(tapis);
    	System.out.println("Le joueur a choisi de déplacer la carte " + carteADeplacer);
//    	carteADeplacer.setEstPlacee(false);
    	
    	this.placerCarte(carteADeplacer, tapis);
    }
    

    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {

    	Carte carteAJouer;
    	
    	if (modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie ) {
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		int randomIndex = new Random().nextInt(joueur.getMainDuJoueur().size());
    		carteAJouer = joueur.getMainDuJoueur().remove(randomIndex);
    		System.out.println("Le joueur a choisi la carte à jouer");
    		return carteAJouer;
    	
    	}
    	

	
    	
    }
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("joueur virtuel");
		
		return sb.toString();
	}


	@Override
	public void placerCarte(Carte carte, TapisDeJeu tapis) {
		
		int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		System.out.println("Désormais, les cartes doivent être adjacentes.");
    	}

    	ligneCase = choisirLigneCarte(tapis);
        colonneCase = choisirColonneCarte(tapis);

    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    		tapis.getContainer().get(ligneCase).set(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase)){
    		
    		System.out.println("DECALAGE POSSIBLE ");
    		tapis.decalerCartes(ligneCase, colonneCase);
    		    
    		    //pas obligé ?
    		    //ligne.remove(colonneCase);

    		    tapis.getContainer().get(ligneCase).set(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    		    
    		}

    	System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);
    	System.out.println("NB CARTES : " + tapis.getNbCartes());
		
	}


	@Override
	public int choisirLigneCarte(TapisDeJeu tapis) {

		Random rand = new Random();
		int nb;
        System.out.println("Choix aléatoire d'une ligne...");
	    nb = rand.nextInt(tapis.getContainer().size());
	    System.out.println("Ligne choisie : " + nb);
        return nb;
	}


	@Override
	public int choisirColonneCarte(TapisDeJeu tapis) {
		// revoir methode avec contraintes 0
		Random rand = new Random();
		int nb;
        System.out.println("Choix aléatoire d'une ligne...");
	    nb = rand.nextInt(tapis.getContainer().get(0).size());
	    System.out.println("Ligne choisie : " + nb);
        return nb;
	}


	@Override
	public boolean proposerDeplacement(TapisDeJeu tapis) {
		return false;
		// TODO Auto-generated method stub
		
	}
}

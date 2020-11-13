package shapeUp;

import java.util.Random;

public class StrategieDeBase implements StrategieMode {
     
	
	
	public void distribuerCartes(Joueur joueur, Partie maPartie) {
    	
		int nbreDeJoueurs = maPartie.getListeJoueurs().size();
		
    	if (nbreDeJoueurs == 2) {

    		
    		int longueurListeCarte = maPartie.getCarteDuJeu().size();
    		int randomIndex = new Random().nextInt(longueurListeCarte);
    	
    		CarteJouable carteJ1 = new CarteJouable();
    		
    		carteJ1 = (CarteJouable) maPartie.getCarteDuJeu().get(randomIndex);
    		joueur.setMain(carteJ1);
    		
    		longueurListeCarte = 0;
    		randomIndex = 0;
    		longueurListeCarte = maPartie.getCarteDuJeu().size();
    		randomIndex = new Random().nextInt(longueurListeCarte);

    		
    		CarteJouable carteJ2 = new CarteJouable();
    		
    		carteJ2 = (CarteJouable) maPartie.getCarteDuJeu().get(randomIndex);
    		
    		//maPartie.getListeJoueurs()
    		//.setMain(carteJ2);
    		
    		
    		Pioche pioche = new Pioche (15, maPartie);
    		
    	} else if (nbreDeJoueurs == 3 ) {
 
    	
    	
    		
    		Pioche pioche= new Pioche (14, maPartie);
    	}
    	
    }

    public CarteDeVictoire definirCarteVictoire(Carte carte, Joueur joueur) {
    }

    public void voirCarteVictoire(Joueur joueur) {
    }





}

package shapeUp;


public class StrategieDeBase implements StrategieMode {
     
	
	
	public void distribuerCartes(Joueur joueur, Partie maPartie) {
    	
		int nbreDeJoueurs = maPartie.getListeJoueurs().size();
		
    	switch (nbreDeJoueurs) {
    	case 2 :
    		
    		
    		
    		Pioche pioche = new Pioche (15, maPartie);
    		
    		
    	case 3 : 
    	
    	
    		
    		Pioche pioche = new Pioche (14, maPartie);
    	}
    	
    }

    public CarteDeVictoire definirCarteVictoire(Carte carte, Joueur joueur) {
    }

    public void voirCarteVictoire(Joueur joueur) {
    }





}

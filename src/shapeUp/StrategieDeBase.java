package shapeUp;

import java.util.Iterator;
import java.util.Random;

public class StrategieDeBase implements StrategieMode {
     
	
	
	public void distribuerCartes(Joueur joueur, Partie maPartie) {
    	
		int nbreDeJoueurs = maPartie.getListeJoueurs().size();
		
		Iterator<String> iteratorRecup = maPartie.getListeJoueurs().keySet().iterator();

		while(iteratorRecup.hasNext())  {
			
		  //Param�tres pour r�cup�rer une carte au hasard
			
		  int longueurListeCarte = maPartie.getCarteDuJeu().size();
  		  int randomIndex = new Random().nextInt(longueurListeCarte);
  		  
  		  //R�cup�rer la carte au hasard    
  		  CarteJouable carteJoueur = new CarteJouable(null,null,false);
  		  carteJoueur = (CarteJouable) maPartie.getCarteDuJeu().get(randomIndex);
  		  
  		  //R�cup�rer les diff�rents joueurs pour leur attribuer une carte 
  		  Object key   = iteratorRecup.next();
  		  maPartie.getListeJoueurs().get(key).setMain(carteJoueur);
  		  
  		  //R�initialisation des param�tres pour r�cuperer une carte au hasard
  		  
  		  longueurListeCarte = 0;
  		  randomIndex = 0;
		}
		
		
    	if (nbreDeJoueurs == 2) {
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

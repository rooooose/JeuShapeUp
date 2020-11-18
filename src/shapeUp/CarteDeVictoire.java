
package shapeUp;

import java.util.Iterator;

public class CarteDeVictoire extends Carte {
	
	
	public boolean estVisible(Partie maPartie, Joueur joueur) {
		
		Iterator<CarteDeVictoire> CartesDeVictoires = maPartie.getCarteVictAssociationJoueur().keySet().iterator();
		boolean visibiliteDeLaCarte = false;
		
		
		
		while (CartesDeVictoires.hasNext()) {
		if (maPartie.getModeDeJeu() instanceof StrategieDeBase || maPartie.getModeDeJeu() instanceof StrategieAvance) {
			
			if (maPartie.getCarteVictAssociationJoueur().get(CartesDeVictoires.next()) == joueur) {
				visibiliteDeLaCarte = true;
				
			} else if (maPartie.getCarteVictAssociationJoueur().get(CartesDeVictoires.next()) != joueur) {
				visibiliteDeLaCarte = false;
			}
	

		}else {
			if (maPartie.getCarteVictAssociationJoueur().get(CartesDeVictoires.next()) == joueur) {
				visibiliteDeLaCarte = false;
				
			}else if (maPartie.getCarteVictAssociationJoueur().get(CartesDeVictoires.next()) != joueur) {
				visibiliteDeLaCarte = true;
			}
			
		
	}
	}
		return visibiliteDeLaCarte;
		
}
	
}
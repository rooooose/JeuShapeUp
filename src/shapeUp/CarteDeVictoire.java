
package shapeUp;

import java.util.Iterator;

public class CarteDeVictoire extends Carte {
	
	
	public CarteDeVictoire(CouleurType couleur, FormeCarte forme, boolean estRemplie) {
		super(couleur, forme, estRemplie);
		// TODO Auto-generated constructor stub
	}

	public boolean estVisible(Partie maPartie, Joueur joueur) {
		
		boolean visibiliteDeLaCarte = false;
		
		if (maPartie.getModeDeJeu() instanceof StrategieDeBase || maPartie.getModeDeJeu() instanceof StrategieAvance) {
			if (joueur.getCarteDeVictoire() == this) {
			 visibiliteDeLaCarte = true;
			} else {
				visibiliteDeLaCarte = false;
				
			}
			
		}else {
			if (joueur.getCarteDeVictoire() == this) {
				 visibiliteDeLaCarte = false;
				} else {
					visibiliteDeLaCarte = true;
					
				}
			
		}
		
		return visibiliteDeLaCarte;
		
		
		
}
	
}
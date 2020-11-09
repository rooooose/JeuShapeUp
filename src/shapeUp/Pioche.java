package shapeUp;

import java.util.ArrayList;
import java.util.List;

public class Pioche {
   private int nbreDeCartes; //J'ai changé le modificateur en package pour le joueur puisse modifier cette valeur en piochant une carte

    public int getNbreDeCartes() {
		return nbreDeCartes;
	}

    public void compterNbCartes(int nbreDeCartes) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    }

	public List<Carte> pioche = new ArrayList<Carte> ();

}

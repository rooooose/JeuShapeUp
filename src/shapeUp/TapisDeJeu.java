package shapeUp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TapisDeJeu {
	
    private boolean rempli;
    private FormeTapis forme; 
    
    public FormeTapis getForme() {
		return forme;
	}

	public void setForme(FormeTapis forme) {
		this.forme = forme;
	}
	
	TapisDeJeu(FormeTapis forme) {
		this.setForme(forme);
		
		 switch (forme) {
	    	case Rectangle : 
	    		Set<CarteJouable> tapisRect = new HashSet<CarteJouable> ();
	    		break;
	    	case TriangleRectangle :
	    		Set<CarteJouable> tapisTrRect = new TreeSet<CarteJouable> ();
	    		break;
	    }
	}


	
	
}

package shapeUp;

import java.util.*;

public class TapisRectangle<Carte> extends ArrayList<Carte> {
	
	private final static int NBLIGNES = 3;
	private final static int NBCOLONNES = 5;
	
	TapisRectangle<Carte> ligneTapis;
	
	//TapisRectangle<TapisRectangle<Carte>> ligneTapis;
	
	TapisRectangle(){
		
		for(int i=0; i<NBLIGNES; i++) {
			this.add(i,ligneTapis = new TapisRectangle<Carte>());
		}
		
	}

	public void add(int lig, int col, Carte carte) {
		
		if(lig>=0 && lig<NBLIGNES && col>=0 && col<NBCOLONNES) {
			this.get(lig).add(col,carte);
		}

    }

}

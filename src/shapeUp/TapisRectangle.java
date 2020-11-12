package shapeUp;

public class TapisRectangle extends TapisDeJeu {
	
	private static final int[][] MODELE = {{1,1,1,1,1},
						   			   	   {1,1,1,1,1},
						   			   	   {1,1,1,1,1}};
	
	TapisRectangle(){
		super(MODELE);
	}
	
	

	/*public void add(int lig, int col, Carte carte) {
		
		if(lig>=0 && lig<NBLIGNES && col>=0 && col<NBCOLONNES) {
			this.get(lig).add(col,carte);
		}

    }*/

}

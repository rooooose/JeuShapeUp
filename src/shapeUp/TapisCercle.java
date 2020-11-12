package shapeUp;

public class TapisCercle extends TapisDeJeu{
	
	/*private static final int[][] MODELE = {{0,0,1,1,0},
		   	   							   {0,1,1,1,0},
		   	   							   {1,1,1,1,1},
		   	   							   {0,1,1,1,0},
		   	   							   {0,0,1,1,0}};*/
	
	private static final int[][] MODELE = {{0,1,1,1,1,0},
				   						   {1,1,1,1,1,1},
				   						   {0,1,1,1,1,0}};

	TapisCercle() {
		super(MODELE);
		// TODO Auto-generated constructor stub
	}

}

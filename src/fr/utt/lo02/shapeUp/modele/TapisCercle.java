package fr.utt.lo02.shapeUp.modele;

public class TapisCercle extends TapisDeJeu{
	
	/*private static final int[][] MODELE = {{0,0,1,1,0},
		   	   							   {0,1,1,1,0},
		   	   							   {1,1,1,1,1},
		   	   							   {0,1,1,1,0},
		   	   							   {0,0,1,1,0}};*/
	
	/*private static final int[][] MODELE = {{0,1,1,1,1,0},
				   						   {1,1,1,1,1,1},
				   						   {0,1,1,1,1,0}};*/
	
	private static final int[][] MODELE = {{0,1,1,0},
			   							   {1,1,1,1},
			   							   {1,1,1,1},
			   							   {1,1,1,1},
			   							   {0,1,1,0}};

	public TapisCercle() {
		super(MODELE);
		// TODO Auto-generated constructor stub
	}
	
	/* public String toString() {
	    	
		 StringBuffer sbTapis = new StringBuffer();
		 sbTapis.append("Tapis circulaire");
		 
		 return sbTapis.toString();
	}  */
}




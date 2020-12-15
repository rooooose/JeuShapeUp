package shapeUp;

public class TapisRectangle extends TapisDeJeu {
	
	private static final int[][] MODELE = {{1,1,1,1,1},
						   			   	   {1,1,1,1,1},
						   			   	   {1,1,1,1,1}};
	
	public TapisRectangle(){
		super(MODELE);
	}
	/*public String toString() {
    	
		 StringBuffer sbTapis = new StringBuffer();
		 sbTapis.append("Tapis rectangulaire");
		 
		 return sbTapis.toString();
	}  */
}

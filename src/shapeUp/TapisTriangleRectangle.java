package shapeUp;

public class TapisTriangleRectangle extends TapisDeJeu{
	
	private static final int[][] MODELE = {{1,0,0,0,0},
			   			   				   {1,1,0,0,0},
			   			   				   {1,1,1,0,0},
			   			   				   {1,1,1,1,0},
			   			   				   {1,1,1,1,1}};
	

	TapisTriangleRectangle(){
		super(MODELE);
	}

}

package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;

public class TapisTriangleRectangle extends TapisDeJeu{
	
	private static final int[][] MODELE = {{1,0,0,0,0},
			   			   				   {1,1,0,0,0},
			   			   				   {1,1,1,0,0},
			   			   				   {1,1,1,1,0},
			   			   				   {1,1,1,1,1}};
	
	//private static final int NBLIGNES = 5;

	public TapisTriangleRectangle(){

		super(MODELE);
//		ArrayList<Carte> ligne0 = new ArrayList<Carte>();
//		ArrayList<Carte> ligne1 = new ArrayList<Carte>();
//		ArrayList<Carte> ligne2 = new ArrayList<Carte>();
//		ArrayList<Carte> ligne3 = new ArrayList<Carte>();
//		ArrayList<Carte> ligne4 = new ArrayList<Carte>();
//		container.add(ligne0);
//		container.add(ligne1);
//		container.add(ligne2);
//		container.add(ligne3);
//		container.add(ligne4);
//		
//		Carte carteVide = new Carte();
	
		
	}
	/*public String toString() {
    	
		 StringBuffer sbTapis = new StringBuffer();
		 sbTapis.append("Tapis triangle rectangle");
		 
		 return sbTapis.toString();
	}  */
}

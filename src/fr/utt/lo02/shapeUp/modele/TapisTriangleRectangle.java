package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;

/**
 * 
 * Représente la forme de triangle rectangle du tapis de jeu. Elle hérite de TapisDeJeu
 * Elle définit un modèle qui sera utilisé pour créer une liste dynamique représentant le tapis.
 *
 * @author Mathéa Z, Shir F
 */
public class TapisTriangleRectangle extends TapisDeJeu{
	
	/**
	 * Représente le modèle fixe attribué à la forme triangulaire, grâce à un tableau d'entiers. Les 1 représentent une case utilisable contrairement aux 0.
	 */
	private static final int[][] MODELE = {{1,0,0,0,0},
			   			   				   {1,1,0,0,0},
			   			   				   {1,1,1,0,0},
			   			   				   {1,1,1,1,0},
			   			   				   {1,1,1,1,1}};
	/**
	 * Instancie un tapis de forme triangulaire en passant son modèle au constructeur de la classe mère.
	 */
	public TapisTriangleRectangle(){
		super(MODELE);
	}
}

package fr.utt.lo02.shapeUp.modele;

/**
 * 
 * Représente la forme de Rectangle du tapis de jeu. Elle hérite de TapisDeJeu
 * Elle définit un modèle qui sera utilisé pour créer une liste dynamique représentant le tapis.
 *
 * @author Mathéa Z, Shir F
 */
public class TapisRectangle extends TapisDeJeu {
	
	/**
	 * Représente le modèle fixe attribué à la forme rectangulaire, grâce à un tableau d'entiers. Les 1 représentent une case utilisable.
	 */
	private static final int[][] MODELE = {{1,1,1,1,1},
						   			   	   {1,1,1,1,1},
						   			   	   {1,1,1,1,1}};
	/**
	 * Instancie un tapis de forme rectangulaire en passant son modèle au constructeur de la classe mère.
	 */
	public TapisRectangle(){
		super(MODELE);
	}
	
}

package fr.utt.lo02.shapeUp.modele;

/**
 * 
 * Représente la forme de Disque du tapis de jeu. Elle hérite de TapisDeJeu
 * Elle définit un modèle qui sera utilisé pour créer une liste dynamique représentant le tapis.
 *
 * @author Mathéa Z, Shir F
 */
public class TapisCercle extends TapisDeJeu{
	
	/**
	 * Représente le modèle fixe attribué à la forme circulaire, grâce à un tableau d'entiers. Les 1 représentent une case utilisable contrairement aux 0.
	 */
	private static final int[][] MODELE = {{0,1,1,0},
			   							   {1,1,1,1},
			   							   {1,1,1,1},
			   							   {1,1,1,1},
			   							   {0,1,1,0}};
	/**
	 * Instancie un tapis de forme circulaire en passant son modèle au constructeur de la classe mère.
	 */
	public TapisCercle() {
		super(MODELE);
	}
	
}




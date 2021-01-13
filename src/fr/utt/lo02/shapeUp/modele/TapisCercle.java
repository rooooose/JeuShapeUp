package fr.utt.lo02.shapeUp.modele;

/**
 * 
 * Repr�sente la forme de Disque du tapis de jeu. Elle h�rite de TapisDeJeu
 * Elle d�finit un mod�le qui sera utilis� pour cr�er une liste dynamique repr�sentant le tapis.
 *
 * @author Math�a Z, Shir F
 */
public class TapisCercle extends TapisDeJeu{
	
	/**
	 * Repr�sente le mod�le fixe attribu� � la forme circulaire, gr�ce � un tableau d'entiers. Les 1 repr�sentent une case utilisable contrairement aux 0.
	 */
	private static final int[][] MODELE = {{0,1,1,0},
			   							   {1,1,1,1},
			   							   {1,1,1,1},
			   							   {1,1,1,1},
			   							   {0,1,1,0}};
	/**
	 * Instancie un tapis de forme circulaire en passant son mod�le au constructeur de la classe m�re.
	 */
	public TapisCercle() {
		super(MODELE);
	}
	
}




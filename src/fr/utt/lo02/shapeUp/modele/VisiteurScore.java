package fr.utt.lo02.shapeUp.modele;

/**
 * L'interface VisiteurScore permet de d�clarer la m�thode visiter qui sera utilis�e pour calculer le score en fin de partie. <br>
 * La partie est une impl�mentation de l'interface Visitable qui lui permet d'�tre visiter.
 * 
 * @author Shir F, Math�a Z
 * @see {@link ScoreForme}, {@link ScoreCouleur}, {@link ScoreRemplissage}, {@link Visitable}
 *
 */

public interface VisiteurScore {
	
	/**
	 * Permet de visiter, en fin de jeu, la partie pour �tudier le placement des cartes et calculer le score en fonction de la carte de victoire de chaque joueur  
	 * @param partie partie de jeu actuelle
	 * @param carteVictoire carte de victoire d'un joueur
	 * @return entier correspondant au score 
	 */
    int visiter(Partie partie, Carte carteVictoire);

}

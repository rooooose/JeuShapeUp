package fr.utt.lo02.shapeUp.modele;

import java.util.List;
/**
 * L'interface StrategieMode permet de déclarer les méthodes qui seront utilisées pour définir les différents modes de jeu d'une partie.
 * @author Shir F, Mathéa Z
 * @see StrategieDeBase 
 * @see StrategieVictoireEnnemie
 * @see StrategieAvance
 * @see Partie
 * */


public interface StrategieMode {

	/**
	 * La méthode distribuerCartes permet de distribuer les cartes en début de Partie à chaque joueur.
	 * @param maPartie la partie de jeu actuelle
	 * @return Les cartes non utilisées pour la distribution pour qu'elles soient utilisées dans la pioche
	 * @see #creerLaPiocheDeLaPartie(Partie)
	 */
    public List<Carte> distribuerCartes(Partie maPartie);
/**
 * La méthode voirCarteVictoire permet de définir si un joueur peut voir sa carte de victoire ou non.
 * 
 * @param maPartie la partie de jeu actuelle
 * @param joueur le joueur dont on définit quelle carte de victoire il peut voir
 */
    public void voirCarteVictoire(Partie maPartie, Joueur joueur);
/**
 * La méthode creerLaPiocheDeLaPartie permet de créer la pioche de la partie de jeu actuelle en garantissant l'unicité des cartes de jeu.   
 * @param maPartie la partie de jeu actuelle
 * @return La pioche qui est utilisée tout au long de la partie
 */
    public Pioche creerLaPiocheDeLaPartie (Partie maPartie);
/**
 * Cette méthode est appelée et permet de finir la partie pour pouvoir calculer le score et définir un gagnant (par appels de méthode de la partie).    
 * @param maPartie la partie de jeu actuelle
 * @see Partie#calculerScoreTotal(Joueur)
 * @see Partie#definirGagnant()
 */
    public void finirLaPartie (Partie maPartie);

}

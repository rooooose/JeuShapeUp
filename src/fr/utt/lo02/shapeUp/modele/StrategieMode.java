package fr.utt.lo02.shapeUp.modele;

import java.util.List;
/**
 * L'interface StrategieMode permet de d�clarer les m�thodes qui seront utilis�es pour d�finir les diff�rents modes de jeu d'une partie.
 * @author Shir F, Math�a Z
 * @see StrategieDeBase 
 * @see StrategieVictoireEnnemie
 * @see StrategieAvance
 * @see Partie
 * */


public interface StrategieMode {

	/**
	 * La m�thode distribuerCartes permet de distribuer les cartes en d�but de Partie � chaque joueur.
	 * @param maPartie la partie de jeu actuelle
	 * @return Les cartes non utilis�es pour la distribution pour qu'elles soient utilis�es dans la pioche
	 * @see #creerLaPiocheDeLaPartie(Partie)
	 */
    public List<Carte> distribuerCartes(Partie maPartie);
/**
 * La m�thode voirCarteVictoire permet de d�finir si un joueur peut voir sa carte de victoire ou non.
 * 
 * @param maPartie la partie de jeu actuelle
 * @param joueur le joueur dont on d�finit quelle carte de victoire il peut voir
 */
    public void voirCarteVictoire(Partie maPartie, Joueur joueur);
/**
 * La m�thode creerLaPiocheDeLaPartie permet de cr�er la pioche de la partie de jeu actuelle en garantissant l'unicit� des cartes de jeu.   
 * @param maPartie la partie de jeu actuelle
 * @return La pioche qui est utilis�e tout au long de la partie
 */
    public Pioche creerLaPiocheDeLaPartie (Partie maPartie);
/**
 * Cette m�thode est appel�e et permet de finir la partie pour pouvoir calculer le score et d�finir un gagnant (par appels de m�thode de la partie).    
 * @param maPartie la partie de jeu actuelle
 * @see Partie#calculerScoreTotal(Joueur)
 * @see Partie#definirGagnant()
 */
    public void finirLaPartie (Partie maPartie);

}

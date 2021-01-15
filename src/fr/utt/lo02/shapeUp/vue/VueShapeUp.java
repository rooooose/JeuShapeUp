package fr.utt.lo02.shapeUp.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.utt.lo02.shapeUp.controleurs.ControleurShapeUp;
import fr.utt.lo02.shapeUp.modele.JoueurReel;
import fr.utt.lo02.shapeUp.modele.JoueurVirtuel;
import fr.utt.lo02.shapeUp.modele.Observable;
import fr.utt.lo02.shapeUp.modele.Observer;
import fr.utt.lo02.shapeUp.modele.Partie;
import fr.utt.lo02.shapeUp.modele.ShapeUp;
import fr.utt.lo02.shapeUp.modele.StrategieAvance;
import fr.utt.lo02.shapeUp.modele.StrategieDeBase;
import fr.utt.lo02.shapeUp.modele.StrategieMode;
import fr.utt.lo02.shapeUp.modele.StrategieVictoireEnnemie;
import fr.utt.lo02.shapeUp.modele.TapisCercle;
import fr.utt.lo02.shapeUp.modele.TapisDeJeu;
import fr.utt.lo02.shapeUp.modele.TapisRectangle;
import fr.utt.lo02.shapeUp.modele.TapisTriangleRectangle;
/**
 * Cette classe permet de choisir les paramètres de ShapeUp via une interface graphique. C'est une vue graphique de ShapeUp.
 * 
 * @see ShapeUp
 * @author Shir F, Mathéa Z
 * 
 *
 */
public class VueShapeUp implements Observer {
	
	/**
	 * Cet attribut permet d'avoir une vue graphique de la partie actuelle utilisée dans ShapeUp.
	 * 
	 * @see VuePartie
	 */
	private VuePartie maPartie;
	
	/**
	 * Permet de récupérer la vue graphique de la partie
	 * @return la vue graphique de la partie
	 */
	public VuePartie getMaPartie() {
		return maPartie;
	}

	/**
	 * Permet de définir la vue graphique de la partie
	 * @param maPartie - Vue graphique de la partie 
	 */
	public void setMaPartie(VuePartie maPartie) {
		this.maPartie = maPartie;
	}

	/**
	 * Objet ShapeUp observé par cette classe
	 * 
	 */
	private ShapeUp jeuShapeUp;
	/**
	 * Console qui observe le même objet que la vue graphique
	 */
	private Console console;
	/**
	 * Fenêtre contenant les objets qui permettent de choisir les différents paramètres de la partie de ShapeUp
	 */
	private JFrame fenetreChoix;
	/**
	 * Zone de texte pour préciser qu'on est dans le choix des paramètres
	 */
	private JLabel choix;
	
	/**
	 * Ce bouton permet de valider tous les choix de paramètres effectués
	 */
	private JButton okAll;
	
	/**
	 * Permet de récupérer le bouton de choix final
	 * @return JButton correspond à la confirmation de choix final
	 */
	public JButton getOkAll() {
		return okAll;
	}
	/**
	 * Permet de définir le bouton de choix final.
	 * @param okAll - JButton de choix final
	 */

	public void setOkAll(JButton okAll) {
		this.okAll = okAll;
	}

	/**
	 * Cet attribut sera composé de l'ensemble d'éléments graphiques qui concernent le choix du nombre de joueur.
	 */
	private JPanel containerNbre;
	/**
	 * L'ensemble des boutons utilisés pour le choix du nombre de joueurs
	 */
	private ButtonGroup choixNbre;
	/**
	 * Bouton de confirmation du choix du nombre, à utiliser lorsque le choix a été fait.
	 */
	private JButton okNbre;
	/**
	 * Permet, lorsqu'il est sélectionné, de choisir 2 joueurs.
	 */
	private JRadioButton deuxJoueurs;

	
	/***
	 * Permet de récupérer la fenêtre principale de la vue.
	 * @return JFrame comprenant tous les éléments graphiques pour le choix des paramètres
	 * 
	 */
	public JFrame getFenetreChoix() {
		return fenetreChoix;
	}

	/**
	 * Permet de définir la fenêtre utilisée pour les choix.
	 * @param fenetreChoix
	 */
	public void setFenetreChoix(JFrame fenetreChoix) {
		this.fenetreChoix = fenetreChoix;
	}

	/**
	 * Permet de récupérer la zone de texte indiquant le choix des paramètres
	 * @return JLabel correspondant à la zone de texte indiquant le choix des paramètres
	 */
	public JLabel getChoix() {
		return choix;
	}

	/**
	 * Permet de définir la zone de texte pour le choix des paramètres
	 * @param choix
	 */
	public void setChoix(JLabel choix) {
		this.choix = choix;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix du nombre de joueurs
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix du nombre de joueurs
	 */
	public JPanel getContainerNbre() {
		return containerNbre;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix du nombre de joueurs
	 * @param containerNbre
	 */
	public void setContainerNbre(JPanel containerNbre) {
		this.containerNbre = containerNbre;
	}

	/**
	 * Permet de récupérer le groupe de JRadioButton permettant de choisir un nombre de joueurs
	 * @return Groupe de JRadioButton permettant de choisir le nombre de joueurs
	 */
	public ButtonGroup getChoixNbre() {
		return choixNbre;
	}

	/**
	 * Permet de définir le groupe de JRadioButton permettant de choisir un nombre de joueurs
	 * @param choixNbre
	 */
	public void setChoixNbre(ButtonGroup choixNbre) {
		this.choixNbre = choixNbre;
	}

	/**
	 * Permet de récupérer le bouton de confirmation de choix du nombre de joueurs
	 * @return JButton pour la confirmation du choix de nombre de joueurs
	 */
	public JButton getOkNbre() {
		return okNbre;
	}

	/**
	 * Permet de définir le bouton de confirmation de choix du nombre de joueurs
	 * @param okNbre
	 */
	public void setOkNbre(JButton okNbre) {
		this.okNbre = okNbre;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction de 2 joueurs pour la partie.
	 * @return JRadioButton correspondant à 2 joueurs
	 */
	public JRadioButton getDeuxJoueurs() {
		return deuxJoueurs;
	}

	/**
	 * Permet de définir le JRadioButton pour la séléction de 2 joueurs pour la partie.
	 * @param deuxJoueurs
	 */

	public void setDeuxJoueurs(JRadioButton deuxJoueurs) {
		this.deuxJoueurs = deuxJoueurs;
	}
	/**
	 * Permet de récupérer le JRadioButton pour la séléction de 3 joueurs pour la partie.
	 * @return JRadioButton correspondant à 3 joueurs
	 */

	public JRadioButton getTroisJoueurs() {
		return troisJoueurs;
	}
	/**
	 * Permet de définir le JRadioButton pour la séléction de 3 joueurs pour la partie.
	 * @param troisJoueurs
	 */

	public void setTroisJoueurs(JRadioButton troisJoueurs) {
		this.troisJoueurs = troisJoueurs;
	}

	/**
	 * Permet de récupérer la zone de texte permettant d'indiquer à l'utilisateur le nombre de joueurs sélectionné.
	 * @return JLabel lié au choix du nombre de joueurs
	 */
	public JLabel getNbreJoueurs() {
		return nbreJoueurs;
	}

	/**
	 * Permet de définir la zone de texte permettant d'indiquer à l'utilisateur le nombre de joueurs sélectionné.
	 * @param nbreJoueurs
	 */

	public void setNbreJoueurs(JLabel nbreJoueurs) {
		this.nbreJoueurs = nbreJoueurs;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix du type des joueurs
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix du type des joueurs
	 */

	public JPanel getContainerType() {
		return containerType1;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix du type des joueurs
	 * @param containerType
	 */
	public void setContainerType(JPanel containerType) {
		this.containerType1 = containerType;
	}
	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix du mode de jeu
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix du mode de jeu
	 */
	public JPanel getContainerMode() {
		return containerMode;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix du mode de jeu
	 * @param containerMode
	 */
	public void setContainerMode(JPanel containerMode) {
		this.containerMode = containerMode;
	}

	/**
	 * Permet de récupérer le groupe de JRadioButton permettant de choisir un mode de jeu
	 * @return Groupe de JRadioButton permettant de choisir un mode de jeu
	 */
	public ButtonGroup getChoixMode() {
		return choixMode;
	}

	/**
	 * Permet de définir le groupe de JRadioButton permettant de choisir un mode de jeu
	 * @param choixMode
	 */
	public void setChoixMode(ButtonGroup choixMode) {
		this.choixMode = choixMode;
	}

	/**
	 * Permet de récupérer le bouton de confirmation de choix du mode de jeu
	 * @return JButton pour la confirmation du choix de mode de jeu
	 */
	public JButton getOkMode() {
		return okMode;
	}

	/**
	 * Permet de définir le bouton de confirmation de choix du mode de jeu
	 * @param okMode
	 */
	public void setOkMode(JButton okMode) {
		this.okMode = okMode;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction des règles avancées
	 * @return JRadioButton correspondant aux règles avancées
	 */
	public JRadioButton getAvance() {
		return avance;
	}

	/**
	 * Permet de définir le JRadioButton pour la séléction des règles avancées
	 * @param avance
	 */
	public void setAvance(JRadioButton avance) {
		this.avance = avance;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction des règles "victoire ennemie"
	 * @return JRadioButton correspondant aux règles "victoire ennemieé
	 */

	public JRadioButton getVictoireEnnemie() {
		return victoireEnnemie;
	}
	/**
	 * Permet de définir le JRadioButton pour la séléction des règles "victoire ennemie"
	 * @param victoireEnnemie
	 */

	public void setVictoireEnnemie(JRadioButton victoireEnnemie) {
		this.victoireEnnemie = victoireEnnemie;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction des règles de base
	 * @return JRadioButton correspondant aux règles de base
	 */
	public JRadioButton getDeBase() {
		return deBase;
	}
	/**
	 * Permet de définir le JRadioButton pour la séléction des règles de base
	 * @param deBase
	 */

	public void setDeBase(JRadioButton deBase) {
		this.deBase = deBase;
	}

	/**
	 * Permet de récupérer la zone de texte permettant d'indiquer à l'utilisateur le mode de jeu sélectionné.
	 * @return JLabel lié au choix du mode de jeu
	 */
	public JLabel getModeDeJeu() {
		return modeDeJeu;
	}

	/**
	 * Permet de définir la zone de texte permettant d'indiquer à l'utilisateur le mode de jeu sélectionné.
	 * @param modeDeJeu
	 */
	public void setModeDeJeu(JLabel modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix de la forme du tapis
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix de la forme du tapis
	 */
	public JPanel getContainerForme() {
		return containerForme;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix de la forme du tapis
	 * @param containerForme
	 */
	public void setContainerForme(JPanel containerForme) {
		this.containerForme = containerForme;
	}
	/**
	 * Permet de récupérer le groupe de JRadioButton permettant de choisir une forme de tapis de jeu
	 * @return Groupe de JRadioButton permettant de choisir une forme de tapis de jeu
	 */

	public ButtonGroup getChoixForme() {
		return choixForme;
	}

	/**
	 * Permet de définir le groupe de JRadioButton permettant de choisir une forme de tapis de jeu
	 * @param choixForme
	 */
	public void setChoixForme(ButtonGroup choixForme) {
		this.choixForme = choixForme;
	}
	/**
	 * Permet de récupérer le bouton de confirmation de choix de la forme du tapis de jeu
	 * @return JButton pour la confirmation du choix de la forme du tapis de jeu
	 */

	public JButton getOkForme() {
		return okForme;
	}

	/**
	 * Permet de définir le bouton de confirmation de choix de la forme du tapis de jeu
	 * @param okForme
	 */
	public void setOkForme(JButton okForme) {
		this.okForme = okForme;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction de la forme de tapis rectangle
	 * @return JRadioButton correspondant à la forme de tapis rectangle
	 */
	public JRadioButton getRectangle() {
		return rectangle;
	}

	/**
	 * Permet de définir le JRadioButton pour la séléction de la forme de tapis rectangle
	 * @param rectangle
	 */

	public void setRectangle(JRadioButton rectangle) {
		this.rectangle = rectangle;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction de la forme de tapis triangle rectangle
	 * @return JRadioButton correspondant à la forme de tapis triangle rectangle
	 */
	public JRadioButton getTriangle() {
		return triangle;
	}

	/**
	 * Permet de définir le JRadioButton pour la séléction de la forme de tapis triangle rectangle
	 * @param triangle
	 */
	public void setTriangle(JRadioButton triangle) {
		this.triangle = triangle;
	}

	/**
	 * Permet de récupérer le JRadioButton pour la séléction de la forme de tapis circulaire
	 * @return JRadioButton correspondant à la forme de tapis circulaire
	 */
	public JRadioButton getCercle() {
		return cercle;
	}

	/**
	 * Permet de définir le JRadioButton pour la séléction de la forme de tapis circulaire
	 * @param cercle
	 */
	public void setCercle(JRadioButton cercle) {
		this.cercle = cercle;
	}

	/**
	 * Permet de récupérer la zone de texte permettant d'indiquer à l'utilisateur la forme de tapis sélectionnée.
	 * @return JLabel lié au choix de la forme du tapis
	 */
	public JLabel getFormeTapis() {
		return formeTapis;
	}

	/**
	 * Permet de définir la zone de texte permettant d'indiquer à l'utilisateur la forme de tapis sélectionnée.
	 * @param formeTapis
	 */
	public void setFormeTapis(JLabel formeTapis) {
		this.formeTapis = formeTapis;
	}
	
	/**
	 * Permet de récupérer l'objet ShapeUp observée par cette vue graphique
	 * @return Objet ShapeUp observé
	 */
	public ShapeUp getJeuShapeUp() {
		return jeuShapeUp;
	}
	
	/**
	 * Permet de définir l'objet ShapeUp observée par cette vue graphique
	 * @param jeuShapeUp
	 */

	public void setJeuShapeUp(ShapeUp jeuShapeUp) {
		this.jeuShapeUp = jeuShapeUp;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix du type du joueur 1
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix du type du joueur 1
	 */

	public JPanel getContainerType1() {
		return containerType1;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix du type du joueur 1
	 * @param containerType1
	 */
	public void setContainerType1(JPanel containerType1) {
		this.containerType1 = containerType1;
	}

	/**
	 * Permet de récupérer la zone de texte correspondant au choix du type du joueur 1
	 * @return JLabel correspondant au choix du type du joueur 1
	 */
	public JLabel getTypeDuJoueur1() {
		return typeDuJoueur1;
	}

	/**
	 * Permet de définir la zone de texte correspondant au choix du type du joueur 1
	 * @param typeDuJoueur1
	 */

	public void setTypeDuJoueur1(JLabel typeDuJoueur1) {
		this.typeDuJoueur1 = typeDuJoueur1;
	}

	/**
	 * Permet de récupérer le bouton de confirmation de choix du type du joueur 1
	 * @return JButton de confirmation de choix du type du joueur 1
	 */
	public JButton getOkType1() {
		return okType1;
	}
	/**
	 * Permet de définir le bouton de confirmation de choix du type du joueur 1
	 * @param okType1
	 */

	public void setOkType1(JButton okType1) {
		this.okType1 = okType1;
	}
	
	/**
	 * Permet de récupérer l'ensemble des boutons liés au choix du type du joueur 1
	 * @return ButtonGroup des boutons liés au choix du type du joueur 1
	 */

	public ButtonGroup getChoixType1() {
		return choixType1;
	}

	/**
	 * Permet de définir l'ensemble des boutons liés au choix du type du joueur 1
	 * @param choixType1
	 */
	public void setChoixType1(ButtonGroup choixType1) {
		this.choixType1 = choixType1;
	}

	/**
	 * Permet de récupérer le bouton de séléction d'un joueur 1 de type virtuel
	 * @return JRadioButton pour choisir un joueur 1 virtuel
	 */
	public JRadioButton getVirtuel1() {
		return virtuel1;
	}
	/**
	 * Permet de définir le bouton de séléction d'un joueur 1 de type virtuel
	 * @param virtuel1
	 */

	public void setVirtuel1(JRadioButton virtuel1) {
		this.virtuel1 = virtuel1;
	}

	/**
	 * Permet de récupérer le bouton de séléction d'un joueur 1 de type réel
	 * @return JRadioButton pour choisir un joueur 1 réel
	 */
	public JRadioButton getReel1() {
		return reel1;
	}
	/**
	 * Permet de définir le bouton de séléction d'un joueur 1 de type réel
	 * @param reel1
	 */

	public void setReel1(JRadioButton reel1) {
		this.reel1 = reel1;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix du type du joueur 1
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix du type du joueur 1
	 */
	public JPanel getContainerType2() {
		return containerType2;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix du type du joueur 1
	 * @param containerType1
	 */
	public void setContainerType2(JPanel containerType2) {
		this.containerType2 = containerType2;
	}

	/**
	 * Permet de récupérer la zone de texte correspondant au choix du type du joueur 2
	 * @return JLabel correspondant au choix du type du joueur 2
	 */
	public JLabel getTypeDuJoueur2() {
		return typeDuJoueur2;
	}

	/**
	 * Permet de définir la zone de texte correspondant au choix du type du joueur 2
	 * @param typeDuJoueur2
	 */
	public void setTypeDuJoueur2(JLabel typeDuJoueur2) {
		this.typeDuJoueur2 = typeDuJoueur2;
	}

	/**
	 * Permet de récupérer le bouton de confirmation de choix du type du joueur 2
	 * @return JButton de confirmation de choix du type du joueur 2
	 */
	public JButton getOkType2() {
		return okType2;
	}
	/**
	 * Permet de définir le bouton de confirmation de choix du type du joueur 2
	 * @param okType2
	 */

	public void setOkType2(JButton okType2) {
		this.okType2 = okType2;
	}

	/**
	 * Permet de récupérer l'ensemble des boutons liés au choix du type du joueur 2
	 * @return ButtonGroup des boutons liés au choix du type du joueur 2
	 */
	public ButtonGroup getChoixType2() {
		return choixType2;
	}

	/**
	 * Permet de définir l'ensemble des boutons liés au choix du type du joueur 2
	 * @param choixType2
	 */
	public void setChoixType2(ButtonGroup choixType2) {
		this.choixType2 = choixType2;
	}

	/**
	 * Permet de récupérer le bouton de séléction d'un joueur 2 de type virtuel
	 * @return JRadioButton pour choisir un joueur 2 virtuel
	 */

	public JRadioButton getVirtuel2() {
		return virtuel2;
	}

	/**
	 * Permet de définir le bouton de séléction d'un joueur 2 de type virtuel
	 * @param virtuel2
	 */
	public void setVirtuel2(JRadioButton virtuel2) {
		this.virtuel2 = virtuel2;
	}

	/**
	 * Permet de récupérer le bouton de séléction d'un joueur 2 de type réel
	 * @return JRadioButton pour choisir un joueur 2 réel
	 */
	public JRadioButton getReel2() {
		return reel2;
	}

	/**
	 * Permet de définir le bouton de séléction d'un joueur 2 de type réel
	 * @param reel2
	 */
	public void setReel2(JRadioButton reel2) {
		this.reel2 = reel2;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques pour le choix du type du joueur 3
	 * @return JPanel correspondant à l'ensemble des éléments graphiques pour le choix du type du joueur 3
	 */
	public JPanel getContainerType3() {
		return containerType3;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques pour le choix du type du joueur 3
	 * @param containerType3
	 */
	public void setContainerType3(JPanel containerType3) {
		this.containerType3 = containerType3;
	}

	/**
	 * Permet de récupérer la zone de texte correspondant au choix du type du joueur 3
	 * @return JLabel correspondant au choix du type du joueur 3
	 */
	public JLabel getTypeDuJoueur3() {
		return typeDuJoueur3;
	}
	/**
	 * Permet de définir la zone de texte correspondant au choix du type du joueur 3
	 * @param typeDuJoueur3
	 */

	public void setTypeDuJoueur3(JLabel typeDuJoueur3) {
		this.typeDuJoueur3 = typeDuJoueur3;
	}

	/**
	 * Permet de récupérer le bouton de confirmation de choix du type du joueur 3
	 * @return JButton de confirmation de choix du type du joueur 3
	 */

	public JButton getOkType3() {
		return okType3;
	}

	/**
	 * Permet de définir le bouton de confirmation de choix du type du joueur 3
	 * @param okType3
	 */
	public void setOkType3(JButton okType3) {
		this.okType3 = okType3;
	}

	/**
	 * Permet de récupérer l'ensemble des boutons liés au choix du type du joueur 3
	 * @return ButtonGroup des boutons liés au choix du type du joueur 3
	 */
	public ButtonGroup getChoixType3() {
		return choixType3;
	}

	/**
	 * Permet de définir l'ensemble des boutons liés au choix du type du joueur 3
	 * @param choixType3
	 */
	public void setChoixType3(ButtonGroup choixType3) {
		this.choixType3 = choixType3;
	}

	/**
	 * Permet de récupérer le bouton de séléction d'un joueur 3 de type virtuel
	 * @return JRadioButton pour choisir un joueur 3 virtuel
	 */
	public JRadioButton getVirtuel3() {
		return virtuel3;
	}

	/**
	 * Permet de définir le bouton de séléction d'un joueur 3 de type virtuel
	 * @param virtuel3
	 */
	public void setVirtuel3(JRadioButton virtuel3) {
		this.virtuel3 = virtuel3;
	}
	/**
	 * Permet de récupérer le bouton de séléction d'un joueur 3 de type réel
	 * @return JRadioButton pour choisir un joueur 3 réel
	 */

	public JRadioButton getReel3() {
		return reel3;
	}

	/**
	 * Permet de définir le bouton de séléction d'un joueur 3 de type réel
	 * @param reel3
	 */
	public void setReel3(JRadioButton reel3) {
		this.reel3 = reel3;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au choix du nom du joueur 1 
	 * @return JPanel contenant l'ensemble des éléments graphiques liés au choix du nom du joueur 1 
	 */
	public JPanel getContainerNom1() {
		return containerNom1;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au choix du nom du joueur 1
	 * @param containerNom1
	 */
	public void setContainerNom1(JPanel containerNom1) {
		this.containerNom1 = containerNom1;
	}
	/**
	 * Permet de récupérer la zone de texte (modifiable par l'utilisateur) correspondant au choix du nom du joueur 1
	 * @return JTextField permettant d'écrire le nom du joueur 1
	 */

	public JTextField getNomJoueur1() {
		return nomJoueur1;
	}
	/**
	 * Permet de définir la zone de texte (modifiable par l'utilisateur) correspondant au choix du nom du joueur 1
	 * @param nomJoueur1
	 */

	public void setNomJoueur1(JTextField nomJoueur1) {
		this.nomJoueur1 = nomJoueur1;
	}

	/**
	 * Permet de récupérer le bouton de confirmation du choix du nom du joueur 1. <br> 
	 * Si l'utilisateur appuie sur ce bouton sans avoir inscrit de nom, le joueur 1 aura automatiquement pour nom "Joueur 1".
	 * @return JButton lié à la confirmation du choix du nom du joueur 1.
	 */
	public JButton getOkNom1() {
		return okNom1;
	}

	/**
	 * Permet de définir le bouton de confirmation du choix du nom du joueur 1.
	 * @param okNom1
	 */
	public void setOkNom1(JButton okNom1) {
		this.okNom1 = okNom1;
	}

	/**
	 * Permet de récupérer la zone de texte lié au choix du nom du joueur 1.
	 * @return JLabel lié au choix du nom du joueur 1
	 */
	public JLabel getNomDuJoueur1() {
		return nomDuJoueur1;
	}

	/**
	 * Permet de définir la zone de texte lié au choix du nom du joueur 1.
	 * @param nomDuJoueur1
	 */
	public void setNomDuJoueur1(JLabel nomDuJoueur1) {
		this.nomDuJoueur1 = nomDuJoueur1;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au choix du nom du joueur 2 
	 * @return JPanel contenant l'ensemble des éléments graphiques liés au choix du nom du joueur 2
	 */
	public JPanel getContainerNom2() {
		return containerNom2;
	}
	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au choix du nom du joueur 2 
	 * @param containerNom2
	 */

	public void setContainerNom2(JPanel containerNom2) {
		this.containerNom2 = containerNom2;
	}

	/**
	 * Permet de récupérer la zone de texte (modifiable par l'utilisateur) correspondant au choix du nom du joueur 2
	 * @return JTextField permettant d'écrire le nom du joueur 2
	 */
	public JTextField getNomJoueur2() {
		return nomJoueur2;
	}
	/**
	 * Permet de définir la zone de texte (modifiable par l'utilisateur) correspondant au choix du nom du joueur 2
	 * @param nomJoueur2
	 */

	public void setNomJoueur2(JTextField nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}
	/**
	 * Permet de récupérer le bouton de confirmation du choix du nom du joueur 2. <br> 
	 * Si l'utilisateur appuie sur ce bouton sans avoir inscrit de nom, le joueur 2 aura automatiquement pour nom "Joueur 2".
	 * @return JButton lié à la confirmation du choix du nom du joueur 2.
	 */

	public JButton getOkNom2() {
		return okNom2;
	}

	/**
	 * Permet de définir le bouton de confirmation du choix du nom du joueur 2.
	 * @param okNom2
	 */
	public void setOkNom2(JButton okNom2) {
		this.okNom2 = okNom2;
	}

	/**
	 * Permet de récupérer la zone de texte lié au choix du nom du joueur 2.
	 * @return JLabel lié au choix du nom du joueur 2
	 */
	public JLabel getNomDuJoueur2() {
		return nomDuJoueur2;
	}

	/**
	 * Permet de définir la zone de texte lié au choix du nom du joueur 2.
	 * @param nomDuJoueur2
	 */
	public void setNomDuJoueur2(JLabel nomDuJoueur2) {
		this.nomDuJoueur2 = nomDuJoueur2;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au choix du nom du joueur 3 
	 * @return JPanel contenant l'ensemble des éléments graphiques liés au choix du nom du joueur 3
	 */
	public JPanel getContainerNom3() {
		return containerNom3;
	}
	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au choix du nom du joueur 3
	 * @param containerNom3
	 */

	public void setContainerNom3(JPanel containerNom3) {
		this.containerNom3 = containerNom3;
	}
	/**
	 * Permet de récupérer la zone de texte (modifiable par l'utilisateur) correspondant au choix du nom du joueur 3
	 * @return JTextField permettant d'écrire le nom du joueur 3 
	 */

	public JTextField getNomJoueur3() {
		return nomJoueur3;
	}
	/**
	 * Permet de définir la zone de texte (modifiable par l'utilisateur) correspondant au choix du nom du joueur 3
	 * @param nomJoueur3
	 */

	public void setNomJoueur3(JTextField nomJoueur3) {
		this.nomJoueur3 = nomJoueur3;
	}

	/**
	 * Permet de récupérer le bouton de confirmation du choix du nom du joueur 3. <br> 
	 * Si l'utilisateur appuie sur ce bouton sans avoir inscrit de nom, le joueur 3 aura automatiquement pour nom "Joueur 3".
	 * @return JButton lié à la confirmation du choix du nom du joueur 3.
	 */
	public JButton getOkNom3() {
		return okNom3;
	}

	/**
	 * Permet de définir le bouton de confirmation du choix du nom du joueur 3.
	 * @param okNom3
	 */
	public void setOkNom3(JButton okNom3) {
		this.okNom3 = okNom3;
	}

	/**
	 * Permet de récupérer la zone de texte lié au choix du nom du joueur 3.
	 * @return JLabel lié au choix du nom du joueur 3
	 */
	public JLabel getNomDuJoueur3() {
		return nomDuJoueur3;
	}
	/**
	 * Permet de définir la zone de texte lié au choix du nom du joueur 3.
	 * @param nomDuJoueur3
	 */

	public void setNomDuJoueur3(JLabel nomDuJoueur3) {
		this.nomDuJoueur3 = nomDuJoueur3;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au joueur 1 (son type et son nom).
	 * @return JPanel lié au joueur 1
	 */
	public JPanel getJoueur1() {
		return joueur1;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au joueur 1 (son type et son nom).
	 * @param joueur1
	 */
	public void setJoueur1(JPanel joueur1) {
		this.joueur1 = joueur1;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au joueur 2 (son type et son nom).
	 * @return JPanel lié au joueur 2
	 */
	public JPanel getJoueur2() {
		return joueur2;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au joueur 2 (son type et son nom).
	 * @param joueur2
	 */
	public void setJoueur2(JPanel joueur2) {
		this.joueur2 = joueur2;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au joueur 3 (son type et son nom).
	 * @return JPanel lié au joueur 3
	 */
	public JPanel getJoueur3() {
		return joueur3;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au joueur 3 (son type et son nom).
	 * @param joueur3
	 */
	public void setJoueur3(JPanel joueur3) {
		this.joueur3 = joueur3;
	}

	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés à tous les joueurs.
	 * @return JPanel lié à tous les joueurs
	 */
	public JPanel getJoueurs() {
		return joueurs;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques liés à tous les joueurs.
	 * @param joueurs
	 */
	public void setJoueurs(JPanel joueurs) {
		this.joueurs = joueurs;
	}


	/**
	 * JRadioButton pour la séléction de 3 joueurs dans la partie
	 */
	private JRadioButton troisJoueurs;
	/**
	 * Zone de texte liée au choix du nombre de joueurs
	 */
	private JLabel nbreJoueurs;
	
	/**
	 * Ensemble d'éléments graphiques liés au choix du type du joueur 1 
	 */
	private JPanel containerType1;
	/**
	 * Zone de texte lié au choix du type du joueur 3
	 */
	private JLabel typeDuJoueur1;
	/**
	 * Bouton de confirmation du choix du type du joueur 1 
	 */
	private JButton okType1;
	/**
	 * Ensemble des boutons pour la séléction du type du joueur 1 
	 */
	private ButtonGroup choixType1; 
	/**
	 * JRadioButton pour la séléction d'un joueur 1 de type virtuel
	 */
	private JRadioButton virtuel1;
	/**
	 * JRadioButton pour la séléction d'un joueur 1 de type réel
	 */
	private JRadioButton reel1;
	/**
	 * Ensemble d'éléments graphiques liés au choix du type du joueur 2 
	 */
	private JPanel containerType2;
	/**
	 * Zone de texte lié au choix du type du joueur 3
	 */
	private JLabel typeDuJoueur2;
	/**
	 * Bouton de confirmation du choix du type du joueur 2 
	 */
	private JButton okType2;
	/**
	 * Ensemble des boutons pour la séléction du type du joueur 2 
	 */
	private ButtonGroup choixType2; 
	/**
	 * JRadioButton pour la séléction d'un joueur 2 de type virtuel
	 */
	private JRadioButton virtuel2;
	/**
	 * JRadioButton pour la séléction d'un joueur 2 de type réel
	 */
	private JRadioButton reel2;
	/**
	 * Ensemble d'éléments graphiques liés au choix du type du joueur 3
	 */
	private JPanel containerType3;
	/**
	 * Zone de texte lié au choix du type du joueur 3
	 */
	private JLabel typeDuJoueur3;
	/**
	 * Bouton de confirmation du choix du type du joueur 3 
	 */
	private JButton okType3;
	/**
	 * Ensemble des boutons pour la séléction du type du joueur 3 
	 */
	private ButtonGroup choixType3; 
	/**
	 * JRadioButton pour la séléction d'un joueur 3 de type virtuel
	 */
	private JRadioButton virtuel3;
	/**
	 * JRadioButton pour la séléction d'un joueur 3 de type réel
	 */
	private JRadioButton reel3;
	
	/**
	 * Ensemble des éléments graphiques liés au choix du nom du joueur 1
	 */
	private JPanel containerNom1;
	/**
	 * Zone de texte modifiable par l'utilisateur pour le choix du nom du joueur 1
	 */
	private JTextField nomJoueur1;
	/**
	 * Bouton utilisé pour la confirmation du choix du nom du joueur 1
	 */
	private JButton okNom1;
	/**
	 * Zone de texte pour informer l'utilisateur du choix du nom du joueur 1
	 */
	private JLabel nomDuJoueur1;
	/**
	 * Ensemble des éléments graphiques liés au choix du nom du joueur 2
	 */
	private JPanel containerNom2;
	/**
	 * Zone de texte modifiable par l'utilisateur pour le choix du nom du joueur 2
	 */
	private JTextField nomJoueur2;
	/**
	 * Bouton utilisé pour la confirmation du choix du nom du joueur 2
	 */
	private JButton okNom2;
	/**
	 * Zone de texte pour informer l'utilisateur du choix du nom du joueur 2
	 */
	private JLabel nomDuJoueur2;
	/**
	 * Ensemble des éléments graphiques liés au choix du nom du joueur 3
	 */
	private JPanel containerNom3;
	/**
	 * Zone de texte modifiable par l'utilisateur pour le choix du nom du joueur 3
	 */
	private JTextField nomJoueur3;
	/**
	 * Bouton utilisé pour la confirmation du choix du nom du joueur 3
	 */
	private JButton okNom3;
	/**
	 * Zone de texte pour informer l'utilisateur du choix du nom du joueur 3
	 */
	private JLabel nomDuJoueur3;
	
	/**
	 * Ensemble des éléments graphiques utilisés pour le choix des paramètres du joueur 1
	 */
	private JPanel joueur1;
	/**
	 * Ensemble des éléments graphiques utilisés pour le choix des paramètres du joueur 2
	 */
	private JPanel joueur2;
	/**
	 * Ensemble des éléments graphiques utilisés pour le choix des paramètres du joueur 3
	 */
	private JPanel joueur3;
	/**
	 * Ensemble des éléments graphiques utilisés pour le choix des paramètres de tous les joueurs
	 */
	private JPanel joueurs;
	
	/**
	 * Ensemble des éléments graphiques utilisés pour le choix des règles du jeu
	 */
	private JPanel containerMode;
	/**
	 * Ensemble des boutons pour la séléction des règles du jeu
	 */
	private ButtonGroup choixMode;
	/**
	 * Bouton pour la confirmation du choix des règles du jeu
	 */
	private JButton okMode;
	/**
	 * JRadioButton pour le choix des règles avancées 
	 */
	private JRadioButton avance;
	/**
	 * JRadioButton pour le choix des règles "victoire ennemie"
	 */
	private JRadioButton victoireEnnemie;
	/**
	 * JRadioButton pour le choix des règles de base 
	 */
	private JRadioButton deBase;
	/**
	 * Zone de texte liée au choix des règles du jeu
	 */
	private JLabel modeDeJeu;
	
	/**
	 * Ensemble des éléments graphiques liés au choix de la forme des tapis de jeu
	 */
	private JPanel containerForme;
	/**
	 * Ensemble des boutons de séléction de la forme de tapis de jeu
	 */
	private ButtonGroup choixForme;
	/**
	 * Bouton pour la confirmation du choix de la forme du tapis de jeu
	 */
	private JButton okForme;
	/**
	 * JRadioButton pour la séléction d'un tapis rectangle
	 */
	private JRadioButton rectangle;
	/**
	 * JRadioButton pour la séléction d'un tapis triangle rectangle
	 */
	private JRadioButton triangle;
	/**
	 * JRadioButton pour la séléction d'un tapis circulaire
	 */
	private JRadioButton cercle;
	/**
	 * Zone de texte liée au choix de la forme du tapis de jeu
	 */
	private JLabel formeTapis;
	
	/**
	 * Constructeur de la vue graphique de ShapeUp
	 * @param sU - Objet ShapeUp dont on souhaite avoir la vue graphique
	 */
	public VueShapeUp (ShapeUp sU) {
		
		
		initialize();
		
		this.jeuShapeUp = sU;
		jeuShapeUp.addObserver(this);
		//jeuShapeUp.addObserver(this);
		Console console = new Console(jeuShapeUp);
		this.console = console;
		new ControleurShapeUp (jeuShapeUp, this, console);
		
	}
	
	/**
	 * Permet d'initialiser tous les éléments graphiques pour le choix des paramètres
	 */
	public void initialize() {
		
		fenetreChoix = new JFrame("Paramètres de jeu");
		JPanel container =(JPanel) fenetreChoix.getContentPane();
		
		choix = new JLabel ("Choix de vos paramètres de jeu :) ");
		choix.setFont(new Font("Verdana", Font.BOLD, 18));
		
		
		nbreJoueurs = new JLabel ("Choix du nombre de joueurs : ");
		choixNbre = new ButtonGroup();
		deuxJoueurs = new JRadioButton("2 joueurs");
		troisJoueurs = new JRadioButton ("3 joueurs");
		okNbre = new JButton("OK");
		okNbre.setForeground(Color.white);
		okNbre.setBackground(Color.BLACK);
		
		
		containerNbre = new JPanel();
		
		nbreJoueurs.setForeground(Color.BLUE);
		containerNbre.add(nbreJoueurs);
		

		containerNbre.add(deuxJoueurs, FlowLayout.CENTER);
		containerNbre.add(troisJoueurs);
		containerNbre.add(okNbre);
		choixNbre.add(deuxJoueurs);
		choixNbre.add(troisJoueurs);
		
		
		typeDuJoueur1 = new JLabel("Veuillez choisir le type du joueur 1");
		okType1 = new JButton(); 
		
		choixType1 = new ButtonGroup();
		virtuel1 = new JRadioButton("Virtuel");
		reel1 = new JRadioButton ("Réel");
		okType1 = new JButton("OK");
		okType1.setForeground(Color.black);
		okType1.setBackground(Color.pink);
		
		
		joueur1 = new JPanel();
		containerType1 = new JPanel();

	
		typeDuJoueur1.setForeground(Color.pink);
		containerType1.add(typeDuJoueur1);
		

		containerType1.add(virtuel1, FlowLayout.CENTER);
		containerType1.add(reel1);
		containerType1.add(okType1);
		choixType1.add(virtuel1);
		choixType1.add(reel1);
		
		
		
		nomDuJoueur1 = new JLabel("Veuillez saisir le nom du joueur 1 : ");
		okNom1 = new JButton ("OK pour ce nom");
		okNom1.setForeground(Color.black);
		okNom1.setBackground(Color.pink);
		nomJoueur1 = new JTextField();
		nomJoueur1.setColumns(10);
	
		containerNom1 = new JPanel();
		
		nomDuJoueur1.setForeground(Color.BLUE);
		containerNom1.add(nomDuJoueur1);
		containerNom1.add(nomJoueur1, FlowLayout.CENTER);
		containerNom1.add(okNom1);
		containerNom1.setVisible(false);
		
		joueur1.setLayout(new BoxLayout(joueur1, BoxLayout.Y_AXIS));
		joueur1.add(containerType1);
		joueur1.add(containerNom1);
		
		
		joueurs = new JPanel();
		
		joueurs.add(joueur1, BorderLayout.LINE_START);
		
		
		
		
		typeDuJoueur2 = new JLabel("Veuillez choisir le type du joueur 2");
		okType2 = new JButton(); 
		
		choixType2 = new ButtonGroup();
		virtuel2 = new JRadioButton("Virtuel");
		reel2 = new JRadioButton ("Réel");
		okType2 = new JButton("OK");
		okType2.setForeground(Color.black);
		okType2.setBackground(Color.orange);
		
		
		joueur2 = new JPanel();
		containerType2 = new JPanel();

	
		typeDuJoueur2.setForeground(Color.ORANGE);
		containerType2.add(typeDuJoueur2);
		

		containerType2.add(virtuel2, FlowLayout.CENTER);
		containerType2.add(reel2);
		containerType2.add(okType2);
		choixType2.add(virtuel2);
		choixType2.add(reel2);
		
		
		
		nomDuJoueur2 = new JLabel("Veuillez saisir le nom du joueur 2 : ");
		okNom2 = new JButton ("OK pour ce nom");
		okNom2.setForeground(Color.black);
		okNom2.setBackground(Color.orange);
		nomJoueur2 = new JTextField();
		nomJoueur2.setColumns(10);
	
		containerNom2 = new JPanel();
		
		nomDuJoueur2.setForeground(Color.BLUE);
		containerNom2.add(nomDuJoueur2);
		containerNom2.add(nomJoueur2, FlowLayout.CENTER);
		containerNom2.add(okNom2);
		containerNom2.setVisible(false);
		
		joueur2.setLayout(new BoxLayout(joueur2, BoxLayout.Y_AXIS));
		joueur2.add(containerType2);
		joueur2.add(containerNom2);
		

		
		joueurs.add(joueur2, BorderLayout.CENTER);
		
		
		typeDuJoueur3 = new JLabel("Veuillez choisir le type du joueur 3");
		okType3 = new JButton(); 
		
		choixType3 = new ButtonGroup();
		virtuel3 = new JRadioButton("Virtuel");
		reel3 = new JRadioButton ("Réel");
		okType3 = new JButton("OK");
		okType3.setForeground(Color.black);
		okType3.setBackground(Color.blue);
		
		
		joueur3 = new JPanel();
		containerType3 = new JPanel();

	
		typeDuJoueur3.setForeground(Color.BLUE);
		containerType3.add(typeDuJoueur3);
		

		containerType3.add(virtuel3, FlowLayout.CENTER);
		containerType3.add(reel3);
		containerType3.add(okType3);
		choixType3.add(virtuel3);
		choixType3.add(reel3);
		
		
		
		nomDuJoueur3 = new JLabel("Veuillez saisir le nom du joueur 3 : ");
		okNom3 = new JButton ("OK pour ce nom");
		okNom3.setForeground(Color.black);
		okNom3.setBackground(Color.blue);
		nomJoueur3 = new JTextField();
		nomJoueur3.setColumns(10);
	
		containerNom3 = new JPanel();
		
		nomDuJoueur3.setForeground(Color.BLUE);
		containerNom3.add(nomDuJoueur3);
		containerNom3.add(nomJoueur3, FlowLayout.CENTER);
		containerNom3.add(okNom3);
		containerNom3.setVisible(false);
		
		joueur3.setLayout(new BoxLayout(joueur3, BoxLayout.Y_AXIS));
		joueur3.add(containerType3);
		joueur3.add(containerNom3);
		

		
		joueurs.add(joueur3, BorderLayout.LINE_END);
		
		
		
		
		
		modeDeJeu = new JLabel("Choix du mode de jeu : ");
		choixMode = new ButtonGroup();
		avance = new JRadioButton("Avancé");
		victoireEnnemie = new JRadioButton("Victoire ennemie");
		deBase = new JRadioButton("Règles de base");
		okMode = new JButton("OK");
		okMode.setForeground(Color.white);
		okMode.setBackground(Color.black);
		
		containerMode = new JPanel();
		
		modeDeJeu.setForeground(Color.BLUE);
		containerMode.add(modeDeJeu);
		containerMode.add(deBase, FlowLayout.CENTER);
		containerMode.add(avance);
		containerMode.add(victoireEnnemie);
		containerMode.add(okMode);
		

		
		choixMode.add(deBase);
		choixMode.add(victoireEnnemie);
		choixMode.add(avance);
		
		containerForme = new JPanel();
		
		formeTapis = new JLabel("Choix de la forme du tapis : ");
		choixForme = new ButtonGroup();
		rectangle = new JRadioButton("Rectangle");
		triangle = new JRadioButton("Triangle rectangle");
		cercle = new JRadioButton("Disque");
		okForme = new JButton("OK");
		okForme.setForeground(Color.white);
		okForme.setBackground(Color.BLACK);
		
		formeTapis.setForeground(Color.BLUE);
		containerForme.add(formeTapis);
		containerForme.add(rectangle, FlowLayout.CENTER);
		containerForme.add(triangle);
		containerForme.add(cercle);
		containerForme.add(okForme);
		choixForme.add(rectangle);
		choixForme.add(triangle);
		choixForme.add(cercle);
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		
		okAll = new JButton("J'ai fini de choisir mes paramètres, je veux lancer la partie.");
		
		container.add(containerNbre);
		container.add(joueurs);

		container.add(containerMode);
		container.add(containerForme);
		container.add(okAll);
		okAll.setVisible(false);
		joueurs.setVisible(false);
		fenetreChoix.setVisible(true);
		
		fenetreChoix.pack();
		
	}


	@Override
	/**
	 * Permet à la vue graphique de ShapeUp de se mettre à jour en fonction des changements effectués
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		if (this.jeuShapeUp.getNbDeJoueurs() == 2) {
			deuxJoueurs.setSelected(true);
			okNbre.doClick();
			
		}
		
		if (this.jeuShapeUp.getNbDeJoueurs() == 3) {
			troisJoueurs.setSelected(true);
			okNbre.doClick();
		}
		
		//choix des options joueurs
		
		if(this.jeuShapeUp.getTypes().size()==1) {
			String ty1 = this.jeuShapeUp.getTypes().get(0);
			if (ty1.equals("v")) {
				virtuel1.setSelected(true);		
						
			} else if (ty1.equals("r")) {
				reel1.setSelected(true);		
			}
			okType1.doClick();
		}
		if(this.jeuShapeUp.getNomsJoueurs().size() == 1) {
			okNom1.doClick();
			
			
		}
		
		if(this.jeuShapeUp.getTypes().size()==2) {
			String ty2 = this.jeuShapeUp.getTypes().get(1);
			
			if (ty2.equals("v")) {
				virtuel2.setSelected(true);		
						
			} else if (ty2.equals("r")) {
				reel2.setSelected(true);		
			}
			okType2.doClick();
		}
		if(this.jeuShapeUp.getNomsJoueurs().size() == 2) {
			okNom2.doClick();
			
			
		}
		
		if(this.jeuShapeUp.getTypes().size()==3) {
			String ty3 = this.jeuShapeUp.getTypes().get(2);
			if (ty3.equals("v")) {
				virtuel3.setSelected(true);		
						
			} else if (ty3.equals("r")) {
				reel3.setSelected(true);		
			}
			okType3.doClick();
		}
		if(this.jeuShapeUp.getNomsJoueurs().size() == 3) {
			okNom3.doClick();
			
		}
		
		
		//choix du mode de jeu
		if(this.jeuShapeUp.getMode() instanceof StrategieDeBase) {
			deBase.setSelected(true);
			okMode.doClick();
			
		} else if (this.jeuShapeUp.getMode() instanceof StrategieAvance) {
			avance.setSelected(true);
			okMode.doClick();
		} else if (this.jeuShapeUp.getMode() instanceof StrategieVictoireEnnemie) {
			victoireEnnemie.setSelected(true);
			okMode.doClick();
		}
		
		if (this.jeuShapeUp.getFormeTapis() instanceof TapisRectangle) {
			rectangle.setSelected(true);
			okForme.doClick();
			
		} else if (this.jeuShapeUp.getFormeTapis() instanceof TapisTriangleRectangle) {
			triangle.setSelected(true);
			okForme.doClick();
			
		} else if (this.jeuShapeUp.getFormeTapis() instanceof TapisCercle) {
			cercle.setSelected(true);
			okForme.doClick();
			
		} 
		
		Partie partie = this.jeuShapeUp.getMaPartie();
		if(partie != null) {
			this.getOkAll().setEnabled(false);
			
			if(this.getMaPartie()==null) {
			  this.setMaPartie(new VuePartie(partie));
			}
		}
		
		
	}
	
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    	ShapeUp jeuShapeUp = new ShapeUp();
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueShapeUp test = new VueShapeUp(jeuShapeUp);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	
    	

		
		
    }


}

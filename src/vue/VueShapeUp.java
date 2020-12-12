package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.ShapeUp;

public class VueShapeUp implements Observer {
	
	private ShapeUp jeuShapeUp;
	
	private JFrame fenetreChoix;
	private JLabel choix;
	
	private JFrame containerNbre;
	private ButtonGroup choixNbre;
	private JRadioButton deuxJoueurs;
	private JRadioButton troisJoueurs;
	private JLabel nbreJoueurs;
	
	private JTextField nomJoueur;
	private JLabel nomDesJoueurs;
	
	private JFrame containerMode;
	private ButtonGroup choixMode;
	private JRadioButton avance;
	private JRadioButton victoireEnnemie;
	private JRadioButton deBase;
	private JLabel modeDeJeu;
	
	private JFrame containerForme;
	private ButtonGroup choixForme;
	private JRadioButton rectangle;
	private JRadioButton triangle;
	private JRadioButton cercle;
	private JLabel formeTapis;
	
	public VueShapeUp () {
		
		//ShapeUp sU
		//jeuShapeUp = sU;
		//jeuShapeUp.addObserver(this);
		
		fenetreChoix = new JFrame("Paramètres de jeu");
		
		choix = new JLabel ("Choix de vos paramètres de jeu : ");
		
		nbreJoueurs = new JLabel ("Choix du nombre de joueurs");
		choixNbre = new ButtonGroup();
		deuxJoueurs = new JRadioButton("2 joueurs");
		troisJoueurs = new JRadioButton ("3 joueurs");
		
		JPanel container =(JPanel) fenetreChoix.getContentPane();
		
		JPanel containerNbre = new JPanel();
		
		nbreJoueurs.setForeground(Color.BLUE);
		containerNbre.add(nbreJoueurs);
		

		containerNbre.add(deuxJoueurs, FlowLayout.CENTER);
		containerNbre.add(troisJoueurs);
		choixNbre.add(deuxJoueurs);
		choixNbre.add(troisJoueurs);
		
		
		
		modeDeJeu = new JLabel("Choix du mode de jeu");
		choixMode = new ButtonGroup();
		avance = new JRadioButton("Avancé");
		victoireEnnemie = new JRadioButton("Victoire ennemie");
		deBase = new JRadioButton("Règles de base");
		
		JPanel containerMode = new JPanel();
		
		modeDeJeu.setForeground(Color.BLUE);
		containerMode.add(modeDeJeu);
		containerMode.add(deBase, FlowLayout.CENTER);
		containerMode.add(avance);
		containerMode.add(victoireEnnemie);
		
		
		
		choixMode.add(deBase);
		choixMode.add(victoireEnnemie);
		choixMode.add(avance);
		
		
		JPanel containerForme = new JPanel();
		
		formeTapis = new JLabel("Choix de la forme du tapis");
		choixForme = new ButtonGroup();
		rectangle = new JRadioButton("Rectangle");
		triangle = new JRadioButton("Triangle rectangle");
		cercle = new JRadioButton("Disque");
		
		formeTapis.setForeground(Color.BLUE);
		containerForme.add(formeTapis);
		containerForme.add(rectangle, FlowLayout.CENTER);
		containerForme.add(triangle);
		containerForme.add(cercle);
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		container.add(containerNbre);
		container.add(containerMode);
		container.add(containerForme);
		fenetreChoix.pack();
		fenetreChoix.setVisible(true);
		//fenetreChoix.getContentPane()
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VueShapeUp test = new VueShapeUp();
		
	}



}

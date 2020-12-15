package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

import shapeUp.JoueurReel;
import shapeUp.JoueurVirtuel;
import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.ShapeUp;
import shapeUp.StrategieAvance;
import shapeUp.StrategieDeBase;
import shapeUp.StrategieMode;
import shapeUp.StrategieVictoireEnnemie;
import shapeUp.TapisCercle;
import shapeUp.TapisDeJeu;
import shapeUp.TapisRectangle;
import shapeUp.TapisTriangleRectangle;

public class VueShapeUp implements Observer {
	
	private ShapeUp jeuShapeUp;
	
	private JFrame fenetreChoix;
	private JLabel choix;
	
	private JPanel containerNbre;
	private ButtonGroup choixNbre;
	private JButton okNbre;
	private JRadioButton deuxJoueurs;
	private JRadioButton troisJoueurs;
	private JLabel nbreJoueurs;
	
	private JPanel containerType;
	private JLabel typeDesJoueurs;
	private JButton okType;
	private ButtonGroup choixType; 
	private JRadioButton virtuel;
	private JRadioButton reel;
	
	private JPanel containerNom;
	private JTextField nomJoueur;
	private JButton okNom;
	private JLabel nomDesJoueurs;
	
	private JPanel containerMode;
	private ButtonGroup choixMode;
	private JButton okMode;
	private JRadioButton avance;
	private JRadioButton victoireEnnemie;
	private JRadioButton deBase;
	private JLabel modeDeJeu;
	
	private JPanel containerForme;
	private ButtonGroup choixForme;
	private JButton okForme;
	private JRadioButton rectangle;
	private JRadioButton triangle;
	private JRadioButton cercle;
	private JLabel formeTapis;
	
	public VueShapeUp (ShapeUp sU) {
		
		
		jeuShapeUp = sU;
		jeuShapeUp.addObserver(this);
		
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
		
		okNbre.addActionListener(new ActionListener() {
			
	int nbre =0;		
	
			public void actionPerformed(ActionEvent e) {
				if (deuxJoueurs.isSelected() || troisJoueurs.isSelected()) {
					
				if (deuxJoueurs.isSelected()) {
					nbreJoueurs.setText("Vous avez choisi 2 joueurs");
					nbre = 2;
					
				}
				else if (troisJoueurs.isSelected()) {
					nbreJoueurs.setText("Vous avez choisi 3 joueurs");
					nbre = 3;
				}
				nbreJoueurs.setForeground(Color.PINK);
				okNbre.setEnabled(false);
				troisJoueurs.setEnabled(false);
				deuxJoueurs.setEnabled(false);
				containerType.setVisible(true);
				}
				else 
				{
					nbreJoueurs.setText("Il faut choisir un nombre de joueurs avant de confirmer.");
				}
				
				fenetreChoix.pack();
			}
		});
		
		
		typeDesJoueurs = new JLabel("Veuillez choisir le type du joueur");
		okType = new JButton(); 
		//nbreJoueurs = new JLabel ("Choix du nombre de joueurs : ");
		choixType = new ButtonGroup();
		virtuel = new JRadioButton("Virtuel");
		reel = new JRadioButton ("Réel");
		okType = new JButton("OK");
		okType.setForeground(Color.white);
		okType.setBackground(Color.BLACK);
		
		containerType = new JPanel();

	
		typeDesJoueurs.setForeground(Color.BLUE);
		containerType.add(typeDesJoueurs);
		

		containerType.add(virtuel, FlowLayout.CENTER);
		containerType.add(reel);
		containerType.add(okType);
		choixType.add(virtuel);
		choixType.add(reel);
		
		
		
		nomDesJoueurs = new JLabel("Veuillez saisir le nom du joueur : ");
		okNom = new JButton ("OK pour ce nom");
		nomJoueur = new JTextField();
		nomJoueur.setColumns(10);
	
		containerNom = new JPanel();
		
		nomDesJoueurs.setForeground(Color.BLUE);
		containerNom.add(nomDesJoueurs);
		containerNom.add(nomJoueur, FlowLayout.CENTER);
		containerNom.add(okNom);
		containerNom.setVisible(false);
		//faire pour le nom des joueurs (sûrment lundi)
		
		okType.addActionListener(new ActionListener() {
			String nom=" ";
				
					public void actionPerformed(ActionEvent e) {
					
						if (virtuel.isSelected() || reel.isSelected()) {
							containerNom.setVisible(true);
							
							
							
									okNom.addActionListener(new ActionListener() {
									
		
									public void actionPerformed(ActionEvent e) {
									nom = nomJoueur.getText();
									nomDesJoueurs.setText("Vous avez choisi le nom du joueur : "+nom);
									nomJoueur.setText("");
									fenetreChoix.pack();
									}		
									});
							
							
						
									if (virtuel.isSelected()) {
										
										JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom, jeuShapeUp.getConsoleDuJeu());
										nomDesJoueurs.setText("Veuillez saisir le nom du joueur suivant : ");
									}
									
									else if (reel.isSelected()) {
										JoueurReel nouveauJoueurR = new JoueurReel(nom, jeuShapeUp.getConsoleDuJeu());
										nomDesJoueurs.setText("Veuillez saisir le nom du joueur suivant : ");
									}
						
						okType.setEnabled(false);
						reel.setEnabled(false);
						virtuel.setEnabled(false);
						
						
						}
						else 
						{
							typeDesJoueurs.setText("Il faut choisir un type de joueur avant de confirmer.");
						}
						

						
						fenetreChoix.pack();
					}
				});

		
		modeDeJeu = new JLabel("Choix du mode de jeu : ");
		choixMode = new ButtonGroup();
		avance = new JRadioButton("Avancé");
		victoireEnnemie = new JRadioButton("Victoire ennemie");
		deBase = new JRadioButton("Règles de base");
		okMode = new JButton("OK");
		okMode.setForeground(Color.white);
		okMode.setBackground(Color.BLACK);
		
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
		
		okMode.addActionListener(new ActionListener() {
		
			StrategieMode mode;
			
		public void actionPerformed(ActionEvent e) {
			
			
			if (deBase.isSelected() || victoireEnnemie.isSelected() || avance.isSelected()) {
				
			if (deBase.isSelected()) {
mode = new StrategieDeBase(jeuShapeUp.getConsoleDuJeu());
				
			}
			else if (victoireEnnemie.isSelected()) {
mode = new StrategieVictoireEnnemie(jeuShapeUp.getConsoleDuJeu());
				
			}
			else if (avance.isSelected()) {
mode = new StrategieAvance(jeuShapeUp.getConsoleDuJeu());
				
			}
			
			modeDeJeu.setText("Vous avez choisi les règles : "+mode );
			modeDeJeu.setForeground(Color.PINK);
			okMode.setEnabled(false);
			deBase.setEnabled(false);
			victoireEnnemie.setEnabled(false);
			avance.setEnabled(false);
			} 
			else {
				modeDeJeu.setText("Il faut choisir un mode de jeu avant de confirmer.");
			}
			
			fenetreChoix.pack();
		}
	});
		
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
		
		
		okForme.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				TapisDeJeu forme = null;				
			if (rectangle.isSelected() || triangle.isSelected() || cercle.isSelected()) {	
				
				if (rectangle.isSelected()) {
					forme = new TapisRectangle();
					formeTapis.setText("Vous avez choisi un tapis rectangulaire");
					
				}
				else if (triangle.isSelected()) {
					forme = new TapisTriangleRectangle();
					formeTapis.setText("Vous avez choisi un tapis triangle rectangle");
				}
				else if (cercle.isSelected()) {
					forme = new TapisCercle();
					formeTapis.setText("Vous avez choisi un tapis circulaire");
					
				}
				
				
				formeTapis.setForeground(Color.PINK);
				okForme.setEnabled(false);
				rectangle.setEnabled(false);
				triangle.setEnabled(false);
				cercle.setEnabled(false);
				
			}  else {
				formeTapis.setText("Attention, veuillez choisir une forme de tapis avant de confirmer.");

			}
			fenetreChoix.pack();
			}
			
		});
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		container.add(choix);
		
		container.add(containerNbre);
		container.add(containerType);
		container.add(containerNom);
		container.add(containerMode);
		container.add(containerForme);
		fenetreChoix.pack();
		containerType.setVisible(false);
		fenetreChoix.setVisible(true);
		//fenetreChoix.getContentPane()
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		VueShapeUp test = new VueShapeUp();
//		
//	}



}

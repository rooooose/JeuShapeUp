package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.utt.lo02.shapeUp.controleurs.ControleurPartie;
import fr.utt.lo02.shapeUp.modele.Carte;
import fr.utt.lo02.shapeUp.modele.Joueur;
import fr.utt.lo02.shapeUp.modele.JoueurReel;
import fr.utt.lo02.shapeUp.modele.Observable;
import fr.utt.lo02.shapeUp.modele.Observer;
import fr.utt.lo02.shapeUp.modele.Partie;
import fr.utt.lo02.shapeUp.modele.StrategieAvance;
import fr.utt.lo02.shapeUp.modele.StrategieDeBase;
import fr.utt.lo02.shapeUp.modele.StrategieVictoireEnnemie;
import fr.utt.lo02.shapeUp.modele.TapisCercle;
import fr.utt.lo02.shapeUp.modele.TapisDeJeu;
import fr.utt.lo02.shapeUp.modele.TapisRectangle;
import fr.utt.lo02.shapeUp.modele.TapisTriangleRectangle;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
/**
 * Cette classe permet de jouer au jeu de ShapeUp via une interface graphique. <br>
 * C'est une vue graphique de la partie et des différents tour de jeu.
 * 
 * @see Partie
 * @author Shir F, Mathéa Z
 *
 */
public class VuePartie implements Observer{

	/**
	 * Partie dont cette classe est la vue graphique
	 */
	private Partie partie;
	
	/**
	 * Fenêtre correspondant à l'affichage des cartes du joueur et du déroulé du jeu
	 */
	private JFrame frame;
	/**
	 * Fenêtre correspondant à l'affichage du tapis de jeu
	 */
	private JFrame tapisDeJeu;

	/**
	 * Ensemble des éléments graphiques nécessaire pour l'affichage des cartes du joueur et du déroulé du jeu
	 */
	private JPanel panel;
	
	/**
	 * Bouton utilisé pour la représentation de la première carte dans la main du joueur
	 */
	private JButton carte0;
	/**
	 * Bouton utilisé pour la représentation de la deuxième carte dans la main du joueur (utilisé seulement en règles avancées)
	 * 
	 * @see StrategieAvance
	 */
	private JButton carte1;
	/**
	 * Bouton utilisé pour la représentation de la troisième carte dans la main du joueur (utilisé seulement en règles avancées)
	 * 
	 * @see StrategieAvance
	 */
	private JButton carte2;
	
	/**
	 * Bouton utilisé pour la représentation de la carte de victoire du joueur ou, en règles "victoire ennemie", la première carte de victoire ennemie
	 * 
	 * @see StrategieMode
	 */
	private JButton carteDeVict;
	/**
	 * Bouton utilisé en règles "victoire ennemie" pour la représentation de la seconde carte de victoire ennemie (lorsqu'il y a 3 joueurs)
	 * 
	 * @see StrategieVictoireEnnemie
	 */
	private JButton carteDeVict2;
	
	/**
	 * Zone de texte pour connaître le déroulé du jeu
	 */
	private JLabel tourDeJeu;
	/**
	 * Zone de texte lié à la carte de victoire du joueur (ou la première carte de victoire ennemie)
	 */
	private JLabel carteVict;
	/**
	 * Zone de texte lié à la seconde carte de victoire ennemie (lorsqu'il y a 3 joueurs en règles "victoire ennemie")
	 */
	private JLabel carteVict2;
	/**
	 * Zone de texte pour l'affichage du nom du joueur actif
	 */
	private JLabel tourDe;
	/**
	 * Collection contenant les joueurs
	 */
	private Queue<Joueur> joueurs = new LinkedList<Joueur>();
	/**
	 * Tapis de jeu de la partie
	 */
	private TapisDeJeu tapis;
	
	/**
	 * Permet de récupérer la vue du tapis de jeu de la partie
	 * @return JFrame correspondant à la vue du tapis de jeu
	 */
	public JFrame getTapisDeJeu() {
		return tapisDeJeu;
	}
	
	/**
	 * Permet de récupérer la partie observée par la vue
	 * @return Partie observée par la vue
	 */
	public Partie getPartie() {
		return partie;
	}

	/**
	 * Permet de définir la partie observée par la vue
	 * @param partie
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	/**
	 * Permet de récupérer la fenêtre pour la gestion du déroulé du jeu
	 * @return JFrame correspondant à la gestion du déroulé du jeu
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Permet de définir la fenêtre pour la gestion du déroulé du jeu
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Permet dé récupérer le bouton utilisé pour la représentation de la carte de victoire du joueur actif ou, en règles "victoire ennemie", la première carte de victoire ennemie
	 * @return JButton correspondant à la carte de victoire 
	 */
	public JButton getCarteDeVict() {
		return carteDeVict;
	}

	/**
	 * Permet dé définir le bouton utilisé pour la représentation de la carte de victoire du joueur actif ou, en règles "victoire ennemie", la première carte de victoire ennemie
	 * @param carteDeVict
	 */
	public void setCarteDeVict(JButton carteDeVict) {
		this.carteDeVict = carteDeVict;
	}
	
	/**
	 * Permet de récupérer la zone de texte correspondant aux informations sur la carte de victoire
	 * @return Zone de texte pour l'affichage des informations sur la carte de victoire
	 */
	public JLabel getCarteVict() {
		return carteVict;
	}

	/**
	 * Permet de définir la zone de texte correspondant aux informations sur la carte de victoire
	 * @param carteVict
	 */
	public void setCarteVict(JLabel carteVict) {
		this.carteVict = carteVict;
	}
	
	/**
	 * Permet de récupérer l'ensemble des éléments graphiques liés au déroulé de la partie
	 * @return JPanel correspondant à l'ensemble des éléments graphiques liés au déroulé de la partie
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Permet de définir l'ensemble des éléments graphiques liés au déroulé de la partie
	 * @param panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Permet de récupérer le bouton représentant la première carte dans la main du joueur 
	 * @return JButton utilisé pour la représentation de la première carte dans la main du joueur
	 */
	public JButton getCarte0() {
		return carte0;
	}

	/**
	 * Permet de définir le bouton représentant la première carte dans la main du joueur
	 * @param carte0
	 */
	public void setCarte0(JButton carte0) {
		this.carte0 = carte0;
	}

	/**
	 * Permet de récupérer le bouton représentant la deuxième carte dans la main du joueur (utilisé seulement en règles avancées)
	 * @return JButton utilisé pour la représentation de la deuxième carte dans la main du joueur
	 */
	public JButton getCarte1() {
		return carte1;
	}
	/**
	 * Permet de définir le bouton représentant la deuxième carte dans la main du joueur (utilisé seulement en règles avancées)
	 * @param carte1
	 */
	public void setCarte1(JButton carte1) {
		this.carte1 = carte1;
	}
	/**
	 * Permet de récupérer le bouton représentant la troisème carte dans la main du joueur (utilisé seulement en règles avancées)
	 * @return JButton utilisé pour la représentation de la troisème carte dans la main du joueur
	 */
	public JButton getCarte2() {
		return carte2;
	}
	/**
	 * Permet de définir le bouton représentant la troisième carte dans la main du joueur (utilisé seulement en règles avancées)
	 * @param carte2
	 */
	public void setCarte2(JButton carte2) {
		this.carte2 = carte2;
	}

	/**
	 * Permet de récupérer la zone de texte pour l'affichage du déroulé du jeu
	 * @return JLabel pour l'affichage du déroulé du jeu
	 */
	public JLabel getTourDeJeu() {
		return tourDeJeu;
	}
	/**
	 * Permet de définir la zone de texte pour l'affichage du déroulé du jeu
	 * @param tourDeJeu
	 */
	public void setTourDeJeu(JLabel tourDeJeu) {
		this.tourDeJeu = tourDeJeu;
	}

/**
 * Constructeur de la vue graphique de la partie de jeu
 * @param p - Partie dont on souhaite avoir la vue graphique
 */
	public VuePartie(Partie p) {
		
		this.partie = p;
		this.partie.addObserver(this);
		this.joueurs = this.partie.getQueueJoueurs();
		Iterator<Joueur> it = this.joueurs.iterator();
		while(it.hasNext()) {
			it.next().addObserver(this);
		}
		this.tapis = this.partie.getTapisDeJeu();
		this.tapis.addObserver(this);
		initialize();
		new ControleurPartie (this.partie, this);
	}

	/**
	 * Permet d'initialiser la fenêtre lié au déroulé de la partie
	 */
	private void initialize() {
		
		frame = new JFrame("C'est parti pour jouer ! :) ");
		
		frame.setBounds(100, 100, 850, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		carte0 = new JButton();
		carte0.setBackground(new Color(0, 0, 0));
		String name = "/fr/utt/lo02/shapeUp/vue/imagesPourCartes/caseVide.png";
		carte0.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
		carte0.setBounds(12, 13, 146, 179);
		panel.add(carte0);
		
		carte1 = new JButton();
		carte1.setBackground(new Color(0, 0, 0));
		carte1.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
		carte1.setBounds(169, 13, 144, 179);
		panel.add(carte1);
		
		carte2 = new JButton();
		carte2.setBackground(new Color(0, 0, 0));
		carte2.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
		carte2.setBounds(325, 13, 137, 179);
		panel.add(carte2);
		
		tourDeJeu = new JLabel("Jouons");
		tourDeJeu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tourDeJeu.setBounds(12, 259, 450, 163);
		panel.add(tourDeJeu);
		
		carteDeVict = new JButton();
		carteDeVict.setBackground(new Color(128, 0, 128));
		carteDeVict.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
		carteDeVict.setBounds(663, 13, 146, 179);
		panel.add(carteDeVict);
		
		carteVict = new JLabel("");
		carteVict.setBackground(new Color(0, 0, 0));
		carteVict.setForeground(new Color(128, 0, 128));
		carteVict.setFont(new Font("Tahoma", Font.PLAIN, 10));
		carteVict.setBounds(518, 205, 291, 16);
		panel.add(carteVict);
		
		carteDeVict2 = new JButton();
		carteDeVict2.setBackground(new Color(0, 0, 128));
		carteDeVict2.setBounds(663, 227, 146, 179);
		panel.add(carteDeVict2);
		
		carteVict2 = new JLabel();
		carteVict2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		carteVict2.setForeground(new Color(0, 0, 128));
		carteVict2.setBounds(518, 406, 291, 16);
		panel.add(carteVict2);
		
		tourDe = new JLabel();
		tourDe.setFont(new Font("Agency FB", Font.BOLD, 26));
		tourDe.setForeground(new Color(32, 178, 170));
		tourDe.setBackground(Color.BLACK);
		tourDe.setBounds(12, 220, 494, 41);
		panel.add(tourDe);
		carteDeVict2.setVisible(false);
		
		
		if (this.partie.getTapisDeJeu() instanceof TapisRectangle) {
			tapisDeJeu = new VueTapisRectangle();
			
		} else if (this.partie.getTapisDeJeu() instanceof TapisTriangleRectangle) {
			tapisDeJeu = new VueTriangle();
		} else if (this.partie.getTapisDeJeu() instanceof TapisCercle) {
			tapisDeJeu = new VueCirculaire();
		}
		
		tapisDeJeu.setVisible(true);
		
		carteDeVict.setVisible(false);
		if (this.partie.getModeDeJeu() instanceof StrategieDeBase || this.partie.getModeDeJeu() instanceof StrategieVictoireEnnemie ) {
			carte1.setVisible(false);
			carte2.setVisible(false);
			carteDeVict.setVisible(true);
		}
		frame.setVisible(true);
		
	}
	
	@Override
	/**
	 * Permet à la vue graphique de se mettre à jour en fonction du déroulé de la partie
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof String) {
			this.tourDeJeu.setText((String) arg);
		}
		
		String string = "/fr/utt/lo02/shapeUp/vue/imagesPourCartes/";
		String name = "/fr/utt/lo02/shapeUp/vue/imagesPourCartes/caseVide.png";
		if(o instanceof Joueur) {
			tourDe.setText("C'est au tour de "+((Joueur)o).getNom());
			if(((Joueur) o).getMainDuJoueur().size()==1) {
				
				if(((Joueur) o).getMainDuJoueur().get(0)!=null) {
					
					Carte c0 = ((Joueur) o).getMainDuJoueur().get(0);
					carte0.setIcon(new ImageIcon(VuePartie.class.getResource(string+c0.getForme()+c0.getCouleur()+c0.EstRemplie()+".png")));
					
				}else {
					carte0.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
				}
				
			}

			
			if(((Joueur) o).getMainDuJoueur().size()==3) {
				
				if(((Joueur) o).getMainDuJoueur().get(0)!=null) {
					
					Carte c0 = ((Joueur) o).getMainDuJoueur().get(0);
					carte0.setIcon(new ImageIcon(VuePartie.class.getResource(string+c0.getForme()+c0.getCouleur()+c0.EstRemplie()+".png")));
					
				}else {
					carte0.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
				}
				
				if(((Joueur) o).getMainDuJoueur().get(1)!=null) {
					
					Carte c1 = ((Joueur) o).getMainDuJoueur().get(1);
					carte1.setIcon(new ImageIcon(VuePartie.class.getResource(string+c1.getForme()+c1.getCouleur()+c1.EstRemplie()+".png")));
				}else{
					carte1.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
				}
				
				if(((Joueur) o).getMainDuJoueur().get(2)!=null) {
					
					Carte c2 = ((Joueur) o).getMainDuJoueur().get(2);
					carte2.setIcon(new ImageIcon(VuePartie.class.getResource(string+c2.getForme()+c2.getCouleur()+c2.EstRemplie()+".png")));
				}
				else{
					carte2.setIcon(new ImageIcon(VuePartie.class.getResource(name)));
				}
			} 
			
			
			if (this.partie.getModeDeJeu() instanceof StrategieDeBase) {
				carteDeVict.setIcon(new ImageIcon(VuePartie.class.getResource(string+((Joueur) o).getCarteDeVictoire().getForme()+((Joueur) o).getCarteDeVictoire().getCouleur()+((Joueur) o).getCarteDeVictoire().EstRemplie()+".png")));
				carteVict.setText("Voici votre carte de victoire");
			
			} else if (this.partie.getModeDeJeu() instanceof StrategieVictoireEnnemie) {

					if ((Joueur) o != ((Joueur) this.partie.getQueueJoueurs().toArray()[1]) ) {
						carteDeVict.setIcon(new ImageIcon(VuePartie.class.getResource(string+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getCarteDeVictoire().getForme()+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getCarteDeVictoire().getCouleur()+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getCarteDeVictoire().EstRemplie()+".png")));
						carteVict.setText("Voici la carte de victoire de "+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getNom());
						
						if (this.partie.getQueueJoueurs().size() == 3 && (Joueur) o != ((Joueur) this.partie.getQueueJoueurs().toArray()[2])) {
							carteDeVict2.setIcon(new ImageIcon(VuePartie.class.getResource(string+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getCarteDeVictoire().getForme()+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getCarteDeVictoire().getCouleur()+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getCarteDeVictoire().EstRemplie()+".png")));
							carteVict2.setText("Voici la carte de victoire de "+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getNom());
							carteDeVict2.setVisible(true);
							carteVict2.setVisible(true);
						}
					}
			}
				
		}
		
		
		if(arg instanceof TapisDeJeu) {
			
			for(int i=0; i<tapis.getContainer().size(); i++) {
				
				for(int j=0; j<tapis.getContainer().get(i).size(); j++) {
					
					Carte c = tapis.getContainer().get(i).get(j);
					
					if(tapis.caseRemplie(i,j)) {
						
							((AbstractButton) this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j)).setIcon(new ImageIcon(VuePartie.class.getResource(string+c.getForme()+c.getCouleur()+c.EstRemplie()+".png")));
						
						
					} else {
						
						if(this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j) instanceof AbstractButton) {
							((AbstractButton) this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j)).setIcon(new ImageIcon(VuePartie.class.getResource(name)));
						}
						
					}
					
				}
			}
			
		}
			
	}
}


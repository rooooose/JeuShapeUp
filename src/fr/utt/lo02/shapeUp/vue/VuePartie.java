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
 * C'est une vue graphique de la partie et des diff�rents tour de jeu.
 * 
 * @see Partie
 * @author Shir F, Math�a Z
 *
 */
public class VuePartie implements Observer{

	/**
	 * Partie dont cette classe est la vue graphique
	 */
	private Partie partie;
	
	/**
	 * Fen�tre correspondant � l'affichage des cartes du joueur et du d�roul� du jeu
	 */
	private JFrame frame;
	/**
	 * Fen�tre correspondant � l'affichage du tapis de jeu
	 */
	private JFrame tapisDeJeu;

	/**
	 * Ensemble des �l�ments graphiques n�cessaire pour l'affichage des cartes du joueur et du d�roul� du jeu
	 */
	private JPanel panel;
	
	/**
	 * Bouton utilis� pour la repr�sentation de la premi�re carte dans la main du joueur
	 */
	private JButton carte0;
	/**
	 * Bouton utilis� pour la repr�sentation de la deuxi�me carte dans la main du joueur (utilis� seulement en r�gles avanc�es)
	 * 
	 * @see StrategieAvance
	 */
	private JButton carte1;
	/**
	 * Bouton utilis� pour la repr�sentation de la troisi�me carte dans la main du joueur (utilis� seulement en r�gles avanc�es)
	 * 
	 * @see StrategieAvance
	 */
	private JButton carte2;
	
	/**
	 * Bouton utilis� pour la repr�sentation de la carte de victoire du joueur ou, en r�gles "victoire ennemie", la premi�re carte de victoire ennemie
	 * 
	 * @see StrategieMode
	 */
	private JButton carteDeVict;
	/**
	 * Bouton utilis� en r�gles "victoire ennemie" pour la repr�sentation de la seconde carte de victoire ennemie (lorsqu'il y a 3 joueurs)
	 * 
	 * @see StrategieVictoireEnnemie
	 */
	private JButton carteDeVict2;
	
	/**
	 * Zone de texte pour conna�tre le d�roul� du jeu
	 */
	private JLabel tourDeJeu;
	/**
	 * Zone de texte li� � la carte de victoire du joueur (ou la premi�re carte de victoire ennemie)
	 */
	private JLabel carteVict;
	/**
	 * Zone de texte li� � la seconde carte de victoire ennemie (lorsqu'il y a 3 joueurs en r�gles "victoire ennemie")
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
	 * Permet de r�cup�rer la vue du tapis de jeu de la partie
	 * @return JFrame correspondant � la vue du tapis de jeu
	 */
	public JFrame getTapisDeJeu() {
		return tapisDeJeu;
	}
	
	/**
	 * Permet de r�cup�rer la partie observ�e par la vue
	 * @return Partie observ�e par la vue
	 */
	public Partie getPartie() {
		return partie;
	}

	/**
	 * Permet de d�finir la partie observ�e par la vue
	 * @param partie
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	/**
	 * Permet de r�cup�rer la fen�tre pour la gestion du d�roul� du jeu
	 * @return JFrame correspondant � la gestion du d�roul� du jeu
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Permet de d�finir la fen�tre pour la gestion du d�roul� du jeu
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Permet d� r�cup�rer le bouton utilis� pour la repr�sentation de la carte de victoire du joueur actif ou, en r�gles "victoire ennemie", la premi�re carte de victoire ennemie
	 * @return JButton correspondant � la carte de victoire 
	 */
	public JButton getCarteDeVict() {
		return carteDeVict;
	}

	/**
	 * Permet d� d�finir le bouton utilis� pour la repr�sentation de la carte de victoire du joueur actif ou, en r�gles "victoire ennemie", la premi�re carte de victoire ennemie
	 * @param carteDeVict
	 */
	public void setCarteDeVict(JButton carteDeVict) {
		this.carteDeVict = carteDeVict;
	}
	
	/**
	 * Permet de r�cup�rer la zone de texte correspondant aux informations sur la carte de victoire
	 * @return Zone de texte pour l'affichage des informations sur la carte de victoire
	 */
	public JLabel getCarteVict() {
		return carteVict;
	}

	/**
	 * Permet de d�finir la zone de texte correspondant aux informations sur la carte de victoire
	 * @param carteVict
	 */
	public void setCarteVict(JLabel carteVict) {
		this.carteVict = carteVict;
	}
	
	/**
	 * Permet de r�cup�rer l'ensemble des �l�ments graphiques li�s au d�roul� de la partie
	 * @return JPanel correspondant � l'ensemble des �l�ments graphiques li�s au d�roul� de la partie
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Permet de d�finir l'ensemble des �l�ments graphiques li�s au d�roul� de la partie
	 * @param panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Permet de r�cup�rer le bouton repr�sentant la premi�re carte dans la main du joueur 
	 * @return JButton utilis� pour la repr�sentation de la premi�re carte dans la main du joueur
	 */
	public JButton getCarte0() {
		return carte0;
	}

	/**
	 * Permet de d�finir le bouton repr�sentant la premi�re carte dans la main du joueur
	 * @param carte0
	 */
	public void setCarte0(JButton carte0) {
		this.carte0 = carte0;
	}

	/**
	 * Permet de r�cup�rer le bouton repr�sentant la deuxi�me carte dans la main du joueur (utilis� seulement en r�gles avanc�es)
	 * @return JButton utilis� pour la repr�sentation de la deuxi�me carte dans la main du joueur
	 */
	public JButton getCarte1() {
		return carte1;
	}
	/**
	 * Permet de d�finir le bouton repr�sentant la deuxi�me carte dans la main du joueur (utilis� seulement en r�gles avanc�es)
	 * @param carte1
	 */
	public void setCarte1(JButton carte1) {
		this.carte1 = carte1;
	}
	/**
	 * Permet de r�cup�rer le bouton repr�sentant la trois�me carte dans la main du joueur (utilis� seulement en r�gles avanc�es)
	 * @return JButton utilis� pour la repr�sentation de la trois�me carte dans la main du joueur
	 */
	public JButton getCarte2() {
		return carte2;
	}
	/**
	 * Permet de d�finir le bouton repr�sentant la troisi�me carte dans la main du joueur (utilis� seulement en r�gles avanc�es)
	 * @param carte2
	 */
	public void setCarte2(JButton carte2) {
		this.carte2 = carte2;
	}

	/**
	 * Permet de r�cup�rer la zone de texte pour l'affichage du d�roul� du jeu
	 * @return JLabel pour l'affichage du d�roul� du jeu
	 */
	public JLabel getTourDeJeu() {
		return tourDeJeu;
	}
	/**
	 * Permet de d�finir la zone de texte pour l'affichage du d�roul� du jeu
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
	 * Permet d'initialiser la fen�tre li� au d�roul� de la partie
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
	 * Permet � la vue graphique de se mettre � jour en fonction du d�roul� de la partie
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


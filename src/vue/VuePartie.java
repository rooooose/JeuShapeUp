package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleurs.pourShapeUp.ControleurPartie;
import shapeUp.Carte;
import shapeUp.Joueur;
import shapeUp.JoueurReel;
import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.Partie;
import shapeUp.StrategieAvance;
import shapeUp.StrategieDeBase;
import shapeUp.StrategieVictoireEnnemie;
import shapeUp.TapisCercle;
import shapeUp.TapisDeJeu;
import shapeUp.TapisRectangle;
import shapeUp.TapisTriangleRectangle;

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

public class VuePartie implements Observer{

	private Partie partie;
	
	private JFrame frame;
	private JFrame tapisDeJeu;

	private JPanel panel;
	private JButton boutonDeplacer;
	
	private JButton carte0;
	private JButton carte1;
	private JButton carte2;
	
	private JButton carteDeVict;
	private JButton carteDeVict2;
	
	private JLabel tourDeJeu;
	private JLabel carteVict;
	private JLabel carteVict2;
	
	private Queue<Joueur> joueurs = new LinkedList<Joueur>();
	private TapisDeJeu tapis;
	
	public JFrame getTapisDeJeu() {
		return tapisDeJeu;
	}
	
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	public JButton getCarteDeVict() {
		return carteDeVict;
	}

	public void setCarteDeVict(JButton carteDeVict) {
		this.carteDeVict = carteDeVict;
	}

	public JLabel getCarteVict() {
		return carteVict;
	}

	public void setCarteVict(JLabel carteVict) {
		this.carteVict = carteVict;
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JButton getBoutonDeplacer() {
		return boutonDeplacer;
	}

	public void setBoutonDeplacer(JButton boutonDeplacer) {
		this.boutonDeplacer = boutonDeplacer;
	}

	public JButton getCarte0() {
		return carte0;
	}

	public void setCarte0(JButton carte0) {
		this.carte0 = carte0;
	}

	public JButton getCarte1() {
		return carte1;
	}

	public void setCarte1(JButton carte1) {
		this.carte1 = carte1;
	}

	public JButton getCarte2() {
		return carte2;
	}

	public void setCarte2(JButton carte2) {
		this.carte2 = carte2;
	}

	public JLabel getTourDeJeu() {
		return tourDeJeu;
	}

	public void setTourDeJeu(JLabel tourDeJeu) {
		this.tourDeJeu = tourDeJeu;
	}


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VuePartie window = new VuePartie();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
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
	 * Initialize the contents of the frame.
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
		carte0.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		carte0.setBounds(12, 13, 146, 179);
		panel.add(carte0);
		
		carte1 = new JButton();
		carte1.setBackground(new Color(0, 0, 0));
		carte1.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		carte1.setBounds(169, 13, 144, 179);
		panel.add(carte1);
		
		carte2 = new JButton();
		carte2.setBackground(new Color(0, 0, 0));
		carte2.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		carte2.setBounds(325, 13, 137, 179);
		panel.add(carte2);
		
		tourDeJeu = new JLabel("Jouons");
		tourDeJeu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tourDeJeu.setBounds(12, 259, 450, 163);
		panel.add(tourDeJeu);
		
		boutonDeplacer = new JButton("D\u00E9placer une carte");
		boutonDeplacer.setForeground(new Color(218, 112, 214));
		boutonDeplacer.setFont(new Font("Century Gothic", Font.BOLD, 13));
		boutonDeplacer.setBackground(Color.BLACK);
		boutonDeplacer.setBounds(12, 221, 161, 25);
		panel.add(boutonDeplacer);
		
		carteDeVict = new JButton();
		carteDeVict.setBackground(new Color(128, 0, 128));
		carteDeVict.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
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
		//frame.pack();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof String) {
			this.tourDeJeu.setText((String) arg);
		}
		
		if(o instanceof Joueur) {
			if(((Joueur) o).getMainDuJoueur().size()>=1) {
				
				if(((Joueur) o).getMainDuJoueur().get(0)!=null) {
					
					Carte c0 = ((Joueur) o).getMainDuJoueur().get(0);
					carte0.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+c0.getForme()+c0.getCouleur()+c0.EstRemplie()+".png")));
					
				}else {
					carte0.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
				}
				
			}
			
			if(((Joueur) o).getMainDuJoueur().size()>=2) {
				
				if(((Joueur) o).getMainDuJoueur().get(1)!=null) {
					
					Carte c1 = ((Joueur) o).getMainDuJoueur().get(1);
					carte1.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+c1.getForme()+c1.getCouleur()+c1.EstRemplie()+".png")));
				}else{
					carte1.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
				}
				
			} 
			
			if(((Joueur) o).getMainDuJoueur().size()==3) {
				
				if(((Joueur) o).getMainDuJoueur().get(2)!=null) {
					
					Carte c2 = ((Joueur) o).getMainDuJoueur().get(2);
					carte2.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+c2.getForme()+c2.getCouleur()+c2.EstRemplie()+".png")));
				}
				else{
					carte2.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
				}
			} /*if (this.partie.getModeDeJeu() instanceof StrategieAvance) {


				
			}*/
			
			if (this.partie.getModeDeJeu() instanceof StrategieDeBase) {
				carteDeVict.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+((Joueur) o).getCarteDeVictoire().getForme()+((Joueur) o).getCarteDeVictoire().getCouleur()+((Joueur) o).getCarteDeVictoire().EstRemplie()+".png")));
				carteVict.setText("Voici votre carte de victoire");
			
			} else if (this.partie.getModeDeJeu() instanceof StrategieVictoireEnnemie) {

					if ((Joueur) o != ((Joueur) this.partie.getQueueJoueurs().toArray()[1]) ) {
						carteDeVict.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getCarteDeVictoire().getForme()+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getCarteDeVictoire().getCouleur()+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getCarteDeVictoire().EstRemplie()+".png")));
						carteVict.setText("Voici la carte de victoire de "+((Joueur) this.partie.getQueueJoueurs().toArray()[1]).getNom());
						
						if (this.partie.getQueueJoueurs().size() == 3 && (Joueur) o != ((Joueur) this.partie.getQueueJoueurs().toArray()[2])) {
							carteDeVict2.setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getCarteDeVictoire().getForme()+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getCarteDeVictoire().getCouleur()+((Joueur) this.partie.getQueueJoueurs().toArray()[2]).getCarteDeVictoire().EstRemplie()+".png")));
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
						//if(this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j) instanceof AbstractButton) {
							((AbstractButton) this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j)).setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/"+c.getForme()+c.getCouleur()+c.EstRemplie()+".png")));
						//}
						
					} else {
						
						if(this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j) instanceof AbstractButton) {
							((AbstractButton) this.tapisDeJeu.getContentPane().getComponent(i*tapis.getContainer().get(i).size()+j)).setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/caseVide.png")));
						}
						
					}
					
				}
			}
			
		}
			
	}
		
		
		
		
}


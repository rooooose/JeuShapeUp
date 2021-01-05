package controleurs.pourShapeUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import shapeUp.Carte;
import shapeUp.Partie;
import shapeUp.TapisDeJeu;
import vue.Console;
import vue.VueCirculaire;
import vue.VuePartie;

public class ControleurPartie {

	public ControleurPartie(Partie p, VuePartie vuePartie) {
		
		/*vuePartie.getBoutonPioche().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuePartie.getCarte0().setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/triangleBleuRempli.png")));

			}
		});
	}*/
		if(vuePartie.getTapisDeJeu() instanceof VueCirculaire) {
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase0x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					if(p.getTapisDeJeu().placementNormalPossible(0,1) || p.getTapisDeJeu().decalagePossible(0, 1)) {
						p.getJoueurActif().placerCarteGUI(0,1,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(0);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
					
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase0x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					if(p.getTapisDeJeu().placementNormalPossible(0,2) || p.getTapisDeJeu().decalagePossible(0, 2)) {
						p.getJoueurActif().placerCarteGUI(0,2,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(0);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					if(p.getTapisDeJeu().placementNormalPossible(1,0) || p.getTapisDeJeu().decalagePossible(1, 0)) {
						p.getJoueurActif().placerCarteGUI(1,0,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(1);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
	

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(1,1) || p.getTapisDeJeu().decalagePossible(1, 1)) {
						p.getJoueurActif().placerCarteGUI(1,1,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(1);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(1,2) || p.getTapisDeJeu().decalagePossible(1, 2)) {
						p.getJoueurActif().placerCarteGUI(1,2,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(1);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					if(p.getTapisDeJeu().placementNormalPossible(1,3) || p.getTapisDeJeu().decalagePossible(1, 3)) {
						p.getJoueurActif().placerCarteGUI(1,3,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(1);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
					
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					if(p.getTapisDeJeu().placementNormalPossible(2,0) || p.getTapisDeJeu().decalagePossible(2, 0)) {
						p.getJoueurActif().placerCarteGUI(2,0,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(2);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(2,1) || p.getTapisDeJeu().decalagePossible(2,1)) {
						p.getJoueurActif().placerCarteGUI(2,1,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(2);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
					
				}
			});

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(2,2) || p.getTapisDeJeu().decalagePossible(2,2)) {
						p.getJoueurActif().placerCarteGUI(2,2,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(2);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(2,3) || p.getTapisDeJeu().decalagePossible(2,3)) {
						p.getJoueurActif().placerCarteGUI(2,3,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(2);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
					
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(3,0) || p.getTapisDeJeu().decalagePossible(3,0)) {
						p.getJoueurActif().placerCarteGUI(3,0,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(3);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
;
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(3,1) || p.getTapisDeJeu().decalagePossible(3,1)) {
						p.getJoueurActif().placerCarteGUI(3,1,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(3);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(3,2) || p.getTapisDeJeu().decalagePossible(3,2)) {
						p.getJoueurActif().placerCarteGUI(3,2,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(3);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(3,3) || p.getTapisDeJeu().decalagePossible(3,3)) {
						p.getJoueurActif().placerCarteGUI(3,3,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(3);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase4x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(4,1) || p.getTapisDeJeu().decalagePossible(4,1)) {
						p.getJoueurActif().placerCarteGUI(4,1,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(4);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase4x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().placementNormalPossible(4,2) || p.getTapisDeJeu().decalagePossible(4,2)) {
						p.getJoueurActif().placerCarteGUI(4,2,p.getTapisDeJeu(),c);
						p.getJoueurActif().setLigCarteGUI(4);
						p.notifyObservers("Appuyez sur Entr�e pour continuer");
					}
				}
			});
		}
		
	
	
	
	}
}




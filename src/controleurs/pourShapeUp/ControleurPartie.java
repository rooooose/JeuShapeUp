package controleurs.pourShapeUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import shapeUp.Carte;
import shapeUp.JoueurReel;
import shapeUp.Partie;
import shapeUp.StrategieAvance;
import shapeUp.TapisDeJeu;
import vue.Console;
import vue.VueCirculaire;
import vue.VuePartie;
import vue.VueTapisRectangle;
import vue.VueTriangle;

public class ControleurPartie {

	public ControleurPartie(Partie p, VuePartie vuePartie) {
		
		

				//if(p.getJoueurActif().getCarteAJouer() == null) {
					
					(vuePartie.getCarte0()).addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							if(p.getModeDeJeu() instanceof StrategieAvance) {
								
								if (p.getJoueurActif() instanceof JoueurReel ) {
							
							//p.getJoueurActif().setCarteAJouer(p.getJoueurActif().getMainDuJoueur().get(0));
							//p.getJoueurActif().getMainDuJoueur().remove(0);
							p.getJoueurActif().setNumCarteGUI(0);
							
							p.notifyObservers("Appuyez sur Entrée pour continuer");
							//p.getJoueurActif().notifyObservers(p.getJoueurActif().getMainDuJoueur());
							
							
							
						}
					}
					
							
						}
					});
					
					(vuePartie.getCarte1()).addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							if(p.getModeDeJeu() instanceof StrategieAvance) {
								
								if (p.getJoueurActif() instanceof JoueurReel ) {
							
							//p.getJoueurActif().setCarteAJouer(p.getJoueurActif().getMainDuJoueur().get(1));
							//p.getJoueurActif().getMainDuJoueur().remove(1);
							p.getJoueurActif().setNumCarteGUI(1);
							
							p.notifyObservers("Appuyez sur Entrée pour continuer");
							//p.getJoueurActif().notifyObservers(p.getJoueurActif().getMainDuJoueur());
							
							
							
						}
					}
					
							
						}
					});
					
					(vuePartie.getCarte2()).addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							if(p.getModeDeJeu() instanceof StrategieAvance) {
								
								if (p.getJoueurActif() instanceof JoueurReel ) {
							
							
									//p.getJoueurActif().setCarteAJouer(p.getJoueurActif().getMainDuJoueur().get(2));
									//p.getJoueurActif().getMainDuJoueur().remove(2);
									p.getJoueurActif().setNumCarteGUI(2);
									
									p.notifyObservers("Appuyez sur Entrée pour continuer");
								
						}
					}
					
							
						}
					});
				//}
			
			
		
		
		if(vuePartie.getTapisDeJeu() instanceof VueCirculaire) {
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase0x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,1) && p.getJoueurActif().isDeplacementPossible()) {
						p.getJoueurActif().deplacerCarteGUI(0,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,1) || p.getTapisDeJeu().decalagePossible(0, 1)) {
						
						p.getJoueurActif().placerCarteGUI(0,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase0x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,2) || p.getTapisDeJeu().decalagePossible(0,2)) {
						
						p.getJoueurActif().placerCarteGUI(0,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,0) || p.getTapisDeJeu().decalagePossible(1,0)) {
						
						p.getJoueurActif().placerCarteGUI(1,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
	

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,1) || p.getTapisDeJeu().decalagePossible(1,1)) {
						
						p.getJoueurActif().placerCarteGUI(1,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,2) || p.getTapisDeJeu().decalagePossible(1,2)) {
						
						p.getJoueurActif().placerCarteGUI(1,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase1x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,3) || p.getTapisDeJeu().decalagePossible(1,3)) {
						
						p.getJoueurActif().placerCarteGUI(1,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,0) || p.getTapisDeJeu().decalagePossible(2,0)) {
						
						p.getJoueurActif().placerCarteGUI(2,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,1) || p.getTapisDeJeu().decalagePossible(2,1)) {
						
						p.getJoueurActif().placerCarteGUI(2,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,2) || p.getTapisDeJeu().decalagePossible(2,2)) {
						
						p.getJoueurActif().placerCarteGUI(2,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});

			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase2x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,3) || p.getTapisDeJeu().decalagePossible(2,3)) {
						
						p.getJoueurActif().placerCarteGUI(2,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,0) || p.getTapisDeJeu().decalagePossible(3,0)) {
						
						p.getJoueurActif().placerCarteGUI(3,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
;
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,1) || p.getTapisDeJeu().decalagePossible(3,1)) {
						
						p.getJoueurActif().placerCarteGUI(3,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,2) || p.getTapisDeJeu().decalagePossible(3,2)) {
						
						p.getJoueurActif().placerCarteGUI(3,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase3x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,3) || p.getTapisDeJeu().decalagePossible(3,3)) {
						
						p.getJoueurActif().placerCarteGUI(3,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase4x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,1) || p.getTapisDeJeu().decalagePossible(4,1)) {
						
						p.getJoueurActif().placerCarteGUI(4,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase4x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,2) || p.getTapisDeJeu().decalagePossible(4,2)) {
						
						p.getJoueurActif().placerCarteGUI(4,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
				}
			});
		}
		
		else if(vuePartie.getTapisDeJeu() instanceof VueTriangle) {
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase0x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,0) || p.getTapisDeJeu().decalagePossible(0,0)) {
						
						p.getJoueurActif().placerCarteGUI(0,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase1x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,0) || p.getTapisDeJeu().decalagePossible(1,0)) {
						
						p.getJoueurActif().placerCarteGUI(1,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase1x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,1) || p.getTapisDeJeu().decalagePossible(1,1)) {
						
						p.getJoueurActif().placerCarteGUI(1,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase2x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,0) || p.getTapisDeJeu().decalagePossible(2,0)) {
						
						p.getJoueurActif().placerCarteGUI(2,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase2x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,1) || p.getTapisDeJeu().decalagePossible(2,1)) {
						
						p.getJoueurActif().placerCarteGUI(2,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase2x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,2) || p.getTapisDeJeu().decalagePossible(2,2)) {
						
						p.getJoueurActif().placerCarteGUI(2,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase3x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,0) || p.getTapisDeJeu().decalagePossible(3,0)) {
						
						p.getJoueurActif().placerCarteGUI(3,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase3x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,1) || p.getTapisDeJeu().decalagePossible(3,1)) {
						
						p.getJoueurActif().placerCarteGUI(3,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase3x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,2) || p.getTapisDeJeu().decalagePossible(3,2)) {
						
						p.getJoueurActif().placerCarteGUI(3,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase3x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(3,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(3,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(3);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(3,3) || p.getTapisDeJeu().decalagePossible(3,3)) {
						
						p.getJoueurActif().placerCarteGUI(3,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(3);
						} else {
							p.getJoueurActif().setLigCarteGUI(3);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase4x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,0) || p.getTapisDeJeu().decalagePossible(4,0)) {
						
						p.getJoueurActif().placerCarteGUI(4,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase4x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,1) || p.getTapisDeJeu().decalagePossible(4,1)) {
						
						p.getJoueurActif().placerCarteGUI(4,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase4x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,2) || p.getTapisDeJeu().decalagePossible(4,2)) {
						
						p.getJoueurActif().placerCarteGUI(4,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase4x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,3) || p.getTapisDeJeu().decalagePossible(4,3)) {
						
						p.getJoueurActif().placerCarteGUI(4,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTriangle) vuePartie.getTapisDeJeu()).getCase4x4().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(4,4) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(4,4,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(4);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(4,4) || p.getTapisDeJeu().decalagePossible(4,4)) {
						
						p.getJoueurActif().placerCarteGUI(4,4,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(4);
						} else {
							p.getJoueurActif().setLigCarteGUI(4);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
		}
	
		else if(vuePartie.getTapisDeJeu() instanceof VueTapisRectangle) {
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase0x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,0) || p.getTapisDeJeu().decalagePossible(0,0)) {
						
						p.getJoueurActif().placerCarteGUI(0,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase0x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,1) || p.getTapisDeJeu().decalagePossible(0,1)) {
						
						p.getJoueurActif().placerCarteGUI(0,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase0x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,2) || p.getTapisDeJeu().decalagePossible(0,2)) {
						
						p.getJoueurActif().placerCarteGUI(0,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase0x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,3) || p.getTapisDeJeu().decalagePossible(0,3)) {
						
						p.getJoueurActif().placerCarteGUI(0,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase0x4().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(0,4) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(0,4,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(0);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(0,4) || p.getTapisDeJeu().decalagePossible(0,4)) {
						
						p.getJoueurActif().placerCarteGUI(0,4,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(0);
						} else {
							p.getJoueurActif().setLigCarteGUI(0);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase1x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,0) || p.getTapisDeJeu().decalagePossible(1,0)) {
						
						p.getJoueurActif().placerCarteGUI(1,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase1x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,1) || p.getTapisDeJeu().decalagePossible(1,1)) {
						
						p.getJoueurActif().placerCarteGUI(1,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase1x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,2) || p.getTapisDeJeu().decalagePossible(1,2)) {
						
						p.getJoueurActif().placerCarteGUI(1,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase1x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,3) || p.getTapisDeJeu().decalagePossible(1,3)) {
						
						p.getJoueurActif().placerCarteGUI(1,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase1x4().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(1,4) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(1,4,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(1);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(1,4) || p.getTapisDeJeu().decalagePossible(1,4)) {
						
						p.getJoueurActif().placerCarteGUI(1,4,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(1);
						} else {
							p.getJoueurActif().setLigCarteGUI(1);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase2x0().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,0) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,0,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,0) || p.getTapisDeJeu().decalagePossible(2,0)) {
						
						p.getJoueurActif().placerCarteGUI(2,0,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase2x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,1) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,1,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,1) || p.getTapisDeJeu().decalagePossible(2,1)) {
						
						p.getJoueurActif().placerCarteGUI(2,1,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase2x2().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,2) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,2,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,2) || p.getTapisDeJeu().decalagePossible(2,2)) {
						
						p.getJoueurActif().placerCarteGUI(2,2,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase2x3().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,3) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,3,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,3) || p.getTapisDeJeu().decalagePossible(2,3)) {
						
						p.getJoueurActif().placerCarteGUI(2,3,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
			
			((VueTapisRectangle) vuePartie.getTapisDeJeu()).getCase2x4().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Carte c = p.getJoueurActif().getCarteAJouer();
					
					if(p.getTapisDeJeu().caseRemplie(2,4) && p.getJoueurActif().isDeplacementPossible()) {
						
						p.getJoueurActif().deplacerCarteGUI(2,4,p.getTapisDeJeu());
						p.getJoueurActif().setLigCarteADepGUI(2);
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					else if(p.getTapisDeJeu().placementNormalPossible(2,4) || p.getTapisDeJeu().decalagePossible(2,4)) {
						
						p.getJoueurActif().placerCarteGUI(2,4,p.getTapisDeJeu(),c);
						
						if(p.getJoueurActif().isDeplacementEnCours()) {
							p.getJoueurActif().setLigCarteDepGUI(2);
						} else {
							p.getJoueurActif().setLigCarteGUI(2);
						}
						p.notifyObservers("Appuyez sur Entrée pour continuer");
					}
					
				}
			});
		}
	
	}
}




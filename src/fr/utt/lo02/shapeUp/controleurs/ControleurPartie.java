package fr.utt.lo02.shapeUp.controleurs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import fr.utt.lo02.shapeUp.modele.Carte;
import fr.utt.lo02.shapeUp.modele.JoueurReel;
import fr.utt.lo02.shapeUp.modele.Partie;
import fr.utt.lo02.shapeUp.modele.StrategieAvance;
import fr.utt.lo02.shapeUp.modele.TapisDeJeu;
import fr.utt.lo02.shapeUp.vue.Console;
import fr.utt.lo02.shapeUp.vue.VueCirculaire;
import fr.utt.lo02.shapeUp.vue.VuePartie;
import fr.utt.lo02.shapeUp.vue.VueTapisRectangle;
import fr.utt.lo02.shapeUp.vue.VueTriangle;

/**
 * Ce contrôleur permet de faire le lien entre une Partie et ses différents Observer 
 * @author Shir F, Mathéa Z
 * 
 * @see {@link Partie}, {@link VuePartie}
 *
 */
public class ControleurPartie {

	/**
	 * Constructeur du contrôleur qui fera le lien entre les objets mis en paramètres
	 * 
	 * @param p - partie que l'on utilise pour jouer
	 * @param vuePartie - vue graphique de la partie
	 */
	public ControleurPartie(Partie p, VuePartie vuePartie) {
		
		

				
					
					(vuePartie.getCarte0()).addActionListener(new ActionListener() {
						
						/**
						 * Lorsque le joueur place sa carte n°0 (il n'y aura qu'une carte en règles de base ou "victoire ennemie") via l'interface graphique, cela met à jour le tapis de jeu 
						 */
						public void actionPerformed(ActionEvent e) {
							
							if(p.getModeDeJeu() instanceof StrategieAvance) {
								
								if (p.getJoueurActif() instanceof JoueurReel ) {
							

							p.getJoueurActif().setNumCarteGUI(0);
							
							p.notifyObservers("Appuyez sur Entrée pour continuer");
							p.getJoueurActif().notifyObservers(p.getJoueurActif().getMainDuJoueur());
							
							
							
						}
					}
					
							
						}
					});
					
					(vuePartie.getCarte1()).addActionListener(new ActionListener() {
						
						/**
						 * Lorsque le joueur place sa carte n°1 en règles avancées (il n'y aura qu'une carte en règles de base ou "victoire ennemie") via l'interface graphique, cela met à jour le tapis de jeu 
						 */
						public void actionPerformed(ActionEvent e) {
							
							if(p.getModeDeJeu() instanceof StrategieAvance) {
								
								if (p.getJoueurActif() instanceof JoueurReel ) {
							
							
							p.getJoueurActif().setNumCarteGUI(1);
							
							p.notifyObservers("Appuyez sur Entrée pour continuer");
							
							
							
							
						}
					}
					
							
						}
					});
					
					(vuePartie.getCarte2()).addActionListener(new ActionListener() {
						/**
						 * Lorsque le joueur place sa carte n°2 en règles avancées (il n'y aura qu'une carte en règles de base ou "victoire ennemie") via l'interface graphique, cela met à jour le tapis de jeu 
						 */
						public void actionPerformed(ActionEvent e) {
							
							if(p.getModeDeJeu() instanceof StrategieAvance) {
								
								if (p.getJoueurActif() instanceof JoueurReel ) {
							
							

									p.getJoueurActif().setNumCarteGUI(2);
									
									p.notifyObservers("Appuyez sur Entrée pour continuer");
								
						}
					}
					
							
						}
					});
				//}
			
			
		
		
		if(vuePartie.getTapisDeJeu() instanceof VueCirculaire) {
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase0x1().addActionListener(new ActionListener() {
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
					/**
					 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
					 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */	
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est circulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */	
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 3x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est triangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 4x4, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
			/**
			 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
			 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 0x4, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 1x4, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x0, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x1, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x2, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x3, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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
				/**
				 * Si le tapis est rectangulaire, les cases ne seront pas placées de la même façon, si une carte est placée sur la case 2x4, on vérifie que le joueur a le droit de placer cette carte ici et si c'est le cas, on met à jour le tapis de jeu
				 */
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




package controleurs.pourShapeUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import shapeUp.JoueurReel;
import shapeUp.JoueurVirtuel;
import shapeUp.ShapeUp;
import shapeUp.StrategieAvance;
import shapeUp.StrategieDeBase;
import shapeUp.StrategieMode;
import shapeUp.StrategieVictoireEnnemie;
import shapeUp.TapisCercle;
import shapeUp.TapisDeJeu;
import shapeUp.TapisRectangle;
import shapeUp.TapisTriangleRectangle;
import vue.VuePartie;
import vue.VueShapeUp;




public class ControleurShapeUp {
	private int nbre;
	private char[] types = {'r', 'r', 'r'};
	private String[] noms = {"Joueur1", "Joueur2", "Joueur3"};
	

	public int getNbre() {
		return nbre;
	}

	public void setNbre(int nbre) {
		this.nbre = nbre;
	}
	
	public char[] getTypes() {
		return types;
	}

	public void setTypes(char[] types) {
		this.types = types;
	}

	public String[] getNoms() {
		return noms;
	}

	public void setNoms(String[] noms) {
		this.noms = noms;
	}

	public ControleurShapeUp(ShapeUp sU, VueShapeUp vueShUp) {
		
		
		
		vueShUp.getOkAll().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vueShUp.getOkAll().setEnabled(false);
				vueShUp.setMaPartie(new VuePartie());
			}
		});
		
		
		vueShUp.getOkMode().addActionListener(new ActionListener() {
			
			StrategieMode mode;
			
		public void actionPerformed(ActionEvent e) {
			
			
			if (vueShUp.getDeBase().isSelected() || vueShUp.getVictoireEnnemie().isSelected() || vueShUp.getAvance().isSelected()) {
				
			if (vueShUp.getDeBase().isSelected()) {
				//mode = new StrategieDeBase(jeuShapeUp.getConsoleDuJeu());
				mode = new StrategieDeBase();
			}
			else if (vueShUp.getVictoireEnnemie().isSelected()) {
				//mode = new StrategieVictoireEnnemie(jeuShapeUp.getConsoleDuJeu());
				mode = new StrategieVictoireEnnemie();
			}
			else if (vueShUp.getAvance().isSelected()) {
				//mode = new StrategieAvance(jeuShapeUp.getConsoleDuJeu());
				mode = new StrategieAvance();
			}
			
			sU.setMode(mode);
			vueShUp.getModeDeJeu().setText("Vous avez choisi les règles : "+mode );
			vueShUp.getModeDeJeu().setForeground(Color.PINK);
			vueShUp.getOkMode().setEnabled(false);
			vueShUp.getDeBase().setEnabled(false);
			vueShUp.getVictoireEnnemie().setEnabled(false);
			vueShUp.getAvance().setEnabled(false);
			} 
			else {
				vueShUp.getModeDeJeu().setText("Il faut choisir un mode de jeu avant de confirmer.");
			}
			
			vueShUp.getFenetreChoix().pack();
		}
	});
		
		vueShUp.getOkForme().addActionListener(new ActionListener() {
			TapisDeJeu forme = null;
			
			public void actionPerformed(ActionEvent e) {
								
			if (vueShUp.getRectangle().isSelected() || vueShUp.getTriangle().isSelected() || vueShUp.getCercle().isSelected()) {	
				
				if (vueShUp.getRectangle().isSelected()) {
					forme = new TapisRectangle();
					//sU.setFormeTapis(forme);;
					vueShUp.getFormeTapis().setText("Vous avez choisi un tapis rectangulaire");
					
				}
				else if (vueShUp.getTriangle().isSelected()) {
					forme = new TapisTriangleRectangle();
					//sU.setFormeTapis(new TapisTriangleRectangle());
					vueShUp.getFormeTapis().setText("Vous avez choisi un tapis triangle rectangle");
				}
				else if (vueShUp.getCercle().isSelected()) {
					forme = new TapisCercle();
					//sU.setFormeTapis(new TapisCercle());
					vueShUp.getFormeTapis().setText("Vous avez choisi un tapis circulaire");
					
				}
				
				sU.setFormeTapis(forme);
				vueShUp.getFormeTapis().setForeground(Color.PINK);
				vueShUp.getOkForme().setEnabled(false);
				vueShUp.getRectangle().setEnabled(false);
				vueShUp.getTriangle().setEnabled(false);
				vueShUp.getCercle().setEnabled(false);
				vueShUp.getOkAll().setVisible(true);
				
			}  else {
				vueShUp.getFormeTapis().setText("Attention, veuillez choisir une forme de tapis avant de confirmer.");

			}
			vueShUp.getFenetreChoix().pack();
			}
			
		});
				
		vueShUp.getOkNbre().addActionListener(new ActionListener() {
			
	int nbre;		
	
			public void actionPerformed(ActionEvent e) {
				if (vueShUp.getDeuxJoueurs().isSelected() || vueShUp.getTroisJoueurs().isSelected()) {
					

				vueShUp.getNbreJoueurs().setForeground(Color.PINK);
				vueShUp.getOkNbre().setEnabled(false);
				vueShUp.getTroisJoueurs().setEnabled(false);
				vueShUp.getDeuxJoueurs().setEnabled(false);
				
				////vueShUp.getContainerType().setVisible(true);
				vueShUp.getJoueurs().setVisible(true);
				
				if (vueShUp.getDeuxJoueurs().isSelected()) {
					vueShUp.getNbreJoueurs().setText("Vous avez choisi 2 joueurs");
					vueShUp.getJoueur3().setVisible(false);
					nbre =2;
					
					
				}
				else if (vueShUp.getTroisJoueurs().isSelected()) {
					vueShUp.getNbreJoueurs().setText("Vous avez choisi 3 joueurs");
					nbre = 3;
				}
				
				ControleurShapeUp.this.setNbre(nbre);
				sU.setNbDeJoueurs(nbre);
				
				}
				else 
				{
					vueShUp.getNbreJoueurs().setText("Il faut choisir un nombre de joueurs avant de confirmer.");
				}
				
				vueShUp.getFenetreChoix().pack();
				
				
			}
		});
		
		
			
		vueShUp.getOkType1().addActionListener(new ActionListener() {
			
			
					public void actionPerformed(ActionEvent e) {
						
						
						if (vueShUp.getVirtuel1().isSelected()) {
							
							vueShUp.getTypeDuJoueur1().setText("Vous avez choisi le joueur 1 virtuel");
							
							ControleurShapeUp.this.getTypes()[0] = 'v';
							
						}else if (vueShUp.getReel1().isSelected()) {
							
							vueShUp.getTypeDuJoueur1().setText("Vous avez choisi le joueur 1 réel");
							
							ControleurShapeUp.this.getTypes()[0] = 'r';
							
						}
							
							
							if (vueShUp.getVirtuel1().isSelected() || vueShUp.getReel1().isSelected()) {
								
								vueShUp.getTypeDuJoueur1().setForeground(Color.PINK);
								vueShUp.getOkType1().setEnabled(false);
								vueShUp.getReel1().setEnabled(false);
								vueShUp.getVirtuel1().setEnabled(false);
								vueShUp.getContainerNom1().setVisible(true);
								
				
							}
				//}
							else 
							{
								vueShUp.getTypeDuJoueur1().setText("Il faut choisir un type de joueur avant de confirmer.");
							}
							vueShUp.getFenetreChoix().pack();
								}
		});
								
		vueShUp.getOkNom1().addActionListener(new ActionListener() {
									
		
									public void actionPerformed(ActionEvent e) {
										
										String nom = vueShUp.getNomJoueur1().getText();
										ControleurShapeUp.this.getNoms()[0] = nom;
										vueShUp.getNomDuJoueur1().setText("Vous avez choisi le nom du joueur 1 : "+nom);
										vueShUp.getNomDuJoueur1().setForeground(Color.PINK);
										//vueShUp.getNomJoueur().setText("");
										vueShUp.getNomJoueur1().setVisible(false);
										vueShUp.getOkNom1().setVisible(false);
										vueShUp.getFenetreChoix().pack();
										if (sU.getQueueJoueurs().size() == 0 ) {
											sU.creerJoueur(ControleurShapeUp.this.getTypes()[0], nom);
										}
										
										
									}
									
									
									
									});

		vueShUp.getOkType2().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				if (vueShUp.getVirtuel2().isSelected()) {
					
					vueShUp.getTypeDuJoueur2().setText("Vous avez choisi le joueur 2 virtuel");
					
					ControleurShapeUp.this.getTypes()[1] = 'v';
					
				}else if (vueShUp.getReel2().isSelected()) {
					
					vueShUp.getTypeDuJoueur2().setText("Vous avez choisi le joueur 2 réel");
					
					ControleurShapeUp.this.getTypes()[1] = 'r';
					
				}
					
					
					if (vueShUp.getVirtuel2().isSelected() || vueShUp.getReel2().isSelected()) {
						
						vueShUp.getTypeDuJoueur2().setForeground(Color.orange);
						vueShUp.getOkType2().setEnabled(false);
						vueShUp.getReel2().setEnabled(false);
						vueShUp.getVirtuel2().setEnabled(false);
						vueShUp.getContainerNom2().setVisible(true);
						
		
					}
		//}
					else 
					{
						vueShUp.getTypeDuJoueur2().setText("Il faut choisir un type de joueur avant de confirmer.");
					}
					vueShUp.getFenetreChoix().pack();
						}
				});
						
		vueShUp.getOkNom2().addActionListener(new ActionListener() {
							

							public void actionPerformed(ActionEvent e) {
								
								String nom = vueShUp.getNomJoueur2().getText();
								ControleurShapeUp.this.getNoms()[1] = nom;
								vueShUp.getNomDuJoueur2().setText("Vous avez choisi le nom du joueur 2 : "+nom);
								vueShUp.getNomDuJoueur2().setForeground(Color.orange);
								//vueShUp.getNomJoueur().setText("");
								vueShUp.getNomJoueur2().setVisible(false);
								vueShUp.getOkNom2().setVisible(false);
								vueShUp.getFenetreChoix().pack();
								if (sU.getQueueJoueurs().size() == 1 ) {
									sU.creerJoueur(ControleurShapeUp.this.getTypes()[1], nom);
								}
								
								
							}
							
							
							
							});
		
		vueShUp.getOkType3().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				if (vueShUp.getVirtuel3().isSelected()) {
					
					vueShUp.getTypeDuJoueur3().setText("Vous avez choisi le joueur 3 virtuel");
					
					ControleurShapeUp.this.getTypes()[2] = 'v';
					
				}else if (vueShUp.getReel3().isSelected()) {
					
					vueShUp.getTypeDuJoueur3().setText("Vous avez choisi le joueur 3 réel");
					
					ControleurShapeUp.this.getTypes()[2] = 'r';
					
				}
					
					
					if (vueShUp.getVirtuel3().isSelected() || vueShUp.getReel3().isSelected()) {
						
						vueShUp.getTypeDuJoueur3().setForeground(Color.blue);
						vueShUp.getOkType3().setEnabled(false);
						vueShUp.getReel3().setEnabled(false);
						vueShUp.getVirtuel3().setEnabled(false);
						vueShUp.getContainerNom3().setVisible(true);
						
		
					}
		//}
					else 
					{
						vueShUp.getTypeDuJoueur3().setText("Il faut choisir un type de joueur avant de confirmer.");
					}
					vueShUp.getFenetreChoix().pack();
						}
});
						
		vueShUp.getOkNom3().addActionListener(new ActionListener() {
							

							public void actionPerformed(ActionEvent e) {
								
								String nom = vueShUp.getNomJoueur3().getText();
								ControleurShapeUp.this.getNoms()[2] = nom;
								vueShUp.getNomDuJoueur3().setText("Vous avez choisi le nom du joueur 3 : "+nom);
								vueShUp.getNomDuJoueur3().setForeground(Color.blue);
								//vueShUp.getNomJoueur().setText("");
								vueShUp.getNomJoueur3().setVisible(false);
								vueShUp.getOkNom3().setVisible(false);
								vueShUp.getFenetreChoix().pack();
								if (sU.getQueueJoueurs().size() == 2 ) {
								sU.creerJoueur(ControleurShapeUp.this.getTypes()[2], nom);
								}
							}
							
							
							
							});

		
		
	}
}


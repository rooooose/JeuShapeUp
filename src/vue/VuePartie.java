package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VuePartie {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VuePartie window = new VuePartie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VuePartie() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("C'est parti pour jouer ! :) ");
		
		frame.setBounds(100, 100, 1316, 863);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton case0x0 = new JButton();
		case0x0.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case0x0 = new GridBagConstraints();
		gbc_case0x0.insets = new Insets(0, 0, 5, 5);
		gbc_case0x0.gridx = 0;
		gbc_case0x0.gridy = 0;
		panel.add(case0x0, gbc_case0x0);
		
		JButton case0x1 = new JButton();
		case0x1.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		case0x1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_case0x1 = new GridBagConstraints();
		gbc_case0x1.insets = new Insets(0, 0, 5, 5);
		gbc_case0x1.gridx = 1;
		gbc_case0x1.gridy = 0;
		panel.add(case0x1, gbc_case0x1);
		
		JButton case0x2 = new JButton();
		case0x2.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case0x2 = new GridBagConstraints();
		gbc_case0x2.insets = new Insets(0, 0, 5, 5);
		gbc_case0x2.gridx = 2;
		gbc_case0x2.gridy = 0;
		panel.add(case0x2, gbc_case0x2);
		
		JButton case0x3 = new JButton();
		case0x3.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case0x3 = new GridBagConstraints();
		gbc_case0x3.insets = new Insets(0, 0, 5, 5);
		gbc_case0x3.gridx = 3;
		gbc_case0x3.gridy = 0;
		panel.add(case0x3, gbc_case0x3);
		
		JButton case0x4 = new JButton();
		case0x4.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case0x4 = new GridBagConstraints();
		gbc_case0x4.insets = new Insets(0, 0, 5, 0);
		gbc_case0x4.gridx = 4;
		gbc_case0x4.gridy = 0;
		panel.add(case0x4, gbc_case0x4);
		
		JButton case1x0 = new JButton();
		case1x0.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case1x0 = new GridBagConstraints();
		gbc_case1x0.insets = new Insets(0, 0, 5, 5);
		gbc_case1x0.gridx = 0;
		gbc_case1x0.gridy = 1;
		panel.add(case1x0, gbc_case1x0);
		
		JButton case1x1 = new JButton();
		case1x1.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case1x1 = new GridBagConstraints();
		gbc_case1x1.insets = new Insets(0, 0, 5, 5);
		gbc_case1x1.gridx = 1;
		gbc_case1x1.gridy = 1;
		panel.add(case1x1, gbc_case1x1);
		
		JButton case1x2 = new JButton();
		case1x2.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case1x2 = new GridBagConstraints();
		gbc_case1x2.insets = new Insets(0, 0, 5, 5);
		gbc_case1x2.gridx = 2;
		gbc_case1x2.gridy = 1;
		panel.add(case1x2, gbc_case1x2);
		
		JButton case1x3 = new JButton();
		case1x3.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case1x3 = new GridBagConstraints();
		gbc_case1x3.insets = new Insets(0, 0, 5, 5);
		gbc_case1x3.gridx = 3;
		gbc_case1x3.gridy = 1;
		panel.add(case1x3, gbc_case1x3);
		
		JButton case1x4 = new JButton();
		case1x4.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case1x4 = new GridBagConstraints();
		gbc_case1x4.insets = new Insets(0, 0, 5, 0);
		gbc_case1x4.gridx = 4;
		gbc_case1x4.gridy = 1;
		panel.add(case1x4, gbc_case1x4);
		
		JButton case2x0 = new JButton();
		case2x0.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case2x0 = new GridBagConstraints();
		gbc_case2x0.insets = new Insets(0, 0, 0, 5);
		gbc_case2x0.gridx = 0;
		gbc_case2x0.gridy = 2;
		panel.add(case2x0, gbc_case2x0);
		
		JButton case2x1 = new JButton();
		case2x1.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case2x1 = new GridBagConstraints();
		gbc_case2x1.insets = new Insets(0, 0, 0, 5);
		gbc_case2x1.gridx = 1;
		gbc_case2x1.gridy = 2;
		panel.add(case2x1, gbc_case2x1);
		
		JButton case2x2 = new JButton();
		case2x2.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case2x2 = new GridBagConstraints();
		gbc_case2x2.insets = new Insets(0, 0, 0, 5);
		gbc_case2x2.gridx = 2;
		gbc_case2x2.gridy = 2;
		panel.add(case2x2, gbc_case2x2);
		
		JButton case2x3 = new JButton();
		case2x3.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case2x3 = new GridBagConstraints();
		gbc_case2x3.insets = new Insets(0, 0, 0, 5);
		gbc_case2x3.gridx = 3;
		gbc_case2x3.gridy = 2;
		panel.add(case2x3, gbc_case2x3);
		
		JButton case2x4 = new JButton();
		case2x4.setIcon(new ImageIcon("C:\\Users\\Patate\\Desktop\\A2i1\\LO02\\Projet\\JeuShapeUp\\JeuShapeUp\\src\\vue\\imagesPourCartes\\caseVide.png"));
		GridBagConstraints gbc_case2x4 = new GridBagConstraints();
		gbc_case2x4.gridx = 4;
		gbc_case2x4.gridy = 2;
		panel.add(case2x4, gbc_case2x4);
		
		frame.setVisible(true);
		frame.pack();
	}

}

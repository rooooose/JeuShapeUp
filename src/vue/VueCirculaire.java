package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class VueCirculaire extends JFrame {

	public VueCirculaire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 1187, 797);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		JButton case0x1 = new JButton();
		case0x1.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x1 = new GridBagConstraints();
		gbc_case0x1.insets = new Insets(0, 0, 5, 5);
		gbc_case0x1.gridx = 1;
		gbc_case0x1.gridy = 0;
		this.getContentPane().add(case0x1, gbc_case0x1);
		
		JButton case0x2 = new JButton();
		case0x2.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x2 = new GridBagConstraints();
		gbc_case0x2.insets = new Insets(0, 0, 5, 5);
		gbc_case0x2.gridx = 2;
		gbc_case0x2.gridy = 0;
		this.getContentPane().add(case0x2, gbc_case0x2);
		
		JButton case1x0 = new JButton();
		case1x0.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x0 = new GridBagConstraints();
		gbc_case1x0.insets = new Insets(0, 0, 5, 5);
		gbc_case1x0.gridx = 0;
		gbc_case1x0.gridy = 1;
		this.getContentPane().add(case1x0, gbc_case1x0);
		
		JButton case1x1 = new JButton();
		case1x1.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x1 = new GridBagConstraints();
		gbc_case1x1.insets = new Insets(0, 0, 5, 5);
		gbc_case1x1.gridx = 1;
		gbc_case1x1.gridy = 1;
		this.getContentPane().add(case1x1, gbc_case1x1);
		
		JButton case1x2 = new JButton();
		case1x2.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x2 = new GridBagConstraints();
		gbc_case1x2.insets = new Insets(0, 0, 5, 5);
		gbc_case1x2.gridx = 2;
		gbc_case1x2.gridy = 1;
		this.getContentPane().add(case1x2, gbc_case1x2);
		
		JButton case1x3 = new JButton();
		case1x3.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x3 = new GridBagConstraints();
		gbc_case1x3.insets = new Insets(0, 0, 5, 0);
		gbc_case1x3.gridx = 3;
		gbc_case1x3.gridy = 1;
		this.getContentPane().add(case1x3, gbc_case1x3);
		
		JButton case2x0 = new JButton();
		case2x0.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x0 = new GridBagConstraints();
		gbc_case2x0.insets = new Insets(0, 0, 5, 5);
		gbc_case2x0.gridx = 0;
		gbc_case2x0.gridy = 2;
		this.getContentPane().add(case2x0, gbc_case2x0);
		
		JButton case2x1 = new JButton();
		case2x1.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x1 = new GridBagConstraints();
		gbc_case2x1.insets = new Insets(0, 0, 5, 5);
		gbc_case2x1.gridx = 1;
		gbc_case2x1.gridy = 2;
		this.getContentPane().add(case2x1, gbc_case2x1);
		
		JButton case2x2 = new JButton();
		case2x2.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x2 = new GridBagConstraints();
		gbc_case2x2.insets = new Insets(0, 0, 5, 5);
		gbc_case2x2.gridx = 2;
		gbc_case2x2.gridy = 2;
		this.getContentPane().add(case2x2, gbc_case2x2);
		
		JButton case2x3 = new JButton();
		case2x3.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x3 = new GridBagConstraints();
		gbc_case2x3.insets = new Insets(0, 0, 5, 0);
		gbc_case2x3.gridx = 3;
		gbc_case2x3.gridy = 2;
		this.getContentPane().add(case2x3, gbc_case2x3);
		
		JButton case3x0 = new JButton();
		case3x0.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x0 = new GridBagConstraints();
		gbc_case3x0.insets = new Insets(0, 0, 5, 5);
		gbc_case3x0.gridx = 0;
		gbc_case3x0.gridy = 3;
		this.getContentPane().add(case3x0, gbc_case3x0);
		
		JButton case3x1 = new JButton();
		case3x1.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x1 = new GridBagConstraints();
		gbc_case3x1.insets = new Insets(0, 0, 5, 5);
		gbc_case3x1.gridx = 1;
		gbc_case3x1.gridy = 3;
		this.getContentPane().add(case3x1, gbc_case3x1);
		
		JButton case3x2 = new JButton();
		case3x2.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x2 = new GridBagConstraints();
		gbc_case3x2.insets = new Insets(0, 0, 5, 5);
		gbc_case3x2.gridx = 2;
		gbc_case3x2.gridy = 3;
		this.getContentPane().add(case3x2, gbc_case3x2);
		
		JButton case3x3 = new JButton();
		case3x3.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x3 = new GridBagConstraints();
		gbc_case3x3.insets = new Insets(0, 0, 5, 0);
		gbc_case3x3.gridx = 3;
		gbc_case3x3.gridy = 3;
		this.getContentPane().add(case3x3, gbc_case3x3);
		
		JButton case4x1 = new JButton();
		case4x1.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x1 = new GridBagConstraints();
		gbc_case4x1.insets = new Insets(0, 0, 0, 5);
		gbc_case4x1.gridx = 1;
		gbc_case4x1.gridy = 4;
		this.getContentPane().add(case4x1, gbc_case4x1);
		
		JButton case4x2 = new JButton();
		case4x2.setIcon(new ImageIcon(VueCirculaire.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x2 = new GridBagConstraints();
		gbc_case4x2.insets = new Insets(0, 0, 0, 5);
		gbc_case4x2.gridx = 2;
		gbc_case4x2.gridy = 4;
		this.getContentPane().add(case4x2, gbc_case4x2);
		
		this.setVisible(true);
		this.pack();
	}

}

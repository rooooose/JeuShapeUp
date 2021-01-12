package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VueTriangle extends JFrame {

	private JButton case0x0;
	private JButton case1x0;
	private JButton case1x1;
	private JButton case2x0;
	private JButton case2x1;
	private JButton case2x2;
	private JButton case3x0;
	private JButton case3x1;
	private JButton case3x2;
	private JButton case3x3;
	private JButton case4x0;
	private JButton case4x1;
	private JButton case4x2;
	private JButton case4x3;
	private JButton case4x4;
	
	public JButton getCase0x0() {
		return case0x0;
	}

	public JButton getCase1x0() {
		return case1x0;
	}
	
	public JButton getCase1x1() {
		return case1x1;
	}

	public JButton getCase2x0() {
		return case2x0;
	}

	public JButton getCase2x1() {
		return case2x1;
	}

	public JButton getCase2x2() {
		return case2x2;
	}

	public JButton getCase3x0() {
		return case3x0;
	}

	public JButton getCase3x1() {
		return case3x1;
	}

	public JButton getCase3x2() {
		return case3x2;
	}

	public JButton getCase3x3() {
		return case3x3;
	}
	
	public JButton getCase4x0() {
		return case4x0;
	}

	public JButton getCase4x1() {
		return case4x1;
	}

	public JButton getCase4x2() {
		return case4x2;
	}

	public JButton getCase4x3() {
		return case4x3;
	}

	public JButton getCase4x4() {
		return case4x4;
	}
	
	public VueTriangle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		case0x0 = new JButton();
		case0x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x0 = new GridBagConstraints();
		gbc_case0x0.insets = new Insets(0, 0, 5, 5);
		gbc_case0x0.gridx = 0;
		gbc_case0x0.gridy = 0;
		this.getContentPane().add(case0x0, gbc_case0x0);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 0;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 0;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		case1x0 = new JButton();
		case1x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x0 = new GridBagConstraints();
		gbc_case1x0.insets = new Insets(0, 0, 5, 5);
		gbc_case1x0.gridx = 0;
		gbc_case1x0.gridy = 1;
		this.getContentPane().add(case1x0, gbc_case1x0);
		
		case1x1 = new JButton();
		case1x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x1 = new GridBagConstraints();
		gbc_case1x1.insets = new Insets(0, 0, 5, 5);
		gbc_case1x1.gridx = 1;
		gbc_case1x1.gridy = 1;
		this.getContentPane().add(case1x1, gbc_case1x1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 1;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 1;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		case2x0 = new JButton();
		case2x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x0 = new GridBagConstraints();
		gbc_case2x0.insets = new Insets(0, 0, 5, 5);
		gbc_case2x0.gridx = 0;
		gbc_case2x0.gridy = 2;
		this.getContentPane().add(case2x0, gbc_case2x0);
		
		case2x1 = new JButton();
		case2x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x1 = new GridBagConstraints();
		gbc_case2x1.insets = new Insets(0, 0, 5, 5);
		gbc_case2x1.gridx = 1;
		gbc_case2x1.gridy = 2;
		this.getContentPane().add(case2x1, gbc_case2x1);
		
		case2x2 = new JButton();
		case2x2.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x2 = new GridBagConstraints();
		gbc_case2x2.insets = new Insets(0, 0, 5, 5);
		gbc_case2x2.gridx = 2;
		gbc_case2x2.gridy = 2;
		this.getContentPane().add(case2x2, gbc_case2x2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 2;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 4;
		gbc_lblNewLabel_8.gridy = 2;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		case3x0 = new JButton();
		case3x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x0 = new GridBagConstraints();
		gbc_case3x0.insets = new Insets(0, 0, 5, 5);
		gbc_case3x0.gridx = 0;
		gbc_case3x0.gridy = 3;
		this.getContentPane().add(case3x0, gbc_case3x0);
		
		case3x1 = new JButton();
		case3x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x1 = new GridBagConstraints();
		gbc_case3x1.insets = new Insets(0, 0, 5, 5);
		gbc_case3x1.gridx = 1;
		gbc_case3x1.gridy = 3;
		this.getContentPane().add(case3x1, gbc_case3x1);
		
		case3x2 = new JButton();
		case3x2.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x2 = new GridBagConstraints();
		gbc_case3x2.insets = new Insets(0, 0, 5, 5);
		gbc_case3x2.gridx = 2;
		gbc_case3x2.gridy = 3;
		this.getContentPane().add(case3x2, gbc_case3x2);
		
		case3x3 = new JButton();
		case3x3.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x3 = new GridBagConstraints();
		gbc_case3x3.insets = new Insets(0, 0, 5, 5);
		gbc_case3x3.gridx = 3;
		gbc_case3x3.gridy = 3;
		this.getContentPane().add(case3x3, gbc_case3x3);
		
		JLabel lblNewLabel_9 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 3;
		getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		case4x0 = new JButton();
		case4x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x0 = new GridBagConstraints();
		gbc_case4x0.insets = new Insets(0, 0, 0, 5);
		gbc_case4x0.gridx = 0;
		gbc_case4x0.gridy = 4;
		this.getContentPane().add(case4x0, gbc_case4x0);
		
		case4x1 = new JButton();
		case4x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x1 = new GridBagConstraints();
		gbc_case4x1.insets = new Insets(0, 0, 0, 5);
		gbc_case4x1.gridx = 1;
		gbc_case4x1.gridy = 4;
		this.getContentPane().add(case4x1, gbc_case4x1);
		
		case4x2 = new JButton();
		case4x2.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x2 = new GridBagConstraints();
		gbc_case4x2.insets = new Insets(0, 0, 0, 5);
		gbc_case4x2.gridx = 2;
		gbc_case4x2.gridy = 4;
		this.getContentPane().add(case4x2, gbc_case4x2);
		
		case4x3 = new JButton();
		case4x3.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x3 = new GridBagConstraints();
		gbc_case4x3.insets = new Insets(0, 0, 0, 5);
		gbc_case4x3.gridx = 3;
		gbc_case4x3.gridy = 4;
		this.getContentPane().add(case4x3, gbc_case4x3);
		
		case4x4 = new JButton();
		case4x4.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x4 = new GridBagConstraints();
		gbc_case4x4.gridx = 4;
		gbc_case4x4.gridy = 4;
		this.getContentPane().add(case4x4, gbc_case4x4);
		
		this.setVisible(true);
		this.pack();
	}

}

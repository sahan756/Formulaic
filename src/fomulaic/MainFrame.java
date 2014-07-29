package fomulaic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Component;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.logging.Level;

import javax.swing.AbstractListModel;
import javax.swing.DropMode;



public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JFrame frame;
	 File file;
	
	JList list_1;
    DefaultListModel listModel;
    JScrollPane pane;
	
	JButton button_1 = new JButton("1");
	JButton button_2 = new JButton("2");
	JButton button_3 = new JButton("3");
	JButton button_4 = new JButton("4");
	JButton button_5 = new JButton("5");
	JButton button_6 = new JButton("6");
	JButton button_7 = new JButton("7");
	JButton button_8 = new JButton("8");
	JButton button_9 = new JButton("9");
	JButton button_0 = new JButton("0");
	JButton button_  = new JButton(".");
	JButton button_eq= new JButton("=");
	JButton button_sin = new JButton("Sin");
	JButton button_Cos = new JButton("cos");
	JButton button_Tan = new JButton("tan");	
	JButton button_plus = new JButton("+");
	JButton button_minus = new JButton("-");	
	JButton button_mul = new JButton("*");
	JButton button_dev = new JButton("/");
	JButton button_opBr = new JButton("(");
	JButton button_cloBr = new JButton(")");
	JButton button_power = new JButton("^");
	JButton btnX = new JButton("X");
	JButton btnA = new JButton("A");
	JButton btnY = new JButton("Y");
	JButton btnB = new JButton("B");
	JButton btnZ = new JButton("Z");
	JButton btnC = new JButton("C");
	JButton btnI = new JButton("I");
	JButton btnJ = new JButton("J");
	JButton btnK = new JButton("K");
	JButton btnL = new JButton("L");
	JButton btnM = new JButton("M");
	JButton btnN = new JButton("N");	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		try {	
            // UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");      
         //   UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");   
         //   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	
		
            new MainWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
		    EventQueue.invokeLater(new Runnable() {
			public void run() {				
					MainFrame frame = new MainFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Fromulaic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 337, 112);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFormula = new JLabel("Formula ");
		lblFormula.setForeground(Color.YELLOW);
		lblFormula.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblFormula.setBounds(10, 14, 54, 14);
		panel.add(lblFormula);
		
		JLabel lblResult = new JLabel("Result ");
		lblResult.setForeground(Color.YELLOW);
		lblResult.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblResult.setBounds(10, 44, 54, 14);
		panel.add(lblResult);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(61, 39, 266, 27);
		panel.add(textField_1);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnLoad.setBounds(115, 77, 64, 23);
		panel.add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnSave.setBounds(189, 77, 64, 23);
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnClear.setBounds(263, 77, 64, 23);
		panel.add(btnClear);
		
		JButton btnEvaluate = new JButton("Evaluate");
		btnEvaluate.setForeground(Color.RED);
		btnEvaluate.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnEvaluate.setBounds(20, 77, 85, 23);
		panel.add(btnEvaluate);
		textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		
		textArea.setBounds(61, 10, 266, 27);
		textArea.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 238, 337, 243);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
				
		button_7.addActionListener(this);
		button_7.setBounds(10, 11, 41, 25);
		panel_1.add(button_7);
				
		button_8.addActionListener(this);
		button_8.setBounds(61, 11, 41, 25);
		panel_1.add(button_8);
		
		button_9.addActionListener(this);
		button_9.setBounds(112, 11, 41, 25);
		panel_1.add(button_9);
		
		button_4.addActionListener(this);
		button_4.setBounds(10, 47, 41, 25);
		panel_1.add(button_4);
		
		button_5.addActionListener(this);
		button_5.setBounds(61, 47, 41, 25);
		panel_1.add(button_5);
		
		button_6.addActionListener(this);
		button_6.setBounds(112, 47, 41, 25);
		panel_1.add(button_6);
		
		button_1.addActionListener(this);
		button_1.setBounds(10, 83, 41, 25);
		panel_1.add(button_1);
		
		button_2.addActionListener(this);
		button_2.setBounds(61, 83, 41, 25);
		panel_1.add(button_2);
		
		button_3.addActionListener(this);
		button_3.setBounds(112, 83, 41, 25);
		panel_1.add(button_3);
		
		button_0.addActionListener(this);
		button_0.setBounds(10, 119, 41, 25);
		panel_1.add(button_0);
			
		button_.addActionListener(this);
		button_.setBounds(61, 119, 41, 25);
		panel_1.add(button_);
		
		button_eq.addActionListener(this);
		button_eq.setBounds(112, 119, 41, 25);
		panel_1.add(button_eq);
		
		button_sin.addActionListener(this);
		button_sin.setBounds(170, 12, 55, 23);
		panel_1.add(button_sin);
		
		button_Cos.addActionListener(this);
		button_Cos.setBounds(170, 48, 55, 23);
		panel_1.add(button_Cos);
		
		button_Tan.addActionListener(this);
		button_Tan.setBounds(170, 84, 55, 23);
		panel_1.add(button_Tan);
		
		button_plus.addActionListener(this);
		button_plus.setBounds(235, 12, 41, 25);
		panel_1.add(button_plus);
		
		button_minus.addActionListener(this);
		button_minus.setBounds(286, 12, 41, 25);
		panel_1.add(button_minus);
		
		button_mul.addActionListener(this);
		button_mul.setBounds(235, 48, 41, 25);
		panel_1.add(button_mul);
		
		button_dev.addActionListener(this);
		button_dev.setBounds(286, 48, 41, 25);
		panel_1.add(button_dev);
		
		button_opBr.addActionListener(this);
		button_opBr.setBounds(235, 84, 41, 25);
		panel_1.add(button_opBr);
		
		button_cloBr.addActionListener(this);
		button_cloBr.setBounds(286, 84, 41, 25);
		panel_1.add(button_cloBr);
		
		button_power.addActionListener(this);
		button_power.setBounds(170, 120, 55, 23);
		panel_1.add(button_power);
		
		btnX.addActionListener(this);
		btnX.setPreferredSize(new Dimension(45, 23));
		btnX.setBounds(10, 172, 45, 25);
		panel_1.add(btnX);
		
		btnA.addActionListener(this);
		btnA.setBounds(10, 208, 45, 25);
		panel_1.add(btnA);
		
		btnY.addActionListener(this);
		btnY.setPreferredSize(new Dimension(45, 23));
		btnY.setBounds(61, 173, 45, 25);
		panel_1.add(btnY);
		
		btnB.addActionListener(this);
		btnB.setPreferredSize(new Dimension(45, 23));
		btnB.setBounds(61, 209, 45, 25);
		panel_1.add(btnB);
		
		btnZ.addActionListener(this);
		btnZ.setPreferredSize(new Dimension(45, 23));
		btnZ.setBounds(112, 173, 45, 25);
		panel_1.add(btnZ);
		
		btnC.addActionListener(this);
		btnC.setPreferredSize(new Dimension(45, 23));
		btnC.setBounds(112, 209, 45, 25);
		panel_1.add(btnC);
		
		btnI.addActionListener(this);
		btnI.setBounds(184, 172, 45, 25);
		panel_1.add(btnI);
		
		btnJ.addActionListener(this);
		btnJ.setBounds(235, 172, 45, 25);
		panel_1.add(btnJ);
		
		btnK.addActionListener(this);
		btnK.setBounds(286, 172, 45, 25);
		panel_1.add(btnK);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBounds(10, 155, 317, 6);
		panel_1.add(separator);
		
		btnL.addActionListener(this);
		btnL.setBounds(184, 209, 45, 25);
		panel_1.add(btnL);
		
		btnM.addActionListener(this);
		btnM.setBounds(235, 209, 45, 25);
		panel_1.add(btnM);
		
		btnN.addActionListener(this);
		btnN.setBounds(286, 209, 45, 25);
		panel_1.add(btnN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(357, 11, 297, 112);
		panel_2.setName("");
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFormulaList = new JLabel("Formula List");
		lblFormulaList.setForeground(Color.YELLOW);
		lblFormulaList.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 11));
		lblFormulaList.setBounds(10, 0, 70, 19);
		panel_2.add(lblFormulaList);
		
		listModel = new DefaultListModel();
		list_1 = new JList(listModel);
		 pane = new JScrollPane(list_1);
		 pane.setViewportView(list_1);
        listModel.addElement("3X + 2Y");
        listModel.addElement("4Y - 52");
        listModel.addElement("5k -20 + C");
		
		
	/*	list_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_1.setSelectedIndex(0);
      //  list_1.addListSelectionListener((ListSelectionListener) this);
        list_1.setVisibleRowCount(5);
		list_1.setBounds(41, 97, 114, -60);*/
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(189, 11, 98, 90);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(10, 67, 78, 23);
		panel_6.add(btnEdit);
		
		JButton btnUse = new JButton("Use");
		btnUse.setBounds(10, 33, 78, 23);
		panel_6.add(btnUse);
		
			JButton btnNew = new JButton("New");
			btnNew.setBounds(10, -1, 78, 23);
			panel_6.add(btnNew);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(10, 21, 180, 80);
			panel_2.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			panel_7.add(pane);

 
   /*     //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
		
	/*	JList list = new JList();
		list.setDropMode(DropMode.ON);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"formula1", "formula2", "formula3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(24, 95, 142, -70);
		panel_2.add(list);
	*/	
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(357, 238, 297, 243);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblX = new JLabel("X = ");
		lblX.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblX.setBounds(28, 14, 33, 14);
		panel_3.add(lblX);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 11, 45, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblY = new JLabel("Y = ");
		lblY.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblY.setBounds(28, 53, 33, 14);
		panel_3.add(lblY);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 50, 45, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblZ = new JLabel("Z = ");
		lblZ.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblZ.setBounds(28, 89, 33, 14);
		panel_3.add(lblZ);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(74, 86, 45, 20);
		panel_3.add(textField_4);
		
		JLabel lblA = new JLabel("A = ");
		lblA.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblA.setBounds(28, 140, 33, 14);
		panel_3.add(lblA);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(74, 137, 45, 20);
		panel_3.add(textField_5);
		
		JLabel lblC = new JLabel("C =");
		lblC.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblC.setBounds(28, 221, 33, 14);
		panel_3.add(lblC);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(74, 215, 45, 20);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(74, 177, 45, 20);
		panel_3.add(textField_7);
		
		JLabel lblB = new JLabel("B =");
		lblB.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblB.setBounds(28, 180, 33, 14);
		panel_3.add(lblB);
		
		JLabel lblI = new JLabel("I = ");
		lblI.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblI.setBounds(173, 11, 36, 14);
		panel_3.add(lblI);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(219, 8, 45, 20);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(219, 47, 45, 20);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(219, 83, 45, 20);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(219, 134, 45, 20);
		panel_3.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(219, 174, 45, 20);
		panel_3.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(219, 212, 45, 20);
		panel_3.add(textField_13);
		
		JLabel lblJ = new JLabel("J = ");
		lblJ.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblJ.setBounds(173, 50, 36, 14);
		panel_3.add(lblJ);
		
		JLabel lblK = new JLabel("K = ");
		lblK.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblK.setBounds(173, 86, 36, 14);
		panel_3.add(lblK);
		
		JLabel lblL = new JLabel("L = ");
		lblL.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblL.setBounds(173, 137, 36, 14);
		panel_3.add(lblL);
		
		JLabel lblM = new JLabel("M = ");
		lblM.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblM.setBounds(173, 177, 36, 14);
		panel_3.add(lblM);
		
		JLabel lblN = new JLabel("N = ");
		lblN.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblN.setBounds(173, 218, 36, 14);
		panel_3.add(lblN);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 134, 337, 99);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textField_15 = new JTextField();
		textField_15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_15.setBounds(132, 36, 195, 20);
		textField_15.setColumns(10);
		panel_4.add(textField_15);
		
		textField_14 = new JTextField();
		textField_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_14.setBounds(132, 67, 195, 20);
		panel_4.add(textField_14);
		textField_14.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_16.setColumns(10);
		textField_16.setBounds(132, 11, 195, 20);
		panel_4.add(textField_16);
		
		JLabel lblNdDerivative = new JLabel("2 nd Derivative");
		lblNdDerivative.setForeground(Color.ORANGE);
		lblNdDerivative.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblNdDerivative.setBounds(10, 39, 112, 14);
		panel_4.add(lblNdDerivative);
		
		JLabel lblSymbolicDifferentiation = new JLabel("Symbolic Differentiation");
		lblSymbolicDifferentiation.setForeground(Color.ORANGE);
		lblSymbolicDifferentiation.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblSymbolicDifferentiation.setBounds(10, 70, 127, 14);
		panel_4.add(lblSymbolicDifferentiation);
		
		JLabel lblStDerivative = new JLabel("1 st Derivative");
		lblStDerivative.setForeground(Color.ORANGE);
		lblStDerivative.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblStDerivative.setBounds(10, 14, 112, 14);
		panel_4.add(lblStDerivative);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(357, 134, 297, 99);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JCheckBox chckbxFromula = new JCheckBox("Fromula");
		chckbxFromula.setForeground(Color.ORANGE);
		chckbxFromula.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		chckbxFromula.setVerticalTextPosition(SwingConstants.BOTTOM);
		chckbxFromula.setVerticalAlignment(SwingConstants.BOTTOM);
		chckbxFromula.setBounds(168, 7, 110, 23);
		panel_5.add(chckbxFromula);
		
		JCheckBox chckbxStDerivative = new JCheckBox("1 st Derivative");
		chckbxStDerivative.setForeground(Color.ORANGE);
		chckbxStDerivative.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		chckbxStDerivative.setBounds(6, 8, 147, 23);
		panel_5.add(chckbxStDerivative);
		
		JCheckBox chckbxNdDerivative = new JCheckBox("2 nd Derivative");
		chckbxNdDerivative.setForeground(Color.ORANGE);
		chckbxNdDerivative.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		chckbxNdDerivative.setBounds(6, 34, 147, 23);
		panel_5.add(chckbxNdDerivative);
		
		JButton btnDrawGraph = new JButton("Draw Graph");
		btnDrawGraph.setForeground(new Color(255, 0, 0));
		btnDrawGraph.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnDrawGraph.setBounds(6, 65, 110, 23);
		panel_5.add(btnDrawGraph);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnSave_1.setBounds(138, 64, 63, 23);
		panel_5.add(btnSave_1);
		
		JButton btnLoad_1 = new JButton("Load");
		btnLoad_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnLoad_1.setBounds(215, 65, 63, 23);
		panel_5.add(btnLoad_1);
	
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser(); 
	            int returnVal = fc.showOpenDialog(frame);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = fc.getSelectedFile();
	                FileReader reader;
	                System.out.println(textArea.getText());
					try {
						String text;
						reader = new FileReader(file);
						BufferedReader br = new BufferedReader(reader);
						while ((text = br.readLine()) != null){
							textArea.append(text);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
	            } 
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				JFileChooser fileChooser = new JFileChooser();
		    //    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Plain Text File", "txt"));
		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML Text File", "XML"));
		        fileChooser.setAcceptAllFileFilterUsed(true);
		        int result = fileChooser.showSaveDialog(frame);
		        if (result != JFileChooser.APPROVE_OPTION) {
		           return ;
		        }
		        
		 //       File fn = new File(fileChooser.getSelectedFile() + ".txt");
		        File fn1 = new File(fileChooser.getSelectedFile() + ".xml");
		        
		        XMLEncoder en = null;
				try {
					en = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fn1)));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                en.writeObject(textArea);
                en.close();
		        
     /*   BufferedWriter bw = null;
		        try {
		        	
		           bw = new BufferedWriter(new FileWriter(fn));
		           bw = new BufferedWriter(new FileWriter(fn1));
		           textArea.write(bw); 

		        } catch (IOException ex) {
		               ex.printStackTrace();
		        } finally {
		           if (bw != null) {
		              try {
		                 bw.close();
		              } catch (IOException ex) {}
		           }
		        }*/
		      } 
		});

	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == button_0){
			textArea.append("0");
		}
		if(source == button_1){
			textArea.append("1");
		}
		if(source == button_2){
			textArea.append("2");
		}
		if(source == button_3){
			textArea.append("3");
		}
		if(source == button_4){
			textArea.append("4");
		}
		if(source == button_5){
			textArea.append("5");
		}
		if(source == button_6){
			textArea.append("6");
		}
		if(source == button_7){
			textArea.append("7");
		}
		if(source == button_8){
			textArea.append("8");
		}
		if(source == button_9){
			textArea.append("9");
		}
		if(source == button_){
			textArea.append(".");
		}
		if(source == button_eq){
			textArea.append("=");
		}
		if(source == button_sin){
			textArea.append("sin");
		}
		if(source == button_Cos){
			textArea.append("cos");
		}
		if(source == button_Tan){
			textArea.append("tan");
		}
		if(source == button_minus){
			textArea.append("-");
		}
		if(source == button_mul){
			textArea.append("*");
		}
		if(source == button_dev){
			textArea.append("/");
		}
		if(source == button_opBr){
			textArea.append("(");
		}
		if(source == button_cloBr){
			textArea.append(")");
		}
		if(source == button_power){
			textArea.append("^");
		}
		if(source == button_plus){
			textArea.append("+");
		}
		if(source == btnA){
			textArea.append("A");
		}
		if(source == btnB){
			textArea.append("B");
		}
		if(source == btnC){
			textArea.append("C");
		}
		if(source == btnX){
			textArea.append("X");
		}
		if(source == btnY){
			textArea.append("Y");
		}
		if(source == btnZ){
			textArea.append("Z");
		}
		if(source == btnI){
			textArea.append("I");
		}
		if(source == btnJ){
			textArea.append("J");
		}
		if(source == btnK){
			textArea.append("K");
		}
		if(source == btnL){
			textArea.append("L");
		}
		if(source == btnM){
			textArea.append("M");
		}
		if(source == btnN){
			textArea.append("N");
		}
		
	}
}

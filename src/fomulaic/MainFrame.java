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
import java.awt.event.KeyListener;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import javax.swing.AbstractListModel;
import javax.swing.DropMode;

import au.com.bytecode.opencsv.CSVWriter;
import controllers.MainFrameController;
import formulator.ComplexFormulaElement;
import formulator.FormulaElement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




public class MainFrame extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField x_assign;
	private JTextField y_assign;
	private JTextField z_assign;
	private JTextField a_assign;
	private JTextField c_assign;
	private JTextField b_assign;
	private JTextField i_assign;
	private JTextField j_assign;
	private JTextField k_assign;
	private JTextField l_assign;
	private JTextField m_assign;
	private JTextField n_assign;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JFrame frame;
	 File file;
	
	JList<String> list_1;
    DefaultListModel<String> listModel;
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
	
	MainFrameController controller;
	JTextField textArea;
	
    static Map<Double,Double> myMap = new HashMap<Double,Double>();	
    static ArrayList<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
    static HashMap<String, String> map;
    
    FormulaElement selectedElement;
    String formulaName;
    
    public void setSelectedElement(String name, FormulaElement elem){
    	this.formulaName = name;
    	this.selectedElement = elem;
    }
	
	//Allow acces textArea to the controller
//	public JTextField getTextArea() {
//		return textArea;
//	}
//	
//	public JTextField getResultField(){
//		return textField_1;
//	}
//	
//	public DefaultListModel<String> getFormulaListModel(){
//		return listModel;
//	}
	
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
		
//		//set controller
//		controller = new MainFrameController(this);
		//set controller
      	controller = new MainFrameController();
        
      	
		setTitle("Fromulaic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 337, 119);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFormula = new JLabel("Formula ");
		lblFormula.setForeground(Color.YELLOW);
		lblFormula.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblFormula.setBounds(10, 14, 64, 14);
		panel.add(lblFormula);
		
		JLabel lblResult = new JLabel("Result ");
		lblResult.setForeground(Color.YELLOW);
		lblResult.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblResult.setBounds(10, 44, 54, 14);
		panel.add(lblResult);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(81, 39, 246, 27);
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
		btnClear.setActionCommand(KeyValues.COMMAND_CLEAR_BOX);
		btnClear.addActionListener(controller);
		
		JButton btnEvaluate = new JButton("Evaluate");
		btnEvaluate.setForeground(Color.RED);
		btnEvaluate.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnEvaluate.setBounds(20, 77, 85, 23);
		panel.add(btnEvaluate);
		
		btnEvaluate.setActionCommand(KeyValues.COMMAND_EVAL_INPUT);
		btnEvaluate.addActionListener(controller);
		
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
		button_power.setBounds(170, 84, 55, 23);
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
		panel_2.setBounds(357, 11, 297, 119);
		panel_2.setName("");
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFormulaList = new JLabel("Formula List");
		lblFormulaList.setForeground(Color.YELLOW);
		lblFormulaList.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 11));
		lblFormulaList.setBounds(10, 0, 70, 19);
		panel_2.add(lblFormulaList);
		
		listModel = new DefaultListModel<String>();
		list_1 = new JList<String>(listModel);
		list_1.setVisibleRowCount(5);
		 pane = new JScrollPane(list_1);
		 pane.setViewportView(list_1);
		 
		 controller.setFormulaJList(list_1);
		 controller.setFomulaListModel(listModel);
		 
//        listModel.addElement("3X + 2Y");
//        listModel.addElement("4Y - 52");
//        listModel.addElement("5k -20 + C");
//        listModel.addElement("5k -20 + C");
//        listModel.addElement("5k -20 + C");
//        listModel.addElement("5k -20 + C");
//        listModel.addElement("5k -20 + C");
//        listModel.addElement("5k -20 + C");
//        listModel.addElement("5k -20 + C");

        
      
	/*	list_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_1.setSelectedIndex(0);
      //  list_1.addListSelectionListener((ListSelectionListener) this);
        list_1.setVisibleRowCount(5);
		list_1.setBounds(41, 97, 114, -60);*/
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(160, 26, 127, 68);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(0, 0, 127, 68);
		panel_6.add(scrollPane);
		
		DefaultListModel<String> commandListModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(commandListModel);
		scrollPane.setViewportView(list);
		
		controller.setCommandJList(list);
		controller.setCommandListModel(commandListModel);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(10, 26, 140, 68);
			panel_2.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			panel_7.add(pane);
			
			JButton btnUse = new JButton("Use");
			btnUse.setBounds(10, 95, 63, 20);
			panel_2.add(btnUse);
			
			btnUse.setActionCommand(KeyValues.COMMAND_USE_FORMULA);
			
			JLabel lblOperationHistory = new JLabel("Command list");
			lblOperationHistory.setForeground(Color.YELLOW);
			lblOperationHistory.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 11));
			lblOperationHistory.setBounds(160, 0, 127, 19);
			panel_2.add(lblOperationHistory);
			
			JButton btn_use_cmd = new JButton("Use");
			btn_use_cmd.setActionCommand(KeyValues.COMMAND_USE_COMMAND);
			btn_use_cmd.setBounds(224, 95, 63, 20);
			panel_2.add(btn_use_cmd);
			btnUse.addActionListener(controller);

 
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
		
		x_assign = new JTextField();
		x_assign.setBounds(74, 11, 45, 20);
		panel_3.add(x_assign);
		x_assign.setColumns(10);
		x_assign.addKeyListener(this);
		
		JLabel lblY = new JLabel("Y = ");
		lblY.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblY.setBounds(28, 53, 33, 14);
		panel_3.add(lblY);
		
		y_assign = new JTextField();
		y_assign.addKeyListener(this);
		y_assign.setBounds(74, 50, 45, 20);
		panel_3.add(y_assign);
		y_assign.setColumns(10);
		
		JLabel lblZ = new JLabel("Z = ");
		lblZ.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblZ.setBounds(28, 89, 33, 14);
		panel_3.add(lblZ);
		
		z_assign = new JTextField();
		z_assign.addKeyListener(this);
		z_assign.setColumns(10);
		z_assign.setBounds(74, 86, 45, 20);
		panel_3.add(z_assign);
		
		JLabel lblA = new JLabel("A = ");
		lblA.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblA.setBounds(28, 140, 33, 14);
		panel_3.add(lblA);
		
		a_assign = new JTextField();
		a_assign.addKeyListener(this);
		a_assign.setColumns(10);
		a_assign.setBounds(74, 137, 45, 20);
		panel_3.add(a_assign);
		
		JLabel lblC = new JLabel("C =");
		lblC.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblC.setBounds(28, 221, 33, 14);
		panel_3.add(lblC);
		
		c_assign = new JTextField();
		c_assign.addKeyListener(this);
		c_assign.setColumns(10);
		c_assign.setBounds(74, 215, 45, 20);
		panel_3.add(c_assign);
		
		b_assign = new JTextField();
		b_assign.addKeyListener(this);
		b_assign.setColumns(10);
		b_assign.setBounds(74, 177, 45, 20);
		panel_3.add(b_assign);
		
		JLabel lblB = new JLabel("B =");
		lblB.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblB.setBounds(28, 180, 33, 14);
		panel_3.add(lblB);
		
		JLabel lblI = new JLabel("I = ");
		lblI.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblI.setBounds(173, 11, 36, 14);
		panel_3.add(lblI);
		
		i_assign = new JTextField();
		i_assign.addKeyListener(this);
		i_assign.setColumns(10);
		i_assign.setBounds(219, 8, 45, 20);
		panel_3.add(i_assign);
		
		j_assign = new JTextField();
		j_assign.addKeyListener(this);
		j_assign.setColumns(10);
		j_assign.setBounds(219, 47, 45, 20);
		panel_3.add(j_assign);
		
		k_assign = new JTextField();
		k_assign.addKeyListener(this);
		k_assign.setColumns(10);
		k_assign.setBounds(219, 83, 45, 20);
		panel_3.add(k_assign);
		
		l_assign = new JTextField();
		l_assign.addKeyListener(this);
		l_assign.setColumns(10);
		l_assign.setBounds(219, 134, 45, 20);
		panel_3.add(l_assign);
		
		m_assign = new JTextField();
		m_assign.addKeyListener(this);
		m_assign.setColumns(10);
		m_assign.setBounds(219, 174, 45, 20);
		panel_3.add(m_assign);
		
		n_assign = new JTextField();
		n_assign.addKeyListener(this);
		n_assign.setColumns(10);
		n_assign.setBounds(219, 212, 45, 20);
		panel_3.add(n_assign);
		
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
		textField_15.setBounds(142, 36, 185, 20);
		textField_15.setColumns(10);
		panel_4.add(textField_15);
		
		textField_14 = new JTextField();
		textField_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_14.setBounds(142, 67, 185, 20);
		panel_4.add(textField_14);
		textField_14.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_16.setColumns(10);
		textField_16.setBounds(142, 11, 185, 20);
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
		chckbxStDerivative.setBounds(6, 8, 130, 23);
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
		
		
		
	
		btnLoad.setActionCommand(KeyValues.COMMAND_LOAD_FORMULA);
		btnLoad.addActionListener(controller);
//		btnLoad.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				final JFileChooser fc = new JFileChooser(); 
//	            int returnVal = fc.showOpenDialog(frame);
//	            if (returnVal == JFileChooser.APPROVE_OPTION) {
//	                file = fc.getSelectedFile();
//	                FileReader reader;
//	                System.out.println(textArea.getText());
//					try {
//						String text;
//						reader = new FileReader(file);
//						BufferedReader br = new BufferedReader(reader);
//						while ((text = br.readLine()) != null){
//							textArea.append(text);
//						}
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//	            } 
//			}
//		});
		
		
		
		textArea = new JTextField();
		textArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textArea.setBounds(81, 7, 246, 28);
		panel.add(textArea);
		textArea.setColumns(10);
		
		textArea.addActionListener(controller);
		//textArea.setActionCommand(KeyValues.COMMAND_EVAL_INPUT);
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					for(ActionListener a: textArea.getActionListeners()) {
					    a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, KeyValues.COMMAND_EVAL_INPUT) {
					          //Nothing need go here, the actionPerformed method (with the
					          //above arguments) will trigger the respective listener
					    });
					}
				}
			}
		});
		

//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {	
//				JFileChooser fileChooser = new JFileChooser();
//		    //    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Plain Text File", "txt"));
//		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML Text File", "XML"));
//		        fileChooser.setAcceptAllFileFilterUsed(true);
//		        int result = fileChooser.showSaveDialog(frame);
//		        if (result != JFileChooser.APPROVE_OPTION) {
//		           return ;
//		        }
//		        
//		 //       File fn = new File(fileChooser.getSelectedFile() + ".txt");
//		        File fn1 = new File(fileChooser.getSelectedFile() + ".xml");
//		        
//		        XMLEncoder en = null;
//				try {
//					en = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fn1)));
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//                en.writeObject(textArea);
//                en.close();
		        
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
//		      } 
//		});


		btnSave.setActionCommand(KeyValues.COMMAND_SAVE_FORMULA);
		btnSave.addActionListener(controller);
		
		//add components to controller
		controller.setMainFrame(this);
		controller.setResultField(textField_1);
		controller.setTextArea(textArea);
		
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {	
//				JFileChooser fileChooser = new JFileChooser();
//		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Plain Text File", "txt"));
//		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML Text File", "XML"));
//		        fileChooser.setAcceptAllFileFilterUsed(true);
//		        int result = fileChooser.showSaveDialog(frame);
//		        if (result != JFileChooser.APPROVE_OPTION) {
//		           return ;
//		        }
//		        
//		        File fn = new File(fileChooser.getSelectedFile() + ".txt");
//		        File fn1 = new File(fileChooser.getSelectedFile() + ".xml");
//		        BufferedWriter bw = null;
//		        try {
//		        	
//		           bw = new BufferedWriter(new FileWriter(fn));
//		           bw = new BufferedWriter(new FileWriter(fn1));
//		           textArea.write(bw); 
//
//		        } catch (IOException ex) {
//		               ex.printStackTrace();
//		        } finally {
//		           if (bw != null) {
//		              try {
//		                 bw.close();
//		              } catch (IOException ex) {}
//		           }
//		        }
//		      } 
//		});
		
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {	
//				JFileChooser fileChooser = new JFileChooser();
//		    //    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Plain Text File", "txt"));
//		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML Text File", "XML"));
//		        fileChooser.setAcceptAllFileFilterUsed(true);
//		        int result = fileChooser.showSaveDialog(frame);
//		        if (result != JFileChooser.APPROVE_OPTION) {
//		           return ;
//		        }
//		        
//		 //       File fn = new File(fileChooser.getSelectedFile() + ".txt");
//		        File fn1 = new File(fileChooser.getSelectedFile() + ".xml");
//		        
//		        XMLEncoder en = null;
//				try {
//					en = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fn1)));
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//                en.writeObject(textArea);
//                en.close();
//		        
//     /*   BufferedWriter bw = null;
//		        try {
//		        	
//		           bw = new BufferedWriter(new FileWriter(fn));
//		           bw = new BufferedWriter(new FileWriter(fn1));
//		           textArea.write(bw); 
//
//		        } catch (IOException ex) {
//		               ex.printStackTrace();
//		        } finally {
//		           if (bw != null) {
//		              try {
//		                 bw.close();
//		              } catch (IOException ex) {}
//		           }
//		        }*/
//		      } 
//		});
//
//
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Comma Seperated File", "XML"));
		        fileChooser.setAcceptAllFileFilterUsed(true);
		        int result = fileChooser.showSaveDialog(frame);
		        if (result != JFileChooser.APPROVE_OPTION) {
		           return ;
		        }
				
		        File fn = new File(fileChooser.getSelectedFile() + ".csv");
				Iterator<Entry<Double, Double>> iter = myMap.entrySet().iterator();
				CSVWriter writer = null;
				try {
					writer = new CSVWriter(new FileWriter(fn));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				        writer.writeNext("X" , "Y");
					while (iter.hasNext()) {
						Map.Entry mEntry = (Map.Entry) iter.next();
						System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
						writer.writeNext(mEntry.getKey().toString() , mEntry.getValue().toString());
						
					}	
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    /*    BufferedWriter bw;
						try {
							//bw = new BufferedWriter(new FileWriter(fn));
							CSVWriter writer = new CSVWriter(new FileWriter(fn));
							writer.writeNext(myMap.toString());
							writer.close();
							for(int i=0; i < myArrList.size();i++){
								
								
								bw.write(",");
								bw.write(myArrList.get(i).get("y").toString());
								bw.write("\r\n");
								System.out.println(myArrList.get(i));
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					

				/*writer.writeNext(country);
				writer.close();*/
				
			}

			
		});
		
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == button_0){
			//textArea.append("0");
			textArea.setText(textArea.getText()+"0");
		}
		if(source == button_1){
			//textArea.append("1");
			textArea.setText(textArea.getText()+"1");
		}
		if(source == button_2){
			//textArea.append("2");
			textArea.setText(textArea.getText()+"2");
		}
		if(source == button_3){
			//textArea.append("3");
			textArea.setText(textArea.getText()+"3");
		}
		if(source == button_4){
			//textArea.append("4");
			textArea.setText(textArea.getText()+"4");
		}
		if(source == button_5){
			//textArea.append("5");
			textArea.setText(textArea.getText()+"5");
		}
		if(source == button_6){
			//textArea.append("6");
			textArea.setText(textArea.getText()+"6");
		}
		if(source == button_7){
			//textArea.append("7");
			textArea.setText(textArea.getText()+"7");
		}
		if(source == button_8){
			//textArea.append("8");
			textArea.setText(textArea.getText()+"8");
		}
		if(source == button_9){
			//textArea.append("9");
			textArea.setText(textArea.getText()+"9");
		}
		if(source == button_){
			//textArea.append(".");
			textArea.setText(textArea.getText()+".");
		}
		if(source == button_eq){
			//textArea.append("=");
			textArea.setText(textArea.getText()+"=");
		}
		if(source == button_sin){
			//textArea.append("sin");
			textArea.setText(textArea.getText()+"sin");
		}
		if(source == button_Cos){
			//textArea.append("cos");
			textArea.setText(textArea.getText()+"cos");
		}
//		if(source == button_Tan){
//			//textArea.append("tan");
//			textArea.setText(textArea.getText()+"tan");
//		}
		if(source == button_minus){
			//textArea.append("-");
			textArea.setText(textArea.getText()+"-");
		}
		if(source == button_mul){
			//textArea.append("*");
			textArea.setText(textArea.getText()+"*");
		}
		if(source == button_dev){
			//textArea.append("/");
			textArea.setText(textArea.getText()+"/");
		}
		if(source == button_opBr){
			//textArea.append("(");
			textArea.setText(textArea.getText()+"(");
		}
		if(source == button_cloBr){
			//textArea.append(")");
			textArea.setText(textArea.getText()+")");
		}
		if(source == button_power){
			//textArea.append("^");
			textArea.setText(textArea.getText()+"^");
		}
		if(source == button_plus){
			//textArea.append("+");
			textArea.setText(textArea.getText()+"+");
		}
		if(source == btnA){
			//textArea.append("A");
			textArea.setText(textArea.getText()+"A");
		}
		if(source == btnB){
			//textArea.append("B");
			textArea.setText(textArea.getText()+"B");
		}
		if(source == btnC){
			//textArea.append("C");
			textArea.setText(textArea.getText()+"C");
		}
		if(source == btnX){
			//textArea.append("X");
			textArea.setText(textArea.getText()+"X");
		}
		if(source == btnY){
			//textArea.append("Y");
			textArea.setText(textArea.getText()+"Y");
		}
		if(source == btnZ){
			//textArea.append("Z");
			textArea.setText(textArea.getText()+"Z");
		}
		if(source == btnI){
			//textArea.append("I");
			textArea.setText(textArea.getText()+"I");
		}
		if(source == btnJ){
			//textArea.append("J");
			textArea.setText(textArea.getText()+"J");
		}
		if(source == btnK){
			//textArea.append("K");
			textArea.setText(textArea.getText()+"K");
		}
		if(source == btnL){
			//textArea.append("L");
			textArea.setText(textArea.getText()+"L");
		}
		if(source == btnM){
			//textArea.append("M");
			textArea.setText(textArea.getText()+"M");
		}
		if(source == btnN){
			//textArea.append("N");
			textArea.setText(textArea.getText()+"N");
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		Object source = e.getSource();
		//String value = source.
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_ENTER && selectedElement != null){
			
			String command = formulaName + "(?)";
			String value="";
			if(source == x_assign){
				value = "X="+x_assign.getText();
			} else if(source == y_assign){
				value = "Y="+y_assign.getText();
			} else if(source == z_assign){
				value = "Z="+z_assign.getText();
			} else if(source == i_assign){
				value = "I="+i_assign.getText();
			} else if(source == j_assign){
				value = "J="+j_assign.getText();
			} else if(source == k_assign){
				value = "K="+k_assign.getText();
			} else if(source == a_assign){
				value = "A="+a_assign.getText();
			} else if(source == b_assign){
				value = "B="+b_assign.getText();
			} else if(source == c_assign){
				value = "C="+c_assign.getText();
			} else if(source == l_assign){
				value = "L="+l_assign.getText();
			} else if(source == m_assign){
				value = "M="+m_assign.getText();
			} else if(source == n_assign){
				value = "N="+n_assign.getText();
			} 
			
			command = command.replaceAll("\\?", value);
			controller.parseCommand(command);
			//System.out.println(command);
		} 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void toSave(double x, double y) {
 
		myMap.put(x, y);
	/*	String x1 = Double.toString(x);
		String y1 = Double.toString(y);
		
		System.out.println(x1 +","+ y1);
		map = new HashMap<String, String>();
		map.put("x",x1);
		map.put("y",y1);
		myArrList.add(map);*/
		
		
		
		/* Iterator<Entry<Double, Double>> iter = myMap.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry mEntry = (Map.Entry) iter.next();
			System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
		}*/
	}
}

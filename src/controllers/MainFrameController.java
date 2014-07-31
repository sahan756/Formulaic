package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.GraphModel;



import fomulaic.GraphDraw;
import fomulaic.KeyValues;
import fomulaic.MainFrame;
import fomulaic.Storage;
import formulator.ComplexFormulaElement;
import formulator.FormulaElement;
import formulator.VariableElement;

public class MainFrameController implements ActionListener{
	private MainFrame mainFrame;
	
	JTextField textArea;
	JTextField resultField;
	JList<String> formulaJList;
	JList<String> commandJList;
	
	DefaultListModel<String> fomulaListModel;
	DefaultListModel<String> commandListModel;
	ArrayList<GraphModel> graphList;
	
	
	private Storage storage;
	
	public MainFrameController(MainFrame frame){
		this.mainFrame = frame;
//		this.textArea = frame.getTextArea();
//		this.resultField = frame.getResultField();
		this.storage = new Storage();
	}
	
	public MainFrameController(){
//		this.mainFrame = frame;
//		this.textArea = frame.getTextArea();
//		this.resultField = frame.getResultField();
		this.storage = new Storage();
	}
	
	
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setTextArea(JTextField textArea) {
		this.textArea = textArea;
	}

	public void setResultField(JTextField resultField) {
		this.resultField = resultField;
	}

	public void setFomulaListModel(DefaultListModel<String> fomulaListModel) {
		this.fomulaListModel = fomulaListModel;
	}
	

	public void setFormulaJList(JList<String> formulaJList) {
		this.formulaJList = formulaJList;
	}
	
	

	public void setCommandJList(JList<String> commandJList) {
		this.commandJList = commandJList;
	}

	public void setCommandListModel(DefaultListModel<String> commandListModel) {
		this.commandListModel = commandListModel;
	}

	public void onClickAdd(){
		//textArea.setText(FormulaElement.parseFormula(textArea.getText()).toString());
		resultField.setText("");
		//if(parseCommand())
			//textArea.append(textField.getText()+"\n");
		if(parseCommand(textArea.getText())){
			textArea.setText("");
		}
		printStoredFormulas();
		printStoredGraphs();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command == KeyValues.COMMAND_SAVE_FORMULA){
			saveFormulaToFile();
		} else if(command == KeyValues.COMMAND_LOAD_FORMULA){
			loadFormulaFromFile();
		} else if(command == KeyValues.COMMAND_EVAL_INPUT){
			onClickAdd();
		} else if(command == KeyValues.COMMAND_USE_FORMULA){
			useFormula();
		}
	}
	
	private void useFormula(){
		int index = formulaJList.getSelectedIndex();
		String selectedItem = fomulaListModel.get(index);
		String trimmed = selectedItem.replaceAll("\\s", "");
		if(trimmed.matches("^[a-zA-Z]=[^=]+$")){
			String[] comps = trimmed.split("=");
			
			FormulaElement element = storage.getStoredFormulas().get(comps[0]);
			textArea.setText(selectedItem);
			
		}
	}
	
	private void saveFormulaToFile() {
//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
//				"Plain Text File", "txt"));
//		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
//				"XML Text File", "XML"));
//		fileChooser.setAcceptAllFileFilterUsed(true);
//		int result = fileChooser.showSaveDialog(mainFrame);
//		if (result != JFileChooser.APPROVE_OPTION) {
//			return;
//		}
//
//		File fn = new File(fileChooser.getSelectedFile() + ".txt");
//		File fn1 = new File(fileChooser.getSelectedFile() + ".xml");
//		BufferedWriter bw = null;
//		try {
//
//			bw = new BufferedWriter(new FileWriter(fn));
//			bw = new BufferedWriter(new FileWriter(fn1));
//			textArea.write(bw);
//			System.out.println(textArea.getText());
//
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} finally {
//			if (bw != null) {
//				try {
//					bw.close();
//				} catch (IOException ex) {
//				}
//			}
//		}
		
		JFileChooser fileChooser = new JFileChooser();
	    //    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Plain Text File", "txt"));
	        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML Text File", "XML"));
	        fileChooser.setAcceptAllFileFilterUsed(true);
	        int result = fileChooser.showSaveDialog(mainFrame);
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
            en.writeObject(storage.getStoredFormulas().get("f"));
            en.close();
	}
	
	private void loadFormulaFromFile(){
		final JFileChooser fc = new JFileChooser(); 
        int returnVal = fc.showOpenDialog(mainFrame);
        File file;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            FileReader reader;
            System.out.println(textArea.getText());
            BufferedReader br;
			try {
				String text;
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				while ((text = br.readLine()) != null){
					textArea.setText(textArea.getText()+text);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
        } 
	}
	
	private boolean parseCommand(String command){
		
		//String text = textArea.getText();
		String text = command;
		boolean addFormula = false, appendFormula = false, appendValue = false, addToList = false;
		String trimmedText = text.replaceAll("\\s", ""); // Remove all white
															// spaces

		if (trimmedText.matches("^\\w=[^=]+$")) { // check for string with
													// character followed by '='
													// followed by any character
													// or digit other than '='
			String[] comps = text.split("=");
			// FormulaElement formula = FormulaElement.parseFormula(comps[1]);
			comps[0] = comps[0].replaceAll("\\s", "");
			if (storage.getStoredFormulas().containsKey(comps[0])) {
				String message = "There's already a formula assigned to '"
						+ comps[0] + "'.\nWould you like to replace?";
				// Object[] options = {"Yes", "No"};
				int response = JOptionPane.showOptionDialog(mainFrame, message,
						"Formula replace", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (response == JOptionPane.YES_OPTION) {
					addFormula = true;
				}
			} else {
				addFormula = true;
			}

			if (addFormula) {
//				storage.addFormula(comps[0],
//						FormulaElement.parseFormula(comps[1]));
				ComplexFormulaElement formula = new ComplexFormulaElement(comps[0], storage.getStoredFormulas());
				storage.addFormula(comps[0], formula.parseComplexFormula(comps[1]));
				//textArea.append(textArea.getText() + "\n");
				//fomulaListModel.addElement(textArea.getText());
				addToList = true;
				fomulaListModel.addElement(textArea.getText());
				formulaJList.ensureIndexIsVisible(fomulaListModel.size()-1);
			}
		} else if(text.matches("^eval\\s[a-zA-Z]$")){
			String[] comps = text.split("\\s");
			FormulaElement elem = storage.getStoredFormulas().get(comps[1]);
			if (elem != null) {
				if (elem.isFullyGrounded()){
					//textArea.append(comps[1] + " = " + elem.evaluate() + "\n");
					resultField.setText(comps[1] + " = " + elem.evaluate() + "\n");
				}else {
					resultField.setText("Not grounded");
					return false;
				}
			} else {
				resultField.setText("Formula not found");
				return false;
			}
		} else {
			//boolean isGraphMode = false;
			//HashMap<String, GraphModel> graphList = new HashMap<String, GraphModel>();
			int i = 0, action = 0, level = 0;
			if(text.matches("^graph\\s.+$")){
				//isGraphMode = true;
				text = text.split("\\s", 2)[1];
				action = KeyValues.COMMAND_DRAW_GRAPH;
			} else {
				action = KeyValues.COMMAND_SET_VAR_VALUE;
			}
			// new test with tokenizer
			StringTokenizer tokenizer = new StringTokenizer(text, "+-/^()*= ",
					true);
			String prevToken = "", formName = "", formulaText = "", varValueText = "", varName = "", tempVarName ="";
			
			
			while (tokenizer.hasMoreTokens()) {

				String token = tokenizer.nextToken();
				if (token.matches("\\s")) {
					continue;
				}
				i++;
				// if(token.matches("=") && prevToken.matches("\\w") && i==2){
				// formName = prevToken;
				// //FormulaElement formula =
				// FormulaElement.parseFormula(comps[1]);
				// action = KeyValues.COMMAND_ASSIGN_FORMULA;
				// appendFormula = true;
				// } else if(appendFormula) {
				// formulaText += token;
				// }

				if (token.matches("\\(")) {
					level++;
					if (level == 1) {
						if (prevToken.matches("^[a-zA-Z'\"]$")
								&& prevToken.length() == 1
								//&& (i == 2 || i == 3)
								) {
							varName = tempVarName.equals("") ? prevToken : tempVarName;
							tempVarName = "";
							if(storage.getStoredFormulas().containsKey(varName)){
								appendValue = true;
							} else {
								varName = "";
							}
						}
					} else {
						varValueText += token;
					}
				} else if (appendValue) {
					if (token.matches("\\)")) {
						level--;
						if(level == 0){
							addToList = assignVariableValue(varName, varValueText, action);
							appendValue = false;
							varValueText = "";
						} else {
							varValueText += token;
						}
					} else if (token.matches("^[a-zA-Z]$")
							&& varValueText.length() > 0 && !prevToken.matches("=")) {
						addToList = assignVariableValue(varName, varValueText, action);
						// varName = token;
						varValueText = token;
					} else {
						varValueText += token;
					}
				} else if(token.matches("^['\"]$") && prevToken.matches("^[a-zA-Z]$")){
					tempVarName = prevToken;
				}
				prevToken = token;
			}
		}
		
		HashMap<String, GraphModel> graphList = storage.getStoredGraphs();
		boolean graphReady = true;
		for (GraphModel value : graphList.values()) {
		    if(!value.checkGraphDraw()){
		    	resultField.setText("Graph parameters are incorrect");
		    	addToList = false;
		    	graphReady = false;
		    	graphList.clear();
		    }
		}
		
		if(graphReady && graphList.size() > 0){
			new GraphDraw(graphList).showWindow();
			graphList.clear();
		}
		
		
		if(addToList){
//			fomulaListModel.addElement(textArea.getText());
//			formulaJList.ensureIndexIsVisible(fomulaListModel.size()-1);
			commandListModel.addElement(textArea.getText());
			commandJList.ensureIndexIsVisible(commandListModel.size()-1);
		}
		
		return true;
	}
	
	private boolean assignVariableValue(String formName, String valueText, int action){
		try {
			FormulaElement element = storage.getStoredFormulas().get(formName);
			ComplexFormulaElement form= new ComplexFormulaElement(storage.getStoredFormulas());
			if (action == KeyValues.COMMAND_SET_VAR_VALUE) {
				
				//if(valueText.matches("^\\w=[\\d\\.]+$")){
				if (valueText.matches("^\\w=.+$")) {
					String[] comp = valueText.split("=");
					//double value = Double.valueOf(comp[1]);
					double value = form.parseComplexFormula(comp[1]).evaluate();
					element.setVariableValue(comp[0], value);
					System.out.println(comp[0] + " = "
							+ element.getVariableValue(comp[0]));
					//} else if(valueText.matches("^[\\d\\.]+$")){
				} else {
					//double value = Double.valueOf(valueText);
					double value = form.parseComplexFormula(valueText)
							.evaluate();
					element.setVariableValue(value);
					System.out.println("Value for " + formName + " set to "
							+ value);
				}
			} else if(action == KeyValues.COMMAND_DRAW_GRAPH){
				GraphModel graph = storage.getStoredGraphs().get(formName);
				if(graph == null){
					FormulaElement formCopy = form.parseComplexFormula(element.toString());
					graph = new GraphModel();
					graph.setFormulaName(formName);
					graph.setFormula(formCopy);
					storage.getStoredGraphs().put(formName, graph);
				}
				if (valueText.matches("^\\w=.+$")) {
					String[] comp = valueText.split("=");
					if(comp[1].contains(",")){
						String[] props = comp[1].split(",");
						graph.setVarName(comp[0]);
						graph.setStartVar(Double.valueOf(props[0]));
						graph.setEndVar(Double.valueOf(props[1]));
						if(props.length == 3) graph.setStep(Double.valueOf(props[2]));
					} else {
						graph.getFormula().setVariableValue(comp[0], Double.valueOf(comp[1]));
					}
				}
			}
			return true;
			//fomulaListModel.addElement(textArea.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private void printStoredFormulas(){
		System.out.println("Formulas");
		for (Map.Entry<String, FormulaElement> entry : storage.getStoredFormulas().entrySet()) {
		    String key = entry.getKey();
		    FormulaElement value = entry.getValue();
		    System.out.println("name: " + key + " formula: " + value.toString());
		    Vector<VariableElement> variables = value.getVariableList();
		    if(variables != null){
			    for (VariableElement variableElement : variables) {
			    	System.out.println("\t variable: " + variableElement.getVarName() + " Value: " + variableElement.getValue());
				}
		    }
		}
		System.out.println("----------------------------");
	}
	
	private void printStoredGraphs(){
		System.out.println("Graphs");
		for (Map.Entry<String, GraphModel> entry : storage.getStoredGraphs().entrySet()) {
		    String key = entry.getKey();
		    GraphModel value = entry.getValue();
		    System.out.println("name: " + key + " formula: " + value.getFormula().toString());
		}
		System.out.println("----------------------------");
	}
}

package fomulaic;

import java.util.ArrayList;
import java.util.HashMap;

//import com.sun.javafx.collections.MappingChange.Map;


import models.GraphModel;
import formulator.FormulaElement;

public class Storage {
//	private HashMap<String, String> storedFormulas;
//	
//	public Storage(){
//		storedFormulas = new HashMap<String, String>();
//	}
//	
//	public void addFormula(String name, String formula){
//		storedFormulas.put(name, formula);
//	}
//	
//	public HashMap<String, String> getStoredFormulas(){
//		return storedFormulas;
//	}
	private HashMap<String, FormulaElement> storedFormulas;
	private HashMap<String, GraphModel> graphList;
	
	public Storage(){
		storedFormulas = new HashMap<String, FormulaElement>();
		graphList = new HashMap<String, GraphModel>();
	}
	
	public void addFormula(String name, FormulaElement formula){
		storedFormulas.put(name, formula);
	}
	
	public HashMap<String, FormulaElement> getStoredFormulas(){
		return storedFormulas;
	}
	
	public void addGraph(String name, GraphModel graph){
		graphList.put(name, graph);
	}
	
	public HashMap<String, GraphModel> getStoredGraphs(){
		return graphList;
	}
}

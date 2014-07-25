package fomulaic;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import formulator.FormulaElement;

public class Storage {
	private HashMap<String, String> storedFormulas;
	
	public Storage(){
		storedFormulas = new HashMap<String, String>();
	}
	
	public void addFormula(String name, String formula){
		storedFormulas.put(name, formula);
	}
	
	public HashMap<String, String> getStoredFormulas(){
		return storedFormulas;
	}
}

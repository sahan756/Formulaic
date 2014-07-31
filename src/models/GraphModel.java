package models;

import java.util.ArrayList;
import java.util.Map;



import formulator.FormulaElement;

public class GraphModel {
	private String formulaName;
	private FormulaElement formula;
	private double startVar;
	private double endVar;
	private double step;
	private String varName;
	
	private boolean startVarAssigned;
	private boolean endVarAssigned;
	private boolean varNameAssigned;
	
	public GraphModel(){
		
	}
	
	public boolean checkGraphDraw(){
		formula.setVariableValue(varName, 0);
		return formula.isFullyGrounded() && startVarAssigned && endVarAssigned && varNameAssigned;
	}
	
	public ArrayList<XYData> getXYCordinates(){
		double step = (this.step > 0) ? this.step : (endVar - startVar)/10;
		double start = startVar;
		ArrayList<XYData> cords = new ArrayList<XYData>();
		while(start < endVar){
			formula.setVariableValue(varName, start);
			double yValue = formula.evaluate();
			cords.add(new XYData(start, yValue));
			start += step;
		}
		return cords;
	}
	
	public String getFormulaName() {
		return formulaName;
	}



	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}



	public FormulaElement getFormula() {
		return formula;
	}



	public void setFormula(FormulaElement formula) {
		this.formula = formula;
	}



	public double getStartVar() {
		return startVar;
	}



	public void setStartVar(double startVar) {
		this.startVarAssigned = true;
		this.startVar = startVar;
	}



	public double getEndVar() {
		return endVar;
	}



	public void setEndVar(double endVar) {
		this.endVarAssigned = true;
		this.endVar = endVar;
	}



	public double getStep() {
		return step;
	}



	public void setStep(double step) {
		this.step = step;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varNameAssigned = true;
		this.varName = varName;
	}
	
}

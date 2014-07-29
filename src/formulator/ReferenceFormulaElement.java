package formulator;

import java.util.HashMap;

public class ReferenceFormulaElement extends FormulaElement{
	private String formulaName;
	private FormulaElement formula;
	private FormulaElement assignValue;
	//private HashMap<String, FormulaElement> storedFormulas;
	
	public ReferenceFormulaElement (String formulaName, FormulaElement formula, FormulaElement assignValue){
		this.formulaName = formulaName;
		//this.formula = formula;
		//To make a copy of Formula element.
		//this.formula = FormulaElement.parseFormula(formula.toString());
		ComplexFormulaElement complexFormula = (ComplexFormulaElement)formula;
		this.formula = complexFormula.parseComplexFormula(complexFormula.getStoredFormula(formulaName).toString());
		this.assignValue = assignValue;
		if(assignValue instanceof ConstantElement || assignValue.isFullyGrounded()) this.formula.setVariableValue(assignValue.evaluate());
	}
	
	@Override
	public String toString(){
		return formulaName + "(" + assignValue + ")";
	}
	
	@Override
	public double evaluate(){
		return formula.evaluate();
	}
	
	@Override
	public void setVariableValue(String varName, double value) {
		//this.setVariableValue(varName, value);
		assignValue.setVariableValue(varName, value);
		formula.setVariableValue(varName, assignValue.evaluate());
		return;
	}
	
	@Override
	public void setVariableValue(double value) {
		//this.setVariableValue(value);
		if (!(assignValue instanceof ConstantElement)) {
			assignValue.setVariableValue(value);
			formula.setVariableValue(assignValue.evaluate());
		}
		return;
	}
	
	@Override
	public boolean isFullyGrounded(){
		return formula.isFullyGrounded();
	}
	
	@Override
	public double getVariableValue(String varName) {
		return this.getVariableValue(varName);
	}
}

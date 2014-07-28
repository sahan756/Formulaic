package formulator;

import java.util.Vector;

public class FunctionElement extends FormulaElement{
	private Vector<FormulaElement> argList;
	public FunctionElement() {
		// TODO Auto-generated constructor stub
		this.argList = new Vector<FormulaElement>();
	}
	public Vector<FormulaElement> getArgList() {
		return argList;
	}
//	public void setArgList(Vector<FormulaElement> argList) {
//		this.argList = argList;
//	}
	
	public FormulaElement getArg(int index){
		return argList.get(index);
	}
	
	public void addArg(FormulaElement arg){
		this.argList.add(arg);
	}
	
	//assign value for a variable
	public void setVariableValue(String varName, double value) {
		Vector<FormulaElement> args = this.getArgList();
		for (FormulaElement element : args) {
			if(!(element instanceof ConstantElement)){
				element.setVariableValue(varName, value);
			}
		}
	}
	
	//assign value for variable without specifying name.
	//useful if formula has one variable.
	//otherwise it will assign same value for all variables.
	
	public void setVariableValue(double value) {
		Vector<FormulaElement> args = this.getArgList();
		for (FormulaElement element : args) {
			if(!(element instanceof ConstantElement)){
				element.setVariableValue(value);
			}
		}
	}
	
//	public void setVariableValue(FormulaElement value) {
//		Vector<FormulaElement> args = this.getArgList();
//		for (FormulaElement element : args) {
//			if(!(element instanceof ConstantElement)){
//				element.setVariableValue(value);
//			}
//		}
//	}
	
	public double getVariableValue(String varName) {
		Vector<FormulaElement> args = this.getArgList();
		for (FormulaElement element : args) {
			if(!(element instanceof ConstantElement)){
				double value = element.getVariableValue(varName);
				if(value > 0)
					return value; 
			}
		}
		return 0;
	}
	
	public boolean isFullyGrounded(){
		Vector<FormulaElement> args = this.getArgList();
		for (FormulaElement element : args) {
			if(!(element instanceof ConstantElement)){
				if(!element.isFullyGrounded())
					return false;
			}
		}
		return true;
	}
	
}

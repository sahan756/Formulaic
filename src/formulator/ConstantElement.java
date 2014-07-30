package formulator;

import java.util.Vector;

public class ConstantElement extends FormulaElement{
	private Double value;
	//private String type = "Constant";
//	public ConstantElement() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	public ConstantElement(double value) {
		//this.type = "Constant";
		this.value = value;
	}
	
	public Double getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return this.value.toString();
	}
	
	public double evaluate(){
		return getValue();
	}
	
//	public double getFirstDerivative(){
//		return 0;
//	}
	
	public Vector<VariableElement> getVariableList(){
		return null;
	}
	
}

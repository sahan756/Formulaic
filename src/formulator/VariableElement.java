package formulator;

public class VariableElement extends FormulaElement{
	private String varName;
	private double value;
	private boolean isFullyGrounded;
	public VariableElement(String varName) {
		// TODO Auto-generated constructor stub
		this.varName = varName;
		isFullyGrounded = false;
	}
	
	public String getVarName() {
		return varName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public boolean isFullyGrounded(){
		return isFullyGrounded;
	}
	
	@Override
	public String toString(){
		return this.varName;
	}
	
	@Override
	public void setVariableValue(String varName, double value) {
		if(this.getVarName().equals(varName)){
			this.setValue(value);
			isFullyGrounded = true;
		}
	}
	
	@Override
	public void setVariableValue(double value) {
		this.setValue(value);
		isFullyGrounded = true;
	}
	
	@Override
	public double getVariableValue(String varName) {
		if(this.getVarName().equals(varName)){
			return this.getValue();
		} else {
			return 0;
		}
	}
	
	public double evaluate(){
		return isFullyGrounded ? getValue() : 0;
	}
}

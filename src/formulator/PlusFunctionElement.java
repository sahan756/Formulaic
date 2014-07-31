package formulator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PlusFunctionElement extends FunctionElement{
	@Override
	public String toString(){
		// if both arguments are Constants
		if (getArg(0) instanceof ConstantElement && getArg(1) instanceof ConstantElement)
			return ((ConstantElement) getArg(0)).getValue()+((ConstantElement) getArg(1)).getValue()+"";
		
	return getArg(0).toString() + "+" + getArg(1).toString();
		// insert parentheses if one or both arguments are plus or minus functions
//		String s1 = "", s2 = "";
//		if (getArg(0) instanceof PlusFunctionElement || getArg(0) instanceof MinusFunctionElement)
//			s1 = "("+getArg(0).toString()+")";
//		else
//			s1 = getArg(0).toString();
//		
//		if (getArg(1) instanceof PlusFunctionElement || getArg(1) instanceof MinusFunctionElement)
//			s2 = "("+getArg(1).toString()+")";
//		else
//			s2 = getArg(1).toString();
//		return s1+"+"+s2;
	}
	
	public double evaluate(){
		return getArg(0).evaluate() + getArg(1).evaluate();
	}
	
//	private void writeObject(ObjectOutputStream os) {
//		try {
//			System.out.println("Starting writeObject");
//			os.defaultWriteObject();
//			os.writeObject(getArgList());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	private void readObject(ObjectInputStream is) {
//		try {
//			System.out.println("Starting readObject");
//			is.defaultReadObject();
//			//cObj = new Collar(is.readInt());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
}

package vector;

import java.io.Serializable;

public interface Calculable extends Cloneable, Serializable {
	
	public Calculable add(Calculable y);
	public Calculable negate();
	public Calculable zero();
	public Calculable substract(Calculable y);
	public Calculable multiply(Calculable y);
	public Calculable get(Class<? extends Calculable> clazz);
	public Object clone() throws CloneNotSupportedException;

}

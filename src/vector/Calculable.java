package vector;

public interface Calculable extends Cloneable {
	
	void add(Calculable y);
	void negate();
	void zero();
	void substract(Calculable y);
	void multiply(Calculable y);
	public Calculable get(Class<? extends Calculable> clazz);

}

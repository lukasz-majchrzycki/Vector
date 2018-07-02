package vector;

public interface Calculable extends Cloneable {
	
	public Calculable add(Calculable y);
	public Calculable negate();
	public Calculable zero();
	public Calculable substract(Calculable y);
	public Calculable multiply(Calculable y);
	public Calculable get(Class<? extends Calculable> clazz);

}

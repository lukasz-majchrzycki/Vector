package vector;

import java.util.ArrayList;
import java.util.List;

public class Vector<T extends Calculable> implements Calculable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<T> x;
	
	//Constructors
	
	public Vector(Vector<T> x)  {
		this.x=new ArrayList<T>();
		this.set(x.get());
	}
	
	
	public Vector(List<T> x){
		this.x = new ArrayList<T>();
		this.set(x);
	}
	
	@SuppressWarnings("unchecked")
	public Vector(T... x){
		
		this.x = new ArrayList<T>();
		
		for(T element: x) {
			try {
				this.x.add((T) element.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	

	@SuppressWarnings("unchecked")
	public <U extends Number> Vector(U[] x){
		
		this.x = new ArrayList<T>();
		
		for(U element: x) {
			this.x.add((T) new Real<U>(element));
		}
	}
	// Getters, Setters
	
	@Override
	public Calculable get(Class<? extends Calculable> clazz) throws ClassCastException, IndexOutOfBoundsException{
		if(clazz==Real.class || clazz==Complex.class) {
			if(this.x.size()==1) {
				return this.x.get(0).get(clazz);
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}	
			else if(clazz==Vector.class) {
				return this;
		}
		
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
	}
	
	public Calculable get(Class<? extends Calculable> clazz, int n) throws ClassCastException, IndexOutOfBoundsException {
		
		if(clazz==Real.class || clazz==Complex.class) {
				return this.x.get(n).get(clazz);
			}	
			else if(clazz==Vector.class) {
				return this;
		}
		
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
	}
	
	public T get(int n) {
		return x.get(n);
	}
	
	public ArrayList<T> get(){
		return this.x;
	}
	
	public void set(int n, T x) {
		this.x.set(n, x);
		
	}
		
	@SuppressWarnings("unchecked")
	public void set(List<T> x) {
		this.x.clear();
		for(T element: x) {
			try {
				this.x.add((T) element.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void set(T[] x) {
		this.x.clear();
		for(T element: x) {
			try {
				this.x.add((T) element.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int size() {
		return x.size();
	}
	
	
	
	
	//Utilities
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Vector<T> copy = new Vector<T>(this.x);
		return copy;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector<?> other = (Vector<?>) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("(");
			
		for(int i=0; i<this.x.size();i++) {
			str.append(this.x.get(i).toString());
			if(i<(this.x.size()-1)) {
				str.append(", ");
			}
		}
		str.append(")");
				
		return str.toString();
	}

	//Arithmetics
	
	@SuppressWarnings("unchecked")
	@Override
	public Calculable add(Calculable y) {
		
		ArrayList<T> resultArray = new ArrayList<T>();
		
		if(y instanceof Vector) {
			if(((Vector<?>) y).size()==this.size()) {
				for(int i=0; i<this.size();i++) {
					resultArray.add((T) this.get(i).add(((Vector<?>) y).get(i)));
				}
			}
			return new Vector<T>(resultArray);
		}
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable negate() {
		ArrayList<T> resultArray = new ArrayList<T>();
		for(int i=0;i<this.size();i++) {
			resultArray.add((T) this.get(i).negate());
		}
		return new Vector<T>(resultArray);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable zero() {
		ArrayList<T> resultArray = new ArrayList<T>();
		for(int i=0;i<this.size();i++) {
			resultArray.add((T) this.get(i).zero());
		}
		return new Vector<T>(resultArray);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable substract(Calculable y) {
		ArrayList<T> resultArray = new ArrayList<T>();
		
		if(y instanceof Vector) {
			if(((Vector<?>) y).size()==this.size()) {
				for(int i=0; i<this.size();i++) {
					resultArray.add((T) this.get(i).substract(((Vector<?>) y).get(i)));
				}
			}
			return new Vector<T>(resultArray);
		}
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable multiply(Calculable y) {
		ArrayList<T> resultArray = new ArrayList<T>();

		
		if(y instanceof Vector) {
			if(((Vector<?>) y).size()==this.size()) {
				resultArray.add((T) this.get(0).multiply(((Vector<?>) y).get(0)));
				
				for(int i=1; i<this.size();i++) {
					resultArray.set(0, (T) resultArray.get(0).add(
							 this.get(i).multiply(((Vector<?>) y).get(i))
																		)	);
				}
			}
			return new Vector<T>(resultArray).get(0);
		}
		else if(y instanceof Real || y instanceof Complex) {
			for(int i=0; i<this.size();i++) {
				resultArray.add((T) this.get(i).multiply(y));
			}
			return new Vector<T>(resultArray);
		}
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		
		
	}



}

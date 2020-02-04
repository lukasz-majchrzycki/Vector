package vector;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends Calculable> implements Calculable{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	private ArrayList<T> x;	// Vector of length m*n, elements counts in rows 
							// element [i,j] = i*m + j
	
	private int m, n;
	//m: number of columns
	//n: number of rows
	
	//Constructors
	
	@SuppressWarnings("unchecked")
	public Matrix (T x) {
		this.m = 1; this.n= 1;
		this.x = new ArrayList<T>();
		try {
			this.x.add((T) x.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	public  Matrix (Matrix<T> x) {
		this(x.m, x.n, x.x);	
	}
	
	@SuppressWarnings("unchecked")
	public Matrix (int m_size, int n_size, List<T> x) {
		if(m_size*n_size!=x.size()) {
			throw new IndexOutOfBoundsException();
		}
		this.m=m_size;
		this.n=n_size;
		this.x= new ArrayList<T>();
		
			for(T element: x)	{
				try {
					this.x.add((T) element.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
	}
	
	@SuppressWarnings("unchecked")
	public <U extends Number> Matrix (int m_size, int n_size, U[] x){
		if(m_size*n_size!=x.length) {
			throw new IndexOutOfBoundsException();
		}
		this.m=m_size;
		this.n=n_size;
		this.x= new ArrayList<T>();
		
			for(U element: x)	{
				this.x.add((T) new Real<U>(element));
			}
	}
	
	@SuppressWarnings("unchecked")
	public Matrix (int m_size, int n_size, T... x){
		if(m_size*n_size!=x.length) {
			throw new IndexOutOfBoundsException();
		}
		this.m=m_size;
		this.n=n_size;
		this.x= new ArrayList<T>();
		
			for(T element: x)	{
				try {
					this.x.add((T) element.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
	}
	
	//getters, setters
	
	@SuppressWarnings("unchecked")
	public <U extends Calculable> void set(Matrix<U> x) {
		//this.set(x.m, x.n, x.x);
		
		this.m=x.m;
		this.n=x.n;
		Class<? extends Calculable> clazz = this.x.get(0).getClass();
		this.x= new ArrayList<T>();
		
			for(U element: x.x)	{
				this.x.add((T) element.get(clazz)  );
			}
	}
	
	@SuppressWarnings("unchecked")
	public void set (int m_size, int n_size, List<T> x) {
		if(m_size*n_size!=x.size()) {
			throw new IndexOutOfBoundsException();
		}
		this.m=m_size;
		this.n=n_size;
		this.x=new ArrayList<T>();
		
			for(int k=0;k<m*n;k++)	{
				try {
					this.x.add((T) x.get(k).clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
	}


	@SuppressWarnings("unchecked")
	public void set(int i, int j, T x) {
		try {
			this.x.set(i*m+j, (T)x.clone() );
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Matrix<T> get(){
		try {
			return (Matrix<T>) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i, int j) {			//j - column no.;  i - row no.
		try {
			return (T) this.x.get(i*m+j).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Vector<T> get(int i){
		ArrayList<T> result = new ArrayList<T>();
		
		try {
			for(int j=0 ;j<m; j++){
				result.add((T) this.x.get(i*this.m +j).clone() );
			}
			return new Vector<T>(result);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

	@SuppressWarnings("unchecked")
	public Vector<T> get(int i, boolean transpose){
		
		if(!transpose) {
			return this.get(i);
		} else {
			ArrayList<T> result = new ArrayList<T>();
			
			try {
				for(int j=i ;j<m*n ; j+=(n-1)){
					result.add((T) this.x.get(j).clone() );
				}
				return new Vector<T>(result);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return null;
		}

	}
	
	@Override
	public Calculable get(Class<? extends Calculable> clazz) {
		if(clazz==Real.class || clazz==Complex.class) {
			if(this.x.size()==1) {
				return this.get(0,0).get(clazz);
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}	
			else if(clazz==Matrix.class) {
				return this;
		}
		
		else if(clazz==Vector.class) {
			if(this.m==1 || this.n==1) {
				return new Vector<T>(this.x);
			} else {
				throw new IndexOutOfBoundsException();
			}
			
		}
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
	}
	
	public Calculable get(Class<? extends Calculable> clazz, int i, int j) throws ClassCastException, IndexOutOfBoundsException{
				
		if(clazz==Real.class || clazz==Complex.class) {
				return this.get(i,j).get(clazz);	
		}	
			else if(clazz==Matrix.class) {
				ArrayList<T> al = new ArrayList<>();
				al.add(this.get(i, j));
				return new Matrix<T>(1,1,al);
		}
		
		else if(clazz==Vector.class) {
			ArrayList<T> al = new ArrayList<>();
			al.add(this.get(i, j));
			
			return new Vector<T>(al);
		}
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		
	}
	
	public int getM() {
		return this.m;
	}
	
	public int getN() {
		return this.n;
	}
	
	//Arithmetics
	@SuppressWarnings("unchecked")
	@Override
	public Calculable add(Calculable y) {
		ArrayList<T> result = new ArrayList<>();
		
		if(y.getClass()==Matrix.class) {
			Matrix<T> newM = (Matrix<T>) y;
			if(newM.m == this.m && newM.n == this.n) {
				for(int i=0; i<this.m*this.n; i++) {
					result.add(  (T) this.x.get(i).add(newM.x.get(i) )  );
				}
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		
		return new Matrix<T>(this.m, this.n, result);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable negate() {
		Matrix<T> result = new Matrix<>(this.m, this.n, this.x);
		
		for(int i=0; i<result.m*result.n;i++) {
			result.x.set(i, (T) result.x.get(i).negate());
		}

		return result;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable zero() {
		Matrix<T> result = new Matrix<>(this.m, this.n, this.x);
		
		for(int i=0; i<result.m*result.n;i++) {
			result.x.set(i, (T) result.x.get(i).zero());
		}

		return result;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable substract(Calculable y) {
		ArrayList<T> result = new ArrayList<>();
		
		if(y.getClass()==Matrix.class) {
			Matrix<T> newM = (Matrix<T>) y;
			if(newM.m == this.m && newM.n == this.n) {
				for(int i=0; i<this.m*this.n; i++) {
					result.add(  (T) this.x.get(i).substract(newM.x.get(i) )  );
				}
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		
		return new Matrix<T>(this.m, this.n, result);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable multiply(Calculable y) {
		ArrayList<T> result = new ArrayList<>();
		int newm = 0, newn = 0;
		
		if (y.getClass()==Real.class || y.getClass()==Complex.class) {
			newm=this.m; newn=this.n;
			
			for(int i=0; i<this.m*this.n; i++) {
				result.add( (T) this.x.get(i).multiply(y) );
			}
		}
		else if(y.getClass()==Vector.class) {
			//TODO
		}
		else if(y.getClass()==Matrix.class) {
			Matrix<T> newM = (Matrix<T>) y;
			//T temp1, temp2, temp3, temp4, temp5, temp11, temp12;
			newm=newM.m;
			newn=this.n;
			
			if(this.m==newM.n) {
				int index=0;
				for(int j=0;j<this.n; j++) {
					for(int i=0; i<newM.m; i++) {
						
						result.add((T) this.get(j, 0).multiply(newM.get(0, i)));		
												
						for(int k=1; k<this.m; k++) {
							
							result.set(index, (T) result.get(index).add(
									(T) this.get(j, k).multiply(newM.get(k, i)))  );
							
						}
						index++;
						
					}
				}
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		return new Matrix<T>(newm, newn, result);	
	}
	
	public Matrix<T> transpose(){
		ArrayList<T> al = new ArrayList<T>();
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				al.add(this.x.get(j*m+i));
			}
		}
		
		Matrix<T> result = new Matrix<T>(this.n, this.m, al);
		return result;
		
	}
	//Utilities

	@Override
	public Object clone() throws CloneNotSupportedException {	//deep copy
		int newm, newn;
		ArrayList<T> newx= new ArrayList<T>();
		newm=getM();
		newn=getN();
		
		for(int i=0;i<newm;i++) {
			for(int j=0;j<newn;j++) {
				newx.add(this.get(i, j));
			}
		}
		
		return new Matrix<T>(newm, newn, newx);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix<?> other = (Matrix<?>) obj;
		if (m != other.m)
			return false;
		if (n != other.n)
			return false;
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
		result = prime * result + m;
		result = prime * result + n;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String str = new String();
		StringBuilder s= new StringBuilder();
		
		for(int i=0;i<this.n;i++) {
			s.append("| ");
			for(int j=0;j<this.m;j++) {
				s.append(this.get(i,j).toString());
				s.append(" ");
			}
			s.append("|");
			if(i!=this.n-1) {
				s.append("\n");
			}
		}
		str=s.toString();
		
		return str;
	}
	

}

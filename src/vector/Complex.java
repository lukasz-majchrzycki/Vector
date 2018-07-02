package vector;

public class Complex<T extends Number> implements Calculable{

	private Real<T> Re, Im;
	
//constructor	
	

	public <U extends Number> Complex(Complex<U> x)  {
		
		this.set(x);
	}
	
	public <U extends Number> Complex(Real<U> re, Real<U> im) {
		this.set(re, im);
	}
	
	public <U extends Number> Complex(U re, U im){
		this.set(re, im);
	}

//getters, setters	
	
	@SuppressWarnings("unchecked")
	public <U extends Number> void set(Complex<U> x)  {
		if(x!=null) {
			
			if(x.Re!=null) {
				try {
					this.Re=(Real<T>) x.Re.clone();
					
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
			if(x.Im!=null) {
				try {
					this.Im=(Real<T>) x.Im.clone();
					
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			this.Re=null;
			this.Im=null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <U extends Number> void set(Real<U> re, Real<U> im) {
		
		if(re!=null) {
			try {
				this.Re=(Real<T>) re.clone();
				
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		if(im!=null) {
			try {
				this.Im=(Real<T>) im.clone();
				
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public <U extends Number> void set(U re, U im) {
		this.Re=new Real<T>(re);
		this.Im=new Real<T>(im);
	}
	
	@Override
	public Calculable get(Class<? extends Calculable> clazz) throws ClassCastException {
		if(clazz==this.getClass()) {
			return this;
		}
		else if(clazz==Real.class) {
			return new Real<T>(this.Re);
		}
		
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
	}
	

	public Real<T> getRe() {
		return Re;
	}

	public void setRe(Real<T> re) {
		Re = re;
	}

	public Real<T> getIm() {
		return Im;
	}

	public void setIm(Real<T> im) {
		Im = im;
	}	
	
//arithmetic
	
	@SuppressWarnings("unchecked")
	@Override
	public Calculable add(Calculable y) throws ClassCastException {
		Complex<T> tmp;
		try {
			tmp = (Complex<T>) this.clone();
		} catch (CloneNotSupportedException e) {
			tmp=null;
		}
		if(y.getClass()==this.getClass()) {
			tmp.Re= (Real<T>) this.Re.add( ((Complex<?>)y).Re);
			tmp.Im=(Real<T>) this.Im.add( ((Complex<?>)y).Im);
		}
		else if(y.getClass()==Real.class) {
			tmp.Re=(Real<T>) this.Re.add( (Real<?>)y);
		}
		//TODO Matrix implementation
		
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		return tmp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable negate() {
		Complex<T> tmp;
		try {
			tmp = (Complex<T>) this.clone();
		} catch (CloneNotSupportedException e) {
			tmp=null;
		}
		
		tmp.Re=(Real<T>) this.Re.negate();
		tmp.Im=(Real<T>) this.Im.negate();

		return tmp;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable zero() {
		Complex<T> tmp;
		try {
			tmp = (Complex<T>) this.clone();
		} catch (CloneNotSupportedException e) {
			tmp=null;
		}
		
		tmp.Re=(Real<T>) this.Re.zero();
		tmp.Im=(Real<T>) this.Im.zero();
		return tmp;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable substract(Calculable y) {
		Complex<T> tmp;
		try {
			tmp = (Complex<T>) this.clone();
		} catch (CloneNotSupportedException e) {
			tmp=null;
		}
		
		if(y.getClass()==this.getClass()) {
			tmp.Re=(Real<T>) this.Re.substract( ((Complex<?>)y).Re);
			tmp.Im=(Real<T>) this.Im.substract( ((Complex<?>)y).Im);
		}
		else if(y.getClass()==Real.class) {
			tmp.Re=(Real<T>) this.Re.substract( (Real<?>)y);
		}
		//TODO Matrix implementation
		
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		return tmp;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable multiply(Calculable y) {
		Complex<T> tmp;
		try {
			tmp = (Complex<T>) this.clone();
		} catch (CloneNotSupportedException e) {
			tmp=null;
		}
		
		if(y.getClass()==this.getClass()) {
			
			tmp.Re= (Real<T>) this.Re.multiply( ((Complex<?>)y).Re)
					.substract
					 ((Real<T>) this.Im.multiply( ((Complex<?>)y).Im));
					
			tmp.Im=(Real<T>) this.Im.multiply( ((Complex<?>)y).Re)
					.add
					((Real<T>) this.Re.multiply( ((Complex<?>)y).Im));
		}
		else if(y.getClass()==Real.class) {
			tmp.Re=(Real<T>) this.Re.multiply( (Real<?>)y);
			tmp.Im=(Real<T>) this.Im.multiply( (Real<?>)y);
		}
		//TODO Matrix implementation
		
		else
		{
			throw new ClassCastException(Messages.WrongCalculable);
		}
		return tmp;
		
	}	
	
//utilities	

	//deep copy	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Complex<T> copy = new Complex<T>(this);
		return copy;
	}
	
	@Override
    public String toString() {
	    return Re.toString()+(Im.get().doubleValue()>=0?"+":"")+Im.toString()+" i";
}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Im == null) ? 0 : Im.hashCode());
		result = prime * result + ((Re == null) ? 0 : Re.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complex<?> other = (Complex<?>) obj;
		if (Im == null) {
			if (other.Im != null)
				return false;
		} else if (!Im.equals(other.Im))
			return false;
		if (Re == null) {
			if (other.Re != null)
				return false;
		} else if (!Re.equals(other.Re))
			return false;
		return true;
	}


}

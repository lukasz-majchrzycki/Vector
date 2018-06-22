package vector;

import java.math.BigDecimal;


public class Real<T extends Number> implements Calculable {

	private T x;
//Constructors
	
/*	public Real() {
		this.zero();
	}*/
	
	@SuppressWarnings("unchecked")
	public <U extends Number> Real(U x) throws ClassCastException  {
		this.set((T)x);
	}
	
	@SuppressWarnings("unchecked")
	public <U extends Number> Real(Real<U> x) throws ClassCastException  {
		
		this.set((T)x.get());
	}

//Getters, Setters	
	
	public T get() {
		return this.x;
	}
	
	@Override
	public Calculable get(Class<? extends Calculable> clazz) {
		if (this.getClass()==clazz) {
			return this;
		} else {
			throw new ClassCastException(Messages.WrongCalculable);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <U extends Number> void set(U x) throws ClassCastException {
		
		Inst instTypes[] = Inst.values();
		boolean okType = false;
		String xClass="";
		
		try {
			xClass = x.getClass().getSimpleName();
		} catch(NullPointerException e) {
			this.x=(T)x;
			return;
		}
		
		
		for(int i=0; i<instTypes.length;i++) {
			if(xClass.equals(instTypes[i].toString()) ) {
				okType=true;
				break;
			}
		}
		if(!okType)  throw new ClassCastException(Messages.ClassCastExp);
		else 	this.x=(T)x;	
	}
	
    @SuppressWarnings("unchecked")
	public <U extends Number> void  set(Real<U> x) throws ClassCastException {
    	this.set((T)x.get());
	}
	
//deep copy	
@Override
public Object clone() throws CloneNotSupportedException {
	Real<T> copy = new Real<T>(this.x);
	return copy;
}

@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((x == null) ? 0 : x.hashCode());
return result;
}

@Override
public boolean equals(Object obj) {
if (this == obj)
	return true;
if (obj == null)
	return false;
if (this.getClass() != obj.getClass())
	return false;
Real<?> other = (Real<?>) obj;

if (x == null) {
	if (other.x != null)
		return false;
} else 
	if (!x.equals(other.x))
	return false;
return true;
}	
//Utilities	
	
	@Override
    public String toString() {
	    return x.toString();
}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Calculable y) {
			this.operateOnClass(Operation.ADD, (Real<T>) y);
		
	}

	@Override
	public void negate() {
		this.operateOnClass(Operation.NEGATE, this);
	}
	
	@Override
	public void zero()  {
		this.operateOnClass(Operation.ZERO, this);	
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public void substract(Calculable y) {
		this.operateOnClass(Operation.SUBSTRACT, (Real<T>) y);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void multiply(Calculable y) {
		this.operateOnClass(Operation.MULTIPLY, (Real<T>) y);
		
	}

//Private methods

	@SuppressWarnings({ "deprecation", "unchecked" })
	private void operateOnClass(Operation op, Real<T> y) throws NumberFormatException, ArithmeticException 
	{
		
		Inst instanceClass = Inst.valueOf(
										this.x.getClass()
										.getSimpleName());
		switch (instanceClass) {
		case Double:
			this.x= (T) new Double(this.operate(op, y).doubleValue());
			break;			
		case Integer:
			this.x= (T) new Integer(this.operate(op, y).intValueExact());
			break;
		case Long:
			this.x= (T) new Long(this.operate(op, y).longValueExact());
			break;
		case Float:
			this.x= (T) new Float(this.operate(op, y).floatValue());
			break;
		case BigDecimal:
			this.x= (T) this.operate(op, y);
			break;
		case Byte:
			this.x= (T) new Byte(this.operate(op, y).byteValueExact());
			break;
		case Short:
			this.x= (T) new Short(this.operate(op, y).shortValueExact());
			break;

		
		}	
	}
	
	private BigDecimal operate(Operation op, Real<T> y) throws NumberFormatException 
	{
		
		BigDecimal result = new BigDecimal(this.x.toString());
		switch(op){
		case ADD:
			result=result.add(new BigDecimal(y.x.toString()));
			break;
		case NEGATE:
			result=result.negate();
			break;
		case MULTIPLY:
			result=result.multiply(new BigDecimal(y.x.toString()));
			break;
		case SUBSTRACT:
			result=result.subtract(new BigDecimal(y.x.toString()));
			break;
		case ZERO:
			result= BigDecimal.ZERO;
			break;
		}
		
		return result;
	}
	
	

	


}

package vector;

import java.math.BigDecimal;


public class Real<T extends Number> implements Calculable {

	private T x;
	
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
		return  this.x;
	}
	
	@Override
	public Calculable get(Class<? extends Calculable> clazz) throws ClassCastException {
		
		if (clazz==this.getClass()) {
			return this;
		} else if(clazz==Complex.class){
			return new Complex<T>(this,new Real<T>(0));
		}
		else
		{
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
	public Calculable add(Calculable y) {
		return	new Real<T> (this.operateOnClass(Operation.ADD, (Real<T>) y) );
		 
		
	}

	@Override
	public Calculable negate() {
		return	new Real<T> (this.operateOnClass(Operation.NEGATE, this));
		}
	
	@Override
	public Calculable zero()  {
		return	new Real<T> (this.operateOnClass(Operation.ZERO, this));	
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public Calculable substract(Calculable y) {
		return	new Real<T> (this.operateOnClass(Operation.SUBSTRACT, (Real<T>) y));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Calculable multiply(Calculable y) {
		return	new Real<T> (this.operateOnClass(Operation.MULTIPLY, (Real<T>) y));
		
	}

//Private methods

	@SuppressWarnings({ "deprecation", "unchecked" })
	private T operateOnClass(Operation op, Real<T> y) throws NumberFormatException, ArithmeticException 
	{
		
		Inst instanceClass = Inst.valueOf(
										this.x.getClass()
										.getSimpleName());
		switch (instanceClass) {
		case Double:
			return (T) new Double(this.operate(op, y).doubleValue());
						
		case Integer:
			return (T) new Integer(this.operate(op, y).intValueExact());
			
		case Long:
			return (T) new Long(this.operate(op, y).longValueExact());
			
		case Float:
			return (T) new Float(this.operate(op, y).floatValue());
			
		case BigDecimal:
			return (T) this.operate(op, y);
			
		case Byte:
			return (T) new Byte(this.operate(op, y).byteValueExact());
			
		case Short:
			return (T) new Short(this.operate(op, y).shortValueExact());
			
		default: return null;		
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

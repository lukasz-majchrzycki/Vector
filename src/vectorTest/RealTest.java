package vectorTest;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import vector.*;

public class RealTest {

public Real<?> makeOperation(int operation, Real<?> x, Real<?> operand) {
	
	switch(operation) {
	case 0:
		return x;
	case 1:
		x.negate();
		return x;
	case 2:
		x.zero();
		return x;
	case 3:	
		x.add(operand);
		return x;
	case 4:
		x.substract(operand);
		return x;
	case 5:
		x.multiply(operand);
		return x;
	default:
		return null;	
	}
}
	
 public void RealInstanceAndOperationsUtility(Inst i, Number actual, Number operand, Number referenceValue, int operation) {
	Real<?> actualReal,operandReal;	
	 switch (i) {
		case Double:
			actualReal = new Real<Double> ((Double)actual);
			operandReal = new Real<Double> ((Double)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());
			break;			
		case Integer:
			actualReal = new Real<Integer> ((Integer)actual);
			operandReal = new Real<Integer> ((Integer)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());			
			break;
		case Long:
			actualReal = new Real<Long> ((Long)actual);
			operandReal = new Real<Long> ((Long)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());
			break;
		case Float:
			actualReal = new Real<Float> ((Float)actual);
			operandReal = new Real<Float> ((Float)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());			
			break;
		case BigDecimal:
			actualReal = new Real<BigDecimal> ((BigDecimal)actual);
			operandReal = new Real<BigDecimal> ((BigDecimal)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());
			break;
		case Byte:
			actualReal = new Real<Byte> ((Byte)actual);
			operandReal = new Real<Byte> ((Byte)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());
			break;
		case Short:
			actualReal = new Real<Short> ((Short)actual);
			operandReal = new Real<Short> ((Short)operand);
			actualReal = makeOperation(operation, actualReal, operandReal);
			assertEquals(referenceValue, actualReal.get());
			break;
		//default:	 
		}	
 }
	
	@Test
	public void RealInstanceTest() {
		
		Number[] values;
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getValueArray(i);
			
			for(int j=0; j<values.length;j++) {
				RealInstanceAndOperationsUtility(i,values[j],null, values[j],0);

				}
			}
		
	}	
	
	@Test
	public void NullInstance() {
		Real<Double> x1 = new Real<>((Double)null);
		x1.set(1.0);
		assertEquals(x1.get(), (Double)1.0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void CloneTest() throws CloneNotSupportedException {
		//constructor clone Test
		Double x1 = new Double(2.0);
		Real<Double> x2 = new Real<>(x1);
		x2.set(10.0);
		assertEquals(x1,(Double)2.0);
		assertEquals(x2.get(), (Double) 10.0);
		assertNotEquals(x1, x2.get());
		
		//Number clone test
		Real<Double> x3 = new Real<>(1.0);
		Real<Double> x4 =new Real<>(0.0);
		x4.set(x3.get());
		assertEquals(x3.get(), x4.get());
		x4.set(2.0);
		assertNotEquals(x3.get(), x4.get());
		
		//Real<T> clone test
		Real<Double> x5 = new Real<>(2.0);
		@SuppressWarnings("unchecked")
		Real<Double> x6 = (Real<Double>) x5.clone();
		x6.set(10.0);
		assertNotEquals(x5.get(), x6.get());
		
		//copy constructor test
		Real<Double> x7 = new Real<>(2.0);
		Real<Double> x8 = new Real<>(x7);
		x8.set(10.0);
		assertNotEquals(x7.get(), x8.get());
		
	}
	
	@Test (expected = ClassCastException.class)
	public void WrongClassInstance() {
		@SuppressWarnings("unused")
		Real<BigInteger> wrongTypeReal = new Real<>(new BigInteger("100"));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void equalsAndHashCodeTest() {
		//null test
		Real<Double> x1 = new Real<>(2.0);
		assertFalse(x1.equals(null));
		//the same object test
		assertTrue(x1.equals(x1));
		
		//other class test
		String str = new String("qwerty");
		assertFalse(x1.equals(str));
		
		//other generic type test
		//value equality with different hashCode's for Double and Integer  
		Real<Float> x2 = new Real<>(2.0F);
		assertFalse(x1.equals(x2));
		assertFalse(x2.equals(x1));
		assertEquals(x1.hashCode(),x2.hashCode());
		
		Real<Integer> x3 = new Real<>(2);
		assertFalse(x1.equals(x3));
		assertFalse(x2.equals(x3));
		assertFalse(x3.equals(x1));
		assertFalse(x3.equals(x2));
		assertNotEquals(x1.hashCode(), x3.hashCode());
		assertNotEquals(x2.hashCode(), x3.hashCode());

		//field x with null instance test
		Real<Double> x4 = new Real<>((Double)null);
		Real<Double> x5 = new Real<>((Double)null);
		Real<Float> x6 = new Real<>((Float)null);

		assertEquals(x4.hashCode(),x5.hashCode());
		assertEquals(x4.hashCode(),x6.hashCode());
		assertTrue(x4.equals(x5));
		assertTrue(x5.equals(x4));
		assertTrue(x4.equals(x6));
		assertTrue(x6.equals(x4));
		
		x4.set(2.0);
		x6.set(2.0F);
		assertFalse(x4.equals(x6));
		assertFalse(x6.equals(x4));
		
		//null and not null equality test
		assertFalse(x4.equals(x5));
		assertFalse(x5.equals(x4));
		
		//equality of different values of x
		Real<Double> x7 = new Real<>(20.0);
		assertFalse(x7.equals(x4));
		assertFalse(x4.equals(x7));
		assertNotEquals(x4.hashCode(), x7.hashCode());
		
		//equality of the same values
		Real<Double> x8 = new Real<>(5.0);
		Real<Double> x9 = new Real<>(5.0);
		assertTrue(x8.equals(x9));
		assertTrue(x9.equals(x8));
		assertEquals(x8.hashCode(), x9.hashCode());
	}
	
	@Test
	public void getSetTest() {
		Real<Double> x1 = new Real<>(0.0);
		assertEquals((Double)0.0, x1.get());
		x1.set(2.5);
		assertEquals((Double)2.5, x1.get());
		Real<Double> x2 = new Real<>(0);
		x2.set(x1);
		assertEquals((Double)2.5, x2.get());
		@SuppressWarnings("unchecked")
		Real<Double> x3 = (Real<Double>) x2.get(x1.getClass());
		assertEquals(x2.get(),x3.get());

	}
	
	@Test (expected=ClassCastException.class)
	public void getExceptionTest() {
		Real<Integer> x1 = new Real<>(2);
		Complex<Real<Integer>> c1 = new Complex<>();
		x1.get(c1.getClass());
	}
	
	@Test
	public void toStringTest() {
		Real<Integer> x1= new Real<>(123);
		assertEquals(x1.toString(),"123");
	}
	
	@Test
	public void negateTest() {
	

		Number[] values, valuesNegated;
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getValueArray(i);
			valuesNegated = TestedValues.getNegateArray(i);
			
			for(int j=0; j<values.length;j++) {
				RealInstanceAndOperationsUtility(i,values[j],null, valuesNegated[j],1);

				}
			}
	}	
	
	@Test
	public void addTest() {
		Number[] values, valuesAdded;
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getValueArrayForAdding(i);
			valuesAdded = TestedValues.getAddedArray(i);
			
			for(int j=0;j<valuesAdded.length;j++) {
				RealInstanceAndOperationsUtility(i,values[2*j], values[(2*j)+1], valuesAdded[j],3);
			}
			}
	}
	
	@Test
	public void zeroTest() {
		Number[] values, valuesZero;
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getValueArray(i);
			valuesZero = TestedValues.getZeroArray(i);
			
			for(int j=0; j<values.length;j++) {
				RealInstanceAndOperationsUtility(i,values[j],null, valuesZero[j],2);

				}
			}
		
	}
	
	@Test
	public void substractTest() {
		Number[] values, valuesSubstracted;
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getValueArrayForSubstracting(i);
			valuesSubstracted = TestedValues.getSubstractedArray(i);
			
			for(int j=0;j<valuesSubstracted.length;j++) {
				RealInstanceAndOperationsUtility(i,values[2*j], values[(2*j)+1], valuesSubstracted[j],4);
			}
			}
	}

	@Test
	public void multiplyTest() {
		Number[] values, valuesMultiplied;
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getValueArrayForMultiplication(i);
			valuesMultiplied = TestedValues.getMultiplicatedArray(i);
			
			for(int j=0;j<valuesMultiplied.length;j++) {
				RealInstanceAndOperationsUtility(i,values[2*j], values[(2*j)+1], valuesMultiplied[j],5);
			}
			}
	}
	
	//overflow Test
	@Test
	public void overflowTest() {
		Number[] values;
		Real<?> actualReal,operandReal;	
		
		for(Inst i: Inst.values()) {
			values=TestedValues.getOverflow(i);
				
			for(int j=0;j<values.length;j+=2) {
				 switch (i) {
					case Double:
						actualReal = new Real<Double> ((Double)values[j]);
						operandReal = new Real<Double> ((Double)values[j+1]);
						break;
					case Integer:
						actualReal = new Real<Integer> ((Integer)values[j]);
						operandReal = new Real<Integer> ((Integer)values[j+1]);
						break;
					case Long:
						actualReal = new Real<Long> ((Long)values[j]);
						operandReal = new Real<Long> ((Long)values[j+1]);
						break;
					case Float:
						actualReal = new Real<Float> ((Float)values[j]);
						operandReal = new Real<Float> ((Float)values[j+1]);
						break;
					case BigDecimal:
						actualReal = new Real<BigDecimal> ((BigDecimal)values[j]);
						operandReal = new Real<BigDecimal> ((BigDecimal)values[j+1]);
						break;
					case Byte:
						actualReal = new Real<Byte> ((Byte)values[j]);
						operandReal = new Real<Byte> ((Byte)values[j+1]);
						break;
					case Short:
						actualReal = new Real<Short> ((Short)values[j]);
						operandReal = new Real<Short> ((Short)values[j+1]);
						break;
					default:
						actualReal=null;
						operandReal=null;
				 }
						
					try {
						actualReal.add(operandReal);
						}catch(ArithmeticException e) {
							continue;
						}
						fail("No overflow detected for"+i.toString()+" "+actualReal.get().toString());
						
						
			}
			}
	}

	//NaN and infinity tests
	@Test
	public void NaN_AndInfinityTest() {
		
		Number[] values;
		Real<?> actualReal;			

		for(Inst i: Inst.values()) {
		values=TestedValues.getNaN_AndInfinity(i);
			
		for(int j=0;j<values.length;j++) {
			 switch (i) {
				case Double:
					actualReal = new Real<Double> ((Double)values[j]);
					break;
				case Float:	
					actualReal = new Real<Float> ((Float)values[j]);
					break;	
				case Integer:
				case Long:	
				case BigDecimal:
				case Byte:
				case Short:
				default:
					actualReal=null;
				    break;	
			 }
					
				try {
					actualReal.add(actualReal);
					}catch(NumberFormatException e) {
						continue;
					}
					fail("No NaN or Infinity detected for"+i.toString()+" "+actualReal.get().toString());
					
					
		}
		}
	}
}
	

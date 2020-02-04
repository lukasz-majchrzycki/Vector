package eu.nanocode.vectorTest;

import java.lang.Number;
import java.math.BigDecimal;

import eu.nanocode.vector.*;


public class TestedValues {
	
	
	public static Number [] getValueArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN,
									new BigDecimal(13.125), new BigDecimal(100)} ;
		case Byte:
			return  new Byte[] {Byte.MIN_VALUE+1, 1, 7 , 13, Byte.MAX_VALUE };	
		case Double:
			return new Double[] {Double.MIN_VALUE, 1.0, 7.25, 13.125, Double.MIN_NORMAL, Double.MAX_VALUE};//, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
		case Float:
			return new Float[] { Float.MIN_VALUE, 1.0F, 7.25F , 13.125F, Float.MIN_NORMAL, Float.MAX_VALUE};//, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY};
		case Integer:
			return new Integer[]  { Integer.MIN_VALUE+1, 1, 7 , 13, Integer.MAX_VALUE };
		case Long:
			return new Long[]  { Long.MIN_VALUE+1, 1L, 7L , 13L, Long.MAX_VALUE };
		case Short:
			return new Short[] {Short.MIN_VALUE+1, 1, 7 , 13, Short.MAX_VALUE };
		default:	return null;
		}
			
	}
	
	public static Number [] getNegateArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ZERO, new BigDecimal(-1), new BigDecimal(-10),
									new BigDecimal(-13.125), new BigDecimal(-100)} ;
		case Byte:
			return  new Byte[] {Byte.MAX_VALUE, -1, -7 , -13, -Byte.MAX_VALUE };	
		case Double:
			return new Double[] {-Double.MIN_VALUE, -1.0, -7.25, -13.125, -Double.MIN_NORMAL, -Double.MAX_VALUE};
		case Float:
			return new Float[] { -Float.MIN_VALUE, -1.0F, -7.25F , -13.125F, -Float.MIN_NORMAL, -Float.MAX_VALUE};
		case Integer:
			return new Integer[]  { Integer.MAX_VALUE, -1, -7 , -13, -Integer.MAX_VALUE };
		case Long:
			return new Long[]  { Long.MAX_VALUE, -1L, -7L , -13L, -Long.MAX_VALUE };
		case Short:
			return new Short[] {Short.MAX_VALUE, -1, -7 , -13, -Short.MAX_VALUE };
		default:	return null;
		}
	}

	public static Number [] getValueArrayForAdding(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN, new BigDecimal(13.125), new BigDecimal(100), new BigDecimal(-100)} ;
		case Byte:
			return  new Byte[] {0, Byte.MIN_VALUE, 1, 7 , -13, 13, Byte.MAX_VALUE-13, 13, Byte.MAX_VALUE-7, 7, Byte.MAX_VALUE-1, 1, Byte.MIN_VALUE, Byte.MAX_VALUE };	
		case Double:
			return new Double[] {0.0, Double.MIN_VALUE, 1.0, 7.25, 13.125, -13.125, Double.MIN_NORMAL, 13.125, Double.MAX_VALUE-13.125, 13.125, Double.MAX_VALUE-7.25, 7.25, Double.MAX_VALUE-1.0, 1.0};
		case Float:
			return new Float[] {0.0F, Float.MIN_VALUE, 1.0F, 7.25F, 13.125F, -13.125F, Float.MIN_NORMAL, 13.125F, Float.MAX_VALUE-13.125F, 13.125F, Float.MAX_VALUE-7.25F, 7.25F, Float.MAX_VALUE-1.0F, 1.0F};
		case Integer:
			return new Integer[] {0, Integer.MIN_VALUE, 1, 7 , -13, 13, Integer.MAX_VALUE-13, 13, Integer.MAX_VALUE-7, 7, Integer.MAX_VALUE-1, 1, Integer.MIN_VALUE, Integer.MAX_VALUE };
		case Long:
			return new Long[]  {0L, Long.MIN_VALUE, 1L, 7L , -13L, 13L, Long.MAX_VALUE-13L, 13L, Long.MAX_VALUE-7L, 7L, Long.MAX_VALUE-1L, 1L, Long.MIN_VALUE, Long.MAX_VALUE };
		case Short:
			return new Short[] {0, Short.MIN_VALUE, 1, 7 , -13, 13, Short.MAX_VALUE-13, 13, Short.MAX_VALUE-7, 7, Short.MAX_VALUE-1, 1, Short.MIN_VALUE, Short.MAX_VALUE };
		default:	return null;
		}
			
	}	
	
	public static Number [] getAddedArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ONE, new BigDecimal(23.125), BigDecimal.ZERO} ;
		case Byte:
			return  new Byte[] {Byte.MIN_VALUE, 8 , 0, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, -1 };	
		case Double:
			return new Double[] {Double.MIN_VALUE, 8.25, 0.0, Double.MIN_NORMAL+13.125, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		case Float:
			return new Float[] {Float.MIN_VALUE, 8.25F, 0.0F, Float.MIN_NORMAL+13.125F, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
		case Integer:
			return new Integer[] {Integer.MIN_VALUE, 8 , 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 };
		case Long:
			return new Long[]  { Long.MIN_VALUE, 8L , 0L, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, -1L };
		case Short:
			return new Short[] {Short.MIN_VALUE, 8, 0, Short.MAX_VALUE, Short.MAX_VALUE, Short.MAX_VALUE, -1 };
		default:	return null;
		}
			
	}	
	
/*	public static Number [] getAddedArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ONE, BigDecimal.TEN, new BigDecimal(13.125),
					new BigDecimal(11.0), new BigDecimal(14.125),
					new BigDecimal(23.125)} ;
		case Byte:
			return  new Byte[] {Byte.MIN_VALUE+2, Byte.MIN_VALUE+8 , Byte.MIN_VALUE+14, 8, 14, 20};	
		case Double:
			return new Double[] {Double.MIN_VALUE+1.0, Double.MIN_VALUE+7.25, Double.MIN_VALUE+13.125, Double.MIN_VALUE+Double.MIN_NORMAL, 
								8.25, 14.125, Double.MIN_NORMAL+1,
								20.375, Double.MIN_NORMAL+7.25 , Double.MIN_NORMAL+13.125};
		case Float:
			return new Float[] {Float.MIN_VALUE+1.0F, Float.MIN_VALUE+7.25F, Float.MIN_VALUE+13.125F, Float.MIN_VALUE+Float.MIN_NORMAL, 
								8.25F, 14.125F, Float.MIN_NORMAL+1,
								20.375F, Float.MIN_NORMAL+7.25F , Float.MIN_NORMAL+13.125F};
		case Integer:
			return new Integer[]  {Integer.MIN_VALUE+2, Integer.MIN_VALUE+8 , Integer.MIN_VALUE+14, 8, 14, 20};
		case Long:
			return new Long[]   {Long.MIN_VALUE+2, Long.MIN_VALUE+8 , Long.MIN_VALUE+14, 8L, 14L, 20L};
		case Short:
			return new Short[] {Short.MIN_VALUE+2, Short.MIN_VALUE+8 , Short.MIN_VALUE+14, 8, 14, 20};
		default:	return null;
		}
			
	}*/
	
	public static Number [] getZeroArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO} ;
		case Byte:
			return  new Byte[] {0, 0, 0, 0, 0 };	
		case Double:
			return new Double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		case Float:
			return new Float[] { 0.0F, 0.0F, 0.0F , 0.0F, 0.0F, 0.0F};
		case Integer:
			return new Integer[] {0, 0, 0, 0, 0 };
		case Long:
			return new Long[]  {0L, 0L, 0L, 0L, 0L };
		case Short:
			return new Short[] {0, 0, 0, 0, 0 };
		default:	return null;
		}
	}
	
	public static Number [] getValueArrayForSubstracting(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN, new BigDecimal(13.125), new BigDecimal(100), new BigDecimal(100)} ;
		case Byte:
			return  new Byte[] {0, Byte.MAX_VALUE, 1, 7 , 13, 13, Byte.MIN_VALUE+13, 13, Byte.MIN_VALUE+7, 7, Byte.MIN_VALUE+1, 1, Byte.MIN_VALUE, Byte.MIN_VALUE };	
		case Double:
			return new Double[] {0.0, Double.MAX_VALUE, 1.0, 7.25, 13.125, 13.125, Double.MIN_NORMAL, 13.125};
		case Float:
			return new Float[] {0.0F, Float.MAX_VALUE, 1.0F, 7.25F, 13.125F, 13.125F, Float.MIN_NORMAL, 13.125F};
		case Integer:
			return new Integer[] {0, Integer.MAX_VALUE, 1, 7 , 13, 13, Integer.MIN_VALUE+13, 13, Integer.MIN_VALUE+7, 7, Integer.MIN_VALUE+1, 1, Integer.MIN_VALUE, Integer.MIN_VALUE };
		case Long:
			return new Long[]  {0L, Long.MAX_VALUE, 1L, 7L , 13L, 13L, Long.MIN_VALUE+13L, 13L, Long.MIN_VALUE+7L, 7L, Long.MIN_VALUE+1L, 1L, Long.MIN_VALUE, Long.MIN_VALUE };
		case Short:
			return new Short[] {0, Short.MAX_VALUE, 1, 7 , 13, 13, Short.MIN_VALUE+13, 13, Short.MIN_VALUE+7, 7, Short.MIN_VALUE+1, 1, Short.MIN_VALUE, Short.MIN_VALUE };
		default:	return null;
		}
			
	}	
	
	public static Number [] getSubstractedArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {new BigDecimal(-1), new BigDecimal(-3.125), BigDecimal.ZERO} ;
		case Byte:
			return  new Byte[] {Byte.MIN_VALUE+1, -6 , 0, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 0 };	
		case Double:
			return new Double[] {-Double.MAX_VALUE, -6.25, 0.0, Double.MIN_NORMAL-13.125};
		case Float:
			return new Float[] {-Float.MAX_VALUE, -6.25F, 0.0F, Float.MIN_NORMAL-13.125F};
		case Integer:
			return new Integer[] {Integer.MIN_VALUE+1, -6 , 0, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0 };
		case Long:
			return new Long[]  { Long.MIN_VALUE+1, -6L , 0L, Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE, 0L };
		case Short:
			return new Short[] {Short.MIN_VALUE+1, -6, 0, Short.MIN_VALUE, Short.MIN_VALUE, Short.MIN_VALUE, 0 };
		default:	return null;
		}
			
	}	
	
	public static Number [] getValueArrayForMultiplication(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN, new BigDecimal(13.125), new BigDecimal(100), new BigDecimal(-100)} ;
		case Byte:
			return  new Byte[] {0, Byte.MAX_VALUE, 0, Byte.MIN_VALUE, 2, 3, -4, 5, -6, -7};	
		case Double:
			return new Double[] {0.0, Double.MAX_VALUE, 0.0, Double.MIN_VALUE, 2.5, 3.5, -4.5, 5.5, -6.5, -7.5};
		case Float:
			return new Float[] {0.0F, Float.MAX_VALUE, 0.0F, Float.MIN_VALUE, 2.5F, 3.5F, -4.5F, 5.5F, -6.5F, -7.5F};
		case Integer:
			return new Integer[] {0, Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 2, 3, -4, 5, -6, -7};	
		case Long:
			return new Long[]  {0L, Long.MAX_VALUE, 0L, Long.MIN_VALUE, 2L, 3L, -4L, 5L, -6L, -7L};	
		case Short:
			return new Short[] {0, Short.MAX_VALUE, 0, Short.MIN_VALUE, 2, 3, -4, 5, -6, -7};	
		default:	return null;
		}
			
	}	
	
	public static Number [] getMultiplicatedArray(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] { BigDecimal.ZERO, new BigDecimal("131.250"), new BigDecimal(-10000)} ;
		case Byte:
			return  new Byte[] {0 ,0, 6, -20, 42};
		case Double:
			return new Double[] {0.0 ,0.0, 8.75, -24.75, 48.75};
		case Float:
			return new Float[] {0.0F ,0.0F, 8.75F, -24.75F, 48.75F};
		case Integer:
			return new Integer[] {0 ,0, 6, -20, 42};
		case Long:
			return new Long[]  {0L ,0L, 6L, -20L, 42L};
		case Short:
			return new Short[] {0 ,0, 6, -20, 42};
		default:	return null;
		}
			
	}	
	
	public static Number [] getOverflow(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] { } ;
		case Byte:
			return  new Byte[] {Byte.MIN_VALUE ,-1, Byte.MAX_VALUE, 1};
		case Double:
			return new Double[] {};
		case Float:
			return new Float[] {};
		case Integer:
			return new Integer[]  {Integer.MIN_VALUE ,-1, Integer.MAX_VALUE, 1};
		case Long:
			return new Long[]  {Long.MIN_VALUE ,-1L, Long.MAX_VALUE, 1L};
		case Short:
			return new Short[]  {Short.MIN_VALUE ,-1, Short.MAX_VALUE, 1};
		default:	return null;
		}
			
	}	
	
	public static Number [] getNaN_AndInfinity(Inst i) {
		switch(i) {
		case BigDecimal:
			return new BigDecimal[] { } ;
		case Byte:
			return  new Byte[] {};
		case Double:
			return new Double[] {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
		case Float:
			return new Float[] {Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY};
		case Integer:
			return new Integer[]  {};
		case Long:
			return new Long[]  {};
		case Short:
			return new Short[]  {};
		default:	return null;
		}
			
	}
	
}

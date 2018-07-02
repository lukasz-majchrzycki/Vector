package vectorTest;

import vector.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComplexTest {

	Real<Double> r1, r2, r3, r4;
	Complex<Double> c1, c2, c3, c4, c5, c6, c7, c8, c9;
	@Before
	public void createObjects() {
		r1=new Real<>(1.0);
		r2=new Real<>(2.0);
		r3=new Real<>(3.0);
		r4=new Real<>(4.0);
		
		c1=new Complex<>(r1,r2);
		c2=new Complex<>(r3,r4);
		c3=new Complex<>(r1,r2);
		c4=new Complex<>(r3,r4);
		c5=new Complex<>(r1,r2);
		c6=new Complex<>(-1.0, -2.0);
		c7=new Complex<>(null, 2.0);
		c8=new Complex<>(1.0, null);
		c9=new Complex<>((Double)null, null);
		
	}
	
	@Test
	public void instanceGetSetTest() {
		Complex<Double> cx = new Complex<>(r1,r2);
		assertEquals(r1, cx.getRe());
		assertEquals(r2, cx.getIm());
		
		cx.setRe(r3);
		cx.setIm(r4);
		assertEquals(r3, cx.getRe());
		assertEquals(r4, cx.getIm());
		
		assertEquals(r3, cx.get(Real.class));
		cx = new Complex<>(r1,r2);
		assertEquals(c3, cx.get(Complex.class));
		//TODO Matrix class test
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void arithmeticsWithComplexTest() {
		c1=(Complex<Double>) c1.add(c2);
		assertEquals(new Complex<Double>(4.0, 6.0), c1);
		
		
		c2=(Complex<Double>) c2.substract(c3);
		assertEquals(new Complex<Double>(2.0, 2.0), c2);
		
		//c3=new Complex<>(r1,r2);
		c3=(Complex<Double>) c3.negate();
		assertEquals(new Complex<Double>(-1.0, -2.0), c3);
		
		c4=(Complex<Double>) c4.multiply(c5);
		assertEquals(new Complex<Double>(-5.0, 10.0), c4);
		
		c5=(Complex<Double>) c5.zero();
		assertEquals(new Complex<Double>(0.0, 0.0), c5);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void arithmeticsWithRealTest() {
		c1=(Complex<Double>) c1.add(r4);
		assertEquals(new Complex<Double>(5.0, 2.0), c1);
		
		c2=(Complex<Double>) c2.substract(r4);
		assertEquals(new Complex<Double>(-1.0, 4.0), c2);
		
		c4=(Complex<Double>) c4.multiply(r4);
		assertEquals(new Complex<Double>(12.0, 16.0), c4);
			
	}
	
	@Test
	public void nullTest() {
		Complex<Double> cx = new Complex<>((Real<Double>)null, (Real<Double>) null);
		cx.setRe(r1);
		assertEquals(r1, cx.getRe());
		cx.setIm(r2);
		assertEquals(r2, cx.getIm());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("1.0+2.0 i", c5.toString());
		Complex<Double> cx = new Complex<>(-1.0, -2.0);
		assertEquals("-1.0-2.0 i", cx.toString());
	}
	
	@Test
	public void cloneTest() throws CloneNotSupportedException  {
		//clone test
		@SuppressWarnings("unchecked")
		Complex<Double> cx = (Complex<Double>)c1.clone();
		assertEquals(new Real<Double>(1.0), cx.getRe());
		assertEquals(new Real<Double>(2.0), cx.getIm());
		cx.setRe(new Real<Double>(3.0));
		cx.setIm(new Real<Double>(4.0));
		assertNotEquals(cx.getRe(), c1.getRe());
		assertNotEquals(cx.getIm(), c1.getIm());
		
		//constructor copy
		Complex<Double> cx2 = new Complex<>(c1);
		assertEquals(new Real<Double>(1.0), cx2.getRe());
		assertEquals(new Real<Double>(2.0), cx2.getIm());
		cx2.setRe(new Real<Double>(3.0));
		cx2.setIm(new Real<Double>(4.0));
		assertNotEquals(cx2.getRe(), c1.getRe());
		assertNotEquals(cx2.getIm(), c1.getIm());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void hashCodeAndEqualsTest() {
		//null test
		assertFalse(c1.equals(null));
		//the same test
		assertTrue(c1.equals(c1));
		//other class test
		String str = new String("qwerty");
		assertFalse(c1.equals(str));
		
		//same value equality
		assertTrue(c1.equals(c3));
		assertTrue(c3.equals(c1));
		assertEquals(c1.hashCode(), c3.hashCode());
		
		//different values equality
		Complex<Double> cx1 = new Complex<>(1.0, 3.0);
		Complex<Double> cx2 = new Complex<>(2.0, 3.0);
		Complex<Double> cx3 = new Complex<>(2.0, 4.0);
		assertFalse(cx1.equals(c1));
		assertFalse(c1.equals(cx1));
		
		assertFalse(cx2.equals(c1));
		assertFalse(c1.equals(cx2));
		
		assertFalse(cx3.equals(c1));
		assertFalse(c1.equals(cx3));
		
		
		//null fields equality
		assertFalse(c1.equals(c7));
		assertFalse(c7.equals(c1));
		
		assertFalse(c1.equals(c8));
		assertFalse(c8.equals(c1));
		
		assertFalse(c1.equals(c9));
		assertFalse(c9.equals(c1));
		
	}

}

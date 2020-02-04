package eu.nanocode.vectorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import eu.nanocode.vector.*;

public class VectorTest {

	Real<Double> r1, r2, r3, r4;
	Complex<Real<Double>> c1, c2, c3, c4, c5, c6, c7, c8, c9;
	
	ArrayList<Real<Double>> al1, al2, al3, al4, al5, al6;
	ArrayList<Complex<Real<Double>>> alc1, alc2, alc3, alc4, alc5, alc6;
	
	Vector<Real<Double>> vr1, vr2, vr3, vr4, vr5, vr6;
	Vector<Complex<Real<Double>>> vc1, vc2, vc3, vc4, vc5, vc6;
	
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
		
		al1 = new ArrayList<>();
		al1.add(r1);
		
		al2 = new ArrayList<>();
		al2.add(r1);  al2.add(r2);  al2.add(r3);
		
		al3 = new ArrayList<>();
		al3.add(r2);  al3.add(r3);  al3.add(r4);
		
		al4 = new ArrayList<>();
		al4.add(r3);  al4.add(r4);  al4.add(r1);
		
		al5 = new ArrayList<>();
		al5.add(r4);  al5.add(r1);  al5.add(r2);
		
		al6 = new ArrayList<>();
		al6.add(r1);  al6.add(r3);  al6.add(r4);
		
		alc1 = new ArrayList<>();
		alc1.add(c1);
		
		alc2 = new ArrayList<>();
		alc2.add(c1); alc2.add(c2); alc2.add(c6);
		
		alc3 = new ArrayList<>();
		alc3.add(c2); alc3.add(c3); alc3.add(c4);
		
		alc4 = new ArrayList<>();
		alc4.add(c3); alc4.add(c4); alc4.add(c5);
		
		alc5 = new ArrayList<>();
		alc5.add(c4); alc5.add(c5); alc5.add(c6);
		
		alc6 = new ArrayList<>();
		alc6.add(c5); alc6.add(c6); alc6.add(c1);
		
		vr1 = new Vector<Real<Double>> (al1);
		vr2 = new Vector<Real<Double>> (al2);
		vr3 = new Vector<Real<Double>> (al2);
		vr4 = new Vector<Real<Double>> (al2);
		vr5 = new Vector<Real<Double>> (al2);
		vr6 = new Vector<Real<Double>> (al2);
		
		/*vr2 = new Vector<Real<Double>> (al2);
		vr3 = new Vector<Real<Double>> (al3);
		vr4 = new Vector<Real<Double>> (al4);
		vr5 = new Vector<Real<Double>> (al5);
		vr6 = new Vector<Real<Double>> (al6);*/
		
		vc1 = new Vector<Complex<Real<Double>>> (alc1);
		vc2 = new Vector<Complex<Real<Double>>> (alc2);
		vc3 = new Vector<Complex<Real<Double>>> (alc2);
		vc4 = new Vector<Complex<Real<Double>>> (alc2);
		vc5 = new Vector<Complex<Real<Double>>> (alc2);
		vc6 = new Vector<Complex<Real<Double>>> (alc2);
		/*vc3 = new Vector<Complex<Real<Double>>> (alc3);
		vc4 = new Vector<Complex<Real<Double>>> (alc4);
		vc5 = new Vector<Complex<Real<Double>>> (alc5);
		vc6 = new Vector<Complex<Real<Double>>> (alc6);*/
	}

	@Test
	public void instanceGetSetTest() {
		Vector<Real<Double>> vx1 = new Vector<>(new ArrayList<>() );
		assertEquals(0, vx1.size());
				
		Vector<Real<Double>> vx2 = new Vector<Real<Double>>(al2) ;
		assertEquals(3, vx2.size());
		
		assertEquals(r1, vx2.get(0));
		assertEquals(r2, vx2.get(1));
		assertEquals(r3, vx2.get(2));
		
		Double [] d1 = {1.0, 2.0, 3.0};
		
		Vector<Real<Double>> vx3 = new Vector<>  (d1);
		Vector<Real<Integer>> vxx1 = new Vector<>(d1);
		Vector<Complex<Real<Integer>>> vxx2 = new Vector<>(d1);
		
		assertEquals(r1, vx3.get(0));
		assertEquals(r2, vx2.get(1));
		assertEquals(r3, vx2.get(2));
		
		assertEquals(r1, vxx1.get(0));
		assertEquals(r2, vxx1.get(1));
		assertEquals(r3, vxx1.get(2));
		
		assertEquals(r1, vxx2.get(0));
		assertEquals(r2, vxx2.get(1));
		assertEquals(r3, vxx2.get(2));
		
		vx3.set(1, new Real<Double>(4.0));
		assertEquals(r4, vx3.get(1) );
		
		Vector<Real<Double>> vx4 = new Vector<Real<Double>>(al1) ;
		assertEquals(r1, vx4.get(Real.class));
		
		Vector<Real<Double>> vx5 = new Vector<Real<Double>>(al1) ;
		assertEquals(new Complex<Real<Double>>(r1, new Real<Double>(0.0)), vx5.get(Complex.class));
		
		Vector<Real<Double>> vx6 = new Vector<>(al2);
		assertEquals(new Vector<Real<Double>>(al2), vx6.get(Vector.class));
		assertEquals(r2, vx6.get(Real.class, 1));
		assertEquals(new Complex<Real<Double>>(r2, new Real<Double>(0.0)), vx6.get(Complex.class, 1));
		
		Vector<Complex<Real<Double>>> vx7 = new Vector<>(alc2);
		assertEquals(new Vector<Complex<Real<Double>>>(alc2), vx7.get(Vector.class));
		assertEquals(c2, vx7.get(Complex.class, 1));
		assertEquals(r3, vx7.get(Real.class, 1));
		
		assertEquals(c2, vx7.get(Complex.class, 1));
		assertEquals(r3, vx7.get(Real.class, 1));
		//TODO Matrix class test
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void arythmeticsWithVector() {
		vr2=(Vector<Real<Double>>) vr2.add(vr2);
		assertEquals(new Real<Double>(2.0), vr2.get(0) );
		assertEquals(new Real<Double>(4.0), vr2.get(1) );
		assertEquals(new Real<Double>(6.0), vr2.get(2) );
		assertEquals(3, vr2.size());
		
		vr3=(Vector<Real<Double>>) vr3.substract(vr3);
		assertEquals(new Real<Double>(0.0), vr3.get(0) );
		assertEquals(new Real<Double>(0.0), vr3.get(1) );
		assertEquals(new Real<Double>(0.0), vr3.get(2) );
		assertEquals(3, vr3.size());
		
		Real<Double> rx1=(Real<Double>) vr4.multiply(vr4);
		assertEquals(new Real<Double>(14.0), rx1 );
		//assertEquals(1, vr4.size());
		
		vr5=(Vector<Real<Double>>) vr5.negate();
		assertEquals(new Real<Double>(-1.0), vr5.get(0) );
		assertEquals(new Real<Double>(-2.0), vr5.get(1) );
		assertEquals(new Real<Double>(-3.0), vr5.get(2) );
		assertEquals(3, vr5.size());
		
		vr6=(Vector<Real<Double>>) vr6.zero();
		assertEquals(new Real<Double>(0.0), vr6.get(0) );
		assertEquals(new Real<Double>(0.0), vr6.get(1) );
		assertEquals(new Real<Double>(0.0), vr6.get(2) );
		assertEquals(3, vr6.size());
		
		vc2=(Vector<Complex<Real<Double>>>) vc2.add(vc2);
		assertEquals(new Complex<Real<Double>>(2.0, 4.0), vc2.get(0) );
		assertEquals(new Complex<Real<Double>>(6.0, 8.0), vc2.get(1) );
		assertEquals(new Complex<Real<Double>>(-2.0, -4.0), vc2.get(2) );
		assertEquals(3, vc2.size());
		
		vc3=(Vector<Complex<Real<Double>>>) vc3.substract(vc3);
		assertEquals(new Complex<Real<Double>>(0.0, 0.0), vc3.get(0) );
		assertEquals(new Complex<Real<Double>>(0.0, 0.0), vc3.get(1) );
		assertEquals(new Complex<Real<Double>>(0.0, 0.0), vc3.get(2) );
		assertEquals(3, vc3.size());
		
		Complex<Real<Double>> cx1=(Complex<Real<Double>>) vc4.multiply(vc4);
		assertEquals(new Complex<Real<Double>>(-13.0, 32.0), cx1 );
		
		
		vc5=(Vector<Complex<Real<Double>>>) vc5.negate();
		assertEquals(new Complex<Real<Double>>(-1.0, -2.0), vc5.get(0) );
		assertEquals(new Complex<Real<Double>>(-3.0, -4.0), vc5.get(1) );
		assertEquals(new Complex<Real<Double>>(1.0, 2.0), vc5.get(2) );
		
		vc6=(Vector<Complex<Real<Double>>>) vc6.zero();
		assertEquals(new Complex<Real<Double>>(0.0, 0.0), vc6.get(0) );
		assertEquals(new Complex<Real<Double>>(0.0, 0.0), vc6.get(1) );
		assertEquals(new Complex<Real<Double>>(0.0, 0.0), vc6.get(2) );	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void multiplyByScalar() {
		vr2 = (Vector<Real<Double>>) vr2.multiply(r3);
		assertEquals(new Real<Double>(3.0), vr2.get(0) );
		assertEquals(new Real<Double>(6.0), vr2.get(1) );
		assertEquals(new Real<Double>(9.0), vr2.get(2) );
		assertEquals(3, vr2.size());
		
		/*Vector<Complex<Real<Double>>>vcx1 = (Vector<Complex<Real<Double>>>) vr3.multiply(c2);
		assertEquals(new Real<Double>(3.0), vcx1.get(0).getRe() ); //(1, 2, 3) *(3+4i)
		assertEquals(new Real<Double>(4.0), vcx1.get(0).getIm() );
		assertEquals(new Real<Double>(6.0), vcx1.get(1).getRe() );
		assertEquals(new Real<Double>(8.0), vcx1.get(1).getIm() );
		assertEquals(new Real<Double>(9.0), vcx1.get(2).getRe() );
		assertEquals(new Real<Double>(12.0), vcx1.get(2).getIm() );
		assertEquals(3, vcx1.size());*/
		
		vc2 = (Vector<Complex<Real<Double>>>) vc2.multiply(r3);	///	(1+2i, 3+4i, -1-2i)*3
		assertEquals(new Real<Double>(3.0), vc2.get(0).getRe() );
		assertEquals(new Real<Double>(6.0), vc2.get(0).getIm() );
		assertEquals(new Real<Double>(9.0), vc2.get(1).getRe() );
		assertEquals(new Real<Double>(12.0), vc2.get(1).getIm() );
		assertEquals(new Real<Double>(-3.0), vc2.get(2).getRe() );
		assertEquals(new Real<Double>(-6.0), vc2.get(2).getIm() );
		assertEquals(3, vc2.size());
		
		vc3 = (Vector<Complex<Real<Double>>>) vc3.multiply(c2);	///	(1+2i, 3+4i, -1-2i)*(3+4i)
		assertEquals(new Real<Double>(-5.0), vc3.get(0).getRe() );
		assertEquals(new Real<Double>(10.0), vc3.get(0).getIm() );
		assertEquals(new Real<Double>(-7.0), vc3.get(1).getRe() );
		assertEquals(new Real<Double>(24.0), vc3.get(1).getIm() );
		assertEquals(new Real<Double>(5.0), vc3.get(2).getRe() );
		assertEquals(new Real<Double>(-10.0), vc3.get(2).getIm() );
		assertEquals(3, vc3.size());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("(1.0)", vr1.toString());
		assertEquals("(1.0, 2.0, 3.0)", vr2.toString());
		assertEquals("(1.0+2.0 i)", vc1.toString());
		assertEquals("(1.0+2.0 i, 3.0+4.0 i, -1.0-2.0 i)", vc2.toString());
	}

}

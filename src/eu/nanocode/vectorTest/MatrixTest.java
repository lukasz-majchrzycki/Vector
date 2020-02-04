package eu.nanocode.vectorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import eu.nanocode.vector.*;

public class MatrixTest {

	Real<Double> r1, r2, r3, r4, r5, r6;
	Complex<Real<Double>> c1, c2, c3, c4, c5, c6, c7, c8, c9;
	
	ArrayList<Real<Double>> al1, al2, alt;
	ArrayList<Real<Double>> al2t1, al2t2, al2nt1, al2nt2, al2nt3;
	ArrayList<Complex<Real<Double>>> alc1, alc2, alct;
	
	Matrix<Real<Double>> mr1, mr2, mr3, mr4, mr5, mr6, mr7, mr8, mrt;
	Matrix<Complex<Real<Double>>> mc1, mc2, mc3, mc4, mc5, mc6, mc7, mc8, mct;
	
	@Before
	public void createObjects()  {
		
		r1=new Real<>(1.0);
		r2=new Real<>(2.0);
		r3=new Real<>(3.0);
		r4=new Real<>(4.0);
		r5=new Real<>(5.0);
		r6=new Real<>(6.0);
		
		c1=new Complex<>(r1,r2);
		c2=new Complex<>(r3,r4);
		c3=new Complex<>(r1,r2);
		c4=new Complex<>(r3,r4);
		c5=new Complex<>(r1,r2);
		c6=new Complex<>(-1.0, -2.0);
		
		al1 = new ArrayList<>();
		al1.add(r1);
		
		al2 = new ArrayList<>();
		al2.add(r1);  al2.add(r2);  al2.add(r3); al2.add(r4); al2.add(r5); al2.add(r6);
		
		alt = new ArrayList<>();
		alt.add(r1);  alt.add(r3);  alt.add(r5); alt.add(r2); alt.add(r4); alt.add(r6);
		
		al2t1 = new ArrayList<>();
		al2t1.add(r1);  al2t1.add(r3);  al2t1.add(r5);
		
		al2t2 = new ArrayList<>();
		al2t2.add(r2);  al2t2.add(r4);  al2t2.add(r6);
		
		al2nt1 = new ArrayList<>();
		al2nt1.add(r1);  al2nt1.add(r2); 
		
		al2nt2 = new ArrayList<>();
		al2nt2.add(r3);  al2nt2.add(r4); 
		
		al2nt3 = new ArrayList<>();
		al2nt3.add(r5);  al2nt3.add(r6); 
		
		alc1 = new ArrayList<>();
		alc1.add(c1);
		
		alc2 = new ArrayList<>();
		alc2.add(c1); alc2.add(c2); alc2.add(c3); alc2.add(c4); alc2.add(c5); alc2.add(c6);
		
		alct = new ArrayList<>();
		alct.add(c1); alct.add(c3); alct.add(c5); alct.add(c2); alct.add(c4); alct.add(c6);
		
		mr1 = new Matrix<>(1,1,al1);
		mr2 = new Matrix<>(2,3,al2);
		mr3 = new Matrix<>(2,3,al2);
		mr4 = new Matrix<>(2,3,al2);
		mr5 = new Matrix<>(2,3,al2);
		mr6 = new Matrix<>(2,3,al2);
		mr7 = new Matrix<>(2,3,al2);
		mr8 = new Matrix<>(2,3,al2);
		mrt = new Matrix<>(3,2,alt);
		
		mc1 = new Matrix<>(1,1,alc1);
		mc2 = new Matrix<>(2,3,alc2);
		mc3 = new Matrix<>(2,3,alc2);
		mc4 = new Matrix<>(2,3,alc2);
		mc5 = new Matrix<>(2,3,alc2);
		mc6 = new Matrix<>(2,3,alc2);
		mc7 = new Matrix<>(2,3,alc2);
		mc8 = new Matrix<>(2,3,alc2);
		mct = new Matrix<>(3,2,alct);
	}

	@Test
	public void instanceGetSetTest() {
		Matrix<Real<Double>> mrx0 = new Matrix<>(0, 0, new ArrayList<>() );
		assertEquals(0, mrx0.getM());
		assertEquals(0, mrx0.getN());
		
		Matrix<Real<Double>> mrx1 = new Matrix<>(1,1,al1);
		assertEquals(new Real<Double>(1.0), mrx1.get(0, 0));	//	|1.0|
		assertEquals(1, mrx1.getM());
		assertEquals(1, mrx1.getN());
		
		Matrix<Real<Double>> mrx2 = new Matrix<>(2,3,al2);	//  |1.0 2.0|
															//  |3.0 4.0|
															//  |5.0 6.0|
		assertEquals(2, mrx2.getM());
		assertEquals(3, mrx2.getN());
		assertEquals(new Real<Double>(1.0), mrx2.get(0, 0));
		assertEquals(new Real<Double>(2.0), mrx2.get(0, 1));
		assertEquals(new Real<Double>(3.0), mrx2.get(1, 0));
		assertEquals(new Real<Double>(4.0), mrx2.get(1, 1));
		assertEquals(new Real<Double>(5.0), mrx2.get(2, 0));
		assertEquals(new Real<Double>(6.0), mrx2.get(2, 1));
		
		Double[] d1 = {1.0, 2.0};
		Matrix<Real<Double>> mrx3 = new Matrix<>(2, 1, d1);		//	|1.0 2.0|
		assertEquals(new Real<Double>(1.0), mrx3.get(0, 0));
		assertEquals(new Real<Double>(2.0), mrx3.get(0, 1));
		assertEquals(2, mrx3.getM());
		assertEquals(1, mrx3.getN());
		
		assertEquals(new Vector<Real<Double>>(al2t1), mrx2.get(0, true));
		assertEquals(new Vector<Real<Double>>(al2t2), mrx2.get(1, true));
		assertEquals(3, mrx2.get(1, true).size());
		
		assertEquals(new Vector<Real<Double>>(al2nt1), mrx2.get(0, false));
		assertEquals(new Vector<Real<Double>>(al2nt2), mrx2.get(1, false));
		assertEquals(new Vector<Real<Double>>(al2nt3), mrx2.get(2, false));
		assertEquals(new Vector<Real<Double>>(al2nt1), mrx2.get(0));
		assertEquals(new Vector<Real<Double>>(al2nt2), mrx2.get(1));
		assertEquals(new Vector<Real<Double>>(al2nt3), mrx2.get(2));
		assertEquals(2, mrx2.get(1, false).size());	
		assertEquals(2, mrx2.get(1).size());
		
		assertEquals(r1, mrx2.get(Real.class, 0, 0));
		assertEquals(r1, mrx1.get(Real.class));
		
		assertEquals(new Complex<Real<Double>>(r1, new Real<Double>(0.0)), mrx2.get(Complex.class, 0, 0));
		assertEquals(new Complex<Real<Double>>(r1, new Real<Double>(0.0)), mrx1.get(Complex.class));
		
		assertEquals(new Vector<Real<Double>>(d1), mrx3.get(Vector.class));
		
		assertEquals(new Matrix<Real<Double>>(2,3,al2), mrx2.get(Matrix.class));
		assertNotEquals(new Matrix<Real<Double>>(3,2,al2), mrx2.get(Matrix.class));
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void arytheticsWithMatrixTest() {
		
		// 			|1.0 2.0|
		// mr2= 	|3.0 4.0|
		//  		|5.0 6.0|
		
		mr2=(Matrix<Real<Double>>) mr2.add(mr2);					
		assertEquals(new Real<Double>(2.0),  mr2.get(0, 0));
		assertEquals(new Real<Double>(4.0),  mr2.get(0, 1));
		assertEquals(new Real<Double>(6.0),  mr2.get(1, 0));
		assertEquals(new Real<Double>(8.0),  mr2.get(1, 1));
		assertEquals(new Real<Double>(10.0), mr2.get(2, 0));
		assertEquals(new Real<Double>(12.0), mr2.get(2, 1));
		
		mr3=(Matrix<Real<Double>>) mr3.substract(mr3);					
		assertEquals(new Real<Double>(0.0),  mr3.get(0, 0));
		assertEquals(new Real<Double>(0.0),  mr3.get(0, 1));
		assertEquals(new Real<Double>(0.0),  mr3.get(1, 0));
		assertEquals(new Real<Double>(0.0),  mr3.get(1, 1));
		assertEquals(new Real<Double>(0.0), mr3.get(2, 0));
		assertEquals(new Real<Double>(0.0), mr3.get(2, 1));
		
		mr4=(Matrix<Real<Double>>) mr4.zero();					
		assertEquals(new Real<Double>(0.0),  mr4.get(0, 0));
		assertEquals(new Real<Double>(0.0),  mr4.get(0, 1));
		assertEquals(new Real<Double>(0.0),  mr4.get(1, 0));
		assertEquals(new Real<Double>(0.0),  mr4.get(1, 1));
		assertEquals(new Real<Double>(0.0), mr4.get(2, 0));
		assertEquals(new Real<Double>(0.0), mr4.get(2, 1));
		
		mr5=(Matrix<Real<Double>>) mr5.negate();					
		assertEquals(new Real<Double>(-1.0),  mr5.get(0, 0));
		assertEquals(new Real<Double>(-2.0),  mr5.get(0, 1));
		assertEquals(new Real<Double>(-3.0),  mr5.get(1, 0));
		assertEquals(new Real<Double>(-4.0),  mr5.get(1, 1));
		assertEquals(new Real<Double>(-5.0), mr5.get(2, 0));
		assertEquals(new Real<Double>(-6.0), mr5.get(2, 1));
		
		mr6=(Matrix<Real<Double>>) mr6.transpose();	
		assertEquals(3, mr6.getM());
		assertEquals(2, mr6.getN());
		assertEquals(new Real<Double>(1.0),  mr6.get(0, 0));
		assertEquals(new Real<Double>(3.0),  mr6.get(0, 1));
		assertEquals(new Real<Double>(5.0),  mr6.get(0, 2));
		assertEquals(new Real<Double>(2.0),  mr6.get(1, 0));
		assertEquals(new Real<Double>(4.0),  mr6.get(1, 1));
		assertEquals(new Real<Double>(6.0),  mr6.get(1, 2));
		assertEquals(mrt, mr6);
		
		mr7=(Matrix<Real<Double>>) mr7.multiply(mrt);
		assertEquals(3, mr7.getM());
		assertEquals(3, mr7.getN());
		assertEquals(new Real<Double>(5.0),  mr7.get(0, 0));
		assertEquals(new Real<Double>(11.0),  mr7.get(0, 1));
		assertEquals(new Real<Double>(17.0),  mr7.get(0, 2));
		assertEquals(new Real<Double>(11.0),  mr7.get(1, 0));
		assertEquals(new Real<Double>(25.0),  mr7.get(1, 1));
		assertEquals(new Real<Double>(39.0),  mr7.get(1, 2));
		assertEquals(new Real<Double>(17.0),  mr7.get(2, 0));
		assertEquals(new Real<Double>(39.0),  mr7.get(2, 1));
		assertEquals(new Real<Double>(61.0),  mr7.get(2, 2));
		
		mrt=(Matrix<Real<Double>>) mrt.multiply(mr8);
		assertEquals(2, mrt.getM());
		assertEquals(2, mrt.getN());
		assertEquals(new Real<Double>(35.0),  mrt.get(0, 0));
		assertEquals(new Real<Double>(44.0),  mrt.get(0, 1));
		assertEquals(new Real<Double>(44.0),  mrt.get(1, 0));
		assertEquals(new Real<Double>(56.0),  mrt.get(1, 1));
		
		mc2=(Matrix<Complex<Real<Double>>>) mc2.multiply(mct);
		assertEquals(3, mc2.getM());
		assertEquals(3, mc2.getN());
		assertEquals(new Complex<Real<Double>>(-10.0, 28.0),  mc2.get(0, 0));
		assertEquals(new Complex<Real<Double>>(-10.0, 28.0),  mc2.get(0, 1));
		assertEquals(new Complex<Real<Double>>(2.0, -6.0),  mc2.get(0, 2));
		
		assertEquals(new Complex<Real<Double>>(-10.0, 28.0),  mc2.get(1, 0));
		assertEquals(new Complex<Real<Double>>(-10.0, 28.0),  mc2.get(1, 1));
		assertEquals(new Complex<Real<Double>>(2.0, -6.0),  mc2.get(1, 2));
		
		assertEquals(new Complex<Real<Double>>(2.0, -6.0),  mc2.get(2, 0));
		assertEquals(new Complex<Real<Double>>(2.0, -6.0),  mc2.get(2, 1));
		assertEquals(new Complex<Real<Double>>(-6.0, 8.0),  mc2.get(2, 2));
		
		}
	
	@SuppressWarnings("unchecked")
	@Test
	public void arytheticsWithScalar() {
		// 			|1.0 2.0|
		// mr2= 	|3.0 4.0|
		//  		|5.0 6.0|
		
		mr2= (Matrix<Real<Double>>) mr2.multiply(r3);
		assertEquals(new Real<Double>(3.0),  mr2.get(0, 0));
		assertEquals(new Real<Double>(6.0),  mr2.get(0, 1));
		assertEquals(new Real<Double>(9.0),  mr2.get(1, 0));
		assertEquals(new Real<Double>(12.0),  mr2.get(1, 1));
		assertEquals(new Real<Double>(15.0), mr2.get(2, 0));
		assertEquals(new Real<Double>(18.0), mr2.get(2, 1));
		
		mc2 = new Matrix<Complex<Real<Double>>>(new Complex<Real<Double>>(0.0, 0.0));
		mc2.set(mr3);
		mc2= (Matrix<Complex<Real<Double>>>) mc2.multiply(c2);
		assertEquals(new Complex<Real<Double>>(3.0, 4.0), mc2.get(0, 0) );
		assertEquals(new Complex<Real<Double>>(6.0, 8.0), mc2.get(0, 1) );
		assertEquals(new Complex<Real<Double>>(9.0, 12.0), mc2.get(1, 0) );
		assertEquals(new Complex<Real<Double>>(12.0, 16.0), mc2.get(1, 1) );
		assertEquals(new Complex<Real<Double>>(15.0, 20.0), mc2.get(2, 0) );
		assertEquals(new Complex<Real<Double>>(18.0, 24.0), mc2.get(2, 1) );
		
	}
	
	@Test
	public void toStringTest() {
		assertEquals("| 1.0 2.0 |\n| 3.0 4.0 |\n| 5.0 6.0 |", mr2.toString());
				}

}

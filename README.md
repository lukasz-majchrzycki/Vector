# Vector #

Utility for calculation of complex number, vector, and matrix calculation

## Creating numbers ##

````java
Real<Integer> r = new Real<>(2);
	//simple Integer number: 2
Real<Double> r1 = new Real<>(1.5);
	//simple Double number: 1.5
...

Complex<Real<Double>> c1 = new Complex<>(2.0, -1.5);	
	//complex number: 2.0-1.5 i
...

Vector<Complex<Real<Double>> v1 = new Vector<>(c1, c2, c3);
	//vector of complex numbers, eg: [2.0-1.5i, 1.0+2.5i, 4.3+0.0i]
...

Matrix<Real<Double>> m1 = new Matrix<>(2,3, r1, r2, r3, r4, r5, r6 );
	//matrix of Double numbers, eg:
	//  |1.0 2.0|
	//  |3.0 4.0|
	//  |5.0 6.0|
	
Matrix<Vector<Complex<Real<Double>>>> m2 = new Matrix<>(2,2, v1, v2, v3, v4);
	//matrix consisting of vectors of complex numbers. Why not?
````

### Known Issues ###
* Calculation results should be casted to proper data type, like eg:

````java
c1=(Complex<Real<Double>>) c1.add(c2);	//adding of two complex numbers
````

* Some mathematical operation cause in extending to a wider number team. At the moment, such conversion is not supported, and cause in java.lang.ClassCastException:

````java
c2=(Complex<Real<Double>>) r1.add(c1);
````
or loosing the data from extending fields:

````java
r1 = (Real<Double>) r1.multiply(c1);
//eg: 3.0 * (-1.0 + 2.0i) gives -3.0 instead of (-3.0 +6.0i)
````

* In above cases objects should be converted intentionally, like:

````java
c2=(Complex<Real<Double>>) new Complex<Real<Double>>(r1, new Real<Double>(0.0)).add(c1);
````

* Vector by vector multiplication is a scalar multiplication:

````java
Real<Double> r1=(Real<Double>) vr4.multiply(vr4);
// eg: (1.0, 2.0, 3.0)*(1.0, 2.0, 3.0) = 14.0
````

### Data types ###
Real<> classes can wrap types:
* Long
* Integer
* Short
* Byte
* Double
* Float
* BigDecimal

Operation:
* Complex ***** Real gives Complex
* Vector ***** Vector gives Real
* Matrix ***** Complex gives Matrix<Complex>
* Matrix ***** Vector - *not implemented yet*

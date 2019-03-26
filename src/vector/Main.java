package vector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import java.math.BigDecimal;
import vectorTest.TestedValues;



public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		

Real<Double> r1, r2, r3, r4, r5, r6;
ArrayList<Real<Double>> al2;
Matrix<Real<Double>> mr1;

r1=new Real<>(1.0);
r2=new Real<>(2.0);
r3=new Real<>(3.0);
r4=new Real<>(4.0);
r5=new Real<>(5.0);
r6=new Real<>(6.0);		

al2 = new ArrayList<>();
al2.add(r1);  al2.add(r2);  al2.add(r3); al2.add(r4); al2.add(r5); al2.add(r6);

mr1 = new Matrix<>(2,3,al2);


System.out.println(mr1.toString());
		/*
		Scanner reader = new Scanner(System.in);
		
		Complex<Real<Double>> a = new Complex<>(0.0, 0.0);
		Complex<Real<Double>> c=null;
		
 		Real<Integer> b = new Real<>(0);
		Real<Integer> d = null;
		
		System.out.println("Podaj Re i Im:");
		a.setRe(new Real<>(reader.nextDouble() ) );
		a.setIm(new Real<>(reader.nextDouble()));
		
		System.out.println("Podaj Real<Integer>");
		b.set(reader.nextInt());
		
		a=(Complex<Real<Double>>) a.multiply(b);
		System.out.println("a*b= "+a);
		
		reader.close();
		
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Calculable.bin"))){
			outputStream.writeObject(a);
			outputStream.writeObject(b);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Deserializacja...");
		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Calculable.bin"))) {
			c=(Complex<Real<Double>>) inputStream.readObject();
			d=(Real<Integer>) inputStream.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("c= "+c+"\nd= "+d);
		System.out.println( ((Object)a)==((Object)c)  );
		System.out.println( a.equals(c)  );*/
		
		/*Float x1=Float.MIN_VALUE;
		System.out.println(x1);
		x1=(float) -x1;
		System.out.println(x1+"\n");
		
		Float x2=Float.MAX_VALUE;
		System.out.println(x2);
		x2=(float) -x2;
		System.out.println(x2);*/
		
//	Number[] values, valuesAdded;
		
	/*		values=TestedValues.getValueArray(Inst.Integer);
			valuesAdded = TestedValues.getAddedArray(Inst.Integer);
			
			int l=0;
			for(int j=0;j<values.length-2;j++) {
			for(int k=j+1; k<values.length-1;k++) {
				//RealInstanceAndOperationsUtility(i,values[j], values[k], valuesAdded[l],2);
				System.out.println(" "+l+" "+j+" "+k+"\n"+values[j]+" "+values[k]+" "+valuesAdded[l]+"\n");
				l++;
				}
			}*/
		//System.out.println(Short.MIN_VALUE+Short.MAX_VALUE);
	
	
	/*Inst i=Inst.Double;
		values=TestedValues.getValueArrayForSubstracting(i);
		valuesAdded = TestedValues.getSubstractedArray(i);
		
		for(int j=0;j<valuesAdded.length;j++) {
			System.out.println(values[2*j].toString()+"-"+ values[(2*j)+1]+"="+ valuesAdded[j]+" jest "+(values[2*j].doubleValue()- values[(2*j)+1].doubleValue()));
		}
		*/
			}
					

}

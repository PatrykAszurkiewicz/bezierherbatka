package bezierr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File teaspoon = new File("teaspoon.txt");
		File czajnik = new File("czajnik.txt");
		File filizana = new File("filizana.txt");

		double putx = 0, puty = 0, putz = 0;
		Punkt p[][][] = new Punkt[16][4][4];// liczba platow w lyzce to 16
		Punkt q[][][] = new Punkt[32][4][4];
		Punkt r[][][] = new Punkt[26][4][4];
		try
		{
		Scanner s = new Scanner(teaspoon);
		Scanner c = new Scanner(czajnik);
		Scanner v = new Scanner(filizana);
		s.useDelimiter(" |" + "\n");

		for(int k = 0; k < 16; k++)
		{
		for(int i = 0; i < 4; i++)
		{
		for(int j = 0; j < 4; j++)
		{
		p[k][i][j] = new Punkt(Double.parseDouble(s.next()), Double.parseDouble(s.next()), Double.parseDouble(s.next()));
		}
		}
		}
		for(int k = 0; k < 32; k++)
		{
		for(int i = 0; i < 4; i++)
		{
		for(int j = 0; j < 4; j++)
		{
		q[k][i][j] = new Punkt(Double.parseDouble(c.next()), Double.parseDouble(c.next()), Double.parseDouble(c.next()));
		}
		}
		}
		for(int k = 0; k < 26; k++)
		{
		for(int i = 0; i < 4; i++)
		{
		for(int j = 0; j < 4; j++)
		{
		r[k][i][j] = new Punkt(Double.parseDouble(v.next()), Double.parseDouble(v.next()), Double.parseDouble(v.next()));
		}
		}
		}

		}
		catch (FileNotFoundException e)
		{
		e.printStackTrace();
		}
		try {
		FileWriter writeteaspoon = new FileWriter("teaspoonresult.txt");
		FileWriter writeczajnik = new FileWriter("czajnikresult.txt");
		FileWriter writefilizana = new FileWriter("filizanaresult.txt");


		writeteaspoon.write("x, y, z"+  System.lineSeparator());
		writeczajnik.write("x, y, z"+  System.lineSeparator());
		writefilizana.write("x, y, z"+  System.lineSeparator());

		
		for(int k = 0; k < 16; k++)
		{

		for(double w = 0.0; w <= 1.0; w = w + 0.01)
		{
		for(double v = 0.0; v <= 1.0; v = v + 0.01)
		{
		   
		putx = 0.0;
		puty = 0.0;
		putz = 0.0;

		for(int j = 0; j < 4; j++)
		{
		for(int i = 0; i < 4; i++)
		{

		putx += p[k][i][j].x * Bernstein(i, 3, v) * Bernstein(j, 3, w);
		puty += p[k][i][j].y * Bernstein(i, 3, v) * Bernstein(j, 3, w);
		putz += p[k][i][j].z * Bernstein(i, 3, v) * Bernstein(j, 3, w);

		}
		}
		writeteaspoon.write(putx + ", " + puty + ", " + putz + System.lineSeparator());
		System.out.println(k);
		}
		}
		}
		
		for(int k = 0; k < 32; k++)
		{

		for(double w = 0.0; w <= 1.0; w = w + 0.01)
		{
		for(double v = 0.0; v <= 1.0; v = v + 0.01)
		{
		   
		putx = 0.0;
		puty = 0.0;
		putz = 0.0;

		for(int j = 0; j < 4; j++)
		{
		for(int i = 0; i < 4; i++)
		{

		putx += q[k][i][j].x * Bernstein(i, 3, v) * Bernstein(j, 3, w);
		puty += q[k][i][j].y * Bernstein(i, 3, v) * Bernstein(j, 3, w);
		putz += q[k][i][j].z * Bernstein(i, 3, v) * Bernstein(j, 3, w);

		}
		}
		writeczajnik.write(putx + ", " + puty + ", " + putz + System.lineSeparator());
		System.out.println(k);
		}
		}
		}
		
		for(int k = 0; k < 26; k++)
		{

		for(double w = 0.0; w <= 1.0; w = w + 0.01)
		{
		for(double v = 0.0; v <= 1.0; v = v + 0.01)
		{
		   
		putx = 0.0;
		puty = 0.0;
		putz = 0.0;

		for(int j = 0; j < 4; j++)
		{
		for(int i = 0; i < 4; i++)
		{

		putx += r[k][i][j].x * Bernstein(i, 3, v) * Bernstein(j, 3, w);
		puty += r[k][i][j].y * Bernstein(i, 3, v) * Bernstein(j, 3, w);
		putz += r[k][i][j].z * Bernstein(i, 3, v) * Bernstein(j, 3, w);

		}
		}
		writefilizana.write(putx + ", " + puty + ", " + putz + System.lineSeparator());
		System.out.println(k);
		}
		}
		}


		} catch (IOException e1)
		{
		e1.printStackTrace();
		}

		}

		   public static int fac(int n) {
		       if (n == 0) {
		           return 1;
		       } else {
		           int result = 1;
		           for (int i = 1; i <= n; i++) {
		               result *= i;
		           }

		           return result;
		       }
		   }
		   
		   public static double Bernstein(int i, int n, double t) {
		       double factor_0 = fac(n) / (fac(n - i) * fac(i));
		       double factor_1 = Math.pow((1 - t),(n - i));
		       double factor_3 = Math.pow(t, i);
		       return  factor_0 * factor_1 * factor_3;
		   }
}
class Punkt {

public double x = 0;
public double y = 0;
public double z = 0;


public Punkt(double a, double b, double c)
{
this.x = a;
this.y = b;
this.z = c;
}

void setX(double a){
this.x = a;
}
void setY(double a){
this.y = a;
}
void setZ(double a){
this.z = a;
}

double getX() {
return this.x;
}
double getY() {
return this.y;
}
double getZ() {
return this.z;
}
}

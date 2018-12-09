package algorithm;

import java.util.Scanner;

public class CircleArea {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		System.out.println(Main(n));
//		
//		
//	}
	public static String Main(int r) {
			double PI=3.14159265358979323;
			double result = (double)(r*r)*PI;
			String resultStr = String .format("%.7f",result);
			return resultStr;
	}
	
}

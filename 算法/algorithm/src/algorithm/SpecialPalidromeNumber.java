package algorithm;

import java.util.ArrayList;
import java.util.Arrays;


public class SpecialPalidromeNumber {
	private static ArrayList<Integer> five(int middle,int num) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int side = (num - middle)/2;
		for(int i=1;i<=9;i++) {
			for(int j = 0;j<=9;j++)
			if((i+j)==side) {
				result.add(i*10000+j*1000+middle*100+j*10+i);
			}
		}
		return result;
	}
	private static ArrayList<Integer> six(int num) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int side = num /2;
		for(int i=1;i<=9;i++) {
			for(int j = 0;j<=9;j++) {
				for(int k = 0;k<=9;k++) {
					if((i+j+k)==side) {
						result.add(i*100000+j*10000+k*1000+k*100+j*10+i);
					}
				}
			}
		}
		return result;
	}
	
	private static void print(Object[] result) {
		int n = result.length;
		for(int i = 0;i<n;i++) {
			System.out.println((int)result[i]);
		}
	}
	
	
	private static void specialPalidromeNumber(int n) {
		if(n%2==1) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.addAll(five(1,n));
			result.addAll(five(3,n));
			result.addAll(five(5,n));
			result.addAll(five(7,n));
			result.addAll(five(9,n));
			Object[] a = result.toArray();
			Arrays.sort(a);
			print(a);
		}
		else {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.addAll(five(0,n));
			result.addAll(five(2,n));
			result.addAll(five(4,n));
			result.addAll(five(6,n));
			result.addAll(five(8,n));
			result.addAll(six(n));
			Object[] a = result.toArray();
			Arrays.sort(a);
			print(a);
		}
	}
}
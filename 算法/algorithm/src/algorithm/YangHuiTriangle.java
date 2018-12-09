package algorithm;

import java.util.ArrayList;

public class YangHuiTriangle {
	public static void yangHuiTriangle(int n) {
		ArrayList<Integer> yHT = new ArrayList<Integer>();
		yHT.add(1);
		for(int i = 0;i<n-1;i++) {
			print(yHT.toArray());
			System.out.println("");
			yHT.add(1);
			for(int j = yHT.size()-2 ;j>0;j--) {
				yHT.set(j, yHT.get(j)+yHT.get(j-1));
			}
		}
		print(yHT.toArray());
	}
	private static final void print(Object[] a) {
		int i = 0;
		for(;i<a.length-1;i++) {
			System.out.print((int)a[i]+" ");
		}
		System.out.print((int)a[i]);
	}






}

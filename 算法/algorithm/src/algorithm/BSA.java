package algorithm;

public class BSA {
	public static void bSA(int[] a) {
		int sum = a[0];
		int big = a[0];
		int small = a[0];
		for(int i = 1;i<a.length;i++) {
			if(a[i]>big) {
				big = a[i];
			}
			sum+=a[i];
		}
		for(int i = 0;i<a.length-1;i++) {
			if(a[i]<small) {
				small = a[i];
			}
		}
	}
}

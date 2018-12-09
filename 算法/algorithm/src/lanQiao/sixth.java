package lanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class sixth {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] num = new int[n];
//		for(int i =0;i<n;i++) {
//			num[i]=sc.nextInt();
//		}
//		fun(num,n);
//	}
	public static void fun(int[] num ,int n) {//nÊÇÏÂ±ê
		int steps = 0;
		if(num.length==0||num.length==1) {
			System.out.println(0);
		}
		Arrays.sort(num);
		while(!fun2(num)) {
			steps+=1;
			for(int i =0;i<n-1;i++) {
				num[i]+=1;
			}
			Arrays.sort(num);
		}
		System.out.println(steps);
	}
	private final static boolean fun2(int[] num) {
		for(int i= num.length-1;i>0;i--) {
			if(num[i]!=num[i-1])
				return false;
		}
		return true;
	}
}

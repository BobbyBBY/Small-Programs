package lanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class seventh {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int p = sc.nextInt();
//		int q = sc.nextInt();
//		int k = sc.nextInt();
//		int[] num = new int[n];
//		for(int i =0;i<n;i++) {
//			num[i]=sc.nextInt();
//		}
//		fun(num,q,k);
//	}
	public static void fun(int[] num ,int Q ,int K) {
		int sum=0;
		Arrays.sort(num);
		if(K>0) {
			if(Q>0) {
				sum-=num[0];
				for(int i=1;i<num.length;i++) {
					sum+=num[i];
				}
				System.out.println(sum);
				return ;
			}
			else {
				for(int i=0;i<num.length;i++) {
					sum+=num[i];
				}
				System.out.println(sum);
				return ;
			}
		}
		else {
			for(int i=0;i<Q;i++) {
				sum-=num[i];
			}
			for(int i=Q;i<num.length;i++) {
				sum+=num[i];
			}
			System.out.println(sum);
			return ;
		}
	}
}

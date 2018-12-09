package lanQiao;

import java.util.Scanner;

public class eighth {
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int k = sc.nextInt();
//		//int k = sc.nextInt();
//		int[] num = new int[n];
//		for(int i =0;i<n;i++) {
//			num[i]=sc.nextInt();
//		}
//		System.out.println(fun2(num,k,m));
//	}
	public static int fun2(int[] N,int K,int M) {
		int MaxN=N[0];
		for(int i = 1 ;i<N.length;i++) {
			if(N[i]>MaxN) {
				MaxN=N[i];
			}
		}
		int MinN=1;
		int T = (MinN+MaxN)/2;
		//二分
		while(MaxN!=MinN) {
			if(fun(N,K,M,T)) {
					MinN = T+1;
					T = (MinN+MaxN)/2;
			}
			else {
				if(T==MinN) {
					return T;
				}
				else {
					MaxN = T;
					T = (MinN+MaxN)/2;
				}
				
			}
		}
		if(fun(N,K,M,T)) {
			return -1;
		}
		else {
			return T;
			}
	}
	
	
	
	private static boolean fun(int[] N,int K,int M,int T) {
		int i =0;
		int j = 0;
		int temp = 0;
		for(;i<K;i++) {
			temp = M;
			for(;j<N.length;j++) {
				temp -= N[j];
				if(temp <= 0) {
					break;
				}
				else {
					temp += T;
					if(temp>M) {
						temp=M;
					}
				}
			}
			if(j==N.length) {
				return false;//未被攻破
			}
		}
		if(i==K) {
			return true;//被攻破
		}
		return false;//实际上不可达
	}
}

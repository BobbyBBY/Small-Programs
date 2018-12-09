package lanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] a = {1,2,4,8};
		//isAlienSorted(a,b);
		System.out.println(canReorderDoubled(a));
	}
	public static boolean canReorderDoubled(int[] A) {
		if(A.length==0) {
			return true;
		}
        if(A.length<2) {
			return false;
		}
		Arrays.sort(A);
		int Max=  1;
		int temp = 0;
		for(;temp<A.length;temp++) {
			if(A[temp]>=0) {
				break;
			}
		}
		
		if(temp%2==1) {
			return false;
		}
		boolean[] sign = new boolean[A.length];
		for(int i = 0 ;i<sign.length;i++) {
			sign[i] = false;
		}
		//非负数
		int i ;
		for(i = temp;i<=(A.length+temp)/2;i++) {
			if(sign[i]) {
				continue;
			}
			sign[i] = true;
			int temp2 = compare(A,A[i]*2,sign);
			if(temp2==-1) {
				return false;
			}
			else {
				sign[i]=true;
				sign[temp2]=true;
			}
		}
		//负数
		for(i = temp-1;i>=(temp-1)/2;i--) {
			if(sign[i]) {
				continue;
			}
			sign[i] = true;
			int temp2 = compare(A,A[i]*2,sign);
			if(temp2==-1) {
				return false;
			}
			else {
				sign[i]=true;
				sign[temp2]=true;
			}
		}
		for(int j = 0;j<A.length;j++) {
			if(sign[j]==false) {
				return false;
			}
		}
		return true;
		
	}
	private static int compare(int[] A,int b,boolean[] sign) {
		for(int i = 0;i<A.length;i++) {
			if(A[i]==b&&!sign[i]) {
				return i;
			}
		}
		return -1;
	}

}
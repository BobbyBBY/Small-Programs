package lanQiao;

import java.util.Scanner;

public class second {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
////		sc.nextLine();
////		String[] numstr = new String[n];
////		for(int i= 0;i<n;i++) {
////			numstr[i]=sc.nextLine();
////		}
//		fun(n);
//	}
	public static void fun(int n) {
		int temp1 = (int)Math.sqrt(n);
		for(int i = 0;i<=temp1;i++) {
			int n2 = n - i*i;
			int temp2 = (int)Math.sqrt(n2);
			for(int j = 0;j<=temp2;j++) {
				int n3 = n2 -j*j ;
				int temp3 = (int)Math.sqrt(n3);
				for(int k =0;k<=temp3;k++) {
					int n4 = n3 -k*k;
					int l = (int) Math.sqrt(n4);
					if(l*l==n4) {
						System.out.println(i + " " + j + "  " + k + " " + l);
						return;
					}
				}
			}
		}
	}
}

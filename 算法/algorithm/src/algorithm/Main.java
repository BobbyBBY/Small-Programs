package algorithm;

import java.util.Scanner;


public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		leapyear(a);
//	}
	public static void leapyear(int n) {
		if(((n%4==0)&&(n%100!=0))||(n%400==0)) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}

}


package lanQiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class forth {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
////		int n = sc.nextInt();
////		sc.nextLine();
////		String[] numstr = new String[n];
////		for(int i= 0;i<n;i++) {
////			numstr[i]=sc.nextLine();
////		}
//		String n = sc.nextLine();
//		fun(n);
//	}
	public static void fun(String str) {
		Stack<Integer> left = new Stack<Integer>();
		ArrayList<Integer> leftlist = new ArrayList<Integer>();
		ArrayList<Integer> Rightlist = new ArrayList<Integer>();
		int n = str.length();
		for(int i =0 ;i<n;i++) {
			if(str.charAt(i)=='(') {
				left.push(i);
			}
			else {
				leftlist.add(left.pop()+1);
				Rightlist.add(i+1);
			}
		}
		int n2 = leftlist.size();
		Integer[] left1 = new Integer[leftlist.size()];
		leftlist.toArray(left1);
		Arrays.sort(left1);
		for(int i = 0 ;i < left1.length ;i++) {
			for(int j = 0;j<left1.length;j++) {
				if(left1[i]==leftlist.get(j)) {
					System.out.println(left1[i] + " " + Rightlist.get(j));
				}
			}
		}
	}
}
